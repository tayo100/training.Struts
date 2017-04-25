/**
 * travelauth.Struts May 25, 2009
 */
package org.iita.trainingunit.applications.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.security.model.User;
import org.iita.security.service.UserService;
import org.iita.service.EmailException;
import org.iita.service.EmailService;
import org.iita.service.TemplatingException;
import org.iita.service.TemplatingService;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.model.Approval;
import org.iita.trainingunit.applications.model.Approval.STATUS;
import org.iita.trainingunit.applications.model.BCodeStatus;
import org.iita.trainingunit.applications.model.BudgetCode;
import org.iita.trainingunit.applications.service.NotificationService;
import org.iita.util.StringUtil;

/**
 * @author mobreza, koraegbunam
 * 
 */
public class NotificationServiceImpl implements NotificationService {
	private static Log LOG = LogFactory.getLog(NotificationService.class);
	private EmailService emailService;
	private TemplatingService templatingService;
	private UserService userService;

	/**
	 * @param emailService
	 * @param templatingService
	 * @param userService
	 * 
	 */
	public NotificationServiceImpl(EmailService emailService, TemplatingService templatingService, UserService userService) {
		this.emailService = emailService;
		this.templatingService = templatingService;
		this.userService = userService;
	}

	/**
	 * @see org.iita.trainingunit.applications.service.NotificationService#budgetHolderPending(org.iita.travelauth.model.BudgetCode)
	 */
	@Override
	public void budgetHolderPending(BudgetCode approval) {
		if (approval.getStatus() != BCodeStatus.WAITING) {
			LOG.warn("Will not send pending notification for cost center " + approval.getCostCenter() + " status " + approval.getStatus());
		}

		if (approval.getNextApprover() != null) {
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("application", approval.getInternalApproval().getApplication());
			data.put("applicant", approval.getInternalApproval().getApplication().getBiodata());
			data.put("approval", approval);
			try {
				String message = templatingService.fillTemplate("budgetholder-pending", data);
				sendEmail(true, approval.getNextApprover(), "Training Application Budget Code needs your authorization", message);
			} catch (TemplatingException e) {
				LOG.error(e);
			}
		} else {
			LOG.warn("No next approver to send e-mail to for cost center " + approval.getCostCenter());
		}
	}

	/**
	 * @see org.iita.trainingunit.applications.service.NotificationService#notifyBudgetHolders(org.iita.trainingunit.application.model.Application)
	 */
	@Override
	public void budgetHoldersPending(Application app) {
		// Loop through attached Budget Codes and send mails to individual Budget Holders of the budgets
		for (int i = app.getInternalApprovals().getBudgetCodes().size() - 1; i >= 0; i--) {
			BudgetCode approval = app.getInternalApprovals().getBudgetCodes().get(i);
			budgetHolderPending(approval);
		}
	}

	/**
	 * @see org.iita.trainingunit.applications.service.NotificationService#notifyCDOs(org.iita.trainingunit.applications.model.Application)
	 */
	@Override
	public void CDOPending(Application app) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("application", app);
		data.put("applicant", app.getBiodata());

		String message = null;
		try {
			message = templatingService.fillTemplate("cdo-pending", data);
		} catch (TemplatingException e) {
			LOG.error(e);
			return;
		}

		LOG.debug("Loading CDOs");
		// find CFOs
		List<User> cdoList = this.userService.findByRole("ROLE_TRAININGUNITHEAD");

		// mail CFOs
		if (cdoList != null && cdoList.size() > 0) {
			for (User cdo : cdoList) {
				LOG.warn("Sending email to CDO : " + cdo.getFullName() + " " + cdo.getMail());
				sendEmail(true, cdo, "Training Application needs your authorization", message);
			}
		}
	}

	/**
	 * @see org.iita.trainingunit.applications.service.NotificationService#rejectedBudgetCode(org.iita.trainingunit.applications.model.Application)
	 */
	@Override
	public void budgetCodeRejected(BudgetCode approval, String comment) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("application", approval.getInternalApproval().getApplication());
		data.put("applicant", approval.getInternalApproval().getApplication().getBiodata());
		data.put("rejectedApproval", approval);
		data.put("comment", comment);
		try {
			String message = templatingService.fillTemplate("budget-reject", data);
			sendEmail(true, approval.getInternalApproval().getApplication().getBiodata().getOwner(), "Training application on " + approval.getCostCenter() + " rejected", message);
		} catch (TemplatingException e) {
			LOG.error(e);
			return;
		}
	}
	
	/**
	 * @see org.iita.trainingunit.applications.service.NotificationService#directorRejected(org.iita.trainingunit.applications.model.Application)
	 */
	@Override
	public void directorRejected(Application app, String comment) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("application", app);
		data.put("applicant", app.getBiodata());
		data.put("comment", comment);
		try {
			String message = templatingService.fillTemplate("director-reject", data);
			sendEmail(true, app.getBiodata().getOwner(), "Director/head rejected training application", message);
		} catch (TemplatingException e) {
			LOG.error(e);
			return;
		}
	}

	/**
	 * @see org.iita.trainingunit.applications.service.NotificationService#directorPending(org.iita.trainingunit.applications.model.Application)
	 */
	@Override
	public void directorPending(Application app) {
		if (app.getAnnouncement().getProgramDirector() == null || app.getAnnouncement().getProgramDirector().getMail() == null) {
			LOG.warn("Director/head does not exist, or has no email address. Not notifying.");
			return;
		}
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("application", app);
		data.put("applicant", app.getBiodata());
		try {
			String message = templatingService.fillTemplate("director-pending", data);
			sendEmail(true, app.getAnnouncement().getProgramDirector(), "Training application request waiting your approval as director/head", message);
		} catch (TemplatingException e) {
			LOG.error(e);
			return;
		}
	}

	/**
	 * @see org.iita.trainingunit.applications.service.NotificationService#CDOApproved(org.iita.trainingunit.applications.model.Application)
	 */
	@Override
	public void CDOApproved(Application app) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("application", app);
		data.put("applicant", app.getBiodata());
		try {
			String message = templatingService.fillTemplate("cdo-approved", data);
			sendEmail(true, app.getBiodata().getOwner(), "Training application request is fully approved", message);
		} catch (TemplatingException e) {
			LOG.error(e);
			return;
		}
	}

	/**
	 * @see org.iita.trainingunit.applications.service.NotificationService#CDOCancelled(org.iita.trainingunit.applications.model.Application)
	 */
	@Override
	public void CDOCanceled(Application app) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("application", app);
		data.put("applicant", app.getBiodata());
		try {
			String message = templatingService.fillTemplate("cdo-canceled", data);
			sendEmail(true, app.getBiodata().getOwner(), "Training application request is cancelled", message);
		} catch (TemplatingException e) {
			LOG.error(e);
			return;
		}
	}


	/**
	 * @see org.iita.trainingunit.applications.service.NotificationService#CDORejected(org.iita.trainingunit.applications.model.Application)
	 */
	@Override
	public void CDORejected(Application app, String comment) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("application", app);
		data.put("applicant", app.getBiodata());
		data.put("comment", comment);
		try {
			String message = templatingService.fillTemplate("cdo-rejected", data);
			sendEmail(true, app.getBiodata().getOwner(), "Training application request was rejected by Head CDO", message);
		} catch (TemplatingException e) {
			LOG.error(e);
			return;
		}
	}
	
	/**
	 * @see org.iita.trainingunit.applications.service.NotificationService#notifyCFOs(org.iita.trainingunit.applications.model.Application)
	 */
	@Override
	public void CFOPending(Application app) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("application", app);
		data.put("applicant", app.getBiodata());

		String message = null;
		try {
			message = templatingService.fillTemplate("cfo-pending", data);
		} catch (TemplatingException e) {
			LOG.error(e);
			return;
		}

		LOG.debug("Loading CFOs");
		// find CFOs
		List<User> cfoList = this.userService.findByRole("ROLE_CFO");

		// mail CFOs
		if (cfoList != null && cfoList.size() > 0) {
			for (User cfo : cfoList) {
				LOG.warn("Sending email to CFO : " + cfo.getFullName() + " " + cfo.getMail());
				sendEmail(true, cfo, "Application Budget Code needs your authorization", message);
			}
		}
	}
	
	/**
	 * @see org.iita.trainingunit.applications.service.NotificationService#CFOApproved(org.iita.trainingunit.applications.model.Application)
	 */
	@Override
	public void CFOApproved(Application app) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("application", app);
		data.put("applicant", app.getBiodata());
		try {
			String message = templatingService.fillTemplate("cfo-approved", data);
			sendEmail(true, app.getBiodata().getOwner(), "Application request is approved", message);
		} catch (TemplatingException e) {
			LOG.error(e);
			return;
		}
	}

	/**
	 * @see org.iita.trainingunit.applications.service.NotificationService#CFOCancelled(org.iita.trainingunit.applications.model.Application)
	 */
	@Override
	public void CFOCanceled(Application app) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("app", app);
		data.put("applicant", app.getBiodata());
		try {
			String message = templatingService.fillTemplate("cfo-canceled", data);
			sendEmail(true, app.getBiodata().getOwner(), "Application request is cancelled", message);
		} catch (TemplatingException e) {
			LOG.error(e);
			return;
		}
	}

	/**
	 * @see org.iita.trainingunit.applications.service.NotificationService#autoApproved(org.iita.trainingunit.applications.model.Application, org.iita.security.model.User,
	 *      java.lang.Double)
	 */
	@Override
	public void autoApproved(Application app, User nextApprover, Double amountLimit) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("application", app);
		data.put("applicant", app.getBiodata());
		data.put("amountLimit", amountLimit);
		try {
			String message = templatingService.fillTemplate("autoapproved", data);
			sendEmail(false, nextApprover, "Automatic approval of training application", message);
		} catch (TemplatingException e) {
			LOG.error(e);
			return;
		}
	}
	
	/**
	 * @see org.iita.trainingunit.applications.service.NotificationService#autoApproved(org.iita.trainingunit.applications.model.Application, org.iita.security.model.User,
	 *      java.lang.Double)
	 */
	@Override
	public void directorAutoApproved(Application app, User nextApprover) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("application", app);
		data.put("applicant", app.getBiodata());
		try {
			String message = templatingService.fillTemplate("directorautoapproved", data);
			sendEmail(false, nextApprover, "Automatic approval of training application", message);
		} catch (TemplatingException e) {
			LOG.error(e);
			return;
		}
	}

	/**
	 * Will notify delegated users instead of intended recipient, but CC the recipient in.
	 * 
	 * @param mail
	 * @param string
	 * @param message
	 */
	@SuppressWarnings("unchecked")
	private void sendEmail(boolean respectDelegation, User recipient, String subject, String body) {
		if (body == null) {
			LOG.warn("Not sending email to " + recipient + ", body is null.");
			return;
		}
		List<User> delegatedUsers = Collections.EMPTY_LIST;
		if (respectDelegation) {
			LOG.warn("Notification service respects delegation for this mail message.");
			delegatedUsers = getDelegatedUsers(recipient);
		}

		if (delegatedUsers != null && delegatedUsers.size() > 0) {
			LOG.warn("Notifying all delegated users and the intended recipient " + recipient.getFullName());
			subject += " [" + recipient.getFullName() + "]";
			body = "\n[Delegated from " + recipient.getFullName() + "]\n" + body;
			try {
				this.emailService.sendEmail(null, getAddresses(delegatedUsers), new String[] { String.format("\"%1$s\" <%2$s>", recipient.getDisplayName(), recipient.getMail()) }, subject, null, body);
			} catch (EmailException e) {
				LOG.error(e.getMessage());
			}
		} else {
			if(recipient!=null){
				LOG.warn("Notifying only the intended recipient " + recipient.getFullName());
				try {
					this.emailService.sendEmail(null, new String[] { String.format("\"%1$s\" <%2$s>", recipient.getDisplayName(), recipient.getMail())}, null, subject, null, body);
				} catch (EmailException e) {
					LOG.error(e.getMessage());
				}
			}
		}
	}

	/**
	 * Convert list of users to a list of email address recipients
	 * 
	 * @param delegatedUsers
	 * @return
	 */
	private String[] getAddresses(List<User> delegatedUsers) {
		if (delegatedUsers == null || delegatedUsers.size() == 0) {
			LOG.warn("Not getting email addresses for empty list.");
			return StringUtil.EMPTY_STRINGARRAY;
		}
		LOG.info("Converting list of " + delegatedUsers.size() + " users to email address list.");
		String[] addresses = new String[delegatedUsers.size()];
		for (int i = 0; i < addresses.length; i++) {
			User user = delegatedUsers.get(i);
			if (user == null || user.getMail() == null) {
				LOG.debug("User is null or user.mail is null, not getting address.");
				continue;
			}
			addresses[i] = "\"" + user.getDisplayName() + "\" <" + user.getMail() + ">";
			LOG.info("Added recipient: " + addresses[i]);
		}
		return addresses;
	}

	/**
	 * @param nextApprover
	 * @return
	 */
	private List<User> getDelegatedUsers(User user) {
		return this.userService.getDelegatedTo(user);
	}

	@Override
	public void notifyByStatus(Application app, String comment) {
		if (app == null)
			return;

		LOG.debug("Status notification for training application status " + app.getStatus());
		switch (app.getStatus()) {
		case WAITING:
			budgetHoldersPending(app);
			break;
		case WAITINGFORDIRECTOR:
			directorPending(app);
			break;
		case WAITINGFORCDO:
			CDOPending(app);
			break;
		case WAITINGFORCFO:
			CFOPending(app);
			break;
		case APPROVED:
			CFOApproved(app);
			break;
		case REJECTED:
			rejected(app, comment);
			break;
		case DEFERRED:
			deferred(app, comment);
			break;

		default:
			LOG.warn("Status notification not sent for training application status " + app.getStatus());
		}
	}

	private void rejected(Application app, String comment) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("application", app);
		data.put("applicant", app.getBiodata());
		data.put("comment", comment);
		try {
			String message = templatingService.fillTemplate("rejected", data);
			sendEmail(true, app.getBiodata().getOwner(), "Training application request is rejected", message);
		} catch (TemplatingException e) {
			LOG.error(e);
			return;
		}
	}
	
	private void deferred(Application app, String comment) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("application", app);
		data.put("applicant", app.getBiodata());
		data.put("comment", comment);
		try {
			String message = templatingService.fillTemplate("deferred", data);
			sendEmail(true, app.getBiodata().getOwner(), "Training application request is deferred", message);
		} catch (TemplatingException e) {
			LOG.error(e);
			return;
		}
	}
}
