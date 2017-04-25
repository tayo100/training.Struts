package org.iita.trainingunit.iya.action;

import org.iita.crm.action.BaseAction;
import org.iita.trainingunit.iya.model.IYATrainingAnnouncement;
import org.iita.trainingunit.iya.service.IyaService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class IyaAnnouncementAction extends BaseAction implements Preparable {
	private IyaService iyaService;
	private PagedResult<IYATrainingAnnouncement> paged;

	private IYATrainingAnnouncement announcement;
	
	protected int startAt = 0, maxResults = 50;
	private Long id;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IyaAnnouncementAction(IyaService iyaService) {
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
	
	/**
	 * @return the paged
	 */
	public PagedResult<IYATrainingAnnouncement> getPaged() {
		return paged;
	}
	
	
	public String input(){
		return "input";
	}

	public String saveAnnouncement(){
		this.announcement = this.iyaService.saveAnnouncement(this.announcement);
		return Action.SUCCESS;
	}
	
	public String details(){		
		if(this.announcement==null)
			return Action.ERROR;
		else
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
	
}
