/**
 * promisCRM.Struts Aug 17, 2010
 */
package org.iita.crm.action;

import org.iita.crm.service.CoreCRMService;
import org.iita.trainingunit.applications.model.Application;

/**
 * @author KOraegbunam
 *
 */
@SuppressWarnings("serial")
public class ApplicationTagBuilderAction extends TagBuilderAction<Application> {


	/**
	 * @param coreCRMService 
	 * 
	 */
	public ApplicationTagBuilderAction(CoreCRMService coreCRMService) {
		super(coreCRMService);
	}
	
	/**
	 * @see org.iita.trainingunit.action.TagBuilderAction#loadProfile(java.lang.Long)
	 */
	@Override
	protected Application loadProfile(Long id) {
		return this.coreCRMService.find(Application.class, id);
	}

}
