package org.iita.trainingunit.iya.service;

import java.util.List;

import org.iita.service.SearchException;
import org.iita.trainingunit.iya.model.ClassInteraction.InteractionType;
import org.iita.trainingunit.iya.model.IYAAnnouncementObjective;
import org.iita.trainingunit.iya.model.IYAEvaluation;
import org.iita.trainingunit.iya.model.IYARegistration;
import org.iita.trainingunit.iya.model.IYATrainingAnnouncement;
import org.iita.util.PagedResult;

public interface IyaService {

	PagedResult<IYARegistration> iyaRegistrations(int startAt, int maxResults);
	PagedResult<IYATrainingAnnouncement> iyaTrainingAnnoucements(int startAt, int maxResults);
	PagedResult<IYAEvaluation> iyaEvaluations(int startAt, int maxResults);
	
	
	IYATrainingAnnouncement saveAnnouncement(IYATrainingAnnouncement announcement);
	IYATrainingAnnouncement updateAnnouncement(IYATrainingAnnouncement announcement);
	IYATrainingAnnouncement loadAnnouncement(long id);
	List<IYATrainingAnnouncement> autocompleteIyaAnnouncement(String text, int i) throws SearchException;
	List<IYATrainingAnnouncement> iyaAnnoucements();
	
	
	IYARegistration loadRegistration(long id);
	IYARegistration saveRegistration(IYARegistration registration);
	List<IYARegistration> iyaRegistrations();	
	IYARegistration updateRegistration(IYARegistration iyaRegistration);
	
	
	IYAEvaluation loadEvaluation(Long id);
	
	List<IYAEvaluation> iyaEvaluations();
	String[] getSelectedObjectives(IYAEvaluation iyaEvaluation);
	List<IYAAnnouncementObjective> iyaAnnouncementObjectives();
	List<IYAAnnouncementObjective> getObjectives(IYATrainingAnnouncement iyaAnnouncement);
	void ensureRemoved(Object objectToRemove);
	void removeAnnouncementItems(IYATrainingAnnouncement ann);
	IYAEvaluation saveEvaluation(IYAEvaluation evaluation);	
}
