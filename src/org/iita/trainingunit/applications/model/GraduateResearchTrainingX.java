package org.iita.trainingunit.applications.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.iita.crm.model.ApplicationTag;
import org.iita.crm.model.EntityTag;
import org.iita.security.model.User;


//@Entity
//@Indexed
public class GraduateResearchTrainingX extends Application {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5981417998275512404L;
	private DEGREE degree;
	private String presentUniversity;
	private DEGREE degreeSought;
	private String proposedResearchTheme;
	
	private String nameOfUniversitySupervisor;
	private String emailOfUniversitySupervisor;
	private String nameOfIITASupervisor;
	
	private String researchLocation;
	private String expectedDuration;
	private Date startDate;
	private Date endDate;
	private List<ApplicationTag> tags;
	private TRAININGTYPE trainingType;
	
	public enum DEGREE{
		BSc, MSc, PhD, MPhil;
	}
	
	public enum TRAININGTYPE {
		Solicited, Unsolicited
	}
	
	/**
	 * 
	 */
	public GraduateResearchTrainingX() {

	}

	/**
	 * Copy constructor
	 * 
	 * @param GraduateResearchTraining
	 */
	public GraduateResearchTrainingX(Application application) {
		super(application);
	}
	
	public String getPresentUniversity() {
		return this.presentUniversity;
	}

	public void setPresentUniversity(String presentUniversity) {
		this.presentUniversity = presentUniversity;
	}
	
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	public DEGREE getDegreeSought() {
		return this.degreeSought;
	}

	public void setDegreeSought(DEGREE degreeSought) {
		this.degreeSought = degreeSought;
	}
	
	
	public String getProposedResearchTheme() {
		return this.proposedResearchTheme;
	}
	public void setProposedResearchTheme(String proposedResearchTheme) {
		this.proposedResearchTheme = proposedResearchTheme;
	}
	

	public String getEmailOfUniversitySupervisor() {
		return this.emailOfUniversitySupervisor;
	}
	
	public void setEmailOfUniversitySupervisor(String emailOfUniversitySupervisor) {
		this.emailOfUniversitySupervisor = emailOfUniversitySupervisor;
	}
	
	public String getNameOfUniversitySupervisor() {
		return this.nameOfUniversitySupervisor;
	}
	
	public void setNameOfUniversitySupervisor(String nameOfUniversitySupervisor) {
		this.nameOfUniversitySupervisor = nameOfUniversitySupervisor;
	}
	

	public String getNameOfIITASupervisor() {
		return this.nameOfIITASupervisor;
	}
	
	public void setNameOfIITASupervisor(String nameOfIITASupervisor) {
		this.nameOfIITASupervisor = nameOfIITASupervisor;
	}
	
	public String getResearchLocation() {
		return this.researchLocation;
	}

	public void setResearchLocation(String researchLocation) {
		this.researchLocation = researchLocation;
	}
	
	
	public String getExpectedDuration() {
		return this.expectedDuration;
	}
	
	public void setExpectedDuration(String expectedDuration) {
		this.expectedDuration = expectedDuration;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return this.startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return this.endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	public DEGREE getDegree() {
		return degree;
	}
	
	public void setDegree(DEGREE degree) {
		this.degree = degree;
	}

	/**
	 * @see org.iita.cdo.model.UserAccess#hasAccess(org.iita.security.model.User)
	 */
	@Override
	public boolean hasAccess(User user) {		
		if(super.getStatus()==APPLICATIONSTATUS.APPROVED)
			return true;
		
		if (super.getBiodata().getId().equals(user.getId())) {
			return true;
		}
		return false;
	}

	/**
	 * @return the tags
	 */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "entity")
	public List<ApplicationTag> getTags() {
		return this.tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<ApplicationTag> tags) {
		this.tags = tags;
	}

	@Override
	@Transient
	public Class<? extends EntityTag<Application>> getTagClass() {
		return ApplicationTag.class;
	}

	@Override
	public EntityTag<Application> createTag() {
		return new ApplicationTag();
	}
	
	public void setTrainingType(TRAININGTYPE trainingType) {
		this.trainingType = trainingType;
	}

	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	public TRAININGTYPE getTrainingType() {
		return trainingType;
	}
	
}