/**
 * 
 */
package org.iita.trainingunit.action;

import java.util.List;

import org.iita.crm.action.BaseAction;
import org.iita.trainingunit.applications.model.ApplicantsBioData;
import org.iita.trainingunit.applications.model.Application.SUBMISSIONSTATUS;
import org.iita.trainingunit.applications.model.GraduateResearchTraining;
import org.iita.trainingunit.applications.model.GroupTraining;
import org.iita.trainingunit.applications.model.InHouseTraining;
import org.iita.trainingunit.applications.model.IndividualTraining;
import org.iita.trainingunit.applications.model.InternshipTraining;
import org.iita.trainingunit.applications.model.NonDegreeTraining;
import org.iita.trainingunit.applications.model.OtherTraining;
import org.iita.trainingunit.applications.model.SabbaticalTraining;
import org.iita.trainingunit.applications.model.StaffDevTraining;
import org.iita.trainingunit.applications.service.CDOApplicationService;

/**
 * @author ken
 *
 *
 */
@SuppressWarnings("serial")
public class BioDataAction extends BaseAction {
	protected CDOApplicationService cdoApplicationService = null;
	protected ApplicantsBioData cdoBioData;
	protected String fileName;
	private List<GroupTraining> groupApplication;
	private List<GraduateResearchTraining> graduateApplication;
	private List<InternshipTraining> internshipApplication;
	private List<NonDegreeTraining> nondegreeApplication;
	private List<OtherTraining> otherApplication = null;
	
	private List<IndividualTraining> individualApplication;
	private List<SabbaticalTraining> sabbaticalApplication;
	private List<StaffDevTraining> staffDevApplication;
	private List<InHouseTraining> inHouseApplication;
	
	private List<GroupTraining> groupUncompleted;
	private List<GraduateResearchTraining> graduateUncompleted;
	private List<InternshipTraining> internshipUncompleted;
	private List<NonDegreeTraining> nondegreeUncompleted;
	private List<OtherTraining> otherUncompleted = null;
	
	private List<IndividualTraining> individualUncompleted;
	private List<SabbaticalTraining> sabbaticalUncompleted;
	private List<StaffDevTraining> staffDevUncompleted;
	private List<InHouseTraining> inHouseUncompleted;
	
	public BioDataAction(CDOApplicationService cdoApplicationService) {
		super();
		this.cdoApplicationService = cdoApplicationService;
	}
	
	@Override
	public void prepare() {
		if(getUser()!=null)
			this.cdoBioData = this.cdoApplicationService.findByUser(getUser());
		
		this.groupApplication = this.cdoApplicationService.list(this.cdoBioData, "Group", SUBMISSIONSTATUS.Submitted);
		this.graduateApplication = this.cdoApplicationService.listGraduate(this.cdoBioData, "Graduate", SUBMISSIONSTATUS.Submitted);
		this.internshipApplication = this.cdoApplicationService.listInternship(this.cdoBioData, "Internship", SUBMISSIONSTATUS.Submitted);
		this.nondegreeApplication = this.cdoApplicationService.listNonDegree(this.cdoBioData, "Non-degree", SUBMISSIONSTATUS.Submitted);
		this.otherApplication = this.cdoApplicationService.listOther(this.cdoBioData, "Other", SUBMISSIONSTATUS.Submitted);
		
		this.individualApplication = this.cdoApplicationService.listIndividual(this.cdoBioData, "Individual", SUBMISSIONSTATUS.Submitted);
		this.staffDevApplication = this.cdoApplicationService.listStaffDev(this.cdoBioData, "Staff Development", SUBMISSIONSTATUS.Submitted);
		this.sabbaticalApplication = this.cdoApplicationService.listSabbatical(this.cdoBioData, "Sabbatical", SUBMISSIONSTATUS.Submitted);
		this.inHouseApplication = this.cdoApplicationService.listInHouse(this.cdoBioData, "In-house Group", SUBMISSIONSTATUS.Submitted);
		
		this.groupUncompleted = this.cdoApplicationService.list(this.cdoBioData, "Group", SUBMISSIONSTATUS.Draft) ;
		this.graduateUncompleted = this.cdoApplicationService.listGraduate(this.cdoBioData, "Graduate", SUBMISSIONSTATUS.Draft);
		this.internshipUncompleted = this.cdoApplicationService.listInternship(this.cdoBioData, "Internship", SUBMISSIONSTATUS.Draft);
		this.nondegreeUncompleted = this.cdoApplicationService.listNonDegree(this.cdoBioData, "Non-degree", SUBMISSIONSTATUS.Draft);
		this.otherUncompleted = this.cdoApplicationService.listOther(this.cdoBioData, "Other", SUBMISSIONSTATUS.Draft);
		
		this.individualUncompleted = this.cdoApplicationService.listIndividual(this.cdoBioData, "Individual", SUBMISSIONSTATUS.Draft) ;
		this.staffDevUncompleted = this.cdoApplicationService.listStaffDev(this.cdoBioData, "Staff Development", SUBMISSIONSTATUS.Draft);
		this.inHouseUncompleted = this.cdoApplicationService.listInHouse(this.cdoBioData, "In-house Group", SUBMISSIONSTATUS.Draft);
		this.sabbaticalUncompleted = this.cdoApplicationService.listSabbatical(this.cdoBioData, "Sabbatical", SUBMISSIONSTATUS.Draft);
	}
	
	public ApplicantsBioData getCdoBioData(){
		return cdoBioData;
	}
	
	public List<GroupTraining> getGroupApplication() {
		return groupApplication;
	}

	public List<GraduateResearchTraining> getGraduateApplication() {
		return graduateApplication;
	}
	
	public List<InternshipTraining> getInternshipApplication() {
		return internshipApplication;
	}

	public List<NonDegreeTraining> getNondegreeApplication() {
		return nondegreeApplication;
	}
	
	public List<OtherTraining> getOtherApplication() {
		return otherApplication;
	}

	
	public List<GroupTraining> getGroupUncompleted() {
		return groupUncompleted;
	}

	public List<GraduateResearchTraining> getGraduateUncompleted() {
		return graduateUncompleted;
	}
	
	public List<InternshipTraining> getInternshipUncompleted() {
		return internshipUncompleted;
	}

	public List<NonDegreeTraining> getNondegreeUncompleted() {
		return nondegreeUncompleted;
	}
	
	public List<OtherTraining> getOtherUncompleted() {
		return otherUncompleted;
	}

	public void setIndividualApplication(List<IndividualTraining> individualApplication) {
		this.individualApplication = individualApplication;
	}

	public List<IndividualTraining> getIndividualApplication() {
		return individualApplication;
	}

	public void setSabbaticalApplication(List<SabbaticalTraining> sabbaticalApplication) {
		this.sabbaticalApplication = sabbaticalApplication;
	}

	public List<SabbaticalTraining> getSabbaticalApplication() {
		return sabbaticalApplication;
	}

	public void setStaffDevApplication(List<StaffDevTraining> staffDevApplication) {
		this.staffDevApplication = staffDevApplication;
	}

	public List<StaffDevTraining> getStaffDevApplication() {
		return staffDevApplication;
	}

	public void setInHouseApplication(List<InHouseTraining> inHouseApplication) {
		this.inHouseApplication = inHouseApplication;
	}

	public List<InHouseTraining> getInHouseApplication() {
		return inHouseApplication;
	}

	public void setIndividualUncompleted(List<IndividualTraining> individualUncompleted) {
		this.individualUncompleted = individualUncompleted;
	}

	public List<IndividualTraining> getIndividualUncompleted() {
		return individualUncompleted;
	}

	public void setSabbaticalUncompleted(List<SabbaticalTraining> sabbaticalUncompleted) {
		this.sabbaticalUncompleted = sabbaticalUncompleted;
	}

	public List<SabbaticalTraining> getSabbaticalUncompleted() {
		return sabbaticalUncompleted;
	}

	public void setStaffDevUncompleted(List<StaffDevTraining> staffDevUncompleted) {
		this.staffDevUncompleted = staffDevUncompleted;
	}

	public List<StaffDevTraining> getStaffDevUncompleted() {
		return staffDevUncompleted;
	}

	public void setInHouseUncompleted(List<InHouseTraining> inHouseUncompleted) {
		this.inHouseUncompleted = inHouseUncompleted;
	}

	public List<InHouseTraining> getInHouseUncompleted() {
		return inHouseUncompleted;
	}
}
