/**
 * 
 */
package org.iita.trainingunit.applications.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.iita.security.model.User;
import org.iita.trainingunit.model.CostCenter;

/**
 * @author ken
 *
 */
@Entity
public class BudgetCode extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private BCodeStatus status = BCodeStatus.NEW;
	private User budgetHolder;
	private User nextApprover;
	private InternalApprovals internalApproval;
	private CostCenter costCenter = null;

	/**
	 * Get cost center budget code
	 * 
	 * @return
	 */
	@Column(nullable = false, length = 20)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Get next approver
	 * 
	 * @return
	 */
	@ManyToOne(cascade = {}, optional = true)
	public User getNextApprover() {
		return nextApprover;
	}

	public void setNextApprover(User nextApprover) {
		this.nextApprover = nextApprover;
	}

	@ManyToOne(cascade = {}, optional = true)
	public User getBudgetHolder() {
		return budgetHolder;
	}

	public void setBudgetHolder(User budgetHolder) {
		this.budgetHolder = budgetHolder;
	}

	@ManyToOne(cascade = {}, optional = false)
	public InternalApprovals getInternalApproval() {
		return internalApproval;
	}

	public void setInternalApproval(InternalApprovals internalApproval) {
		this.internalApproval = internalApproval;
	}

	/**
	 * Status of approval.
	 * 
	 * @param status
	 */
	public void setStatus(BCodeStatus status) {
		this.status = status;
	}

	public BCodeStatus getStatus() {
		return status;
	}

	/**
	 * @return the costCenter
	 */
	@ManyToOne(cascade = {})
	public CostCenter getCostCenter() {
		return this.costCenter;
	}

	/**
	 * @param costCenter the costCenter to set
	 */
	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}
}
