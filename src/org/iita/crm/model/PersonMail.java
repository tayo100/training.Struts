/**
 * promisCRM.Struts Apr 27, 2010
 */
package org.iita.crm.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.iita.appmail.model.MailMessage;
import org.iita.entity.SimpleEntity;

/**
 * @author mobreza
 *
 */
@Entity
public class PersonMail extends SimpleEntity {
	private static final long serialVersionUID = -8342082352520650277L;
	private Person person;
	private MailMessage message;
	/**
	 * @return the person
	 */
	@ManyToOne(cascade = {}, optional = false)
	public Person getPerson() {
		return this.person;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	/**
	 * @return the message
	 */
	@ManyToOne(cascade = {}, optional = false)
	public MailMessage getMessage() {
		return this.message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(MailMessage message) {
		this.message = message;
	}
}
