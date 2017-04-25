package org.iita.trainingunit.iya.action;

//import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.crm.action.BaseAction;
import org.iita.crm.model.Person;
import org.iita.trainingunit.iya.model.IYAEvaluation;
import org.iita.trainingunit.iya.model.IYARegistration;
import org.iita.trainingunit.iya.model.IYATrainingAnnouncement;
import org.iita.trainingunit.iya.service.IyaService;
import org.iita.trainingunit.service.TrainingUnitService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class IyaRegistrationAction extends BaseAction implements Preparable {
	private static final Log LOG = LogFactory.getLog(IyaRegistrationAction.class);
	private IyaService iyaService;
	private TrainingUnitService trainingUnitService;
	private PagedResult<IYARegistration> paged;
	private IYARegistration registration;
	private IYATrainingAnnouncement ann;
	protected int startAt = 0, maxResults = 50;
	private IYAEvaluation evaluation;
	private String fullname;
	private Long id;
	private Long personId;
	private Long announcementId;
	private Long regId;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IyaRegistrationAction(IyaService iyaService, TrainingUnitService trainingUnitService) {
		this.iyaService = iyaService;
		this.trainingUnitService = trainingUnitService;
	}
	
	@Override
	public String execute() {
		super.execute();
		return Action.SUCCESS;
	}
	
	@Override
	public void prepare() {
		
		super.prepare();
		this.setPaged(this.iyaService.iyaRegistrations(this.startAt, this.maxResults));
		
		if(this.id != null)
			this.evaluation = this.iyaService.loadEvaluation(this.id);
		
		if(this.regId != null)
			this.registration = this.iyaService.loadRegistration(this.regId);
		
		if (this.personId != null) {
			Person person = new Person();
			person = this.trainingUnitService.loadPerson(this.personId);
			this.setFullname(person.getFullName());
		}
		
		if (this.announcementId != null){
			IYATrainingAnnouncement ann = new IYATrainingAnnouncement();
			ann = this.trainingUnitService.loadIYAAnnouncement(announcementId);
			this.registration.setIyaTrainingAnnouncement(ann);
		}

	}
	
	public String input(){
		return "input";
	}
	
	public String saveRegistration() {
		if(this.registration==null)
			this.registration = new IYARegistration();

		LOG.info("Person Id: " + getPersonId());
		LOG.info("Ann Id: " + getAnnouncementId());
		
		if (this.personId != null) {
			Person person = new Person();
			person = this.trainingUnitService.loadPerson(this.personId);
			this.registration.setPerson(person);
		}

		if (this.announcementId != null){
			IYATrainingAnnouncement ann = new IYATrainingAnnouncement();
			ann = this.trainingUnitService.loadIYAAnnouncement(announcementId);
			this.registration.setIyaTrainingAnnouncement(ann);
		}

		this.registration = this.iyaService.saveRegistration(this.registration);
		return Action.SUCCESS;
	}

	public String details(){		
		if(this.registration==null)
			return Action.ERROR;
		else
			return Action.SUCCESS;
	}
	
	public String list(){
		
		if (this.id != null){
			this.registration = this.iyaService.loadRegistration(this.id);
			
			this.regId = this.id;
			LOG.info("Registration Id: " + this.regId);
		}	

		return Action.SUCCESS;
		
	}
	
	public String removeRegistration() throws Exception {
		this.registration = this.iyaService.loadRegistration(id);

		try {
			this.iyaService.ensureRemoved(this.registration);
		}
		catch (javax.persistence.PersistenceException e) {
			addActionError("Registration could not be removed due to constraints violation.");
			return Action.ERROR;
		}
 		return Action.SUCCESS;
	}

	/**
	 * @param registration the registration to set
	 */
	public void setRegistration(IYARegistration registration) {
		this.registration = registration;
	}

	/**
	 * @return the registration
	 */
	public IYARegistration getRegistration() {
		return registration;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * @return the personId
	 */
	public Long getPersonId() {
		return personId;
	}


	/**
	 * @return the announcementId
	 */
	public Long getAnnouncementId() {
		return announcementId;
	}
	
	/**
	 * @param announcementId the announcementId to set
	 */
	public void setAnnouncementId(Long announcementId) {
	}

	/**
	 * @param paged the paged to set
	 */
	public void setPaged(PagedResult<IYARegistration> paged) {
		this.paged = paged;
	}

	/**
	 * @return the paged
	 */
	public PagedResult<IYARegistration> getPaged() {
		return paged;
	}

	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @param regId the regId to set
	 */
	public void setRegId(Long regId) {
		this.regId = regId;
	}

	/**
	 * @return the regId
	 */
	public Long getRegId() {
		return regId;
	}

	/**
	 * @param ann the ann to set
	 */
	public void setAnn(IYATrainingAnnouncement ann) {
		this.ann = ann;
	}

	/**
	 * @return the ann
	 */
	public IYATrainingAnnouncement getAnn() {
		return ann;
	}
	
	/**
	 * @param evaluation the evaluation to set
	 */
	public void setEvaluation(IYAEvaluation evaluation) {
		this.evaluation = evaluation;
	}

	/**
	 * @return the evaluation
	 */
	public IYAEvaluation getEvaluation() {
		return evaluation;
	}
	
}
