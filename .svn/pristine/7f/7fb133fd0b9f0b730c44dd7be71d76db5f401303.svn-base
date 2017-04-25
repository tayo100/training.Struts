/**
 * training.Struts Feb 5, 2010
 */
package org.iita.crm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.iita.entity.VersionedEntity;
import org.iita.util.StringUtil;

/**
 * {@link Person}s can be affiliated to {@link Organization}s. This class holds the affiliation information.
 * 
 * @author KOraegbunam
 */
@Entity
public class PartnerPersonContact extends VersionedEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 770865896045775053L;

	/** The partner. */
	private Partner partner;

	/** The person. */
	private Person person;

	/** The discipline. */
	private String discipline;

	/** The title title. */
	private String title;

	/** The type. */
	private AffiliationType type;
	
	/** The status. */
	private Status status;
	
	private String position;
	private String sourceFile;
	private String sourceFileRow;
	private String sourcePerson;
	private Date sourceDate;
	private String remarks;


	/**
	 * The Enum AffiliationType.
	 */
	public enum AffiliationType {
		/** Employee at partner organization */
		EMPLOYEE,
		/** Manager at partner organization */
		MANAGER,
		/** Trainee at partner organization */
		TRAINEE,
		/** Consultant at partner organization */
		CONSULTANT,
		/** IITA Contact at partner organization */
		IITA,
		UNSPECIFIED
	}
	
	/**
	 * The Enum Status.
	 */
	public enum Status {
		/** Active */
		ACTIVE,
		/** InActive */
		INACTIVE
	}

	/**
	 * Gets the partner.
	 * 
	 * @return the partner
	 */
	@ManyToOne(cascade = {}, optional = false)
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
	}

	/**
	 * Gets the person.
	 * 
	 * @return the person
	 */
	@ManyToOne(cascade = {}, optional = false)
	public Person getPerson() {
		return this.person;
	}

	/**
	 * Sets the person.
	 * 
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	@Enumerated(EnumType.STRING)
	public AffiliationType getType() {
		return this.type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type the type to set
	 */
	public void setType(AffiliationType type) {
		this.type = type;
	}
	
	
	/**
	 * Gets the status.
	 * 
	 * @return the status
	 */
	@Enumerated(EnumType.STRING)
	public Status getStatus() {
		return this.status;
	}

	/**
	 * Sets the status.
	 * 
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Gets the discipline.
	 * 
	 * @return the discipline
	 */
	@Column(length = 200)
	public String getDiscipline() {
		return this.discipline;
	}

	/**
	 * Sets the discipline.
	 * 
	 * @param discipline the discipline to set
	 */
	public void setDiscipline(String discipline) {
		this.discipline = StringUtil.nullOrString(discipline);
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	@Column(length = 200)
	public String getTitle() {
		return this.title;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = StringUtil.nullOrString(title);
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(length = 255)
	public String getPosition() {
		return position;
	}

	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}

	@Column(length = 255)
	public String getSourceFile() {
		return sourceFile;
	}

	public void setSourceFileRow(String sourceFileRow) {
		this.sourceFileRow = sourceFileRow;
	}

	@Column(length = 10)
	public String getSourceFileRow() {
		return sourceFileRow;
	}

	public void setSourcePerson(String sourcePerson) {
		this.sourcePerson = sourcePerson;
	}

	@Column(length = 255)
	public String getSourcePerson() {
		return sourcePerson;
	}

	public void setSourceDate(Date sourceDate) {
		this.sourceDate = sourceDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getSourceDate() {
		return sourceDate;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Lob
	public String getRemarks() {
		return remarks;
	}
	
}
