package org.iita.trainingunit.applications.action;

import org.iita.trainingunit.applications.service.CDOApplicationService;

import com.opensymphony.xwork2.Action;

/**
 * Readonly view Application action
 * 
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class ViewApplicationAction extends BaseApplicationAction {

	public ViewApplicationAction(CDOApplicationService cdoApplicationService) {
		super(cdoApplicationService);
	}

	public String sendReminders() {
		this.cdoApplicationService.sendReminders(getUser(), this.app);
		addActionMessage("E-mail reminder was sent to approver.");
		return Action.SUCCESS;
	}
}
