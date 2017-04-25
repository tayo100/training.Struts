/**
 * 
 */
package org.iita.trainingunit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.iita.entity.VersionedEntity;

/**
 * Contains information on when users need to be alerted of a particular "event" (Trainee status report, Training evaluation). Alert is linked to
 * {@link Trainee} or {@link TrainingProgram}. Depending on the type of alert, email can be automatically sent to Trainee or Trainers of Group training.
 * 
 * @author koraegbunam
 */
@SuppressWarnings("serial")
@Entity
public class Alert extends VersionedEntity {

	/** The trainee. */
	private Trainee trainee;

	/** The group. */
	private TrainingProgram group;

	/** The status. */
	private NotifyStatus status;

	/** The alert date. */
	private Date alertDate;

	/** The subject. */
	private String subject;

	/** The body. */
	private String body;

	/** The type. */
	private AlertType type;

	/**
	 * Notification status.
	 */
	public enum NotifyStatus {
		/** Alert has not been sent. */
		PENDING,
		/** Alert has been sent. */
		SENT
	}

	/**
	 * Alert type.
	 */
	public enum AlertType {
		/** Report type will send a notification email to Trainee or Trainers. */
		REPORT,
		/** Check will alert Training Unit staff. */
		CHECK
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
	 * Gets the status.
	 * 
	 * @return the status
	 */
	@Enumerated(EnumType.STRING)
	public NotifyStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 * 
	 * @param status the status to set
	 */
	public void setStatus(NotifyStatus status) {
		this.status = status;
	}

	/**
	 * Gets the alert date.
	 * 
	 * @return the alertDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date getAlertDate() {
		return alertDate;
	}

	/**
	 * Sets the alert date.
	 * 
	 * @param alertDate the alertDate to set
	 */
	public void setAlertDate(Date alertDate) {
		this.alertDate = alertDate;
	}

	/**
	 * Gets the subject.
	 * 
	 * @return the subject
	 */
	@Column(length = 100)
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.
	 * 
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Gets the body.
	 * 
	 * @return the body
	 */
	@Lob
	public String getBody() {
		return body;
	}

	/**
	 * Sets the body.
	 * 
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	@Enumerated(EnumType.STRING)
	public AlertType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type the type to set
	 */
	public void setType(AlertType type) {
		this.type = type;
	}
}
