/**
 * 
 */
package org.iita.crm.action;

import org.iita.crm.model.ApplicationReportDocument;
import org.iita.crm.service.CoreCRMService;
import org.iita.trainingunit.applications.model.Application;

/**
 * @author koraegbunam
 *
 */
@SuppressWarnings("serial")
public class ApplicationReportDocumentAction extends EntityDocumentAction<Application, ApplicationReportDocument> {

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
	protected ApplicationReportDocument createNewDocument() {
		return new ApplicationReportDocument();
	}

	/**
	 * @see org.iita.crm.action.EntityDocumentAction#loadEntity(java.lang.Long)
	 */
	@Override
	protected Application loadEntity(Long entityId) {
		return this.coreCRMService.find(Application.class, entityId);
	}
	
	/**
	 * @see org.iita.crm.action.EntityDocumentAction#loadEntityDocument(long)
	 */
	@Override
	protected ApplicationReportDocument loadEntityDocument(long id) {
		return this.coreCRMService.find(ApplicationReportDocument.class, id);
	}
}
