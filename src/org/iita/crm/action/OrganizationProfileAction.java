/**
 * training.Struts Feb 5, 2010
 */
package org.iita.crm.action;

import java.util.List;

import org.iita.crm.model.Affiliation;
import org.iita.crm.model.Organization;
import org.iita.crm.model.Affiliation.AffiliationType;
import org.iita.crm.service.CoreCRMService;
import org.iita.util.PagedResult;
import org.springframework.dao.DataIntegrityViolationException;

import com.opensymphony.xwork2.Action;

/**
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public class OrganizationProfileAction extends BaseProfileAction<Organization> {
	private CoreCRMService service;
	private Long personId;
	private AffiliationType affiliationType;
	private String personName;
	protected Organization organization;
	private List<?> similarOrganizations;
	private PagedResult<Affiliation> affiliations;
	private int maxResults = 20;
	private int startAt;
	
	/**
	 * @param startAt the startAt to set
	 */
	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}
	
	/**
	 * @param service instance of CoreCRMService
	 * 
	 */
	public OrganizationProfileAction(CoreCRMService service) {
		this.service = service;
	}
	
	/**
	 * @return the affiliations
	 */
	public PagedResult<Affiliation> getAffiliations() {
		return this.affiliations;
	}
	
	/**
	 * Used for {@link #addAffiliation()}
	 * 
	 * @param personId the personId to set
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * @param affiliationType the affiliationType to set
	 */
	public void setAffiliationType(AffiliationType affiliationType) {
		this.affiliationType = affiliationType;
	}

	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}


	/**
	 * @return the similarOrganizations
	 */
	public List<?> getSimilarOrganizations() {
		return this.similarOrganizations;
	}

	/**
	 * @see org.iita.trainingunit.action.BaseProfileAction#loadProfile()
	 */
	@Override
	protected Organization loadProfile() {
		this.organization = this.service.loadOrganization(this.id);
		this.similarOrganizations = this.service.getSimilarOrganizations(this.organization, 5);
		return organization;
	}

	@Override
	public String execute() {
		return Action.SUCCESS;
	}

	public String addAffiliation() {
		Affiliation affiliation = new Affiliation();
		affiliation.setType(this.affiliationType);
		affiliation.setOrganization(this.profile);
		if (this.personId != null)
			affiliation.setPerson(this.service.loadPerson(this.personId));
		else
			affiliation.setPerson(this.service.createPerson(this.personName));
		this.service.update(affiliation);
		return "reload";
	}
	
	public String affiliations() {
		String result = super.execute();
		this.affiliations = this.service.listAffiliations(this.organization, startAt, maxResults);
		return result;
	}
	
	public String update() {
		this.service.update(this.profile);
		return "reload";
	}

	public String delete() {
		try {
			this.service.delete(this.profile);
		} catch (DataIntegrityViolationException e) {
			addActionError("Could not delete Organization. Other data links to it.");
			return Action.ERROR;
		}
		return "tolist";
	}
}
