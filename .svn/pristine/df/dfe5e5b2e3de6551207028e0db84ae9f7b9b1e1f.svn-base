package org.iita.trainingunit.announcements.service;

import java.io.IOException;
import java.util.List;

import org.iita.security.model.User;
import org.iita.trainingunit.announcements.model.TrainingProposal;
import org.iita.util.PagedResult;

public interface TrainingProposalService {
	void save(TrainingProposal trainingProposal);//, List<TrainingLocation> locations);// throws TrainingProposalException;

	void delete(TrainingProposal trainingProposal);

	PagedResult<TrainingProposal> list(int startAt, int maxResults);

	TrainingProposal find(Long id);
	
	List<TrainingProposal> list();

	PagedResult<TrainingProposal> list(int startAt, int maxResults, User user);

	void convertTrainingProposal(TrainingProposal trainingProposal, String comments) throws IOException;

	void rejectTrainingProposal(TrainingProposal trainingProposal, User user, String comments);

	TrainingProposal createNew(User owner) throws TrainingProposalException;

	TrainingProposal copy(TrainingProposal trainingProposal, User user) throws IOException;
	
}