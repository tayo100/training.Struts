/**
 * newsletter.Struts Apr 1, 2010
 */
package org.iita.appmail.service;

import java.io.IOException;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.SharedByteArrayInputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mobreza
 * 
 */
public class MailJMSReceiver implements SessionAwareMessageListener {
	private static final Log LOG = LogFactory.getLog(MailJMSReceiver.class);
	private ApplicationMailService applicationMailService;

	/**
	 * @param applicationMailService 
	 * 
	 */
	public MailJMSReceiver(ApplicationMailService applicationMailService) {
		this.applicationMailService=applicationMailService;
		LOG.info("Mail JMS receiver is up");
	}
	
	/**
	 * @see org.springframework.jms.listener.SessionAwareMessageListener#onMessage(javax.jms.Message, javax.jms.Session)
	 */
	@Override
	@Transactional
	public void onMessage(Message message, Session session) throws JMSException {
		LOG.info("Received JMQ message");
		if (!(message instanceof BytesMessage)) {
			LOG.warn("Message is not bytes message");
			return;
		}
		BytesMessage bytesMessage = (BytesMessage) message;
		int len = (int) bytesMessage.getBodyLength();
		byte[] data = new byte[len];
		bytesMessage.readBytes(data);
		// message is received
		MimeMessage cmsg=null;
		try {
			SharedByteArrayInputStream bis = new SharedByteArrayInputStream(data);
			cmsg = new MimeMessage((javax.mail.Session) null, bis);
			bis.close();
		} catch (MessagingException e) {
			LOG.error("Error getting MimeMessage: " + e.getMessage());
		} catch (IOException e) {
			LOG.error("IO error: " + e.getMessage());
		}
		
		if (cmsg!=null) {
			LOG.info("Mail received via JMS");
			try {
				LOG.info("From: " + cmsg.getSender());
				LOG.info("Subject: " + cmsg.getSubject());
			} catch (MessagingException e) {
				
			}
			this.applicationMailService.receive(cmsg);
		}
	}

}
