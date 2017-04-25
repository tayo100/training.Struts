package org.iita.trainingunit.iya.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.iita.entity.VersionedEntity;
import org.iita.trainingunit.iya.model.IYAEvaluation.STATUS;



/**
 * 
 * @author ooluloko
 */
@Entity
public class IYAEvaluation extends VersionedEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String subjectMastery;
	private String courseDelivery;	
	private String programDuration;
	private String objectivesMet ;
	private String classInteraction;
	private IYARegistration iyaRegistration; 
	
	public enum STATUS {
		STRONGLYAGREE, AGREE, DISAGREE, NEUTRAL, STRONGLYDISAGREE
	}

	
	public String getSubjectMastery() {
		return subjectMastery;
	}
	
	public void setSubjectMastery(String subjectMastery) {
		this.subjectMastery = subjectMastery;
	}
	
	public String getCourseDelivery() {
		return courseDelivery;
	}
	
	public void setCourseDelivery(String courseDelivery) {
		this.courseDelivery = courseDelivery;
	}
/*	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "iyaEvaluation")
	public List<ClassInteraction> getClassInteractions() {
		return classInteraction;
	}
	
	public void setClassInteractions(List<ClassInteraction> classInteraction) {
		this.classInteraction = classInteraction;
	}
*/	
	
	public String getProgramDuration() {
		return programDuration;
	}
	
	public void setProgramDuration(String programDuration) {
		this.programDuration = programDuration;
	}

/*	*//**
	 * @param iyaRegistration the iyaRegistration to set
	 *//*
	public void setIyaRegistration(IYARegistration iyaRegistration) {
		this.iyaRegistration = iyaRegistration;
	}

	*//**
	 * @return the iyaRegistration
	 *//*
	@OneToOne(cascade = {}, optional = false)
	public IYARegistration getIyaRegistration() {
		return iyaRegistration;
	}*/

	/**
	 * @param objectivesMet the objectivesMet to set
	 */
	public void setObjectivesMet(String objectivesMet) {
		this.objectivesMet = objectivesMet;
	}

	/**
	 * @return the objectivesMet
	 */
	//@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "iyaEvaluation")
	public String getObjectivesMet() {
		return objectivesMet;
	}

	/**
	 * @param classInteraction the classInteraction to set
	 */
	public void setClassInteraction(String classInteraction) {
		this.classInteraction = classInteraction;
	}

	/**
	 * @return the classInteraction
	 */
	
	public String getClassInteraction() {
		return classInteraction;
	}

	/**
	 * @param iyaRegistration the iyaRegistration to set
	 */
	public void setIyaRegistration(IYARegistration iyaRegistration) {
		this.iyaRegistration = iyaRegistration;
	}

	/**
	 * @return the iyaRegistration
	 */
	@OneToOne(fetch = FetchType.LAZY)
	public IYARegistration getIyaRegistration() {
		return iyaRegistration;
	}

}
