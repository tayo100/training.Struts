package org.iita.trainingunit.applications.action;

import org.iita.crm.action.BaseAction;
import org.iita.trainingunit.applications.model.ApplicantsBioData;
import org.iita.trainingunit.applications.service.CDOApplicationService;

@SuppressWarnings("serial")
public abstract class BaseBIOAction extends BaseAction {
	protected CDOApplicationService cdoApplicationService = null;
	private Long id;
	
	protected ApplicantsBioData cdoBioData;

	public BaseBIOAction(CDOApplicationService cdoApplicationService) {
		super();
		this.cdoApplicationService = cdoApplicationService;
	}

	@Override
	public void prepare() {
		if (this.id != null)
			this.cdoBioData = this.cdoApplicationService.findBioData(this.id);

		if(getUser()!=null && this.cdoBioData==null)
			this.cdoBioData = this.cdoApplicationService.findByUser(getUser());
	}
	
	protected void createBlankBIO() {
		this.cdoBioData = new ApplicantsBioData();		
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
	 * @return the bio data
	 */
	public ApplicantsBioData getCdoBioData() {
		return cdoBioData;
	}
}
