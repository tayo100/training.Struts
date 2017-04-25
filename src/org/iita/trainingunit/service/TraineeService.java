package org.iita.trainingunit.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.iita.crm.model.Organization;
import org.iita.crm.model.Person;
import org.iita.security.model.User;
import org.iita.struts.webfile.ServerFile;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.Trainer;
import org.iita.util.PagedResult;

public interface TraineeService {

	void registerTrainee(Trainee trainee);
	
	Trainee registerAlumniTrainee(Trainee trainee);

	/**
	 * Load trainee by ID
	 * 
	 * @param id
	 * @return
	 */
	Trainee loadTrainee(Long id);

	/**
	 * @param person
	 * @return
	 */
	List<Trainee> listTrainees(Person person);

	/**
	 * @param trainee
	 * @return
	 */
	List<Trainer> loadTrainers(Trainee trainee);

	void update(Trainee trainee, String[] selectedCrps, String[] selectedHubs, String[] selectedCoreCompetencies, String[] selectedSubPrograms);

	/**
	 * List all {@link Trainee} records where this person in a supervisor
	 * 
	 * @param person
	 * @return
	 */
	List<Trainee> listSupervisions(Person person);

	/**
	 * List active trainees in a time period
	 * 
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 */
	List<Trainee> listTrainees(Calendar dateFrom, Calendar dateTo);
	
	/**
	 * List active trainees in a time period
	 * 
	 * @param user
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 */
	List<Trainee> listTrainees(User user, Calendar dateFrom, Calendar dateTo);

	/**
	 * Get the list of all trainee files
	 * 
	 * @param profile
	 * @return
	 */
	List<ServerFile> getTraineeFiles(Trainee trainee, String subDirectory);

	/**
	 * Get reference to trainee file
	 * 
	 * @param trainee
	 * @param downloadDirectory
	 * @param downloadFileName
	 * @return
	 * @throws IOException
	 */
	ServerFile getTraineeFile(Trainee trainee, String directory, String downloadFileName) throws IOException;

	/**
	 * @param trainee
	 * @return
	 * @throws FileNotFoundException
	 */
	File getTraineeFileDirectory(Trainee trainee) throws FileNotFoundException;
	
	void removeTrainee(Trainee trainee);
	

	List<Trainee> listTrainees(Organization organization);

	PagedResult<Trainee> getTraineesExportList(int exportyear);
	PagedResult<Trainee> getUserTraineesExportList(User user, int exportyear);

	void removeSupervisor(Trainer trainer);
}
