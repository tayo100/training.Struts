package org.iita.crm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.iita.entity.VersionedEntity;
import org.iita.security.model.User;
import org.iita.trainingunit.announcements.model.TrainingProposal;
import org.iita.trainingunit.applications.model.Application;


@Entity
public class ActionLog extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private String username;
	private ActionType action;
	private String comment;
	private Date sysDate = new Date();
	private TrainingProposal trainingProposal;
	private Application application;
	//private Announcement announcement;

	/**
	 * Available action types
	 * 
	 * @author KOraegbunam
	 * 
	 */
	public enum ActionType {
		SUBMITTED, APPROVED, REJECTED, AMMEND, CANCELLED, FORWARD;
	}

	/**
	 * User who performed the action
	 * 
	 * @return
	 */
	@Column(length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Enumerated(EnumType.STRING)
	public ActionType getAction() {
		return action;
	}

	public void setAction(ActionType action) {
		this.action = action;
	}

	@Lob
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

	/**
	 * Get the parent TrainingProposal record
	 * 
	 * @see trainingProposal
	 * @return the trainingProposal
	 */
	@ManyToOne(cascade = {}, optional = true)
	public TrainingProposal getTrainingProposal() {
		return this.trainingProposal;
	}

	public void setTrainingProposal(TrainingProposal trainingProposal) {
		this.trainingProposal = trainingProposal;
	}
	
	/**
	 * Get the parent Application record
	 * 
	 * @see application
	 * @return the application
	 */
	@ManyToOne(cascade = {}, optional = true)
	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	/**
	 * Get full reference to user who performed the action
	 * 
	 * @return
	 */
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY, optional = true)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
