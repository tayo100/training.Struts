/**
 * promisCRM.Struts Aug 17, 2010
 */
package org.iita.crm.action;

import org.iita.crm.service.CoreCRMService;
import org.iita.trainingunit.announcements.model.Announcement;

/**
 * @author KOraegbunam
 *
 */
@SuppressWarnings("serial")
public class AnnouncementTagBuilderAction extends TagBuilderAction<Announcement> {


	/**
	 * @param coreCRMService 
	 * 
	 */
	public AnnouncementTagBuilderAction(CoreCRMService coreCRMService) {
		super(coreCRMService);
	}
	
	/**
	 * @see org.iita.trainingunit.action.TagBuilderAction#loadProfile(java.lang.Long)
	 */
	@Override
	protected Announcement loadProfile(Long id) {
		return this.coreCRMService.find(Announcement.class, id);
	}

}
