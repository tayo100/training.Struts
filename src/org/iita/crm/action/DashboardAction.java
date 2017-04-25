/**
 * training.Struts Feb 5, 2010
 */
package org.iita.crm.action;

import java.util.List;

import org.iita.crm.model.Organization;
import org.iita.crm.model.Person;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

import com.opensymphony.xwork2.Action;

/**
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public class DashboardAction extends BaseAction {
	private CoreCRMService service;
	private List<?> persons;
	private List<?> organizations;

	/**
	 * @param service 
	 * 
	 */
	public DashboardAction(CoreCRMService service) {
		this.service = service;
	}

	/**
	 * @return the persons
	 */
	public List<?> getPersons() {
		return this.persons;
	}

	/**
	 * @return the organizations
	 */
	public List<?> getOrganizations() {
		return this.organizations;
	}

	/**
	 * @see org.iita.struts.BaseAction#execute()
	 */
	@Override
	public String execute() {
		this.persons = this.service.getLastUpdated(Person.class, 10);
		this.organizations = this.service.getLastUpdated(Organization.class, 10);
		
		return Action.SUCCESS;
	}

}
