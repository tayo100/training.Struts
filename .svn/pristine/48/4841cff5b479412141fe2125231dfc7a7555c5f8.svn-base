/**
 * promisCRM.Struts Apr 21, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerSector;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

/**
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class PartnerSectorAction extends BaseAction {
	private Long id;
	private Long partnerId;
	private CoreCRMService crmService;
	private PartnerSector sector;
	private Partner partner;

	/**
	 * @param crmService
	 * 
	 */
	public PartnerSectorAction(CoreCRMService crmService) {
		this.crmService = crmService;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the sector
	 */
	public PartnerSector getSector() {
		return this.sector;
	}

	public void setSector(PartnerSector sector) {
		this.sector = sector;
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
			this.sector = this.crmService.loadSector(this.id);
		} else {
			this.sector = new PartnerSector();
		}
	}

	public String update() {
		if (this.partner != null) {
			this.sector.setPartner(this.partner);
			
			this.crmService.updateSector(this.sector);
		}
		
		if (this.sector.getPartner() != null)
			return "reload";
		else
			return "tolist";
	}

	public String remove() {
		this.sector = this.crmService.loadSector(this.id);
		
		if(this.sector!=null)
			this.crmService.removeSector(this.sector);
		
		return "reload";
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public Long getPartnerId() {
		return partnerId;
	}
}
