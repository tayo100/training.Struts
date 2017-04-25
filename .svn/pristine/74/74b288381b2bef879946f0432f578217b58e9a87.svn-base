/**
 * newsletter.Struts Apr 1, 2010
 */
package org.iita.appmail.action;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.iita.appmail.model.MailMessage;
import org.iita.appmail.service.ApplicationMailService;
import org.iita.struts.BaseAction;

import com.opensymphony.xwork2.Action;

/**
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public class MailAction extends BaseAction {
	private ApplicationMailService applicationMailService;
	private Long id;
	private MailMessage message = null;

	/**
	 * @param applicationMailService
	 * 
	 */
	public MailAction(ApplicationMailService applicationMailService) {
		this.applicationMailService = applicationMailService;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @see org.iita.struts.BaseAction#prepare()
	 */
	@Override
	public void prepare() {
		if (this.id != null)
			this.message = this.applicationMailService.load(this.id);
	}

	/**
	 * @see org.iita.struts.BaseAction#execute()
	 */
	@Override
	public String execute() {
		if (this.message == null) {
			addActionError("No such mail message");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	/**
	 * @return the message
	 */
	public MailMessage getMessage() {
		return this.message;
	}
	
	public MimeMessage getMimeMessage() throws MessagingException, IOException {
		return this.message.getMessage();
	}
}
