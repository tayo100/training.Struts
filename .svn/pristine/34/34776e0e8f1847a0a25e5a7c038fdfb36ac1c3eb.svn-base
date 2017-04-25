/**
 * 
 */
package org.iita.crm.action;

import org.iita.crm.model.Person;
import org.iita.crm.model.PersonDocument;
import org.iita.crm.service.CoreCRMService;

/**
 * @author koraegbunam
 *
 */
@SuppressWarnings("serial")
public class PersonDocumentAction extends EntityDocumentAction<Person, PersonDocument> {

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
	protected PersonDocument createNewDocument() {
		return new PersonDocument();
	}

	/**
	 * @see org.iita.crm.action.EntityDocumentAction#loadEntity(java.lang.Long)
	 */
	@Override
	protected Person loadEntity(Long entityId) {
		return this.coreCRMService.find(Person.class, entityId);
	}
	
	/**
	 * @see org.iita.crm.action.EntityDocumentAction#loadEntityDocument(long)
	 */
	@Override
	protected PersonDocument loadEntityDocument(long id) {
		return this.coreCRMService.find(PersonDocument.class, id);
	}
}
