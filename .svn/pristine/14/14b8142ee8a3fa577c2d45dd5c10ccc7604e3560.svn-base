package org.iita.trainingunit.iya.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.iita.entity.VersionedEntity;


/**
 * 
 * @author ooluloko
 */
@Entity
public class IYAEvaluation extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String subjectMastery;
	private List<IYAEvaluationObjective> objectivesMet;
	private String courseDelivery;
	private List<ClassInteraction> classInteraction;
	private String programDuration;
		
	public String getSubjectMastery() {
		return subjectMastery;
	}
	
	public void setSubjectMastery(String subjectMastery) {
		this.subjectMastery = subjectMastery;
	}
	
	
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "iyaEvaluation")
	public List<IYAEvaluationObjective> getObjectivesMet() {
		return objectivesMet;
	}
	
	public void setObjectivesMet(List<IYAEvaluationObjective> objectivesMet) {
		this.objectivesMet = objectivesMet;
	}
	
	public String getCourseDelivery() {
		return courseDelivery;
	}
	
	public void setCourseDelivery(String courseDelivery) {
		this.courseDelivery = courseDelivery;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "iyaEvaluation")
	public List<ClassInteraction> getClassInteraction() {
		return classInteraction;
	}
	
	public void setClassInteraction(List<ClassInteraction> classInteraction) {
		this.classInteraction = classInteraction;
	}
	
	public String getProgramDuration() {
		return programDuration;
	}
	
	public void setProgramDuration(String programDuration) {
		this.programDuration = programDuration;
	}
}
