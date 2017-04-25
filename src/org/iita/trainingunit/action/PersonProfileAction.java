package org.iita.trainingunit.action;

import java.util.List;

import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.model.TrainingProposal;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.service.AlumniService;
import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;

@SuppressWarnings("serial")
public class PersonProfileAction extends org.iita.crm.action.PersonProfileAction {
	private TrainingUnitService service;
	private List<Trainee> trainees;
	private List<Trainee> supervisions;
	private List<TrainingProposal> trainingProposalResourcing;
	private List<Announcement> announcementResourcing;
	private List<TrainingProgram> trainings;

	public PersonProfileAction(TrainingUnitService trainingUnitService, AlumniService alumniService) {
		super(trainingUnitService, alumniService);
		this.service = trainingUnitService;
	}

	/**
	 * @return the trainees
	 */
	public List<Trainee> getTrainees() {
		return this.trainees;
	}

	/**
	 * @return the supervisions
	 */
	public List<Trainee> getSupervisions() {
		return this.supervisions;
	}
	
	/**
	 * @return the supervisions
	 */
	public List<TrainingProposal> getTrainingProposalResourcing() {
		return this.trainingProposalResourcing;
	}
	
	/**
	 * @return the supervisions
	 */
	public List<Announcement> getAnnouncementResourcing() {
		return this.announcementResourcing;
	}
	
	/**
	 * @return the trainings
	 */
	public List<TrainingProgram> getTrainings() {
		return this.trainings;
	}
	
	@Override
	public String execute() {
		super.execute();
		this.trainees = this.service.listTrainees(this.person);
		this.supervisions = this.service.listSupervisions(this.person);
		this.trainingProposalResourcing = this.service.listTrainingProposalTrainers(this.person);
		this.announcementResourcing = this.service.listAnnouncementTrainers(this.person);
		
		this.trainings=this.service.listTrainingPrograms(this.person);
		return Action.SUCCESS;
	}
}
