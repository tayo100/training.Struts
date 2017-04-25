/**
 * travelauth.Struts May 20, 2009
 */
package org.iita.trainingunit.applications.action;

import org.iita.security.Authorize;
import org.iita.trainingunit.applications.service.CDOApplicationService;

import com.opensymphony.xwork2.Action;

/**
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class DespatchApplicationAction extends ViewApplicationAction {

	/**
	 * @param taService
	 */
	public DespatchApplicationAction(CDOApplicationService cdoApplicationService) {
		super(cdoApplicationService);
	}

	/**
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() {
		if (this.app != null) {
			if (this.app.getBiodata().getOwner().getId().equals(getUser().getId())) {
				// user owns the TA
				switch (this.app.getStatus()) {
				case PENDING:
				case REJECTED:
					return "editable";

				case WAITING:
					if (this.app.isWaitingForUser(getUser())) {
						return "budget";
					} else if (Authorize.hasRole(getUser(), "ROLE_DDG")) {
						return "budget";
					} else if (Authorize.hasRole(getUser(), "ROLE_CFO")) {
						return "budget";
					}
					return "readonly";
					
				case WAITINGFORCDO:
					System.out.println("CDO Head return: ");
					if (Authorize.hasRole(getUser(), "ROLE_TRAININGUNITHEAD")) {
						System.out.println("CDO return: ");
						return "cdo";
					}
					return "readonly";
					
				case WAITINGFORCFO:
					if (this.app.isWaitingForUser(getUser())) {
						return "budget";
					} else if (Authorize.hasRole(getUser(), "ROLE_CFO")) {
						return "cfo";
					} 
					return "readonly";
				default:
					return "readonly";
				}
			} else {
				// somebody else's TA
				switch (this.app.getStatus()) {
				case WAITING:
					if (this.app.isWaitingForUser(getUser())) {
						System.out.println("DIRECTOR return: User");
						return "budget";
					} else if (Authorize.hasRole(getUser(), "ROLE_DDG")) {
						System.out.println("DIRECTOR return: DDG");
						return "budget";
					} else if (Authorize.hasRole(getUser(), "ROLE_CFO")) {
						System.out.println("DIRECTOR return: CFO");
						return "budget";
					}
					return "readonly";
					
				case WAITINGFORCDO:
					if (this.app.isWaitingForUser(getUser())) {
						return "budget";
					} else if (Authorize.hasRole(getUser(), "ROLE_TRAININGUNITHEAD")) {
						return "cdo";
					}
					return "readonly";
				/*case WAITINGFORDIRECTOR:
					LOG.info("DIRECTOR return: " + this.app.getAnnouncement().getProgramDirector().getId());
					if (this.app.getAnnouncement().getProgramDirector().getId().equals(getUser().getId())) {
						System.out.println("DIRECTOR return: " + this.app.getAnnouncement().getProgramDirector().getId());
						return "director";
					} else if (Authorize.hasRole(getUser(), "ROLE_DDG")) {
						System.out.println("DDG return: " + this.app.getAnnouncement().getProgramDirector().getId());
						return "director";
					} else if (Authorize.hasRole(getUser(), "ROLE_CFO")) {
						System.out.println("CFO return: " + this.app.getAnnouncement().getProgramDirector().getId());
						return "director";
					}
					return "readonly";*/
					
				case WAITINGFORCFO:
					if (this.app.isWaitingForUser(getUser())) {
						return "budget";
					} else if (Authorize.hasRole(getUser(), "ROLE_CFO")) {
						return "cfo";
					} 
					return "readonly";

				case APPROVED:
					return "readonly";

				default:
					if (this.app.getApprovers().contains(getUser())) {
						return "readonly";
					} else {
						clearApplication();
						addActionError("You are not allowed to access details of the requested application record.");
						return Action.ERROR;
					}
				}
			}
		} else {
			addActionError("No such application.");
			return Action.ERROR;
		}
	}

}
