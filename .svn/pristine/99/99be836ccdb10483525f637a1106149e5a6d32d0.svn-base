package org.iita.trainingunit.action;

import org.iita.crm.model.Person;
import org.iita.struts.BaseAction;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.model.TrainingProposal;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.Trainer;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.model.Trainer.TrainerType;
import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;

@SuppressWarnings("serial")
public class TrainerAction extends BaseAction {
	private TrainingUnitService service;
	private Person person;
	private Long personId;
	private String personName;
	private Long traineeId;
	private Long programId;
	private TrainerType type;
	private String notes;
	private Trainer trainer;
	private Trainee trainee;
	private TrainingProgram trainingProgram;
	private Long trainerId;
	
	private TrainingProposal trainingProposal;
	private Long trainingProposalId;
	
	private Announcement announcement;
	private Long announcementId;

	public TrainerAction(TrainingUnitService trainingUnitService) {
		this.service = trainingUnitService;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * @param traineeId the traineeId to set
	 */
	public void setTraineeId(Long traineeId) {
		this.traineeId = traineeId;
	}
	
	/**
	 * @param programId the programId to set
	 */
	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TrainerType type) {
		this.type = type;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Trainer getTrainer() {
		return trainer;
	}
	
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	/**
	 * @return the trainee
	 */
	public Trainee getTrainee() {
		return this.trainee;
	}
	
	/**
	 * @return the trainingProgram
	 */
	public TrainingProgram getTrainingProgram() {
		return this.trainingProgram;
	}
	
	/**
	 * @param trainerId the trainerId to set
	 */
	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}
	
	/**
	 * @return the trainingProposal
	 */
	public TrainingProposal getTrainingProposal() {
		return this.trainingProposal;
	}
	
	/**
	 * @param trainingProposalId the trainingProposalId to set
	 */
	public void setTrainingProposalId(Long trainingProposalId) {
		this.trainingProposalId = trainingProposalId;
	}
	
	/**
	 * @return the announcement
	 */
	public Announcement getAnnouncement() {
		return this.announcement;
	}
	
	/**
	 * @param announcementId the announcementId to set
	 */
	public void setAnnouncementId(Long announcementId) {
		this.announcementId = announcementId;
	}

	public String execute() {
		String resultType = Action.SUCCESS;

		this.trainer = new Trainer();
		if (this.personId != null)
			this.person = this.service.loadPerson(personId);
		else
			this.person = this.service.createPerson(this.personName);

		trainer.setPerson(this.person);
		trainer.setNotes(notes);
		trainer.setType(type);

		// attach to trainee
		if (this.traineeId != null) {
			
			this.trainee = this.service.loadTrainee(this.traineeId);
			
			if (trainee != null) {
				trainer.setTrainee(trainee);
			}
			//Mail Notification to added trainer
			/*String sender = "Software Support<software.support@iita.org>";
			String recipient = ((EmailContact) this.trainer.getPerson().getLastEmail()).getEmail();
			String subject = "Supervisor to " + this.trainee.getResearchTopic();
			String body = "Dear " + this.trainer.getPerson().getFullName() + ", ";
			body += "\n\nYou have been selected as one of the supervisors of " + this.trainee.getPerson().getFullName() + " for research topic: " + this.trainee.getResearchTopic();
			body += "\n\nThank you";
			try{
				if(recipient!=null)
					this.emailService.sendEmail(sender, recipient, subject, body);
			}
			catch (EmailException e){
				LOG.debug(e.getMessage());
			}*/
			
			resultType = "trainee";
		}
		
		// attach trainer to training program
		if (this.programId!=null) {
			
			this.trainingProgram = this.service.loadTrainingProgram(this.programId);
			
			if (trainingProgram != null) {
				trainer.setGroup(trainingProgram);
			}
			
			//Mail Notification to added trainer
			/*String sender = "software.support@iita.org";
			String recipient = ((EmailContact) this.trainer.getPerson().getLastEmail()).getEmail();
			String subject = "Supervisor to " + this.trainingProgram.getTitle();
			String body = "Dear " + this.trainer.getPerson().getFullName() + ", ";
			body += "\n\nYou have been selected as one of the trainers of " + this.trainingProgram.getTitle();
			body += "\n\nThank you";
			try{
				if(recipient!=null)
					this.emailService.sendEmail(sender, recipient, subject, body);
			}
			catch (EmailException e){
				LOG.debug(e.getMessage());
			}*/
			
			resultType="program";
		}
		
		// attach trainer to training proposal
		if (this.trainingProposalId!=null) {
			
			this.trainingProposal = this.service.loadTrainingProposal(this.trainingProposalId);
			
			if (trainingProposal != null) {
				trainer.setTrainingProposal(this.trainingProposal);
			}
			resultType="trainingproposal";
		}
		
		// attach trainer to announcement
		if (this.announcementId!=null) {
			
			this.announcement = this.service.loadAnnouncement(this.announcementId);
			
			if (announcement != null) {
				trainer.setAnnouncement(this.announcement);
			}
			resultType="announcement";
		}

		this.service.registerTrainer(trainer);

		return resultType;
	}
	
	public String removeSupervisor(){
		String resultType = "unknown";
		
		if (this.trainerId != null)
			this.trainer = this.service.loadTrainer(this.trainerId);
		
		// remove supervisor from trainee training
		if (this.traineeId != null && this.trainerId != null) {
			this.trainee = this.service.loadTrainee(this.traineeId);
			this.service.removeSupervisor(this.trainer);
			
			resultType = "trainee";
		}
		
		// remove trainer from group training
		if (this.programId!=null && this.trainerId != null) {
			this.trainingProgram = this.service.loadTrainingProgram(this.programId);
			this.service.removeSupervisor(this.trainer);
			
			resultType="program";
		}
		
		// remove trainer from training proposal
		if (this.trainingProposalId!=null && this.trainerId != null) {
			this.trainingProposal = this.service.loadTrainingProposal(this.trainingProposalId);
			this.service.removeSupervisor(this.trainer);
			
			resultType="trainingproposal";
		}
		
		// remove trainer from announcement
		if (this.announcementId!=null && this.trainerId != null) {
			this.announcement = this.service.loadAnnouncement(this.announcementId);
			this.service.removeSupervisor(this.trainer);
			
			resultType="announcement";
		}
		
		return resultType;
	}
	
	public String update() {
		String resultType = "unknown";
		
		if(this.trainerId!=null){
			this.trainer = this.service.loadTrainer(trainerId);
			
			if (this.personId != null){
				this.person = this.service.loadPerson(personId);
	
				trainer.setPerson(this.person);
			}
			
			trainer.setNotes(notes);
			trainer.setType(type);
	
			// attach to trainee
			if (this.traineeId != null) {
				this.trainee = this.service.loadTrainee(this.traineeId);
				if (trainee != null) {
					trainer.setTrainee(this.trainee);
				}
				resultType = "trainee";
			}
			
			// attach trainer to training program
			if (this.programId!=null) {
				this.trainingProgram = this.service.loadTrainingProgram(this.programId);
				if (trainingProgram != null) {
					trainer.setGroup(trainingProgram);
				}
				resultType="program";
			}
			
			// attach to trainingproposal
			if (this.trainingProposalId != null) {
				this.trainingProposal = this.service.loadTrainingProposal(this.trainingProposalId);
				if (trainingProposal != null) {
					trainer.setTrainingProposal(this.trainingProposal);
				}
				resultType = "trainingproposal";
			}
			
			// attach to announcement
			if (this.announcementId != null) {
				this.announcement = this.service.loadAnnouncement(this.announcementId);
				if (announcement != null) {
					trainer.setAnnouncement(this.announcement);
				}
				resultType = "announcement";
			}
	
			this.service.updateTrainer(trainer);
		}
		return resultType;		
	}
}
