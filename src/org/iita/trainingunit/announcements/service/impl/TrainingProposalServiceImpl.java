package org.iita.trainingunit.announcements.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.crm.model.ActionLog;
import org.iita.crm.model.ActionLog.ActionType;
import org.iita.crm.model.AnnouncementDocument;
import org.iita.crm.model.Document;
import org.iita.crm.model.EmailContact;
import org.iita.crm.model.Person;
import org.iita.crm.model.TrainingProposalDocument;
import org.iita.security.model.User;
import org.iita.service.EmailService;
import org.iita.service.TemplatingException;
import org.iita.service.TemplatingService;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.model.TrainingLocation;
import org.iita.trainingunit.announcements.model.TrainingProposal;
import org.iita.trainingunit.announcements.model.TrainingProposal.STATUS;
import org.iita.trainingunit.announcements.service.TrainingProposalException;
import org.iita.trainingunit.announcements.service.TrainingProposalService;
import org.iita.trainingunit.model.Trainer;
import org.iita.util.PagedResult;
import org.iita.util.StringUtil;
import org.springframework.security.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;

public class TrainingProposalServiceImpl implements TrainingProposalService {
	private static final Log LOG = LogFactory.getLog(TrainingProposalServiceImpl.class);
	static final String[] FIELDS = new String[] { "" };
	private EntityManager entityManager;
	private EmailService emailService;
	private TemplatingService templatingService;
	final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
	final java.util.Random rand = new java.util.Random();
	final Set<String> identifiers = new HashSet<String>();

	/**
	 * @param templatingService the templatingService to set
	 */
	public void setTemplatingService(TemplatingService templatingService) {
		this.templatingService = templatingService;
	}
	
	/**
	 * @param emailService the emailService to set
	 */
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	
	/**
	 * @see org.iita.service.impl.SimpleDaoServiceImpl#setEntityManager(javax.persistence.EntityManager)
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional(readOnly = false)
	public TrainingProposal createNew(User owner) throws TrainingProposalException {
		LOG.info("Creating new TrainingProposal for " + owner);
		TrainingProposal tp = new TrainingProposal();
		tp.setStatus(STATUS.DRAFT);
		tp.setTitle("Yet to be specified");
		tp.setOwner(owner);
		tp.setTrainingFee(0.0d);
		this.entityManager.persist(tp);
		return tp;
	}

	@Override
	@Transactional
	public void save(TrainingProposal trainingProposal){//, List<Trainer> trainers, List<TrainingLocation> locations) {//throws TrainingProposalException {
		cleanupTrainer(trainingProposal);//, trainers);		
		cleanupLocation(trainingProposal);//, locations);
		
		if (trainingProposal.getId() == null) {
			this.entityManager.persist(trainingProposal);
		} else {
			this.entityManager.merge(trainingProposal);
		}
		
		for(Trainer tr: trainingProposal.getTrainers()){
			if(tr!=null){
				if(tr.getEmail()!=null && tr.getPerson()==null){
					//Create Find/Person and assign
					Person p = null;
					p = findExistingPerson(tr.getEmail());
					
					if(p==null)
						p = createPerson(tr.getNames());
					
					tr.setPerson(p);
					
					//Create Email Contact and assign
					EmailContact ec = new EmailContact();
					ec.setEmail(tr.getEmail());
					ec.setPerson(p);
					this.entityManager.persist(ec);
				}
			}
		}
		
		if(trainingProposal.getStatus()==STATUS.SUBMITTED){
			//SEND NOTIFICATION/ALERT TO TRAINING UNIT
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("trainingproposal", trainingProposal);
			try {
				String recipient;
				recipient="IITA-TrainingUnit@cgiar.org";
				
				String body = templatingService.fillTemplate("trainingproposal", data);
				try {
					this.emailService.sendEmail("software@iita.org", new String[] { recipient }, null, "Training Proposal submission notification", null, body);
				} catch (Exception e) {
					LOG.error(e);
				}
			} catch (TemplatingException e) {
				LOG.error(e);
			}
		}
			
	}

	@Override
	@Transactional
	public void delete(TrainingProposal trainingProposal) {
		this.entityManager.remove(trainingProposal);
	}

	@Override
	public PagedResult<TrainingProposal> list(int startAt, int maxResults) {
		LOG.info("Got here: ");
		LOG.info(new TrainingProposal());
		PagedResult<TrainingProposal> paged = new PagedResult<TrainingProposal>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);

		paged.setResults(this.entityManager.createQuery("from TrainingProposal t " + "order by t.createdDate desc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(t) from TrainingProposal t").getSingleResult());

		return paged;
	}
	
	@Override
	public PagedResult<TrainingProposal> list(int startAt, int maxResults, User user) {
		LOG.info("Got here: ");
		LOG.info(new TrainingProposal());
		PagedResult<TrainingProposal> paged = new PagedResult<TrainingProposal>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);

		paged.setResults(this.entityManager.createQuery("from TrainingProposal t where t.owner=:user order by t.createdDate desc")
				.setFirstResult(startAt)
				.setMaxResults(maxResults)
				.setParameter("user",user)
				.getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(t) from TrainingProposal t where t.owner=:user").setParameter("user",user).getSingleResult());

		return paged;
	}

	@Override
	@Transactional(readOnly = true)
	@Secured( { "ROLE_TRAININGUNITHEAD", "ROLE_CRM", "BF_USERACCESS" })
	public TrainingProposal find(Long id) {
		TrainingProposal trainingProposal = this.entityManager.find(TrainingProposal.class, id);
		return trainingProposal;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<TrainingProposal> list() {
		return this.entityManager.createQuery("from TrainingProposal a " +
		"where (a.deadline>=now() or a.deadline is null) order by a.createdDate desc").getResultList();
	}
	
	/**
	 * 
	 */
	@Transactional
	public void cleanupTrainer(TrainingProposal trainingProposal){//, List<Trainer> trainers) {
		if(trainingProposal!=null){
			// cleanup  Constraints
			if(trainingProposal.getTrainers()!=null){
				for (int i = trainingProposal.getTrainers().size() - 1; i >= 0; i--) {
					Trainer c = trainingProposal.getTrainers().get(i);
					if(c!=null){
						
						if (c.getNames().isEmpty()) {
							//LOG.debug("Removing " + c);
							ensureRemoved(trainingProposal.getTrainers().remove(i));
						} else{
							//LOG.info("NAME " + i + ": " + c.getNames());
							c.setTrainingProposal(trainingProposal);
						}
					}
				}
			}
		}
	}
	
	/**
	 * 
	 */
	@Transactional
	public void cleanupLocation(TrainingProposal trainingProposal){//, List<TrainingLocation> locations) {
		if(trainingProposal!=null){
			// cleanup  Training Locations
			if(trainingProposal.getTrainingLocations()!=null){
				for (int i = trainingProposal.getTrainingLocations().size() - 1; i >= 0; i--) {
					TrainingLocation tl = trainingProposal.getTrainingLocations().get(i);
					if(tl!=null){
						if (tl.getVenue().isEmpty()) {
							//LOG.debug("Removing " + tl);
							ensureRemoved(trainingProposal.getTrainingLocations().remove(i));
						} else{
							//LOG.info("VENUE " + i + ": " + tl.getVenue());
							tl.setTrainingProposal(trainingProposal);
						}
					}
				}
			}
		}
	}
	
	/**
	 * Utility method checks if object is in session and deletes from persistent storage
	 * 
	 * @param objectToRemove
	 */
	@Transactional(readOnly = false)
	private void ensureRemoved(Object objectToRemove) {
		// if (this.entityManager.contains(objectToRemove))
		if (objectToRemove != null) {
			LOG.debug("EM removing " + objectToRemove);
			this.entityManager.remove(objectToRemove);
		}
	}
	
	/**
	 * @param budgetCode
	 * @param user
	 * @param comment
	 * @param action
	 * @param comment2
	 */
	private void addActionLog(TrainingProposal ta, User user, ActionType action, String comment) {
		ActionLog actionLog = createActionLog(ta, user, action, comment);
		this.entityManager.persist(actionLog);
	}

	public static ActionLog createActionLog(TrainingProposal tp, User user, ActionType action, String comment) {
		ActionLog actionLog = new ActionLog();
		actionLog.setTrainingProposal(tp);
		actionLog.setUsername(user == null ? "SYSTEM" : user.getFullName());
		actionLog.setUser(user);
		actionLog.setComment(comment);
		actionLog.setAction(action);
		return actionLog;
	}
	
	@Transactional
	public void rejectTrainingProposal(TrainingProposal trainingProposal, User user, String comments){
		trainingProposal.setStatus(STATUS.AMMEND);
		this.entityManager.merge(trainingProposal);
		addActionLog(trainingProposal,user, ActionType.AMMEND, comments);
	}
	
	@Transactional
	public void convertTrainingProposal(TrainingProposal trainingProposal, String comments) throws IOException {
		if(trainingProposal.getStatus()==STATUS.SUBMITTED){
			Announcement announce = new Announcement();
			
			announce.setRequester(trainingProposal.getRequester());
			announce.setProgramDirector(trainingProposal.getProgramDirector());
			announce.setExpectedOutcome(trainingProposal.getExpectedOutcome());
			announce.setIntroduction(trainingProposal.getIntroduction());
			announce.setTrainingProposal(trainingProposal);
			announce.setDeadline(trainingProposal.getDeadline());
			announce.setType(trainingProposal.getType());
			announce.setObjective(trainingProposal.getObjective());
			announce.setPayment(trainingProposal.getPayment());
			announce.setTitle(trainingProposal.getTitle());
			announce.setTargetGroup(trainingProposal.getTargetGroup());		
			announce.setLearningMethod(trainingProposal.getLearningMethod());
			announce.setCourseContents(trainingProposal.getCourseContents());		
			announce.setTrainingFee(trainingProposal.getTrainingFee());
			announce.setAccommodation(trainingProposal.getAccommodation());
			announce.setKeywords(trainingProposal.getKeywords());
			announce.setNumberOfParticipants(trainingProposal.getNumberOfParticipants());
			announce.setNumberOfFemale(trainingProposal.getNumberOfFemale());
			announce.setNumberOfMale(trainingProposal.getNumberOfMale());
			announce.setStatus(Announcement.STATUS.Draft);
			
			//Insert announcement entity
			this.entityManager.persist(announce);
			
			//Update/migrate trainers
			for(int i=0;i<trainingProposal.getTrainers().size();i++){
				Trainer trainer = new Trainer();
				trainer.setAnnouncement(announce);
				trainer.setPerson(trainingProposal.getTrainers().get(i).getPerson());
				trainer.setType(trainingProposal.getTrainers().get(i).getType());
				trainer.setNotes(trainingProposal.getTrainers().get(i).getNotes());
				trainer.setNames(trainingProposal.getTrainers().get(i).getNames());
				trainer.setEmail(trainingProposal.getTrainers().get(i).getEmail());
				this.entityManager.persist(trainer);
			}
			
			//Update/migrate location information
			for(int i=0;i<trainingProposal.getTrainingLocations().size();i++){
				TrainingLocation loc = new TrainingLocation();
				loc.setAnnouncement(announce);
				loc.setCountry(trainingProposal.getTrainingLocations().get(i).getCountry());
				loc.setVenue(trainingProposal.getTrainingLocations().get(i).getVenue());
				loc.setEndDate(trainingProposal.getTrainingLocations().get(i).getEndDate());
				loc.setStartDate(trainingProposal.getTrainingLocations().get(i).getStartDate());
				this.entityManager.persist(loc);
			}
			
			//Update/migrate documents
			for(int i=0;i<trainingProposal.getDocuments().size();i++){
				Document doc = new Document();
				doc.setAllowPublic(trainingProposal.getDocuments().get(i).getDocument().isAllowPublic());
				//try{
					File file = new File(trainingProposal.getDocuments().get(i).getDocument().getFile());
					String newName = distinctName() + "." + getExtension(trainingProposal.getDocuments().get(i).getDocument().getFile());
					File fileToCreate = new File(trainingProposal.getDocuments().get(i).getDocument().getFile().substring(0, trainingProposal.getDocuments().get(i).getDocument().getFile().lastIndexOf("/")+1), newName);
					FileUtils.copyFile(file, fileToCreate);	
					doc.setFile(fileToCreate.toString());
					doc.setFilePath(trainingProposal.getDocuments().get(i).getDocument().getFilePath().substring(0, trainingProposal.getDocuments().get(i).getDocument().getFilePath().lastIndexOf("/")+1) + newName);
				//}catch(Exception e){
				//	throw null;				
				//}
				
				doc.setTitle(trainingProposal.getDocuments().get(i).getDocument().getTitle());
				doc.setType(trainingProposal.getDocuments().get(i).getDocument().getType());
				
				this.entityManager.persist(doc);
				
				AnnouncementDocument announceDoc = new AnnouncementDocument();
				announceDoc.setDocument(doc);
				announceDoc.setEntity(announce);
				this.entityManager.persist(announceDoc);
			}
			//Update announcement entity
			//this.entityManager.merge(announce);
			
			//update trainingProposal
			trainingProposal.setAnnouncement(announce);
			this.entityManager.merge(trainingProposal);
		}
		
		// add log
		this.entityManager.persist(createActionLog(trainingProposal, trainingProposal.getOwner(), ActionType.APPROVED, "Training proposal request approved and converted to announcement"));
	}
	
	private String distinctName() {
		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
			int length = rand.nextInt(5) + 5;
			for (int i = 0; i < length; i++)
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			if (identifiers.contains(builder.toString()))
				builder = new StringBuilder();
		}
		return builder.toString() + StringUtil.getRandomAlphaNumericString(5);
	}
	
	private String getExtension(final String filename) {
		  if (filename == null) return null;
		  final String afterLastSlash = filename.substring(filename.lastIndexOf('/') + 1);
		  final int _slash = afterLastSlash.lastIndexOf('\\') + 1;
		  final int _index = afterLastSlash.indexOf('.', _slash);
		  return (_index == -1) ? "" : afterLastSlash.substring(_index + 1);
	}
	
	@Transactional
	public TrainingProposal copy(TrainingProposal trainingProposal, User user) throws IOException {
		if(trainingProposal.getStatus()==STATUS.SUBMITTED){
			TrainingProposal newTP = new TrainingProposal();
			
			//newTP.setCreatedBy(user);
			newTP.setExpectedOutcome(trainingProposal.getExpectedOutcome());
			newTP.setIntroduction(trainingProposal.getIntroduction());
			newTP.setDeadline(trainingProposal.getDeadline());
			newTP.setType(trainingProposal.getType());
			newTP.setObjective(trainingProposal.getObjective());
			newTP.setPayment(trainingProposal.getPayment());
			newTP.setTitle("COPY - " + trainingProposal.getTitle());
			newTP.setTargetGroup(trainingProposal.getTargetGroup());		
			newTP.setLearningMethod(trainingProposal.getLearningMethod());
			newTP.setCourseContents(trainingProposal.getCourseContents());		
			newTP.setTrainingFee(trainingProposal.getTrainingFee());
			newTP.setAccommodation(trainingProposal.getAccommodation());
			newTP.setKeywords(trainingProposal.getKeywords());
			newTP.setNumberOfParticipants(trainingProposal.getNumberOfParticipants());
			newTP.setNumberOfFemale(trainingProposal.getNumberOfFemale());
			newTP.setNumberOfMale(trainingProposal.getNumberOfMale());
			newTP.setStatus(TrainingProposal.STATUS.DRAFT);
			newTP.setOwner(user);
			newTP.setRequester(trainingProposal.getRequester());
			newTP.setProgramDirector(trainingProposal.getProgramDirector());
			
			newTP.setUnit(trainingProposal.getUnit());
			newTP.setCrp(trainingProposal.getCrp());
			newTP.setActivity(trainingProposal.getActivity());
			newTP.setProjectInformation(trainingProposal.getProjectInformation());
			newTP.setCostCenter(trainingProposal.getCostCenter());
			
			//Insert announcement entity
			this.entityManager.persist(newTP);
			
			//Update/migrate trainers
			for(int i=0;i<trainingProposal.getTrainers().size();i++){
				Trainer trainer = new Trainer();
				trainer.setTrainingProposal(newTP);
				trainer.setPerson(trainingProposal.getTrainers().get(i).getPerson());
				trainer.setType(trainingProposal.getTrainers().get(i).getType());
				trainer.setNotes(trainingProposal.getTrainers().get(i).getNotes());
				trainer.setNames(trainingProposal.getTrainers().get(i).getNames());
				trainer.setEmail(trainingProposal.getTrainers().get(i).getEmail());
				this.entityManager.persist(trainer);
			}
			
			//Update/migrate location information
			for(int i=0;i<trainingProposal.getTrainingLocations().size();i++){
				TrainingLocation loc = new TrainingLocation();
				loc.setTrainingProposal(newTP);
				loc.setCountry(trainingProposal.getTrainingLocations().get(i).getCountry());
				loc.setVenue(trainingProposal.getTrainingLocations().get(i).getVenue());
				loc.setEndDate(trainingProposal.getTrainingLocations().get(i).getEndDate());
				loc.setStartDate(trainingProposal.getTrainingLocations().get(i).getStartDate());
				this.entityManager.persist(loc);
			}
			
			//Update/migrate documents
			for(int i=0;i<trainingProposal.getDocuments().size();i++){
				Document doc = new Document();
				doc.setAllowPublic(trainingProposal.getDocuments().get(i).getDocument().isAllowPublic());
				//try{
					File file = new File(trainingProposal.getDocuments().get(i).getDocument().getFile());
					String newName = distinctName() + "." + getExtension(trainingProposal.getDocuments().get(i).getDocument().getFile());
					File fileToCreate = new File(trainingProposal.getDocuments().get(i).getDocument().getFile().substring(0, trainingProposal.getDocuments().get(i).getDocument().getFile().lastIndexOf("/")+1), newName);
					FileUtils.copyFile(file, fileToCreate);	
					doc.setFile(fileToCreate.toString());
					doc.setFilePath(trainingProposal.getDocuments().get(i).getDocument().getFilePath().substring(0, trainingProposal.getDocuments().get(i).getDocument().getFilePath().lastIndexOf("/")+1) + newName);
				//}catch(Exception e){
				//	throw null;				
				//}
				
				doc.setTitle(trainingProposal.getDocuments().get(i).getDocument().getTitle());
				doc.setType(trainingProposal.getDocuments().get(i).getDocument().getType());
				
				this.entityManager.persist(doc);
				
				TrainingProposalDocument proposalDoc = new TrainingProposalDocument();
				proposalDoc.setDocument(doc);
				proposalDoc.setEntity(newTP);
				
				this.entityManager.persist(proposalDoc);
			}
			//Update announcement entity
			//this.entityManager.merge(announce);
			
			//update trainingProposal
			//trainingProposal.setAnnouncement(announce);
			this.entityManager.merge(trainingProposal);
			
			return newTP;
		}
		
		return null;
	}
	
	/**
	 * @see org.iita.crm.service.PersonService#createPerson(java.lang.String)
	 */
	@Transactional
	private Person createPerson(String personName) {
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
	
	@Transactional(readOnly=true)
	private Person findExistingPerson(String email) {
		// search existing Person by email
		Person person = null;
		try{
			person = (Person) this.entityManager.createQuery("select c.person from EmailContact c where c.email=:mail").setParameter("mail", email).getSingleResult();
		}catch(Exception e){
			person=null;
		}
		if(person==null)
			return null;
		else
			return person;
	}
}