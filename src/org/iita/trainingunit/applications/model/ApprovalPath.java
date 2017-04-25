package org.iita.trainingunit.applications.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;
import org.iita.security.model.User;
import org.iita.trainingunit.model.CostCenter;

@Entity
public class ApprovalPath extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3688063400534810652L;
	private CostCenter costCenter;
	private User user;
	private float amountLimit;

	/**
	 * Get the parent TravelAuthorization record
	 * 
	 * @see TravelAuthorization
	 * @return the travelAuthorization
	 */
	@ManyToOne(cascade = {}, optional = false)
	@JoinColumn(name = "BUDGET_CODE")
	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	@ManyToOne(cascade = {}, optional = false)
	public User getUser() {
		return user;
	}

	/**
	 *@return Links up the the Budget Code to the Approver's (User) action
	 **/
	public void setUser(User user) {
		this.user = user;
	}

	public float getAmountLimit() {
		return amountLimit;
	}

	public void setAmountLimit(float amountLimit) {
		this.amountLimit = amountLimit;
	}
}
