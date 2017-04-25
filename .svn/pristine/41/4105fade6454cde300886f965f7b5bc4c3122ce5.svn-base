package org.iita.trainingunit.iya.action;

import java.util.List;

import org.iita.crm.action.BaseAction;
import org.iita.trainingunit.iya.model.IYARegistration;
import org.iita.trainingunit.iya.service.IyaService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class IyaRegistrationAction extends BaseAction implements Preparable {
	private IyaService iyaService;
	
	private PagedResult<IYARegistration> registrations;
	private List<IYARegistration> iyaRegistrations;
	private IYARegistration registration;
	protected int startAt = 0, maxResults = 50;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IyaRegistrationAction(IyaService iyaService) {
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
		this.iyaRegistrations = this.iyaService.iyaRegistrations();
	}
	
	
	public String input(){
		return "input";
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
