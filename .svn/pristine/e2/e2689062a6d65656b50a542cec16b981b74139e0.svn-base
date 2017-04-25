/**
 * 
 */
package org.iita.trainingunit.applications.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.iita.entity.VersionedEntity;
import org.iita.trainingunit.applications.model.InternalApprovals.SIGNATURE;

/**
 * @author ken
 *
 */
@Entity
public class Affirmation extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 680852113075931007L;
	private String institution;
	private SIGNATURE directorApproval = SIGNATURE.PENDING;
	private Date approvalDate;
	private NonDegreeTraining nonDegree;


	@Column(length = 150)
	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	public SIGNATURE getDirectorApproval() {
		return directorApproval;
	}

	public void setDirectorApproval(SIGNATURE directorApproval) {
		this.directorApproval = directorApproval;
	}

	@Temporal(TemporalType.DATE)
	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
	
	public void setNonDegree(NonDegreeTraining nonDegree) {
		this.nonDegree = nonDegree;
	}
	
	@OneToOne(optional = false, cascade = {})
	public NonDegreeTraining getNonDegree() {
		return nonDegree;
	}
}
