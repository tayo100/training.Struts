package org.iita.crm.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.hibernate.search.annotations.ClassBridge;
import org.hibernate.search.annotations.Indexed;
import org.iita.entity.VersionedEntity;

/**
 * Abstract Contact class links subclasses ({@link AddressContact}, {@link EmailContact}, ...) to a either {@link Person} or {@link Organization}.
 * 
 * @author mobreza
 * @author KOraegbunam
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Indexed
@ClassBridge(impl = org.iita.crm.lucene.ContactBridge.class)
public abstract class Contact extends VersionedEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2366247075078219943L;

	/** The person. */
	private Person person;

	/** The organization. */
	private Organization organization;
	
	/** The partner. */
	private Partner partner;

	/** The active. */
	private boolean active = true;

	/**
	 * Gets the person.
	 * 
	 * @return the person
	 */
	@ManyToOne(cascade = {})
	public Person getPerson() {
		return person;
	}

	/**
	 * Sets the person.
	 * 
	 * @param person the new person
	 */
	public void setPerson(Person person) {
		this.person = person;
		if (this.person != null)
			this.organization = null;
	}

	/**
	 * Gets the organization.
	 * 
	 * @return the organization
	 */
	@ManyToOne(cascade = {})
	public Organization getOrganization() {
		return this.organization;
	}

	/**
	 * Sets the organization.
	 * 
	 * @param organization the organization to set
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
		if (this.organization != null)
			this.person = null;
	}
	
	/**
	 * Gets the partner.
	 * 
	 * @return the partner
	 */
	@ManyToOne(cascade = {CascadeType.REMOVE})
	public Partner getPartner() {
		return this.partner;
	}

	/**
	 * Sets the partner.
	 * 
	 * @param partner the partner to set
	 */
	public void setPartner(Partner partner) {
		this.partner = partner;
		if (this.partner != null)
			this.person = null;
	}

	/**
	 * Checks if is active.
	 * 
	 * @return true, if is active
	 */
	public boolean isActive() {
		return this.active;
	}

	/**
	 * Sets the active.
	 * 
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
}
