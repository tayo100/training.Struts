/**
 * promisCRM.Struts Apr 21, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerIITAHub;
import org.iita.crm.model.PartnerIITAHub.IITAHub;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

/**
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class IitaHubAction extends BaseAction {
	private Long id;
	private Long partnerId;
	private CoreCRMService crmService;
	private PartnerIITAHub iitahub;
	private Partner partner;
	private String hub;

	/**
	 * @param crmService
	 * 
	 */
	public IitaHubAction(CoreCRMService crmService) {
		this.crmService = crmService;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the iitahub
	 */
	public PartnerIITAHub getIitahub() {
		return this.iitahub;
	}

	/**
	 * @return the partner
	 */
	public Partner getPartner() {
		return this.partner;
	}

	/**
	 * @param hub the hub to set
	 */
	public void setHub(String hub) {
		this.hub = hub;
	}

	/**
	 * @see org.iita.struts.BaseAction#prepare()
	 */
	@Override
	public void prepare() {
		if (this.partnerId != null)
			this.partner = this.crmService.loadPartner(this.partnerId);
			
		if (this.id != null) {
			this.iitahub = this.crmService.loadIitahub(this.id);
		} else {
			this.iitahub = new PartnerIITAHub();
		}
	}

	public String updateIitaHub() {
		if (this.partner != null) {
			
			if(this.iitahub==null)
				this.iitahub = new PartnerIITAHub();
			
			this.iitahub.setPartner(this.partner);
			
			System.out.println("HUB SELECTED" + this.hub);
			
			if(this.hub.contains("EASTERNAFRICA"))
				this.iitahub.setHub(IITAHub.EASTERNAFRICA);
			if(this.hub.contains("WESTERNAFRICA"))
				this.iitahub.setHub(IITAHub.WESTERNAFRICA);
			if(this.hub.contains("SOUTHERNAFRICA"))
				this.iitahub.setHub(IITAHub.SOUTHERNAFRICA);
			if(this.hub.contains("CENTRALAFRICA"))
				this.iitahub.setHub(IITAHub.CENTRALAFRICA);
			
			this.crmService.updateIitahub(this.iitahub);
		}
		
		if (this.iitahub.getPartner() != null)
			return "reload";
		else
			return "tolist";
	}

	public String removeIitaHub() {
		this.iitahub = this.crmService.loadIitahub(this.id);
		
		if(this.iitahub!=null)
			this.crmService.removeIitahub(this.iitahub);
		
		return "reload";
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public Long getPartnerId() {
		return partnerId;
	}
}
