package org.iita.trainingunit.announcements.action;

import java.util.List;

import org.iita.crm.action.BaseAction;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.service.AnnouncementService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class PublicAnnouncementAction extends BaseAction implements Preparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1417523288661425735L;
	private AnnouncementService announcementService;
	private List<Announcement> groups;
	private List<Announcement> graduates;
	private List<Announcement> nonDegrees;
	private List<Announcement> others;
	private List<Announcement> iframeAll;
	
	private Long id;
	private Announcement announcement;
	
	public PublicAnnouncementAction(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}
	
	public List<Announcement> getGroups() {
		return groups;
	}
	
	public List<Announcement> getGraduates() {
		return graduates;
	}
	
	public List<Announcement> getNonDegrees() {
		return nonDegrees;
	}
	
	public List<Announcement> getOthers() {
		return others;
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
		
		this.groups = this.announcementService.list("Group");
		this.graduates = this.announcementService.list("Graduate");
		this.nonDegrees = this.announcementService.list("Non-degree");
		this.others = this.announcementService.list("Other");
		this.iframeAll = this.announcementService.listAll();
	}
	
	public String execute() {
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

	public void setIframeAll(List<Announcement> iframeAll) {
		this.iframeAll = iframeAll;
	}

	public List<Announcement> getIframeAll() {
		return iframeAll;
	}
}