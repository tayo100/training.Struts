/**
 * promisCRM.Struts Aug 17, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Partner;
import org.iita.crm.service.CoreCRMService;

/**
 * @author KOraegbunam
 *
 */
@SuppressWarnings("serial")
public class PartnerTagBuilderAction extends TagBuilderAction<Partner> {
	/**
	 * @param coreCRMService 
	 * 
	 */
	public PartnerTagBuilderAction(CoreCRMService coreCRMService) {
		super(coreCRMService);
	}
	
	/**
	 * @see org.iita.promis.action.TagBuilderAction#loadProfile(java.lang.Long)
	 */
	@Override
	protected Partner loadProfile(Long id) {
		return this.coreCRMService.find(Partner.class, id);
	}

}
