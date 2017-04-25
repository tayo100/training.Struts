/**
 * 
 */
package org.iita.trainingunit.applications.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.iita.entity.VersionedEntity;
import org.iita.trainingunit.model.CoreCompetency;
import org.iita.trainingunit.model.Crp;
import org.iita.trainingunit.model.Hub;

/**
 * @author ken
 *
 */
@Entity
public class InternalApprovals extends VersionedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 680852113075931007L;
	private String evaluation;
	
	private List<CoreCompetency> coreCompetencies = new ArrayList<CoreCompetency>();
	private List<Crp> crps = new ArrayList<Crp>();
	private List<Hub> hubs = new ArrayList<Hub>();
	private List<BudgetCode> budgetCodes = new ArrayList<BudgetCode>();
	private String project;
	private double coreBudget;
	private double totalCost;
	private String budgetCode;
	private RATING rating;
	private String remarks;
	
	private String projOfficer;
	private SIGNATURE projOfficerApproval = SIGNATURE.PENDING;
	private Date projOfficerDateApproved;
	
	
	private String progDirector;
	private SIGNATURE progDirectorApproval = SIGNATURE.PENDING;
	private Date progDirectorDateApproved;
	
	private String cfoName;
	private SIGNATURE cfoApproval = SIGNATURE.PENDING;
	private Date cfoDateApproved;
	private String cfoComments;
	
	private String cdoHeadName;
	private SIGNATURE cdoHeadApproval = SIGNATURE.PENDING;
	private Date cdoHeadDateApproved;
	private String cdoHeadComments;
	
	
	private Application application;
	//private GraduateResearchTraining graduateResearch;
	//private NonDegreeTraining nonDegree;
	
	public enum SIGNATURE{APPROVED, PENDING, REJECTED}
	
	public enum RATING {EXCELLENT, GOOD, NEEDIMPROVEMENT, WEAK}
	
	@Lob
	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public double getCoreBudget() {
		return coreBudget;
	}

	public void setCoreBudget(double coreBudget) {
		this.coreBudget = coreBudget;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
	
	@Column(length = 100)
	public String getBudgetCode() {
		return budgetCode;
	}

	public void setBudgetCode(String budgetCode) {
		this.budgetCode = budgetCode;
	}

	/**
	 * Gets the hubs.
	 * 
	 * @return the hubs
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "internalApproval")
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
	 * @param rating the rating to set
	 */
	public void setRating(RATING rating) {
		this.rating = rating;
	}

	/**
	 * @return the rating
	 */
	@Enumerated(EnumType.STRING)
	public RATING getRating() {
		return rating;
	}

	/**
	 * Gets the crps.
	 * 
	 * @return the crps
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "internalApproval")
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
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "internalApproval")
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
	 * Get budget codes for this TA
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "internalApproval")
	public List<BudgetCode> getBudgetCodes() {
		return budgetCodes;
	}

	public void setBudgetCodes(List<BudgetCode> budgetCodes) {
		this.budgetCodes = budgetCodes;
	}
	
	@Column(length = 150)
	public String getProjOfficer() {
		return projOfficer;
	}

	public void setProjOfficer(String projOfficer) {
		this.projOfficer = projOfficer;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	public SIGNATURE getProjOfficerApproval() {
		return projOfficerApproval;
	}

	public void setProjOfficerApproval(SIGNATURE projOfficerApproval) {
		this.projOfficerApproval = projOfficerApproval;
	}

	@Temporal(TemporalType.DATE)
	public Date getProjOfficerDateApproved() {
		return projOfficerDateApproved;
	}

	public void setProjOfficerDateApproved(Date projOfficerDateApproved) {
		this.projOfficerDateApproved = projOfficerDateApproved;
	}

	@Column(length = 150)
	public String getProgDirector() {
		return progDirector;
	}

	public void setProgDirector(String progDirector) {
		this.progDirector = progDirector;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	public SIGNATURE getProgDirectorApproval() {
		return progDirectorApproval;
	}

	public void setProgDirectorApproval(SIGNATURE progDirectorApproval) {
		this.progDirectorApproval = progDirectorApproval;
	}

	@Temporal(TemporalType.DATE)
	public Date getProgDirectorDateApproved() {
		return progDirectorDateApproved;
	}

	public void setProgDirectorDateApproved(Date progDirectorDateApproved) {
		this.progDirectorDateApproved = progDirectorDateApproved;
	}

	@Column(length = 150)
	public String getCfoName() {
		return cfoName;
	}

	public void setCfoName(String cfoName) {
		this.cfoName = cfoName;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	public SIGNATURE getCfoApproval() {
		return cfoApproval;
	}

	public void setCfoApproval(SIGNATURE cfoApproval) {
		this.cfoApproval = cfoApproval;
	}

	@Temporal(TemporalType.DATE)
	public Date getCfoDateApproved() {
		return cfoDateApproved;
	}

	public void setCfoDateApproved(Date cfoDateApproved) {
		this.cfoDateApproved = cfoDateApproved;
	}

	@Lob
	public String getCfoComments() {
		return cfoComments;
	}

	public void setCfoComments(String cfoComments) {
		this.cfoComments = cfoComments;
	}

	@Column(length = 150)
	public String getCdoHeadName() {
		return cdoHeadName;
	}

	public void setCdoHeadName(String cdoHeadName) {
		this.cdoHeadName = cdoHeadName;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	public SIGNATURE getCdoHeadApproval() {
		return cdoHeadApproval;
	}

	public void setCdoHeadApproval(SIGNATURE cdoHeadApproval) {
		this.cdoHeadApproval = cdoHeadApproval;
	}

	@Temporal(TemporalType.DATE)
	public Date getCdoHeadDateApproved() {
		return cdoHeadDateApproved;
	}

	public void setCdoHeadDateApproved(Date cdoHeadDateApproved) {
		this.cdoHeadDateApproved = cdoHeadDateApproved;
	}

	@Lob
	public String getCdoHeadComments() {
		return cdoHeadComments;
	}

	public void setCdoHeadComments(String cdoHeadComments) {
		this.cdoHeadComments = cdoHeadComments;
	}

	@Lob
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	public Application getApplication() {
		return application;
	}
	
	//public void setGraduateResearch(GraduateResearchTraining graduateResearch) {
	//	this.graduateResearch = graduateResearch;
	//}
	
	//@OneToOne(optional = false, cascade = CascadeType.ALL)
	//public GraduateResearchTraining getGraduateResearch() {
	//	return graduateResearch;
	//}
	
	//public void setNonDegree(NonDegreeTraining nonDegree) {
	//	this.nonDegree = nonDegree;
	//}
	
	//@OneToOne(optional = false, cascade = CascadeType.ALL)
	//public NonDegreeTraining getNonDegree() {
	//	return nonDegree;
	//}
}
