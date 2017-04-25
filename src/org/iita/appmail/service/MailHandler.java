/**
 * projecttask.Struts Apr 6, 2010
 */
package org.iita.appmail.service;

import java.io.IOException;

import javax.mail.MessagingException;

import org.iita.appmail.model.MailMessage;

/**
 * An interface defining project-specific mail handers. If handler is defined, the {@link #handle} method will be called to address project specific
 * needs of incoming mail messages.
 * 
 * @author mobreza
 */
public interface MailHandler {

	/**
     * @param mailMessage
	 * @throws IOException 
	 * @throws MessagingException 
     */
    void handle(MailMessage mailMessage) throws MessagingException, IOException;
}
