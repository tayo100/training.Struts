/**
 * promisCRM.Struts Aug 6, 2010
 */
package org.iita.crm.action;

import org.iita.crm.model.Organization;
import org.iita.crm.model.OrganizationDocument;
import org.iita.crm.service.CoreCRMService;

/**
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public class OrganizationDocumentAction extends EntityDocumentAction<Organization, OrganizationDocument> {

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
	protected OrganizationDocument createNewDocument() {
		return new OrganizationDocument();
	}

	/**
	 * @see org.iita.crm.action.EntityDocumentAction#loadEntity(java.lang.Long)
	 */
	@Override
	protected Organization loadEntity(Long entityId) {
		return this.coreCRMService.find(Organization.class, entityId);
	}
	
	/**
	 * @see org.iita.crm.action.EntityDocumentAction#loadEntityDocument(long)
	 */
	@Override
	protected OrganizationDocument loadEntityDocument(long id) {
		return this.coreCRMService.find(OrganizationDocument.class, id);
	}
}
