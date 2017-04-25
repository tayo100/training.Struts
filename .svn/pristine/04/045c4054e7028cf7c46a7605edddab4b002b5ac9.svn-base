/**
 * trainingunit.Struts Feb 1, 2010
 */
package org.iita.trainingunit.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.service.TrainingUnitService;
import org.iita.struts.FilesAction;
import org.iita.struts.webfile.ServerFile;

/**
 * @author koraegbunam
 * 
 */
@SuppressWarnings("serial")
public class GroupFilesAction extends FilesAction {
	private TrainingUnitService service;
	private TrainingProgram group;

	@Override
	public void setId(Long id) {
		this.group = this.service.loadTrainingProgram(id);
	}

	/**
	 * Get ID
	 * 
	 * @return the ID
	 */
	@Override
	public Long getId() {		
		return this.group == null ? null : this.group.getId();
	}
	
	@Override
	public String getBrowserTitle() {
		return this.group == null ? null : this.group.getTitle();
	}
	
	public TrainingProgram getGroup() {
		return this.group;
	}

	/**
	 * @param service
	 * 
	 */
	public GroupFilesAction(TrainingUnitService service) {
		this.service = service;
	}

	/**
	 * @see org.iita.struts.FileDownloadAction#getServerFile(java.lang.String, java.lang.String)
	 */
	@Override
	public ServerFile getServerFile(String subDirectory, String fileName) throws IOException {
		return this.service.getTrainingProgramFile(this.group, subDirectory, fileName);
	}
	
	/**
	 * @see org.iita.struts.FileDownloadAction#remove(java.lang.String, java.lang.String)
	 */
	@Override
	public String remove() throws IOException {
		this.service.removeTrainingProgramFile(this.group, getDirectory(), getFile());
		return "deleted";
	}
	
	/**
	 * @throws FileNotFoundException 
	 * @see org.iita.struts.FilesAction#getRootDirectory()
	 */
	@Override
	protected File getRootDirectory() throws FileNotFoundException {
		return this.service.getTrainingProgramFileDirectory(this.group);
	}
	
	/**
	 * @see org.iita.struts.FilesAction#getFiles(java.lang.String)
	 */
	@Override
	public List<ServerFile> getFiles(String subDirectory) {
		return this.service.getTrainingProgramFiles(this.group, subDirectory);
	}
}
