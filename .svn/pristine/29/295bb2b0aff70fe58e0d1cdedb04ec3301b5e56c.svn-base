package org.iita.trainingunit.service;

import org.iita.crm.model.Organization;
import org.iita.trainingunit.model.Funding;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.TrainingProgram;

public interface FundingService {
	
	/*
	 * registration of funding for trainee and group training use
	 * */
	void registerFunding(Funding funding);
	
	/*
	 * registration of funding for trainee and group training use
	 * */
	Funding registerAlumniFunding(Funding funding);
	
	/*
	 * remove of funding for trainee training use
	 * */
	void removeTraineeFunding(Trainee trainee, Funding funding);
	
	/*
	 * remove of funding for group training use
	 * */
	void removeProgramFunding(TrainingProgram trainingProgram, Funding funding);
	
	/*
	 * load of funding for trainee and group training use
	 * */
	Funding loadFunding(Long id);
	
	Funding lookupFunding(String costCenter, Organization org);
	
	/*
	 * updating of funding for trainee and group training use
	 * */
	void updateFunding(Funding funding);
}
