/**
 * promisCRM.Struts Apr 21, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerClassification;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

/**
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class ClassificationAction extends BaseAction {
	private Long id;
	private Long partnerId;
	private CoreCRMService crmService;
	private PartnerClassification classification;
	private Partner partner;

	/**
	 * @param crmService
	 * 
	 */
	public ClassificationAction(CoreCRMService crmService) {
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
	public PartnerClassification getClassification() {
		return this.classification;
	}

	public void setClassification(PartnerClassification classification) {
		this.classification = classification;
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
			this.classification = this.crmService.loadClassification(this.id);
		} else {
			this.classification = new PartnerClassification();
		}
	}

	public String updateClassification() {
		if (this.partner != null) {
			this.classification.setPartner(this.partner);
			
			this.crmService.updateClassification(this.classification);
		}
		
		if (this.classification.getPartner() != null)
			return "reload";
		else
			return "tolist";
	}

	public String removeClassification() {
		this.classification = this.crmService.loadClassification(this.id);
		
		if(this.classification!=null)
			this.crmService.removeClassification(this.classification);
		
		return "reload";
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public Long getPartnerId() {
		return partnerId;
	}
}
