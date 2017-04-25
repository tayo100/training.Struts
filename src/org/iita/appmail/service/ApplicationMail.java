/**
 * newsletter.Struts Apr 1, 2010
 */
package org.iita.appmail.service;

import java.io.ByteArrayOutputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.appmail.model.MailMessage;
import org.iita.util.PagedResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mobreza
 * 
 */
public class ApplicationMail implements ApplicationMailService {
	private static final Log LOG = LogFactory.getLog(ApplicationMail.class);
	protected EntityManager entityManager;
	private MailHandler mailHandler;

	/**
	 * @param projectMailHandler the projectMailHandler to set
	 */
	public void setMailHandler(MailHandler mailHandler) {
		this.mailHandler = mailHandler;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * @see org.iita.appmail.service.ApplicationMailService#list(int, int)
	 */
	@Override
	@Transactional(readOnly = true)
	public PagedResult<MailMessage> list(int startAt, int maxResults) {
		PagedResult<MailMessage> paged = new PagedResult<MailMessage>(startAt, maxResults);
		paged.setResults(this.entityManager.createQuery("from MailMessage m order by m.createdDate desc").setMaxResults(maxResults).setFirstResult(startAt)
				.getResultList());
		if (paged.getResults().size() > 0)
			paged.setTotalHits(((Long) this.entityManager.createQuery("select count(m) from MailMessage m").getSingleResult()).longValue());
		return paged;
	}

	/**
	 * @return
	 * @see org.iita.appmail.service.ApplicationMailService#receive(javax.mail.internet.MimeMessage)
	 */
	@Override
	@Transactional
	public MailMessage receive(MimeMessage message) {
		LOG.info("Converting MimeMessage to MailMessage for storage");
		MailMessage mailMessage = new MailMessage();
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			message.writeTo(baos);
			byte[] bytes = baos.toByteArray();
			mailMessage.setData(bytes);
			mailMessage.setMessageId(message.getHeader("message-id")[0]);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return null;
		}

		// find referenced message
		try {
			String[] headers = message.getHeader("In-Reply-To");
			if (headers != null)
				for (String inReplyTo : headers) {
					LOG.debug("Message In-Reply-To: " + inReplyTo);
					MailMessage originalMessage = loadById(inReplyTo);
					if (originalMessage != null) {
						LOG.info("Found original message: " + originalMessage.getId());
						mailMessage.setInReplyTo(originalMessage);
						this.entityManager.merge(mailMessage);
						break;
					}
				}
		} catch (MessagingException e1) {
			LOG.error("Could not find In-Reply-To header");
		}

		this.store(mailMessage);
		if (this.mailHandler != null) {
			// handle mail in project specific way
			try {
				this.mailHandler.handle(mailMessage);
			} catch (Exception e) {
				LOG.error("Project mail handler failed: " + e.getMessage());
				LOG.error("Ignoring handler.");
			}
		}
		return mailMessage;
	}

	/**
	 * @see org.iita.appmail.service.ApplicationMailService#store(org.iita.appmail.model.MailMessage)
	 */
	@Override
	@Transactional
	public void store(MailMessage mailMessage) {
		LOG.info("Persisting MailMessage " + mailMessage.getMessageId());

		if (mailMessage.getId() == null)
			this.entityManager.persist(mailMessage);
		else
			this.entityManager.merge(mailMessage);
	}

	/**
	 * @see org.iita.appmail.service.ApplicationMailService#load(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly = true)
	public MailMessage load(Long id) {
		return this.entityManager.find(MailMessage.class, id);
	}

	/**
	 * @see org.iita.appmail.service.ApplicationMailService#loadById(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public MailMessage loadById(String messageId) {
		try {
			return (MailMessage) this.entityManager.createQuery("from MailMessage m where m.messageId=?").setParameter(1, messageId).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
