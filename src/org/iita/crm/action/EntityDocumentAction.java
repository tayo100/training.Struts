/**
 * promisCRM.Struts Aug 6, 2010
 */
package org.iita.crm.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.crm.model.EntityDocument;
import org.iita.crm.service.DocumentService;
import org.iita.struts.BaseAction;
import org.iita.struts.FileUploadAction;

import com.opensymphony.xwork2.Action;

/**
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public abstract class EntityDocumentAction<ENTITY, ENTITYDOCUMENT extends EntityDocument<ENTITY>> extends BaseAction implements FileUploadAction {
	protected static Log LOG = LogFactory.getLog(EntityDocumentAction.class);
	private List<String> uploadFileNames;
	private List<File> uploads;
	protected ENTITY entity;
	private DocumentService documentService;
	private ENTITYDOCUMENT entityDocument = createNewDocument();

	/**
	 * @param documentService the documentService to set
	 */
	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}

	/**
	 * Make sure you use <code>@TypeConversion(converter = "genericConverter")</code> when you override this method!
	 * 
	 * @param entity the entity to set
	 */
	public void setEntityId(Long entityId) {
		this.entity=loadEntity(entityId);
	}
	
	public void setId(long id) {
		this.entityDocument=loadEntityDocument(id);
	}

	/**
	 * Load Entity document
	 * @param id
	 * @return
	 */
	protected abstract ENTITYDOCUMENT loadEntityDocument(long id);

	/**
	 * @param entityId
	 * @return
	 */
	protected abstract ENTITY loadEntity(Long entityId);

	/**
	 * @return the entityDocument
	 */
	public ENTITYDOCUMENT getEntityDocument() {
		return this.entityDocument;
	}

	/**
	 * @see org.iita.struts.FileUploadAction#setUploads(java.util.List)
	 */
	@Override
	public void setUploads(List<File> uploads) {
		this.uploads = uploads;
	}

	/**
	 * @see org.iita.struts.FileUploadAction#setUploadsContentType(java.util.List)
	 */
	@Override
	public void setUploadsContentType(List<String> uploadContentTypes) {

	}

	/**
	 * @see org.iita.struts.FileUploadAction#setUploadsFileName(java.util.List)
	 */
	@Override
	public void setUploadsFileName(List<String> uploadFileNames) {
		this.uploadFileNames = uploadFileNames;
	}

	/**
	 * @see org.iita.struts.BaseAction#prepare()
	 */
	@Override
	public void prepare() {
		if (this.entity != null) {
			this.entityDocument.setEntity(this.entity);
		}
	}

	/**
	 * @return
	 */
	protected abstract ENTITYDOCUMENT createNewDocument();

	public String upload() {
		if (this.uploads==null || this.uploads.size()==0)
		{
			addActionError("No files selected to upload! Please try again");
			return Action.SUCCESS;
		}
		
		for (File file : this.uploads) {
			try {
				this.documentService.upload(this.entityDocument, this.uploadFileNames.get(this.uploads.indexOf(file)), file);
			} catch (IOException e) {
				addActionError(e.getMessage());
				return Action.ERROR;
			}
		}
		return Action.SUCCESS;
	}
	
	public String update() {
		this.documentService.update(this.entityDocument.getDocument());
		return Action.SUCCESS;
	}
	
	public String remove() {
		this.documentService.remove(this.entityDocument);
		return Action.SUCCESS;
	}
}
