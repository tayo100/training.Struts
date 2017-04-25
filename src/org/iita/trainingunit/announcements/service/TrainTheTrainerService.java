package org.iita.trainingunit.announcements.service;

import java.util.List;

import org.iita.trainingunit.announcements.model.TrainTheTrainer;
import org.iita.util.PagedResult;

public interface TrainTheTrainerService {
	void save(TrainTheTrainer trainTheTrainer);

	void delete(TrainTheTrainer trainTheTrainer);

	PagedResult<TrainTheTrainer> list(int startAt, int maxResults);

	TrainTheTrainer find(Long id);
	
	List<TrainTheTrainer> list();
}