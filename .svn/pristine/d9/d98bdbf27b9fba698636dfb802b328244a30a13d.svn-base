/**
 * training.Struts Feb 5, 2010
 */
package org.iita.trainingunit.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.iita.crm.model.Person;
import org.iita.security.model.User;
import org.iita.struts.webfile.ServerFile;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.util.PagedResult;

/**
 * @author mobreza
 * 
 */
public interface TrainingProgramService {

	/**
	 * @param title
	 * @return
	 */
	TrainingProgram registerTrainingProgram(String title);

	/**
	 * @param id
	 * @return
	 */
	TrainingProgram loadTrainingProgram(Long id);

	/**
	 * @param profile
	 */
	void update(TrainingProgram program, String[] selectedCrps, String[] selectedHubs, String[] selectedCoreCompetencies, String[] selectedSubPrograms);

	/**
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 */
	List<TrainingProgram> listTrainingPrograms(Calendar dateFrom, Calendar dateTo);
	
	/**
	 * @param user
	 * @param dateFrom
	 * * @param dateTo
	 * @return
	 */
	List<TrainingProgram> listTrainingPrograms(User user, Calendar dateFrom, Calendar dateTo);

	/**
	 * List Training Programs where the <code>person</code> is a trainer.
	 * 
	 * @param person
	 * @return
	 */
	List<TrainingProgram> listTrainingPrograms(Person person);

	/**
	 * Get the list of all trainingProgram files
	 * 
	 * @param profile
	 * @return
	 */
	List<ServerFile> getTrainingProgramFiles(TrainingProgram trainingProgram, String subDirectory);

	/**
	 * Get reference to trainingProgram file
	 * 
	 * @param trainingProgram
	 * @param downloadDirectory
	 * @param downloadFileName
	 * @return
	 * @throws IOException
	 */
	ServerFile getTrainingProgramFile(TrainingProgram trainingProgram, String directory, String downloadFileName) throws IOException;

	/**
	 * @param trainingProgram
	 * @return
	 * @throws FileNotFoundException
	 */
	File getTrainingProgramFileDirectory(TrainingProgram trainingProgram) throws FileNotFoundException;
	
	void removeGroupTraining(TrainingProgram group);

	PagedResult<TrainingProgram> getTrainingProgramsExportList(int exportyear);
	PagedResult<TrainingProgram> getUserTrainingProgramsExportList(User user, int exportyear);
	
	void removeAttendance(TrainingProgram group);

	void updateAllTrainingProgramFiles();
}
