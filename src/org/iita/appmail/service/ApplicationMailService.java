/**
 * newsletter.Struts Apr 1, 2010
 */
package org.iita.appmail.service;

import javax.mail.internet.MimeMessage;

import org.iita.appmail.model.MailMessage;
import org.iita.util.PagedResult;


/**
 * Application mail service.
 * 
 * @author mobreza
 */
public interface ApplicationMailService {

	/**
	 * Store.
	 * 
	 * @param mailMessage the mail message
	 */
	void store(MailMessage mailMessage);

	/**
	 * Load.
	 * 
	 * @param id the id
	 * 
	 * @return the mail message
	 */
	MailMessage load(Long id);

	/**
	 * Load by id.
	 * 
	 * @param messageId the message id
	 * 
	 * @return the mail message
	 */
	MailMessage loadById(String messageId);

	/**
	 * List stored mail messages.
	 * 
	 * @param startAt the start at
	 * @param maxResults the max results
	 * 
	 * @return the paged result< mail message>
	 */
	PagedResult<MailMessage> list(int startAt, int maxResults);

	/**
	 * Mail message was received for the application, the method will persist the message to database and return a {@link MailMessage} object
	 * 
	 * @param cmsg
	 */
	MailMessage receive(MimeMessage cmsg);
}
