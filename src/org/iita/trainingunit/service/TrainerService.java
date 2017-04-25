/**
 * training.Struts Feb 4, 2010
 */
package org.iita.trainingunit.service;

import java.util.List;

import org.iita.crm.model.Person;
import org.iita.trainingunit.model.Trainer;

/**
 * @author mobreza
 * 
 */
public interface TrainerService {

	/**
	 * @param trainer
	 */
	void registerTrainer(Trainer trainer);
	
	Trainer loadTrainer(Long trainerId);

	/**
	 * @param person
	 * @return
	 */
	List<Trainer> listTrainers(Person person);
	
	void updateTrainer(Trainer trainer);
}
