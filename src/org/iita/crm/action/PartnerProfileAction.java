/**
 * training.Struts Feb 5, 2010
 */
package org.iita.crm.action;

import java.util.List;

import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerPersonContact;
import org.iita.crm.model.PartnerPersonContact.AffiliationType;
import org.iita.crm.service.CoreCRMService;
import org.iita.util.PagedResult;
import org.springframework.dao.DataIntegrityViolationException;

import com.opensymphony.xwork2.Action;

/**
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class PartnerProfileAction extends BaseProfileAction<Partner> {
	private CoreCRMService service;
	private Long personId;
	private String personName;
	private Partner partner;
	private List<?> similarPartners;
	private PagedResult<PartnerPersonContact> associates;
	private AffiliationType affiliationType;
	
	
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
	public PartnerProfileAction(CoreCRMService service) {
		this.service = service;
	}
	
	/**
	 * @return the affiliations
	 */
	public PagedResult<PartnerPersonContact> getAssociates() {
		return this.associates;
	}
	
	/**
	 * @param affiliationType the affiliationType to set
	 */
	public void setAffiliationType(AffiliationType affiliationType) {
		this.affiliationType = affiliationType;
	}
	
	/**
	 * Used for {@link #addPartnerContact()}
	 * 
	 * @param personId the personId to set
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	/**
	 * @return the similarPartners
	 */
	public List<?> getSimilarPartners() {
		return this.similarPartners;
	}

	/**
	 * @see org.iita.trainingunit.action.BaseProfileAction#loadProfile()
	 */
	@Override
	protected Partner loadProfile() {
		this.partner = this.service.loadPartner(this.id);
		this.similarPartners = this.service.getSimilarPartners(this.partner, 5);
		return partner;
	}

	@Override
	public String execute() {
		return Action.SUCCESS;
	}

	public String addPartnerContact() {
		PartnerPersonContact partnerContact = new PartnerPersonContact();
		partnerContact.setPartner(this.profile);
		partnerContact.setType(this.affiliationType);
		if (this.personId != null)
			partnerContact.setPerson(this.service.loadPerson(this.personId));
		else
			partnerContact.setPerson(this.service.createPerson(this.personName));
		this.service.update(partnerContact);
		return "reload";
	}

	public String affiliations() {
		String result = super.execute();
		this.associates = this.service.listPartnerContacts(this.partner, startAt, maxResults);
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
			addActionError("Could not delete Partner. Other data links to it.");
			return Action.ERROR;
		}
		return "tolist";
	}
}
