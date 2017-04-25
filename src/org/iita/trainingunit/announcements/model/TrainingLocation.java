/**
 * 
 */
package org.iita.trainingunit.announcements.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.iita.entity.VersionedEntity;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.iya.model.IYATrainingAnnouncement;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 * @author ken
 *
 */
@Entity
public class TrainingLocation extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String country;
	private String venue;
	private Date startDate;
	private Date endDate;
	private Announcement announcement;
	private TrainingProposal trainingProposal;
	private IYATrainingAnnouncement iyaTrainingAnnouncement;
	private Application application;
	
	public void setCountry(String country) {
		this.country = country;
	}

	@Column(length = 100)
	public String getCountry() {
		return country;
	}
	
	public void setVenue(String venue) {
		this.venue = venue;
	}

	@Column(length = 255)
	public String getVenue() {
		return venue;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	
	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	@OneToOne(cascade = {}, optional = true, fetch = FetchType.LAZY)
	public Announcement getAnnouncement() {
		return announcement;
	}
	
	public void setApplication(Application application) {
		this.application = application;
	}

	@ManyToOne(cascade = {}, optional = true)
	public Application getApplication() {
		return application;
	}
	
	public void setTrainingProposal(TrainingProposal trainingProposal) {
		this.trainingProposal = trainingProposal;
	}

	@ManyToOne(cascade = {CascadeType.ALL}, optional = true, fetch = FetchType.LAZY)
	public TrainingProposal getTrainingProposal() {
		return trainingProposal;
	}
	
	public void setIyaTrainingAnnouncement(IYATrainingAnnouncement iyaTrainingAnnouncement) {
		this.iyaTrainingAnnouncement = iyaTrainingAnnouncement;
	}

	@ManyToOne(cascade = {}, optional = true)
	public IYATrainingAnnouncement getIyaTrainingAnnouncement() {
		return iyaTrainingAnnouncement;
	}
	
	/**
	 * Get duration of travel
	 */
	@Transient
	public String getDuration() {
		if (endDate != null && startDate != null) {
			Period period = new Period(startDate.getTime(), endDate.getTime(), PeriodType.days());
			int days = period.getDays()+1;
			if (days > 0)
				return days + (days == 1 ? " day" : " days");
			else {
				int hours = period.getHours();
				return hours + (hours == 1 ? " hour" : " hours");
			}
		} else
			return "N/A";
	}
}
