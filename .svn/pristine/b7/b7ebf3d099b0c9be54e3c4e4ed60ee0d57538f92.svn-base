/**
 * promisCRM.Struts Apr 27, 2010
 */
package org.iita.crm.service;

import java.io.IOException;
import java.util.List;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.appmail.model.MailMessage;
import org.iita.appmail.service.MailHandler;
import org.iita.crm.model.Person;
import org.iita.crm.model.PersonMail;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author mobreza
 */
public class MailHandlerImpl implements MailHandler {
	private static final Log LOG = LogFactory.getLog(MailHandlerImpl.class);
	protected EntityManager entityManager;

	/**
	 * @param entityManager the entityManager to set
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * 
	 * @see org.iita.appmail.service.MailHandler#handle(org.iita.appmail.model.MailMessage)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void handle(MailMessage mailMessage) throws MessagingException, IOException {
		for (Address senderAddress : mailMessage.getMessage().getFrom()) {
			InternetAddress internetAddress = (InternetAddress) senderAddress;
			LOG.info("Mail from: " + internetAddress.getAddress());
			List<Person> persons=this.entityManager.createQuery("select distinct p from EmailContact e inner join e.person p where e.email=:email").setParameter("email", internetAddress.getAddress()).getResultList();
			for (Person person : persons) {
				LOG.debug("Linking " + mailMessage + " to " + person);
				PersonMail pm = new PersonMail();
				pm.setPerson(person);
				pm.setMessage(mailMessage);
				this.entityManager.persist(pm);
			}
		}
	}
}
