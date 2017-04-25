/**
 * promisCRM.Struts Apr 21, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerCoreBusinessCategory;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

/**
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class CoreBusinessCategoryAction extends BaseAction {
	private Long id;
	private Long partnerId;
	private CoreCRMService crmService;
	private PartnerCoreBusinessCategory coreBusinessCategory;
	private Partner partner;

	/**
	 * @param crmService
	 * 
	 */
	public CoreBusinessCategoryAction(CoreCRMService crmService) {
		this.crmService = crmService;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the coreBusinessCategory
	 */
	public PartnerCoreBusinessCategory getCoreBusinessCategory() {
		return this.coreBusinessCategory;
	}

	public void setCoreBusinessCategory(PartnerCoreBusinessCategory coreBusinessCategory) {
		this.coreBusinessCategory = coreBusinessCategory;
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
			this.coreBusinessCategory = this.crmService.loadCoreBusinessCategory(this.id);
		} else {
			this.coreBusinessCategory = new PartnerCoreBusinessCategory();
		}
	}

	public String update() {
		if(this.coreBusinessCategory==null){
			addActionError("Core Business Category is empty!");
			return "reload";
		}
		
		if(this.coreBusinessCategory!=null)
			if(this.coreBusinessCategory.getType()==null){
				addActionError("Core Business Category field is empty!");
				return "reload";
			}
		
		if (this.partner != null) {
			this.coreBusinessCategory.setPartner(this.partner);
			
			this.crmService.updateCoreBusinessCategory(this.coreBusinessCategory);
		}
		
		if (this.coreBusinessCategory.getPartner() != null)
			return "reload";
		else
			return "tolist";
	}

	public String remove() {
		this.coreBusinessCategory = this.crmService.loadCoreBusinessCategory(this.id);
		
		if(this.coreBusinessCategory!=null)
			this.crmService.removeCoreBusinessCategory(this.coreBusinessCategory);
		
		return "reload";
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public Long getPartnerId() {
		return partnerId;
	}
}
