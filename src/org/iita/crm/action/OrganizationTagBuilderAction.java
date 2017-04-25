/**
 * promisCRM.Struts Aug 17, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Organization;
import org.iita.crm.service.CoreCRMService;

/**
 * @author mobreza
 *
 */
@SuppressWarnings("serial")
public class OrganizationTagBuilderAction extends TagBuilderAction<Organization> {


	/**
	 * @param coreCRMService 
	 * 
	 */
	public OrganizationTagBuilderAction(CoreCRMService coreCRMService) {
		super(coreCRMService);
	}
	
	/**
	 * @see org.iita.promis.action.TagBuilderAction#loadProfile(java.lang.Long)
	 */
	@Override
	protected Organization loadProfile(Long id) {
		return this.coreCRMService.find(Organization.class, id);
	}

}
