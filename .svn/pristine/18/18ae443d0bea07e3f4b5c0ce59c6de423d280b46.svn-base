/**
 * promisCRM.Struts Apr 21, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerScale;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

/**
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class PartnerScaleAction extends BaseAction {
	private Long id;
	private Long partnerId;
	private CoreCRMService crmService;
	private PartnerScale scale;
	private Partner partner;

	/**
	 * @param crmService
	 * 
	 */
	public PartnerScaleAction(CoreCRMService crmService) {
		this.crmService = crmService;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the scale
	 */
	public PartnerScale getScale() {
		return this.scale;
	}

	public void setScale(PartnerScale scale) {
		this.scale = scale;
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
			this.scale = this.crmService.loadScale(this.id);
		} else {
			this.scale = new PartnerScale();
		}
	}

	public String update() {
		if (this.partner != null) {
			this.scale.setPartner(this.partner);
			
			this.crmService.updateScale(this.scale);
		}
		
		if (this.scale.getPartner() != null)
			return "reload";
		else
			return "tolist";
	}

	public String remove() {
		this.scale = this.crmService.loadScale(this.id);
		
		if(this.scale!=null)
			this.crmService.removeScale(this.scale);
		
		return "reload";
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public Long getPartnerId() {
		return partnerId;
	}
}
