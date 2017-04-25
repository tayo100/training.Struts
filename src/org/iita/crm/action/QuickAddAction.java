/**
 * promisCRM.Struts Apr 13, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Organization;
import org.iita.crm.service.CRMException;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

import com.opensymphony.xwork2.Action;

/**
 * @author mobreza
 *
 */
@SuppressWarnings("serial")
public class QuickAddAction extends BaseAction {
	protected Long id=null;
	protected String title=null;
	private CoreCRMService service;
	protected String shortName;
	
	/**
	 * @param service 
	 * 
	 */
	public QuickAddAction(CoreCRMService service) {
		this.service=service;
	}
	
	public String addOrganization() {
		Organization organization;
		try {
			organization = this.service.registerOrganization(this.title);
			this.id=organization.getId();
		} catch (CRMException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}
}
