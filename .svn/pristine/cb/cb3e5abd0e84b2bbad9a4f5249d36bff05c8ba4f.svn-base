package org.iita.trainingunit.applications.action;

import org.iita.struts.AllowedParameters;
import org.iita.trainingunit.applications.model.BudgetCode;
import org.iita.trainingunit.applications.service.ApprovalException;
import org.iita.trainingunit.applications.service.ApprovalService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

@SuppressWarnings("serial")
public class ApproveBudgetAction extends ApproveBaseAction {
	private BudgetCode budgetCode;
	private String extraComment = null;

	public ApproveBudgetAction(ApprovalService approvalService) {
		super(approvalService);
	}

	@TypeConversion(converter = "genericConverter")
	public void setBudgetCode(BudgetCode budgetCode) {
		this.budgetCode = budgetCode;
	}

	public BudgetCode getBudgetCode() {
		return budgetCode;
	}

	@Override
	@AllowedParameters({"budgetCode", "comment"})
	public String approve() throws ApprovalException {
		if (this.budgetCode == null) {
			addActionError("Cost Center not provided");
			return Action.INPUT;
		}
		try {
			if (!this.getUser().getId().equals(this.budgetCode.getBudgetHolder().getId())) {
				extraComment = " Approved by " + this.getPrincipal().getFullName();
				this.approvalService.approve(this.budgetCode.getInternalApproval().getApplication(), this.budgetCode.getNextApprover(), this.comment + extraComment);
				// addActionMessage("TA request approved successfully!");
				return "monitor";
			} else {
				extraComment = " Approved by " + this.getPrincipal().getFullName();
				this.approvalService.approve(this.budgetCode.getInternalApproval().getApplication(), this.getUser(), this.comment + extraComment);
				return Action.SUCCESS;
			}
		} catch (ApprovalException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
	}

	@Override
	@AllowedParameters({"budgetCode", "comment"})
	public String reject() {
		if (this.budgetCode == null) {
			addActionError("Cost Center not provided");
			return Action.INPUT;
		}
		try {
			if (!this.getUser().getId().equals(this.budgetCode.getBudgetHolder().getId())) {
				extraComment = " Rejected by " + this.getPrincipal().getFullName();
				this.approvalService.reject(this.budgetCode.getInternalApproval().getApplication(), this.budgetCode.getNextApprover(), this.comment + extraComment);
				//addActionMessage("Application request rejected successfully!");
				return "monitor";
			} else {
				this.approvalService.reject(this.budgetCode.getInternalApproval().getApplication(), this.getUser(), this.comment + extraComment);
				return Action.SUCCESS;
			}
		} catch (ApprovalException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
	}
}
