/**
 * 
 */
package org.iita.trainingunit.applications.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;

/**
 * @author ken
 *
 */
@Entity
public class OtherStudiesAndTraining extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int year;
	private int duration;	
	private String place;
	private String topic;
	private ApplicantsBioData biodata;
	
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	/**
	 * @return the place
	 */
	@Column(length = 255)
	public String getPlace() {
		return place;
	}
	
	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	
	/**
	 * @return the topic
	 */
	@Column(length = 400)
	public String getTopic() {
		return topic;
	}
	
	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	/**
	 * Get the parent biodata record
	 * 
	 * @see biodata
	 * @return the biodata
	 */
	@ManyToOne(cascade = {}, optional = false)
	public ApplicantsBioData getBiodata() {
		return this.biodata;
	}

	public void setBiodata(ApplicantsBioData biodata) {
		this.biodata = biodata;
	}
}
