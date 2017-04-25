/**
 * promisCRM.Struts Aug 27, 2010
 */
package org.iita.crm.action;

import java.util.List;

import org.iita.crm.service.CoreCRMService;
import org.iita.struts.webfile.ServerFile;

/**
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public class DirectoryFilesAction extends org.iita.struts.DirectoryFilesAction {
	@SuppressWarnings("unused")
	private CoreCRMService coreCRMService;
	private List<ServerFile> files;

	/**
	 * @param directory
	 */
	public DirectoryFilesAction(String directory) {
		super(directory);
	}
	
	/**
	 * @param coreCRMService the coreCRMService to set
	 */
	public void setCoreCRMService(CoreCRMService coreCRMService) {
		this.coreCRMService = coreCRMService;
	}

	/**
	 * @see org.iita.struts.FilesAction#getFiles()
	 */
	@Override
	public List<ServerFile> getFiles() {
		if (this.files == null) {
			this.files = super.getFiles();
		}
		return this.files;
	}
}
