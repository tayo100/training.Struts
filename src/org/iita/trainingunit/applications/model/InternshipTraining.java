/**
 * 
 */
package org.iita.trainingunit.applications.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.search.annotations.Indexed;
import org.iita.crm.model.ApplicationTag;
import org.iita.crm.model.EntityTag;
import org.iita.security.model.User;

/**
 * @author ken
 *
 */
@Entity
@Indexed
public class InternshipTraining extends Application {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SupportType supportTypes;
	private List<ApplicationTag> tags;
	private List<InternshipEducationAndExperience> internshipEducationAndExperience = new ArrayList<InternshipEducationAndExperience>();
	private String areaOfSpecialization;
	private String whyInIITA;
	
	private List<InternshipWorkExperience> internshipWorkExperience = new ArrayList<InternshipWorkExperience>();
	
	/**
	 * 
	 */
	public InternshipTraining() {

	}

	/**
	 * Copy constructor
	 * 
	 * @param InternshipTraining
	 */
	public InternshipTraining(Application application) {
		super(application);
	}
	
	/**
	 * @return the supportTypes
	 */
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "application")
	public SupportType getSupportTypes() {
		return supportTypes;
	}

	/**
	 * @param supportTypes the supportTypes to set
	 */
	public void setSupportTypes(SupportType supportTypes) {
		this.supportTypes = supportTypes;
	}
	
	/**
	 * List of education and training on this internshipEducationAndExperience
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
	public List<InternshipWorkExperience> getInternshipWorkExperience() {
		return internshipWorkExperience;
	}
	
	public void setInternshipWorkExperience(List<InternshipWorkExperience> internshipWorkExperience) {
		this.internshipWorkExperience = internshipWorkExperience;
	}
	
	public void setInternshipEducationAndExperience(List<InternshipEducationAndExperience> internshipEducationAndExperience) {
		this.internshipEducationAndExperience = internshipEducationAndExperience;
	}
	
	/**
	 * List of education and training on this internshipEducationAndExperience
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
	public List<InternshipEducationAndExperience> getInternshipEducationAndExperience() {
		return internshipEducationAndExperience;
	}
	
	/**
	 * @param areaOfSpecialization the areaOfSpecialization to set
	 */
	public void setAreaOfSpecialization(String areaOfSpecialization) {
		this.areaOfSpecialization = areaOfSpecialization;
	}

	/**
	 * @return the areaOfSpecialization
	 */
	@Column(length=255)
	public String getAreaOfSpecialization() {
		return areaOfSpecialization;
	}

	/**
	 * @param whyInIITA the whyInIITA to set
	 */
	public void setWhyInIITA(String whyInIITA) {
		this.whyInIITA = whyInIITA;
	}

	/**
	 * @return the whyInIITA
	 */
	@Lob
	public String getWhyInIITA() {
		return whyInIITA;
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
	public boolean hasAccess(User user) {
		// TODO Auto-generated method stub
		return false;
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

}
