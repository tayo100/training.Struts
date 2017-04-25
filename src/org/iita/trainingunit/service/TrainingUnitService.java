/**
 * training.Struts Feb 4, 2010
 */
package org.iita.trainingunit.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.iita.crm.model.AnnouncementTag;
import org.iita.crm.model.ApplicationTag;
import org.iita.crm.model.Organization;
import org.iita.crm.model.Partner;
import org.iita.crm.model.Person;
import org.iita.crm.service.CRMException;
import org.iita.crm.service.CoreCRMService;
import org.iita.security.model.User;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.model.TrainingLocation;
import org.iita.trainingunit.announcements.model.TrainingProposal;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.service.impl.CDOApplicationException;
import org.iita.trainingunit.iya.model.IYATrainingAnnouncement;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.TraineeTag;
import org.iita.trainingunit.model.Trainer;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.model.TrainingProgramTag;
import org.iita.util.PagedResult;

/**
 * One service to rule them all.
 * 
 * @author mobreza
 */
public interface TrainingUnitService extends CoreCRMService, TraineeService, TrainerService, TraineeEducationalInfoService ,
		TrainingProgramService, FundingService, AlertService, XLSService, SelectionService {

	/**
	 * @param class1
	 * @param i
	 * @return
	 */
	<T> List<T> getLastUpdated(Class<T> clazz, int maxRecords);

	/**
	 * Find entities
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	<T> T find(Class<T> clazz, Long id);

	/**
	 * @param left
	 * @param right
	 * @throws ClassNotFoundException 
	 * @throws TrainingUnitDataException 
	 * @throws CRMException 
	 */
	void merge(MergeEntity left, MergeEntity right) throws ClassNotFoundException, TrainingUnitDataException, CRMException;

	/**
	 * MergeEntity information
	 * 
	 * @author mobreza
	 */
	public class MergeEntity {
		private Class<?> clazz;
		private Long id;
		private Object entity;
		private List<String> preserveClass = new ArrayList<String>();
		private List<Long> preserveId = new ArrayList<Long>();

		/**
		 * @return the clazz
		 */
		public Class<?> getClazz() {
			return this.clazz;
		}

		/**
		 * @param clazz the clazz to set
		 */
		public void setClazz(Class<?> clazz) {
			this.clazz = clazz;
		}

		/**
		 * @return the id
		 */
		public Long getId() {
			return this.id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}

		public void setClassName(String className) throws ClassNotFoundException {
			this.clazz = Class.forName(className);
		}

		public String getClassName() {
			return this.clazz == null ? null : this.clazz.getName();
		}

		/**
		 * @param entity the entity to set
		 */
		public void setEntity(Object entity) {
			this.entity = entity;
		}

		/**
		 * @return the entity
		 */
		public Object getEntity() {
			return this.entity;
		}
		
		/**
		 * @return the preserveClass
		 */
		public List<String> getPreserveClass() {
			return this.preserveClass;
		}
		
		/**
		 * @return the preserveId
		 */
		public List<Long> getPreserveId() {
			return this.preserveId;
		}
		
		/**
		 * @param preserveClass the preserveClass to set
		 */
		public void setPreserveClass(List<String> preserveClass) {
			this.preserveClass = preserveClass;
		}
		
		/**
		 * @param preserveId the preserveId to set
		 */
		public void setPreserveId(List<Long> preserveId) {
			this.preserveId = preserveId;
		}
	}
	
	TraineeTag createTag(String tag, Trainee trainee);

	TrainingProgramTag createTag(String tag, TrainingProgram trainingProgram);
	
	AnnouncementTag createTag(String tag, Announcement announcement);
	
	ApplicationTag createTag(String tag, Application application);

	void removeTag(TraineeTag tag);

	void removeTag(TrainingProgramTag tag);
	
	void removeTag(AnnouncementTag tag);
	
	void removeTag(ApplicationTag tag);

	InputStream getPDFTemplateStream() throws IOException;
	
	PagedResult<Trainee> getTrainees(int startAt, int maxResults);

	PagedResult<TrainingProgram> getTrainingPrograms(int startAt, int maxResults);
	
	PagedResult<Trainee> getUserTrainees(User user, int startAt, int maxResults);

	PagedResult<TrainingProgram> getUserTrainingPrograms(User user, int startAt, int maxResults);

	List<Trainee> getTrainees(List<Long> selectedTrainees);

	List<TrainingProgram> getTrainingPrograms(List<Long> selectedTrainingPrograms);

	void updateTag(TrainingProgramTag tagEntity);

	void updateTag(TraineeTag tagEntity);
	
	void updateTag(AnnouncementTag tagEntity);
	
	void updateTag(ApplicationTag tagEntity);
	
	/**
	 * Get a list of trainee for current logged in user
	 * 
	 * @param clazz
	 * @param maxRecords
	 * @return
	 */
	List<Trainee> getLastUpdatedTrainees(User user, Class<?> clazz, int maxRecords);
	
	/**
	 * Get a list of group training for current logged in user
	 * 
	 * @param clazz
	 * @param maxRecords
	 * @return
	 */
	List<TrainingProgram> getLastUpdatedTrainingPrograms(User user, Class<?> clazz, int maxRecords);

	void removeTrainingProgramFile(TrainingProgram group, String subDirectory, String fileName) throws IOException;

	void removeTraineeFile(Trainee trainee, String directory, String file) throws IOException;
	
	PagedResult<Partner> getPartnersExportList();
	PagedResult<Partner> getPartners(int startAt, int maxResults);

	TrainingProposal loadTrainingProposal(Long trainingProposalId);

	Announcement loadAnnouncement(Long announcementId);
	
	List<TrainingProposal> listTrainingProposalTrainers(Person person);

	List<Announcement> listAnnouncementTrainers(Person person);

	User loadUser(Long userId);

	List<Integer> getTraineeYears(User user);
	
	List<Integer> getTrainingProgramYears(User user);

	String[] getSelectedCrps(Trainee trainee);
	String[] getSelectedHubs(Trainee trainee);
	String[] getSelectedCoreCompetencies(Trainee trainee);
	String[] getSelectedSubPrograms(Trainee trainee);
	
	String[] getSelectedCrps(TrainingProgram trainingProgram);
	String[] getSelectedHubs(TrainingProgram trainingProgram);
	String[] getSelectedCoreCompetencies(TrainingProgram trainingProgram);
	String[] getSelectedSubPrograms(TrainingProgram trainingProgram);

	List<Trainer> findAllTrainers();
	
	List<Organization> findAllOrganizations();

	PagedResult<Trainee> listTrainees(int year);

	List<Integer> getActivityYears(User user);

	PagedResult<TrainingProgram> listPrograms(int year);

	PagedResult<TrainingLocation> listProposals(int year);

	PagedResult<TrainingLocation> listAnnouncements(int year);

	PagedResult<Organization> listOrganizations(int year);

	PagedResult<Application> getAwaitingApproval(User user, int startAt, int maxResults) throws CDOApplicationException;

	List<User> getWaitingFor(Application app);

	PagedResult<Application> getMyBcApplications(User user, int startAt, int maxResults);

	IYATrainingAnnouncement loadIYAAnnouncement(Long id);
}
