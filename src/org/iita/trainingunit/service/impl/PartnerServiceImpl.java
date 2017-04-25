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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.iita.crm.model.AddressContact;
import org.iita.crm.model.EmailContact;
import org.iita.crm.model.FaxContact;
import org.iita.crm.model.MobileContact;
import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerCategory;
import org.iita.crm.model.PartnerClassification;
import org.iita.crm.model.PartnerCoreBusiness;
import org.iita.crm.model.PartnerCoreBusinessCategory;
import org.iita.crm.model.PartnerIITAHub;
import org.iita.crm.model.PartnerIITAHub.IITAHub;
import org.iita.crm.model.PartnerMandateCrop;
import org.iita.crm.model.PartnerPersonContact;
import org.iita.crm.model.PartnerPersonContact.AffiliationType;
import org.iita.crm.model.PartnerScale;
import org.iita.crm.model.PartnerSector;
import org.iita.crm.model.PartnerSubsector;
import org.iita.crm.model.Person;
import org.iita.crm.model.PhoneContact;
import org.iita.crm.model.RssContact;
import org.iita.crm.model.WebsiteContact;
import org.iita.service.XLSDataImportService;
import org.iita.service.impl.XLSExportService;
import org.iita.service.impl.XLSImportException;
import org.iita.trainingunit.service.PartnerPortService;
import org.iita.util.DeleteFileAfterCloseInputStream;
import org.iita.util.PagedResult;
import org.springframework.security.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author KOraegbunam
 *
 */
public class PartnerServiceImpl implements PartnerPortService {
	private static final Log LOG = LogFactory.getLog(PartnerServiceImpl.class);
	static final String[] FIELDS = new String[] { "" };
	//private String alumniStorage;
	private XLSDataImportService xlsImportService;
	//private EmailService emailService;
	//private TemplatingService templatingService;
	private EntityManager entityManager;
	//private TrainingUnitService trainingUnitService;
	
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
	//public void setTrainingUnitService(TrainingUnitService trainingUnitService) {
	//	this.trainingUnitService = trainingUnitService;
	//}

	@Override
	@Transactional
	public <T extends Object> void importXLSData(List<Object[]> partners, Class<T> clazz, List<Object[]> rowFailedPartnerData) {
		for (Object[] partner : partners) {
			ensurePartnerExists(partner, clazz, rowFailedPartnerData);
		}
	}
	

	/**
	 * @return 
	 * @return
	 * @see org.iita.crm.service.PartnerService#ensurePartnerExists(Person, Class, Object)
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public <T extends Object> T ensurePartnerExists(Object[] partner, Class<T> clazz, List<Object[]> rowFailedPartnerData) {
		LOG.info("Ensuring record exists for " + partner[0] + " [" + partner[1] + "]");
		Partner partnerR = (Partner) this.findPartner(partner, clazz);

		LOG.debug("Partner: " + partnerR);
		if (partnerR == null) {
			LOG.warn("Creating new instances with details " + partner[0]  + " [" + partner[1]  + "]");

			AddressContact addressContact = new AddressContact();
			EmailContact emailContact = new EmailContact();
			PhoneContact phoneContact = new PhoneContact();
			RssContact rssContact = new RssContact();
			WebsiteContact websiteContact = new WebsiteContact();
			MobileContact mobileContact = new MobileContact();
			FaxContact faxContact = new FaxContact();
			
			try {
				partnerR = new Partner(); //clazz.newInstance();
			} catch (Exception e) {
				LOG.error("Error creating instance of " + clazz.getName());
				throw new RuntimeException("Error creating instance of " + clazz, e);
			}
			//Partner properties set
			//ShortName/Acronym
			if(partner[0]!=null)
				partnerR.setShortName((String) partner[0].toString().trim());
			else
				partnerR.setShortName("");
			
			//Title
			if(partner[1]!=null)
				partnerR.setTitle((String) partner[1].toString().trim());
			else
				partnerR.setTitle("Unknown");
			
			//Department
			if(partner[2]!=null)
				partnerR.setDepartment((String) partner[2].toString().trim());
			
			//Partnership Type
			if(partner[35]!=null)
				partnerR.setPartnershipType((String) partner[35].toString().trim());
			
			//Partnership Agreement
			if(partner[36]!=null)
				partnerR.setPartnershipAgreement((String) partner[36].toString().trim());
			
			//Source File
			if(partner[37]!=null)
				partnerR.setSourceFile((String) partner[37].toString().trim());
			
			//Source Person
			if(partner[38]!=null)
				partnerR.setSourcePerson((String) partner[38].toString().trim());
			
			//Date Submitted
			if(partner[39]!=null){
				try {
					String str = (String) partner[39].toString().replace(".", "/").replace("-", "/");
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					
					Date date = formatter.parse(str);
					
					partnerR.setDateSubmitted(date);
				} catch (ParseException ex) {
					try {
						String dateStr = (String) partner[39].toString().replace(".", "/").replace("-", "/");
						DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
						Date date = (Date) formatter.parse(dateStr);
						
						partnerR.setDateSubmitted(date);
					}catch (ParseException ex2) {
						Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
					}
			    }
			}
			
			//Notes
			if(partner[40]!=null)
				partnerR.setNotes((String) partner[40].toString().trim());
			
			if(partner[0]!=null || partner[1]!=null)
				this.entityManager.persist(partnerR);
			
			
			//AddressContact properties set
			if(partner[3]!=null){
				String addr = null;
				addr = (String) partner[3].toString().trim();
				addressContact.setAddress(addr);
			}
			
			if(partner[4]!=null)
				addressContact.setPostalAddress((String) partner[4].toString().trim());
				
			if(partner[5]!=null)
				addressContact.setCity((String) partner[5].toString().trim());
				
			if(partner[6]!=null)
				addressContact.setState((String) partner[6].toString().trim());
					
			addressContact.setActive(true);
			if(partner[7]!=null)
				addressContact.setCountry((String) partner[7].toString().trim());
				
			if(partner[8]!=null)
				addressContact.setContinent((String) partner[8].toString().trim());
				        
			if((String) partner[9]!=null)
				addressContact.setLatitude((Double) partner[9]);
			
			if(partner[10]!=null)
				addressContact.setLongitude((Double) partner[10]);
			
					
			addressContact.setPartner(partnerR);
			if((partner[0]!=null || partner[1]!=null || partner[2]!=null || partner[3]!=null || partner[4]!=null || partner[5]!=null || partner[6]!=null || partner[7]!=null || partner[8]!=null || partner[9]!=null  || partner[10]!=null) && partnerR!=null){
				this.entityManager.persist(addressContact);
			}
			
			//PhoneContact properties set
			if(partner[11]!=null && partnerR!=null){
				phoneContact.setActive(true);
				phoneContact.setPhoneNumber((String) partner[11].toString().trim());
				
				phoneContact.setPartner(partnerR);
				this.entityManager.persist(phoneContact);
			}
			
			if(partner[12]!=null && partnerR!=null){
				phoneContact = new PhoneContact();
				phoneContact.setActive(true);
				phoneContact.setPhoneNumber((String) partner[12].toString().trim());
				
				phoneContact.setPartner(partnerR);
				this.entityManager.persist(phoneContact);
			}
/*			
			if(partner[12]!=null && partnerR!=null){
				rssContact = new RssContact();
				rssContact.setActive(true);
				rssContact.setRss((String) partner[12].toString().trim());
				
				rssContact.setPartner(partnerR);
				this.entityManager.persist(rssContact);
			}
*/
			
			/*			
			if(partner[12]!=null && partnerR!=null){
				rssContact = new RssContact();
				rssContact.setActive(true);
				rssContact.setRss((String) partner[12].toString().trim());
				
				rssContact.setPartner(partnerR);
				this.entityManager.persist(rssContact);
			}
*/
						
			
			//MobileContact properties set
			//Mobile 1
			if(partner[13]!=null && partnerR!=null){
				mobileContact.setActive(true);
				mobileContact.setMobileNumber((String) partner[13].toString().trim());
				
				mobileContact.setPartner(partnerR);
				this.entityManager.persist(mobileContact);
			}
			//Mobile 2
			if(partner[14]!=null && partnerR!=null){
				mobileContact = new MobileContact();
				mobileContact.setActive(true);
				mobileContact.setMobileNumber((String) partner[14].toString().trim());
				
				mobileContact.setPartner(partnerR);
				this.entityManager.persist(mobileContact);
			}
			
			//FaxContact properties set
			if(partner[15]!=null && partnerR!=null){
				faxContact.setActive(true);
				faxContact.setFaxNumber((String) partner[15].toString().trim());
				
				faxContact.setPartner(partnerR);
				this.entityManager.persist(faxContact);
			}
			
			//EmailContact properties set
			//Email 1
			if(partner[16]!=null && partnerR!=null){
				emailContact.setActive(true);
				emailContact.setEmail((String) partner[16].toString().trim());
				
				emailContact.setPartner(partnerR);
				this.entityManager.persist(emailContact);
			}
			//Email 2
			if(partner[17]!=null && partnerR!=null){
				emailContact = new EmailContact();
				emailContact.setActive(true);
				emailContact.setEmail((String) partner[17].toString().trim());
				
				emailContact.setPartner(partnerR);
				this.entityManager.persist(emailContact);
			}
			
			//WebsiteContact properties set
			if(partner[18]!=null && partnerR!=null){
				websiteContact.setActive(true);
				websiteContact.setUrl((String) partner[18].toString().trim());
				
				websiteContact.setPartner(partnerR);
				this.entityManager.persist(websiteContact);
			}

			//Check if classification is in existence
			//classification 1
			if(partner[19]!=null && partnerR!=null){
				PartnerClassification pc = new PartnerClassification();
				pc.setPartner(partnerR);
				String str19 = (String) partner[19].toString().trim();
				str19 = Character.toString(str19.charAt(0)).toUpperCase()+str19.substring(1);
				
				pc.setType(str19);
				this.entityManager.persist(pc);
			}
			//classification 2
			if(partner[20]!=null && partnerR!=null){
				PartnerSector pc = new PartnerSector();
				pc.setPartner(partnerR);
				String str20 = (String) partner[20].toString().trim();
				str20 = Character.toString(str20.charAt(0)).toUpperCase()+str20.substring(1);
				
				pc.setType(str20);
				this.entityManager.persist(pc);
			}
/*			
			//classification 2
			if(partner[20]!=null && partnerR!=null){
				PartnerSubsector pc = new PartnerSubsector();
				pc.setPartner(partnerR);
				String str20 = (String) partner[20].toString().trim();
				str20 = Character.toString(str20.charAt(0)).toUpperCase()+str20.substring(1);
				
				pc.setType(str20);
				this.entityManager.persist(pc);
			}*/
			
			
			//Category 1
			if(partner[21]!=null && partnerR!=null){
				PartnerCategory pc = new PartnerCategory();
				pc.setPartner(partnerR);
				String str21 = (String) partner[21].toString().trim();
				str21 = Character.toString(str21.charAt(0)).toUpperCase()+str21.substring(1);
				
				pc.setType(str21);
				this.entityManager.persist(pc);
			}
			//Category 2
			if(partner[22]!=null && partnerR!=null){
				PartnerScale pc = new PartnerScale();
				pc.setPartner(partnerR);
				
				String str = (String) partner[22].toString().trim();
				str = Character.toString(str.charAt(0)).toUpperCase()+str.substring(1);
				
				pc.setType(str);
				this.entityManager.persist(pc);
			}
			
			//CoreBusiness 1
			if(partner[23]!=null && partnerR!=null){
				PartnerCoreBusiness pc = new PartnerCoreBusiness();
				pc.setPartner(partnerR);
				String str23 = (String) partner[23].toString().trim();
				str23 = Character.toString(str23.charAt(0)).toUpperCase()+str23.substring(1);
				
				pc.setType(str23);
				this.entityManager.persist(pc);
			}
			//CoreBusiness 2
			if(partner[24]!=null && partnerR!=null){
				PartnerCoreBusinessCategory pc = new PartnerCoreBusinessCategory();
				pc.setPartner(partnerR);
				String str24 = (String) partner[24].toString().trim();
				str24 = Character.toString(str24.charAt(0)).toUpperCase()+str24.substring(1);
				
				pc.setType(str24);
				this.entityManager.persist(pc);
			}
			
			//MandateCrop 1
			if(partner[25]!=null && partnerR!=null){
				PartnerMandateCrop pc = new PartnerMandateCrop();
				pc.setPartner(partnerR);
				String str25 = (String) partner[25].toString().trim();
				str25 = Character.toString(str25.charAt(0)).toUpperCase()+str25.substring(1);
				
				pc.setType(str25);
				this.entityManager.persist(pc);
			}
			
			if(partner[34]!=null && partnerR!=null){
				PartnerIITAHub pc = new PartnerIITAHub();
				pc.setPartner(partnerR);
				IITAHub hub = IITAHub.UNSPECIFIED;
				
				if (partner[34].toString().trim().contains("Western"))
					hub=IITAHub.WESTERNAFRICA;
				if (partner[34].toString().trim().contains("Eastern"))
					hub=IITAHub.EASTERNAFRICA;
				if (partner[34].toString().trim().contains("Southern"))
					hub=IITAHub.SOUTHERNAFRICA;
				if (partner[34].toString().trim().contains("Central"))
					hub=IITAHub.CENTRALAFRICA;
				
				
				pc.setHub(hub);
				this.entityManager.persist(pc);
			}
		}
		return (T) partnerR;
	}
	
	@Override
	@Transactional
	public <T extends Object> void importContactsXLSData(List<Object[]> contacts, Class<T> clazz, List<Object[]> rowFailedPartnerData) {
		for (Object[] contact : contacts) {
			ensurePartnerContactExists(contact, clazz, rowFailedPartnerData);
		}
	}
	/**
	 * @return 
	 * @return
	 * @see org.iita.crm.service.PartnerService#ensurePartnerContactExists(Person, Class, Object)
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public <T extends Object> T ensurePartnerContactExists(Object[] partner, Class<T> clazz, List<Object[]> rowFailedPartnerData) {
		LOG.info("Ensuring record exists for " + partner[0] + " [" + partner[1] + "]");
		Partner partnerR = (Partner) this.findPartner(partner, Partner.class);
		
		String lastName = null;
		String firstName = null;
		String email = null;
		
		if(partner[1]!=null)
			lastName = (String) partner[1].toString().trim();
	
		if(partner[3]!=null)
			firstName = (String) partner[3].toString().trim();
		
		if(partner[6]!=null)
			email = (String) partner[6].toString().trim();
		
		
		Person person = (Person) this.findPerson(lastName, firstName, email);
		
		
		PartnerPersonContact partnerContactR = (PartnerPersonContact) this.findPartnerContact(partnerR, person);
		
		if(partnerContactR==null){
			if (partnerR!=null && person==null && partner[3]!=null && partner[1]!=null) {
				LOG.warn("Creating new instances with details " + partner[0]  + " [" + partner[1]  + "]");
	
				person = new Person();
				EmailContact emailContact = new EmailContact();
				PhoneContact phoneContact = new PhoneContact();
				FaxContact faxContact = new FaxContact();
				MobileContact mobileContact = new MobileContact();
				
				try {
					partnerContactR = new PartnerPersonContact(); //clazz.newInstance();
				} catch (Exception e) {
					LOG.error("Error creating instance of " + clazz.getName());
					throw new RuntimeException("Error creating instance of " + clazz, e);
				}
				
				//Person properties set
				//Last Name
				if(partner[1]!=null)
					person.setLastName((String) partner[1].toString().trim());
				else
					person.setLastName("Unspecified");
				
				//Middle Name
				if(partner[2]!=null)
					person.setOtherNames((String) partner[2].toString().trim());
								
				//First Name
				if(partner[3]!=null)
					person.setFirstName((String) partner[3].toString().trim());
				else
					person.setFirstName("Unspecified");
				
				//Title
				if(partner[4]!=null)
					person.setTitle((String) partner[4].toString().trim());
				
				LOG.warn("GENDER: " + partner[7]);
				if(partner[7]!=null){
					if((boolean) partner[7].toString().trim().equalsIgnoreCase("Male"))
						person.setGender(Person.Gender.MALE);
					else if((boolean) partner[7].toString().trim().equalsIgnoreCase("Female"))
						person.setGender(Person.Gender.FEMALE);
				}
				
				person.setMaritalStatus(null);
				
				//PERSIST PERSON
				if(partner[3]!=null || partner[1]!=null)
					this.entityManager.persist(person);
				
				//EmailContact properties set
				if((String) partner[8]!=null && partnerR!=null && person!=null){
					emailContact.setActive(true);
					if((String) partner[8]!=null)
						emailContact.setEmail((String) partner[8].toString().trim());
					
					emailContact.setPerson(person);
					this.entityManager.persist(emailContact);
				}
				
				//PhoneContact properties set
				//Phone 1
				if(partner[9]!=null && partnerR!=null && person!=null){
					phoneContact.setActive(true);
					if(partner[9]!=null)
						phoneContact.setPhoneNumber((String) partner[9].toString().trim());
					
					phoneContact.setPerson(person);
					this.entityManager.persist(phoneContact);
				}
				//Phone 2
				if(partner[10]!=null && partnerR!=null && person!=null){
					phoneContact.setActive(true);
					if(partner[10]!=null)
						phoneContact.setPhoneNumber((String) partner[10].toString().trim());
					
					phoneContact.setPerson(person);
					this.entityManager.persist(phoneContact);
				}
				
				//MobileContact properties set
				//Mobile 1
				if(partner[11]!=null && partnerR!=null && person!=null){
					mobileContact.setActive(true);
					if(partner[11]!=null)
						mobileContact.setMobileNumber((String) partner[11].toString().trim());
					
					phoneContact.setPerson(person);
					this.entityManager.persist(mobileContact);
				}
				//Mobile 2
				if(partner[12]!=null && partnerR!=null && person!=null){
					mobileContact.setActive(true);
					if(partner[12]!=null)
						mobileContact.setMobileNumber((String) partner[12].toString().trim());
					
					mobileContact.setPerson(person);
					this.entityManager.persist(mobileContact);
				}
				
				if(partner[13]!=null && partnerR!=null && person!=null){
					faxContact.setActive(true);
					if(partner[13]!=null)
						faxContact.setFaxNumber((String) partner[13].toString().trim());
					
					faxContact.setPerson(person);
					this.entityManager.persist(faxContact);
				}
				
				//PartnerPersonContact properties set
				if(partner[4]!=null)
					partnerContactR.setTitle((String) partner[4].toString().trim());
				
				if(partner[5]!=null)
					partnerContactR.setPosition((String) partner[5].toString().trim());
				
				if(partner[6]!=null)
					partnerContactR.setDiscipline((String) partner[6].toString().trim());
				
				if(partner[14]!=null){
					AffiliationType typ = AffiliationType.EMPLOYEE;
					
					if (partner[14].toString().trim().contains("EMPLOYEE"))
						typ=AffiliationType.EMPLOYEE;
					if (partner[14].toString().trim().contains("TRAINEE"))
						typ=AffiliationType.TRAINEE;
					if (partner[14].toString().trim().contains("CONSULTANT"))
						typ=AffiliationType.CONSULTANT;
					if (partner[14].toString().trim().contains("MANAGER"))
						typ=AffiliationType.MANAGER;
					if (partner[14].toString().trim().contains("IITA"))
						typ=AffiliationType.IITA;
					
					partnerContactR.setType(typ);
				}
				
				if(partner[15]!=null)
					partnerContactR.setSourceFile((String) partner[15].toString().trim());
				
				if(partner[16]!=null)
					partnerContactR.setSourceFileRow((String) partner[16].toString().trim());
				
				//Source Person
				if(partner[17]!=null)
					partnerContactR.setSourcePerson((String) partner[17].toString().trim());

				//Source Date
				if(partner[18]!=null){
					try {
						String str = (String) partner[18].toString().replace(".", "/").replace("-", "/");
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						
						Date date = formatter.parse(str);
						
						partnerContactR.setSourceDate(date);
					} catch (ParseException ex) {
						try {
							String dateStr = (String) partner[18].toString().replace(".", "/").replace("-", "/");
							DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
							Date date = (Date) formatter.parse(dateStr);
							
							partnerContactR.setSourceDate(date);
						}catch (ParseException ex2) {
							Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
						}
				    }
				}
				
				if(partner[19]!=null)
					partnerContactR.setRemarks((String) partner[19].toString().trim());
				
				partnerContactR.setPartner(partnerR);
				partnerContactR.setPerson(person);
				
				if(partnerR!=null && person!=null)
					this.entityManager.persist(partnerContactR);
		
			}else if(partnerR!=null && person!=null){
				try {
					partnerContactR = new PartnerPersonContact(); //clazz.newInstance();
				} catch (Exception e) {
					LOG.error("Error creating instance of " + clazz.getName());
					throw new RuntimeException("Error creating instance of " + clazz, e);
				}
				//PartnerPersonContact properties set
				if(partner[4]!=null)
					partnerContactR.setTitle((String) partner[4].toString().trim());
				
				if(partner[5]!=null)
					partnerContactR.setPosition((String) partner[5].toString().trim());
				
				if(partner[6]!=null)
					partnerContactR.setDiscipline((String) partner[6].toString().trim());
				
				if(partner[14]!=null){
					AffiliationType typ = AffiliationType.EMPLOYEE;
					
					if (partner[14].toString().trim().contains("EMPLOYEE"))
						typ=AffiliationType.EMPLOYEE;
					if (partner[14].toString().trim().contains("TRAINEE"))
						typ=AffiliationType.TRAINEE;
					if (partner[14].toString().trim().contains("CONSULTANT"))
						typ=AffiliationType.CONSULTANT;
					if (partner[14].toString().trim().contains("MANAGER"))
						typ=AffiliationType.MANAGER;
					if (partner[14].toString().trim().contains("IITA"))
						typ=AffiliationType.IITA;
					
					partnerContactR.setType(typ);
				}
				
				if(partner[15]!=null)
					partnerContactR.setSourceFile((String) partner[15].toString().trim());
				
				if(partner[16]!=null)
					partnerContactR.setSourceFileRow((String) partner[16].toString().trim());
				
				//Source Person
				if(partner[17]!=null)
					partnerContactR.setSourcePerson((String) partner[17].toString().trim());

				//Source Date
				if(partner[18]!=null){
					try {
						String str = (String) partner[18].toString().replace(".", "/").replace("-", "/");
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						
						Date date = formatter.parse(str);
						
						partnerContactR.setSourceDate(date);
					} catch (ParseException ex) {
						try {
							String dateStr = (String) partner[18].toString().replace(".", "/").replace("-", "/");
							DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
							Date date = (Date) formatter.parse(dateStr);
							
							partnerContactR.setSourceDate(date);
						}catch (ParseException ex2) {
							Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
						}
				    }
				}
				
				if(partner[19]!=null)
					partnerContactR.setRemarks((String) partner[19].toString().trim());
				
				partnerContactR.setPartner(partnerR);
				partnerContactR.setPerson(person);
				this.entityManager.persist(partnerContactR);
			}else
				rowFailedPartnerData.add(partner);
			
		}else
			rowFailedPartnerData.add(partner);
		
		return (T) partnerContactR;
	}	
	
	@Transactional
	private PartnerPersonContact findPartnerContact(Partner partner, Person person) {
		try {
			LOG.warn("Finding partner person contact for " + partner + ", " + person);
			return (PartnerPersonContact) this.entityManager
					.createQuery("select distinct p from PartnerPersonContact p where p.partner=:partner and p.person=:person")
					.setParameter("partner", partner)
					.setParameter("person", person).setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			LOG.warn("Partner person contact not found.");
			return null;
		}
	}
	
	@Transactional
	private Person findPerson(String lastName, String firstName, String email) {
		try {
			LOG.warn("Finding person contact for " + lastName + ", " + firstName + " [" + email + "]");
			return (Person) this.entityManager
					.createQuery("select distinct p from Person p where (p.lastName=:lastName and p.firstName=:firstName)")
					.setParameter("lastName", lastName)
					.setParameter("firstName", firstName)
					.setMaxResults(1).getSingleResult();//.setParameter("email", email)
		} catch (NoResultException e) {
			LOG.warn("Partner contact not found.");// or p.lastEmail.email=:email
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	private <T extends Object> T findPartner(Object[] partner, Class<T> clazz) {
		try {
			LOG.warn("Finding partner for " + partner[0] + " from " + partner[1]);
			return (T) this.entityManager
					.createQuery("select distinct p from " + clazz.getName() + " p where p.title=:title" +
							" or p.shortName=:shortname")
					.setParameter("title", (String) partner[0])
					.setParameter("shortname", (String) partner[1])
					.setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			LOG.warn("Partner not found.");
			return null;
		}
	}
	
	
	@Override
	public <T extends Partner> List<T> previewXLSImports(File file, Class<T> clazz, List<Object[]> allXlsRowData) throws FileNotFoundException,
			IOException, XLSImportException {
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));

		List<Object[]> rowData = this.xlsImportService.getObjectsFromXLS(workbook.getSheetAt(0), 0);
		List<T> partners = new ArrayList<T>();
		for (Object[] row : rowData) {
			T partner;
			try {
				partner = getPartner(row, clazz, allXlsRowData);
			} catch (Exception e) {
				LOG.error(e, e);
				throw new RuntimeException("Could not create partner: " + e.getMessage(), e);
			}
			if (partner != null) {
				partners.add(partner);
				LOG.debug("PARTNER FOUND");
			} else {
				LOG.debug("PARTNER NOT FOUND");
			}
		}
		return partners;
	}
	
	@Override
	public <T extends PartnerPersonContact> List<T> previewContactsXLSImports(File file, Class<T> clazz, List<Object[]> allXlsRowData) throws FileNotFoundException,
			IOException, XLSImportException {
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));

		List<Object[]> rowData = this.xlsImportService.getObjectsFromXLS(workbook.getSheetAt(0), 0);
		List<T> partners = new ArrayList<T>();
		for (Object[] row : rowData) {
			T partner;
			try {
				partner = getPartnerPersonContact(row, clazz, allXlsRowData);
			} catch (Exception e) {
				LOG.error(e, e);
				throw new RuntimeException("Could not create partner: " + e.getMessage(), e);
			}
			if (partner != null) {
				partners.add(partner);
				LOG.debug("PARTNER FOUND");
			} else {
				LOG.debug("PARTNER NOT FOUND");
			}
		}
		return partners;
	}
	
	/**
	 * @param row
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private <T extends Partner> T getPartner(Object[] row, Class<T> clazz, List<Object[]> allXlsRowData) throws InstantiationException,
			IllegalAccessException {
		T partner = clazz.newInstance();
		int i = 0;
		for (Object x : row) {
			LOG.debug("" + i++ + ": " + x);
		}

		if (row[0] != null || row[1] != null) {
			allXlsRowData.add(row);
			return partner;
		} else {
			return null;
		}
	}
	/**
	 * @param row
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private <T extends PartnerPersonContact> T getPartnerPersonContact(Object[] row, Class<T> clazz, List<Object[]> allXlsRowData) throws InstantiationException,
			IllegalAccessException {
		T partner = clazz.newInstance();
		int i = 0;
		for (Object x : row) {
			LOG.debug("" + i++ + ": " + x);
		}

		if (row[0] != null || row[1] != null) {
			allXlsRowData.add(row);
			return partner;
		} else {
			return null;
		}
	}
	
	@Override
	public InputStream exportPartnerData(List<Partner> partners) throws IOException {
		if (partners.size() == 0)
			return null;

		return exportData((List<Partner>) partners);

	}
	
	/**
	 * @param appraisals
	 * @return
	 * @throws IOException
	 */
	private InputStream exportData(List<Partner> partners) throws IOException {
		InputStream templateStream = PartnerServiceImpl.class.getClassLoader().getResourceAsStream(
				"org/iita/trainingunit/service/impl/Partner-template.xls");

		HSSFWorkbook wb = new HSSFWorkbook(templateStream);
		HSSFSheet sheet = wb.createSheet();
		sheet = wb.getSheetAt(0);

		List<Object[]> data = XLSExportService.convertData(partners, new String[] { "title", "shortName" });

		XLSExportService.fillSheet(sheet, new String[] { "Title", "ShortName" }, data);

		int rowCount = sheet.getLastRowNum();

		LOG.debug("ROW COUNT VALUE: " + rowCount);

		// return stream for downloads
		File file = File.createTempFile("export", "xls");
		FileOutputStream fs = new FileOutputStream(file);
		wb.write(fs);
		fs.flush();
		fs.close();
		return new DeleteFileAfterCloseInputStream(file);
	}

	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public PagedResult<Partner> list(int startAt, int maxResults) {
		PagedResult<Partner> paged = new PagedResult<Partner>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("select p from Partner p " +
				"order by p.title asc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(p) from Partner " +
				"p").getSingleResult());
		return paged;
	}

	@Override
	@Transactional
	public List<Partner> list(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	@Transactional
	public List<Partner> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public PagedResult<Partner> search(String text, int startAt, int maxResults) {
		
		
		try {
			StringBuilder query = new StringBuilder();
			//query = null;
			
			if(text!=null && text.length()>0){
				query.append("p.title like '%").append(text).append("%'");
				query.append(" or p.shortName like '%").append(text).append("%'");
			}
			
			//LOG.warn("QUERY STRING 1: " + query);
			if(query!=null && query.length()>0){
				//LOG.warn("QUERY STRING 2: " + query);
				LOG.warn("select p from Partner p where "+query+" order by p.title asc");
				PagedResult<Partner> paged = new PagedResult<Partner>();
				paged.setStartAt(startAt);
				paged.setMaxResults(maxResults);
				paged.setResults(this.entityManager.createQuery("select p from Partner p where "+query+" order by p.title asc")
						.setFirstResult(startAt)
						.setMaxResults(maxResults)
						.getResultList());
				paged.setTotalHits((Long) this.entityManager.createQuery("select count(p) from Partner p" +
						" where "+query)
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
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public List<Partner> search(String text) {
		try {
			StringBuilder query = new StringBuilder();
			//query = null;
			
			if(text!=null && text.length()>0){
				query.append("p.title like '%").append(text).append("%'");
				query.append(" or p.shortName like '%").append(text).append("%'");
			}
			//LOG.warn("QUERY STRING 1: " + query);
			if(query!=null && query.length()>0){
				//LOG.warn("QUERY STRING 2: " + query);
				LOG.info("select p from Partner p where "+query+" order by p.title asc");
				return this.entityManager.createQuery("from Partner p where "+query+" order by p.title asc").getResultList();
			}else
				return null;
		} catch (NoResultException e) {
			LOG.warn("Partner not found.");
			return null;
		}
	}
	
	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public Partner getPartnerInfo(Person person) {
		try {
			return (Partner) this.entityManager
			.createQuery("from Partner p where (p.person=:person)")
			.setParameter("person", person).getSingleResult();
		} catch (NoResultException e) {
			LOG.warn("Partner not found.");
			return null;
		}
	}

	@Override
	@Transactional
	public void addPartner(Partner partner) {
		if (partner != null) {
			this.entityManager.persist(partner);
		}
	}

	@Override
	@Transactional
	public void deletePartner(Partner partner) {
		this.entityManager.remove(partner);
	}
	
	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public Partner getPartnerInfo(Long id){
		Partner partner = this.entityManager.find(Partner.class, id);
		return partner;
	}
	

	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public PagedResult<Partner> search(String name, String tag, String org, int startAt, int maxResults) {
				
		try {
			StringBuilder query = new StringBuilder();
			//query = null;
			
			if(name!=null && name.length()>0)
				query.append("p.lastName like '%").append(name).append("%'");
			
			if(query!=null && query.length()>0){
				if(name!=null && name.length()>0)
					query.append(" or p.firstName like '%").append(name).append("%'");
			}else{
				if(name!=null && name.length()>0)
					query.append("p.firstName like '%").append(name).append("%'");
			}
			
			if(query!=null && query.length()>0){
				if(tag!=null && tag.length()>0)
					query.append(" and pt.entity.tag like '%").append(tag).append("%'");
			}else {
				if(tag!=null && tag.length()>0)
					query.append("pt.entity.tag like '%").append(tag).append("%'");
			}
			
			if(query!=null && query.length()>0){
				if(org!=null && org.length()>0)
					query.append(" and (pt.title like '%").append(org).append("%'").append(" or pt.shortName like '%").append(org).append("%')");
			}else{
				if(org!=null && org.length()>0)
					query.append("(pt.title like '%").append(org).append("%'").append(" or pt.shortName like '%").append(org).append("%')");
			}
			
			//LOG.warn("QUERY STRING 1: " + query);
			if(query!=null && query.length()>0){
				//LOG.warn("QUERY STRING 2: " + query);
				//LOG.warn("select * from Alumni a where "+query+" order by a.person.firstName, a.person.lastName asc");
				PagedResult<Partner> paged = new PagedResult<Partner>();
				paged.setStartAt(startAt);
				paged.setMaxResults(maxResults);
				paged.setResults(this.entityManager.createQuery("from Partner pt left outer join pt.tags at left outer join pt.partnerContacts pc left outer join pc.person p where "+query+" order by p.firstName, p.lastName asc")
						.setFirstResult(startAt)
						.setMaxResults(maxResults)
						.getResultList());
				paged.setTotalHits((Long) this.entityManager.createQuery("select count(pt) from Partner pt left outer join pt.tags at left outer join pt.partnerContacts pc left outer join pc.person p where "+query)
						.getSingleResult());
				return paged;
			}else
				return null;
		} catch (NoResultException e) {
			LOG.warn("Partner not found.");
			return null;
		}
	}
	
	/**
	 * @see org.iita.trainingunit.service.PartnerPortService#listCategories()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public List<String> listPartnerCategories() {
		return this.entityManager.createQuery("from PartnerCategory pc group by pc.type order by pc.type asc").getResultList();
	}
	/**
	 * @see org.iita.trainingunit.service.PartnerPortService#listCategories()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public List<String> listPartnerClassifications() {
		return this.entityManager.createQuery("from PartnerClassification pc group by pc.type order by pc.type asc").getResultList();
	}
	/**
	 * @see org.iita.trainingunit.service.PartnerPortService#listCategories()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public List<String> listPartnerMandateCrops() {
		return this.entityManager.createQuery("from PartnerMandateCrop pc group by pc.type order by pc.type asc").getResultList();
	}
	/**
	 * @see org.iita.trainingunit.service.PartnerPortService#listCategories()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public List<String> listPartnerCoreBusinesses() {
		return this.entityManager.createQuery("from PartnerCoreBusiness pc group by pc.type order by pc.type asc").getResultList();
	}
	/**
	 * @see org.iita.trainingunit.service.PartnerPortService#listCategories()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public List<String> listHubs() {
		return this.entityManager.createQuery("from PartnerIITAHub pc group by pc.hub order by pc.hub asc").getResultList();
	}
	/**
	 * @see org.iita.trainingunit.service.PartnerPortService#listPartnerCoreBusinessCategories()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public List<String> listPartnerCoreBusinessCategories() {
		return this.entityManager.createQuery("from PartnerCoreBusinessCategory pc group by pc.type order by pc.type asc").getResultList();
	}
	/**
	 * @see org.iita.trainingunit.service.PartnerPortService#listPartnerCoreBusinessCategories()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public List<String> listPartnerScales() {
		return this.entityManager.createQuery("from PartnerScale pc group by pc.type order by pc.type asc").getResultList();
	}
	/**
	 * @see org.iita.trainingunit.service.PartnerPortService#listPartnerCoreBusinessCategories()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public List<String> listPartnerSectors() {
		return this.entityManager.createQuery("from PartnerSector pc group by pc.type order by pc.type asc").getResultList();
	}
}
