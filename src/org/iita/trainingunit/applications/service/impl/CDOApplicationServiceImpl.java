package org.iita.trainingunit.applications.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LazyInitializationException;
import org.iita.security.model.User;
import org.iita.security.model.User.AuthenticationType;
import org.iita.security.model.UserLookup;
import org.iita.security.model.UserRole;
import org.iita.security.service.UserService;
import org.iita.service.EmailException;
import org.iita.service.EmailService;
import org.iita.service.TemplatingException;
import org.iita.service.TemplatingService;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.model.TrainingLocation;
import org.iita.trainingunit.applications.model.AdministrativeExperience;
import org.iita.trainingunit.applications.model.ApplicantTrainingLocation;
import org.iita.trainingunit.applications.model.ApplicantsBioData;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.model.Application.APPLICATIONSTATUS;
import org.iita.trainingunit.applications.model.Application.SUBMISSIONSTATUS;
import org.iita.trainingunit.applications.model.ApplicationStarter;
import org.iita.trainingunit.applications.model.BCodeStatus;
import org.iita.trainingunit.applications.model.BudgetCode;
import org.iita.trainingunit.applications.model.EducationAndTraining;
import org.iita.trainingunit.applications.model.EmploymentHistory;
import org.iita.trainingunit.applications.model.GraduateResearchTraining;
import org.iita.trainingunit.applications.model.GroupTraining;
import org.iita.trainingunit.applications.model.InHouseTraining;
import org.iita.trainingunit.applications.model.IndividualTraining;
import org.iita.trainingunit.applications.model.InternalApprovals;
import org.iita.trainingunit.applications.model.InternshipEducationAndExperience;
import org.iita.trainingunit.applications.model.InternshipTraining;
import org.iita.trainingunit.applications.model.InternshipWorkExperience;
import org.iita.trainingunit.applications.model.LanguageSpoken;
import org.iita.trainingunit.applications.model.MajorConstraints;
import org.iita.trainingunit.applications.model.MajorDuties;
import org.iita.trainingunit.applications.model.Milestone;
import org.iita.trainingunit.applications.model.NonDegreeTraining;
import org.iita.trainingunit.applications.model.OtherApplicationDetails;
import org.iita.trainingunit.applications.model.OtherStudiesAndTraining;
import org.iita.trainingunit.applications.model.OtherTraining;
import org.iita.trainingunit.applications.model.PreviousEducationAndTraining;
import org.iita.trainingunit.applications.model.PreviousEmploymentHistory;
import org.iita.trainingunit.applications.model.ProjectSummary;
import org.iita.trainingunit.applications.model.SabbaticalProjectSummary;
import org.iita.trainingunit.applications.model.SabbaticalTraining;
import org.iita.trainingunit.applications.model.SpecificSkills;
import org.iita.trainingunit.applications.model.StaffDevTraining;
import org.iita.trainingunit.applications.model.SupportType;
import org.iita.trainingunit.applications.model.TimeSchedule;
import org.iita.trainingunit.applications.service.CDOApplicationService;
import org.iita.trainingunit.applications.service.NotificationService;
import org.iita.trainingunit.model.CoreCompetency;
import org.iita.trainingunit.model.CostCenter;
import org.iita.trainingunit.model.Crp;
import org.iita.trainingunit.model.Hub;
import org.iita.util.NaturalOrderComparator;
import org.iita.util.PagedResult;
import org.iita.util.StringUtil;
import org.springframework.security.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;

public class CDOApplicationServiceImpl implements CDOApplicationService {
	private static final Log LOG = LogFactory.getLog(CDOApplicationServiceImpl.class);
	private EntityManager entityManager;
	private NotificationService notificationService;
	private Object cdoNumberMutex = new Object();
	private Long nextCDOnumber = null;
	private EmailService emailService;
	private TemplatingService templatingService;
	private UserService userService;
	
	
	/**
	 * @see org.iita.service.impl.SimpleDaoServiceImpl#setEntityManager(javax.persistence.EntityManager)
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/**
	 * @param templatingService the templatingService to set
	 */
	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
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
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public GroupTraining exists(Announcement announcement, String refNumber){
		try{
			return (GroupTraining) this.entityManager.createQuery("select a from GroupTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.refNumber=:refNumber").setParameter("announcement", announcement).setParameter("refNumber", refNumber).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
		
	@Override
	@Transactional(readOnly=true)
	public OtherApplicationDetails findOtherAppDetails(Long id) {
		if(id==null)
			return null;
		
		LOG.info("OtherAppID: " + id);		
		OtherApplicationDetails appDetails = this.entityManager.find(OtherApplicationDetails.class, id);
		return appDetails;
	}
	
	@Override
	public Application findByRefNumber(String refNumber, String email){
		try{
			return (Application) this.entityManager.createQuery("from Application a " +
		"where a.refNumber=:refNumber and a.biodata.correspondenceEmailAddress=:email").setParameter("refNumber", refNumber).setParameter("email", email).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	@Override
	public ApplicantsBioData getBioDataByRefNumber(String email){
		try{
			return (ApplicantsBioData) this.entityManager.createQuery("from ApplicantsBioData ab " +
		"where ab.correspondenceEmailAddress=:email").setParameter("email", email).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	@Override
	@Transactional
	public GroupTraining save(GroupTraining application) {//, List<Long> selectedLocations
		if(application==null)
			return null;
		
		//Cleaning up the data arrays
		cleanup(application);

		if (application.getId() == null) {
			application.setRefNumber(this.getNextCDOReferenceNumber());
			this.entityManager.persist(application);
		} else {
			this.entityManager.merge(application);
		}
		
		if(application.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("application", application);
			data.put("applicant", application.getBiodata());
			data.put("announcement", application.getAnnouncement());
			
			try {
				String message = templatingService.fillTemplate("cdoapplication", data);
				sendEmail(application, application.getAnnouncement().getTitle() + " Group Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
				
				message = templatingService.fillTemplate("cdoapplication-notify", data);
				
				for (User user : this.userService.findByRole("ROLE_APPLICATION"))
					sendEmail(true, user, application.getAnnouncement().getTitle() + " Group Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
			} catch (TemplatingException e) {
				LOG.error(e);
				return null;
			}
		}
		
		return application;
	}
	
	//@Transactional
	@SuppressWarnings("unused")
	private void handleSelectedLocations(List<Long> selectedLocations, Application application){
		
		//Clean up already added locations before new insertions
		//clearApplicantLocation(application);
		for(Long id : selectedLocations){
			ApplicantTrainingLocation appLoc = new ApplicantTrainingLocation();
			
			TrainingLocation loc = this.entityManager.find(TrainingLocation.class,id);
			appLoc.setApplication(application);
			appLoc.setTrainingLocation(loc);
			this.entityManager.persist(appLoc);
		}
		
	}
	
	//@SuppressWarnings("unchecked")
	//@Transactional
	//private void clearApplicantLocation(Application application){
	//	List<ApplicantTrainingLocation> applocDelete = (List<ApplicantTrainingLocation>) this.entityManager.createQuery("from ApplicantTrainingLocation a where a.application=:app").setParameter("app", application).getResultList();
		
	//	for(ApplicantTrainingLocation a : applocDelete){
	//		this.entityManager.remove(a);
	//	}
	//}
	
	@Override
	@Transactional
	//, List<Long> selectedLocations
	public GraduateResearchTraining save(GraduateResearchTraining application) throws Exception {
		if(application==null)
			return null;
		
		//Cleaning up the data arrays
		cleanupGraduateTraining(application);

		if (application.getId() == null) {
			application.setRefNumber(this.getNextCDOReferenceNumber());
			this.entityManager.persist(application);
		} else 
			this.entityManager.merge(application);
		
		//handleSelectedLocations(selectedLocations,application);
		
		if(application.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("application", application);
			data.put("applicant", application.getBiodata());
			data.put("announcement", application.getAnnouncement());
		
			try {
				String message = templatingService.fillTemplate("cdogradapplication", data);
				sendEmail(application, application.getAnnouncement().getTitle() + " Graduate Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
				
				message = templatingService.fillTemplate("cdogradapplication-notify", data);
				for (User user : this.userService.findByRole("ROLE_APPLICATION"))
					sendEmail(true, user, application.getAnnouncement().getTitle() + " Graduate Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
			} catch (TemplatingException e) {
				LOG.error(e);
				return null;
			}
		}
		
		return application;
	}
	
	
	@Override
	@Transactional
	public NonDegreeTraining save(NonDegreeTraining application) throws Exception {
		if(application==null)
			return null;
		
		//Cleaning up the data arrays
		cleanupNonDegree(application);

		if (application.getId() == null) {
			application.setRefNumber(this.getNextCDOReferenceNumber());
			this.entityManager.persist(application);
		} else 
			this.entityManager.merge(application);

		if(application.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("application", application);
			data.put("applicant", application.getBiodata());
			data.put("announcement", application.getAnnouncement());
		
			try {
				String message = templatingService.fillTemplate("cdonondegapplication", data);
				sendEmail(application, application.getAnnouncement().getTitle() + " Non-Degree Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
				
				message = templatingService.fillTemplate("cdonondegapplication-notify", data);
				for (User user : this.userService.findByRole("ROLE_APPLICATION"))
					sendEmail(true, user, application.getAnnouncement().getTitle() + " Non-Degree Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
			} catch (TemplatingException e) {
				LOG.error(e);
				return null;
			}
		}
		
		return application;
	}
	
	@Override
	@Transactional
	public OtherTraining save(OtherTraining application) throws Exception {
		if(application==null)
			return null;
		
		//Cleaning up the data arrays
		//cleanup(application);

		if (application.getId() == null) {
			application.setRefNumber(this.getNextCDOReferenceNumber());
			this.entityManager.persist(application);
		} else 
			this.entityManager.merge(application);
		
		if(application.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("application", application);
			data.put("applicant", application.getBiodata());
			data.put("announcement", application.getAnnouncement());
		
			try {
				String message = templatingService.fillTemplate("cdoapplication", data);
				sendEmail(application, application.getAnnouncement().getTitle() + " Group Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
				
				message = templatingService.fillTemplate("cdoapplication-notify", data);
				
				for (User user : this.userService.findByRole("ROLE_APPLICATION"))
					sendEmail(true, user, application.getAnnouncement().getTitle() + " Group Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
			} catch (TemplatingException e) {
				LOG.error(e);
				return null;
			}
		}
		
		return application;
	}

	
	@Transactional(readOnly=true)
	public PagedResult<Application> list(Long announcementId, int startAt, int maxResults) {
		PagedResult<Application> paged = new PagedResult<Application>(startAt, maxResults);
		paged.setResults(this.entityManager.createQuery("from Application a where a.announcement.id=:announcementId " +
				"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").setParameter("announcementId", announcementId).setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		
		if (paged.getResults().size() > 0)
			paged.setTotalHits(((Long) this.entityManager.createQuery("select count (a) from Application a where a.announcement.id=:announcementId").setParameter("announcementId", announcementId).getSingleResult()).longValue());
		
		return paged;
	}

	@Override
	@Transactional(readOnly=true)
	public GroupTraining find(Long id) {
		GroupTraining app = this.entityManager.find(GroupTraining.class, id);
		return app;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<GroupTraining> list() {
		return this.entityManager.createQuery("from GroupTraining a " +
		"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").getResultList();
	}
	
	/**
	 * Internal method to get next CDO number. Will increment CDO number.
	 * 
	 * @return
	 */
	@Transactional
	private String getNextCDOReferenceNumber() {
		synchronized (this.cdoNumberMutex) {
			if (this.nextCDOnumber == null) {
				findLastCDOReferenceNumber();
			}
			// return incremented
			return String.format("CDOAPP-%1$06d", this.nextCDOnumber++);
		}
	}
	
	private void findLastCDOReferenceNumber() {
		try {
			String maxShortName = (String) this.entityManager
					.createQuery("select a.refNumber from Application a where a.refNumber like 'CDOAPP-%' order by a.refNumber desc").setMaxResults(1)
					.getSingleResult();
			LOG.info("Max shortName: " + maxShortName);
			Matcher matcher = Pattern.compile("\\-(\\d+)$").matcher(maxShortName);
			if (matcher.find()) {
				LOG.info("Found part:" + matcher.group(1));
				String cdoNumber = matcher.group(1);
				this.nextCDOnumber = Long.parseLong(cdoNumber) + 1;
			} else {
				this.nextCDOnumber = 1l;
			}
		} catch (NoResultException e) {
			this.nextCDOnumber = 1l;
		}
	}
	
	/**
	 * Internal method to get next CDO number. Will increment CDO number.
	 * 
	 * @return
	 */
	/*@Transactional
	private String getNextCDOGradReferenceNumber() {
		synchronized (this.cdoNumberMutex) {
			if (this.nextCDOnumber == null) {
				findLastCDOGradReferenceNumber();
			}
			// return incremented
			return String.format("CDOGRAD-%1$06d", this.nextCDOnumber++);
		}
	}
	
	private void findLastCDOGradReferenceNumber() {
		try {
			String maxShortName = (String) this.entityManager
					.createQuery("select a.refNumber from GraduateResearchTraining a where a.refNumber like 'CDOGRAD-%' order by a.refNumber desc").setMaxResults(1)
					.getSingleResult();
			LOG.info("Max shortName: " + maxShortName);
			Matcher matcher = Pattern.compile("\\-(\\d+)$").matcher(maxShortName);
			if (matcher.find()) {
				LOG.info("Found part:" + matcher.group(1));
				String cdoNumber = matcher.group(1);
				this.nextCDOnumber = Long.parseLong(cdoNumber) + 1;
			} else {
				this.nextCDOnumber = 1l;
			}
		} catch (NoResultException e) {
			this.nextCDOnumber = 1l;
		}
	}
	*/
	/**
	 * Internal method to get next CDO number. Will increment CDO number.
	 * 
	 * @return
	 */
	/*@Transactional
	private String getNextCDONonDegReferenceNumber() {
		synchronized (this.cdoNumberMutex) {
			if (this.nextCDOnumber == null) {
				findLastCDONonDegReferenceNumber();
			}
			// return incremented
			return String.format("CDONDEG-%1$06d", this.nextCDOnumber++);
		}
	}
	
	private void findLastCDONonDegReferenceNumber() {
		try {
			String maxShortName = (String) this.entityManager
					.createQuery("select a.refNumber from NonDegreeTraining a where a.refNumber like 'CDONDEG-%' order by a.refNumber desc").setMaxResults(1)
					.getSingleResult();
			LOG.info("Max shortName: " + maxShortName);
			Matcher matcher = Pattern.compile("\\-(\\d+)$").matcher(maxShortName);
			if (matcher.find()) {
				LOG.info("Found part:" + matcher.group(1));
				String cdoNumber = matcher.group(1);
				this.nextCDOnumber = Long.parseLong(cdoNumber) + 1;
			} else {
				this.nextCDOnumber = 1l;
			}
		} catch (NoResultException e) {
			this.nextCDOnumber = 1l;
		}
	}*/
	
	/**
	 * Will notify delegated users instead of intended recipient, but CC the recipient in.
	 * 
	 * @param mail
	 * @param string
	 * @param message
	 */
	private void sendEmail(Application applicant, String subject, String body) {
		if (body == null) {
			LOG.warn("Not sending email to " + applicant.getBiodata().getCorrespondenceEmailAddress() + ", body is null.");
			return;
		}
			
		if(applicant!=null){
			LOG.warn("Notifying only the intended recipient " + applicant.getBiodata().getCorrespondenceEmailAddress());
			try {
				this.emailService.sendEmail("IITA-TrainingUnit@cgiar.org", null, new String[] { String.format("\"%1$s\" <%2$s>", applicant.getBiodata().getFullName(), applicant.getBiodata().getCorrespondenceEmailAddress()) }, subject, null, body);
			} catch (EmailException e) {
				LOG.error(e.getMessage());
			}
		}
	}
	
	/**
	 * Will notify delegated users instead of intended recipient, but CC the recipient in.
	 * 
	 * @param mail
	 * @param string
	 * @param message
	 */
	/*private void sendEmail(GraduateResearchTraining applicant, String subject, String body) {
		if (body == null) {
			LOG.warn("Not sending email to " + applicant.getBiodata().getEmailAddress() + ", body is null.");
			return;
		}
			
		if(applicant!=null){
			LOG.warn("Notifying only the intended recipient " + applicant.getBiodata().getEmailAddress());
			try {
				this.emailService.sendEmail("IITA-TrainingUnit@cgiar.org", null, new String[] { String.format("\"%1$s\" <%2$s>", applicant.getBiodata().getFullName(), applicant.getBiodata().getEmailAddress()) }, subject, null, body);
			} catch (EmailException e) {
				LOG.error(e.getMessage());
			}
		}
	}
	*/
	/**
	 * Will notify delegated users instead of intended recipient, but CC the recipient in.
	 * 
	 * @param mail
	 * @param string
	 * @param message
	 */
	/*private void sendEmail(NonDegreeTraining applicant, String subject, String body) {
		if (body == null) {
			LOG.warn("Not sending email to " + applicant.getBiodata().getEmailAddress() + ", body is null.");
			return;
		}
			
		if(applicant!=null){
			LOG.warn("Notifying only the intended recipient " + applicant.getBiodata().getEmailAddress());
			try {
				this.emailService.sendEmail("IITA-TrainingUnit@cgiar.org", null, new String[] { String.format("\"%1$s\" <%2$s>", applicant.getBiodata().getFullName(), applicant.getBiodata().getEmailAddress()) }, subject, null, body);
			} catch (EmailException e) {
				LOG.error(e.getMessage());
			}
		}
	}
	*/
	
	/**
	 * Will notify delegated users instead of intended recipient, but CC the recipient in.
	 * 
	 * @param mail
	 * @param string
	 * @param message
	 */
	private void sendEmail(ApplicantsBioData cdoBioData, String subject, String body) {
		if (body == null) {
			LOG.warn("Not sending email to " + cdoBioData.getCorrespondenceEmailAddress() + ", body is null.");
			return;
		}
			
		if(cdoBioData!=null){
			LOG.warn("Notifying only the intended recipient " + cdoBioData.getCorrespondenceEmailAddress());
			try {
				this.emailService.sendEmail("IITA-TrainingUnit@cgiar.org", new String[] { String.format("\"%1$s\" <%2$s>", cdoBioData.getFullName(), cdoBioData.getCorrespondenceEmailAddress()) }, null, subject, null, body);
			} catch (EmailException e) {
				LOG.error(e.getMessage());
			}
		}
	}
	
	/**
	 * Will notify delegated users instead of intended recipient, but CC the recipient in.
	 * 
	 * @param mail
	 * @param string
	 * @param message
	 */
	@SuppressWarnings("unchecked")
	private void sendEmail(boolean respectDelegation, User recipient, String subject, String body) {
		if (body == null) {
			LOG.warn("Not sending email to " + recipient + ", body is null.");
			return;
		}
		List<User> delegatedUsers = Collections.EMPTY_LIST;
		if (respectDelegation) {
			LOG.warn("Notification service respects delegation for this mail message.");
			delegatedUsers = getDelegatedUsers(recipient);
		}

		if (delegatedUsers != null && delegatedUsers.size() > 0) {
			LOG.warn("Notifying all delegated users and the intended recipient " + recipient.getFullName());
			subject += " [" + recipient.getFullName() + "]";
			body = "\n[Delegated from " + recipient.getFullName() + "]\n" + body;
			try {
				this.emailService.sendEmail("IITA-TrainingUnit@cgiar.org", getAddresses(delegatedUsers), new String[] { String.format("\"%1$s\" <%2$s>", recipient.getDisplayName(), recipient.getMail()) }, subject, body);
			} catch (EmailException e) {
				LOG.error(e.getMessage());
			}
		} else {
			if(recipient!=null){
				LOG.warn("Notifying only the intended recipient " + recipient.getFullName());
				try {
					this.emailService.sendEmail("IITA-TrainingUnit@cgiar.org", new String[] { String.format("\"%1$s\" <%2$s>", recipient.getDisplayName(), recipient.getMail()) }, null, subject, null, body);
				} catch (EmailException e) {
					LOG.error(e.getMessage());
				}
			}
		}
	}

	/**
	 * Convert list of users to a list of email address recipients
	 * 
	 * @param delegatedUsers
	 * @return
	 */
	private String[] getAddresses(List<User> delegatedUsers) {
		if (delegatedUsers == null || delegatedUsers.size() == 0) {
			LOG.warn("Not getting email addresses for empty list.");
			return StringUtil.EMPTY_STRINGARRAY;
		}
		LOG.info("Converting list of " + delegatedUsers.size() + " users to email address list.");
		String[] addresses = new String[delegatedUsers.size()];
		for (int i = 0; i < addresses.length; i++) {
			User user = delegatedUsers.get(i);
			if (user == null || user.getMail() == null) {
				LOG.debug("User is null or user.mail is null, not getting address.");
				continue;
			}
			addresses[i] = "\"" + user.getDisplayName() + "\" <" + user.getMail() + ">";
			LOG.info("Added recipient: " + addresses[i]);
		}
		return addresses;
	}

	/**
	 * @param nextApprover
	 * @return
	 */
	private List<User> getDelegatedUsers(User user) {
		return this.userService.getDelegatedTo(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int totalApplicants(Announcement announcement) {
		List<Application> list = this.entityManager.createQuery("from Application a inner join a.announcement an " +
		"where a.announcement=:announcement order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").setParameter("announcement", announcement).getResultList();
		
		return list.size();
	}
	
	/**
	 * 
	 */
	@Transactional
	public void cleanupNonDegree(NonDegreeTraining apps) {
		// cleanup  Constraints
		if(apps.getConstraints()!=null){
			if(apps.getConstraints()!=null){
				for (int i = apps.getConstraints().size() - 1; i >= 0; i--) {
					MajorConstraints c = apps.getConstraints().get(i);
					if(c!=null){
						if (c.getFaced() == null || c.getFaced().length() == 0) {
							LOG.debug("Removing " + c);
							ensureRemoved(apps.getConstraints().remove(i));
						} else
							c.setNonDegree(apps);
					}
				}
			}
		}
		
		// cleanup  Skills
		if(apps.getListSkills()!=null){
			if(apps.getListSkills()!=null){
				for (int i = apps.getListSkills().size() - 1; i >= 0; i--) {
					SpecificSkills s = apps.getListSkills().get(i);
					if(s!=null){
						if (s.getAcquireSkills() == null || s.getAcquireSkills().length() == 0) {
							LOG.debug("Removing " + s);
							ensureRemoved(apps.getListSkills().remove(i));
						} else
							s.setNonDegree(apps);
					}
				}
			}
		}
		
		// cleanup  Major Duties
		if(apps.getMajorDuties()!=null){
			if(apps.getMajorDuties()!=null){
				for (int i = apps.getMajorDuties().size() - 1; i >= 0; i--) {
					MajorDuties s = apps.getMajorDuties().get(i);
					if(s!=null){
						if (s.getDuties() == null || s.getDuties().length() == 0) {
							LOG.debug("Removing " + s);
							ensureRemoved(apps.getMajorDuties().remove(i));
						} else
							s.setNonDegree(apps);
					}
				}
			}
		}
	}
	
	/**
	 * 
	 */
	@Transactional
	public void cleanupGraduateTraining(GraduateResearchTraining apps) {
		if(apps!=null){
			if(apps.getMilestones()!=null){
				// cleanup Milestones
				for (int i = apps.getMilestones().size() - 1; i >= 0; i--) {
					Milestone mile = apps.getMilestones().get(i);
					if(mile!=null){
						if (mile.getMilestone() == null || mile.getMilestone().length() == 0) {
							LOG.debug("Removing " + mile);
							ensureRemoved(apps.getMilestones().remove(i));
						} else
							mile.setApplication(apps);
					}
				}
			}
			
			// cleanup  TimeSchedule
			if(apps.getTimeSchedules()!=null){
				TimeSchedule tm = apps.getTimeSchedules();
				if(tm!=null){
					/*if (tm.getStartMonthYearPeriod()!=null) {
						DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
						String sDate = "01/" + tm.getStartMonthYearPeriod();
						Date startDate;
							
						try {
							startDate = df.parse(sDate);
							tm.setStartMonthYearPeriod(startDate);
						} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
						
					}*/
					tm.setApplication(apps);
				}		
			}
			
			// cleanup  ProjectSummary
			if(apps.getProjectSummaries()!=null){
				ProjectSummary tm = apps.getProjectSummaries();
				if(tm!=null){
					tm.setApplication(apps);
				}		
			}
			
			// cleanup  SupportType
			if(apps.getSupportTypes()!=null){
				SupportType tm = apps.getSupportTypes();
				if(tm!=null){
					tm.setApplication(apps);
				}		
			}
		}
	}
	
	/**
	 * 
	 */
	@Transactional
	public void cleanupSabbatical(SabbaticalTraining apps) {		
		// cleanup  AdministrativeExperiences
		if(apps.getAdminExperiences()!=null){
			AdministrativeExperience tm = apps.getAdminExperiences();
			if(tm!=null){
				tm.setApplication(apps);
			}		
		}
		
		// cleanup  ProjectSummary
		if(apps.getSabProjectSummaries()!=null){
			SabbaticalProjectSummary tm = apps.getSabProjectSummaries();
			if(tm!=null){
				tm.setApplication(apps);
			}		
		}
			
		// cleanup  SupportType
		if(apps.getSupportTypes()!=null){
			SupportType tm = apps.getSupportTypes();
			if(tm!=null){
				tm.setApplication(apps);
			}		
		}
	}
	
	/**
	 * 
	 */
	@Transactional
	public void cleanup(GroupTraining app) {
		// cleanup  Training Locations
		if(app.getLocations()!=null){
			for (int i = app.getLocations().size() - 1; i >= 0; i--) {
				TrainingLocation tl = app.getLocations().get(i);
				if(tl!=null){
					if (tl.getVenue()==null || tl.getVenue().length()==0) {
						LOG.info("Removing " + tl);
						ensureRemoved(app.getLocations().remove(i));
					} else{
						LOG.info("VENUE " + i + ": " + tl.getVenue());
						tl.setApplication(app);
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

	@Transactional(readOnly = false)
	public void save(ApplicantsBioData cdoBioData, ApplicationStarter appStarter) {
		if(cdoBioData==null)
			return;
		
		//Cleanups
		cleanup(cdoBioData);
		
		if(cdoBioData.getId()!=null){
			LOG.info("MERGE cdoBioData(): " + cdoBioData.getId());
			this.entityManager.merge(cdoBioData);
		}else{
			LOG.info("cdoBioData(): " + cdoBioData);
			LOG.info("INSERT cdoBioData(): " + cdoBioData.getId());
			this.entityManager.persist(cdoBioData);
		}
		
		
		if (cdoBioData != null) {
			if(appStarter!=null){
				HashMap<String, Object> data = new HashMap<String, Object>();
				data.put("announcement", appStarter.getAnnouncement());
				data.put("applicant", cdoBioData);
				data.put("appStarter", appStarter);
				
				try {
					String message = templatingService.fillTemplate("cdobiodata", data);
					sendEmail(cdoBioData, appStarter.getAnnouncement().getTitle() + " Registration Submission from " + cdoBioData.getFirstName() + " " + cdoBioData.getLastName(), message);
						
					message = templatingService.fillTemplate("cdobiodata-notify", data);
					for (User user : this.userService.findByRole("ROLE_REGISTRATION"))
						sendEmail(true, user, appStarter.getAnnouncement().getTitle() + " Registration Submission from " + cdoBioData.getFirstName() + " " + cdoBioData.getLastName(), message);
				} catch (TemplatingException e) {
					LOG.error(e);
					return;
				}
			}
		}
		return;
	}
	
	@Override
	@Transactional(readOnly = false)
	public void save(ApplicantsBioData cdoBioData) {
		if(cdoBioData==null)
			return;
		
		//Cleanups
		cleanup(cdoBioData);
		
		if(cdoBioData.getId()!=null){
			this.entityManager.merge(cdoBioData);
		}else{
			this.entityManager.persist(cdoBioData);
		}
		return;
	}
	
	/**
	 * 
	 */
	@Transactional
	public void cleanup(ApplicantsBioData cdoBioData) {
		// cleanup  EducationAndTraining
		if(cdoBioData!=null){
			if(cdoBioData.getEducationAndTraining()!=null){
				for (int i = cdoBioData.getEducationAndTraining().size() - 1; i >= 0; i--) {
					EducationAndTraining edu = cdoBioData.getEducationAndTraining().get(i);
					if(edu!=null){
						
						if (edu.getNameOfInstitution() == null || edu.getNameOfInstitution().length() == 0) {
							LOG.debug("Removing " + edu);
							ensureRemoved(cdoBioData.getEducationAndTraining().remove(i));
						} else{
							edu.setBiodata(cdoBioData);
						}
					}
				}
			}
			
			
			// cleanup  PreviousEducationAndTraining
			if(cdoBioData.getPreviousEducationAndTraining()!=null){
				for (int i = cdoBioData.getPreviousEducationAndTraining().size() - 1; i >= 0; i--) {
					PreviousEducationAndTraining edu = cdoBioData.getPreviousEducationAndTraining().get(i);
					if(edu!=null){
							
						if (edu.getNameOfInstitution() == null || edu.getNameOfInstitution().length() == 0) {
							LOG.debug("Removing " + edu);
							ensureRemoved(cdoBioData.getPreviousEducationAndTraining().remove(i));
						} else{
							edu.setBiodata(cdoBioData);
						}
					}
				}
			}
			
		
			if(cdoBioData.getLanguageSpoken()!=null){
				// cleanup  LanguageSpoken
				for (int i = cdoBioData.getLanguageSpoken().size() - 1; i >= 0; i--) {
					LanguageSpoken ls = cdoBioData.getLanguageSpoken().get(i);
					if(ls!=null){
						if (ls.getLanguage() == null || ls.getLanguage().length() == 0) {
							LOG.debug("Removing " + ls);
							ensureRemoved(cdoBioData.getLanguageSpoken().remove(i));
						} else
							ls.setBiodata(cdoBioData);
					}
				}
			}
			
			if(cdoBioData.getOtherStudiesAndTraining()!=null){
				// cleanup  OtherStudiesAndTraining
				for (int i = cdoBioData.getOtherStudiesAndTraining().size() - 1; i >= 0; i--) {
					OtherStudiesAndTraining ls = cdoBioData.getOtherStudiesAndTraining().get(i);
					if(ls!=null){
						if ((ls.getTopic() == null || ls.getTopic().length() == 0) && (ls.getPlace() == null || ls.getPlace().length() == 0)) {
							LOG.debug("Removing " + ls);
							ensureRemoved(cdoBioData.getOtherStudiesAndTraining().remove(i));
						} else
							ls.setBiodata(cdoBioData);
					}
				}
			}
			
			if(cdoBioData.getEmploymentHistory()!=null){
				// cleanup EmploymentHistory
				for (int i = cdoBioData.getEmploymentHistory().size() - 1; i >= 0; i--) {
					EmploymentHistory empHistory = cdoBioData.getEmploymentHistory().get(i);
					if(empHistory!=null){
						if (empHistory.getNameOfEmployer() == null || empHistory.getNameOfEmployer().length() == 0) {
							LOG.debug("Removing " + empHistory);
							ensureRemoved(cdoBioData.getEmploymentHistory().remove(i));
						} else
							empHistory.setBiodata(cdoBioData);
					}
				}
			}
			
			if(cdoBioData.getPreviousEmploymentHistory()!=null){
				// cleanup PreviousEmploymentHistory
				for (int i = cdoBioData.getPreviousEmploymentHistory().size() - 1; i >= 0; i--) {
					PreviousEmploymentHistory empHistory = cdoBioData.getPreviousEmploymentHistory().get(i);
					if(empHistory!=null){
						if (empHistory.getNameOfEmployer() == null || empHistory.getNameOfEmployer().length() == 0) {
							LOG.debug("Removing " + empHistory);
							ensureRemoved(cdoBioData.getPreviousEmploymentHistory().remove(i));
						} else
							empHistory.setBiodata(cdoBioData);
					}
				}
			}
		}
	}
	
	@Override
	@Transactional
	public OtherApplicationDetails save(OtherApplicationDetails otherAppDetails) {
		if(otherAppDetails==null)
			return null;
		
		if(otherAppDetails.getId()!=null){
			LOG.info("UPDATE otherAppDetails.getId(): " + otherAppDetails.getId());
			this.entityManager.merge(otherAppDetails);
		}else{
			LOG.info("INSERT otherAppDetails.getId(): " + otherAppDetails.getId());
			this.entityManager.persist(otherAppDetails);
		}
		
		return otherAppDetails;
	}

	@Override
	@Transactional(readOnly = true)
	public ApplicantsBioData findByUser(User user) {
		if (user == null)
			return null;

		try {
			ApplicantsBioData bio = (ApplicantsBioData) this.entityManager.createQuery("from ApplicantsBioData bio where bio.owner=:user").setParameter("user", user).setMaxResults(1)
					.getSingleResult();
			return bio;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public User findUserByEmail(String emailAddress) {
		if (emailAddress == null)
			return null;

		try {
			User u = (User) this.entityManager.createQuery("from User u where u.mail=:email").setParameter("email", emailAddress).setMaxResults(1)
					.getSingleResult();
			u.getAccessTags().size();
			return u;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	@Transactional
	public User save(User user) {
		if(user==null)
			return null;
		
		try {
			List<UserLookup> lookups = null;
			List<UserRole> roles = null;
			
			try {
				lookups = user.getLookups();
				if (lookups != null)
					for (int i = lookups.size() - 1; i >= 0; i--)
						if (lookups.get(i).getIdentifier() == null || lookups.get(i).getIdentifier().trim().length() == 0) {
							UserLookup lookup = lookups.remove(i);
							this.entityManager.remove(lookup);
						} else{
							LOG.info("INNER USER SAVE Identifier user :  " + lookups.get(i).getIdentifier());
							lookups.get(i).setUser(user);
						}

				roles = user.getRoles();
				if (roles != null)
					for (int i = roles.size() - 1; i >= 0; i--)
						if (roles.get(i).getRole() == null || roles.get(i).getRole().trim().length() == 0) {
							UserRole role = roles.remove(i);
							this.entityManager.remove(role);
						} else{
							LOG.info("INNER USER SAVE Identifier user :  " + roles.get(i).getRole());
							roles.get(i).setUser(user);
							roles.get(i).setApplication("training");
						}
			} catch (LazyInitializationException e) {

			}

			if (user.getId() == null) {
				LOG.info("new user id is:  " + user.getId());
				if(roles!=null)
					user.setRoles(roles);
				
				if(lookups!=null)
					user.setLookups(lookups);
				
				entityManager.persist(user);
				LOG.info("new user id is: now persisted!");
			} else {
				// update driver info
				LOG.info("Merging user data for id=" + user.getId());
				if(roles!=null)
					user.setRoles(roles);
				
				if(lookups!=null)
					user.setLookups(lookups);
				
				entityManager.merge(user);
			}
			return user;
		} catch (RuntimeException e) {
			LOG.error(e);
			throw e;
		}
	}
	
	@Override
	@Transactional
	public void delete(User principal, User user, Application app) throws CDOApplicationException {
		if (app == null) {
			LOG.debug("null App passed to delete. Doing nothing.");
			return;
		}
		LOG.warn("Delete App called by " + principal + " on behalf of " + user + " for App " + app.getId());

		if (principal != null && app.getBiodata().getOwner().getId().equals(principal.getId())) {
			deleteApplication(app);
		}

		if (user != null && app.getBiodata().getOwner().getId().equals(user.getId())) {
			deleteApplication(app);
		}
		
		if (user == null && principal == null) {
			deleteApplication(app);
		}
	}

	/**
	 * Permanently remove APP. USE WITH CAUTION!
	 * 
	 * @param ta
	 * @throws CDOApplicationException
	 */
	@Transactional(readOnly = false)
	private void deleteApplication(Application app) throws CDOApplicationException {
		LOG.warn("Deleting App " + app.getId() + ".");
		switch (app.getSubmissionStatus()) {
		case Draft:
			this.entityManager.remove(app);
			return;

		default:
			throw new CDOApplicationException("Cannot delete an application in status " + app.getSubmissionStatus());
		}
	}
	
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void validate(GroupTraining app) throws CDOApplicationException {
		LOG.info("Running cleanup on data before storing.");
		cleanup(app);
	}
	
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void validate(ApplicantsBioData biodata) throws CDOApplicationException {
		LOG.info("Running cleanup on data before storing.");
		cleanup(biodata);
	}
	
	@Override
	@Transactional
	public void delete(User principal, User user, ApplicantsBioData biodata) throws CDOApplicationException {
		if (biodata == null) {
			LOG.debug("null App passed to delete. Doing nothing.");
			return;
		}
		LOG.warn("Delete biodata called by " + principal + " on behalf of " + user + " for Biodata " + biodata.getId());

		if (principal != null && biodata.getOwner().getId().equals(principal.getId())) {
			deleteBiodata(biodata);
		}

		if (user != null && biodata.getOwner().getId().equals(user.getId())) {
			deleteBiodata(biodata);
		}
		
		if (user == null && principal == null) {
			deleteBiodata(biodata);
		}
	}

	/**
	 * Permanently remove APP. USE WITH CAUTION!
	 * 
	 * @param ta
	 * @throws CDOApplicationException
	 */
	@Transactional(readOnly = false)
	private void deleteBiodata(ApplicantsBioData biodata) throws CDOApplicationException {
		LOG.warn("Deleting biodata " + biodata.getId() + ".");
		this.entityManager.remove(biodata);
		return;
	}
	
	@Override
	@Transactional
	public ApplicationStarter save(ApplicationStarter appStarter) {
		if(appStarter==null)
			return null;
		
		if(appStarter.getId()!=null){
			LOG.info("appStarter.getId(): " + appStarter.getId());
			this.entityManager.merge(appStarter);
		}else
			this.entityManager.persist(appStarter);
		
		return appStarter;
	}
	
	@Override
	@Transactional(readOnly=true)
	public ApplicationStarter findAppStarter(Long id) {
		ApplicationStarter appStarter = this.entityManager.find(ApplicationStarter.class, id);
		return appStarter;
	}
	
	@Override
	@Transactional(readOnly=true)
	public ApplicationStarter findAppStarterByKey(String appKey) {
		try{
			return (ApplicationStarter) this.entityManager.createQuery("from ApplicationStarter a " +
		"where a.appKey=:appKey").setParameter("appKey", appKey).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public ApplicantsBioData findBioData(Long id) {
		return this.entityManager.find(ApplicantsBioData.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<GroupTraining> list(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status) {
		return (List<GroupTraining>) this.entityManager.createQuery("select a from GroupTraining a inner join a.announcement an " +
			"where a.announcement.type=:type and a.biodata=:biodata and a.submissionStatus=:status order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc")
			.setParameter("type", type).setParameter("biodata", cdoBioData).setParameter("status", status).getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public ApplicationStarter findAppStarterByKey(ApplicantsBioData cdoBioData) {
		if(cdoBioData==null)
			return null;
		
		LOG.info("cdoBioData ID: " + cdoBioData.getId());
		
		return (ApplicationStarter) this.entityManager.createQuery("from ApplicationStarter a " +
		"where a.biodata=:bio").setParameter("bio", cdoBioData).getSingleResult();
	}

	@Override
	@Transactional(readOnly=true)
	public GroupTraining findApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status) {
		try{
			return (GroupTraining) this.entityManager.createQuery("select a from GroupTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.biodata=:biodata and a.submissionStatus=:status").setParameter("status", status).setParameter("announcement", announcement).setParameter("biodata", cdoBioData).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	//@Override
	//@Transactional
	//public void delete(Application application) {
	//	if(application!=null)
	//		this.entityManager.remove(application);
	//}

	//@Override
	//@Transactional
	//public void delete(Application application) {
	//	if(application!=null)
	//		this.entityManager.remove(application);
	//}
	
	@Override
	@Transactional(readOnly = true)
	public PagedResult<GraduateResearchTraining> listGraduate(int startAt, int maxResults) {
		PagedResult<GraduateResearchTraining> paged = new PagedResult<GraduateResearchTraining>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("from GraduateResearchTraining a " +
				"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(a) from GraduateResearchTraining " +
				"a").getSingleResult());
		return paged;
	}

	@Override
	@Transactional(readOnly = true)
	public PagedResult<NonDegreeTraining> listNonDegree(int startAt, int maxResults) {
		PagedResult<NonDegreeTraining> paged = new PagedResult<NonDegreeTraining>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("from NonDegreeTraining a " +
				"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(a) from NonDegreeTraining " +
				"a").getSingleResult());
		return paged;
	}
	
	@Override
	@Transactional(readOnly = true)
	public GraduateResearchTraining existsGraduate(Announcement announcement, String refNumber) {
		try{
			return (GraduateResearchTraining) this.entityManager.createQuery("select a from GraduateResearchTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.refNumber=:refNumber").setParameter("announcement", announcement).setParameter("refNumber", refNumber).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public NonDegreeTraining existsNonDegree(Announcement announcement, String refNumber) {
		try{
			return (NonDegreeTraining) this.entityManager.createQuery("select a from NonDegreeTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.refNumber=:refNumber").setParameter("announcement", announcement).setParameter("refNumber", refNumber).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public GraduateResearchTraining findGraduate(Long id) {
		if(id==null)
			return null;
		
		return this.entityManager.find(GraduateResearchTraining.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public NonDegreeTraining findNonDegree(Long id) {
		if(id==null)
			return null;
		
		return this.entityManager.find(NonDegreeTraining.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<GraduateResearchTraining> listGraduate() {
		return this.entityManager.createQuery("from GraduateResearchTraining a " +
		"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<NonDegreeTraining> listNonDegree() {
		return this.entityManager.createQuery("from NonDegreeTraining a " +
		"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").getResultList();
	}

	@Override
	public void delete(User principal, User user, GraduateResearchTraining app) throws CDOApplicationException {
		if (app == null) {
			LOG.debug("null App passed to delete. Doing nothing.");
			return;
		}
		LOG.warn("Delete App called by " + principal + " on behalf of " + user + " for App " + app.getId());

		if (principal != null && app.getBiodata().getOwner().getId().equals(principal.getId())) {
			deleteApplication(app);
		}

		if (user != null && app.getBiodata().getOwner().getId().equals(user.getId())) {
			deleteApplication(app);
		}
		
		if (user == null && principal == null) {
			deleteApplication(app);
		}
	}
	
	/**
	 * Permanently remove APP. USE WITH CAUTION!
	 * 
	 * @param ta
	 * @throws CDOApplicationException
	 */
	@Transactional(readOnly = false)
	private void deleteApplication(GraduateResearchTraining app) throws CDOApplicationException {
		LOG.warn("Deleting App " + app.getId() + ".");
		switch (app.getSubmissionStatus()) {
		case Draft:
			this.entityManager.remove(app);
			return;

		default:
			throw new CDOApplicationException("Cannot delete an application in status " + app.getSubmissionStatus());
		}
	}
	
	@Override
	public void delete(User principal, User user, NonDegreeTraining app) throws CDOApplicationException {
		if (app == null) {
			LOG.debug("null App passed to delete. Doing nothing.");
			return;
		}
		LOG.warn("Delete App called by " + principal + " on behalf of " + user + " for App " + app.getId());

		if (principal != null && app.getBiodata().getOwner().getId().equals(principal.getId())) {
			deleteApplication(app);
		}

		if (user != null && app.getBiodata().getOwner().getId().equals(user.getId())) {
			deleteApplication(app);
		}
		
		if (user == null && principal == null) {
			deleteApplication(app);
		}
	}
	
	/**
	 * Permanently remove APP. USE WITH CAUTION!
	 * 
	 * @param ta
	 * @throws CDOApplicationException
	 */
	@Transactional(readOnly = false)
	private void deleteApplication(NonDegreeTraining app) throws CDOApplicationException {
		LOG.warn("Deleting App " + app.getId() + ".");
		switch (app.getSubmissionStatus()) {
		case Draft:
			this.entityManager.remove(app);
			return;

		default:
			throw new CDOApplicationException("Cannot delete an app in status " + app.getSubmissionStatus());
		}
	}
	
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void validate(GraduateResearchTraining app) throws CDOApplicationException {
		cleanupGraduateTraining(app);
	}

	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void validate(NonDegreeTraining app) throws CDOApplicationException {
		cleanupNonDegree(app);
	}

	
	@Override
	public OtherApplicationDetails findOtherAppDetails(GraduateResearchTraining application) {
		LOG.info("Application ID: " + application.getId());
		try{
			return (OtherApplicationDetails) this.entityManager.createQuery("select o from OtherApplicationDetails o " +
		"where o.application=:application").setParameter("application", application).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	public OtherApplicationDetails findOtherAppDetails(NonDegreeTraining application) {
		LOG.info("Application ID: " + application.getId());
		try{
			return (OtherApplicationDetails) this.entityManager.createQuery("select o from OtherApplicationDetails o " +
		"where o.application=:application").setParameter("application", application).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<GraduateResearchTraining> listGraduate(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status) {
		return (List<GraduateResearchTraining>) this.entityManager.createQuery("select a from GraduateResearchTraining a inner join a.announcement an " +
		"where a.announcement.type=:type and a.biodata=:biodata and a.submissionStatus=:status order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc")
		.setParameter("type", type).setParameter("biodata", cdoBioData).setParameter("status", status).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<InternshipTraining> listInternship(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status) {
		return (List<InternshipTraining>) this.entityManager.createQuery("select a from InternshipTraining a inner join a.announcement an " +
		"where a.announcement.type=:type and a.biodata=:biodata and a.submissionStatus=:status order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc")
		.setParameter("type", type).setParameter("biodata", cdoBioData).setParameter("status", status).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<NonDegreeTraining> listNonDegree(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status) {
		return (List<NonDegreeTraining>) this.entityManager.createQuery("select a from NonDegreeTraining a inner join a.announcement an " +
		"where a.announcement.type=:type and a.biodata=:biodata and a.submissionStatus=:status order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc")
		.setParameter("type", type).setParameter("biodata", cdoBioData).setParameter("status", status).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public GraduateResearchTraining findGraduateApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status) {
		try{
			return (GraduateResearchTraining) this.entityManager.createQuery("select a from GraduateResearchTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.biodata=:biodata and a.submissionStatus=:status").setParameter("status", status).setParameter("announcement", announcement).setParameter("biodata", cdoBioData).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public NonDegreeTraining findNonDegreeApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status) {
		try{
			return (NonDegreeTraining) this.entityManager.createQuery("select a from NonDegreeTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.biodata=:biodata and a.submissionStatus=:status").setParameter("status", status).setParameter("announcement", announcement).setParameter("biodata", cdoBioData).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Object> applications(boolean fulldisplay){
		List<Object> group = new ArrayList<Object>();
		//List<Object> graduate = new ArrayList<Object>();
		//List<Object> nondegree = new ArrayList<Object>();
		List<Object> mergeEntities = new ArrayList<Object>();
		
		if(fulldisplay){
			group = (List<Object>) this.entityManager.createQuery("from Application order by createdDate desc limit 10").getResultList();
			
			//if(group.size()>5)
			//	graduate = (List<Object>) this.entityManager.createQuery("from GraduateResearchTraining order by createdDate desc limit 5").getResultList();
			//else
			//	graduate = (List<Object>) this.entityManager.createQuery("from GraduateResearchTraining order by createdDate desc limit 10").getResultList();
			
			//if(graduate.size()>5)
			//	nondegree = (List<Object>) this.entityManager.createQuery("from NonDegreeTraining order by createdDate desc limit 5").getResultList();
			//else
			//	nondegree = (List<Object>) this.entityManager.createQuery("from NonDegreeTraining order by createdDate desc limit 10").getResultList();
		}else{
			group = (List<Object>) this.entityManager.createQuery("from Application order by createdDate desc").getResultList();
			//graduate = (List<Object>) this.entityManager.createQuery("from GraduateResearchTraining order by createdDate desc").getResultList();
			//nondegree = (List<Object>) this.entityManager.createQuery("from NonDegreeTraining order by createdDate desc").getResultList();
		}
		
		mergeEntities.addAll(group);
		//mergeEntities.addAll(graduate);
		//mergeEntities.addAll(nondegree);
		
		Collections.sort(mergeEntities, new NaturalOrderComparator<Object>());
		
		return mergeEntities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PagedResult<Object> listObject(int startAt, int maxResults) {
		List<Object> group = new ArrayList<Object>();
		//List<Object> graduate = new ArrayList<Object>();
		//List<Object> nondegree = new ArrayList<Object>();
		List<Object> allObjects = new ArrayList<Object>();
		PagedResult<Object> mergeEntities = new PagedResult<Object>();
		
		group = (List<Object>) this.entityManager.createQuery("from Application order by createdDate desc").setFirstResult(startAt)
		.setMaxResults(maxResults).getResultList();
		//graduate = (List<Object>) this.entityManager.createQuery("from GraduateResearchTraining order by createdDate desc").setFirstResult(startAt)
		//.setMaxResults(maxResults).getResultList();
		//nondegree = (List<Object>) this.entityManager.createQuery("from NonDegreeTraining order by createdDate desc").setFirstResult(startAt)
		//.setMaxResults(maxResults).getResultList();
		
		allObjects.addAll(group);
		//allObjects.addAll(graduate);
		//allObjects.addAll(nondegree);
		
		Long totalHits = (long) (group.size());// + graduate.size() + nondegree.size());
		
		mergeEntities.setResults(allObjects);
		mergeEntities.setTotalHits(totalHits);
		mergeEntities.setMaxResults(maxResults);
		
		return mergeEntities;
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(GroupTraining application) {
		if(application!=null)
			this.entityManager.remove(application);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(GraduateResearchTraining application) {
		if(application!=null)
			this.entityManager.remove(application);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(NonDegreeTraining application) {
		if(application!=null)
			this.entityManager.remove(application);
	}

	@Override
	@Transactional(readOnly = true)
	public PagedResult<GroupTraining> list(int startAt, int maxResults) {
		PagedResult<GroupTraining> paged = new PagedResult<GroupTraining>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("from GroupTraining a " +
				"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(a) from GroupTraining " +
				"a").getSingleResult());
		return paged;
	}

	@Override
	@Transactional(readOnly = true)
	public OtherApplicationDetails findOtherAppDetails(GroupTraining application) {
		LOG.info("Application ID: " + application.getId());
		try{
			return (OtherApplicationDetails) this.entityManager.createQuery("select o from OtherApplicationDetails o " +
		"where o.application=:application").setParameter("application", application).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public PagedResult<OtherTraining> listOther(int startAt, int maxResults) {
		PagedResult<OtherTraining> paged = new PagedResult<OtherTraining>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("from OtherTraining a " +
				"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(a) from OtherTraining " +
				"a").getSingleResult());
		return paged;
	}

	@Override
	public OtherTraining findOther(Long id) {
		if(id==null)
			return null;
		
		return this.entityManager.find(OtherTraining.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<OtherTraining> listOther() {
		return this.entityManager.createQuery("from OtherTraining a " +
		"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").getResultList();
	}

	@Override
	@Transactional
	public void delete(User principal, User user, OtherTraining app) throws CDOApplicationException {
		if (app == null) {
			LOG.debug("null App passed to delete. Doing nothing.");
			return;
		}
		LOG.warn("Delete App called by " + principal + " on behalf of " + user + " for App " + app.getId());

		if (principal != null && app.getBiodata().getOwner().getId().equals(principal.getId())) {
			deleteApplication(app);
		}

		if (user != null && app.getBiodata().getOwner().getId().equals(user.getId())) {
			deleteApplication(app);
		}
		
		if (user == null && principal == null) {
			deleteApplication(app);
		}
	}
	
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void validate(OtherTraining app) throws CDOApplicationException {
		//cleanupOtherTraining(app);
	}

	@Override
	@Transactional(readOnly = true)
	public OtherApplicationDetails findOtherAppDetails(OtherTraining application) {
		LOG.info("Application ID: " + application.getId());
		try{
			return (OtherApplicationDetails) this.entityManager.createQuery("select o from OtherApplicationDetails o " +
		"where o.application=:application").setParameter("application", application).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<OtherTraining> listOther(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status) {
		return (List<OtherTraining>) this.entityManager.createQuery("select a from OtherTraining a inner join a.announcement an " +
		"where a.announcement.type=:type and a.biodata=:biodata and a.submissionStatus=:status order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc")
		.setParameter("type", type).setParameter("biodata", cdoBioData).setParameter("status", status).getResultList();

	}

	@Override
	@Transactional(readOnly = true)
	public OtherTraining findOtherApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status) {
		try{
			return (OtherTraining) this.entityManager.createQuery("select a from OtherTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.biodata=:biodata and a.submissionStatus=:status").setParameter("status", status).setParameter("announcement", announcement).setParameter("biodata", cdoBioData).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public ApplicationStarter findByAppKeyAndEmail(String appKey, String email) {
		try{
			return (ApplicationStarter) this.entityManager.createQuery("from ApplicationStarter a " +
		"where a.appKey=:appKey and a.email=:email").setParameter("appKey", appKey).setParameter("email", email).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	public Application findApplication(Long id) {
		if(id==null)
			return null;
		
		LOG.info("Application ID: " + id);		
		Application app = this.entityManager.find(Application.class, id);
		return app;
	}
	
	/**
	 * Confirm user's password.
	 * 
	 * @see org.iita.training.service.CDOApplicationServiceService#confirmExistingPassword(java.lang.String)
	 */
	@Override
	@Transactional
	public boolean confirmExistingPassword(User user, String oldPassword) {
		LOG.info("Setting password for " + user.getUsername() + ".");
		
		String pwd = org.springframework.security.util.Sha512DigestUtils.shaHex(oldPassword);
		try{
			Long hit =(Long) this.entityManager.createQuery("select count(a) from User a where username=:username and password=:pwd")
			.setParameter("username", user.getUsername())
			.setParameter("pwd", pwd)
			.getSingleResult();
			
			if(hit>0)
				return true;
			else
				return false;
		}
		catch(NoResultException r){
			return false;
		}
	}
	
	/**
	 * Sets user's password and configures the account to use PASSWORD login instead of LDAP.
	 * 
	 * @see org.iita.par.service.UserService#setPassword(java.lang.String)
	 */
	@Override
	@Transactional
	public void updatePassword(User user, String newPassword) {
		LOG.info("Setting password for " + user.getUsername() + ".");
		if (user.getAuthenticationType().toString()!="PASSWORD") {
			LOG.info("Authentication type set to PASSWORD");
			user.setAuthenticationType(AuthenticationType.PASSWORD);
		}
		user.setPassword(org.springframework.security.util.Sha512DigestUtils.shaHex(newPassword));
		updateLoginData(user);
	}
	
	@Transactional
	private void updateLoginData(User user) {
		try {
			if (user.getId() == null) {
				LOG.debug("new user id is:  " + user.getId());
				entityManager.persist(user);
				LOG.debug("new user id is: now persisted!");
			} else {
				// update driver info
				LOG.trace("Merging user data for id=" + user.getId());
				entityManager.merge(user);
			}
		} catch (RuntimeException e) {
			LOG.error(e);
			throw e;
		}
	}

	@Override
	@Transactional(readOnly=false)
	public IndividualTraining save(IndividualTraining application) throws Exception {
		if(application==null)
			return null;
		
		//Cleaning up the data arrays
		//cleanup(application);

		if (application.getId() == null) {
			application.setRefNumber(this.getNextCDOReferenceNumber());
			this.entityManager.persist(application);
		} else 
			this.entityManager.merge(application);
		
		if(application.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("application", application);
			data.put("applicant", application.getBiodata());
			data.put("announcement", application.getAnnouncement());
		
			try {
				String message = templatingService.fillTemplate("cdoapplication", data);
				sendEmail(application, application.getAnnouncement().getTitle() + " Individual Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
				
				message = templatingService.fillTemplate("cdoapplication-notify", data);
				
				for (User user : this.userService.findByRole("ROLE_APPLICATION"))
					sendEmail(true, user, application.getAnnouncement().getTitle() + " individual Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
			} catch (TemplatingException e) {
				LOG.error(e);
				return null;
			}
		}
		
		return application;
	}

	@Override
	@Transactional
	public SabbaticalTraining save(SabbaticalTraining application) throws Exception {
		if(application==null)
			return null;
		
		//Cleaning up the data arrays
		cleanupSabbatical(application);

		if (application.getId() == null) {
			application.setRefNumber(this.getNextCDOReferenceNumber());
			this.entityManager.persist(application);
		} else{
			LOG.info("MERGING SABBATICAL APPLICATION: " + application);
			this.entityManager.merge(application);
		}
		
		if(application.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("application", application);
			data.put("applicant", application.getBiodata());
			data.put("announcement", application.getAnnouncement());
		
			try {
				String message = templatingService.fillTemplate("cdoapplication", data);
				sendEmail(application, application.getAnnouncement().getTitle() + " Sabbatical Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
				
				message = templatingService.fillTemplate("cdoapplication-notify", data);
				
				for (User user : this.userService.findByRole("ROLE_APPLICATION"))
					sendEmail(true, user, application.getAnnouncement().getTitle() + " Sabbatical Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
			} catch (TemplatingException e) {
				LOG.error(e);
				return null;
			}
		}
		
		return application;
	}

	@Override
	@Transactional(readOnly=false)
	public StaffDevTraining save(StaffDevTraining application) throws Exception {
		if(application==null)
			return null;
		
		//Cleaning up the data arrays
		//cleanup(application);

		if (application.getId() == null) {
			application.setRefNumber(this.getNextCDOReferenceNumber());
			this.entityManager.persist(application);
		} else 
			this.entityManager.merge(application);
		
		if(application.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("application", application);
			data.put("applicant", application.getBiodata());
			data.put("announcement", application.getAnnouncement());
		
			try {
				String message = templatingService.fillTemplate("cdoapplication", data);
				sendEmail(application, application.getAnnouncement().getTitle() + " Staff Development Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
				
				message = templatingService.fillTemplate("cdoapplication-notify", data);
				
				for (User user : this.userService.findByRole("ROLE_APPLICATION"))
					sendEmail(true, user, application.getAnnouncement().getTitle() + " Staff Development Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
			} catch (TemplatingException e) {
				LOG.error(e);
				return null;
			}
		}
		
		return application;
	}

	@Override
	@Transactional(readOnly=false)
	public InHouseTraining save(InHouseTraining application) throws Exception {
		if(application==null)
			return null;
		
		//Cleaning up the data arrays
		//cleanup(application);

		if (application.getId() == null) {
			application.setRefNumber(this.getNextCDOReferenceNumber());
			this.entityManager.persist(application);
		} else 
			this.entityManager.merge(application);
		
		if(application.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("application", application);
			data.put("applicant", application.getBiodata());
			data.put("announcement", application.getAnnouncement());
		
			try {
				String message = templatingService.fillTemplate("cdoapplication", data);
				sendEmail(application, application.getAnnouncement().getTitle() + " In-house Group Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
				
				message = templatingService.fillTemplate("cdoapplication-notify", data);
				
				for (User user : this.userService.findByRole("ROLE_APPLICATION"))
					sendEmail(true, user, application.getAnnouncement().getTitle() + " In-house Group Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
			} catch (TemplatingException e) {
				LOG.error(e);
				return null;
			}
		}
		
		return application;
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(IndividualTraining application) {
		if(application!=null)
			this.entityManager.remove(application);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(SabbaticalTraining application) {
		if(application!=null)
			this.entityManager.remove(application);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(InHouseTraining application) {
		if(application!=null)
			this.entityManager.remove(application);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(StaffDevTraining application) {
		if(application!=null)
			this.entityManager.remove(application);
	}

	@Override
	@Transactional(readOnly=true)
	public PagedResult<IndividualTraining> listIndividual(int startAt, int maxResults) {
		PagedResult<IndividualTraining> paged = new PagedResult<IndividualTraining>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("from IndividualTraining a " +
				"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(a) from Individual " +
				"a").getSingleResult());
		return paged;
	}

	@Override
	@Transactional(readOnly=true)
	public PagedResult<InHouseTraining> listInHouse(int startAt, int maxResults) {
		PagedResult<InHouseTraining> paged = new PagedResult<InHouseTraining>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("from InHouseTraining a " +
				"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(a) from InHouse " +
				"a").getSingleResult());
		return paged;
	}

	@Override
	@Transactional(readOnly=true)
	public PagedResult<StaffDevTraining> listStaffDev(int startAt, int maxResults) {
		PagedResult<StaffDevTraining> paged = new PagedResult<StaffDevTraining>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("from StaffDevTraining a " +
				"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(a) from StaffDev " +
				"a").getSingleResult());
		return paged;
	}

	@Override
	@Transactional(readOnly=true)
	public PagedResult<SabbaticalTraining> listSabbatical(int startAt, int maxResults) {
		PagedResult<SabbaticalTraining> paged = new PagedResult<SabbaticalTraining>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("from SabbaticalTraining a " +
				"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(a) from Sabbatical " +
				"a").getSingleResult());
		return paged;
	}

	@Override
	@Transactional(readOnly=true)
	public IndividualTraining existsIndividual(Announcement announcement, String refNumber) {
		try{
			return (IndividualTraining) this.entityManager.createQuery("select a from IndividualTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.refNumber=:refNumber").setParameter("announcement", announcement).setParameter("refNumber", refNumber).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public StaffDevTraining existsStaffDev(Announcement announcement, String refNumber) {
		try{
			return (StaffDevTraining) this.entityManager.createQuery("select a from StaffDevTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.refNumber=:refNumber").setParameter("announcement", announcement).setParameter("refNumber", refNumber).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public SabbaticalTraining existsSabbatical(Announcement announcement, String refNumber) {
		try{
			return (SabbaticalTraining) this.entityManager.createQuery("select a from SabbaticalTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.refNumber=:refNumber").setParameter("announcement", announcement).setParameter("refNumber", refNumber).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public InHouseTraining existsInHouse(Announcement announcement, String refNumber) {
		try{
			return (InHouseTraining) this.entityManager.createQuery("select a from InHouseTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.refNumber=:refNumber").setParameter("announcement", announcement).setParameter("refNumber", refNumber).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public IndividualTraining findIndividual(Long id) {
		if(id==null)
			return null;
		
		return this.entityManager.find(IndividualTraining.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public InHouseTraining findInHouse(Long id) {
		if(id==null)
			return null;
		
		return this.entityManager.find(InHouseTraining.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public SabbaticalTraining findSabbatical(Long id) {
		if(id==null)
			return null;
		
		return this.entityManager.find(SabbaticalTraining.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public StaffDevTraining findStaffDev(Long id) {
		if(id==null)
			return null;
		
		return this.entityManager.find(StaffDevTraining.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<IndividualTraining> listIndividual() {
		return this.entityManager.createQuery("from IndividualTraining a " +
		"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<SabbaticalTraining> listSabbatical() {
		return this.entityManager.createQuery("from SabbaticalTraining a " +
		"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<StaffDevTraining> listStaffDev() {
		return this.entityManager.createQuery("from StaffDevTraining a " +
		"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<InHouseTraining> listInHouse() {
		return this.entityManager.createQuery("from InHouseTraining a " +
		"order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc").getResultList();
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(User principal, User user, IndividualTraining app) throws CDOApplicationException {
		if (app == null) {
			LOG.debug("null App passed to delete. Doing nothing.");
			return;
		}
		LOG.warn("Delete App called by " + principal + " on behalf of " + user + " for App " + app.getId());

		if (principal != null && app.getBiodata().getOwner().getId().equals(principal.getId())) {
			deleteApplication(app);
		}

		if (user != null && app.getBiodata().getOwner().getId().equals(user.getId())) {
			deleteApplication(app);
		}
		
		if (user == null && principal == null) {
			deleteApplication(app);
		}
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(User principal, User user, StaffDevTraining app) throws CDOApplicationException {
		if (app == null) {
			LOG.debug("null App passed to delete. Doing nothing.");
			return;
		}
		LOG.warn("Delete App called by " + principal + " on behalf of " + user + " for App " + app.getId());

		if (principal != null && app.getBiodata().getOwner().getId().equals(principal.getId())) {
			deleteApplication(app);
		}

		if (user != null && app.getBiodata().getOwner().getId().equals(user.getId())) {
			deleteApplication(app);
		}
		
		if (user == null && principal == null) {
			deleteApplication(app);
		}
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(User principal, User user, SabbaticalTraining app) throws CDOApplicationException {
		if (app == null) {
			LOG.debug("null App passed to delete. Doing nothing.");
			return;
		}
		LOG.warn("Delete App called by " + principal + " on behalf of " + user + " for App " + app.getId());

		if (principal != null && app.getBiodata().getOwner().getId().equals(principal.getId())) {
			deleteApplication(app);
		}

		if (user != null && app.getBiodata().getOwner().getId().equals(user.getId())) {
			deleteApplication(app);
		}
		
		if (user == null && principal == null) {
			deleteApplication(app);
		}
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(User principal, User user, InHouseTraining app) throws CDOApplicationException {
		if (app == null) {
			LOG.debug("null App passed to delete. Doing nothing.");
			return;
		}
		LOG.warn("Delete App called by " + principal + " on behalf of " + user + " for App " + app.getId());

		if (principal != null && app.getBiodata().getOwner().getId().equals(principal.getId())) {
			deleteApplication(app);
		}

		if (user != null && app.getBiodata().getOwner().getId().equals(user.getId())) {
			deleteApplication(app);
		}
		
		if (user == null && principal == null) {
			deleteApplication(app);
		}
	}

	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void validate(InHouseTraining app) throws CDOApplicationException {
		//cleanup(app);
	}

	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void validate(StaffDevTraining app) throws CDOApplicationException {
		//cleanup(app);
	}

	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void validate(IndividualTraining app) throws CDOApplicationException {
		//cleanup(app);
	}

	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void validate(SabbaticalTraining app) throws CDOApplicationException {
		cleanupSabbatical(app);
	}

	@Override
	@Transactional(readOnly=true)
	public OtherApplicationDetails findOtherAppDetails(InHouseTraining application) {
		LOG.info("Application ID: " + application.getId());
		try{
			return (OtherApplicationDetails) this.entityManager.createQuery("select o from OtherApplicationDetails o " +
		"where o.application=:application").setParameter("application", application).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public OtherApplicationDetails findOtherAppDetails(IndividualTraining application) {
		LOG.info("Application ID: " + application.getId());
		try{
			return (OtherApplicationDetails) this.entityManager.createQuery("select o from OtherApplicationDetails o " +
		"where o.application=:application").setParameter("application", application).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public OtherApplicationDetails findOtherAppDetails(SabbaticalTraining application) {
		LOG.info("Application ID: " + application.getId());
		try{
			return (OtherApplicationDetails) this.entityManager.createQuery("select o from OtherApplicationDetails o " +
		"where o.application=:application").setParameter("application", application).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public OtherApplicationDetails findOtherAppDetails(StaffDevTraining application) {
		LOG.info("Application ID: " + application.getId());
		try{
			return (OtherApplicationDetails) this.entityManager.createQuery("select o from OtherApplicationDetails o " +
		"where o.application=:application").setParameter("application", application).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<IndividualTraining> listIndividual(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status) {
		return (List<IndividualTraining>) this.entityManager.createQuery("select a from IndividualTraining a inner join a.announcement an " +
		"where a.announcement.type=:type and a.biodata=:biodata and a.submissionStatus=:status order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc")
		.setParameter("type", type).setParameter("biodata", cdoBioData).setParameter("status", status).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<InHouseTraining> listInHouse(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status) {
		return (List<InHouseTraining>) this.entityManager.createQuery("select a from InHouseTraining a inner join a.announcement an " +
		"where a.announcement.type=:type and a.biodata=:biodata and a.submissionStatus=:status order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc")
		.setParameter("type", type).setParameter("biodata", cdoBioData).setParameter("status", status).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<SabbaticalTraining> listSabbatical(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status) {
		return (List<SabbaticalTraining>) this.entityManager.createQuery("select a from SabbaticalTraining a inner join a.announcement an " +
		"where a.announcement.type=:type and a.biodata=:biodata and a.submissionStatus=:status order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc")
		.setParameter("type", type).setParameter("biodata", cdoBioData).setParameter("status", status).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<StaffDevTraining> listStaffDev(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status) {
		return (List<StaffDevTraining>) this.entityManager.createQuery("select a from StaffDevTraining a inner join a.announcement an " +
		"where a.announcement.type=:type and a.biodata=:biodata and a.submissionStatus=:status order by a.createdDate, a.biodata.lastName, a.biodata.firstName desc")
		.setParameter("type", type).setParameter("biodata", cdoBioData).setParameter("status", status).getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public IndividualTraining findIndividualApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status) {
		try{
			return (IndividualTraining) this.entityManager.createQuery("select a from IndividualTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.biodata=:biodata and a.submissionStatus=:status").setParameter("status", status).setParameter("announcement", announcement).setParameter("biodata", cdoBioData).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public InHouseTraining findInHouseApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status) {
		try{
			return (InHouseTraining) this.entityManager.createQuery("select a from InHouseTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.biodata=:biodata and a.submissionStatus=:status").setParameter("status", status).setParameter("announcement", announcement).setParameter("biodata", cdoBioData).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public SabbaticalTraining findSabbaticalApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status) {
		try{
			return (SabbaticalTraining) this.entityManager.createQuery("select a from SabbaticalTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.biodata=:biodata and a.submissionStatus=:status").setParameter("status", status).setParameter("announcement", announcement).setParameter("biodata", cdoBioData).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public StaffDevTraining findStaffDevApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status) {
		try{
			return (StaffDevTraining) this.entityManager.createQuery("select a from StaffDevTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.biodata=:biodata and a.submissionStatus=:status").setParameter("status", status).setParameter("announcement", announcement).setParameter("biodata", cdoBioData).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional
	public ApplicantsBioData findStaff(String staffId, String email) {
		User user = null;
		
		try{
			user = (User) this.entityManager.createQuery("from User where staffId=:staffId and mail=:email").setParameter("staffId", staffId).setParameter("email", email).getSingleResult();
			
			if(user==null){
				user = this.userService.findByStaffID(staffId, true);
				if(user!=null){
					String username = null;
					if(user!=null)
						username = user.getUsername();
					
					user = (User) this.entityManager.createQuery("from User where (username=:username and mail=:email) or (staffId=:staffId and mail=:email)").setParameter("username", username).setParameter("staffId", staffId).setParameter("email", email).getSingleResult();
						
					if(user!=null){
						ApplicantsBioData bio = new ApplicantsBioData();
						bio.setCorrespondenceEmailAddress(user.getMail());
						bio.setFirstName(user.getFirstName());
						bio.setLastName(user.getLastName());
						bio.setPassword(user.getPassword());
						bio.setOwner(user);
						this.entityManager.persist(bio);
						return bio;
					}
				}
			}else{
				ApplicantsBioData bio = new ApplicantsBioData();
				bio.setCorrespondenceEmailAddress(user.getMail());
				bio.setFirstName(user.getFirstName());
				bio.setLastName(user.getLastName());
				bio.setPassword(user.getPassword());
				bio.setOwner(user);
				this.entityManager.persist(bio);
				return bio;
			}
		}catch(Exception e){
			user = this.userService.findByStaffID(staffId, true);
			if(user!=null){
				String username = null;
				
				if(user!=null)
					username = user.getUsername();
				
				user = (User) this.entityManager.createQuery("from User where (username=:username and mail=:email) or (staffId=:staffId and mail=:email)").setParameter("username", username).setParameter("staffId", staffId).setParameter("email", email).getSingleResult();
					
				if(user!=null){
					ApplicantsBioData bio = new ApplicantsBioData();
					bio.setCorrespondenceEmailAddress(user.getMail());
					bio.setFirstName(user.getFirstName());
					bio.setLastName(user.getLastName());
					bio.setPassword(user.getPassword());
					bio.setOwner(user);
					this.entityManager.persist(bio);
					return bio;
				}
			}
			return null;
		}
		return null;
	}
	
	/**
	 * @throws CDOApplicationException
	 * @see org.iita.trainingunit.applications.service.CDOApplicationService#getAwaitingApproval(org.iita.security.model.User, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public PagedResult<Application> getAwaitingApproval(User user, int startAt, int maxResults) throws CDOApplicationException {
		if (user == null) {
			throw new CDOApplicationException("User not provided");
		}

		int requesterCount = ((Long) this.entityManager.createQuery(
				"select count(*) from Application app where (app.status=:appStatus and app.announcement.requester=:user) or (app.status=:appStatusDir and app.announcement.programDirector=:user)")
				.setParameter("appStatus", APPLICATIONSTATUS.WAITING).setParameter("appStatusDir", APPLICATIONSTATUS.WAITINGFORDIRECTOR).setParameter("user", user).getSingleResult()).intValue();
		LOG.debug("Total linemanager/director pending: " + requesterCount);

		int budgetCount = ((Long) this.entityManager
				.createQuery(
						"select count(distinct bc.application) from Approval bc where bc.application.status=:appStatus and bc.nextApprover=:user AND (bc.status=1 OR bc.status=0)")
				.setParameter("appStatus", APPLICATIONSTATUS.WAITING).setParameter("user", user).getSingleResult()).intValue();
		LOG.debug("Total budget pending: " + budgetCount);

		PagedResult<Application> pagedAwaitingApproval = new PagedResult<Application>(startAt, maxResults);
		pagedAwaitingApproval.setTotalHits(requesterCount + budgetCount);
		LOG.debug("Total pending: " + pagedAwaitingApproval.getTotalHits());

		// line manager
		pagedAwaitingApproval.setResults(this.entityManager.createQuery(
				"from Application app where (app.status=:appStatus and app.announcement.requester=:user) or (app.status=:appStatusDir and app.announcement.programDirector=:user) order by app.announcement.deadline desc").setParameter("appStatus",
						APPLICATIONSTATUS.WAITING).setParameter("appStatusDir", APPLICATIONSTATUS.WAITINGFORDIRECTOR).setParameter("user", user).setFirstResult(startAt).setMaxResults(maxResults).getResultList());
		LOG.debug("Total pending (1): " + pagedAwaitingApproval.getResults().size());
		
		// the rest
		pagedAwaitingApproval
				.getResults()
				.addAll(
						this.entityManager
								.createQuery(
										"select distinct bc.application from Approval bc where bc.application.status=:appStatus and bc.nextApprover=:user AND (bc.status=1 OR bc.status=0) ORDER BY bc.application.announcement.deadline DESC")
								.setParameter("appStatus", APPLICATIONSTATUS.WAITING).setParameter("user", user).setFirstResult(
										startAt - requesterCount < 0 ? 0 : startAt - requesterCount).setMaxResults(
										maxResults - pagedAwaitingApproval.getResults().size()).getResultList());
		LOG.debug("Total pending (2): " + pagedAwaitingApproval.getResults().size());

		return pagedAwaitingApproval;
	}
	
	/**
	 * Checks next approver in the Application BudgetCode list
	 * 
	 */
	@Override
	public List<User> getWaitingFor(Application app) {
		List<User> waitingFor = new ArrayList<User>();
		switch (app.getStatus()) {
		case WAITINGFORCDO:
			waitingFor.addAll(userService.findByRole("ROLE_TRAININGUNITHEAD"));
			break;
		case WAITINGFORDIRECTOR:
			waitingFor.add(app.getAnnouncement().getProgramDirector());
			break;
		case WAITINGFORCFO:
			waitingFor.addAll(userService.findByRole("ROLE_CFO"));
			break;
		case WAITING:
			for (BudgetCode bc : app.getInternalApprovals().getBudgetCodes()) {
				if (bc.getNextApprover() != null && bc.getStatus() == BCodeStatus.WAITING) {
					waitingFor.add(bc.getNextApprover());
				}
			}
			break;
		}
		return waitingFor;
	}
	
	/**
	 * @throws CDOApplicationException
	 * @see org.iita.trainingunit.applications.service.CDOApplicationService#getMyBcApplications(org.iita.security.model.User, int, int)
	 */
	@Override
	@Transactional(readOnly = true)
	public PagedResult<Application> getMyBcApplications(User user, int startAt, int maxResults) throws CDOApplicationException {
		if (user == null) {
			throw new CDOApplicationException("User not provided");
		}
		PagedResult<Application> paged = new PagedResult<Application>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery(
				"select distinct bc.application from Approval bc where bc.requester=:user ORDER BY bc.application.announcement.deadline DESC").setParameter("user", user)
				.setFirstResult(startAt).setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager
				.createQuery("select count(distinct bc.application) from Approval bc where bc.requester=:user").setParameter("user", user)
				.getSingleResult());
		return paged;
	}

	@Override
	//@Secured( { "ROLE_CFO", "ROLE_ADMIN", "ROLE_READALL", "BF_USERACCESS", "ROLE_TRAININGUNITHEAD" })
	@Transactional(readOnly = true)
	public Application load(Long id) {
		return this.entityManager.find(Application.class, id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public PagedResult<Application> getApplications(int startAt, int maxResults, APPLICATIONSTATUS... statuslist) {
		return getApplications(startAt, maxResults, null, statuslist);
	}

	@Override
	@Transactional(readOnly = true)
	public PagedResult<Application> getApplications(int startAt, int maxResults, String orderBy, APPLICATIONSTATUS... statuslist) {
		if (orderBy == null)
			orderBy = "refNumber DESC";
		PagedResult<Application> paged = new PagedResult<Application>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		Collection<Object> list = org.iita.util.Collections.fromArray(statuslist);
		paged.setResults(this.entityManager.createQuery("from Application app where app.status in (:statuslist) ORDER BY " + orderBy).setParameter(
				"statuslist", list).setFirstResult(startAt).setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(*) from Application app where app.status in (:statuslist)").setParameter(
				"statuslist", list).getSingleResult());
		return paged;
	}
	
	@Override
	@Transactional(readOnly = true)
	public PagedResult<Application> getApplications(User owner, int startAt, int maxResults, APPLICATIONSTATUS... statuslist) {
		PagedResult<Application> paged = new PagedResult<Application>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		Collection<Object> list = org.iita.util.Collections.fromArray(statuslist);
		paged.setResults(this.entityManager.createQuery(
				"from Application app where app.biodata.owner=:owner and app.status in (:statuslist) ORDER BY app.refNumber DESC")
				.setParameter("statuslist", list).setParameter("owner", owner).setFirstResult(startAt).setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery(
				"select count(*) from Application app where app.biodata.owner=:owner and app.status in (:statuslist)").setParameter(
				"statuslist", list).setParameter("owner", owner).getSingleResult());
		return paged;
	}
	
	/**
	 * @see org.iita.trainingunit.applications.service.CDOApplicationService#sendReminders(org.iita.security.model.User, org.iita.trainingunit.applications.model.Application)
	 */
	@Override
	@Secured( { "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN", "ROLE_CFO", "ROLE_MONITOR", "ROLE_MANAGER", "ROLE_DDG" })
	public void sendReminders(User user, Application app) {
		this.notificationService.notifyByStatus(app, null);
	}

	@Override
	@Transactional(readOnly = true)
	public InternshipTraining findInternship(Long applicationId) {
		if(applicationId==null)
			return null;
		
		return this.entityManager.find(InternshipTraining.class, applicationId);
	}

	@Override
	@Transactional(readOnly = true)
	public InternshipTraining findInternshipApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status) {
		try{
			return (InternshipTraining) this.entityManager.createQuery("select a from InternshipTraining a inner join a.announcement an " +
		"where a.announcement=:announcement and a.biodata=:biodata and a.submissionStatus=:status").setParameter("status", status).setParameter("announcement", announcement).setParameter("biodata", cdoBioData).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional
	public InternshipTraining save(InternshipTraining application) {
		if(application==null)
			return null;
		
		//Cleaning up the data arrays
		cleanupInternshipTraining(application);

		if (application.getId() == null) {
			application.setRefNumber(this.getNextCDOReferenceNumber());
			this.entityManager.persist(application);
		} else 
			this.entityManager.merge(application);
		
		//handleSelectedLocations(selectedLocations,application);
		
		if(application.getSubmissionStatus().equals(SUBMISSIONSTATUS.Submitted)){
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("application", application);
			data.put("applicant", application.getBiodata());
			data.put("announcement", application.getAnnouncement());
		
			try {
				String message = templatingService.fillTemplate("cdointernapplication", data);
				sendEmail(application, application.getAnnouncement().getTitle() + " Internship Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
				
				message = templatingService.fillTemplate("cdointernapplication-notify", data);
				for (User user : this.userService.findByRole("ROLE_APPLICATION"))
					sendEmail(true, user, application.getAnnouncement().getTitle() + " Internship Application Submission from " + application.getBiodata().getFirstName() + " " + application.getBiodata().getLastName(), message);
			} catch (TemplatingException e) {
				LOG.error(e);
				return null;
			}
		}
		
		return application;
	}
	
	/**
	 * 
	 */
	@Transactional
	public void cleanupInternshipTraining(InternshipTraining apps) {
		// cleanup  EducationAndTraining
		if(apps.getBiodata()!=null){
			if(apps.getBiodata().getLanguageSpoken()!=null){
				// cleanup  LanguageSpoken
				for (int i = apps.getBiodata().getLanguageSpoken().size() - 1; i >= 0; i--) {
					LanguageSpoken ls = apps.getBiodata().getLanguageSpoken().get(i);
					if(ls!=null){
						if (ls.getLanguage() == null || ls.getLanguage().length() == 0) {
							LOG.debug("Removing " + ls);
							ensureRemoved(apps.getBiodata().getLanguageSpoken().remove(i));
						} else
							ls.setBiodata(apps.getBiodata());
					}
				}
			}			
		}
		
		if(apps.getInternshipEducationAndExperience()!=null){
			// cleanup EmploymentHistory
			for (int i = apps.getInternshipEducationAndExperience().size() - 1; i >= 0; i--) {
				InternshipEducationAndExperience eduExperience = apps.getInternshipEducationAndExperience().get(i);
				if(eduExperience!=null){
					if (eduExperience.getNameOfInstitution() == null || eduExperience.getNameOfInstitution().length() == 0) {
						LOG.debug("Removing " + eduExperience);
						ensureRemoved(apps.getInternshipEducationAndExperience().remove(i));
					} else{
						LOG.info("ADDING EduExp: " + eduExperience);
						eduExperience.setApplication(apps);
					}
				}
			}
		}
		
		if(apps.getInternshipWorkExperience()!=null){
			// cleanup EmploymentHistory
			for (int i = apps.getInternshipWorkExperience().size() - 1; i >= 0; i--) {
				InternshipWorkExperience workExperience = apps.getInternshipWorkExperience().get(i);
				if(workExperience!=null){
					if (workExperience.getInstitution() == null || workExperience.getInstitution().length() == 0) {
						LOG.debug("Removing " + workExperience);
						ensureRemoved(apps.getInternshipWorkExperience().remove(i));
					} else{
						LOG.info("ADDING WrkExp: " + workExperience);
						workExperience.setApplication(apps);
					}
				}
			}
		}
		
		// cleanup  SupportType
		if(apps.getSupportTypes()!=null){
			SupportType tm = apps.getSupportTypes();
			if(tm!=null){
				tm.setApplication(apps);
			}		
		}
	}
	
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public InternalApprovals validate(InternalApprovals internalApproval) throws CDOApplicationException {
		LOG.debug("Running cleanup on data before storing.");
		cleanup(internalApproval);

		// lookup cost center owners
		lookupCostCenters(internalApproval);
		
		if(internalApproval.getId()!=null)
			this.entityManager.merge(internalApproval);
		else
			this.entityManager.persist(internalApproval);
		
		
		//Save application against internalApproval
		Application app = internalApproval.getApplication();		
		app.setInternalApprovals(internalApproval);
		this.entityManager.merge(app);
		
		return internalApproval;
		
		
	}
	
	/**
	 * Looks up budget holders and sets all APP cost centers to WAITING + sets owner and approver to holder of cost center
	 * 
	 * @param internalApproval
	 * @throws CDOApplicationException
	 */
	@Transactional
	private void lookupCostCenters(InternalApprovals internalApproval) throws CDOApplicationException {
		
		for (BudgetCode bc : internalApproval.getBudgetCodes()) {
			String costCenterCode = bc.getCode().replace("CC", "").replace(" ", "");
			User ccUser = null;
			
			LOG.info("Looking up cost center " + costCenterCode);
			CostCenter costCenter = this.entityManager.find(CostCenter.class, costCenterCode);
			if (costCenter != null) {
				LOG.debug("\tFound cost center " + costCenter);
				
				// set budget holder
				bc.setCode(bc.getCode().replace("CC", "").replace(" ", ""));
				bc.setCostCenter(costCenter);
				
				if(costCenter.getHolder()!=null){
					if(costCenter.getHolder().getMail().equalsIgnoreCase("P.BRAMEL@CGIAR.ORG")){
						if(costCenter.getCode().equals("1085"))
							ccUser=this.userService.lookup("S.SHOLOLA@CGIAR.ORG");
						else
							ccUser=this.userService.lookup("R.ASIEDU@CGIAR.ORG");
					}else if(costCenter.getHolder().getMail().equalsIgnoreCase("L.MENON@CGIAR.ORG")){
						if(costCenter.getCode().equals("1085"))
							ccUser=this.userService.lookup("S.SHOLOLA@CGIAR.ORG");
						else
							ccUser=this.userService.lookup("N.SANGINGA@CGIAR.ORG");
					}else
						ccUser = costCenter.getHolder();
				}else{
					if(costCenter.getRollupUser()!=null){
						if(costCenter.getRollupUser().getMail().equalsIgnoreCase("P.BRAMEL@CGIAR.ORG")){
							if(costCenter.getCode().equals("1085"))
								ccUser=this.userService.lookup("S.SHOLOLA@CGIAR.ORG");
							else
								ccUser=this.userService.lookup("R.ASIEDU@CGIAR.ORG");
						}else if(costCenter.getRollupUser().getMail().equalsIgnoreCase("L.MENON@CGIAR.ORG")){
							if(costCenter.getCode().equals("1085"))
								ccUser=this.userService.lookup("S.SHOLOLA@CGIAR.ORG");
							else
								ccUser=this.userService.lookup("N.SANGINGA@CGIAR.ORG");
						}else
							ccUser = costCenter.getRollupUser();
					}					
				}
				
				bc.setBudgetHolder(ccUser);
				if (bc.getBudgetHolder() == null) {
					// set budget holder to rollup user if no holder specified!
					bc.setBudgetHolder(costCenter.getRollupUser());
				}
				if (bc.getBudgetHolder() == null) {
					// what to do when there's no holder information available??
				}

				// next approver is the budget holder
				bc.setNextApprover(bc.getBudgetHolder());

				if (bc.getNextApprover() != null)
					bc.setStatus(BCodeStatus.WAITING);
				else {
					LOG.error("No approver for " + costCenter);
					bc.setStatus(BCodeStatus.NEW);
				}
			} else {
				// no cost center
				LOG.error("No cost center record found for " + costCenterCode);
				throw new CDOApplicationException("Cost center " + costCenterCode + " not found!");
			}
		}
	}
	
	/**
	 * 
	 */
	@Transactional
	public void cleanup(InternalApprovals internalApproval) {

		for (int i = internalApproval.getCoreCompetencies().size() - 1; i >= 0; i--) {
			CoreCompetency comp = internalApproval.getCoreCompetencies().get(i);
			if (comp.getName() == null || comp.getName().length() == 0) {
				LOG.debug("Removing " + comp);
				ensureRemoved(internalApproval.getCoreCompetencies().remove(i));
			} else 
				comp.setInternalApproval(internalApproval);
		}
		
		for (int i = internalApproval.getCrps().size() - 1; i >= 0; i--) {
			Crp crp = internalApproval.getCrps().get(i);
			if (crp.getName() == null || crp.getName().length() == 0) {
				LOG.debug("Removing " + crp);
				ensureRemoved(internalApproval.getCrps().remove(i));
			} else 
				crp.setInternalApproval(internalApproval);
		}
		
		for (int i = internalApproval.getHubs().size() - 1; i >= 0; i--) {
			Hub hub = internalApproval.getHubs().get(i);
			if (hub.getName() == null || hub.getName().length() == 0) {
				LOG.debug("Removing " + hub);
				ensureRemoved(internalApproval.getHubs().remove(i));
			} else 
				hub.setInternalApproval(internalApproval);
		}
		
		for (int i = internalApproval.getBudgetCodes().size() - 1; i >= 0; i--) {
			BudgetCode budgetCode = internalApproval.getBudgetCodes().get(i);
			if (budgetCode.getCode() == null || budgetCode.getCode().length() == 0) {
				LOG.debug("Removing " + budgetCode);
				ensureRemoved(internalApproval.getBudgetCodes().remove(i));
			} else {
				budgetCode.setCode(budgetCode.getCode().replace("CC", "").replace(" ", ""));
				budgetCode.setInternalApproval(internalApproval);
			}
		}
	}
}
