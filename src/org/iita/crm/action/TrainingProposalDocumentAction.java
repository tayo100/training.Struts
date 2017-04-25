/**
 * 
 */
package org.iita.crm.action;

import org.iita.crm.model.TrainingProposalDocument;
import org.iita.crm.service.CoreCRMService;
import org.iita.trainingunit.announcements.model.TrainingProposal;

/**
 * @author koraegbunam
 *
 */
@SuppressWarnings("serial")
public class TrainingProposalDocumentAction extends EntityDocumentAction<TrainingProposal, TrainingProposalDocument> {

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
	protected TrainingProposalDocument createNewDocument() {
		return new TrainingProposalDocument();
	}

	/**
	 * @see org.iita.crm.action.EntityDocumentAction#loadEntity(java.lang.Long)
	 */
	@Override
	protected TrainingProposal loadEntity(Long entityId) {
		return this.coreCRMService.find(TrainingProposal.class, entityId);
	}
	
	/**
	 * @see org.iita.crm.action.EntityDocumentAction#loadEntityDocument(long)
	 */
	@Override
	protected TrainingProposalDocument loadEntityDocument(long id) {
		return this.coreCRMService.find(TrainingProposalDocument.class, id);
	}
}
