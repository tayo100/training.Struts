/**
 * newsletter.Struts Apr 1, 2010
 */
package org.iita.appmail.action;

import org.iita.appmail.model.MailMessage;
import org.iita.appmail.service.ApplicationMailService;
import org.iita.struts.BaseAction;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;

/**
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public class ListMailAction extends BaseAction {
	private static final int maxResults = 20;
	private ApplicationMailService applicationMailService;
	private int startAt = 0;
	private PagedResult<MailMessage> paged;

	/**
	 * @param applicationMailService
	 * 
	 */
	public ListMailAction(ApplicationMailService applicationMailService) {
		this.applicationMailService = applicationMailService;
	}

	/**
	 * @see org.iita.struts.BaseAction#execute()
	 */
	@Override
	public String execute() {
		this.paged = this.applicationMailService.list(this.startAt, maxResults);
		return Action.SUCCESS;
	}
	
	/**
	 * @return the paged
	 */
	public PagedResult<MailMessage> getPaged() {
		return this.paged;
	}
}
