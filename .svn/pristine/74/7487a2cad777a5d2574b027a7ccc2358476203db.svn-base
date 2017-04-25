/**
 * promisCRM.Struts Apr 21, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerCategory;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

/**
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class CategoryAction extends BaseAction {
	private Long id;
	private Long partnerId;
	private CoreCRMService crmService;
	private PartnerCategory category;
	private Partner partner;

	/**
	 * @param crmService
	 * 
	 */
	public CategoryAction(CoreCRMService crmService) {
		this.crmService = crmService;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the classification
	 */
	public PartnerCategory getCategory() {
		return this.category;
	}

	public void setCategory(PartnerCategory category) {
		this.category = category;
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
			this.category = this.crmService.loadCategory(this.id);
		} else {
			this.category = new PartnerCategory();
		}
	}

	public String updateCategory() {
		if (this.partner != null) {
			this.category.setPartner(this.partner);
			
			this.crmService.updateCategory(this.category);
		}
		
		if (this.category.getPartner() != null)
			return "reload";
		else
			return "tolist";
	}

	public String removeCategory() {
		this.category = this.crmService.loadCategory(this.id);
		
		if(this.category!=null)
			this.crmService.removeCategory(this.category);
		
		return "reload";
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public Long getPartnerId() {
		return partnerId;
	}
}
