package org.iita.trainingunit.service;

import java.util.List;

import org.iita.crm.model.Person;
import org.iita.trainingunit.model.TraineeEducationalInfo;

public interface TraineeEducationalInfoService {

	List<TraineeEducationalInfo> loadEduInfo(Person person);

	void update(TraineeEducationalInfo traineeEducationalInfo);


}
