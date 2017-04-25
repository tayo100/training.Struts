/**
 * promisCRM.Struts Apr 8, 2010
 */
package org.iita.crm.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.iita.crm.model.Affiliation;
import org.iita.crm.model.Contact;
import org.iita.crm.model.Document;
import org.iita.crm.model.EmailContact;
import org.iita.crm.model.EntityDocument;
import org.iita.crm.model.EntityTag;
import org.iita.crm.model.Organization;
import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerCategory;
import org.iita.crm.model.PartnerClassification;
import org.iita.crm.model.PartnerCoreBusiness;
import org.iita.crm.model.PartnerCoreBusinessCategory;
import org.iita.crm.model.PartnerIITAHub;
import org.iita.crm.model.PartnerMandateCrop;
import org.iita.crm.model.PartnerPersonContact;
import org.iita.crm.model.PartnerPersonContact.Status;
import org.iita.crm.model.PartnerScale;
import org.iita.crm.model.PartnerSector;
import org.iita.crm.model.PartnerSubsector;
import org.iita.crm.model.Person;
import org.iita.crm.model.PersonMail;
import org.iita.crm.model.Tag;
import org.iita.crm.model.Taggable;
import org.iita.security.model.User;
import org.iita.service.SearchException;
import org.iita.trainingunit.announcements.model.TrainingProposal;
import org.iita.trainingunit.service.TrainingUnitDataException;
import org.iita.util.PagedResult;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;

/*
 * *
 * @author mobreza
 */
public class CoreCRMServiceImpl implements CoreCRMService {
	static final Log LOG = LogFactory.getLog(CoreCRMServiceImpl.class);
	static final String[] FIELDS = new String[] { "" };
	private File documentDirectory;
	// / Name of "this" organization
	private String organizationName = "IITA";
	// / The "this" organization
	protected Organization thisOrganization;

	protected EntityManager entityManager;

	/**
	 * 
	 */
	public CoreCRMServiceImpl() {
		super();
	}

	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		LOG.info("Setting 'This' organization to " + organizationName);
		this.organizationName = organizationName;
	}

	/**
	 * @param documentDirectory the documentDirectory to set
	 */
	public void setDocumentDirectory(String documentDirectory) {
		File directory = new File(documentDirectory);
		if (!directory.exists()) {
			LOG.error("Document directory does not exist: " + documentDirectory);
			return;
		}
		if (!directory.isDirectory()) {
			LOG.error("Is not directory: " + documentDirectory);
			return;
		}
		if (!directory.canRead()) {
			LOG.error("Can't read document directory: " + documentDirectory);
			return;
		}

		this.documentDirectory = directory;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Get Organization that is running the software.
	 * 
	 * @return <code>this</code> Organization
	 */
	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public synchronized Organization getThisOrganization() {
		if (this.thisOrganization != null)
			return this.thisOrganization;

		if (this.organizationName != null) {
			LOG.info("'This' organization is " + organizationName);
			List<Organization> orgs = this.entityManager.createQuery("from Organization o where o.shortName=:shortName").setParameter("shortName",
					this.organizationName).setMaxResults(2).getResultList();
			if (orgs != null && orgs.size() > 0) {
				this.thisOrganization = orgs.get(0);
				if (orgs.size() > 1) {
					LOG.warn("Found more than one organization with shortName '" + this.organizationName + "'. Using first one.");
				}
			}
		}

		return this.thisOrganization;
	}

	/**
	 * @see org.iita.crm.service.PersonService#loadPerson(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly=true)
	public Person loadPerson(Long id) {
		return this.entityManager.find(Person.class, id);
	}

	/**
	 * @see org.iita.crm.service.PersonService#update(org.iita.crm.model.Person)
	 */
	@Override
	@Transactional
	@Secured("ROLE_CRM")
	public void update(Person person) {
		if (person.getId() == null)
			this.entityManager.persist(person);
		else
			this.entityManager.merge(person);
	}

	/**
	 * @see org.iita.crm.service.PersonService#createPerson(java.lang.String)
	 */
	@Override
	@Transactional
	@Secured({"ROLE_CRM","ROLE_ADMIN"})
	public Person createPerson(String personName) {
		if (personName == null || personName.trim().length() == 0)
			return null;
		personName = personName.trim();
		String[] names = personName.split("\\s+");
		String lastName = null, firstName = null, otherNames = "";
		if (names.length == 0)
			return null;
		else if (names.length == 1) {
			lastName = names[0];
		} else if (names.length == 2 && names[0].endsWith(",")) {
			lastName = names[0].substring(0, names[0].length() - 1);
			firstName = names[1];
		} else if (names.length == 2) {
			lastName = names[1];
			firstName = names[0];
		} else {
			lastName = names[names.length - 1];
			firstName = names[0];
			for (int i = 1; i < names.length - 1; i++)
				otherNames += names[i] + " ";
			otherNames = otherNames.trim();
		}

		if (otherNames.length() == 0)
			otherNames = null;

		Person person = new Person();
		person.setLastName(lastName);
		person.setFirstName(firstName);
		person.setOtherNames(otherNames);

		this.entityManager.persist(person);
		return person;
	}
	
	/**
	 * @see org.iita.crm.service.PersonService#createPerson(java.lang.String)
	 */
	@Override
	@Transactional
	@Secured({"ROLE_CRM","ROLE_ADMIN"})
	public Person findPerson(String personName) {
	    int	i = 0;
		LOG.warn("Find Person: " + personName);
		String[] person = personName.split("\\s+");
		List<String> personList = new ArrayList<String>();
		for (i=0;i<person.length;i++)
			personList.add(person[i]);
		
		try{
			return (Person) this.entityManager.createQuery("from Person p where p.lastName in (:text) and p.firstName in (:text)")
		.setParameter("text", personList).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional
	@Secured({"ROLE_CRM","ROLE_ADMIN"})
	public void registerPerson(Person person) {
		this.entityManager.persist(person);
	}

	/**
	 * @throws SearchException
	 * @see org.iita.crm.service.PersonService#autocompletePerson(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Person> autocompletePerson(String text, int maxResults) throws SearchException {
		if (text == null || text.length() == 0)
			return null;
		text = "+" + text.replaceAll("\\s+", " +");
		return (List<Person>) autocomplete(Person.class, text, maxResults);
	}

	/**
	 * @see org.iita.crm.service.CoreCRMService#autocompleteUser(java.lang.String, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<User> autocompleteUser(String text, int maxRecords) {
		return this.entityManager.createQuery("select u from User u where u.lastName like :text or u.displayName like :text or u.firstName like :text")
				.setParameter("text", text + "%").setMaxResults(maxRecords).getResultList();
	}

	/**
	 * @throws SearchException
	 * @see org.iita.crm.service.PersonService#autocompletePerson(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Organization> autocompleteOrganization(String text, int maxResults) throws SearchException {
		if (text == null || text.length() == 0)
			return null;
		text = "+" + text.replaceAll("\\s+", " +");
		return (List<Organization>) autocomplete(Organization.class, text, maxResults);
	}
	
	/**
	 * @throws SearchException
	 * @see org.iita.crm.service.PersonService#autocompletePerson(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<TrainingProposal> lookupTrainingProposal(String text, int maxResults) throws SearchException {
		if (text == null || text.length() == 0)
			return null;
		text = "+" + text.replaceAll("\\s+", " +");
		return (List<TrainingProposal>) autocomplete(TrainingProposal.class, text, maxResults);
	}
	
	@SuppressWarnings("rawtypes")
	protected List<?> autocomplete(Class<?> clazz, String text, int maxResults) throws SearchException {
		FullTextEntityManager ftEm = Search.createFullTextEntityManager(this.entityManager);
		org.apache.lucene.search.Query luceneQuery = null;

		try {
			luceneQuery = getLuceneQuery(text + "*", FIELDS);
			org.hibernate.search.jpa.FullTextQuery query = ftEm.createFullTextQuery(luceneQuery, clazz);
			
			List searchResults = query.setMaxResults(maxResults).getResultList();
			LOG.info("Query \"" + text + "\" on " + clazz + " gives " + searchResults.size() + " hits");
			return searchResults;
		} catch (ParseException e) {
			throw new SearchException(e);
		}
	}

	/**
	 * @param searchQuery
	 * @return
	 * @throws ParseException
	 */
	private Query getLuceneQuery(String searchQuery, String[] fields) throws ParseException {
		MultiFieldQueryParser parser = new MultiFieldQueryParser(fields, new StandardAnalyzer());
		try {
			return parser.parse(searchQuery);
		} catch (ParseException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Contact> loadContacts(Person person) {
		return this.entityManager.createQuery("from Contact c where c.person=:person").setParameter("person", person).getResultList();
	}

	@Override
	@Transactional
	@Secured({"ROLE_CRM","ROLE_ADMIN"})
	public void updateContact(Contact contact) {
		if (contact.getId() == null) {
			this.entityManager.persist(contact);

			Person person = contact.getPerson();
			if (person != null) {
				person.setLastContact(contact);
				this.entityManager.merge(person);
			}
		} else {
			this.entityManager.merge(contact);
		}
	}

	/**
	 * @see org.iita.crm.service.ContactService#loadContact(java.lang.Long)
	 */
	@Override
	@Transactional
	public Contact loadContact(Long id) {
		return this.entityManager.find(Contact.class, id);
	}

	/**
	 * @see org.iita.crm.service.OrganizationService#loadOrganization(java.lang.Long)
	 */
	@Override
	@Transactional
	public Organization loadOrganization(Long id) {
		return this.entityManager.find(Organization.class, id);
	}

	/**
	 * @see org.iita.crm.service.OrganizationService#update(org.iita.crm.model.Organization)
	 */
	@Override
	@Transactional
	@Secured({"ROLE_CRM","ROLE_ADMIN"})
	public void update(Organization organization) {
		if (organization.getId() == null) {
			this.entityManager.persist(organization);
		} else {
			this.entityManager.merge(organization);
		}
	}

	/**
	 * @throws CRMException
	 * @see org.iita.crm.service.OrganizationService#delete(org.iita.crm.model.Organization)
	 */
	@Override
	@Transactional
	@Secured("ROLE_CRM")
	public void delete(Organization organization) {
		this.entityManager.remove(organization);
	}

	/**
	 * @see org.iita.crm.service.PersonService#delete(org.iita.crm.model.Person)
	 */
	@Override
	@Transactional
	@Secured("ROLE_CRM")
	public void delete(Person person) throws DataIntegrityViolationException {
		this.entityManager.remove(person);
	}

	/**
	 * @see org.iita.crm.service.OrganizationService#loadAffiliation(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly = true)
	public Affiliation loadAffiliation(Long id) {
		return this.entityManager.find(Affiliation.class, id);
	}

	/**
	 * @see org.iita.crm.service.OrganizationService#update(org.iita.crm.model.Affiliation)
	 */
	@Override
	@Transactional
	@Secured("ROLE_CRM")
	public void update(Affiliation affiliation) {
		if (affiliation.getId() == null) {
			if (affiliation.getStartDate() == null)
				affiliation.setStartDate(new Date());
			this.entityManager.persist(affiliation);
		} else {
			this.entityManager.merge(affiliation);
		}

		Person person = affiliation.getPerson();
		if (person != null && !affiliation.isExpired()) {
			person.setLastAffiliation(affiliation);
			this.entityManager.merge(person);
		}
	}

	/**
	 * @see org.iita.crm.service.OrganizationService#remove(org.iita.crm.model.Affiliation)
	 */
	@Override
	@Transactional
	@Secured("ROLE_CRM")
	public void remove(Affiliation affiliation) {
		Person person = affiliation.getPerson();
		if (person != null && person.getLastAffiliation() == affiliation) {
			person.setLastAffiliation(null);
			this.entityManager.merge(person);
		}
		this.entityManager.remove(affiliation);
	}

	/**
	 * @throws TrainingUnitDataException When organization cannot be registered (title null)
	 * @see org.iita.crm.service.OrganizationService#registerOrganization(java.lang.String)
	 */
	@Override
	@Transactional
	@Secured({"ROLE_CRM","ROLE_ADMIN"})
	public Organization registerOrganization(String title) throws CRMException {
		if (title == null || title.length() == 0)
			throw new CRMException("Organization title cannot be empty");
		Organization organization = new Organization();
		organization.setTitle(title);
		this.entityManager.persist(organization);
		return organization;
	}

	/**
	 * @see org.iita.trainingunit.service.TrainingUnitService#getLastUpdated(java.lang.Class, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public <T> List<T> getLastUpdated(Class<T> clazz, int maxRecords) {
		return this.entityManager.createQuery("from " + clazz.getName() + " order by lastUpdated desc").setMaxResults(maxRecords).getResultList();
	}

	@Override
	@Transactional
	@Secured("ROLE_CRM")
	public void removeContact(Contact contact) {
		Person person = contact.getPerson();
		if (person != null) {
			if (person.getLastAddress() == contact)
				person.setLastAddress(null);
			if (person.getLastEmail() == contact)
				person.setLastEmail(null);
			if (person.getLastPhone() == contact)
				person.setLastPhone(null);
		}

		this.entityManager.remove(contact);
	}

	/**
	 * @see org.iita.trainingunit.service.TrainingUnitService#find(java.lang.Class, java.lang.Long)
	 */
	@Override
	@Transactional(readOnly = true)
	@Secured( { "ROLE_APPLICANT", "ROLE_READALL", "BF_USERACCESS" })
	public <T> T find(Class<T> clazz, Long id) {
		return this.entityManager.find(clazz, id);
	}

	/**
	 * List entities by sample
	 * 
	 * @see org.iita.crm.service.CoreCRMService#list(java.lang.Object, int, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Secured( { "ROLE_READALL", "BF_USERACCESS" })
	public <T> java.util.List<T> list(T sample, int startAt, int maxResults) {
		if (sample == null)
			throw new NullPointerException("findOne needs a sample record.");

		Session session = (Session) this.entityManager.getDelegate();
		Criteria crit = session.createCriteria(sample.getClass());
		crit.add(Example.create(sample).excludeZeroes().enableLike());
		crit.setFirstResult(startAt).setMaxResults(maxResults);
		List<T> list = crit.list();
		if (list == null || list.size() == 0)
			return null;
		return list;
	}

	/**
	 * Load first entity matching sample
	 * 
	 * @see org.iita.crm.service.CoreCRMService#findOne(java.lang.Object)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> T findOne(T sample) {
		if (sample == null)
			throw new NullPointerException("findOne needs a sample record.");
		Session session = (Session) this.entityManager.getDelegate();
		Criteria crit = session.createCriteria(sample.getClass());
		crit.add(Example.create(sample).excludeZeroes().enableLike());
		crit.setMaxResults(2);
		List<T> list = crit.list();
		if (list == null || list.size() == 0)
			return null;
		if (list.size() > 1)
			LOG.warn("findOne found more than 1 matching object! Returning first one.");
		return list.get(0);
	}

	/**
	 * @see org.iita.crm.service.PersonService#getSimilarPersons(org.iita.crm.model.Person)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Person> getSimilarPersons(Person person, int maxResults) {
		LOG.info("Searching for persons simlar to " + person);
		if (person == null)
			return null;
		FullTextEntityManager ftEm = Search.createFullTextEntityManager(this.entityManager);
		MultiFieldQueryParser parser = new MultiFieldQueryParser(FIELDS, new StandardAnalyzer());
		try {
			org.apache.lucene.search.Query luceneQuery = parser.parse(createPersonQuery(person));
			org.hibernate.search.jpa.FullTextQuery query = ftEm.createFullTextQuery(luceneQuery, Person.class);
			List<Person> persons = query.setMaxResults(maxResults).getResultList();
			LOG.info("Got " + persons.size() + " similar persons");
			persons.remove(person);
			return persons;
		} catch (ParseException e) {
			LOG.error(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Organization> getSimilarOrganizations(Organization organization, int maxResults) {
		if (organization == null)
			return null;
		LOG.info("Searching for organizations simlar to " + organization);
		FullTextEntityManager ftEm = Search.createFullTextEntityManager(this.entityManager);
		MultiFieldQueryParser parser = new MultiFieldQueryParser(FIELDS, new StandardAnalyzer());
		try {
			org.apache.lucene.search.Query luceneQuery = parser.parse(createOrganizationQuery(organization));
			org.hibernate.search.jpa.FullTextQuery query = ftEm.createFullTextQuery(luceneQuery, Organization.class);
			List<Organization> organizations = query.setMaxResults(maxResults).getResultList();
			LOG.info("Got " + organizations.size() + " similar organizations");
			organizations.remove(organization);
			if (organization.getParent() != null)
				organizations.remove(organization.getParent());
			if (organization.getSubOrganizations() != null)
				for (Organization subOrganization : organization.getSubOrganizations())
					organizations.remove(subOrganization);

			return organizations;
		} catch (ParseException e) {
			LOG.error(e.getMessage());
			return null;
		}
	}

	/**
	 * @param person
	 * @return
	 */
	private String createPersonQuery(Person person) {
		StringBuffer sb = new StringBuffer();
		String[] tokens = person.getFullName().split("\\s+");
		for (String token : tokens) {
			token = token.replaceAll("[^\\w\\d]+", "");
			if (token.length() < 2)
				continue;
			if (token.startsWith("+"))
				continue;
			sb.append(token).append("~ ");
		}
		LOG.debug("Similar person query: " + sb.toString());
		return sb.toString();
	}

	private String createOrganizationQuery(Organization organization) {
		if (organization == null)
			return null;
		StringBuffer sb = new StringBuffer();
		if (organization.getTitle() != null) {
			String[] tokens = organization.getTitle().split("\\s+");
			for (String token : tokens) {
				token = token.replaceAll("[^\\w\\d]+", "");
				if (token.length() < 2)
					continue;
				if (token.startsWith("+"))
					continue;
				sb.append(token).append("~ ");
			}
		}
		LOG.debug("Similar organization query: " + sb.toString());
		return sb.toString();
	}
	
	private String createPartnerQuery(Partner partner) {
		if (partner == null)
			return null;
		StringBuffer sb = new StringBuffer();
		if (partner.getTitle() != null) {
			String[] tokens = partner.getTitle().split("\\s+");
			for (String token : tokens) {
				token = token.replaceAll("[^\\w\\d]+", "");
				if (token.length() < 2)
					continue;
				if (token.startsWith("+"))
					continue;
				sb.append(token).append("~ ");
			}
		}
		LOG.debug("Similar partner query: " + sb.toString());
		return sb.toString();
	}

	/**
	 * @see org.iita.crm.service.PersonService#listPersons(int, int)
	 */
	@Override
	@Transactional(readOnly = true)
	public PagedResult<Person> listPersons(int startAt, int maxResults) {
		PagedResult<Person> paged = new PagedResult<Person>(startAt, maxResults);
		paged.setResults(this.entityManager.createQuery("from Person p order by p.lastName, p.firstName").setFirstResult(startAt).setMaxResults(maxResults)
				.getResultList());
		if (paged.getResults().size() > 0)
			paged.setTotalHits(((Long) this.entityManager.createQuery("select count (p) from Person p").getSingleResult()).longValue());
		return paged;
	}

	/**
	 * @see org.iita.crm.service.DocumentService#load(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public Document load(String filePath) {
		try {
			Document document = (Document) this.entityManager.createQuery("from Document d where d.filePath=:filePath").setParameter("filePath", filePath)
					.getSingleResult();
			LOG.debug("Loaded document " + document.getTitle() + " of type " + document.getClass().getName());
			return document;
		} catch (NoResultException e) {
			LOG.warn("No document with path " + filePath);
			return null;
		}
	}

	/**
	 * @throws IOException
	 * @see org.iita.crm.service.DocumentService#getFile(org.iita.crm.model.Document)
	 */
	@Override
	public File getFile(Document document) throws IOException {
		LOG.info("Requesting file for document " + (document == null ? "null" : document.getTitle()));
		if (document == null)
			throw new IOException("No document entity provided");
		LOG.debug("Requesting file " + document.getFilePath());
		File documentFile = new File(this.documentDirectory, document.getFilePath());
		LOG.debug("Document file is " + documentFile.getPath());
		LOG.debug("Document exists? " + documentFile.exists());

		if (!documentFile.getParentFile().getAbsolutePath().startsWith(this.documentDirectory.getAbsolutePath())) {
			LOG.warn("Document file outside of document directory: " + documentFile.getAbsolutePath());
			throw new IOException("Document file outside of document directory");
		}
		if (!documentFile.exists()) {
			throw new FileNotFoundException(document.getFilePath() + " does not exist.");
		}
		return documentFile;
	}

	@Override
	@Transactional
	public Document upload(String title, String filePath, File file) throws IOException {
		Document document = new Document();
		document.setTitle(title);

		File destination = this.documentDirectory;
		if (filePath != null)
			destination = new File(this.documentDirectory, filePath);

		int num = 1;
		String fileName = filePath;
		String ext = "";
		int lastIndexOf = filePath.lastIndexOf('.');
		if (lastIndexOf >= 0) {
			fileName = filePath.substring(0, lastIndexOf);
			ext = filePath.substring(lastIndexOf, filePath.length());
		}
		File parentFile = destination.getParentFile();
		if (!parentFile.getAbsolutePath().startsWith(this.documentDirectory.getCanonicalPath())) {
			LOG.warn("Destination file outside of document directory: " + parentFile.getAbsolutePath());
			throw new IOException("Destination file outside of document directory");
		}

		if (!parentFile.exists()) {
			LOG.info("Creating directories: " + parentFile.getAbsolutePath());
			parentFile.mkdirs();
		}
		while (destination.exists()) {
			destination = new File(this.documentDirectory, String.format("%1$s (%3$d)%2$s", fileName, ext, num++));
			LOG.debug("Checking alternative filename: " + destination.getName());
		}
		document.setFilePath(destination.getAbsolutePath().substring(this.documentDirectory.getAbsolutePath().length()));
		LOG.info("Moving document to: " + destination.getAbsolutePath());
		FileUtils.copyFile(file, destination);
		if (destination.length() != file.length())
			throw new IOException("File could not be copied to destination!");

		document.setFile(destination.getAbsolutePath());

		this.entityManager.persist(document);
		return document;
	}

	/**
	 * @see org.iita.crm.service.TagService#loadTag(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly = true)
	public Tag loadTag(Class<? extends Tag> clazz, Long id) {
		return this.entityManager.find(clazz, id);
	}

	/**
	 * @see org.iita.crm.service.CoreCRMServiceImpl#autocompleteTag(java.lang.String, int)
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@Transactional(readOnly = true)
	public List<String> autocompleteTag(String text, int i) {
		if (text == null || text.length() == 0)
			return null;
		text = text.trim();
		LOG.debug("Listing tags matching: " + text);
		
		List list = this.entityManager.createQuery("select distinct t.tag from Tag t where t.tag like :text order by t.tag").setMaxResults(i).setParameter(
				"text", text + "%").getResultList();
		LOG.debug("Got " + list.size() + " matching tags");
		return list;
	}

	/**
	 * @see org.iita.crm.service.TagService#list(java.lang.String, int, int)
	 */
	@Override
	@Transactional(readOnly = true)
	public PagedResult<? extends Tag> list(String tag, int startAt, int maxResults) {
		LOG.info("Listing everything with tag: " + tag);
		PagedResult<? extends Tag> paged = new PagedResult<Tag>(startAt, maxResults);
		paged.setResults(this.entityManager.createQuery("from Tag t where t.tag=:tag order by t.tag").setParameter("tag", tag).setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		if (paged.getResults().size() > 0)
			paged
					.setTotalHits(((Long) this.entityManager.createQuery("select count(t) from Tag t where t.tag=:tag").setParameter("tag", tag)
							.getSingleResult()).longValue());
		
		//LOG.info("Listing everything with tag Lastly: " + tag + " COUNT paged: " + paged.getTotalHits());
		return paged;
	}

	/**
	 * @see org.iita.crm.service.TagService#getCloud()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public TagCloud getCloud(int size) {
		List<Object[]> usedTags = this.entityManager.createQuery("select t.tag, count(t) from Tag t group by t.tag order by count(t) desc").setMaxResults(size)
				.getResultList();
		TagCloud cloud = new TagCloud();
		for (Object[] o : usedTags) {
			cloud.add((String) o[0], (Long) o[1]);
		}

		return cloud.prepare();
	}

	/**
	 * @see org.iita.crm.service.TagService#update(org.iita.crm.model.Tag)
	 */
	@Override
	@Transactional
	@Secured({"ROLE_CRM","ROLE_ADMIN", "ROLE_PARTNERADMIN"})
	public void update(Tag tag) {
		if (tag.getId() == null)
			this.entityManager.persist(tag);
		else
			this.entityManager.merge(tag);
	}

	/**
	 * @see org.iita.crm.service.TagService#removeTag(org.iita.crm.model.Tag)
	 */
	@Override
	@Transactional
	@Secured({"ROLE_CRM", "ROLE_PARTNERADMIN"})
	public void remove(Tag tag) {
		this.entityManager.remove(tag);
	}

	/**
	 * @see org.iita.crm.service.TagService#getTagCategories(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public <T> List<String> getTagCategories(Class<T> clazz) {
		List<String> tags = this.entityManager.createQuery("select distinct(t.tag) from " + clazz.getName() + " t where t.tag like '%:%'").getResultList();
		List<String> categories = new ArrayList<String>();
		for (String tag : tags) {
			String category = tag.substring(0, tag.lastIndexOf(':'));
			if (!categories.contains(category))
				categories.add(category);
		}
		Collections.sort(categories);
		return categories;
	}

	/**
	 * @see org.iita.crm.service.TagService#getTagsForCategory(java.lang.Class, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public <T> List<String> getTagsForCategory(Class<T> clazz, String category) {
		List<String> tags = this.entityManager.createQuery("select distinct(t.tag) from " + clazz.getName() + " t where t.tag like :category order by t.tag")
				.setParameter("category", category + ":%").getResultList();
		return tags;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<String> getTagsInCategory(Taggable<?> entity, String category) {
		return this.entityManager.createQuery("select t.tag from " + entity.getClass().getName() + " e join e.tags t where e=:entity and t.tag like :category").setParameter("entity", entity).setParameter("category", String.format("%1$s:%%", category)).getResultList();
	}

	@Secured( { "ROLE_CGO", "ROLE_CRM", "ROLE_PARTNERADMIN" })
	@Override
	@Transactional
	public <T extends Taggable<T>> void bulkUpdateTags(T taggableEntity, java.util.List<String> usedTags, java.util.Map<String, Double> tagValues) {
		List<? extends EntityTag<T>> existingTags = taggableEntity.getTags();
		for (String usedTag : usedTags) {
			Double tagValue = tagValues.get(usedTag);
			LOG.debug("Using tag: " + usedTag + " with value=" + tagValue);

			boolean found = false;
			// update existing tag
			for (EntityTag<T> existingTag : existingTags) {
				if (existingTag.getTag().equals(usedTag)) {
					found = true;
					LOG.debug("Found existing tag: " + existingTag);
					existingTag.setPercentage(tagValue);
					this.entityManager.merge(existingTag);
					break;
				}
			}
			// create new tag
			if (!found) {
				LOG.info("Creating new tag: " + usedTag + " with value " + tagValue);
				EntityTag<T> newTag = taggableEntity.createTag();
				newTag.setTag(usedTag);
				newTag.setEntity(taggableEntity);
				newTag.setPercentage(tagValue);
				this.entityManager.persist(newTag);
			}
		}

		// remove unused tags
		for (int i = existingTags.size() - 1; i >= 0; i--) {
			if (!usedTags.contains(existingTags.get(i).getTag())) {
				LOG.info("Removing unused tag: " + existingTags.get(i));
				this.entityManager.remove(existingTags.remove(i));
			}
		}
	}

	/**
	 * @see org.iita.crm.service.CoreCRMService#listPersonMail(org.iita.crm.model.Person, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public PagedResult<PersonMail> listPersonMail(Person person, int startAt, int maxRecords) {
		LOG.info("Listing emails for person " + person);
		PagedResult<PersonMail> paged = new PagedResult<PersonMail>(startAt, maxRecords);
		paged.setResults((List<PersonMail>) this.entityManager.createQuery("from PersonMail pm where pm.person=:person order by pm.message.createdDate desc")
				.setParameter("person", person).setFirstResult(startAt).setMaxResults(maxRecords).getResultList());
		if (paged.getResults().size() > 0)
			paged.setTotalHits(((Long) this.entityManager.createQuery("select count(pm) from PersonMail pm where pm.person=:person").setParameter("person",
					person).getSingleResult()).longValue());
		return paged;
	}

	/**
	 * @param left
	 * @param right
	 */
	protected Person mergePerson(Person left, Person right) {
		if (left.getUser() == null)
			left.setUser(right.getUser());

		this.entityManager.createQuery("update Affiliation a set a.person=:left where a.person=:right").setParameter("left", left).setParameter("right", right)
				.executeUpdate();
		this.entityManager.createQuery("update Contact c set c.person=:left where c.person=:right").setParameter("left", left).setParameter("right", right)
				.executeUpdate();

		this.entityManager.createQuery("update PersonMail pm set pm.person=:left where pm.person=:right").setParameter("left", left).setParameter("right",
				right).executeUpdate();

		return left;
	}

	/**
	 * @param left
	 * @param right
	 */
	protected Organization mergeOrganization(Organization left, Organization right) {
		this.entityManager.createQuery("update Affiliation a set a.organization=:left where a.organization=:right").setParameter("left", left).setParameter(
				"right", right).executeUpdate();

		this.entityManager.createQuery("update Contact c set c.organization=:left where c.organization=:right").setParameter("left", left).setParameter(
				"right", right).executeUpdate();

		this.entityManager.createQuery("update Organization o set o.parent=:left where o.parent=:right").setParameter("left", left)
				.setParameter("right", right).executeUpdate();

		this.entityManager.createQuery("update OrganizationDocument od set od.entity=:left where od.entity=:right").setParameter("left", left).setParameter(
				"right", right).executeUpdate();

		return left;
	}

	/**
	 * @see org.iita.crm.service.DocumentService#findDocument(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly = true)
	public Document findDocument(Long id) {
		return this.entityManager.find(Document.class, id);
	}

	/**
	 * @see org.iita.crm.service.DocumentService#remove(org.iita.crm.model.Document)
	 */
	@Override
	@Transactional
	@Secured({"ROLE_APPLICANT", "ROLE_CGO","ROLE_ADMIN", "ROLE_PARTNERADMIN"})
	public void remove(Document document) {
		this.entityManager.remove(document);
	}

	/**
	 * @see org.iita.crm.service.DocumentService#update(org.iita.crm.model.Document)
	 */
	@Override
	@Transactional
	@Secured({"ROLE_APPLICANT", "ROLE_CGO","ROLE_ADMIN", "ROLE_PARTNERADMIN"})
	public void update(Document document) {
		if (document.getId() == null) {
			this.entityManager.persist(document);
		} else {
			this.entityManager.merge(document);
		}
	}

	/**
	 * @see org.iita.crm.service.OrganizationService#listAffiliations(org.iita.crm.model.Organization, int, int)
	 */
	@Override
	@Transactional
	public PagedResult<Affiliation> listAffiliations(Organization organization, int startAt, int maxResults) {
		PagedResult<Affiliation> paged = new PagedResult<Affiliation>(startAt, maxResults);
		paged.setResults(this.entityManager.createQuery("select a from Affiliation a where a.organization=:organization or a.organization.parent=:organization order by a.person.lastName, a.person.firstName").setParameter("organization",
				organization).setFirstResult(startAt).setMaxResults(maxResults).getResultList());
		if (paged.getResults().size() > 0)
			paged.setTotalHits((Long) this.entityManager.createQuery("select count(a) from Affiliation a where a.organization=:organization or a.organization.parent=:organization").setParameter(
					"organization", organization).getSingleResult());
		return paged;
	}

	/**
	 * @see org.iita.crm.service.DocumentService#upload(org.iita.crm.model.EntityDocument, java.lang.String, java.io.File)
	 */
	@Override
	@Transactional
	public <T> void upload(EntityDocument<T> entityDocument, String fileName, File file) throws IOException {
		LOG.info("Attaching document as " + entityDocument.getClass().getSimpleName() + ": " + fileName);		
		Document document = upload(fileName, entityDocument.getEntity().getClass().getSimpleName() + File.separator + fileName, file);
		entityDocument.setDocument(document);
		this.entityManager.persist(entityDocument);
	}

	/**
	 * @see org.iita.crm.service.DocumentService#remove(org.iita.crm.model.EntityDocument)
	 */
	@Override
	@Transactional
	public <T> void remove(EntityDocument<T> entityDocument) {
		if (entityDocument.getDocument().getFile() != null) {
			File file = new File(entityDocument.getDocument().getFile());
			if (file.exists()) {
				LOG.warn("Deleting file " + file + " for entity document.");
				file.delete();
			}
		}
		this.entityManager.remove(entityDocument);
	}

	/**
	 * @see org.iita.crm.service.PersonService#findOrCreatePerson(org.iita.security.model.User)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Person findOrCreatePerson(User user) {
		List<Person> persons = this.entityManager.createQuery("select p from Person p where p.user=:user").setParameter("user", user).setMaxResults(2)
				.getResultList();
		if (persons == null || persons.size() == 0) {
			// check if there's existing person in the system or create one
			return findExistingPersonOrCreate(user);
		}
		if (persons.size() > 1) {
			LOG.warn("Non-unique Person for " + user);
		}
		return persons.get(0);
	}

	/**
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Person findExistingPersonOrCreate(User user) {
		// search existing Persons by email
		String mail = user.getMail();
		if (mail != null) {
			List<Person> persons = this.entityManager.createQuery("select c.person from EmailContact c where c.email=:mail").setParameter("mail", mail)
					.getResultList();
			if (persons != null && persons.size() == 1) {
				LOG.info("Found one matching person by email: " + mail);
				Person person = persons.get(0);
				person.setUser(user);
				this.entityManager.persist(person);
				return person;
			} else {
				LOG.warn("Could not find unique person matching email " + mail + ".");
			}
		}

		List<Person> persons = this.entityManager.createQuery("select p from Person p where p.lastName=:lastName and p.firstName=:firstName").setParameter(
				"lastName", user.getLastName()).setParameter("firstName", user.getFirstName()).setMaxResults(2).getResultList();
		if (persons != null && persons.size() == 1) {
			LOG.info("found one matching person by lastName and firstName: " + user.getFullName());
			Person person = persons.get(0);
			person.setUser(user);
			this.entityManager.persist(person);
			return person;
		} else {
			LOG.warn("Could not find unique person matching lastName " + user.getLastName() + " and firstName " + user.getFirstName() + ".");
		}

		persons = this.entityManager.createQuery("select p from Person p where p.lastName=:lastName").setParameter("lastName",
				user.getLastName() + ", " + user.getFirstName()).setMaxResults(2).getResultList();
		if (persons != null && persons.size() == 1) {
			LOG.info("found one matching person by lastName + firstName: " + user.getFullName());
			Person person = persons.get(0);
			person.setUser(user);
			this.entityManager.persist(person);
			return person;
		} else {
			LOG.warn("Could not find unique person matching lastName '" + user.getLastName() + ", " + user.getFirstName() + "'.");
		}

		// could not find, create new person from user
		return createPersonFromUser(user);
	}

	/**
	 * Create new Person record for logged-in user
	 * 
	 * @param user
	 * @return
	 */
	private Person createPersonFromUser(User user) {
		Person person = new Person();
		person.setUser(user);
		person.setLastName(user.getLastName());
		person.setFirstName(user.getFirstName());
		this.entityManager.persist(person);

		// affiliate with thisOrganization
		Organization thisOrg = getThisOrganization();
		if (thisOrg != null) {
			Affiliation affiliation = new Affiliation();
			affiliation.setPerson(person);
			affiliation.setOrganization(thisOrg);
			affiliation.setDepartment(user.getDepartment());
			affiliation.setJobTitle(user.getDescription());
			this.update(affiliation);
		}

		// email
		String mail = user.getMail();
		if (mail != null && mail.trim().length() > 0) {
			EmailContact emailContact = new EmailContact();
			emailContact.setPerson(person);
			emailContact.setEmail(mail);
			this.updateContact(emailContact);
		}

		return person;
	}

	@Override
	public Partner loadPartner(Long id) {
		return this.entityManager.find(Partner.class, id);
	}

	@Override
	@Transactional
	public void update(Partner partner) {
		if (partner.getId() == null) {
			this.entityManager.persist(partner);
		} else {
			this.entityManager.merge(partner);
		}
	}

	@Override
	@Transactional
	public void update(PartnerPersonContact partnerContact) {
		if (partnerContact.getId() == null) {
			if (partnerContact.getStatus() == null)
				partnerContact.setStatus(Status.ACTIVE);
			this.entityManager.persist(partnerContact);
		} else {
			this.entityManager.merge(partnerContact);
		}
	}

	@Override
	@Secured({"ROLE_ADMIN","ROLE_PARTNERADMIN"})
	@Transactional
	public void remove(PartnerPersonContact partnerContact) {
		this.entityManager.remove(partnerContact);
	}

	@Override
	public PartnerPersonContact loadPartnerContact(Long id) {
		return this.entityManager.find(PartnerPersonContact.class, id);
	}

	@Override
	@Secured({"ROLE_ADMIN","ROLE_PARTNERADMIN"})
	@Transactional
	public void delete(Partner partner) throws DataIntegrityViolationException {
		this.entityManager.remove(partner);
	}

	@Override
	@Transactional
	public Partner registerPartner(String title) throws CRMException {
		if (title == null || title.length() == 0)
			throw new CRMException("Partner title cannot be empty");
		Partner partner = new Partner();
		partner.setTitle(title);
		this.entityManager.persist(partner);
		return partner;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Partner> autocompletePartner(String text, int maxResults) throws SearchException {
		if (text == null || text.length() == 0)
			return null;
		text = "+" + text.replaceAll("\\s+", " +");
		return (List<Partner>) autocomplete(Partner.class, text, maxResults);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Partner> getSimilarPartners(Partner partner, int maxResults) {
		if (partner == null)
			return null;
		LOG.info("Searching for partners simlar to " + partner);
		FullTextEntityManager ftEm = Search.createFullTextEntityManager(this.entityManager);
		MultiFieldQueryParser parser = new MultiFieldQueryParser(FIELDS, new StandardAnalyzer());
		try {
			org.apache.lucene.search.Query luceneQuery = parser.parse(createPartnerQuery(partner));
			org.hibernate.search.jpa.FullTextQuery query = ftEm.createFullTextQuery(luceneQuery, Partner.class);
			
			List<Partner> partners = query.setMaxResults(maxResults).getResultList();
			LOG.info("Got " + partners.size() + " similar partners");
			partners.remove(partner);
			if (partner.getParent() != null)
				partners.remove(partner.getParent());
			if (partner.getSubPartners() != null)
				for (Partner subPartner : partner.getSubPartners())
					partners.remove(subPartner);

			return partners;
		} catch (ParseException e) {
			LOG.error(e.getMessage());
			return null;
		}
	}

	@Override
	public PagedResult<PartnerPersonContact> listPartnerContacts(Partner partner, int startAt, int maxResults) {
		//LOG.info("Associates of partner organization: " + partner);
		PagedResult<PartnerPersonContact> paged = new PagedResult<PartnerPersonContact>(startAt, maxResults);
		paged.setResults(this.entityManager.createQuery("select pc from PartnerPersonContact pc where pc.partner=:partner or pc.partner.parent=:partner order by pc.partner.title, pc.partner.shortName").setParameter("partner",
				partner).setFirstResult(startAt).setMaxResults(maxResults).getResultList());
		if (paged.getResults().size() > 0)
			paged.setTotalHits((Long) this.entityManager.createQuery("select count(pc) from PartnerPersonContact pc where pc.partner=:partner or pc.partner.parent=:partner").setParameter(
					"partner", partner).getSingleResult());
		//LOG.info("PAGED COUNT: " + paged.getTotalHits());
		return paged;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PartnerClassification> loadClassifications(Partner partner) {
		return this.entityManager.createQuery("from PartnerClassification c where c.partner=:partner").setParameter("partner", partner).getResultList();
	}

	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN","ROLE_ADMIN"})
	public void updateClassification(PartnerClassification classification) {
		//LOG.info("CLASSIFICATION ID: " + classification.getId());
		if (classification.getId() == null) {
			this.entityManager.persist(classification);
		} else {
			this.entityManager.merge(classification);
		}
	}

	/**
	 * @see org.iita.crm.service.PartnerService#loadClassification(java.lang.Long)
	 */
	@Override
	@Transactional
	public PartnerClassification loadClassification(Long id) {
		return this.entityManager.find(PartnerClassification.class, id);
	}
	
	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public void removeClassification(PartnerClassification classification) {
		this.entityManager.remove(classification);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PartnerCategory> loadCategories(Partner partner) {
		return this.entityManager.createQuery("from PartnerCategory c where c.partner=:partner").setParameter("partner", partner).getResultList();
	}

	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN","ROLE_ADMIN"})
	public void updateCategory(PartnerCategory category) {
		//LOG.info("CATEGORY ID: " + category.getId());
		if (category.getId() == null) {
			this.entityManager.persist(category);
		} else {
			this.entityManager.merge(category);
		}
	}

	/**
	 * @see org.iita.crm.service.PartnerService#loadCategory(java.lang.Long)
	 */
	@Override
	@Transactional
	public PartnerCategory loadCategory(Long id) {
		return this.entityManager.find(PartnerCategory.class, id);
	}
	
	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public void removeCategory(PartnerCategory category) {
		this.entityManager.remove(category);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PartnerCoreBusiness> loadCoreBusinesses(Partner partner) {
		return this.entityManager.createQuery("from PartnerCoreBusiness c where c.partner=:partner").setParameter("partner", partner).getResultList();
	}

	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN","ROLE_ADMIN"})
	public void updateCoreBusiness(PartnerCoreBusiness coreBusiness) {
		//LOG.info("COREBUSINESS ID: " + coreBusiness.getId());
		if (coreBusiness.getId() == null) {
			this.entityManager.persist(coreBusiness);
		} else {
			this.entityManager.merge(coreBusiness);
		}
	}

	/**
	 * @see org.iita.crm.service.PartnerService#loadCoreBusinesses(java.lang.Long)
	 */
	@Override
	@Transactional
	public PartnerCoreBusiness loadCoreBusiness(Long id) {
		return this.entityManager.find(PartnerCoreBusiness.class, id);
	}
	
	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public void removeCoreBusiness(PartnerCoreBusiness coreBusiness) {
		this.entityManager.remove(coreBusiness);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PartnerMandateCrop> loadMandateCrops(Partner partner) {
		return this.entityManager.createQuery("from PartnerMandateCrop c where c.partner=:partner").setParameter("partner", partner).getResultList();
	}

	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN","ROLE_ADMIN"})
	public void updateMandateCrop(PartnerMandateCrop mandateCrop) {
		//LOG.info("MANDATECROP ID: " + mandateCrop.getId());
		if (mandateCrop.getId() == null) {
			this.entityManager.persist(mandateCrop);
		} else {
			this.entityManager.merge(mandateCrop);
		}
	}

	/**
	 * @see org.iita.crm.service.PartnerService#loadMandateCrops(java.lang.Long)
	 */
	@Override
	@Transactional
	public PartnerMandateCrop loadMandateCrop(Long id) {
		return this.entityManager.find(PartnerMandateCrop.class, id);
	}
	
	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public void removeMandateCrop(PartnerMandateCrop mandateCrop) {
		this.entityManager.remove(mandateCrop);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PartnerIITAHub> loadIitahubs(Partner partner) {
		return this.entityManager.createQuery("from PartnerIITAHub c where c.partner=:partner").setParameter("partner", partner).getResultList();
	}

	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN","ROLE_ADMIN"})
	public void updateIitahub(PartnerIITAHub iitahub) {
		//LOG.info("MANDATECROP ID: " + mandateCrop.getId());
		if (iitahub.getId() == null) {
			this.entityManager.persist(iitahub);
		} else {
			this.entityManager.merge(iitahub);
		}
	}

	/**
	 * @see org.iita.crm.service.PartnerService#loadIitahub(java.lang.Long)
	 */
	@Override
	@Transactional
	public PartnerIITAHub loadIitahub(Long id) {
		return this.entityManager.find(PartnerIITAHub.class, id);
	}
	
	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public void removeIitahub(PartnerIITAHub iitahub) {
		this.entityManager.remove(iitahub);
	}

	
	@Override
	@Transactional(readOnly = true)
	public PartnerSector loadSector(Long id) {
		return this.entityManager.find(PartnerSector.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public List<PartnerSector> loadSectors(Partner partner) {
		return this.entityManager.createQuery("from PartnerSector s where s.partner=:partner").setParameter("partner", partner).getResultList();
	}

	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public void updateSector(PartnerSector sector) {
		if (sector.getId() == null) {
			this.entityManager.persist(sector);
		} else {
			this.entityManager.merge(sector);
		}
	}

	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public void removeSector(PartnerSector sector) {
		this.entityManager.remove(sector);
	}

	
	
	@Override
	@Transactional(readOnly = true)
	public PartnerSubsector loadSubsector(Long id) {
		return this.entityManager.find(PartnerSubsector.class, id);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public List<PartnerSubsector> loadSubsectors(Partner partner) {
		return this.entityManager.createQuery("from PartnerSubsector s where s.partner=:partner").setParameter("partner", partner).getResultList();
	}

	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public void removeSubsector(PartnerSubsector subsector) {
		this.entityManager.remove(subsector);
	}
	
	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public void updateSubsector(PartnerSubsector subsector) {
		if (subsector.getId() == null) {
			this.entityManager.persist(subsector);
		} else {
			this.entityManager.merge(subsector);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public List<PartnerScale> loadScales(Partner partner) {
		return this.entityManager.createQuery("from PartnerScale s where s.partner=:partner").setParameter("partner", partner).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public PartnerScale loadScale(Long id) {
		return this.entityManager.find(PartnerScale.class, id);
	}

	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public void updateScale(PartnerScale scale) {
		if (scale.getId() == null) {
			this.entityManager.persist(scale);
		} else {
			this.entityManager.merge(scale);
		}
	}

	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public void removeScale(PartnerScale scale) {
		this.entityManager.remove(scale);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public List<PartnerCoreBusinessCategory> loadCoreBusinessCategories(Partner partner) {
		return this.entityManager.createQuery("from PartnerCoreBusinessCategory s where s.partner=:partner").setParameter("partner", partner).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public PartnerCoreBusinessCategory loadCoreBusinessCategory(Long id) {
		return this.entityManager.find(PartnerCoreBusinessCategory.class, id);
	}

	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public void updateCoreBusinessCategory(PartnerCoreBusinessCategory coreBusinessCategory) {
		if (coreBusinessCategory.getId() == null) {
			this.entityManager.persist(coreBusinessCategory);
		} else {
			this.entityManager.merge(coreBusinessCategory);
		}
	}

	@Override
	@Transactional
	@Secured({"ROLE_PARTNERADMIN", "ROLE_ADMIN"})
	public void removeCoreBusinessCategory(PartnerCoreBusinessCategory coreBusinessCategory) {
		this.entityManager.remove(coreBusinessCategory);
	}
}