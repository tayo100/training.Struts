/**
 * promisCRM.Struts Apr 21, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerSubsector;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

/**
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class PartnerSubsectorAction extends BaseAction {
	private Long id;
	private Long partnerId;
	private CoreCRMService crmService;
	private PartnerSubsector subsector;
	private Partner partner;

	/**
	 * @param crmService
	 * 
	 */
	public PartnerSubsectorAction(CoreCRMService crmService) {
		this.crmService = crmService;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the subsector
	 */
	public PartnerSubsector getSubsector() {
		return this.subsector;
	}

	public void setSubsector(PartnerSubsector subsector) {
		this.subsector = subsector;
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
			this.subsector = this.crmService.loadSubsector(this.id);
		} else {
			this.subsector = new PartnerSubsector();
		}
	}

	public String update() {
		if (this.partner != null) {
			this.subsector.setPartner(this.partner);
			
			this.crmService.updateSubsector(this.subsector);
		}
		
		if (this.subsector.getPartner() != null)
			return "reload";
		else
			return "tolist";
	}

	public String remove() {
		this.subsector = this.crmService.loadSubsector(this.id);
		
		if(this.subsector!=null)
			this.crmService.removeSubsector(this.subsector);
		
		return "reload";
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public Long getPartnerId() {
		return partnerId;
	}
}
