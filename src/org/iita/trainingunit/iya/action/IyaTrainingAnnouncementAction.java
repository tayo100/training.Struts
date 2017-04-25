package org.iita.trainingunit.iya.action;

import org.iita.crm.action.BaseAction;
import org.iita.trainingunit.announcements.model.TrainingLocation;
import org.iita.trainingunit.iya.model.IYAAnnouncementObjective;
import org.iita.trainingunit.iya.model.IYATrainingAnnouncement;
import org.iita.trainingunit.iya.service.IyaService;
import org.iita.trainingunit.model.Trainer;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IyaTrainingAnnouncementAction extends BaseAction implements Preparable {
	private static final Log LOG = LogFactory.getLog(IyaTrainingAnnouncementAction.class);
	private IyaService iyaService;
	private PagedResult<IYATrainingAnnouncement> paged;
	private IYATrainingAnnouncement announcement;
	private IYAAnnouncementObjective obj;	
	private String organizer;
	private String sponsor;
	/**
	 * @return the trainer
	 */
	public Trainer getTrainer() {
		return trainer;
	}

	/**
	 * @return the location
	 */
	public TrainingLocation getLocation() {
		return location;
	}

	/**
	 * @param trainer the trainer to set
	 */
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(TrainingLocation location) {
		this.location = location;
	}

	private Trainer trainer;
	private TrainingLocation location;
	
	
	protected int startAt = 0, maxResults = 50;
	private Long id;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IyaTrainingAnnouncementAction(IyaService iyaService) {
		this.iyaService = iyaService;
	}
	
	@Override
	public String execute() {
		super.execute();
		return Action.SUCCESS;
	}
	
	@Override
	public void prepare(){
		super.prepare();
		this.paged = this.iyaService.iyaTrainingAnnoucements(this.startAt, this.maxResults);
		
		if(this.id != null)
			this.announcement = this.iyaService.loadAnnouncement(this.id);
	}

	public String edit(){
		this.announcement = this.iyaService.saveAnnouncement(this.announcement);
		return Action.SUCCESS;
	}
	
	public String input(){
		return "input";
	}
	/**
	 * @return the paged
	 */
	public PagedResult<IYATrainingAnnouncement> getPaged() {
		return paged;
	}
	
	public String saveAnnouncement(){
		if(this.announcement==null)
			this.announcement = new IYATrainingAnnouncement();
		this.announcement.setSponsor(sponsor);
		this.announcement.setOrganizer(organizer);
		
		this.announcement = this.iyaService.saveAnnouncement(this.announcement);
		return Action.SUCCESS;
	}
	
	public String details(){		
		if(this.announcement==null)
			return Action.ERROR;
		else
			return Action.SUCCESS;
	}
	
	public String removeAnnouncement() throws Exception {
		
		this.announcement = this.iyaService.loadAnnouncement(id);		
		try {
			this.iyaService.removeAnnouncementItems(this.announcement);
			this.iyaService.ensureRemoved(this.announcement);
		}
		catch (javax.persistence.PersistenceException e) {
			addActionError("Announcement could not be removed due to constraints violation.");
			return Action.ERROR;
		}
 		return Action.SUCCESS;
	}
	
	/**
	 * @param announcements the announcements to set
	 */
	public void setAnnouncement(IYATrainingAnnouncement announcement) {
		this.announcement = announcement;
	}

	/**
	 * @return the announcement
	 */
	public IYATrainingAnnouncement getAnnouncement() {
		return announcement;
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
	 * @param obj the obj to set
	 */
	public void setObj(IYAAnnouncementObjective obj) {
		this.obj = obj;
	}

	/**
	 * @return the obj
	 */
	public IYAAnnouncementObjective getObj() {
		return obj;
	}


	/**
	 * @param sponsor the sponsor to set
	 */
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	/**
	 * @return the sponsor
	 */
	public String getSponsor() {
		return sponsor;
	}

	/**
	 * @param organizer the organizer to set
	 */
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	/**
	 * @return the organizer
	 */
	public String getOrganizer() {
		return organizer;
	}


	
}
