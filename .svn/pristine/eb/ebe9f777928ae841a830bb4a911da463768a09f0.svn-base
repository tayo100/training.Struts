package org.iita.trainingunit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.iita.crm.model.Person;
import org.iita.entity.VersionedEntity;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.model.TrainingProposal;
import org.iita.trainingunit.iya.model.IYATrainingAnnouncement;

/**
 * Trainer in group training.
 * 
 * @author mobreza
 */
@Entity
public class Trainer extends VersionedEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4860724692402091851L;
	
	/** The trainee. */
	private Trainee trainee;

	/** The group. */
	private TrainingProgram group;
	
	/** The group. */
	private Announcement announcement;
	
	/** The group. */
	private TrainingProposal trainingProposal;
	
	/** The group. */
	private IYATrainingAnnouncement iyaTrainingAnnouncement;
	
	/** The person. */
	private Person person;

	/** The type. */
	private TrainerType type;

	/** The notes. */
	private String notes;
	
	/** The email. */
	private String email;
	
	/** The names. */
	private String names;

	/**
	 * The Enum TrainerType.
	 */
	public enum TrainerType {
		/** Internal, IITA trainer */
		INTERNAL,
		/** External, partner trainer */
		EXTERNAL
	}

	/**
	 * Gets the trainee.
	 * 
	 * @return the trainee
	 */
	@OneToOne(cascade = {}, optional = true)
	public Trainee getTrainee() {
		return trainee;
	}

	/**
	 * Sets the trainee.
	 * 
	 * @param trainee the trainee to set
	 */
	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	/**
	 * Gets the group.
	 * 
	 * @return the group
	 */
	@OneToOne(cascade = {}, optional = true)
	public TrainingProgram getGroup() {
		return group;
	}

	/**
	 * Sets the group.
	 * 
	 * @param group the group to set
	 */
	public void setGroup(TrainingProgram group) {
		this.group = group;
	}
	
	/**
	 * Gets the announcement.
	 * 
	 * @return the announcement
	 */
	@ManyToOne(cascade = {}, optional = true)
	public Announcement getAnnouncement() {
		return announcement;
	}

	/**
	 * Sets the announcement.
	 * 
	 * @param announcement the announcement to set
	 */
	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}
	
	/**
	 * Gets the trainingProposal.
	 * 
	 * @return the trainingProposal
	 */
	@ManyToOne(cascade = {}, optional = true)
	public TrainingProposal getTrainingProposal() {
		return trainingProposal;
	}

	/**
	 * Sets the trainingProposal.
	 * 
	 * @param trainingProposal the trainingProposal to set
	 */
	public void setTrainingProposal(TrainingProposal trainingProposal) {
		this.trainingProposal = trainingProposal;
	}
	
	/**
	 * Gets the iyaTrainingAnnouncement.
	 * 
	 * @return the iyaTrainingAnnouncement
	 */
	@ManyToOne(cascade = {}, optional = true)
	public IYATrainingAnnouncement getIyaTrainingAnnouncement() {
		return iyaTrainingAnnouncement;
	}

	/**
	 * Sets the iyaTrainingAnnouncement.
	 * 
	 * @param iyaTrainingAnnouncement the iyaTrainingAnnouncement to set
	 */
	public void setIyaTrainingAnnouncement(IYATrainingAnnouncement iyaTrainingAnnouncement) {
		this.iyaTrainingAnnouncement = iyaTrainingAnnouncement;
	}
	
	/**
	 * Gets the person.
	 * 
	 * @return the person
	 */
	@ManyToOne(cascade = {}, optional = true)
	public Person getPerson() {
		return person;
	}

	/**
	 * Sets the person.
	 * 
	 * @param person the new person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	@Enumerated(EnumType.STRING)
	public TrainerType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type the new type
	 */
	public void setType(TrainerType type) {
		this.type = type;
	}

	/**
	 * Gets the notes.
	 * 
	 * @return the notes
	 */
	@Lob
	public String getNotes() {
		return notes;
	}

	/**
	 * Sets the notes.
	 * 
	 * @param notes the new notes
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	@Column(length = 100)
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the names.
	 * 
	 * @return the names
	 */
	@Column(length = 255)
	public String getNames() {
		return names;
	}

	/**
	 * Sets the names.
	 * 
	 * @param names the new names
	 */
	public void setNames(String names) {
		this.names = names;
	}
	
	@Transient
	public String getTrainingType(){
		StringBuffer sb = new StringBuffer();
		
		if(trainee != null){
			if(!sb.toString().isEmpty())
				sb.append(", ").append(trainee.getResearchTopic());
			else
				sb.append(trainee.getResearchTopic());
		}else if(group != null){
			if(!sb.toString().isEmpty())
				sb.append(", ").append(group.getTitle());
			else
				sb.append(group.getTitle());
		}else if(announcement != null){
			if(!sb.toString().isEmpty())
				sb.append(", ").append(announcement.getTitle());
			else
				sb.append(announcement.getTitle());
		}else if(trainingProposal != null){
			if(!sb.toString().isEmpty())
				sb.append(", ").append(trainingProposal.getTitle());
			else
				sb.append(trainingProposal.getTitle());
		}
		return sb.toString();
	}
	
}
