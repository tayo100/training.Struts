/**
 * promisCRM.Struts Apr 21, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Affiliation;
import org.iita.crm.model.Organization;
import org.iita.crm.model.Person;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

/**
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public class AffiliationAction extends BaseAction {
	private Long id;
	private CoreCRMService crmService;
	private Affiliation affiliation;
	private Organization organization;
	private Person person;

	/**
	 * @param crmService
	 * 
	 */
	public AffiliationAction(CoreCRMService crmService) {
		this.crmService = crmService;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the affiliation
	 */
	public Affiliation getAffiliation() {
		return this.affiliation;
	}

	/**
	 * @param affiliation the affiliation to set
	 */
	public void setAffiliation(Affiliation affiliation) {
		this.affiliation = affiliation;
	}
	
	/**
	 * @return the organization
	 */
	public Organization getOrganization() {
		return this.organization;
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
			this.affiliation = this.crmService.loadAffiliation(this.id);
		} else {
			this.affiliation = new Affiliation();
		}
	}

	public String update() {
		this.organization = this.affiliation.getOrganization();
		this.person = this.affiliation.getPerson();
		this.crmService.update(this.affiliation);
		if (this.person != null)
			return "reload-person";
		else
			return "reload-organization";
	}

	public String remove() {
		this.organization = this.affiliation.getOrganization();
		this.person = this.affiliation.getPerson();
		this.crmService.remove(this.affiliation);
		if (this.person != null)
			return "reload-person";
		else
			return "reload-organization";
	}
}
