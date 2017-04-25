package org.iita.trainingunit.applications.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.crm.model.ActionLog;
import org.iita.crm.model.ActionLog.ActionType;
import org.iita.security.Authorize;
import org.iita.security.model.User;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.model.Application.APPLICATIONSTATUS;
import org.iita.trainingunit.applications.model.Approval;
import org.iita.trainingunit.applications.model.Approval.STATUS;
import org.iita.trainingunit.applications.model.ApprovalPath;
import org.iita.trainingunit.applications.model.BCodeStatus;
import org.iita.trainingunit.applications.model.BudgetCode;
import org.iita.trainingunit.applications.model.GraduateResearchTraining;
import org.iita.trainingunit.applications.model.GroupTraining;
import org.iita.trainingunit.applications.model.InternalApprovals;
import org.iita.trainingunit.applications.model.InternalApprovals.SIGNATURE;
import org.iita.trainingunit.applications.model.InternshipTraining;
import org.iita.trainingunit.applications.model.SabbaticalTraining;
import org.iita.trainingunit.applications.service.ApprovalException;
import org.iita.trainingunit.applications.service.ApprovalService;
import org.iita.trainingunit.applications.service.NotificationService;
import org.iita.trainingunit.model.CostCenter;
import org.springframework.transaction.annotation.Transactional;

public class ApprovalServiceImpl implements ApprovalService {
	private static Log LOG = LogFactory.getLog(ApprovalService.class);
	private NotificationService notificationService = null;
	private EntityManager entityManager;

	/**
	 * @param notificationService
	 * 
	 */
	public ApprovalServiceImpl(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
		
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	@Override
	@Transactional
	public void reject(Application app, User rejecter, String comment) throws ApprovalException {
		internalReject(app, rejecter, comment);

		// notify current
		this.notificationService.notifyByStatus(app, comment);
	}

	/**
	 * 
	 * @param ta
	 * @param rejecter
	 * @param comment
	 * @throws ApprovalException
	 */
	private void internalReject(Application app, User rejecter, String comment) throws ApprovalException {
		LOG.debug("Rejecting application with status " + app.getStatus());

		switch (app.getStatus()) {
		case WAITING:
			rejectBudgetCodes(app, rejecter, comment);
			break;
			
		case WAITINGFORDIRECTOR:
			rejectDirector(rejecter, app, comment);
			break;
			
		case WAITINGFORCDO:
			rejectCDO(app, rejecter, comment);
			break;
		
		case WAITINGFORCFO:
			rejectCFO(app, rejecter, comment);
			break;

		default:
			LOG.warn("Don't know how to approve application " + app.getId() + " in status " + app.getStatus());
		}
	}

	private void rejectBudgetCodes(Application app, User rejecter, String comment) throws ApprovalException {
		for (BudgetCode budgetCode : app.getInternalApprovals().getBudgetCodes()) {
			try {
				if (budgetCode.getNextApprover().getId().equals(rejecter.getId()))
					rejectBudgetCode(budgetCode, rejecter, comment);
			} catch (ApprovalException e) {
				LOG.error("User " + rejecter.getDisplayName() + " failed to reject application " + app.getId() + ". " + e.getMessage());
				LOG.error(e);
				throw e;
			}
		}
	}
	
	@Transactional
	public void rejectBudgetCode(BudgetCode budgetCode, User user, String comment) throws ApprovalException {
		LOG.warn("Rejecting application on budget code " + budgetCode.getCostCenter() + " by user " + user + " with comment: " + comment);
		CostCenter costCenter = this.entityManager.find(CostCenter.class, budgetCode.getCostCenter());

		// Check if User is in approval path
		if (isOnApprovalPath(costCenter, user)) {
			LOG.debug("User is on approval path, rejecting!");
			budgetCode.setStatus(BCodeStatus.REJECTED);
			budgetCode.getInternalApproval().getApplication().setStatus(APPLICATIONSTATUS.REJECTED);
			addActionLog(budgetCode.getInternalApproval().getApplication(), user, ActionType.REJECTED, "Reject application on " +  budgetCode.getCostCenter(), comment);
		} else {
			throw new ApprovalException("User " + user + " is not on the approval path.");
		}
	}
	
	@Override
	@Transactional
	public void approve(Application app, User approver, String comment) throws ApprovalException {
		internalApprove(app, approver, comment);
				
		int counter = 0;
		while (internalAutoApprove(app, app.getApprovers(), comment)) {
			LOG.trace("Auto-approval process continues.");
			if (counter++ == 30) {
				LOG.error("Loop in auto-approval mechanism! 30 loops so far!");
				break;
			}
		}

		// notify current
		LOG.info("Notifying about current status: " + app.getStatus().name());
		this.notificationService.notifyByStatus(app, comment);
	}

	/**
	 * Iterate over a list of users and call {@link #internalApprove(TravelAuthorization, User)} for each.
	 * 
	 * @param comment
	 * 
	 * @return <code>true</code> if at least one auto-approval was made
	 */
	private boolean internalAutoApprove(Application app, List<User> approvers, String comment) {
		if(app instanceof GraduateResearchTraining)
			app = (GraduateResearchTraining) app;
		else if(app instanceof GroupTraining)
			app = (GroupTraining) app;
		else if(app instanceof SabbaticalTraining)
			app = (SabbaticalTraining) app;
		else if(app instanceof InternshipTraining)
			app = (InternshipTraining) app;
		
		boolean oneApproved = false;
		LOG.info("Starting Auto-approval process for " + approvers.size() + " approvers.");
		for (User approver : approvers) {
			LOG.trace("Auto-approving for " + approver.getDisplayName());
			try {
				internalApprove(app, approver, comment);
				LOG.info("Auto-approved by " + approver.getDisplayName());
				oneApproved = true;
			} catch (ApprovalException e) {
				LOG.warn("Auto-approve error: " + e.getMessage());
			}
		}
		return oneApproved;
	}

	/**
	 * Approve TA and BudgetCodes depending on TA status
	 * 
	 * @param ta
	 * @param approver
	 * @param comment
	 */
	private void internalApprove(Application app, User approver, String comment) throws ApprovalException {
		LOG.debug("Approving application with status " + app.getStatus());
		LOG.info("internalApprove Method: Approving application with status " + app.getStatus());
		if(app instanceof GraduateResearchTraining)
			app = (GraduateResearchTraining) app;
		else if(app instanceof GroupTraining)
			app = (GroupTraining) app;
		else if(app instanceof SabbaticalTraining)
			app = (SabbaticalTraining) app;
		else if(app instanceof InternshipTraining)
			app = (InternshipTraining) app;
		
		switch (app.getStatus()) {
		case PENDING:
			fileNewApplication(app, approver);
			break;

		case WAITING:
			approveBudgetCodes(app, approver, comment);
			break;

		case WAITINGFORDIRECTOR:
			approveDirector(approver, app, comment);
			break;
			
		case WAITINGFORCDO:
			approveCDO(app, approver, comment);
			break;
		
		case WAITINGFORCFO:
			approveCFO(app, approver, comment);
			break;

		case APPROVED:
			throw new ApprovalException("Cannot approve an approved application");

		default:
			LOG.warn("Don't know how to approve application " + app.getId() + " in status " + app.getStatus());
		}
	}

	private void approveBudgetCodes(Application app, User approver, String comment) throws ApprovalException {
		//Check for director of the traveler/requester
		//LOG.info("approveBudgetCodes Method: APPROVER/USER PASSED" + approver.getFullName());	
		if(app instanceof GraduateResearchTraining)
			app = (GraduateResearchTraining) app;
		else if(app instanceof GroupTraining)
			app = (GroupTraining) app;
		else if(app instanceof SabbaticalTraining)
			app = (SabbaticalTraining) app;
		else if(app instanceof InternshipTraining)
			app = (InternshipTraining) app;
		
		boolean oneApproved = false;
		for (int i = 0; i < app.getInternalApprovals().getBudgetCodes().size(); i++) {
			BudgetCode budgetCode = app.getInternalApprovals().getBudgetCodes().get(i);
			if (budgetCode.getStatus() != BCodeStatus.WAITING)
				// can safely skip all that are not WAITING
				continue;
			try {
				if (budgetCode.getNextApprover() != null && budgetCode.getNextApprover().getId().equals(approver.getId())) {
					//LOG.info("approveBudgetCodes Method 2: APPROVER/USER PASSED" + approver.getFullName());
					approveBudgetCode(budgetCode, approver, comment);
					//LOG.info("approveBudgetCodes Method 3: APPROVER/USER PASSED" + approver.getFullName());
					oneApproved = true;
				}
			} catch (ApprovalException e) {
				LOG.error("User " + approver.getDisplayName() + " failed to approve application " + app.getId() + ". " + e.getMessage());
				LOG.error(e);
				throw e;
			}
		}
		if (!oneApproved)
			throw new ApprovalException("User " + approver.getDisplayName() + " cannot approve any budget codes!");
	}
	
	/**
	 * Approve TA on a particular budget.
	 * 
	 * @see org.iita.travelauth.service.ApprovalService#approveBudgetCode(org.iita.travelauth.model.BudgetCode, org.iita.security.model.User, java.lang.String)
	 * @throws ApprovalException when user is not the next approver or the TA is in the wrong status
	 */
	@Transactional
	public void approveBudgetCode(BudgetCode budgetCode, User user, String comment) throws ApprovalException {
		LOG.warn("Approving budget code " + budgetCode.getCostCenter() + " by user " + user.getFullName() + " with comment: " + comment);
		//LOG.info("approveBudgetCode Method: Approving budget code " + budgetCode.getCode() + " by user " + user.getFullName() + " with comment: " + comment);
		
		// Check if User is next approver
		if (!budgetCode.getNextApprover().getId().equals(user.getId())) {
			throw new ApprovalException("User " + user + " is not the next approver");
		}

		if (!budgetCode.getNextApprover().getId().equals(user.getId()))
			LOG.debug("User is next approver");

		Application app = budgetCode.getInternalApproval().getApplication();
		if(app instanceof GraduateResearchTraining)
			app = (GraduateResearchTraining) app;
		else if(app instanceof GroupTraining)
			app = (GroupTraining) app;
		else if(app instanceof SabbaticalTraining)
			app = (SabbaticalTraining) app;
		else if(app instanceof InternshipTraining)
			app = (InternshipTraining) app;
		
		// Check if status is set to Approved
		if (budgetCode.getStatus() != BCodeStatus.WAITING && budgetCode.getStatus() != BCodeStatus.NEW) {
			LOG.warn("Budget " + budgetCode.getCostCenter() + " is in status " + budgetCode.getStatus() + " which is invalid.");
			throw new ApprovalException("Budget " + budgetCode.getCostCenter() + " is in status " + budgetCode.getStatus() + " which is invalid.");
		}

		//CostCenter costCenter = this.entityManager.find(CostCenter.class, budgetCode.getCostCenter());
		//LOG.debug("Loaded cost center " + costCenter);

		LOG.debug("Approving budget code " + budgetCode.getCostCenter());
		budgetCode.setStatus(BCodeStatus.WAITING);

		// get next approver
		//TODO
		User nextApprover = findNextApprover(app);
		//LOG.info("approveBudgetCode Method: NextApprover - " + nextApprover.getFullName());
		nextApprover = null;
		if (nextApprover != null) {
			//have more people in approval path 
			//need to notify the next approver!

			LOG.warn("Application " + app.getId() + " is waiting for approval of " + budgetCode.getCostCenter() + " by " + nextApprover);
			budgetCode.setStatus(BCodeStatus.WAITING);
			budgetCode.setNextApprover(nextApprover);
			this.entityManager.merge(budgetCode);
			addActionLog(budgetCode.getInternalApproval().getApplication(), user, ActionType.APPROVED, "Approve application on " + budgetCode.getCostCenter(), comment);

			/*{
				// need to check for amount limit of the next approver and auto approve
				nextApprover = approval.getNextApprover();
				//Double amountLimit = getAmountLimit(nextApprover, budgetCode.getCode());
				if(approval.getInternalApproval().get.getProgramDirector()!=null & nextApprover.getId()==app.getAnnouncement().getProgramDirector().getId()) {
					// auto approve!
					LOG.warn("Auto-approving application on " + approval.getCostCenter() + ". Approver " + nextApprover.getFullName() + " is the same as director/head " + app.getAnnouncement().getProgramDirector().getFullName());
					try {
						approveBudgetCode(approval, nextApprover, null);
						// notify of auto-approval
						this.notificationService.directorAutoApproved(app, nextApprover);
					} catch (ApprovalException e) {
						LOG.error(e);
					}
				}
			}*/

			return;
		} else {
			// no more approvers, final approval
			//LOG.info("NO NEXT APPROVER: ");
			budgetCode.setStatus(BCodeStatus.APPROVED);
			budgetCode.setNextApprover(null);
			this.entityManager.merge(budgetCode);
			
			addActionLog(budgetCode.getInternalApproval().getApplication(), user, ActionType.APPROVED, "Approve application on " + budgetCode.getCostCenter(), comment);

			// check if all budgetCodes have been approved
			boolean allApproved = app.isAllBudgetCodesApproved();
			//LOG.info("ALL APPROVED: " + allApproved);
			if (allApproved) {
				if(app.getAnnouncement().getProgramDirector()!=null){
					app.setStatus(APPLICATIONSTATUS.WAITINGFORDIRECTOR);
					this.entityManager.merge(app);
					addActionLog(budgetCode.getInternalApproval().getApplication(), null, ActionType.FORWARD, "Application on budget code approved. Forwarding to PROGRAM DIRECTOR/HEAD.", null);
				}else{
					app.setStatus(APPLICATIONSTATUS.WAITINGFORCDO);
					this.entityManager.merge(app);
					//LOG.info("DIRECTOR NO. TA Status: " + ta.getStatus());
					addActionLog(budgetCode.getInternalApproval().getApplication(), null, ActionType.APPROVED, "Application on budget code approved. Forwarding to Head CDO.", null);
				}
			}
			
			if(budgetCode.getStatus()==BCodeStatus.APPROVED){
				InternalApprovals internalApprovals = budgetCode.getInternalApproval();
				
				internalApprovals.setProjOfficerApproval(SIGNATURE.APPROVED);
				Date date = new Date();
				internalApprovals.setProjOfficerDateApproved(date);
				this.entityManager.merge(internalApprovals);
			}
		}
	}

	@Transactional
	public void fileNewApplication(Application app, User approver) throws ApprovalException {
		if(app instanceof GraduateResearchTraining)
			app = (GraduateResearchTraining) app;
		else if(app instanceof GroupTraining)
			app = (GroupTraining) app;
		else if(app instanceof SabbaticalTraining)
			app = (SabbaticalTraining) app;
		else if(app instanceof InternshipTraining)
			app = (InternshipTraining) app;
		
		if (!this.entityManager.contains(app)) {
			LOG.error("Application not yet persisted to database");
			throw new ApprovalException("Application not yet persisted to database.");
		}

		//if (app.getBiodata().getOwner().getId().longValue() != approver.getId().longValue()) {
		//	throw new ApprovalException(app.getBiodata().getOwner().getDisplayName() + " can file this application.");
		//}

		if (app.getStatus() != APPLICATIONSTATUS.PENDING) {
			LOG.error("Application must be in status PENDING for to be filed. It is in status " + app.getStatus());
			throw new ApprovalException("Application must be in status PENDING for to be filed. It is in status " + app.getStatus());
		}
		
		if (app.getInternalApprovals().getBudgetCodes().size() > 0) {
			// if has line manager, goes to LINEMANAGER
			LOG.info("has requester/budget holder manager, goes to REQUESTER/BUDGETHOLDER");
			app.setStatus(APPLICATIONSTATUS.WAITING);
			
		} else if(app.getAnnouncement().getProgramDirector()!=null){	
			// goes to PROGRAM DIRECTOR/HEAD
			LOG.info("goes to PROGRAM DIRECTOR/HEAD");
			app.setStatus(APPLICATIONSTATUS.WAITINGFORDIRECTOR);
		} else {
			// goes to WAITING -- Oracle approval path
			LOG.info("Need budget holder's approval");
			app.setStatus(APPLICATIONSTATUS.WAITINGFORCDO);
		}

		// persist
		this.entityManager.merge(app);

		// add log
		this.entityManager.persist(ApprovalServiceImpl.createActionLog(app, approver, ActionType.SUBMITTED, "Application request filed for approval",
				null));

		LOG.info("After Approval Status: "+ app.getStatus());
	}

	/**
	 * Approve TA on a particular budget.
	 * 
	 * @see org.iita.travelauth.service.ApprovalService#approveBudgetCode(org.iita.travelauth.model.BudgetCode, org.iita.security.model.User, java.lang.String)
	 * @throws ApprovalException when user is not the next approver or the TA is in the wrong status
	 */
	//@Transactional
	/*public void approve(Approval approval, User user, String comment) throws ApprovalException {
		LOG.warn("Approving budget code " + approval.getApplication().getAnnouncement().getCostCenter() + " by user " + user.getFullName() + " with comment: " + comment);
		//LOG.info("approveBudgetCode Method: Approving budget code " + budgetCode.getCode() + " by user " + user.getFullName() + " with comment: " + comment);
		
		// Check if User is next approver
		if (!approval.getNextApprover().getId().equals(user.getId())) {
			throw new ApprovalException("User " + user + " is not the next approver");
		}

		if (!approval.getNextApprover().getId().equals(user.getId()))
			LOG.debug("User is next approver");

		Application app = approval.getApplication();

		// Check if status is set to Approved
		if (approval.getStatus() != STATUS.WAITING && approval.getStatus() != STATUS.NEW) {
			LOG.warn("Budget " + approval.getApplication().getAnnouncement().getCostCenter() + " is in status " + approval.getStatus() + " which is invalid.");
			throw new ApprovalException("Budget " + approval.getApplication().getAnnouncement().getCostCenter() + " is in status " + approval.getStatus() + " which is invalid.");
		}


		LOG.debug("Approving budget code " + approval.getApplication().getAnnouncement().getCostCenter());
		approval.setStatus(STATUS.WAITING);

		// get next approver
		//TODO
		User nextApprover = findNextApprover(app);
		//LOG.info("approveBudgetCode Method: NextApprover - " + nextApprover.getFullName());
		nextApprover = null;
		if (nextApprover != null) {
			//have more people in approval path  & need to notify the next approver!

			LOG.warn("Application " + app.getId() + " is waiting for approval of " + app.getAnnouncement().getCostCenter() + " by " + nextApprover);
			approval.setStatus(STATUS.WAITING);
			approval.setNextApprover(nextApprover);
			this.entityManager.merge(approval);
			addActionLog(approval.getApplication(), user, ActionType.APPROVED, "Approve application on " + app.getAnnouncement().getCostCenter(), comment);

			{
				// need to check for amount limit of the next approver and auto approve
				nextApprover = approval.getNextApprover();
				//Double amountLimit = getAmountLimit(nextApprover, budgetCode.getCode());
				if(app.getAnnouncement().getProgramDirector()!=null & nextApprover.getId()==app.getAnnouncement().getProgramDirector().getId()) {
					// auto approve!
					LOG.warn("Auto-approving application on " + app.getAnnouncement().getCostCenter() + ". Approver " + nextApprover.getFullName() + " is the same as program director/head " + app.getAnnouncement().getProgramDirector().getFullName());
					try {
						approveBudgetCode(approval, nextApprover, null);
						// notify of auto-approval
						this.notificationService.directorAutoApproved(app, nextApprover);
					} catch (ApprovalException e) {
						LOG.error(e);
					}
				}
			}

			return;
		} else {
			// no more approvers, final approval
			//LOG.info("NO NEXT APPROVER: ");
			approval.setStatus(STATUS.APPROVED);
			approval.setNextApprover(null);
			this.entityManager.merge(approval);
			addActionLog(approval.getApplication(), user, ActionType.APPROVED, "Approve application on " + app.getAnnouncement().getCostCenter(), comment);

			// check if all budgetCodes have been approved
			boolean allApproved = app.isAllBudgetCodesApproved();
			//LOG.info("ALL APPROVED: " + allApproved);
			if (allApproved) {
				app.setStatus(APPLICATIONSTATUS.WAITINGFORCDO);
				this.entityManager.merge(app);
				//LOG.info("DIRECTOR NO. application Status: " + app.getStatus());
				addActionLog(approval.getApplication(), null, ActionType.APPROVED, "Application on all budget codes approved. Forwarding to Head CDO.", null);
			}
		}
	}*/

	/**
	 * Finds next approver in the cost center approval path.
	 * 
	 * Looks up the current user and returns next person in path.
	 * 
	 */
	@Transactional
	private User findNextApprover(Application app) {
		
			// next approver
			User nextApprover = null;
			if (app.getStatus()==APPLICATIONSTATUS.WAITING) {
				LOG.info("Assigning approval to requester " + app.getAnnouncement().getRequester());
				nextApprover = app.getAnnouncement().getRequester();
			}
			
			if (app.getStatus()==APPLICATIONSTATUS.WAITINGFORDIRECTOR) {
				LOG.info("Assigning approval to program director " + app.getAnnouncement().getProgramDirector());
				nextApprover = app.getAnnouncement().getProgramDirector();
			}

			if (nextApprover != null) {
				// return it!
				LOG.debug("Actual next approver is " + nextApprover);
				return nextApprover;
			}
		return nextApprover;
	}
	

	@Transactional
	public void rejectApplication(Approval approval, User user, String comment) throws ApprovalException {
		LOG.warn("Rejecting application on budget code " + approval.getApplication().getAnnouncement().getCostCenter() + " by user " + user + " with comment: " + comment);
		CostCenter costCenter = this.entityManager.find(CostCenter.class, approval.getApplication().getAnnouncement().getCostCenter());

		// Check if User is in approval path
		if (isOnApprovalPath(costCenter, user)) {
			LOG.debug("User is on approval path, rejecting!");
			approval.setStatus(STATUS.REJECTED);
			approval.getApplication().setStatus(APPLICATIONSTATUS.REJECTED);
			addActionLog(approval.getApplication(), user, ActionType.REJECTED, "Reject application on " + approval.getApplication().getAnnouncement().getCostCenter(), comment);
		} else {
			throw new ApprovalException("User " + user + " is not on the approval path.");
		}
	}

	/**
	 * @param budgetCode
	 * @param user
	 * @param comment
	 * @param action
	 * @param comment2
	 */
	private void addActionLog(Application app, User user, ActionType action, String comment, String comment2) {
		ActionLog actionLog = createActionLog(app, user, action, comment, comment2);
		this.entityManager.persist(actionLog);
	}

	public static ActionLog createActionLog(Application app, User user, ActionType action, String comment, String comment2) {
		ActionLog actionLog = new ActionLog();
		actionLog.setApplication(app);
		actionLog.setUsername(user == null ? "SYSTEM" : user.getFullName());
		actionLog.setUser(user);
		actionLog.setComment(comment + (comment2 == null || comment2.length() == 0 ? "" : ": " + comment2));
		actionLog.setAction(action);
		return actionLog;
	}

	/**
	 * Is user on approval path of a cost center?
	 * 
	 * @param costCenter
	 * @param user
	 * @return
	 */
	private boolean isOnApprovalPath(CostCenter costCenter, User user) {
		if (costCenter == null)
			return false;
		if (costCenter.getHolder().getId().equals(user.getId()))
			return true;
		for (ApprovalPath x : costCenter.getApprovalPath()) {
			if (x.getUser().getId().equals(user.getId()))
				return true;
		}
		return false;
	}
	
	/**
	 * @see org.iita.travelauth.service.ApprovalService#approveDirector(org.iita.security.model.User, org.iita.travelauth.model.TravelAuthorization,
	 *      java.lang.String)
	 */
	@Transactional
	public void approveDirector(User director, Application app, String comment) throws ApprovalException {
		if (app == null)
			throw new NullPointerException("No application");
		if (director == null)
			throw new NullPointerException("No director/head");
		if (app.getStatus() != APPLICATIONSTATUS.WAITINGFORDIRECTOR)
			throw new ApprovalException("Application is not waiting for director/head's approval");
		if (director.getId().equals(app.getAnnouncement().getProgramDirector().getId())) {
			LOG.warn("Director/head " + director + " approving " + app.getId());

			LOG.info("Application " + app.getId() + " has no budget codes, going to Head CDO");
			app.setStatus(APPLICATIONSTATUS.WAITINGFORCDO);
			
			this.entityManager.merge(app);

			LOG.warn("Director/head " + director + " approved " + app.getId());
			addActionLog(app, director, ActionType.APPROVED, "Application approved by program director/head", comment);
		} else {
			LOG.warn("User " + director.getDisplayName() + " is not director/head!");
			throw new ApprovalException("User " + director.getDisplayName() + " is not director/head!");
		}
	}


	/**
	 * @see org.iita.trainingunit.service.ApprovalService#rejectDirector(org.iita.security.model.User, org.iita.trainingunit.applications.model.Application,
	 *      java.lang.String)
	 */
	@Transactional
	public void rejectDirector(User director, Application app, String comment) throws ApprovalException {
		if (app == null)
			throw new NullPointerException("No Application");
		if (director == null)
			throw new NullPointerException("No director/head");
		if (app.getStatus() != APPLICATIONSTATUS.WAITINGFORDIRECTOR)
			throw new ApprovalException("Application is not waiting for director/head's approval");
		if (director.getId().equals(app.getAnnouncement().getProgramDirector().getId())) {
			LOG.warn("Director/head " + director + " rejecting " + app.getId());
			app.setStatus(APPLICATIONSTATUS.REJECTED);
			this.entityManager.merge(app);
			LOG.warn("Director/head " + director + " rejected " + app.getId());
			addActionLog(app, director, ActionType.REJECTED, "Application approval rejected by director/head", comment);
		} else {
			LOG.error("User " + director.getDisplayName() + " is not director/head! Cannot reject.");
			throw new ApprovalException("User " + director.getDisplayName() + " cannot reject this application. Not director/head.");
		}
	}

	/**
	 * CFO approves TA
	 * */
	@Transactional
	public void approveCDO(Application app, User user, String comment) throws ApprovalException {
		if (app.getStatus() != APPLICATIONSTATUS.WAITINGFORCDO) {
			throw new ApprovalException("Application status is not waiting for Head CDO. Current application status: " + app.getStatus());
		}

		if (!Authorize.hasRole(user, "ROLE_TRAININGUNITHEAD")) {
			throw new ApprovalException("User " + user.getDisplayName() + " does not have CDO Head role.");
		}

		app.setStatus(APPLICATIONSTATUS.WAITINGFORCFO);
		this.entityManager.merge(app);
		
		InternalApprovals internalApprovals = app.getInternalApprovals();
		internalApprovals.setCdoHeadApproval(SIGNATURE.APPROVED);
		Date date = new Date();
		internalApprovals.setCdoHeadDateApproved(date);
		internalApprovals.setCdoHeadComments(comment);
		this.entityManager.merge(internalApprovals);
		
		addActionLog(app, user, ActionType.APPROVED, "Application approved by the Head CDO", comment);
	}

	/**
	 * CDO rejects Application
	 * */
	@Transactional
	public void rejectCDO(Application app, User user, String comment) throws ApprovalException {
		if (app.getStatus() != APPLICATIONSTATUS.WAITINGFORCDO) {
			throw new ApprovalException("Application status is not waiting for Head CDO. Current application status: " + app.getStatus());
		}
		app.setStatus(APPLICATIONSTATUS.REJECTED);
		this.entityManager.merge(app);
		
		InternalApprovals internalApprovals = app.getInternalApprovals();
		internalApprovals.setCdoHeadApproval(SIGNATURE.REJECTED);
		Date date = new Date();
		internalApprovals.setCdoHeadDateApproved(date);
		internalApprovals.setCdoHeadComments(comment);
		this.entityManager.merge(internalApprovals);
		
		addActionLog(app, user, ActionType.REJECTED, "Application rejected by the Head CDO", comment);
	}

	/**
	 * CFO approves Application
	 * */
	@Transactional
	public void approveCFO(Application app, User user, String comment) throws ApprovalException {
		if (app.getStatus() != APPLICATIONSTATUS.WAITINGFORCFO) {
			throw new ApprovalException("Application status is not waiting for CFO. Current application status: " + app.getStatus());
		}

		if (!Authorize.hasRole(user, "ROLE_CFO")) {
			throw new ApprovalException("User " + user.getDisplayName() + " does not have CFO role.");
		}

		app.setStatus(APPLICATIONSTATUS.APPROVED);
		this.entityManager.merge(app);
		
		InternalApprovals internalApprovals = app.getInternalApprovals();
		internalApprovals.setCfoApproval(SIGNATURE.APPROVED);
		Date date = new Date();
		internalApprovals.setCfoDateApproved(date);
		internalApprovals.setCfoComments(comment);
		this.entityManager.merge(internalApprovals);
		
		addActionLog(app, user, ActionType.APPROVED, "Application approved by the CFO", comment);
	}

	
	/**
	 * CFO rejects Application
	 * */
	@Transactional
	public void rejectCFO(Application app, User user, String comment) throws ApprovalException {
		if (app.getStatus() != APPLICATIONSTATUS.WAITINGFORCFO) {
			throw new ApprovalException("Application status is not waiting for CFO. Current application status: " + app.getStatus());
		}
		app.setStatus(APPLICATIONSTATUS.REJECTED);
		this.entityManager.merge(app);
		
		InternalApprovals internalApprovals = app.getInternalApprovals();
		internalApprovals.setCfoApproval(SIGNATURE.REJECTED);
		Date date = new Date();
		internalApprovals.setCfoDateApproved(date);
		internalApprovals.setCfoComments(comment);
		this.entityManager.merge(internalApprovals);
		
		addActionLog(app, user, ActionType.REJECTED, "Application rejected by the CFO", comment);
	}
	
	/**
	 * @see org.iita.travelauth.service.ApprovalService#reapprove(java.util.List)
	 */
	@Override
	@Transactional
	public void reapprove(List<Application> apps) {
		for (Application app : apps) {
			// if status is not WAITING
			if (app.getStatus() != APPLICATIONSTATUS.WAITING) {
				LOG.info("Skipping " + app + "... not waiting CC approval.");
				continue;
			}

			//Calendar oneYearAgo = Calendar.getInstance();
			//oneYearAgo.add(Calendar.YEAR, -1);
			//if (app.getAnnouncement().getStartDate()==null || ta.getStartDate().before(oneYearAgo.getTime())) {
			//	LOG.info("TA has no start date or too old: " + ta.getStartDate());
			//	continue;
			//}

			LOG.info("Re-approving application " + app);

			// reset Budget code approver to budget holder in case of WAITING
			for (BudgetCode bc : app.getInternalApprovals().getBudgetCodes()) {
				if (bc.getStatus() == BCodeStatus.WAITING)
					bc.setNextApprover(bc.getCostCenter().getHolder());
			}

			int counter = 0;
			// copy approvers
			List<User> approvers = new ArrayList<User>(app.getApprovers());
			while (internalAutoApprove(app, approvers, "Re-approved")) {
				LOG.trace("Auto-approval process continues.");
				if (counter++ == 30) {
					LOG.error("Loop in auto-approval mechanism! 30 loops so far!");
					break;
				}
			}

			// merge ta
			this.entityManager.merge(app);
			
			// notify current
			LOG.info("Notifying about current status: " + app.getStatus().name());
			this.notificationService.notifyByStatus(app, "Re-approved");
		}
	}
}
