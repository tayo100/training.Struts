/**
 * 
 */
package org.iita.crm.action;

import org.iita.crm.model.AnnouncementDocument;
import org.iita.crm.service.CoreCRMService;
import org.iita.trainingunit.announcements.model.Announcement;

/**
 * @author koraegbunam
 *
 */
@SuppressWarnings("serial")
public class AnnouncementDocumentAction extends EntityDocumentAction<Announcement, AnnouncementDocument> {

	private CoreCRMService coreCRMService;

	/**
	 * @see org.iita.crm.action.EntityDocumentAction#setDocumentService(org.iita.crm.service.DocumentService)
	 */
	public void setDocumentService(CoreCRMService coreCRMService) {
		super.setDocumentService(coreCRMService);
		this.coreCRMService = coreCRMService;
	}

	/**
	 * @see org.iita.crm.action.EntityDocumentAction#createNewDocument()
	 */
	@Override
	protected AnnouncementDocument createNewDocument() {
		return new AnnouncementDocument();
	}

	/**
	 * @see org.iita.crm.action.EntityDocumentAction#loadEntity(java.lang.Long)
	 */
	@Override
	protected Announcement loadEntity(Long entityId) {
		return this.coreCRMService.find(Announcement.class, entityId);
	}
	
	/**
	 * @see org.iita.crm.action.EntityDocumentAction#loadEntityDocument(long)
	 */
	@Override
	protected AnnouncementDocument loadEntityDocument(long id) {
		return this.coreCRMService.find(AnnouncementDocument.class, id);
	}
}
