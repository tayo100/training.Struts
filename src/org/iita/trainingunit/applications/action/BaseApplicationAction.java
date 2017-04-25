package org.iita.trainingunit.applications.action;

import org.iita.struts.BaseAction;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.service.CDOApplicationService;

@SuppressWarnings("serial")
public abstract class BaseApplicationAction extends BaseAction {

	protected CDOApplicationService cdoApplicationService = null;
	private Long id = null;
	
	protected Application app = null;

	public BaseApplicationAction(CDOApplicationService cdoApplicationService) {
		super();
		this.cdoApplicationService = cdoApplicationService;
	}

	@Override
	public void prepare() {
		LOG.trace("prepare() called");
		//System.out.println("prepare() called ID " + this.id);
		if (this.id != null) {
			this.app = this.cdoApplicationService.load(id);
			//System.out.println("TA: " + this.ta);
		}
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the Id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @return the application
	 */
	public Application getApp() {
		return app;
	}

	protected void clearApplication() {
		this.app = null;
	}
	
	public Application getApplication(){
		return app;
	}
}