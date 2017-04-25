package org.iita.trainingunit.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.iita.security.model.User;
import org.iita.trainingunit.applications.model.ApprovalPath;

@Entity
@Indexed
public class CostCenter {
	private String code;
	private User holder;
	private String type;
	private String description;
	private String budgetHolder;
	private User rollupUser;
	private List<ApprovalPath> approvalPath;
	
	@ManyToOne(cascade = {}, optional = true)
	@JoinColumn(name = "user_id")
	public User getHolder() {
		return holder;
	}

	public void setHolder(User holder) {
		this.holder = holder;
	}
	
	@Column(length = 20, name = "CATEGORY")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the code
	 */
	@Id
	@Column(nullable = false, updatable = false, unique = true, name = "BUDGET_CODE", length = 20)
	@DocumentId
	public String getCode() {
		return this.code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	@Column(nullable = false, updatable = false, name = "DESCR")
	@Field(index = Index.TOKENIZED, store = Store.NO)
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Get approval path records
	 * 
	 * @return
	 */
	@OneToMany(cascade = {}, mappedBy = "costCenter")
	@OrderBy("amountLimit")
	public List<ApprovalPath> getApprovalPath() {
		return approvalPath;
	}

	public void setApprovalPath(List<ApprovalPath> approvalPath) {
		this.approvalPath = approvalPath;
	}

	/**
	 * Rollup leader
	 * 
	 * @return
	 */
	@ManyToOne(cascade = {}, optional = true)
	public User getRollupUser() {
		return rollupUser;
	}

	public void setRollupUser(User rollupUser) {
		this.rollupUser = rollupUser;
	}

	/**
	 * Get budget holder name as imported from Oracle
	 * 
	 * @return
	 */
	@Column(name = "BUDGET_HOLDER", length = 255)
	public String getBudgetHolder() {
		return budgetHolder;
	}

	public void setBudgetHolder(String budgetHolder) {
		this.budgetHolder = budgetHolder;
	}

	/**
	 * String representation of this object
	 */
	@Override
	public String toString() {
		return new StringBuffer().append(getCode()).append(" [").append(getType()).append("] ").append(getDescription()).toString();
	}
}
