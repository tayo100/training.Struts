/**
 * promisCRM.Struts Apr 21, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerCoreBusiness;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

/**
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class CoreBusinessAction extends BaseAction {
	private Long id;
	private Long partnerId;
	private CoreCRMService crmService;
	private PartnerCoreBusiness coreBusiness;
	private Partner partner;

	/**
	 * @param crmService
	 * 
	 */
	public CoreBusinessAction(CoreCRMService crmService) {
		this.crmService = crmService;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the coreBusiness
	 */
	public PartnerCoreBusiness getCoreBusiness() {
		return this.coreBusiness;
	}

	public void setCoreBusiness(PartnerCoreBusiness coreBusiness) {
		this.coreBusiness = coreBusiness;
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
			this.coreBusiness = this.crmService.loadCoreBusiness(this.id);
		} else {
			this.coreBusiness = new PartnerCoreBusiness();
		}
	}

	public String updateCoreBusiness() {
		if (this.partner != null) {
			this.coreBusiness.setPartner(this.partner);
			
			this.crmService.updateCoreBusiness(this.coreBusiness);
		}
		
		if (this.coreBusiness.getPartner() != null)
			return "reload";
		else
			return "tolist";
	}

	public String removeCoreBusiness() {
		this.coreBusiness = this.crmService.loadCoreBusiness(this.id);
		
		if(this.coreBusiness!=null)
			this.crmService.removeCoreBusiness(this.coreBusiness);
		
		return "reload";
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public Long getPartnerId() {
		return partnerId;
	}
}
