/**
 * 
 */
package org.iita.crm.action;

import org.iita.crm.model.TrainTheTrainerDocument;
import org.iita.crm.service.CoreCRMService;
import org.iita.trainingunit.announcements.model.TrainTheTrainer;

/**
 * @author koraegbunam
 *
 */
@SuppressWarnings("serial")
public class TrainTheTrainerDocumentAction extends EntityDocumentAction<TrainTheTrainer, TrainTheTrainerDocument> {

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
	protected TrainTheTrainerDocument createNewDocument() {
		return new TrainTheTrainerDocument();
	}

	/**
	 * @see org.iita.crm.action.EntityDocumentAction#loadEntity(java.lang.Long)
	 */
	@Override
	protected TrainTheTrainer loadEntity(Long entityId) {
		return this.coreCRMService.find(TrainTheTrainer.class, entityId);
	}
	
	/**
	 * @see org.iita.crm.action.EntityDocumentAction#loadEntityDocument(long)
	 */
	@Override
	protected TrainTheTrainerDocument loadEntityDocument(long id) {
		return this.coreCRMService.find(TrainTheTrainerDocument.class, id);
	}
}
