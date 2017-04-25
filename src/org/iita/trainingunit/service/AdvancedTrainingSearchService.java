package org.iita.trainingunit.service;

import java.util.Date;
import java.util.List;

import org.iita.crm.model.Organization;
import org.iita.security.model.User;
import org.iita.trainingunit.announcements.model.TrainingProposal;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.Trainer;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.util.PagedResult;

public interface AdvancedTrainingSearchService {
	PagedResult<Trainee> searchTrainee(String sDate, String eDate, String operands, String origin, String text, Date startDate, Date endDate,
			int startAt, int maxResults, boolean fullText, String type, String[] selectedCrps, String[] selectedHubs, String[] selectedCoreCompetencies, String[] selectedTrainers, String[] selectedSponsors, String loc, boolean groupYearly, String cc) throws AdvancedTrainingSearchException;

	PagedResult<TrainingProgram> searchPrograms(String sDate, String eDate, String operands, String loc, String text, Date startDate, Date endDate,
			int startAt, int maxResults, boolean fullText, String[] selectedCrps, String[] selectedHubs, String[] selectedCoreCompetencies, String[] selectedTrainers, String[] selectedSponsors, boolean groupYearly, String cc) throws AdvancedTrainingSearchException;

	PagedResult<Organization> searchOrg(String sDate, String eDate, String operands, String loc, String text, Date startDate, Date endDate, int startAt,
			int maxResults, boolean fullText) throws AdvancedTrainingSearchException;

	PagedResult<Trainer> searchTrainer(String sDate, String eDate, String operands, String origin, String text, Date startDate, Date endDate, int startAt,
			int maxResults, boolean fullText, String loc) throws AdvancedTrainingSearchException;

	List<Trainer> searchTrainer(String sDate, String eDate, String operands, String origin, String text, Date startDate, Date endDate, boolean fullText, String loc)
			throws AdvancedTrainingSearchException;

	List<Organization> searchOrg(String sDate, String eDate, String operands, String loc, String text, Date startDate, Date endDate, boolean fullText)
			throws AdvancedTrainingSearchException;

	List<Trainee> searchTrainee(String sDate, String eDate, String operands, String origin, String text, Date startDate, Date endDate,
			boolean fullText, String type, String[] selectedCrps, String[] selectedHubs, String[] selectedCoreCompetencies, String[] selectedTrainers, String[] selectedSponsors, String loc, boolean groupYearly, String cc) throws AdvancedTrainingSearchException;

	List<TrainingProgram> searchPrograms(String sDate, String eDate, String operands, String loc, String text, Date startDate, Date endDate, boolean fullText, 
			String[] selectedCrps, String[] selectedHubs, String[] selectedCoreCompetencies, String[] selectedTrainers, String[] selectedSponsors, boolean groupYearly, String cc)
			throws AdvancedTrainingSearchException;
	
	List<String> getTraineeTypes();

	List<String> getGroupTypes();
	
	List<TrainingProposal> searchTrainingProposal(String sDate, String eDate, String operands, String loc, String text, Date startDate, Date endDate, boolean fullText, String type, boolean groupYearly, String cc)
	throws AdvancedTrainingSearchException;
	
	PagedResult<TrainingProposal> searchTrainingProposal(String sDate, String eDate, String operands, String loc, String text, Date startDate, Date endDate,
			int startAt, int maxResults, boolean fullText, String type, boolean groupYearly, String cc) throws AdvancedTrainingSearchException;

	PagedResult<Trainee> searchTrainee(User user, int year, int startAt, int maxResults);

	PagedResult<TrainingProgram> searchPrograms(User user, int year, int startAt, int maxResults);
}