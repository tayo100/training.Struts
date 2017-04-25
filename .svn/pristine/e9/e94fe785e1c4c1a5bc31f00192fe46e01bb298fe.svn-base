/**
 * promisCRM.Struts Apr 21, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerMandateCrop;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

/**
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class MandateCropAction extends BaseAction {
	private Long id;
	private Long partnerId;
	private CoreCRMService crmService;
	private PartnerMandateCrop mandateCrop;
	private Partner partner;

	/**
	 * @param crmService
	 * 
	 */
	public MandateCropAction(CoreCRMService crmService) {
		this.crmService = crmService;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the mandateCrop
	 */
	public PartnerMandateCrop getMandateCrop() {
		return this.mandateCrop;
	}

	public void setMandateCrop(PartnerMandateCrop mandateCrop) {
		this.mandateCrop = mandateCrop;
	}

	/**
	 * @return the partner
	 */
	public Partner getPartner() {
		return this.partner;
	}


	/**
	 * @see org.iita.struts.BaseAction#prepare()
	 */
	@Override
	public void prepare() {
		if (this.partnerId != null)
			this.partner = this.crmService.loadPartner(this.partnerId);
			
		if (this.id != null) {
			this.mandateCrop = this.crmService.loadMandateCrop(this.id);
		} else {
			this.mandateCrop = new PartnerMandateCrop();
		}
	}

	public String updateMandateCrop() {
		if (this.partner != null) {
			this.mandateCrop.setPartner(this.partner);
			
			this.crmService.updateMandateCrop(this.mandateCrop);
		}
		
		if (this.mandateCrop.getPartner() != null)
			return "reload";
		else
			return "tolist";
	}

	public String removeMandateCrop() {
		this.mandateCrop = this.crmService.loadMandateCrop(this.id);
		
		if(this.mandateCrop!=null)
			this.crmService.removeMandateCrop(this.mandateCrop);
		
		return "reload";
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public Long getPartnerId() {
		return partnerId;
	}
}
