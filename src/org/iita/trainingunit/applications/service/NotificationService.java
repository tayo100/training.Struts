/**
 * travelauth.Struts May 25, 2009
 */
package org.iita.trainingunit.applications.service;

import org.iita.security.model.User;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.model.Approval;
import org.iita.trainingunit.applications.model.BudgetCode;

/**
 * Notification service provides mechanisms of informing next approvers or application owners of changes in the request
 * 
 * @author KOraegbunam
 * 
 */
public interface NotificationService {
	/**
	 * Notify pending budget holders an application is awaiting approval
	 * 
	 * @param application
	 */
	void budgetHoldersPending(Application app);

	/**
	 * Notify CDOs that an application is awaiting their approval.
	 * 
	 * @param application
	 */
	void CDOPending(Application app);

	/**
	 * Send message to next approver of a budget code
	 * 
	 * @param budgetCode
	 */
	void budgetHolderPending(BudgetCode approval);

	/**
	 * Notify user that application on budget code was rejected
	 * 
	 * @param budgetCode
	 */
	void budgetCodeRejected(BudgetCode approval, String comment);

	/**
	 * @param application
	 */
	void CDOApproved(Application app);
	
	/**
	 * @param application
	 */
	void CDOCanceled(Application app);

	/**
	 * @param application
	 */
	void CDORejected(Application app, String comment);

	/**
	 * @param application
	 * @param nextApprover
	 * @param amountLimit
	 */
	void autoApproved(Application app, User nextApprover, Double amountLimit);

	/**
	 * Send notification status depending on application status
	 * 
	 * @param application
	 * @param comment 
	 */
	void notifyByStatus(Application app, String comment);
	
	void directorRejected(Application app, String comment);

	void directorPending(Application app);

	void directorAutoApproved(Application app, User nextApprover);
	
	/**
	 * Notify CFOs that an application is awaiting their approval.
	 * 
	 * @param app
	 */
	void CFOPending(Application app);

	
	/**
	 * @param app
	 */
	void CFOApproved(Application app);
	
	/**
	 * @param app
	 */
	void CFOCanceled(Application app);

}
