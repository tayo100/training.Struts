/**
 * trainingunit.Struts Feb 1, 2010
 */
package org.iita.trainingunit.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.service.TrainingUnitService;
import org.iita.struts.FilesAction;
import org.iita.struts.webfile.ServerFile;

/**
 * @author koraegbunam
 * 
 */
@SuppressWarnings("serial")
public class TraineeFilesAction extends FilesAction {
	private TrainingUnitService service;
	private Trainee trainee;

	@Override
	public void setId(Long id) {
		this.trainee = this.service.loadTrainee(id);
	}

	/**
	 * Get ID
	 * 
	 * @return the ID
	 */
	@Override
	public Long getId() {		
		return this.trainee == null ? null : this.trainee.getId();
	}
	
	@Override
	public String getBrowserTitle() {
		return this.trainee == null ? null : this.trainee.getPerson().getLegalName();
	}
	
	public Trainee getTrainee() {
		return this.trainee;
	}

	/**
	 * @param service
	 * 
	 */
	public TraineeFilesAction(TrainingUnitService service) {
		this.service = service;
	}

	/**
	 * @see org.iita.struts.FileDownloadAction#getServerFile(java.lang.String, java.lang.String)
	 */
	@Override
	public ServerFile getServerFile(String subDirectory, String fileName) throws IOException {
		return this.service.getTraineeFile(this.trainee, subDirectory, fileName);
	}
	/**
	 * @throws FileNotFoundException 
	 * @see org.iita.struts.FilesAction#getRootDirectory()
	 */
	@Override
	protected File getRootDirectory() throws FileNotFoundException {
		return this.service.getTraineeFileDirectory(this.trainee);
	}
	
	/**
	 * @see org.iita.struts.FilesAction#getFiles(java.lang.String)
	 */
	@Override
	public List<ServerFile> getFiles(String subDirectory) {
		return this.service.getTraineeFiles(this.trainee, subDirectory);
	}

	/**
	 * @see org.iita.struts.FileDownloadAction#remove(java.lang.String, java.lang.String)
	 */
	@Override
	public String remove() throws IOException {
		this.service.removeTraineeFile(this.trainee, getDirectory(), getFile());
		return "deleted";
	}
}
