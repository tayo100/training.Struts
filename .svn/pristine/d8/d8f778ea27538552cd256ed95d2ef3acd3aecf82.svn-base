/**
 * 
 */
package org.iita.crm.action;

import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerDocument;
import org.iita.crm.service.CoreCRMService;

/**
 * @author koraegbunam
 *
 */
@SuppressWarnings("serial")
public class PartnerDocumentAction extends EntityDocumentAction<Partner, PartnerDocument> {

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
	protected PartnerDocument createNewDocument() {
		return new PartnerDocument();
	}

	/**
	 * @see org.iita.crm.action.EntityDocumentAction#loadEntity(java.lang.Long)
	 */
	@Override
	protected Partner loadEntity(Long entityId) {
		return this.coreCRMService.find(Partner.class, entityId);
	}
	
	/**
	 * @see org.iita.crm.action.EntityDocumentAction#loadEntityDocument(long)
	 */
	@Override
	protected PartnerDocument loadEntityDocument(long id) {
		return this.coreCRMService.find(PartnerDocument.class, id);
	}
}
