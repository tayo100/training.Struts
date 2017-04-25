package org.iita.trainingunit.iya.action;

import java.util.List;

import org.iita.crm.action.BaseAction;
import org.iita.trainingunit.iya.model.IYARegistration;
import org.iita.trainingunit.iya.model.IYATrainingAnnouncement;
import org.iita.trainingunit.iya.service.IyaService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class DashboardIyaAction extends BaseAction implements Preparable {
	private IyaService iyaService;
	private PagedResult<IYATrainingAnnouncement> announcements;
	private List<IYATrainingAnnouncement> iyaAnnouncements;
	private IYATrainingAnnouncement announcement;
	
	private PagedResult<IYARegistration> registrations;
	private List<IYARegistration> iyaRegistrations;
	private IYARegistration registration;
	protected int startAt = 0, maxResults = 50;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DashboardIyaAction(IyaService iyaService) {
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
		this.iyaAnnouncements = this.iyaService.iyaAnnoucements();
		this.iyaRegistrations = this.iyaService.iyaRegistrations();
	}

	/**
	 * @return the announcement
	 */
	public PagedResult<IYATrainingAnnouncement> getAnnouncements() {
		return announcements;
	}
	
	
	public String input(){
		return "input";
	}

	public String saveAnnouncement(){
		this.announcement = this.iyaService.saveAnnouncement(this.announcement);
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
	 * @param registrations the registrations to set
	 */
	public void setRegistrations(PagedResult<IYARegistration> registrations) {
		this.registrations = registrations;
	}

	/**
	 * @return the registrations
	 */
	public PagedResult<IYARegistration> getRegistrations() {
		return registrations;
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
	 * @param iyaAnnouncements the iyaAnnouncements to set
	 */
	public void setIyaAnnouncements(List<IYATrainingAnnouncement> iyaAnnouncements) {
		this.iyaAnnouncements = iyaAnnouncements;
	}

	/**
	 * @return the iyaAnnouncements
	 */
	public List<IYATrainingAnnouncement> getIyaAnnouncements() {
		return iyaAnnouncements;
	}

	/**
	 * @param iyaRegistrations the iyaRegistrations to set
	 */
	public void setIyaRegistrations(List<IYARegistration> iyaRegistrations) {
		this.iyaRegistrations = iyaRegistrations;
	}

	/**
	 * @return the iyaRegistrations
	 */
	public List<IYARegistration> getIyaRegistrations() {
		return iyaRegistrations;
	}
	
	
	
}
