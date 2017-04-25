/**
 * promisCRM.Struts Apr 21, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerPersonContact;
import org.iita.crm.model.PartnerPersonContact.AffiliationType;
import org.iita.crm.model.PartnerPersonContact.Status;
import org.iita.crm.model.Person;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

/**
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class PartnerPersonContactAction extends BaseAction {
	private Long id;
	private CoreCRMService crmService;
	private PartnerPersonContact affiliation;
	private Partner partner;
	private Person person;
	private AffiliationType affiliationType;
	//private String discipline;
	private Status status;

	/**
	 * @param crmService
	 * 
	 */
	public PartnerPersonContactAction(CoreCRMService crmService) {
		this.crmService = crmService;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the affiliationType
	 */
	public AffiliationType getAffiliationType() {
		return this.affiliationType;
	}
	
	/**
	 * @param affiliationType the affiliationType to set
	 */
	public void setAffiliationType(AffiliationType affiliationType) {
		this.affiliationType = affiliationType;
	}
	
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return this.status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	/**
	 * @return the affiliation
	 */
	public PartnerPersonContact getAffiliation() {
		return this.affiliation;
	}
	
	/**
	 * @return the partner
	 */
	public Partner getPartner() {
		return this.partner;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return this.person;
	}

	/**
	 * @see org.iita.struts.BaseAction#prepare()
	 */
	@Override
	public void prepare() {
		if (this.id != null) {
			this.affiliation = this.crmService.loadPartnerContact(this.id);
		} else {
			this.affiliation = new PartnerPersonContact();
		}
	}

	public String update() {
		this.partner = this.affiliation.getPartner();
		this.person = this.affiliation.getPerson();
		this.affiliation.setType(this.affiliationType);
		this.affiliation.setStatus(this.status);
		this.crmService.update(this.affiliation);
		if (this.partner != null)
			return "reload-partner";
		else
			return "reload-person";
	}

	public String remove() {
		this.partner = this.affiliation.getPartner();
		this.person = this.affiliation.getPerson();
		
		if(this.affiliation != null)
			this.crmService.remove(this.affiliation);
		
		if (this.partner != null)
			return "reload-partner";
		else
			return "reload-person";
	}
}
