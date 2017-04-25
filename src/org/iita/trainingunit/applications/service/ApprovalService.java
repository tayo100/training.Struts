package org.iita.trainingunit.applications.service;

import java.util.List;

import org.iita.security.model.User;
import org.iita.trainingunit.applications.model.Application;

/**
 * Approval process interface
 * 
 * @author koraegbunam
 * 
 */
public interface ApprovalService {

	/**
	 * Approve application and move it to next state. This method will call internal approve method and then auto-approve where possible.
	 * 
	 * @param app
	 * @param approver
	 * @throws ApprovalException
	 */
	void approve(Application app, User approver, String comment) throws ApprovalException;

	/**
	 * General reject method Will call appropriate reject method based on current status
	 * 
	 * @param app
	 * @param rejecter
	 * @param comment
	 * @throws ApprovalException
	 */
	void reject(Application app, User rejecter, String comment) throws ApprovalException;

	/**
	 * Rerun approvals from Action log (in case CC approvers change)
	 * 
	 * @param results
	 */
	void reapprove(List<Application> results);
}
