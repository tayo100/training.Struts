package org.iita.trainingunit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.iita.crm.model.Person;
import org.iita.entity.VersionedEntity;

//
// DON'T FIDDLE WITH THIS
//
@Entity
public class TraineeEducationalInfo extends VersionedEntity {
	private static final long serialVersionUID = -5735989011210797007L;
	private Person person;
	private String degree;
	private String university;
	private String universityAddress;
	private Date degreeAwardDate;
	
	@ManyToOne(cascade = {}, optional = false)
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String getDegree() {
		return degree;
	}
	
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public String getUniversity() {
		return university;
	}
	
	public void setUniversity(String university) {
		this.university = university;
	}
	
	@Column(length = 400)
	public String getUniversityAddress() {
		return universityAddress;
	}
	
	public void setUniversityAddress(String universityAddress) {
		this.universityAddress = universityAddress;
	}
	
	public Date getDegreeAwardDate() {
		return degreeAwardDate;
	}
	
	public void setDegreeAwardDate(Date degreeAwardDate) {
		this.degreeAwardDate = degreeAwardDate;
	}
	
}
