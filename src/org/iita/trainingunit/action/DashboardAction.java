/**
 * training.Struts Feb 5, 2010
 */
package org.iita.trainingunit.action;

//import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.iita.crm.model.Organization;
import org.iita.crm.model.Partner;
import org.iita.crm.model.Person;
import org.iita.security.Authorize;
import org.iita.security.model.User;
import org.iita.security.service.UserService;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.service.CDOApplicationService;
import org.iita.trainingunit.applications.service.impl.CDOApplicationException;
import org.iita.trainingunit.model.Alert;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.service.TrainingUnitService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
/*Chart things stopped here*/
/**
 * @author mobreza
 * @author KOraegbunam
 * 
 */
@SuppressWarnings("serial")
public class DashboardAction extends org.iita.crm.action.DashboardAction {

	private TrainingUnitService service;
	private CDOApplicationService cdoService;
	private UserService userService;
	private List<Person> persons;
	private List<Organization> organizations;
	private List<Trainee> trainees;
	private List<TrainingProgram> programs;
	private List<Partner> partners;
	private List<Alert> alerts;
	private List<Object> applications;
	
	private Hashtable<User, Long> otherPeoplePending = null;
	private PagedResult<Application> pagedAwaitingApproval;
	
	private List<Integer> traineeYears;
	private List<Integer> trainingProgramYears;
	private List<Integer> activityYears;
	
	/**
	 * @param trainingUnitService
	 * 
	 */
	public DashboardAction(TrainingUnitService trainingUnitService, CDOApplicationService cdoService, UserService userService) {
		super(trainingUnitService);
		this.service = trainingUnitService;
		this.cdoService = cdoService;
		this.userService = userService;
	}

	/**
	 * @return the persons
	 */
	public List<Person> getPersons() {
		return this.persons;
	}

	/**
	 * @return the organizations
	 */
	public List<Organization> getOrganizations() {
		return this.organizations;
	}

	/**
	 * @return the trainees
	 */
	public List<Trainee> getTrainees() {
		return this.trainees;
	}

	/**
	 * @return the traineeYears
	 */
	public List<Integer> getTraineeYears() {
		return this.traineeYears;
	}
	
	/**
	 * @return the trainingProgramYears
	 */
	public List<Integer> getTrainingProgramYears() {
		return this.trainingProgramYears;
	}
	
	/**
	 * @return the activityYears
	 */
	public List<Integer> getActivityYears() {
		return this.activityYears;
	}
	
	/**
	 * @return the programs
	 */
	public List<TrainingProgram> getPrograms() {
		return this.programs;
	}
	
	/**
	 * @return the partners
	 */
	public List<Partner> getPartners() {
		return this.partners;
	}
	
	/**
	 * @return the alerts
	 */
	public List<Alert> getAlerts() {
		return this.alerts;
	}

	public void setApplications(List<Object> applications) {
		this.applications = applications;
	}

	public List<Object> getApplications() {
		return applications;
	}
	
	public Hashtable<User, Long> getOtherPeoplePending() {
		return otherPeoplePending;
	}
	
	public PagedResult<Application> getPagedAwaitingApproval() {
		return pagedAwaitingApproval;
	}
	
	/**
	 * @see org.iita.struts.BaseAction#execute()
	 */
	@Override
	public String execute() {
		super.execute();
		
		if (Authorize.hasAny("ROLE_TRAININGUNITHEAD, ROLE_QUERYMANAGER, ROLE_ADMIN, ROLE_CRM, ROLE_QUERY, ROLE_MERGE")) {
			// cgo read-only
		}else if (Authorize.hasAny("ROLE_APPLICANT")) {
			return "applicant";
		} else { 
			return "user";
		}
		
		//if(getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_HEAD") || getUser().hasRole("ROLE_QUERYMANAGER")){
			this.persons = this.service.getLastUpdated(Person.class, 10);
			this.organizations = this.service.getLastUpdated(Organization.class, 10);
			this.trainees = this.service.getLastUpdated(Trainee.class, 10);
			this.programs = this.service.getLastUpdated(TrainingProgram.class, 10);
			this.alerts = this.service.getLastUpdated(Alert.class, 10);
			this.partners = this.service.getLastUpdated(Partner.class, 10);
			if (Authorize.hasAny("ROLE_TRAININGUNITHEAD, ROLE_APPLICATION, ROLE_ADMIN, ROLE_REGISTRATION")) {
				this.applications = this.cdoService.applications(false);
			}
		//}else{
		//	this.trainees = this.service.getLastUpdatedTrainees(getUser(), Trainer.class, 10);
		//	this.programs = this.service.getLastUpdatedTrainingPrograms(getUser(), Trainer.class, 10);
		//}
		if(getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_CRM") || getUser().hasRole("ROLE_TRAININGUNITHEAD"))
			this.traineeYears = this.service.getTraineeYears(null);
		else
			this.traineeYears = this.service.getTraineeYears(getUser());
		
		if(getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_CRM") || getUser().hasRole("ROLE_TRAININGUNITHEAD"))
			this.trainingProgramYears = this.service.getTrainingProgramYears(null);
		else
			this.trainingProgramYears = this.service.getTrainingProgramYears(getUser());
		
		if(getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_CRM") || getUser().hasRole("ROLE_TRAININGUNITHEAD"))
			this.activityYears = this.service.getActivityYears(null);
		else
			this.activityYears = this.service.getActivityYears(getUser());
		
		
		try {
			this.pagedAwaitingApproval = this.service.getAwaitingApproval(this.getUser(), 0, 50);
		} catch (CDOApplicationException e) {
			addActionError(e.getMessage());
		}
		
		// everything that is pending for users that have delegated access to this user
		if (getUser().getImpersonator() == null) {
			List<User> incomingDelegations = this.userService.getDelegatedFrom(getUser());
			this.otherPeoplePending = new Hashtable<User, Long>();

			// for each delegation, check for pending TAs
			for (User incomingDelegation : incomingDelegations) {
				try {
					LOG.debug("Listing awaiting for " + incomingDelegation);
					long waitingTAs = this.service.getAwaitingApproval(incomingDelegation, 0, 1).getTotalHits();
					LOG.debug("Has " + waitingTAs + " application(s) awaiting approval");
					if (waitingTAs > 0)
						otherPeoplePending.put(incomingDelegation, waitingTAs);
				} catch (CDOApplicationException e) {
					LOG.info("Error fetching awaiting applications for incoming delegation from " + incomingDelegation);
				}
			}
		}
		
		return Action.SUCCESS;
	}
	
	public String regPerson(){
		this.persons = this.service.getLastUpdated(Person.class, 10);
		
		return "regPerson";
	}
	
	public String regTrainee(){
		this.trainees = this.service.getLastUpdated(Trainee.class, 10);
		
		return "regTrainee";
	}
	
	public String regTrainingProgram(){
		this.programs = this.service.getLastUpdated(TrainingProgram.class, 10);
		
		return "regTrainingProgram";
	}
	
	public String regOrganization(){
		this.organizations = this.service.getLastUpdated(Organization.class, 10);
		
		return "regOrganization";
	}
	
	public String regPartner(){
		this.partners = this.service.getLastUpdated(Partner.class, 10);
		
		return "regPartner";
	}
	
	public String alerts(){
		this.alerts = this.service.getLastUpdated(Alert.class, 10);
		
		return "alerts";
	}
	
	public String tagCloud(){
		if (Authorize.hasAny("ROLE_TRAININGUNITHEAD, ROLE_APPLICATION, ROLE_ADMIN, ROLE_REGISTRATION")) {
			this.applications = this.cdoService.applications(false);
		}
		
		return "tagCloud";
	}
}
