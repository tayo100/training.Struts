/**
 * training.Struts Feb 4, 2010
 */
package org.iita.trainingunit.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.iita.crm.model.AnnouncementTag;
import org.iita.crm.model.ApplicationTag;
import org.iita.crm.model.Document;
import org.iita.crm.model.EmailContact;
import org.iita.crm.model.Organization;
import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerPersonContact;
import org.iita.crm.model.Person;
import org.iita.crm.model.TrainingProgramDocument;
import org.iita.crm.service.CRMException;
import org.iita.crm.service.CoreCRMServiceImpl;
import org.iita.security.model.User;
import org.iita.security.service.UserService;
import org.iita.service.EmailService;
import org.iita.service.TemplatingException;
import org.iita.service.TemplatingService;
import org.iita.service.XLSDataImportService;
import org.iita.service.impl.XLSImportException;
import org.iita.struts.webfile.ServerFile;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.model.Announcement.STATUS;
import org.iita.trainingunit.announcements.model.TrainingLocation;
import org.iita.trainingunit.announcements.model.TrainingProposal;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.model.BCodeStatus;
import org.iita.trainingunit.applications.model.BudgetCode;
import org.iita.trainingunit.applications.model.Application.APPLICATIONSTATUS;
import org.iita.trainingunit.applications.service.impl.CDOApplicationException;
import org.iita.trainingunit.iya.model.IYATrainingAnnouncement;
import org.iita.trainingunit.model.Alert;
import org.iita.trainingunit.model.Alert.AlertType;
import org.iita.trainingunit.model.Alert.NotifyStatus;
import org.iita.trainingunit.model.Alumni;
import org.iita.trainingunit.model.Attendance;
import org.iita.trainingunit.model.Attendance.Gender;
import org.iita.trainingunit.model.CoreCompetency;
import org.iita.trainingunit.model.Crp;
import org.iita.trainingunit.model.Funding;
import org.iita.trainingunit.model.Hub;
import org.iita.trainingunit.model.Selection;
import org.iita.trainingunit.model.SubProgram;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.TraineeEducationalInfo;
import org.iita.trainingunit.model.TraineeTag;
import org.iita.trainingunit.model.Trainer;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.model.TrainingProgramTag;
import org.iita.trainingunit.service.TrainingUnitService;
import org.iita.util.DeleteFileAfterCloseInputStream;
import org.iita.util.PagedResult;
import org.springframework.security.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mobreza
 * 
 */
public class TrainingUnitServiceImpl extends CoreCRMServiceImpl implements TrainingUnitService {
	static final Log LOG = LogFactory.getLog(TrainingUnitServiceImpl.class);
	static final String[] FIELDS = new String[] { "" };
	private String traineeStorage;
	private String groupStorage;
	private XLSDataImportService importService;
	private EmailService emailService;
	private TemplatingService templatingService;
	private UserService userService;
	
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
	 * @param importService the importService to set
	 */
	public void setXlsImportService(XLSDataImportService importService) {
		this.importService = importService;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Set trainee file storage downloadDirectory
	 * 
	 * @param traineeStorage the traineeStorage to set
	 */
	public void setTraineeStorage(String traineeStorage) {
		this.traineeStorage = traineeStorage;
	}

	/**
	 * Set group file storage downloadDirectory
	 * 
	 * @param traineeStorage the traineeStorage to set
	 */
	public void setGroupStorage(String groupStorage) {
		this.groupStorage = groupStorage;
	}
	
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public Trainee registerAlumniTrainee(Trainee trainee) {
		this.entityManager.persist(trainee);
		return trainee;
	}

	@SuppressWarnings("static-access")
	@Override
	@Transactional
	@Secured({ "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void registerTrainee(Trainee trainee) {
		this.entityManager.persist(trainee);
		Calendar firstAlert = GregorianCalendar.getInstance(), lastAlert = GregorianCalendar.getInstance();

		if (trainee.getStartDate() != null && trainee.getEndDate() != null) {
			Alert notify = new Alert();

			firstAlert.setTime(trainee.getStartDate());
			firstAlert.add(firstAlert.MONTH, 3);
			notify.setAlertDate(firstAlert.getTime());

			notify.setBody("Dear " + trainee.getPerson().getFullName()
					+ ", you are required to submit your training progress report to the Training Unit using the attached form");
			notify.setStatus(NotifyStatus.PENDING);
			notify.setSubject("Training Progress Report");
			notify.setTrainee(trainee);
			notify.setType(AlertType.REPORT);

			if (trainee.getExtensionDate() != null) {
				this.entityManager.persist(notify);

				firstAlert.setTime(trainee.getExtensionDate());
				firstAlert.add(lastAlert.MONTH, -3);
				notify.setAlertDate(lastAlert.getTime());

				this.entityManager.persist(notify);
			} else {
				this.entityManager.persist(notify);

				firstAlert.setTime(trainee.getEndDate());
				firstAlert.add(lastAlert.MONTH, -3);
				notify.setAlertDate(lastAlert.getTime());

				this.entityManager.persist(notify);
			}
		}
	}

	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public Trainee loadTrainee(Long id) {
		Trainee trainee = this.entityManager.find(Trainee.class, id);
		return trainee;
	}

	/**
	 * @see org.iita.trainingunit.service.TraineeService#listTrainees(org.iita.crm.model.Person)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public List<Trainee> listTrainees(Person person) {
		return this.entityManager.createQuery("from Trainee t where t.person=:person order by t.extensionDate, t.endDate desc").setParameter("person", person)
				.getResultList();
	}

	/**
	 * @see org.iita.trainingunit.service.TrainerService#listTrainers(org.iita.crm.model.Person)
	 */
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public List<Trainer> listTrainers(Person person) {
		return this.entityManager.createQuery("from Trainer t where t.person=:person").setParameter("person", person).getResultList();
	}

	/**
	 * @see org.iita.trainingunit.service.TraineeService#listTrainees(java.util.Date, java.util.Date)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public List<Trainee> listTrainees(Calendar dateFrom, Calendar dateTo) {
		return this.entityManager
				.createQuery(
						"from Trainee t where (t.extensionDate is null and (:dateFrom between t.startDate and t.endDate or :dateTo between t.startDate and t.endDate or t.startDate between :dateFrom and :dateTo)) "
								+ "or (t.extensionDate is not null and (:dateFrom between t.startDate and t.extensionDate or :dateTo between t.startDate and t.extensionDate or t.startDate between :dateFrom and :dateTo))"
								+ "order by t.extensionDate, t.endDate").setParameter("dateFrom", dateFrom.getTime()).setParameter("dateTo", dateTo.getTime())
				.getResultList();
	}
	
	/**
	 * @see org.iita.trainingunit.service.TraineeService#listTrainees(java.util.Date, java.util.Date)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public List<Trainee> listTrainees(User user, Calendar dateFrom, Calendar dateTo) {
		return this.entityManager
				.createQuery(
						"select t.trainee from Trainer t where ((t.trainee.extensionDate is null and (:dateFrom between t.trainee.startDate and t.trainee.endDate or :dateTo between t.trainee.startDate and t.trainee.endDate or t.trainee.startDate between :dateFrom and :dateTo)) "
								+ "or (t.trainee.extensionDate is not null and (:dateFrom between t.trainee.startDate and t.trainee.extensionDate or :dateTo between t.trainee.startDate and t.trainee.extensionDate or t.trainee.startDate between :dateFrom and :dateTo))) and t.person.user=:user"
								+ " order by t.trainee.extensionDate, t.trainee.endDate").setParameter("user", user).setParameter("dateFrom", dateFrom.getTime()).setParameter("dateTo", dateTo.getTime())
				.getResultList();
	}

	/**
	 * @see org.iita.trainingunit.service.TraineeService#listSupervisions(org.iita.crm.model.Person)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured({"ROLE_READALL", "BF_USERACCESS"})
	public List<Trainee> listSupervisions(Person person) {
		return this.entityManager.createQuery(
				"select distinct (t) from Trainee t inner join t.supervisors s where s.person=:person order by t.extensionDate desc, t.endDate desc")
				.setParameter("person", person).getResultList();
	}
		
	/**
	 * @see org.iita.trainingunit.service.TraineeService#listSupervisions(org.iita.crm.model.Person)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured({"ROLE_CRM", "ROLE_READALL", "BF_USERACCESS"})
	public List<TrainingProposal> listTrainingProposalTrainers(Person person) {
		return this.entityManager.createQuery(
				"select distinct (t) from TrainingProposal t inner join t.trainers s where s.person=:person order by t.deadline desc")
				.setParameter("person", person).getResultList();
	}
	
	/**
	 * @see org.iita.trainingunit.service.TraineeService#listSupervisions(org.iita.crm.model.Person)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured({"ROLE_CRM", "ROLE_READALL", "BF_USERACCESS"})
	public List<Announcement> listAnnouncementTrainers(Person person) {
		return this.entityManager.createQuery(
				"select distinct (t) from Announcement t inner join t.trainers s where s.person=:person order by t.deadline desc")
				.setParameter("person", person).getResultList();
	}

	/**
	 * @see org.iita.trainingunit.service.TrainerService#registerTrainer(org.iita.trainingunit.model.Trainer)
	 */
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void registerTrainer(Trainer trainer) {
		this.entityManager.persist(trainer);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<TraineeEducationalInfo> loadEduInfo(Person person) {
		return this.entityManager.createQuery("from TraineeEducationalInfo t where t.person=:person").setParameter("person", person).getResultList();
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void update(TraineeEducationalInfo traineeEducationalInfo) {
		if (traineeEducationalInfo.getId() == null) {
			this.entityManager.persist(traineeEducationalInfo);
		} else {
			this.entityManager.merge(traineeEducationalInfo);
		}
	}

	/**
	 * @see org.iita.trainingunit.service.TraineeService#loadTrainers(org.iita.trainingunit.model.Trainee)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Trainer> loadTrainers(Trainee trainee) {
		return this.entityManager.createQuery("select t.trainers from Trainee t where t=:trainee").setParameter("trainee", trainee).getResultList();
	}

	/**
	 * @see org.iita.trainingunit.service.TrainingProgramService#registerTrainingProgram(java.lang.String)
	 */
	@SuppressWarnings("static-access")
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public TrainingProgram registerTrainingProgram(String title) {
		TrainingProgram program = new TrainingProgram();
		program.setTitle(title);
		this.entityManager.persist(program);

		Calendar firstAlert = GregorianCalendar.getInstance();

		if (program.getEndDate() != null) {
			Alert notify = new Alert();

			firstAlert.setTime(program.getEndDate());
			firstAlert.add(firstAlert.MONTH, 1);
			notify.setAlertDate(firstAlert.getTime());

			notify.setBody("Dear All, you are required to submit your training progress report to the Training Unit using the attached form");
			notify.setStatus(NotifyStatus.PENDING);
			notify.setSubject("Training Progress Report");
			notify.setGroup(program);
			notify.setType(AlertType.REPORT);

			this.entityManager.persist(notify);
		}

		return program;
	}

	/**
	 * @see org.iita.trainingunit.service.TrainingProgramService#loadTrainingProgram(java.lang.Long)
	 */
	@Override
	@Transactional
	@Secured( { "ROLE_TRAININGUNITHEAD", "ROLE_CRM", "BF_USERACCESS" })
	public TrainingProgram loadTrainingProgram(Long id) {
		return this.entityManager.find(TrainingProgram.class, id);
	}
	
	/**
	 * @see org.iita.trainingunit.service.TrainingProgramService#loadTrainingProposal(java.lang.Long)
	 */
	@Override
	@Transactional
	@Secured( { "ROLE_USER", "ROLE_CRM", "BF_USERACCESS" })
	public TrainingProposal loadTrainingProposal(Long id) {
		return this.entityManager.find(TrainingProposal.class, id);
	}
	
	/**
	 * @see org.iita.trainingunit.service.TrainingProgramService#loadAnnouncement(java.lang.Long)
	 */
	@Override
	@Transactional
	@Secured( { "ROLE_USER", "ROLE_CRM", "BF_USERACCESS" })
	public Announcement loadAnnouncement(Long id) {
		return this.entityManager.find(Announcement.class, id);
	}
	
	/**
	 * @see org.iita.trainingunit.service.TrainingProgramService#loadAnnouncement(java.lang.Long)
	 */
	@Override
	@Transactional
	@Secured( { "ROLE_USER", "ROLE_CRM", "BF_USERACCESS" })
	public IYATrainingAnnouncement loadIYAAnnouncement(Long id) {
		return this.entityManager.find(IYATrainingAnnouncement.class, id);
	}

	/**
	 * @see org.iita.trainingunit.service.TrainingProgramService#listTrainingPrograms(java.util.Date, java.util.Date)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured( { "ROLE_TRAININGUNITHEAD", "ROLE_CRM", "BF_USERACCESS" })
	public List<TrainingProgram> listTrainingPrograms(Calendar dateFrom, Calendar dateTo) {
		// LOG.debug("KENNNET Date From: " + dateFrom + " Date To: " + dateTo);
		return this.entityManager
				.createQuery(
						"from TrainingProgram t where (:dateFrom between t.startDate and t.endDate or :dateTo between t.startDate and t.endDate or t.startDate between :dateFrom and :dateTo) order by t.endDate desc")
				.setParameter("dateFrom", dateFrom.getTime()).setParameter("dateTo", dateTo.getTime()).getResultList();
	}
	
	/**
	 * @see org.iita.trainingunit.service.TrainingProgramService#listTrainingPrograms(user, java.util.Date, java.util.Date)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured( { "ROLE_TRAININGUNITHEAD", "ROLE_CRM", "BF_USERACCESS" })
	public List<TrainingProgram> listTrainingPrograms(User user, Calendar dateFrom, Calendar dateTo) {
		// LOG.debug("KENNNET Date From: " + dateFrom + " Date To: " + dateTo);
		return this.entityManager
				.createQuery(
						"select t.group from Trainer t where (:dateFrom between t.group.startDate and t.group.endDate or :dateTo between t.group.startDate and t.group.endDate or t.group.startDate between :dateFrom and :dateTo) and t.person.user=:user order by t.group.endDate desc")
				.setParameter("user", user).setParameter("dateFrom", dateFrom.getTime()).setParameter("dateTo", dateTo.getTime()).getResultList();
	}
	
	/**
	 * @see org.iita.trainingunit.service.TrainingProgramService#listTrainingPrograms(org.iita.crm.model.Person)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured( { "ROLE_TRAININGUNITHEAD", "ROLE_CRM", "BF_USERACCESS" })
	public List<TrainingProgram> listTrainingPrograms(Person person) {
		return this.entityManager.createQuery(
				"select distinct (t) from TrainingProgram t inner join t.trainers tr where tr.person=:person order by t.lastUpdated desc").setParameter(
				"person", person).getResultList();
	}

	/**
	 * @see org.iita.trainingunit.service.TrainingProgramService#update(org.iita.trainingunit.model.TrainingProgram)
	 */
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void update(TrainingProgram program, String[] selectedCrps, String[] selectedHubs, String[] selectedCoreCompetencies, String[] selectedSubPrograms) {
		if (program.getId() == null)
			this.entityManager.persist(program);
		else
			this.entityManager.merge(program);
		
		if(selectedCrps!=null)
			if(selectedCrps.length > 0)
				this.addCrps(null, program, selectedCrps);
		
		if(selectedHubs!=null)
			if(selectedHubs.length > 0)
				this.addHubs(null, program, selectedHubs);
		
		if(selectedCoreCompetencies!=null)
			if(selectedCoreCompetencies.length > 0)
				this.addCoreCompetencies(null, program, selectedCoreCompetencies);
		
		if(selectedSubPrograms!=null)
			if(selectedSubPrograms.length > 0)
				this.addSubPrograms(null, program, selectedSubPrograms);
	}

	/**
	 * @see org.iita.trainingunit.service.TraineeService#update(org.iita.trainingunit.model.Trainee)
	 */
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void update(Trainee trainee, String[] selectedCrps, String[] selectedHubs, String[] selectedCoreCompetencies, String[] selectedSubPrograms) {
		if (trainee.getId() == null)
			this.entityManager.persist(trainee);
		else
			this.entityManager.merge(trainee);
		
		if(selectedCrps!=null)
			if(selectedCrps.length > 0)
				this.addCrps(trainee, null, selectedCrps);
		
		if(selectedHubs!=null)
			if(selectedHubs.length > 0)
				this.addHubs(trainee, null, selectedHubs);
		
		if(selectedCoreCompetencies!=null)
			if(selectedCoreCompetencies.length > 0)
				this.addCoreCompetencies(trainee, null, selectedCoreCompetencies);
		
		if(selectedSubPrograms!=null)
			if(selectedSubPrograms.length > 0)
				this.addSubPrograms(trainee, null, selectedSubPrograms);
	}
	
	@Transactional
	private void addCrps(Trainee trainee, TrainingProgram trainingProgram, String[] selectedCrps){
		if(trainee != null){
			this.clearCrps(trainee, null);
			if(selectedCrps!=null){
				if(selectedCrps.length>0){
					for(String crpName : selectedCrps){
						Crp crp = new Crp();
						crp.setTrainee(trainee);
						crp.setName(crpName);
						this.entityManager.persist(crp);
					}
				}
			}
		}else if(trainingProgram != null){
			this.clearCrps(null, trainingProgram);
			if(selectedCrps!=null){
				if(selectedCrps.length>0){
					for(String crpName : selectedCrps){
						Crp crp = new Crp();
						crp.setTrainingProgram(trainingProgram);
						crp.setName(crpName);
						this.entityManager.persist(crp);
					}
				}
			}
		}
	}
	
	@Transactional
	private void clearCrps(Trainee trainee, TrainingProgram trainingProgram){
		if(trainee != null){
			for (int i = trainee.getCrps().size() - 1; i >= 0; i--) {
				Crp crp = trainee.getCrps().get(i);
				LOG.debug("Removing " + crp);
				ensureRemoved(trainee.getCrps().remove(i));
			}
		}else if(trainingProgram != null){
			for (int i = trainingProgram.getCrps().size() - 1; i >= 0; i--) {
				Crp crp = trainingProgram.getCrps().get(i);
				LOG.debug("Removing " + crp);
				ensureRemoved(trainingProgram.getCrps().remove(i));
			}
		}
	}
	
	@Transactional
	private void addHubs(Trainee trainee, TrainingProgram trainingProgram, String[] selectedHubs){
		if(trainee != null){
			this.clearHubs(trainee, null);
			if(selectedHubs!=null){
				if(selectedHubs.length>0){
					for(String hubName : selectedHubs){
						Hub hub = new Hub();
						hub.setTrainee(trainee);
						hub.setName(hubName);
						this.entityManager.persist(hub);
					}
				}
			}
		}else if(trainingProgram != null){
			this.clearHubs(null, trainingProgram);
			if(selectedHubs!=null){
				if(selectedHubs.length>0){
					for(String hubName : selectedHubs){
						Hub hub = new Hub();
						hub.setTrainingProgram(trainingProgram);
						hub.setName(hubName);
						this.entityManager.persist(hub);
					}
				}
			}
		}
	}
	
	@Transactional
	private void clearHubs(Trainee trainee, TrainingProgram trainingProgram){
		if(trainee != null){
			for (int i = trainee.getHubs().size() - 1; i >= 0; i--) {
				Hub hub = trainee.getHubs().get(i);
				LOG.debug("Removing " + hub);
				ensureRemoved(trainee.getHubs().remove(i));
			}
		}else if(trainingProgram != null){
			for (int i = trainingProgram.getHubs().size() - 1; i >= 0; i--) {
				Hub hub = trainingProgram.getHubs().get(i);
				LOG.debug("Removing " + hub);
				ensureRemoved(trainingProgram.getHubs().remove(i));
			}
		}
	}
	
	@Transactional
	private void addCoreCompetencies(Trainee trainee, TrainingProgram trainingProgram, String[] selectedCoreCompetencies){
		if(trainee != null){
			this.clearCoreCompetencies(trainee, null);
			if(selectedCoreCompetencies!=null){
				if(selectedCoreCompetencies.length>0){
					for(String compName : selectedCoreCompetencies){
						CoreCompetency comp = new CoreCompetency();
						comp.setTrainee(trainee);
						comp.setName(compName);
						this.entityManager.persist(comp);
					}
				}
			}
		}else if(trainingProgram != null){
			this.clearCoreCompetencies(null, trainingProgram);
			if(selectedCoreCompetencies!=null){
				if(selectedCoreCompetencies.length>0){
					for(String compName : selectedCoreCompetencies){
						CoreCompetency comp = new CoreCompetency();
						comp.setTrainingProgram(trainingProgram);
						comp.setName(compName);
						this.entityManager.persist(comp);
					}
				}
			}
		}
	}
	
	@Transactional
	private void clearCoreCompetencies(Trainee trainee, TrainingProgram trainingProgram){
		if(trainee != null){
			for (int i = trainee.getCoreCompetencies().size() - 1; i >= 0; i--) {
				CoreCompetency comp = trainee.getCoreCompetencies().get(i);
				LOG.debug("Removing " + comp);
				ensureRemoved(trainee.getCoreCompetencies().remove(i));
			}
		}else if(trainingProgram != null){
			for (int i = trainingProgram.getCoreCompetencies().size() - 1; i >= 0; i--) {
				CoreCompetency comp = trainingProgram.getCoreCompetencies().get(i);
				LOG.debug("Removing " + comp);
				ensureRemoved(trainingProgram.getCoreCompetencies().remove(i));
			}
		}
	}
	
	@Transactional
	private void addSubPrograms(Trainee trainee, TrainingProgram trainingProgram, String[] selectedSubPrograms){
		if(trainee != null){
			this.clearSubPrograms(trainee, null);
			if(selectedSubPrograms!=null){
				if(selectedSubPrograms.length>0){
					for(String subName : selectedSubPrograms){
						SubProgram sub = new SubProgram();
						sub.setTrainee(trainee);
						sub.setName(subName);
						this.entityManager.persist(sub);
					}
				}
			}
		}else if(trainingProgram != null){
			this.clearSubPrograms(null, trainingProgram);
			if(selectedSubPrograms!=null){
				if(selectedSubPrograms.length>0){
					for(String subName : selectedSubPrograms){
						SubProgram sub = new SubProgram();
						sub.setTrainingProgram(trainingProgram);
						sub.setName(subName);
						this.entityManager.persist(sub);
					}
				}
			}
		}
	}
	
	@Transactional
	private void clearSubPrograms(Trainee trainee, TrainingProgram trainingProgram){
		if(trainee != null){
			for (int i = trainee.getSubPrograms().size() - 1; i >= 0; i--) {
				SubProgram sub = trainee.getSubPrograms().get(i);
				LOG.debug("Removing " + sub);
				ensureRemoved(trainee.getSubPrograms().remove(i));
			}
		}else if(trainingProgram != null){
			for (int i = trainingProgram.getSubPrograms().size() - 1; i >= 0; i--) {
				SubProgram sub = trainingProgram.getSubPrograms().get(i);
				LOG.debug("Removing " + sub);
				ensureRemoved(trainingProgram.getSubPrograms().remove(i));
			}
		}
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void registerFunding(Funding funding) {
		this.entityManager.persist(funding);
	}
	
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public Funding registerAlumniFunding(Funding funding) {
		this.entityManager.persist(funding);
		LOG.warn("TrainingUnitServiceImpl Persisted Funding: " + funding.getId());
		return funding;
	}

	/**
	 * @see org.iita.trainingunit.service.TraineeService#getTraineeFiles(org.iita.trainingunit.model.Trainee)
	 */
	@Override
	public List<ServerFile> getTraineeFiles(Trainee trainee, String subDirectory) {
		try {
			return ServerFile.getServerFiles(getTraineeFileDirectory(trainee), subDirectory);
		} catch (IOException e) {
			// thrown if there's trouble accessing things
			LOG.error(e);
			return null;
		}
	}

	/**
	 * @throws IOException
	 * @see org.iita.trainingunit.service.TraineeService#getTraineeFile(org.iita.trainingunit.model.Trainee, java.lang.String, java.lang.String)
	 */
	@Override
	public ServerFile getTraineeFile(Trainee trainee, String directory, String fileName) throws IOException {
		LOG.debug("Root downloadDirectory: " + this.traineeStorage);
		LOG.info("Fetching " + fileName + " from " + directory + " for trainee " + trainee);
		try {
			return ServerFile.getServerFile(getTraineeFileDirectory(trainee), directory, fileName);
		} catch (IOException e) {
			LOG.info(e);
			throw e;
		}
	}

	/**
	 * @throws FileNotFoundException
	 * @see org.iita.trainingunit.service.TraineeService#getTraineeFileDirectory()
	 */
	@Override
	public File getTraineeFileDirectory(Trainee trainee) throws FileNotFoundException {
		if (trainee == null)
			throw new FileNotFoundException("No trainee directory for null trainees");
		if (this.traineeStorage == null)
			throw new FileNotFoundException("Trainee storage directory not configured.");
		File directory = new File(this.traineeStorage);
		directory = new File(directory, trainee.getId().toString());

		LOG.debug("Trainee directory of " + trainee + " is " + directory);
		return directory;
	}

	/**
	 * @see org.iita.trainingunit.service.TrainingProgramService#getTrainingProgramFiles(org.iita.trainingunit.model.TrainingProgram)
	 */
	@Override
	public List<ServerFile> getTrainingProgramFiles(TrainingProgram trainingProgram, String subDirectory) {
		try {
			return ServerFile.getServerFiles(getTrainingProgramFileDirectory(trainingProgram), subDirectory);
		} catch (IOException e) {
			// thrown if there's trouble accessing things
			LOG.error(e);
			return null;
		}
	}
	
	/**
	 * @see org.iita.trainingunit.service.TrainingProgramService#getTrainingProgramFiles(org.iita.trainingunit.model.TrainingProgram)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void updateAllTrainingProgramFiles() {
		//HashMap<String[], String[]> data =  new HashMap<String[], String[]>();
		
		List<TrainingProgram> trainingPrograms = (List<TrainingProgram>) this.entityManager.createQuery("from TrainingProgram order by title asc").getResultList();
		LOG.info("trainingPrograms list for file persistence " + trainingPrograms.size());
		for(TrainingProgram trainingProgram : trainingPrograms){
			try {
				List<ServerFile> serverFiles = ServerFile.getServerFiles(getTrainingProgramFileDirectory(trainingProgram));
				
				if(serverFiles.size()>0){
					LOG.info("Number of files found for " + trainingProgram + " is " + serverFiles.size());
					for(ServerFile file : serverFiles){
						Document doc = new Document();
						
						//LOG.info("File getTitle: " + file.getTitle());
						//LOG.info("File getFile: " + file.getFile());
						//LOG.info("File getDownloadLink: " + file.getDownloadLink());
						//int pos = file.getFile().toString().lastIndexOf(".");
						//LOG.info("File getType: " + file.getFile().toString().substring(pos+1,file.getFile().toString().length()).toUpperCase());
						
						doc.setTitle(file.getTitle());
						int filePos = 0;
						if(file.getDownloadLink()==null){
							filePos = file.getFile().toString().lastIndexOf("/");
							doc.setFilePath(file.getFile().toString().substring(filePos+1,file.getFile().toString().length()));
						}else{
							filePos = file.getDownloadLink().toString().lastIndexOf("/");
							doc.setFilePath(file.getDownloadLink().toString().substring(filePos+1,file.getDownloadLink().toString().length()));
						}
						int pos = file.getFile().toString().lastIndexOf(".");
						doc.setType(file.getFile().toString().substring(pos+1,file.getFile().toString().length()).toUpperCase());
						
						doc.setFile(file.getFile().toString());
						
						this.entityManager.persist(doc);
						
						TrainingProgramDocument tpdoc = new TrainingProgramDocument();
						
						tpdoc.setEntity(trainingProgram);
						tpdoc.setDocument(doc);
						this.entityManager.persist(tpdoc);
					}
						//StringBuilder sb = new StringBuilder();
						
						//for(ServerFile file : serverFiles){
						//	sb.append("<a href='").append(file.getDownloadLink()).append("' target='_blank'>").append(file.getTitle()).append("</a>");
						//}
						//data.put("fileTitle", sb.toString());
						//data.put("programTitle", trainingProgram.getTitle());
				}
			} catch (IOException e) {
				// thrown if there's trouble accessing things
				LOG.error(e);
				//return null;
			}
		}
		
		//return data;
	}

	/**
	 * @throws IOException
	 * @see org.iita.trainingunit.service.TrainingProgramService#getTrainingProgramFile(org.iita.trainingunit.model.TrainingProgram, java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public ServerFile getTrainingProgramFile(TrainingProgram trainingProgram, String directory, String fileName) throws IOException {
		LOG.debug("Root downloadDirectory: " + this.groupStorage);
		LOG.info("Fetching " + fileName + " from " + directory + " for group " + trainingProgram);
		try {
			return ServerFile.getServerFile(getTrainingProgramFileDirectory(trainingProgram), directory, fileName);
		} catch (IOException e) {
			LOG.info(e);
			throw e;
		}
	}

	/**
	 * @throws FileNotFoundException
	 * @see org.iita.trainingunit.service.TrainingProgramService#getTrainingProgramFileDirectory()
	 */
	@Override
	public File getTrainingProgramFileDirectory(TrainingProgram trainingProgram) throws FileNotFoundException {
		if (trainingProgram == null)
			throw new FileNotFoundException("No group directory for null groups");
		if (this.groupStorage == null)
			throw new FileNotFoundException("Group storage not configured");

		File directory = new File(this.groupStorage);
		directory = new File(directory, trainingProgram.getId().toString());

		LOG.debug("Group directory of " + trainingProgram + " is " + directory);
		return directory;
	}

	@Override
	@Transactional
	public Funding loadFunding(Long id) {
		Funding funding = this.entityManager.find(Funding.class, id);
		return funding;
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void removeTraineeFunding(Trainee trainee, Funding funding) {
		if (funding != null) {
			if (trainee.getFundings().remove(funding)) {
				this.entityManager.merge(trainee);
			}
		}
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void removeProgramFunding(TrainingProgram trainingProgram, Funding funding) {
		if (funding != null) {
			if (trainingProgram.getFundings().remove(funding)) {
				this.entityManager.merge(trainingProgram);
			}
		}
	}

	@Override
	@Transactional
	public void removeSupervisor(Trainer trainer) {
		LOG.debug("SUPERVISOR: " + trainer.getPerson().getFullName());
		if (trainer != null) {
			this.entityManager.remove(trainer);
		}
	}

	@Override
	@Transactional
	public Trainer loadTrainer(Long id) {
		Trainer trainer = this.entityManager.find(Trainer.class, id);
		return trainer;
	}

	/**
	 * Merge records: move information left and right
	 * 
	 * @throws ClassNotFoundException
	 * @throws TrainingUnitDataException
	 * 
	 * @see org.iita.trainingunit.service.TrainingUnitService#merge(org.iita.trainingunit.service.TrainingUnitService.MergeEntity,
	 *      org.iita.trainingunit.service.TrainingUnitService.MergeEntity)
	 */
	/*@Override
	@Transactional
	public void merge(MergeEntity left, MergeEntity right) throws ClassNotFoundException, TrainingUnitDataException {
		List<Object> preservedLeft = new ArrayList<Object>();
		List<Object> preservedRight = new ArrayList<Object>();

		for (int i = 0; i < left.getPreserveClass().size(); i++) {
			Long id = left.getPreserveId().get(i);
			String clazz = left.getPreserveClass().get(i);
			LOG.info("Preserving left " + id + " of " + clazz);
			Object entity = this.find(Class.forName(clazz), id);
			if (entity == null)
				throw new TrainingUnitDataException("Could not find entity " + clazz + " with id " + id);
			preservedLeft.add(entity);
			mergeAssign(left.getEntity(), right.getEntity(), entity);
		}

		for (int i = 0; i < right.getPreserveClass().size(); i++) {
			Long id = right.getPreserveId().get(i);
			String clazz = right.getPreserveClass().get(i);
			LOG.info("Preserving right " + id + " of " + clazz);
			Object entity = this.find(Class.forName(clazz), id);
			if (entity == null)
				throw new TrainingUnitDataException("Could not find entity " + clazz + " with id " + id);
			preservedRight.add(entity);
			if (preservedLeft.contains(entity)) {
				// need to copy
				mergeCopy(right.getEntity(), entity);
			} else {
				// assign
				mergeAssign(right.getEntity(), left.getEntity(), entity);
			}
		}
	}*/

	/**
	 * Creates a copy of entity and assigns it to owner
	 * 
	 * @param owner
	 * @param entity
	 */
	/*private void mergeCopy(Object owner, Object entity) {

	}*/

	/**
	 * Assigns entity to owner
	 * 
	 * @param owner
	 * @param entity
	 */
	/*private void mergeAssign(Object owner, Object otherOwner, Object entity) {
		if (owner instanceof Person) {
			mergeAssignPerson((Person) owner, (Person) otherOwner, entity);
		} else if (owner instanceof Organization) {
			mergeAssignOrganization((Organization) owner, (Organization) otherOwner, entity);
		}
	}*/

	/*private void mergeAssignPerson(Person person, Person otherPerson, Object entity) {
		if (entity instanceof Contact) {
			Contact contact = (Contact) entity;
			Person previousOwner = contact.getPerson();
			if (previousOwner.getLastAddress() == entity) {
				previousOwner.setLastAddress(null);
			}
			if (previousOwner.getLastEmail() == entity) {
				previousOwner.setLastEmail(null);
			}
			if (previousOwner.getLastPhone() == entity) {
				previousOwner.setLastPhone(null);
			}
			contact.setPerson(person);
			person.setLastContact(contact);
			this.entityManager.merge(previousOwner);
			this.entityManager.merge(person);
			this.entityManager.merge(contact);
		}

		if (entity instanceof Trainee) {
			Trainee trainee = (Trainee) entity;
			trainee.setPerson(person);
			this.entityManager.merge(trainee);
		}

		if (entity instanceof Trainer) {
			Trainer trainer = (Trainer) entity;
			trainer.setPerson(person);
			this.entityManager.merge(trainer);
		}

		if (entity instanceof Affiliation) {
			Affiliation affiliation = (Affiliation) entity;
			Person previousOwner = affiliation.getPerson();
			if (previousOwner.getLastAffiliation() == affiliation) {
				previousOwner.setLastAffiliation(null);
				this.entityManager.merge(previousOwner);
			}
			affiliation.setPerson(person);
			person.setLastAffiliation(affiliation);
			this.entityManager.merge(person);
		}

		if (entity instanceof TrainingProgram) {
			TrainingProgram program = (TrainingProgram) entity;
			for (Trainer trainer : program.getTrainers()) {
				if (trainer.getPerson().getId().equals(otherPerson.getId())) {
					trainer.setPerson(person);
				}
			}
			this.entityManager.merge(program);
		}

		this.entityManager.merge(person);
	}*/

	
	/*private void mergeAssignOrganization(Organization organization, Organization otherOrganization, Object entity) {

		if (entity instanceof Contact) {
			Contact contact = (Contact) entity;
			Organization previousOwner = contact.getOrganization();

			contact.setOrganization(organization);
			this.entityManager.merge(previousOwner);
			this.entityManager.merge(contact);
		}

		if (entity instanceof Trainee) {
			Trainee trainee = (Trainee) entity;
			trainee.setUniversity(organization);
			this.entityManager.merge(trainee);
		}

		if (entity instanceof Affiliation) {
			Affiliation affiliation = (Affiliation) entity;
			Organization previousOrganization = affiliation.getOrganization();
			if (previousOrganization.getAffiliations().contains(affiliation)) {
				previousOrganization.getAffiliations().add(affiliation);
				this.entityManager.merge(previousOrganization);
			}
			affiliation.setOrganization(organization);
			organization.getAffiliations().add(affiliation);
			this.entityManager.merge(organization);
		}

		this.entityManager.merge(organization);
	}*/

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void createAlert(Alert alert) {
		this.entityManager.persist(alert);
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void removeAlert(Alert alert) {
		this.entityManager.remove(alert);
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public Alert createAlert(Date alertDate, AlertType alertType, String subject, String body, Trainee trainee) {
		Alert alert = new Alert();
		alert.setAlertDate(alertDate);
		alert.setBody(body);
		alert.setType(alertType);
		alert.setTrainee(trainee);
		alert.setSubject(subject);
		alert.setStatus(NotifyStatus.PENDING);
		this.entityManager.persist(alert);
		return alert;
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public Alert createAlert(Date alertDate, AlertType alertType, String subject, String body, TrainingProgram program) {
		Alert alert = new Alert();
		alert.setAlertDate(alertDate);
		alert.setBody(body);
		alert.setType(alertType);
		alert.setGroup(program);
		alert.setSubject(subject);
		alert.setStatus(NotifyStatus.PENDING);
		this.entityManager.persist(alert);
		return alert;
	}

	/**
	 * @throws IOException
	 * @see org.iita.trainingunit.service.XLSService#getTemplateStream(java.util.List)
	 */
	@Override
	public InputStream getXLSTemplateStream(TrainingProgram group) throws IOException {

		InputStream templateStream = TrainingUnitServiceImpl.class.getClassLoader().getResourceAsStream(
				"org/iita/trainingunit/service/impl/GroupTraining-Attendance-template.xls");
		HSSFWorkbook wb = new HSSFWorkbook(templateStream);
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row = sheet.getRow(0);
		HSSFCell cell = row.getCell(0);

		if (cell == null)
			row.createCell(0);
		cell.setCellValue(new HSSFRichTextString(group.getTitle()));

		cell = sheet.getRow(2).getCell(1);
		cell.setCellValue(group.getStartDate().toString());

		cell = sheet.getRow(3).getCell(1);
		cell.setCellValue(group.getEndDate().toString());

		cell = sheet.getRow(4).getCell(1);
		cell.setCellValue(group.getLocation());

		File file = File.createTempFile("export", ".xls");
		FileOutputStream fs = new FileOutputStream(file);
		wb.write(fs);
		fs.flush();
		fs.close();
		return new DeleteFileAfterCloseInputStream(file);
	}

	/**
	 * @throws IOException
	 * @see org.iita.trainingunit.service.XLSService#getTemplateStream(java.util.List)
	 */
	@Override
	public InputStream getPDFTemplateStream() throws IOException {

		InputStream templateStream = TrainingUnitServiceImpl.class.getClassLoader().getResourceAsStream(
				"org/iita/trainingunit/service/impl/IITA-Attendancesheets.pdf");

		return templateStream;
	}

	@Override
	@Transactional
	public void importXLSAttendance(List<Attendance> attendances) {
		for (Attendance attendance : attendances) {
			this.entityManager.persist(attendance);
		}
	}

	/**
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws XLSImportException
	 * @see org.iita.trainingunit.service.XLSService#importXLSOutputs(java.io.File)
	 */
	@Override
	public List<Attendance> previewXLSAttendance(TrainingProgram trainingProgram, File file) throws FileNotFoundException, IOException, XLSImportException {
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));

		List<Object[]> rowData = this.importService.getObjectsFromXLS(workbook.getSheetAt(0), 6);
		List<Attendance> attendances = new ArrayList<Attendance>();
		for (Object[] row : rowData) {
			LOG.debug("Reading Email: " + row[6]);
			Attendance attendance = getAttendance(row);
			if (attendance != null) {
				LOG.debug("Reading Address: " + attendance.getAddress());
				attendance.setTrainingProgram(trainingProgram);
				attendances.add(attendance);
			}
		}

		return attendances;
	}

	/**
	 * @param row
	 * @return
	 */
	private Attendance getAttendance(Object[] row) {
		Attendance attendance = new Attendance();

		int i = 0;
		for (Object x : row) {
			LOG.debug("" + i++ + ": " + x);
		}

		if (row[0] != null) {
			attendance.setLastName((String) row[0]);
			attendance.setFirstName((String) row[1]);
			
			String gender = row[2].toString();
			
			if (gender.toLowerCase().equals("male") || gender.toLowerCase().equals("m"))
				attendance.setGender(Gender.MALE);
			if (gender.toLowerCase().equals("female") || gender.toLowerCase().equals("f"))
				attendance.setGender(Gender.FEMALE);

			// Checks if DOB value is an instance of date object
			if (row[3] instanceof Date)
				attendance.setDob((Date) row[3]);

			attendance.setDesignation((String) row[4]);
			
			if(row[5]!=null)
				attendance.setPhone((String) row[5].toString());
			else
				attendance.setPhone(null);
			
			attendance.setEmail((String) row[6]);
			attendance.setAddress((String) row[7]);
			attendance.setNationality((String) row[8]);
			attendance.setCountryOfResidence((String) row[9]);
			attendance.setEducation((String) row[10]);
			attendance.setInstituteAffiliation((String) row[11]);
			attendance.setOther((String) row[12]);
			
			
			if (row.length > 13 && row[13] != null) {
				if(row[13] instanceof Boolean){
					Boolean present = (Boolean) row[13];
					attendance.setPresent(present.booleanValue());
				}else if(row[13] instanceof String)
					if(row[13].equals("Yes") || row[13].equals("Y") || row[13].equals("T"))
						attendance.setPresent(true);
					else
						attendance.setPresent(false);
			}else
				attendance.setPresent(false);
			

			//LOG.debug("CHECK PRESENT: " + present);

			// Checks if Attendance Date value is an instance of date object
			if (row.length > 14 && row[14] instanceof Date)
				attendance.setAttendanceDate((Date) row[14]);

			attendance.setBackground((String) row[15]);

			return attendance;
		} else
			return null;
	}

	/**
	 * Adds tag to TraineeTag entity
	 * */
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public TraineeTag createTag(String tag, Trainee trainee) {
		TraineeTag traineeTag = new TraineeTag();
		traineeTag.setTag(tag);
		traineeTag.setEntity(trainee);
		this.entityManager.persist(traineeTag);
		return traineeTag;
	}

	/**
	 * Adds tag to TrainingProgramTag entity
	 * */
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public TrainingProgramTag createTag(String tag, TrainingProgram trainingProgram) {
		TrainingProgramTag groupTag = new TrainingProgramTag();
		groupTag.setTag(tag);
		groupTag.setEntity(trainingProgram);
		this.entityManager.persist(groupTag);
		return groupTag;
	}

	/**
	 * Removes tag from TraineeTag entity
	 * */
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void removeTag(TraineeTag tag) {
		this.entityManager.remove(tag);
	}

	/**
	 * Removes tag from TrainingProgramTag entity
	 * */
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void removeTag(TrainingProgramTag tag) {
		this.entityManager.remove(tag);
	}

	/**
	 * Removes trainee from Trainee entity
	 * */
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void removeTrainee(Trainee trainee) {
		this.entityManager.remove(trainee);
	}

	/**
	 * Removes trainee from Training Program entity
	 * */
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void removeGroupTraining(TrainingProgram group) {
		this.entityManager.remove(group);
	}

	/**
	 * Removes trainee from Training Program Attendance entity
	 * */
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void removeAttendance(TrainingProgram group) {
		LOG.debug("GROUP TRAINING TITLE: " + group.getTitle());
		for (int i = group.getAttendance().size() - 1; i >= 0; i--) {
			Attendance attendance = group.getAttendance().get(i);
			if (attendance.getId() != null) {
				LOG.debug("Removing " + attendance);
				ensureRemoved(group.getAttendance().remove(i));
			}
		}
	}

	/**
	 * Utility method checks if object is in session and deletes from persistent storage
	 * 
	 * @param objectToRemove
	 */
	private void ensureRemoved(Object objectToRemove) {
		// if (this.entityManager.contains(objectToRemove))
		if (objectToRemove != null) {
			LOG.debug("EM removing " + objectToRemove);
			this.entityManager.remove(objectToRemove);
		}
	}

	/**
	 * @see org.iita.trainingunit.service.TraineeService#listTrainees(org.iita.trainingunit.model.Organization)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Trainee> listTrainees(Organization organization) {
		return this.entityManager.createQuery("from Trainee t where t.university=:organization order by t.extensionDate, t.endDate desc").setParameter(
				"organization", organization).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public PagedResult<Trainee> getTrainees(int startAt, int maxResults) {
		PagedResult<Trainee> paged = new PagedResult<Trainee>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("from Trainee tr order by tr.person.lastName, tr.person.firstName asc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(*) from Trainee").getSingleResult());
		return paged;
	}
	
	@Override
	@Transactional(readOnly = true)
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN", "BF_USERACCESS" })
	public PagedResult<Trainee> getUserTrainees(User user, int startAt, int maxResults) {
		PagedResult<Trainee> paged = new PagedResult<Trainee>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("select t.trainee from Trainer t where t.person.user=:user order by t.trainee.person.lastName, t.trainee.person.firstName asc").setParameter("user", user).setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(t.trainee) from Trainer t where t.person.user=:user").setParameter("user", user).getSingleResult());
		return paged;
	}

	@Override
	@Transactional(readOnly = true)
	public PagedResult<Trainee> getTraineesExportList(int exportyear) {
		PagedResult<Trainee> paged = new PagedResult<Trainee>();
		
		if(exportyear>0){
			LOG.info("YEAR: " + exportyear);
			paged.setResults(this.entityManager.createQuery("from Trainee tr where year(tr.startDate)=:year order by tr.person.lastName, tr.person.firstName asc").setParameter("year", exportyear).getResultList());
		}else
			paged.setResults(this.entityManager.createQuery("from Trainee tr order by tr.person.lastName, tr.person.firstName asc").getResultList());
		
		return paged;
	}
	
	@Override
	@Transactional(readOnly = true)
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN", "BF_USERACCESS" })
	public PagedResult<Trainee> getUserTraineesExportList(User user, int exportyear) {
		PagedResult<Trainee> paged = new PagedResult<Trainee>();
		if(exportyear>0)
			paged.setResults(this.entityManager.createQuery("select (tr.trainee) from Trainer tr where tr.person.user=:user and year(tr.startDate)=:year order by tr.trainee.person.lastName, tr.trainee.person.firstName asc").setParameter("user", user).setParameter("year", exportyear).getResultList());
		else
			paged.setResults(this.entityManager.createQuery("select (tr.trainee) from Trainer tr where tr.person.user=:user order by tr.trainee.person.lastName, tr.trainee.person.firstName asc").setParameter("user", user).getResultList());
		
		return paged;
	}
	
	@Override
	@Transactional(readOnly = true)
	public PagedResult<Partner> getPartners(int startAt, int maxResults) {
		PagedResult<Partner> paged = new PagedResult<Partner>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("from Partner pt order by pt.title, pt.shortName asc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(*) from Partner").getSingleResult());
		return paged;
	}
	

	@Override
	@Transactional(readOnly = true)
	public PagedResult<Partner> getPartnersExportList() {
		PagedResult<Partner> paged = new PagedResult<Partner>();
		paged.setResults(this.entityManager.createQuery("from Partner pt order by pt.title, pt.shortName asc").getResultList());
		return paged;
	}
	
	

	@Override
	@Transactional(readOnly = true)
	public PagedResult<TrainingProgram> getTrainingPrograms(int startAt, int maxResults) {
		PagedResult<TrainingProgram> paged = new PagedResult<TrainingProgram>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("from TrainingProgram tp order by tp.startDate Desc").setFirstResult(startAt).setMaxResults(maxResults)
				.getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(*) from TrainingProgram").getSingleResult());
		return paged;
	}
	
	@Override
	@Transactional(readOnly = true)
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN", "BF_USERACCESS" })
	public PagedResult<TrainingProgram> getUserTrainingPrograms(User user, int startAt, int maxResults) {
		PagedResult<TrainingProgram> paged = new PagedResult<TrainingProgram>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("select t.group from Trainer t where t.person.user=:user order by t.group.startDate Desc").setParameter("user", user).setFirstResult(startAt).setMaxResults(maxResults)
				.getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(t.group) from Trainer t where t.person.user=:user").setParameter("user", user).getSingleResult());
		return paged;
	}

	@Override
	@Transactional(readOnly = true)
	public PagedResult<TrainingProgram> getTrainingProgramsExportList(int exportyear) {
		PagedResult<TrainingProgram> paged = new PagedResult<TrainingProgram>();
		if(exportyear>0)
			paged.setResults(this.entityManager.createQuery("from TrainingProgram tp where year(tp.startDate)=:year order by tp.startDate Desc").setParameter("year", exportyear).getResultList());
		else
			paged.setResults(this.entityManager.createQuery("from TrainingProgram tp order by tp.startDate Desc").getResultList());
		return paged;
	}
	
	@Override
	@Transactional(readOnly = true)
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN", "BF_USERACCESS" })
	public PagedResult<TrainingProgram> getUserTrainingProgramsExportList(User user, int exportyear) {
		PagedResult<TrainingProgram> paged = new PagedResult<TrainingProgram>();
		if(exportyear>0)
			paged.setResults(this.entityManager.createQuery("select tr.group from Trainer tr where tr.person.user=:user and year(tr.group.startDate)=:year order by tr.group.startDate Desc").setParameter("year", exportyear).setParameter("user", user).getResultList());
		else
			paged.setResults(this.entityManager.createQuery("select tr.group from Trainer tr where tr.person.user=:user order by tr.group.startDate Desc").setParameter("year", exportyear).getResultList());
		
		return paged;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trainee> getTrainees(List<Long> selectedTrainees) {
		// no data
		if (selectedTrainees == null || selectedTrainees.size() == 0)
			return null;
		return this.entityManager.createQuery("from Trainee t where t.id in (:ids)").setParameter("ids", selectedTrainees).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrainingProgram> getTrainingPrograms(List<Long> selectedTrainingPrograms) {
		// no data
		if (selectedTrainingPrograms == null || selectedTrainingPrograms.size() == 0)
			return null;
		return this.entityManager.createQuery("from TrainingProgram tp where tp.id in (:ids)").setParameter("ids", selectedTrainingPrograms).getResultList();
	}

	@Override
	public String createList(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getListNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Selection> getLists() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Selection getSelectedList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectList(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void updateAlert(Alert alert) {
		if (alert != null) {
			this.entityManager.merge(alert);
		}
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void updateFunding(Funding funding) {
		if (funding != null) {
			this.entityManager.merge(funding);
		}
	}
	
	/**
	 * @see org.iita.trainingunit.service.FundingService#lookupFunding(String, Organization)
	 */
	@Override
	@Transactional
	@Secured( { "ROLE_TRAININGUNITHEAD", "ROLE_CRM", "BF_USERACCESS" })
	public Funding lookupFunding(String cc, Organization org) {
		// LOG.debug("KENNNET Date From: " + dateFrom + " Date To: " + dateTo);
		try{
			return (Funding) this.entityManager
				.createQuery(
						"from Funding f where f.costCenter=:cc and f.organization=:org)")
				.setParameter("cc", cc).setParameter("org", org).setMaxResults(1).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void updateTrainer(Trainer trainer) {
		if (trainer != null) {
			this.entityManager.merge(trainer);
		}
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void updateTag(TrainingProgramTag tagEntity) {
		if (tagEntity != null) {
			this.entityManager.merge(tagEntity);
		}
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void updateTag(TraineeTag tagEntity) {
		if (tagEntity != null) {
			this.entityManager.merge(tagEntity);
		}
	}

	// Lookup for pending trainee and group training program alerts
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void requestForPendingAlerts(String whichObject) {
		String today;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar now = GregorianCalendar.getInstance();
		today = sdf.format(now.getTime());
		
		if (whichObject.equals("trainee")) {
			List<Alert> alert = this.entityManager.createQuery("from Alert a where (a.trainee is not null and date_format(a.alertDate, '%Y-%m-%d') like :today and a.trainee.startDate>='2011-09-01') or (a.trainee is not null and a.status<>'SENT' and (a.trainee.endDate>now() or a.trainee.extensionDate>now()) and a.trainee.startDate>='2011-09-01')").setParameter(
					"today", today).getResultList();
			
			//LOG.info("TRAINEE ALERT SIZE: " + alert.size());
			if(alert.size()>0){
				for (Alert tr : alert) {
					if(tr.getTrainee().sendAlert()){
						//LOG.info("TRAINEE ALERT STATUS: " + tr.getTrainee().sendAlert() + " on ID " + tr.getTrainee().getId());
						sendAlertNotification(tr.getTrainee().getId(), "trainee");
					}
				}
			}
		} else {
			List<Alert> alert = this.entityManager.createQuery("from Alert a where (a.group is not null and date_format(a.alertDate, '%Y-%m-%d') like :today and a.group.startDate>='2011-09-01') or (a.group is not null and a.status<>'SENT' and a.group.endDate>now() and a.group.startDate>='2011-09-01')").setParameter(
					"today", today).getResultList();
			
			//LOG.info("GROUP ALERT SIZE: " + alert.size());
			if(alert.size()>0){
				for (Alert tr : alert) {
					if(tr.getGroup().sendAlert()){
						//LOG.info("GROUP ALERT STATUS: " + tr.getTrainee().sendAlert());
						sendAlertNotification(tr.getGroup().getId(), "group");
					}
				}
			}
		}
	}

	@Override
	@Transactional
	public void sendAlertNotification(Long id, String whichObject) {
		if (whichObject.equals("trainee")) {
			Trainee trainee = this.entityManager.find(Trainee.class, id);
			Alert alert = (Alert) this.entityManager.createQuery("from Alert a where a.trainee=:trainee").setParameter("trainee", trainee).getSingleResult();// and date_format(a.alertDate, '%Y-%m-%d') like :today
			ArrayList<String> ccTrainers = new ArrayList<String>();
			
			LOG.info("SENDING ALERT NOTIFICATION");
			if (alert != null && trainee != null) {
				LOG.info("ALERT & TRAINEE NOT NULL: TRAINEE PERSON EMAIL: " + trainee.getPerson().getLastEmail() + " on Trainee ID " + trainee.getId());
				for (Trainer tr : trainee.getSupervisors()) {
					if(tr.getPerson().getLastEmail() != null){
						if (((EmailContact) tr.getPerson().getLastEmail()).getEmail() != null) {
							ccTrainers.add(((EmailContact) tr.getPerson().getLastEmail()).getEmail().toString());
						}
					}
				}
				
				String email = null;
				if (trainee.getPerson().getLastEmail() != null) {
					LOG.info("SENDING MAIL TO TRAINEE PERSON: " + trainee.sendAlert() + " on ID " + trainee.getId());
					email = ((EmailContact) trainee.getPerson().getLastEmail()).getEmail().toString();

					HashMap<String, Object> data = new HashMap<String, Object>();
					data.put("trainee", trainee);
					//data.put("trainer", tr);
					InputStream file = TrainingUnitServiceImpl.class.getClassLoader().getResourceAsStream(
							"org/iita/trainingunit/service/impl/TraineeProgressReportForm2.doc");

					try {
						String body = this.templatingService.fillTemplate("trainee-alert", data);
						try {
							int length = file.available();

							//System.out.println("length of file : " + length);
							byte[] rawfile = new byte[length];

							file.read(rawfile);
							this.emailService.sendEmailWithAttachment("IITA-TrainingUnit@cgiar.org", email, ccTrainers, "Student’s Progress Reporting alert", body, "trainee-report.doc", rawfile);
							//this.emailService.sendEmail("IITA-TrainingUnit@cgair.org",email,"Testing", body);
							alert.setStatus(NotifyStatus.SENT);
							this.entityManager.merge(alert);
							file.close();
						} catch (Exception e) {
							LOG.error(e);
						}
					} catch (TemplatingException e) {
						LOG.error(e);
					}
				}
						//}
					//} 
				//}
				//SEND REPORT THE THE TRAINEE
				/*if(trainee.getPerson().getLastEmail() != null){
					if ((trainee.getPerson().getLastEmail()) != null) {
						
						EmailContact ec = (EmailContact) trainee.getPerson().getLastEmail();
						String email = ec.getEmail();
						HashMap<String, Object> data = new HashMap<String, Object>();
						data.put("trainee", trainee);
						InputStream file = TrainingUnitServiceImpl.class.getClassLoader().getResourceAsStream(
								"org/iita/trainingunit/service/impl/TraineeProgressReportForm.doc");

						try {
							String body = templatingService.fillTemplate("trainee-alert", data);
							try {
								int length = file.available();

								System.out.println("length of file : " + length);
								byte[] rawfile = new byte[length];

								file.read(rawfile);
								this.emailService.sendEmailWithAttachment("IITA-TrainingUnit@cgiar.org", email, null, "Reporting Exercise Alert", body,
										"trainee-report.doc", rawfile);
								alert.setStatus(NotifyStatus.SENT);
								this.entityManager.merge(alert);
								file.close();
							} catch (Exception e) {
								LOG.error(e);
							}
						} catch (TemplatingException e) {
							LOG.error(e);
						}
					}
				}*/
			}
		} else {
			TrainingProgram group = this.entityManager.find(TrainingProgram.class, id);
			Alert alert = (Alert) this.entityManager.createQuery("from Alert a where a.group=:group").setParameter("group", group).getSingleResult();// and date_format(a.alertDate, '%Y-%m-%d') like :today
			if (alert != null && group != null) {
				for (Trainer tr : group.getTrainers()) {
					if(tr.getPerson().getLastEmail() != null){
						if (((EmailContact) tr.getPerson().getLastEmail()).getEmail() != null) {
							String email = ((EmailContact) tr.getPerson().getLastEmail()).getEmail().toString();
							HashMap<String, Object> data = new HashMap<String, Object>();
							data.put("group", group);
							data.put("trainer", tr);
							InputStream file = TrainingUnitServiceImpl.class.getClassLoader().getResourceAsStream(
									"org/iita/trainingunit/service/impl/GroupTraiNetReportformat.doc");
	
							try {
								String body = templatingService.fillTemplate("grouptraining-alert", data);
								try {
									int length = file.available();
									byte[] rawfile = new byte[length];
									file.read(rawfile);
									this.emailService.sendEmailWithAttachment("IITA-TrainingUnit@cgiar.org", email, null, "Reporting Exercise Alert", body,
											"group-report.doc", rawfile);
									alert.setStatus(NotifyStatus.SENT);
									this.entityManager.merge(alert);
									file.close();
								} catch (Exception e) {
									LOG.error(e);
								}
							} catch (TemplatingException e) {
								LOG.error(e);
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * @throws CRMException
	 * @see org.iita.promis.service.PromisCRMService#merge(org.iita.promis.service.MergeEntity, org.iita.promis.service.MergeEntity)
	 */
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void merge(MergeEntity left, MergeEntity right) throws CRMException {
		Object leftEntity = left.getEntity();
		Object rightEntity = right.getEntity();
		if (leftEntity.getClass() != rightEntity.getClass()) {
			throw new CRMException("Cannot merge two diffent entity types");
		}

		if (leftEntity.getClass() == Person.class) {
			mergePerson((Person) leftEntity, (Person) rightEntity);
			this.entityManager.merge(leftEntity);
			this.entityManager.remove(rightEntity);
		} else if (leftEntity.getClass() == Organization.class) {
			mergeOrganization((Organization) leftEntity, (Organization) rightEntity);
			this.entityManager.merge(leftEntity);
			this.entityManager.remove(rightEntity);
		}
	}

	/**
	 * Returns merged entity
	 * 
	 * @param leftEntity
	 * @param rightEntity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	protected Person mergePerson(Person left, Person right) {
		// merge Core CRM data
		super.mergePerson(left, right);
		
		// merge TU specific data
		//Trainees
		List<Trainee> trainees = this.entityManager.createQuery("from Trainee t where t.person=:user").setParameter("user", right).getResultList();
		if (trainees != null) {
			for (Trainee trainee : trainees) {
				trainee.setPerson(left);
				this.entityManager.merge(trainee);
			}
			trainees.clear();
		}
		
		//Trainers
		List<Trainer> trainers = this.entityManager.createQuery("from Trainer t where t.person=:user").setParameter("user", right).getResultList();
		if (trainers != null) {
			for (Trainer trainer : trainers) {
				trainer.setPerson(left);
				this.entityManager.merge(trainer);
			}
			trainers.clear();
		}
		
		//Attendance
		List<Attendance> attendances = this.entityManager.createQuery("from Attendance a where a.attendee=:user").setParameter("user", right).getResultList();
		if (attendances != null) {
			for (Attendance attendance : attendances) {
				attendance.setAttendee(left);
				this.entityManager.merge(attendance);
			}
			attendances.clear();
		}
		
		//Alumni
		List<Alumni> alumni = this.entityManager.createQuery("from Alumni a where a.person=:user").setParameter("user", right).getResultList();
		if (alumni != null) {
			for (Alumni alumnus : alumni) {
				alumnus.setPerson(left);
				this.entityManager.merge(alumnus);
			}
			alumni.clear();
		}
		
		//PartnerPersonContact
		List<PartnerPersonContact> personContacts = this.entityManager.createQuery("from PartnerPersonContact p where p.person=:user").setParameter("user", right).getResultList();
		if (personContacts != null) {
			for (PartnerPersonContact personContact : personContacts) {
				personContact.setPerson(left);
				this.entityManager.merge(personContact);
			}
			attendances.clear();
		}
		
		return left;
	}

	/**
	 * Returns merged entity
	 * 
	 * @param leftEntity
	 * @param rightEntity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	protected Organization mergeOrganization(Organization left, Organization right) {		
		// merge Core CRM data
		super.mergeOrganization(left, right);
		
		// merge TU specific data and then core CRM
		//Trainees
		List<Trainee> trainees = this.entityManager.createQuery("from Trainee t where t.university=:organization").setParameter("organization", right).getResultList();
		if (trainees != null) {
			for (Trainee trainee : trainees) {
				trainee.setUniversity(left);
				this.entityManager.merge(trainee);
			}
			trainees.clear();
		}
		
		//Fundings
		List<Funding> fundings = this.entityManager.createQuery("from Funding t where t.organization=:organization").setParameter("organization", right).getResultList();
		if (fundings != null) {
			for (Funding funding : fundings) {
				funding.setOrganization(left);
				this.entityManager.merge(funding);
			}
			fundings.clear();
		}
		
		return left;
	}
	
	/**
	 * @see org.iita.trainingunit.service.TrainingUnitService#getLastUpdatedTrainees(user, java.lang.Class, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Trainee> getLastUpdatedTrainees(User user, Class<?> clazz, int maxRecords) {
		//LOG.debug("USERID: "+user.getId());
		return this.entityManager.createQuery("select distinct tr.trainee from " + clazz.getName() + " tr where tr.person.user=:trainer order by tr.trainee.lastUpdated desc").setParameter("trainer", user).setMaxResults(maxRecords).getResultList();
	}
	
	/**
	 * @see org.iita.trainingunit.service.TrainingUnitService#getLastUpdatedTrainingPrograms(user, java.lang.Class, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<TrainingProgram> getLastUpdatedTrainingPrograms(User user, Class<?> clazz, int maxRecords) {
		//LOG.debug("USERID: "+user.getId());
		return this.entityManager.createQuery("select distinct tr.group from " + clazz.getName() + " tr where tr.person.user=:trainer order by tr.group.lastUpdated desc").setParameter("trainer", user).setMaxResults(maxRecords).getResultList();
	}

	@Override
	public void removeTrainingProgramFile(TrainingProgram group, String subDirectory, String fileName) throws IOException {
		try {
			ServerFile.removeServerFile(getTrainingProgramFileDirectory(group), subDirectory, fileName);
		} catch (IOException e) {
			LOG.info(e);
			throw e;
		}
	}

	@Override
	public void removeTraineeFile(Trainee trainee, String directory, String file) throws IOException {
		try {
			ServerFile.removeServerFile(getTraineeFileDirectory(trainee), directory, file);
		} catch (IOException e) {
			LOG.info(e);
			throw e;
		}
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public AnnouncementTag createTag(String tag, Announcement announcement) {
		AnnouncementTag announcementTag = new AnnouncementTag();
		announcementTag.setTag(tag);
		announcementTag.setEntity(announcement);
		this.entityManager.persist(announcementTag);
		return announcementTag;
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public ApplicationTag createTag(String tag, Application application) {
		ApplicationTag applicationTag = new ApplicationTag();
		applicationTag.setTag(tag);
		applicationTag.setEntity(application);
		this.entityManager.persist(applicationTag);
		return applicationTag;
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void removeTag(AnnouncementTag tag) {
		this.entityManager.remove(tag);
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void removeTag(ApplicationTag tag) {
		this.entityManager.remove(tag);
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void updateTag(AnnouncementTag tagEntity) {
		if (tagEntity != null) {
			this.entityManager.merge(tagEntity);
		}
	}

	@Override
	@Transactional
	@Secured( { "ROLE_MERGE", "ROLE_CRM", "ROLE_TRAININGUNITHEAD", "ROLE_ADMIN" })
	public void updateTag(ApplicationTag tagEntity) {
		if (tagEntity != null) {
			this.entityManager.merge(tagEntity);
		}
	}
	
	@Override
	@Transactional
	public User loadUser(Long userId){
		return this.entityManager.find(User.class, userId);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.trainingunit.service.TrainingUnitService#getYears(org.iita.par.model.User)
	 */
	/**
	 * @see org.iita.trainingunit.service.TrainingUnitService#getYears(org.iita.security.model.User)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getTraineeYears(User user) {
		if(user != null)
			return entityManager.createQuery("select distinct Year(t.startDate) from Trainee t left outer join t.supervisors tr where tr.person.user=:user order by t.startDate Desc").setParameter(
				"user", user).getResultList();
		else
			return entityManager.createQuery("select distinct Year(t.startDate) from Trainee t order by t.startDate Desc").getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.trainingunit.service.TrainingUnitService#getTrainingProgramYears(org.iita.par.model.User)
	 */
	/**
	 * @see org.iita.trainingunit.service.TrainingUnitService#getTrainingProgramYears(org.iita.security.model.User)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getTrainingProgramYears(User user) {
		if(user != null)
			return entityManager.createQuery("select distinct Year(t.startDate) from TrainingProgram t left outer join t.trainers tr where tr.person.user=:user order by t.startDate Desc").setParameter(
				"user", user).getResultList();
		else
			return entityManager.createQuery("select distinct Year(t.startDate) from TrainingProgram t order by t.startDate Desc").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public String[] getSelectedCrps(Trainee trainee) {
		return (String[]) this.entityManager.createQuery("select distinct c.name from Crp c where c.trainee=:trainee order by c.name asc")
		.setParameter("trainee", trainee)
		.getResultList().toArray(new String[] {});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public String[] getSelectedHubs(Trainee trainee) {
		return (String[]) this.entityManager.createQuery("select distinct c.name from Hub c where c.trainee=:trainee order by c.name asc")
		.setParameter("trainee", trainee)
		.getResultList().toArray(new String[] {});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public String[] getSelectedCoreCompetencies(Trainee trainee) {
		return (String[]) this.entityManager.createQuery("select distinct c.name from CoreCompetency c where c.trainee=:trainee order by c.name asc")
		.setParameter("trainee", trainee)
		.getResultList().toArray(new String[] {});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public String[] getSelectedSubPrograms(Trainee trainee) {
		return (String[]) this.entityManager.createQuery("select distinct s.name from SubProgram s where s.trainee=:trainee order by s.name asc")
		.setParameter("trainee", trainee)
		.getResultList().toArray(new String[] {});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public String[] getSelectedCrps(TrainingProgram group) {
		return (String[]) this.entityManager.createQuery("select distinct c.name from Crp c where c.trainingProgram=:group order by c.name asc")
		.setParameter("group", group)
		.getResultList().toArray(new String[] {});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public String[] getSelectedHubs(TrainingProgram group) {
		return (String[]) this.entityManager.createQuery("select distinct c.name from Hub c where c.trainingProgram=:group order by c.name asc")
		.setParameter("group", group)
		.getResultList().toArray(new String[] {});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public String[] getSelectedCoreCompetencies(TrainingProgram group) {
		return (String[]) this.entityManager.createQuery("select distinct c.name from CoreCompetency c where c.trainingProgram=:group order by c.name asc")
		.setParameter("group", group)
		.getResultList().toArray(new String[] {});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public String[] getSelectedSubPrograms(TrainingProgram group) {
		return (String[]) this.entityManager.createQuery("select distinct s.name from SubProgram s where s.trainingProgram=:group order by s.name asc")
		.setParameter("group", group)
		.getResultList().toArray(new String[] {});
	}
	
	/**
	 * @see org.iita.trainingunit.service.TrainingUnitService#findAllTrainers()
	 */
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Trainer> findAllTrainers() {
		return (List<Trainer>) this.entityManager.createQuery("select distinct t from Trainer t inner join t.person p where p.lastEmail.email IS NOT NULL group by p.lastName, p.lastEmail.email order by p.lastName").getResultList();
	}
	
	/**
	 * @see org.iita.trainingunit.service.TrainingUnitService#findAllOrganizations()
	 */
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Organization> findAllOrganizations() {
		return (List<Organization>) this.entityManager.createQuery("select distinct o from Organization o order by o.title").getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public PagedResult<Trainee> listTrainees(int year){
		PagedResult<Trainee> paged = new PagedResult<Trainee>();
		paged.setStartAt(0);
		paged.setMaxResults(10);
		paged.setResults(this.entityManager.createQuery("from Trainee t where Year(t.startDate)=:year order by startDate desc").setParameter("year", year).setFirstResult(0)
				.setMaxResults(10).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(*) from Trainee t where Year(t.startDate)=:year").setParameter("year", year).getSingleResult());
		return paged;
	}
	
	@Override
	@Transactional(readOnly = true)
	public PagedResult<TrainingProgram> listPrograms(int year){
		PagedResult<TrainingProgram> paged = new PagedResult<TrainingProgram>();
		paged.setStartAt(0);
		paged.setMaxResults(10);
		paged.setResults(this.entityManager.createQuery("from TrainingProgram t where Year(t.startDate)=:year order by startDate desc").setParameter("year", year).setFirstResult(0)
				.setMaxResults(10).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(*) from TrainingProgram t where Year(t.startDate)=:year").setParameter("year", year).getSingleResult());
		return paged;
	}
	
	@Override
	@Transactional(readOnly = true)
	public PagedResult<TrainingLocation> listProposals(int year){
		PagedResult<TrainingLocation> paged = new PagedResult<TrainingLocation>();
		paged.setStartAt(0);
		paged.setMaxResults(10);
		paged.setResults(this.entityManager.createQuery("select t from TrainingLocation t join t.trainingProposal tp where Year(t.startDate)=:year and tp.status=:status order by startDate desc")
				.setParameter("year", year)
				.setParameter("status", org.iita.trainingunit.announcements.model.TrainingProposal.STATUS.SUBMITTED)
				.setFirstResult(0)
				.setMaxResults(10)
				.getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(*) from TrainingLocation t join t.trainingProposal tp where Year(t.startDate)=:year and tp.status=:status")
				.setParameter("year", year)
				.setParameter("status", org.iita.trainingunit.announcements.model.TrainingProposal.STATUS.SUBMITTED)
				.getSingleResult());
		return paged;
	}
	
	@Override
	@Transactional(readOnly = true)
	public PagedResult<TrainingLocation> listAnnouncements(int year){
		PagedResult<TrainingLocation> paged = new PagedResult<TrainingLocation>();
		paged.setStartAt(0);
		paged.setMaxResults(10);
		paged.setResults(this.entityManager.createQuery("select t from TrainingLocation t join t.announcement a where Year(t.startDate)=:year and a.status=:status order by startDate desc")
				.setParameter("year", year)
				.setParameter("status", STATUS.Published)
				.setFirstResult(0)
				.setMaxResults(10).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(*) from TrainingLocation t join t.announcement a where Year(t.startDate)=:year and a.status=:status")
				.setParameter("year", year)
				.setParameter("status", STATUS.Published)
				.getSingleResult());
		return paged;
	}
	
	@Override
	@Transactional(readOnly = true)
	public PagedResult<Organization> listOrganizations(int year){
		PagedResult<Organization> paged = new PagedResult<Organization>();
		paged.setStartAt(0);
		paged.setMaxResults(10);
		paged.setResults(this.entityManager.createQuery("from Organization o where Year(o.createdDate)=:year order by createdDate desc").setParameter("year", year).setFirstResult(0)
				.setMaxResults(10).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(*) from Organization o where Year(o.createdDate)=:year").setParameter("year", year).getSingleResult());
		return paged;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.trainingunit.service.TrainingUnitService#getActivityYears(org.iita.par.model.User)
	 */
	/**
	 * @see org.iita.trainingunit.service.TrainingUnitService#getActivityYears(org.iita.security.model.User)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getActivityYears(User user) {
		List<Integer> years = new ArrayList<Integer>();
		//Set<String> years = new HashSet<String>();
		//years.add(new Date().getYear());
		Integer yr = 0;
		if(user != null){
			List<Integer> tpYears = (List<Integer>) entityManager.createQuery("select distinct Year(t.startDate) from TrainingProgram t left outer join t.trainers tr where tr.person.user=:user order by t.startDate Desc").setParameter(
				"user", user).getResultList();
			
			for (int i = 0; i < tpYears.size();i++){
				yr = (Integer) tpYears.get(i);
			     if (!years.contains(yr))
			        years.add(yr);
			}
			
			List<Integer> tYears = (List<Integer>) entityManager.createQuery("select distinct Year(t.startDate) from Trainee t left outer join t.supervisors tr where tr.person.user=:user order by t.startDate Desc").setParameter(
					"user", user).getResultList();
			for (int i = 0; i < tYears.size();i++){
				yr = (Integer) tYears.get(i);
			     if (!years.contains(yr))
			        years.add(yr);
			}
		}else{
			List<Integer> tpYears = (List<Integer>) entityManager.createQuery("select distinct Year(t.startDate) from TrainingProgram t order by t.startDate Desc").getResultList();
			LOG.info(tpYears.size());
			
			if(tpYears.size()>0){
				for (Integer i : tpYears){
					yr = (Integer) i;
				     if (!years.contains(yr))
				        years.add(yr);
				}
			}
			List<Integer> tYears = (List<Integer>) entityManager.createQuery("select distinct Year(t.startDate) from Trainee t order by t.startDate Desc").getResultList();
			if(tYears.size()>0){
				for (Integer i : tYears){
					yr = (Integer) i;
				     if (!years.contains(yr))
				        years.add(yr);
				}
			}
		}
			
		return years;
	}
	
	/**
	 * @throws CDOApplicationException
	 * @see org.iita.trainingunit.service.TrainingUnitService#getApplications(org.iita.security.model.User, int, int)
	 */
	@Override
	@Transactional(readOnly = true)
	public PagedResult<Application> getAwaitingApproval(User user, int startAt, int maxResults) throws CDOApplicationException {
		if (user == null) {
			throw new CDOApplicationException("User not provided");
		}

		int budgetCount = ((Long) this.entityManager
				.createQuery(
						"select count(distinct bc.internalApproval.application) from BudgetCode bc where " +
						"bc.internalApproval.application.status=:appStatus " +
						"and bc.nextApprover=:user AND (bc.status=1 OR bc.status=0)")
				.setParameter("appStatus", APPLICATIONSTATUS.WAITING).setParameter("user", user).getSingleResult()).intValue();
		LOG.debug("Total budget pending: " + budgetCount);

		PagedResult<Application> pagedAwaitingApproval = new PagedResult<Application>(startAt, maxResults);
		pagedAwaitingApproval.setTotalHits(budgetCount);
		LOG.debug("Total pending: " + pagedAwaitingApproval.getTotalHits());

		// BCs
		pagedAwaitingApproval.setResults(this.entityManager.createQuery(
				"select distinct bc.internalApproval.application from BudgetCode bc where " +
										"((bc.internalApproval.application.status=:appStatus and bc.nextApprover=:user) or " +
										"(bc.internalApproval.application.status=:appStatusCDO and bc.nextApprover=:user)) AND " +
										"(bc.status=1 OR bc.status=0) ORDER BY bc.internalApproval.application.refNumber DESC")
										.setParameter("appStatus", APPLICATIONSTATUS.WAITING)
										.setParameter("appStatusCDO", APPLICATIONSTATUS.WAITINGFORCDO)
										.setParameter("user", user)
				.setFirstResult(startAt).setMaxResults(maxResults).getResultList());
		LOG.debug("Total pending (1): " + pagedAwaitingApproval.getResults().size());
		
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
	 *
	 * @see org.iita.trainingunit.applications.service.CDOApplicationService#getMyBcApplications(org.iita.security.model.User, int, int)
	 */
	@Override
	@Transactional(readOnly = true)
	public PagedResult<Application> getMyBcApplications(User user, int startAt, int maxResults) {
		if (user == null) {
			try {
				throw new Exception("User not provided");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		PagedResult<Application> paged = new PagedResult<Application>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery(
				"select distinct bc.internalApproval.application from BudgetCode bc where bc.budgetHolder=:user ORDER BY bc.internalApproval.application.refNumberDESC").setParameter("user", user)
				.setFirstResult(startAt).setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager
				.createQuery("select count(distinct bc.internalApproval.application) from BudgetCode bc where bc.budgetHolder=:user").setParameter("user", user)
				.getSingleResult());
		return paged;
	}
}
