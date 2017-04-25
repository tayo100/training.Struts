package org.iita.trainingunit.applications.service;

import java.util.List;

import org.iita.security.model.User;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.applications.model.ApplicantsBioData;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.model.Application.APPLICATIONSTATUS;
import org.iita.trainingunit.applications.model.Application.SUBMISSIONSTATUS;
import org.iita.trainingunit.applications.model.ApplicationStarter;
import org.iita.trainingunit.applications.model.GraduateResearchTraining;
import org.iita.trainingunit.applications.model.GroupTraining;
import org.iita.trainingunit.applications.model.InHouseTraining;
import org.iita.trainingunit.applications.model.IndividualTraining;
import org.iita.trainingunit.applications.model.InternalApprovals;
import org.iita.trainingunit.applications.model.InternshipTraining;
import org.iita.trainingunit.applications.model.NonDegreeTraining;
import org.iita.trainingunit.applications.model.OtherApplicationDetails;
import org.iita.trainingunit.applications.model.OtherTraining;
import org.iita.trainingunit.applications.model.SabbaticalTraining;
import org.iita.trainingunit.applications.model.StaffDevTraining;
import org.iita.trainingunit.applications.service.impl.CDOApplicationException;
import org.iita.util.PagedResult;

public interface CDOApplicationService extends ApplicantBioDataService {

	GroupTraining save(GroupTraining application) throws Exception;//, List<Long> selectedLocations
	GraduateResearchTraining save(GraduateResearchTraining application) throws Exception;// List<Long> selectedLocations
	NonDegreeTraining save(NonDegreeTraining application) throws Exception;
	OtherTraining save(OtherTraining application) throws Exception;
	
	IndividualTraining save(IndividualTraining application) throws Exception;
	SabbaticalTraining save(SabbaticalTraining application) throws Exception;
	StaffDevTraining save(StaffDevTraining application) throws Exception;
	InHouseTraining save(InHouseTraining application) throws Exception;

	void delete(GroupTraining application);
	void delete(GraduateResearchTraining application);
	void delete(NonDegreeTraining application);
	
	void delete(IndividualTraining application);
	void delete(SabbaticalTraining application);
	void delete(InHouseTraining application);
	void delete(StaffDevTraining application);

	PagedResult<GroupTraining> list(int startAt, int maxResults);
	PagedResult<GraduateResearchTraining> listGraduate(int startAt, int maxResults);
	PagedResult<NonDegreeTraining> listNonDegree(int startAt, int maxResults);
	PagedResult<OtherTraining> listOther(int startAt, int maxResults);
	
	PagedResult<IndividualTraining> listIndividual(int startAt, int maxResults);
	PagedResult<InHouseTraining> listInHouse(int startAt, int maxResults);
	PagedResult<StaffDevTraining> listStaffDev(int startAt, int maxResults);
	PagedResult<SabbaticalTraining> listSabbatical(int startAt, int maxResults);
	
	GroupTraining exists(Announcement announcement, String refNumber);
	GraduateResearchTraining existsGraduate(Announcement announcement, String refNumber);
	NonDegreeTraining existsNonDegree(Announcement announcement, String refNumber);
	
	IndividualTraining existsIndividual(Announcement announcement, String refNumber);
	StaffDevTraining existsStaffDev(Announcement announcement, String refNumber);
	SabbaticalTraining existsSabbatical(Announcement announcement, String refNumber);
	InHouseTraining existsInHouse(Announcement announcement, String refNumber);
	
	int totalApplicants(Announcement announcement);
	
	Application findApplication(Long id);
	
	GroupTraining find(Long id);
	GraduateResearchTraining findGraduate(Long id);
	NonDegreeTraining findNonDegree(Long id);
	OtherTraining findOther(Long id);
	
	IndividualTraining findIndividual(Long id);
	InHouseTraining findInHouse(Long id);
	SabbaticalTraining findSabbatical(Long id);
	StaffDevTraining findStaffDev(Long id);

	List<GroupTraining> list();
	List<GraduateResearchTraining> listGraduate();
	List<NonDegreeTraining> listNonDegree();
	List<OtherTraining> listOther();
	
	List<IndividualTraining> listIndividual();
	List<SabbaticalTraining> listSabbatical();
	List<StaffDevTraining> listStaffDev();
	List<InHouseTraining> listInHouse();

	Application findByRefNumber(String refNumber, String email);
	ApplicantsBioData getBioDataByRefNumber(String email);
	
	void delete(User principal, User user, Application app) throws CDOApplicationException;
	void delete(User principal, User user, GraduateResearchTraining app) throws CDOApplicationException;
	void delete(User principal, User user, NonDegreeTraining app) throws CDOApplicationException;
	void delete(User principal, User user, OtherTraining app) throws CDOApplicationException;
	void delete(User principal, User user, IndividualTraining app) throws CDOApplicationException;
	void delete(User principal, User user, StaffDevTraining app) throws CDOApplicationException;
	void delete(User principal, User user, SabbaticalTraining app) throws CDOApplicationException;
	void delete(User principal, User user, InHouseTraining app) throws CDOApplicationException;

	void validate(GroupTraining app) throws CDOApplicationException;
	void validate(GraduateResearchTraining app) throws CDOApplicationException;
	void validate(NonDegreeTraining app) throws CDOApplicationException;
	void validate(OtherTraining app) throws CDOApplicationException;
	
	void validate(InHouseTraining app) throws CDOApplicationException;
	void validate(StaffDevTraining app) throws CDOApplicationException;
	void validate(IndividualTraining app) throws CDOApplicationException;
	void validate(SabbaticalTraining app) throws CDOApplicationException;
	
	void validate(ApplicantsBioData app) throws CDOApplicationException;

	OtherApplicationDetails save(OtherApplicationDetails otherAppDetails);
	
	ApplicationStarter save(ApplicationStarter appStarter);
	ApplicationStarter findAppStarter(Long id);
	
	OtherApplicationDetails findOtherAppDetails(GroupTraining cdoApplication);
	OtherApplicationDetails findOtherAppDetails(GraduateResearchTraining cdoApplication);
	OtherApplicationDetails findOtherAppDetails(NonDegreeTraining cdoApplication);
	OtherApplicationDetails findOtherAppDetails(OtherTraining cdoApplication);
	
	OtherApplicationDetails findOtherAppDetails(InHouseTraining cdoApplication);
	OtherApplicationDetails findOtherAppDetails(IndividualTraining cdoApplication);
	OtherApplicationDetails findOtherAppDetails(SabbaticalTraining cdoApplication);
	OtherApplicationDetails findOtherAppDetails(StaffDevTraining cdoApplication);
	
	OtherApplicationDetails findOtherAppDetails(Long id);

	void delete(User principal, User user, ApplicantsBioData cdoBioData) throws CDOApplicationException;

	ApplicantsBioData findBioData(Long id);

	ApplicationStarter findAppStarterByKey(String appKey);

	List<GroupTraining> list(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status);
	List<GraduateResearchTraining> listGraduate(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status);
	List<InternshipTraining> listInternship(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status);
	List<NonDegreeTraining> listNonDegree(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status);
	List<OtherTraining> listOther(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status);
	
	List<IndividualTraining> listIndividual(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status);
	List<InHouseTraining> listInHouse(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status);
	List<SabbaticalTraining> listSabbatical(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status);
	List<StaffDevTraining> listStaffDev(ApplicantsBioData cdoBioData, String type, SUBMISSIONSTATUS status);

	ApplicationStarter findAppStarterByKey(ApplicantsBioData cdoBioData);

	GroupTraining findApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status);
	GraduateResearchTraining findGraduateApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status);
	NonDegreeTraining findNonDegreeApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status);
	OtherTraining findOtherApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status);
	
	IndividualTraining findIndividualApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status);
	InHouseTraining findInHouseApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status);
	SabbaticalTraining findSabbaticalApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status);
	StaffDevTraining findStaffDevApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status);
	
	List<Object> applications(boolean fulldisplay);
	PagedResult<Object> listObject(int startAt, int maxResults);

	PagedResult<Application> list(Long announcementId, int startAt, int maxResults);
	ApplicantsBioData findStaff(String staffId, String email);
	
	PagedResult<Application> getAwaitingApproval(User user, int startAt, int maxResults) throws CDOApplicationException;
	List<User> getWaitingFor(Application app);
	PagedResult<Application> getMyBcApplications(User user, int startAt, int maxResults) throws CDOApplicationException;
	Application load(Long id);
	void sendReminders(User user, Application app);
	
	InternshipTraining findInternship(Long applicationId);
	InternshipTraining findInternshipApplication(Announcement announcement, ApplicantsBioData cdoBioData, SUBMISSIONSTATUS status);
	InternshipTraining save(InternshipTraining cdoInternshipApplication);
	
	InternalApprovals validate(InternalApprovals internalApproval) throws CDOApplicationException;
	
	PagedResult<Application> getApplications(int startAt, int maxResults, APPLICATIONSTATUS... statuslist);

	PagedResult<Application> getApplications(User owner, int startAt, int maxResults, APPLICATIONSTATUS... statuslist);
	
	/**
	 * @param startAt
	 * @param maxResults
	 * @param statuslist
	 * @param orderBy
	 * @return
	 */
	PagedResult<Application> getApplications(int startAt, int maxResults, String orderBy, APPLICATIONSTATUS... statuslist);


}