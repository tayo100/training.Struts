/**
 * 
 */
package org.iita.trainingunit.applications.action;

import java.util.List;

import org.iita.security.model.User;
import org.iita.struts.BaseAction;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.model.Application.APPLICATIONSTATUS;
import org.iita.trainingunit.applications.service.ApprovalException;
import org.iita.trainingunit.applications.service.ApprovalService;
import org.iita.trainingunit.applications.service.CDOApplicationService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

/**
 * @author ken
 *
 */
@SuppressWarnings("serial")
public class CDODefaultAction extends BaseAction implements Preparable {
	private PagedResult<Application> paged;
	private CDOApplicationService cdoApplicationService;
	private ApprovalService approvalService;
	private int startAt = 0, maxResults = 50;
	// fields
	private Long id;
	private String comment;
	private Application application = null;
	private PagedResult<Application> pending;

	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the training application
	 */
	public Application getApplication() {
		return application;
	}

	public CDODefaultAction(CDOApplicationService cdoApplicationService, ApprovalService approvalService) {
		this.cdoApplicationService = cdoApplicationService;
		this.approvalService = approvalService;
	}

	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}

	public PagedResult<Application> getPaged() {
		return paged;
	}

	@Override
	public String execute() {
		this.paged = this.cdoApplicationService.getApplications(startAt, maxResults, APPLICATIONSTATUS.WAITINGFORCDO, APPLICATIONSTATUS.APPROVED, APPLICATIONSTATUS.REJECTED);
		this.pending = this.cdoApplicationService.getApplications(startAt, maxResults, APPLICATIONSTATUS.WAITINGFORCDO);
		return super.execute();
	}
	

	/**
	 * Make sure this.paged contains only WAITINGFORCDO TAs
	 */
	public String viewpending() {
		this.paged = this.pending = this.cdoApplicationService.getApplications(startAt, maxResults, APPLICATIONSTATUS.WAITINGFORCDO);
		return Action.SUCCESS;
	}

	@Override
	public void prepare() {
		LOG.trace("prepare() called");
		if (this.id != null)
			this.application = this.cdoApplicationService.load(id);
		else
			this.application = null;
	}

	// CDO approves TA record
	public String approve() {
		LOG.trace("CDO approve() called");
		if (this.application != null) {
			try {
				this.approvalService.approve(application, getUser(), comment);
			} catch (ApprovalException e) {
				addActionError(e.getMessage());
				return Action.ERROR;
			}
			return Action.SUCCESS;
		} else {
			return Action.INPUT;
		}
	}

	// CDO rejects TA record
	public String reject() {
		LOG.trace("CDO reject() called");
		if (this.application != null) {
			try {
				this.approvalService.reject(this.application, getPrincipal(), comment);
			} catch (ApprovalException e) {
				addActionError(e.getMessage());
				return Action.ERROR;
			}
			return Action.SUCCESS;
		} else {
			return Action.INPUT;
		}
	}

	public String reviewApplication() {
		LOG.trace("CDO reviewTrainingApplication() called");
		if (this.application != null) {
			return Action.SUCCESS;
		} else {
			addActionError("Training Application record was not supplied");
			return Action.ERROR;
		}
	}
	
	public PagedResult<Application> getPending() {
		return pending;
	}
	
	public List<User> waitingFor(Application application) {
		return this.cdoApplicationService.getWaitingFor(application);
	}
}
