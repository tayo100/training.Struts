/**
 * travelauth.Struts May 22, 2009
 */
package org.iita.trainingunit.applications.action;

import org.iita.struts.AllowedParameters;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.service.ApprovalException;
import org.iita.trainingunit.applications.service.ApprovalService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

/**
 * @author koraegbunam
 * 
 */
@SuppressWarnings("serial")
public class ApproveDirectorAction extends ApproveBaseAction {
	private Application app;
	private String extraComment = null;
	/**
	 * @param app the app to set
	 */
	@TypeConversion(converter = "genericConverter")
	public void setApp(Application app) {
		this.app = app;
	}

	public Application getApp() {
		return app;
	}

	/**
	 * @param approvalService
	 */
	public ApproveDirectorAction(ApprovalService approvalService) {
		super(approvalService);
	}

	/**
	 * @see org.iita.travelauth.action.ApproveBaseAction#approve()
	 */
	@Override
	@AllowedParameters( { "comment", "app" })
	public String approve() {
		try {
			
			if(!this.getUser().hasRole("ROLE_TRAININGUNITHEAD")){
				extraComment = " Approved by " + this.getPrincipal().getFullName();
				this.approvalService.approve(this.app, this.getPrincipal(), this.comment + extraComment);
				//addActionMessage("TA request approved successfully!");
				return "monitor";
			}else{	
				this.approvalService.approve(this.app, getUser(), comment + extraComment);
				return Action.SUCCESS;
			}
		} catch (ApprovalException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
	}

	/**
	 * @see org.iita.travelauth.action.ApproveBaseAction#reject()
	 */
	@Override
	@AllowedParameters( { "comment", "ta" })
	public String reject() {
		try {
			if(!this.getUser().hasRole("ROLE_TRAININGUNITHEAD")){
				extraComment = " Rejected by " + this.getPrincipal().getFullName();
				this.approvalService.reject(this.app, this.getPrincipal(), this.comment + extraComment);
				//addActionMessage("Application request rejected successfully!");
				return "monitor";
			}else{
				this.approvalService.reject(app, getUser(), comment + extraComment);
				return Action.SUCCESS;
			}
		} catch (ApprovalException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
	}

}
