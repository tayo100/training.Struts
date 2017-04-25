/**
 * travelauth.Struts May 22, 2009
 */
package org.iita.trainingunit.applications.action;

import org.iita.struts.BaseAction;
import org.iita.trainingunit.applications.service.ApprovalException;
import org.iita.trainingunit.applications.service.ApprovalService;

/*
 * *
 * 
 * @author KOraegbunam
 */
@SuppressWarnings("serial")
public abstract class ApproveBaseAction extends BaseAction {

	protected ApprovalService approvalService;

	public abstract String reject();

	public abstract String approve() throws ApprovalException;

	protected String comment;

	/**
	 * @param approvalService2
	 */
	public ApproveBaseAction(ApprovalService approvalService) {
		this.approvalService=approvalService;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}