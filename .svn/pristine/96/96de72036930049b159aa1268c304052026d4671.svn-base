package org.iita.trainingunit.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.search.annotations.ClassBridge;
import org.hibernate.search.annotations.Indexed;
import org.iita.crm.model.EntityTag;
import org.iita.crm.model.Organization;
import org.iita.crm.model.Person;
import org.iita.crm.model.Taggable;
import org.iita.entity.VersionedEntity;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

/**
 * <p>
 * Trainee contains data about individual training (as opposed to group training) and focuses more on the person being trained than the trainers. Individual
 * trainings are usually longer-term (one, two year).
 * </p>
 * <p>
 * Any trainee may have one or more INTERNAL or EXTERNAL supervisors.
 * </p>
 * 
 * @author mobreza
 */
@Entity
@Indexed
@ClassBridge(impl = org.iita.trainingunit.lucene.TraineeBridge.class)
public class Trainee extends VersionedEntity implements Taggable<Trainee> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5495878812293833334L;
	
	/** The person. */
	private Person person;

	/** The research topic. */
	private String researchTopic;

	/** The location. */
	private String location;

	/** The start date. */
	private Date startDate;

	/** The end date. */
	private Date endDate;

	/** The extension date. */
	private Date extensionDate;

	/** The program. */
	private String program;

	/** The discipline. */
	private String discipline;

	/** The country. */
	private String country;

	/** The keywords. */
	private String keywords;

	/** The fundings. */
	private List<Funding> fundings;

	/** The alerts. */
	private List<Alert> alerts;

	/** The university. */
	private Organization university;

	/** The degree the trainee is working on. */
	private String degree;

	/** The degree award date. */
	private Date degreeAwardDate;

	/** The supervisors. */
	private List<Trainer> supervisors;

	/** Tags */
	private List<TraineeTag> tags = new ArrayList<TraineeTag>();
	
	/** The latitude. */
	private Double latitude;
	
	/** The longitude. */
	private Double longitude;
	
	/** The sponsor*/
	private String sponsor;
	
	private List<Hub> hubs = new ArrayList<Hub>();
	private List<Crp> crps = new ArrayList<Crp>();
	private List<CoreCompetency> coreCompetencies = new ArrayList<CoreCompetency>();
	private List<SubProgram> subPrograms = new ArrayList<SubProgram>();
	
	
	/** The alumni */
	
	/**
	 * Gets the person.
	 * 
 	 * @return the person
	 */
	@ManyToOne(cascade = {}, optional = false)
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
	 * Sets the location.
	 * 
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the location.
	 * 
	 * @return the location
	 */
	@Column(length = 200)
	public String getLocation() {
		return location;
	}

	/**
	 * Gets the start date of training
	 * 
	 * @return the start date
	 */
	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date of training
	 * 
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date of training
	 * 
	 * @return the end date
	 */
	@Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 * 
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the supervisors.
	 * 
	 * @return the supervisors
	 */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "trainee")
	// @JoinTable(name = "Trainee_Trainer", joinColumns = { @JoinColumn(name = "Trainee_id") }, inverseJoinColumns = { @JoinColumn(name = "supervisors_id") })
	public List<Trainer> getSupervisors() {
		return supervisors;
	}

	/**
	 * Sets the supervisors.
	 * 
	 * @param supervisors the new supervisors
	 */
	public void setSupervisors(List<Trainer> supervisors) {
		this.supervisors = supervisors;
	}

	/**
	 * Gets the extension date.
	 * 
	 * @return the extension date
	 */
	@Temporal(TemporalType.DATE)
	public Date getExtensionDate() {
		return extensionDate;
	}

	/**
	 * Sets the extension date.
	 * 
	 * @param extensionDate the new extension date
	 */
	public void setExtensionDate(Date extensionDate) {
		this.extensionDate = extensionDate;
	}

	/**
	 * Sets the program.
	 * 
	 * @param program the program to set
	 */
	public void setProgram(String program) {
		this.program = program;
	}

	/**
	 * Gets the program.
	 * 
	 * @return the program
	 */
	@Column(length = 100)
	public String getProgram() {
		return program;
	}

	/**
	 * Sets the discipline.
	 * 
	 * @param discipline the discipline to set
	 */
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	/**
	 * Gets the discipline.
	 * 
	 * @return the discipline
	 */
	@Column(length = 200)
	public String getDiscipline() {
		return discipline;
	}

	/**
	 * Sets the research topic.
	 * 
	 * @param researchTopic the researchTopic to set
	 */
	public void setResearchTopic(String researchTopic) {
		this.researchTopic = researchTopic;
	}

	/**
	 * Gets the research topic.
	 * 
	 * @return the researchTopic
	 */
	@Column(length = 400, nullable = false)
	public String getResearchTopic() {
		return researchTopic;
	}

	/**
	 * Gets the degree.
	 * 
	 * @return the degree
	 */
	@Column(length = 50)
	public String getDegree() {
		return this.degree;
	}

	/**
	 * Sets the degree.
	 * 
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * Gets the degree award date.
	 * 
	 * @return the degreeAwardDate
	 */
	@Temporal(TemporalType.DATE)
	public Date getDegreeAwardDate() {
		return this.degreeAwardDate;
	}

	/**
	 * Sets the degree award date.
	 * 
	 * @param degreeAwardDate the degreeAwardDate to set
	 */
	public void setDegreeAwardDate(Date degreeAwardDate) {
		this.degreeAwardDate = degreeAwardDate;
	}

	/**
	 * Gets the university.
	 * 
	 * @return the university
	 */
	@ManyToOne(cascade = {})
	public Organization getUniversity() {
		return this.university;
	}

	/**
	 * Sets the university.
	 * 
	 * @param university the university to set
	 */
	@TypeConversion(converter = "genericConverter")
	public void setUniversity(Organization university) {
		this.university = university;
	}

	/**
	 * Is this trainee status expired?.
	 * 
	 * @return true, if checks if is expired
	 */
	@Transient
	public boolean isExpired() {
		if (this.extensionDate != null)
			return this.extensionDate.before(new Date());
		if (this.endDate == null)
			return false;
		return this.endDate.before(new Date());
	}
	
	/**
	 * Is this trainee suppose to receive alert?.
	 * 
	 * @return true, then it should sendAlert
	 */
	@Transient
	public boolean sendAlert() {
		if (this.extensionDate != null){
			long diff = this.extensionDate.getTime() - this.startDate.getTime();
			if((diff / (1000 * 60 * 60 * 24))>=365)
				return true;
			else
				return false;
		}
		
		if (this.endDate != null){
			long diff = this.endDate.getTime() - this.startDate.getTime();
			if((diff / (1000 * 60 * 60 * 24))>=365)
				return true;
			else
				return false;
		}
		
		if(this.extensionDate == null && this.endDate == null)
			return true;
		else
			return false;
	}

	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	@Column(length = 50)
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 * 
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the keywords.
	 * 
	 * @return the keywords
	 */
	@Lob
	public String getKeywords() {
		return keywords;
	}

	/**
	 * Sets the keywords.
	 * 
	 * @param keywords the new keywords
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * Gets the fundings.
	 * 
	 * @return the fundings
	 */
	@OneToMany(cascade = { CascadeType.ALL })
	public List<Funding> getFundings() {
		return fundings;
	}

	/**
	 * Sets the fundings.
	 * 
	 * @param fundings the new fundings
	 */
	public void setFundings(List<Funding> fundings) {
		this.fundings = fundings;
	}

	/**
	 * Sets the alerts.
	 * 
	 * @param alert the new alerts
	 */
	public void setAlerts(List<Alert> alert) {
		this.alerts = alert;
	}

	/**
	 * Gets the alerts.
	 * 
	 * @return the alerts
	 */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "trainee")
	@OrderBy("alertDate")
	public List<Alert> getAlerts() {
		return alerts;
	}

	/**
	 * @return the tags
	 */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "entity")
	public List<TraineeTag> getTags() {
		return this.tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<TraineeTag> tags) {
		this.tags = tags;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * @see org.iita.crm.model.Taggable#createTag()
	 */
	@Override
	public EntityTag<Trainee> createTag() {
		return new TraineeTag();
	}
	
	/**
	 * @see org.iita.crm.model.Taggable#getTagClass()
	 */
	@Override
	@Transient
	public Class<? extends EntityTag<Trainee>> getTagClass() {
		return TraineeTag.class;
	}

	/**
	 * @param sponsor the sponsor to set
	 */
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	/**
	 * @return the sponsor
	 */
	public String getSponsor() {
		return sponsor;
	}
	
	/**
	 * Gets the hubs.
	 * 
	 * @return the hubs
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee")
	public List<Hub> getHubs() {
		return this.hubs;
	}

	/**
	 * Sets the hubs.
	 * 
	 * @param hubs the hubs to set
	 */
	public void setHubs(List<Hub> hubs) {
		this.hubs = hubs;
	}
	
	/**
	 * Gets the crps.
	 * 
	 * @return the crps
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee")
	public List<Crp> getCrps() {
		return this.crps;
	}

	/**
	 * Sets the crps.
	 * 
	 * @param crps the crps to set
	 */
	public void setCrps(List<Crp> crps) {
		this.crps = crps;
	}
	
	/**
	 * Gets the coreCompetencies.
	 * 
	 * @return the coreCompetencies
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee")
	public List<CoreCompetency> getCoreCompetencies() {
		return this.coreCompetencies;
	}

	/**
	 * Sets the coreCompetencies.
	 * 
	 * @param coreCompetencies the coreCompetencies to set
	 */
	public void setCoreCompetencies(List<CoreCompetency> coreCompetencies) {
		this.coreCompetencies = coreCompetencies;
	}
	
	/**
	 * Gets the subPrograms.
	 * 
	 * @return the subPrograms
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee")
	public List<SubProgram> getSubPrograms() {
		return this.subPrograms;
	}

	/**
	 * Sets the subPrograms.
	 * 
	 * @param subPrograms the subPrograms to set
	 */
	public void setSubPrograms(List<SubProgram> subPrograms) {
		this.subPrograms = subPrograms;
	}
	
	
	@Transient
	public String getCostCenters(){
		StringBuffer sb = new StringBuffer();
		
		for (Funding funding : this.fundings) {
			if(funding != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(funding.getCostCenter());
				else
					sb.append(funding.getCostCenter());
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getUnivSupervisors(){
		StringBuffer sb = new StringBuffer();
		
		for (Trainer trainer : this.supervisors) {
			if(trainer.getType()==Trainer.TrainerType.EXTERNAL){
				if(trainer != null){
					if(!sb.toString().isEmpty())
						sb.append(", ").append(trainer.getPerson().getFullName());
					else
						sb.append(trainer.getPerson().getFullName());
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getIitaSupervisors(){
		StringBuffer sb = new StringBuffer();
		
		for (Trainer trainer : this.supervisors) {
			if(trainer.getType()==Trainer.TrainerType.INTERNAL){
				if(trainer != null){
					if(!sb.toString().isEmpty())
						sb.append(", ").append(trainer.getPerson().getFullName());
					else
						sb.append(trainer.getPerson().getFullName());
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getExportHubs(){
		StringBuffer sb = new StringBuffer();
		
		for (Hub hub : this.hubs) {
			if(hub != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(hub.getName());
				else
					sb.append(hub.getName());
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getExportCrps(){
		StringBuffer sb = new StringBuffer();
		
		for (Crp crp : this.crps) {
			if(crp != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(crp.getName());
				else
					sb.append(crp.getName());
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getExportCoreCompetencies(){
		StringBuffer sb = new StringBuffer();
		
		for (CoreCompetency core : this.coreCompetencies) {
			if(core != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(core.getName());
				else
					sb.append(core.getName());
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getExportSubPrograms(){
		StringBuffer sb = new StringBuffer();
		
		for (SubProgram sub : this.subPrograms) {
			if(sub != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(sub.getName());
				else
					sb.append(sub.getName());
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getUnivSupervisorsEmail(){
		StringBuffer sb = new StringBuffer();
		
		for (Trainer trainer : this.supervisors) {
			if(trainer.getType()==Trainer.TrainerType.EXTERNAL){
				if(trainer != null){
					if(!sb.toString().isEmpty())
						sb.append(", ").append(trainer.getPerson().getLastEmail().getEmail());
					else
						sb.append(trainer.getPerson().getLastEmail().getEmail());
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * Get duration of training
	 */
	@Transient
	public String getDuration() {
		if (this.extensionDate != null && startDate != null) {
			Period period = new Period(startDate.getTime(), extensionDate.getTime(), PeriodType.days());
			int years = period.getYears();
			int months = period.getMonths();
			int weeks = period.getWeeks();
			int days = period.getDays();
			
			if (years > 0)
				return years + (years == 1 ? " year" : " years");
			else if (months > 0)
				return months + (months == 1 ? " month" : " months");
			else if (weeks > 0)
				return weeks + (weeks == 1 ? " week" : " weeks");
			else if (days > 0)
				return days + (days == 1 ? " day" : " days");
			else {
				int hours = period.getHours();
				return hours + (hours == 1 ? " hour" : " hours");
			}
		} else if(this.endDate != null && startDate != null){
			Period period = new Period(startDate.getTime(), endDate.getTime(), PeriodType.days());
			int years = period.getYears();
			int months = period.getMonths();
			int weeks = period.getWeeks();
			int days = period.getDays()+1;
			
			if (years > 0)
				return years + (years == 1 ? " year" : " years");
			else if (months > 0)
				return months + (months == 1 ? " month" : " months");
			else if (weeks > 0)
				return weeks + (weeks == 1 ? " week" : " weeks");
			else if (days > 0)
				return days + (days == 1 ? " day" : " days");
			else {
				int hours = period.getHours();
				return hours + (hours == 1 ? " hour" : " hours");
			}
		} else
			return "N/A";
	}
}
