/**
 * promisCRM.Struts Apr 9, 2010
 */
package org.iita.crm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.iita.crm.model.Document;
import org.iita.crm.service.DocumentService;
import org.iita.struts.BaseAction;
import org.iita.struts.DownloadableStream;
import org.iita.util.StringUtil;

import com.opensymphony.xwork2.Action;

/**
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public class DownloadDocumentAction extends BaseAction implements DownloadableStream {
	private String downloadFileName;
	private InputStream downloadStream;
	private String file;
	private DocumentService documentService;

	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * @param documentService
	 * 
	 */
	public DownloadDocumentAction(DocumentService documentService) {
		this.documentService = documentService;
	}

	/**
	 * @see org.iita.struts.BaseAction#execute()
	 */
	@Override
	public String execute() {
		// find file in Documents
		Document document = this.documentService.load(this.file);
		if (document != null) {
			LOG.info("Downloading document: " + document.getTitle());
			File file;
			try {
				file = this.documentService.getFile(document);
				LOG.info("Downloading file: " + file.getAbsolutePath());
				this.downloadFileName = StringUtil.sanitizeFileName(file.getName());
				this.downloadStream = new FileInputStream(file);
				return "download";
			} catch (IOException e) {
				addActionError(e.getMessage());
				return Action.ERROR;
			}
		} else {
			addActionError("Requested document " + this.file + " does not exist");
			return Action.ERROR;
		}
	}

	/**
	 * @see org.iita.struts.DownloadableStream#getDownloadFileName()
	 */
	@Override
	public String getDownloadFileName() {
		LOG.debug("Sending as filename: " + this.downloadFileName);
		return this.downloadFileName;
	}

	/**
	 * @see org.iita.struts.DownloadableStream#getDownloadStream()
	 */
	@Override
	public InputStream getDownloadStream() {
		return this.downloadStream;
	}

}
