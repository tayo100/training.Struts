/**
 * 
 */
package org.iita.trainingunit.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.iita.crm.model.AddressContact;
import org.iita.crm.model.EmailContact;
import org.iita.crm.model.Organization;
import org.iita.crm.model.Person;
import org.iita.crm.model.Person.AlumniStatus;
import org.iita.crm.model.PhoneContact;
import org.iita.crm.service.CRMException;
import org.iita.service.XLSDataImportService;
import org.iita.service.impl.XLSExportService;
import org.iita.service.impl.XLSImportException;
import org.iita.trainingunit.model.Alumni;
import org.iita.trainingunit.model.Funding;
import org.iita.trainingunit.model.Funding.SponsorType;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.Trainer;
import org.iita.trainingunit.service.AlumniService;
import org.iita.trainingunit.service.TrainingUnitService;
import org.iita.util.DeleteFileAfterCloseInputStream;
import org.iita.util.PagedResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author KOraegbunam
 *
 */
public class AlumniServiceImpl implements AlumniService {
	private static final Log LOG = LogFactory.getLog(AlumniServiceImpl.class);
	static final String[] FIELDS = new String[] { "" };
	//private String alumniStorage;
	private XLSDataImportService xlsImportService;
	//private EmailService emailService;
	//private TemplatingService templatingService;
	private EntityManager entityManager;
	private TrainingUnitService trainingUnitService;
	
	/**
	 * @see org.iita.service.impl.SimpleDaoServiceImpl#setEntityManager(javax.persistence.EntityManager)
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/**
	 * @param alumniStorage the alumniStorage to set
	 */
	//public void setAlumniStorage(String alumniStorage) {
	//	this.alumniStorage = alumniStorage;
	//}
	
	/**
	 * @param xlsImportService the xlsImportService to set
	 */
	public void setXlsImportService(XLSDataImportService xlsImportService) {
		this.xlsImportService = xlsImportService;
	}

	/**
	 * @param emailService the emailService to set
	 */
	//public void setEmailService(EmailService emailService) {
	//	this.emailService = emailService;
	//}

	/**
	 * @param templatingService the templatingService to set
	 */
	//public void setTemplatingService(TemplatingService templatingService) {
	//	this.templatingService = templatingService;
	//}
	
	/**
	 * @param trainingUnitService the trainingUnitService to set
	 */
	public void setTrainingUnitService(TrainingUnitService trainingUnitService) {
		this.trainingUnitService = trainingUnitService;
	}

	@Override
	@Transactional
	public <T extends Object> void importXLSData(List<Object[]> alumnis, Class<T> clazz, List<Object[]> rowFailedAlumniData) {
		for (Object[] alumni : alumnis) {
			ensureAlumniExists(alumni, clazz, rowFailedAlumniData);
		}
	}

	/**
	 * @return
	 * @see org.iita.par.service.AlumniService#ensureAlumniExists(Person, Class, Object)
	 */
	@SuppressWarnings({ "unchecked", "null" })
	@Transactional
	public <T extends Object> T ensureAlumniExists(Object[] alumni, Class<T> clazz, List<Object[]> rowFailedAlumniData) {
		LOG.info("Ensuring appraisal exists for " + alumni[2] + " " + alumni[1] + " from " + alumni[7]);
		Alumni alumniR = (Alumni) this.findAlumni(alumni, clazz);

		LOG.debug("Alumni: " + alumniR);
		if (alumniR == null) {
			LOG.warn("Creating new person with details " + alumni[1]  + ", " + alumni[2]  + " from " + alumni[7] + " with email: " + alumni[8]);
			Person person = new Person();
			AddressContact addressContact = new AddressContact();
			EmailContact emailContact = new EmailContact();
			PhoneContact phoneContact = new PhoneContact();
			Trainee trainee = new Trainee();
			
			try {
				alumniR = new Alumni(); //clazz.newInstance();
			} catch (Exception e) {
				LOG.error("Error creating instance of " + clazz.getName());
				throw new RuntimeException("Error creating instance of " + clazz, e);
			}
			//Person properties set
			if(alumni[2]!=null)
				person.setFirstName((String) alumni[2].toString().trim());
			else
				person.setFirstName("Unknown");
			if(alumni[1]!=null)
				person.setLastName((String) alumni[1].toString().trim());
			else
				person.setLastName("Unknown");
			
			if(alumni[3]!=null)
				person.setOtherNames((String) alumni[3].toString().trim());
			
			LOG.warn("GENDER: " + (String) alumni[11]);
			if((String) alumni[11]!=null){
				if((boolean) alumni[11].toString().trim().equals("M"))
					person.setGender(Person.Gender.MALE);
				else if((boolean) alumni[11].toString().trim().equals("F"))
					person.setGender(Person.Gender.FEMALE);
			}
			
			person.setMaritalStatus(null);
			if((String) alumni[7]!=null)
				person.setCountry((String) alumni[7].toString().trim());
			
			person.setAlumniStatus(AlumniStatus.YES);
			
			if((String) alumni[7]!=null)
				person.setCountryOfResidence((String) alumni[7].toString().trim());
			
			if(alumni[2]!=null || alumni[1]!=null)
				this.entityManager.persist(person);
			
			//AddressContact properties set
			if((String) alumni[4]!=null && person!=null){
				addressContact.setAddress((String) alumni[4].toString().trim());
				if((String) alumni[7]!=null)
					addressContact.setCountry((String) alumni[7].toString().trim());
				if((String) alumni[5]!=null)
					addressContact.setCity((String) alumni[5].toString().trim());
					
				addressContact.setActive(true);
				if((String) alumni[6]!=null)
					addressContact.setState((String) alumni[6].toString().trim());
					
				addressContact.setPerson(person);
				this.entityManager.persist(addressContact);
			}
			
			//EmailContact properties set
			if((String) alumni[8]!=null && person!=null){
				emailContact.setActive(true);
				if((String) alumni[8]!=null)
					emailContact.setEmail((String) alumni[8].toString().trim());
				
				emailContact.setPerson(person);
				this.entityManager.persist(emailContact);
			}
			
			//PhoneContact properties set
			if((alumni[9]!=null || alumni[10]!=null) && person!=null){
				phoneContact.setActive(true);
				if(alumni[9]!=null){
					String phone = (String) alumni[9].toString().trim();
					
					if(alumni[10]!=null)
						phone += " FAX:" + (String) alumni[10].toString().trim();
					
					phoneContact.setPhoneNumber(phone);
				}
				phoneContact.setPerson(person);
				this.entityManager.persist(phoneContact);
			}
			
			//Check if sponsor/organization is in existence
			Organization org = new Organization();
			if((String) alumni[27]!=null){
				org = this.findOrganization((String) alumni[27].toString().trim());
				//Funding properties set
				
				if(org==null){
					try {
						org = this.trainingUnitService.registerOrganization((String) alumni[27].toString().trim());
					} catch (CRMException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					System.out.println("ORG ID for " + org.getShortName() + " is " + org.getId());
				}
			}
			
			if((String) alumni[28]!=null)
				trainee.setDiscipline((String) alumni[28].toString().trim());
			
			if((String) alumni[12]!=null)
				trainee.setResearchTopic((String) alumni[12].toString().trim());
			else
				trainee.setResearchTopic("Not specified");
			
			if((String) alumni[27]!=null)
				trainee.setSponsor((String) alumni[27].toString().trim());
			
			if((String) alumni[15]!=null)
				trainee.setDegree((String) alumni[15].toString().trim());
			
			if((String) alumni[13]!=null)
				trainee.setLocation((String) alumni[13].toString().trim());
			
			String str;
			int index;
			String startDateStr;
			String endDateStr;
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			
			if(alumni[17]!=null){
				str = (String) alumni[17].toString().trim();
				index = str.indexOf(".");
				
				if(index==0)
					startDateStr = "01/01/"+ str;
				else
					startDateStr = "01/01/"+ str.substring(0, index);
				
				Date startDate = new Date();
				
				try {
					startDate = (Date) formatter.parse(startDateStr);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				LOG.warn("Start Date: " + startDate);
				trainee.setStartDate(startDate);
			}
			
			if(alumni[18]!=null){
				str = (String) alumni[18].toString().trim();
				index = str.indexOf(".");
				if(index==0)
					endDateStr = "12/31/"+ str;
				else
					endDateStr = "12/31/"+ str.substring(0, index);
				
				Date endDate = new Date();
				try {
					endDate = (Date) formatter.parse(endDateStr);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				LOG.warn("End Date: " + endDate);
				trainee.setEndDate(endDate);
			}			
			
			//Check if sponsor/organization is in existence
			Organization university = null;
			if((String) alumni[16]!=null){
				if(!alumni[16].equals("")){
					university = this.findOrganization((String) alumni[16].toString().trim());
					//Funding properties set
					if(university==null){
						try {
							Organization univ = this.trainingUnitService.registerOrganization((String) alumni[16].toString().trim());
							university = univ;
						} catch (CRMException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
			trainee.setUniversity(university);
			if(person!=null){
				trainee.setPerson(person);
				this.trainingUnitService.registerTrainee(trainee);
			}
			
			//Add person to alumni entity
			if(person!=null){
				alumniR.setPerson(person);
				if(alumni[29]!=null)
					alumniR.setCostCenter((String) alumni[29].toString().trim());
				
				if((String) alumni[28]!=null)
					alumniR.setDepartment((String) alumni[28]);
				
				if((String) alumni[27]!=null)
					alumniR.setSponsor((String) alumni[27].toString().trim());
				
				StringBuilder supos = new StringBuilder();
				if((String) alumni[19]!=null)
					supos.append((String) alumni[19].toString().trim());
				
				if((String) alumni[21]!=null){
					if(supos!=null)
						supos.append((String) alumni[21].toString().trim());
					else
						supos.append((String) alumni[19].toString().trim());
				}
				
				if((String) alumni[22]!=null)
					supos.append(" ").append((String) alumni[22].toString().trim());
				
				if((String) alumni[20]!=null)
					supos.append(" ").append((String) alumni[20].toString().trim());
				
				if((String) alumni[23]!=null && supos!=null)
					supos.append("/").append((String) alumni[23].toString().trim());
				else if((String) alumni[23]!=null && supos==null)
					supos.append((String) alumni[23].toString().trim());
				
				if((String) alumni[25]!=null)
					supos.append(" ").append((String) alumni[25].toString().trim());
				
				if((String) alumni[26]!=null)
					supos.append(" ").append((String) alumni[26].toString().trim());
				
				if((String) alumni[24]!=null)
					supos.append(" ").append((String) alumni[24].toString().trim());
				
				if(supos!=null)
					alumniR.setSupervisor(supos.toString());
				
				if(trainee!=null)
					alumniR.setTrainee(trainee);
				
				this.entityManager.persist(alumniR);
			}
			String costCentre = null;
			
			if(alumni[29]!=null)
				costCentre = (String) alumni[29].toString();
			
			//Check funding
			existingFunding(costCentre, org, trainee);
			
			//Check and add Supervisor 1
			existingSupervisor((String) alumni[19], (String) alumni[20], (String) alumni[21], (String) alumni[22], trainee);
			
			//Check and add Supervisor 2
			existingSupervisor((String) alumni[23], (String) alumni[24], (String) alumni[25], (String) alumni[26], trainee);
		}
		
		return (T) alumniR;
	}
	
	private void existingSupervisor(String title, String lastName, String firstName, String otherNames,  Trainee trainee){
		LOG.warn("Supervisor: " + title + " " + firstName + " " + otherNames + " " + lastName);
		StringBuilder supo = new StringBuilder();
		Person person = new Person();
		if(title!=null)
			supo.append(title);
		if(firstName!=null)
			supo.append(" ").append(firstName);
		if(otherNames!=null && otherNames.length()>0)
			supo.append(" ").append(otherNames);
		if(lastName!=null)
			supo.append(" ").append(lastName);
				
		if(supo!=null){
				person = this.trainingUnitService.findPerson(supo.toString());
				if(person!=null){
						if(trainee!=null){
							Trainer trainer = new Trainer();
							trainer.setPerson(person);
							trainer.setTrainee(trainee);
							this.trainingUnitService.registerTrainer(trainer);
							
						}
				}else if(person==null){
					person = this.trainingUnitService.createPerson(supo.toString());
					if(trainee!=null){
						Trainer trainer = new Trainer();
						trainer.setPerson(person);
						trainer.setTrainee(trainee);
						this.trainingUnitService.registerTrainer(trainer);
					}
				}
			//}
		}
	}
	
	private void existingFunding(String cc, Organization org, Trainee trainee){
		LOG.warn("CC: " + cc);
		LOG.warn("ORG: " + org);
		LOG.warn("TRAINEE: " + trainee);
		Funding lookupFunding = new Funding();
		if(cc!=null){
			lookupFunding = this.trainingUnitService.lookupFunding(cc, org);
		}
		
		if(cc!=null){
			if(lookupFunding!=null){
					if(trainee!=null){
						List<Funding> stList = new ArrayList<Funding>(); 
						stList.add(lookupFunding);
						Trainee t = this.trainingUnitService.loadTrainee(trainee.getId());
						
						t.setFundings(stList);
						this.trainingUnitService.update(t, null, null, null, null);
					}
			}else if(lookupFunding==null){
				Funding funding = new Funding();
				funding.setCostCenter(cc);
				funding.setOrganization(org);
				funding.setEstimatedCost(null);
				funding.setSponsorType(SponsorType.CORE);
				List<Funding> stList = new ArrayList<Funding>(); 
				stList.add(funding);
				LOG.warn("lookupFunding: null");
				if(trainee!=null){
					Trainee t = this.trainingUnitService.loadTrainee(trainee.getId());

					LOG.warn("Check funding: " + t.getFundings());
					t.setFundings(stList);
					this.trainingUnitService.update(t, null, null, null, null);
					this.trainingUnitService.registerFunding(funding);
				}
			}
		}
	}
	
	
	@Transactional
	private Organization findOrganization(String org) {
		try {
			LOG.warn("Finding organization for " + org);
			return (Organization) this.entityManager
					.createQuery("select distinct o from Organization o where (o.shortName=:org" +
							" or o.title=:org) or o.shortName in (:org)")
					.setParameter("org", org).setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			LOG.warn("Organization not found.");
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	private <T extends Object> T findAlumni(Object[] alumni, Class<T> clazz) {
		try {
			LOG.warn("Finding alumni for " + alumni[2] + " from " + alumni[7]);
			return (T) this.entityManager
					.createQuery("select distinct a from " + clazz.getName() + " a where a.person.firstName=:fname" +
							" and a.person.lastName=:lname " +
							"and a.person.country=:country")
					.setParameter("fname", (String) alumni[2])
					.setParameter("lname", (String) alumni[1])
					.setParameter("country", (String) alumni[7]).setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			LOG.warn("Alumni not found.");
			return null;
		}
	}
	
	
	@Override
	public <T extends Alumni> List<T> previewXLSImports(File file, Class<T> clazz, List<Object[]> allXlsRowData) throws FileNotFoundException,
			IOException, XLSImportException {
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));

		List<Object[]> rowData = this.xlsImportService.getObjectsFromXLS(workbook.getSheetAt(0), 0);
		List<T> alumnis = new ArrayList<T>();
		for (Object[] row : rowData) {
			T alumni;
			try {
				alumni = getAlumni(row, clazz, allXlsRowData);
			} catch (Exception e) {
				LOG.error(e, e);
				throw new RuntimeException("Could not create alumni: " + e.getMessage(), e);
			}
			if (alumni != null) {
				alumnis.add(alumni);
				LOG.debug("ALUMNI FOUND");
			} else {
				LOG.debug("ALUMNI NOT FOUND");
			}
		}
		return alumnis;
	}
	
	/**
	 * @param row
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private <T extends Alumni> T getAlumni(Object[] row, Class<T> clazz, List<Object[]> allXlsRowData) throws InstantiationException,
			IllegalAccessException {
		T alumni = clazz.newInstance();
		Person person = new Person();
		int i = 0;
		for (Object x : row) {
			LOG.debug("" + i++ + ": " + x);
		}

		if (row[1] != null || row[2] != null) {
			//row[3] is the Appraiser Staff ID cell
			person.setLastName((String) row[1]);
			person.setFirstName((String) row[2]);
			person.setOtherNames((String) row[3]);
			person.setCountry((String) row[7]);
			if((String) row[11]=="M")
				person.setGender(Person.Gender.MALE);
			else if((String) row[11]=="F")
				person.setGender(Person.Gender.FEMALE);
			
			alumni.setPerson(person);
			//if (appraiser == null) {
			//	rowFailedAppraisalData.add(row);
			//	return null;
			//}
			allXlsRowData.add(row);
			return alumni;
		} else {
			return null;
		}
	}
	
	@Override
	public InputStream exportAlumniData(List<Alumni> alumnis) throws IOException {
		if (alumnis.size() == 0)
			return null;

		return exportData((List<Alumni>) alumnis);

	}
	
	/**
	 * @param appraisals
	 * @return
	 * @throws IOException
	 */
	private InputStream exportData(List<Alumni> alumnis) throws IOException {
		InputStream templateStream = AlumniServiceImpl.class.getClassLoader().getResourceAsStream(
				"org/iita/trainingunit/service/impl/Alumni-template.xls");

		HSSFWorkbook wb = new HSSFWorkbook(templateStream);
		HSSFSheet sheet = wb.createSheet();
		sheet = wb.getSheetAt(0);

		List<Object[]> data = XLSExportService.convertData(alumnis, new String[] { "person.user.lastName", "person.user.firstName", "person.gender",
				"person.dob", "person.designation", "person.phoneContacts", "person.emailContacts", "person.addressContacts", "person.country",
				"person.addressCountry" });

		XLSExportService.fillSheet(sheet, new String[] { "LastName", "FirstName", "Gender", "DOB", "Designation", "Telephone", "Email",
				"Address", "Nationality", "Country of Residence" }, data);

		int rowCount = sheet.getLastRowNum();

		LOG.debug("ROW COUNT VALUE: " + rowCount);

		// return stream for downloads
		File file = File.createTempFile("export", ".xls");
		FileOutputStream fs = new FileOutputStream(file);
		wb.write(fs);
		fs.flush();
		fs.close();
		return new DeleteFileAfterCloseInputStream(file);
	}

	@Override
	@Transactional
	public PagedResult<Alumni> list(int startAt, int maxResults) {
		PagedResult<Alumni> paged = new PagedResult<Alumni>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("from Alumni a " +
				"order by a.person.firstName, a.person.lastName asc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(a) from Alumni " +
				"a").getSingleResult());
		return paged;
	}

	@Override
	@Transactional
	public List<Alumni> list(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	public PagedResult<Alumni> search(String lastName, String firstName, String topic, String org, Date fromDate, Date toDate, int startAt, int maxResults) {
		
		
		try {
			StringBuilder query = new StringBuilder();
			//query = null;
			
			if(lastName!=null && lastName.length()>0)
				query.append("p.lastName like '%").append(lastName).append("%'");
			
			if(query!=null && query.length()>0){
				if(firstName!=null && firstName.length()>0)
					query.append(" and p.firstName like '%").append(firstName).append("%'");
			}else{
				if(firstName!=null && firstName.length()>0)
					query.append("p.firstName like '%").append(firstName).append("%'");
			}
			
			if(query!=null && query.length()>0){
				if(topic!=null && topic.length()>0)
					query.append(" and t.researchTopic like '%").append(topic).append("%'");
			}else {
				if(topic!=null && topic.length()>0)
					query.append("t.researchTopic like '%").append(topic).append("%'");
			}
			//LOG.warn("TOPIC QUERY STRING: " + topic);
			//LOG.warn("QUERY STRING: " + query);
			
			if(query!=null && query.length()>0){
				if(org!=null && org.length()>0)
					query.append(" and (t.university.title like '%").append(org).append("%'").append(" or t.university.shortName like '%").append(org).append("%')");
			}else{
				if(org!=null && org.length()>0)
					query.append("(t.university.title like '%").append(org).append("%'").append(" or t.university.shortName like '%").append(org).append("%')");
			}
			
			if(query!=null && query.length()>0){
				if(fromDate!=null && toDate!=null){
					String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					String toDate1 = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
					query.append(" and ((t.startDate between '").append(fromDate1).append("' and '").append(toDate1).append("')");
					query.append(" or (t.endDate between '").append(fromDate1).append("' and '").append(toDate1).append("')");
					query.append(" or (t.extensionDate between '").append(fromDate1).append("' and '").append(toDate1).append("'))");
				}
				else if(fromDate!=null && toDate==null){
					String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					query.append(" and ((t.startDate = '").append(fromDate1).append("')");
					query.append(" or (t.endDate = '").append(fromDate1).append("')");
					query.append(" or (t.extensionDate = '").append(fromDate1).append("'))");
				}
				else if(fromDate==null && toDate!=null){
					String toDate1 = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
					query.append(" and ((t.startDate = '").append(toDate1).append("')");
					query.append(" or (t.endDate = '").append(toDate1).append("')");
					query.append(" or (t.extensionDate = '").append(toDate1).append("'))");
				}
			}else{
				if(fromDate!=null && toDate!=null){
					String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					String toDate1 = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
					query.append("((t.startDate between '").append(fromDate1).append("' and '").append(toDate1).append("')");
					query.append(" or (t.endDate between '").append(fromDate1).append("' and '").append(toDate1).append("')");
					query.append(" or (t.extensionDate between '").append(fromDate1).append("' and '").append(toDate1).append("'))");
				}
				else if(fromDate!=null && toDate==null){
					String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					query.append("((t.startDate = '").append(fromDate1).append("')");
					query.append(" or (t.endDate = '").append(fromDate1).append("')");
					query.append(" or (t.extensionDate = '").append(fromDate1).append("'))");
				}
				else if(fromDate==null && toDate!=null){
					String toDate1 = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
					query.append("((t.startDate = '").append(toDate1).append("')");
					query.append(" or (t.endDate = '").append(toDate1).append("')");
					query.append(" or (t.extensionDate = '").append(toDate1).append("'))");
				}
			}
			//LOG.warn("QUERY STRING 1: " + query);
			if(query!=null && query.length()>0){
				//LOG.warn("QUERY STRING 2: " + query);
				//LOG.warn("select a from Alumni a where "+query+" order by a.person.firstName, a.person.lastName asc");
				PagedResult<Alumni> paged = new PagedResult<Alumni>();
				paged.setStartAt(startAt);
				paged.setMaxResults(maxResults);
				paged.setResults(this.entityManager.createQuery("from Person p left join Trainee t left join Alumni a where "+query+" order by p.firstName, p.lastName asc")
						.setFirstResult(startAt)
						.setMaxResults(maxResults)
						.getResultList());
				paged.setTotalHits((Long) this.entityManager.createQuery("select count(a) from Person p left join Trainee t left join Alumni a where "+query)
						.getSingleResult());
				return paged;
			}else
				return null;
		} catch (NoResultException e) {
			LOG.warn("Alumni not found.");
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Alumni> search(String lastName, String firstName, String topic, String org, Date fromDate, Date toDate) {
		try {
			StringBuilder query = new StringBuilder();
			//query = null;
			
			if(lastName!=null && lastName.length()>0)
				query.append("p.lastName like '%").append(lastName).append("%'");
			
			if(query!=null && query.length()>0){
				if(firstName!=null && firstName.length()>0)
					query.append(" and p.firstName like '%").append(firstName).append("%'");
			}else{
				if(firstName!=null && firstName.length()>0)
					query.append("p.firstName like '%").append(firstName).append("%'");
			}
			
			if(query!=null && query.length()>0){
				if(topic!=null && topic.length()>0)
					query.append(" and t.researchTopic like '%").append(topic).append("%'");
			}else {
				if(topic!=null && topic.length()>0)
					query.append("t.researchTopic like '%").append(topic).append("%'");
			}
			//LOG.warn("TOPIC QUERY STRING: " + topic);
			//LOG.warn("QUERY STRING: " + query);
			
			if(query!=null && query.length()>0){
				if(org!=null && org.length()>0)
					query.append(" and (t.university.title like '%").append(org).append("%'").append(" or t.university.shortName like '%").append(org).append("%')");
			}else{
				if(topic!=null && org.length()>0)
					query.append("(t.university.title like '%").append(org).append("%'").append(" or t.university.shortName like '%").append(org).append("%')");
			}
			
			if(query!=null && query.length()>0){
				if(fromDate!=null && toDate!=null){
					String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					String toDate1 = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
					query.append(" and ((t.startDate between '").append(fromDate1).append("' and '").append(toDate1).append("')");
					query.append(" or (t.endDate between '").append(fromDate1).append("' and '").append(toDate1).append("')");
					query.append(" or (t.extensionDate between '").append(fromDate1).append("' and '").append(toDate1).append("'))");
				}
				else if(fromDate!=null && toDate==null){
					String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					query.append(" and ((t.startDate = '").append(fromDate1).append("')");
					query.append(" or (t.endDate = '").append(fromDate1).append("')");
					query.append(" or (t.extensionDate = '").append(fromDate1).append("'))");
				}
				else if(fromDate==null && toDate!=null){
					String toDate1 = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
					query.append(" and ((t.startDate = '").append(toDate1).append("')");
					query.append(" or (t.endDate = '").append(toDate1).append("')");
					query.append(" or (t.extensionDate = '").append(toDate1).append("'))");
				}
			}else{
				if(fromDate!=null && toDate!=null){
					String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					String toDate1 = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
					query.append("((t.startDate between '").append(fromDate1).append("' and '").append(toDate1).append("')");
					query.append(" or (t.endDate between '").append(fromDate1).append("' and '").append(toDate1).append("')");
					query.append(" or (t.extensionDate between '").append(fromDate1).append("' and '").append(toDate1).append("'))");
				}
				else if(fromDate!=null && toDate==null){
					String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					query.append("((t.startDate = '").append(fromDate1).append("')");
					query.append(" or (t.endDate = '").append(fromDate1).append("')");
					query.append(" or (t.extensionDate = '").append(fromDate1).append("'))");
				}
				else if(fromDate==null && toDate!=null){
					String toDate1 = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
					query.append("((t.startDate = '").append(toDate1).append("')");
					query.append(" or (t.endDate = '").append(toDate1).append("')");
					query.append(" or (t.extensionDate = '").append(toDate1).append("'))");
				}
			}
			//LOG.warn("QUERY STRING 1: " + query);
			if(query!=null && query.length()>0){
				//LOG.warn("QUERY STRING 2: " + query);
				LOG.info("select a from Person p left join Trainee t left join Alumni a where "+query+" order by p.firstName, p.lastName asc");
				return this.entityManager.createQuery("from Person p left join Trainee t left join Alumni a where "+query+" order by p.firstName, p.lastName asc").getResultList();
			}else
				return null;
		} catch (NoResultException e) {
			LOG.warn("Alumni not found.");
			return null;
		}
	}
	
	@Override
	@Transactional
	public Alumni getAlumniInfo(Person person) {
		try {
			return (Alumni) this.entityManager.createQuery("from Alumni a where (a.person=:person)").setParameter("person", person)
			.getSingleResult();
		} catch (NoResultException e) {
			LOG.warn("Organization not found.");
			return null;
		}
	}

	@Override
	@Transactional
	public void addAlumnus(Alumni alumnus) {
		if (alumnus != null) {
			if(alumnus.getPerson()!=null)
				if(this.getAlumniInfo(alumnus.getPerson())==null)
					this.entityManager.persist(alumnus);
		}
	}

	@Override
	@Transactional
	public void deleteAlumnus(Alumni alumnus) {
		this.entityManager.remove(alumnus);
	}
	
	@Override
	@Transactional
	public Alumni getAlumniInfo(Long id){
		Alumni alumnus = this.entityManager.find(Alumni.class, id);
		return alumnus;
	}
}
