/**
 * training.Struts Feb 5, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Organization;
import org.iita.crm.service.CRMException;
import org.iita.crm.service.OrganizationService;
import org.iita.struts.BaseAction;

import com.opensymphony.xwork2.Action;

/**
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public class AddOrganizationAction extends BaseAction {
	private String title;
	private Organization organization;
	private OrganizationService service;

	/**
	 * 
	 */
	public AddOrganizationAction(OrganizationService organizationService) {
		this.service = organizationService;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the organization
	 */
	public Organization getOrganization() {
		return this.organization;
	}

	/**
	 * @throws TrainingUnitDataException 
	 * @see org.iita.struts.BaseAction#execute()
	 */
	@Override
	public String execute() {
		try {
			this.organization = this.service.registerOrganization(this.title);
		} catch (javax.persistence.PersistenceException e) {
			addActionError("Organization with the same name already exists.");
			return Action.ERROR;
		} catch (CRMException e) {
			addActionError("Organization with the same name already exists.");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
}
