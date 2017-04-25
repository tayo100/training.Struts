package org.iita.trainingunit.announcements.action;

import org.iita.crm.action.BaseAction;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.service.AnnouncementException;
import org.iita.trainingunit.announcements.service.AnnouncementService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class AnnouncementAction extends BaseAction implements Preparable {
	private static final long serialVersionUID = -1417523288661425735L;
	private AnnouncementService announcementService;
	private PagedResult<? extends Announcement> paged;
	protected int startAt = 0, maxResults = 50;
	private Long id;
	private Announcement announcement;
	
	public AnnouncementAction(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}
	
	public PagedResult<? extends Announcement> getPaged() {
		return paged;
	}
	
	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	public void prepare(){
		if(this.id!=null)
			this.announcement =this.announcementService.find(this.id);
		
		this.paged = this.announcementService.list(startAt, maxResults);
	}
	
	public String execute() {
		return Action.SUCCESS;
	}

	public String newAnnouncement() throws AnnouncementException {
		this.announcement = this.announcementService.createNew(getUser());
		return Action.SUCCESS;
	}
	
	public String delete() throws AnnouncementException {
		if (this.announcement != null) {
			this.announcementService.delete(this.announcement);
			addActionMessage("Announcement record deleted!");
		} else {
			addActionError("No announcement record found for deletion!");
		}
		return Action.SUCCESS;
	}
	
	@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "announcement.type", trim=true, message = "Select announcement type"),
			@RequiredStringValidator(fieldName = "announcement.title", trim=true, message = "Enter announcement title"),
			@RequiredStringValidator(fieldName = "announcement.introduction", trim=true, message = "Enter announcement introduction")})
	public String save(){
		try{
			if(this.announcement!=null){
				
				this.announcementService.save(this.announcement);
				
				if(this.announcement.getId()!=null)
					addActionMessage("Announcement updated successfully!");
				else
					addActionMessage("Announcement filed successfully!");
							
				return Action.SUCCESS;
			}else{
				addActionError("Error adding CDO announcement! Announcement entity is empty.");
				return Action.ERROR;
			}
		}catch(Exception e){
			addActionError("Error adding CDO announcement! " + e.getMessage());
			return Action.ERROR;
		}
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public Announcement getAnnouncement() {
		return announcement;
	}
}