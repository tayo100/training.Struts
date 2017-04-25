/**
 * promisCRM.Struts Jul 5, 2010
 */
package org.iita.crm.action;

import org.apache.struts2.ServletActionContext;
import org.iita.crm.model.Document;
import org.iita.crm.service.DocumentService;
import org.iita.struts.BaseAction;

import com.opensymphony.xwork2.Action;

/**
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public class DocumentAction extends BaseAction {
	private DocumentService documentService;
	private Long id;
	private Document document = new Document();
	private String referer;

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param documentService
	 * 
	 */
	public DocumentAction(DocumentService documentService) {
		this.documentService = documentService;
	}

	/**
	 * @return the document
	 */
	public Document getDocument() {
		return this.document;
	}

	/**
	 * @return the referer
	 */
	public String getReferer() {
		return this.referer;
	}

	/**
	 * @see org.iita.struts.BaseAction#prepare()
	 */
	@Override
	public void prepare() {
		this.referer = ServletActionContext.getRequest().getHeader("Referer");

		if (this.id != null)
			this.document = this.documentService.findDocument(this.id);
	}

	public String update() {
		this.documentService.update(this.document);
		return Action.SUCCESS;
	}

	public String remove() {
		this.documentService.remove(this.document);
		return Action.SUCCESS;
	}
}
