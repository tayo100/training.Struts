package org.iita.trainingunit.action;

import java.util.Hashtable;
import java.util.List;

import org.iita.crm.model.Person;
import org.iita.security.model.User;
import org.iita.security.service.UserService;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.service.impl.CDOApplicationException;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.service.AlumniService;
import org.iita.trainingunit.service.TrainingUnitService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;

@SuppressWarnings("serial")
public class DashboardActionUser extends PersonProfileAction {

	private TrainingUnitService trainingUnitService;
	private UserService userService;
	private List<Trainee> trainees;
	private List<Trainee> supervisions;
	private List<TrainingProgram> trainings;
	private List<Integer> traineeYears;
	private List<Integer> trainingProgramYears;
	
	private Hashtable<User, Long> otherPeoplePending = null;
	private PagedResult<Application> pagedAwaitingApproval;
	
	
	public DashboardActionUser(TrainingUnitService trainingUnitService, AlumniService alumniService, UserService userService) {
		super(trainingUnitService, alumniService);
		this.trainingUnitService = trainingUnitService;
		this.userService = userService;
	}
	
	/**
	 * @return the trainees
	 */
	public List<Trainee> getTrainees() {
		return this.trainees;
	}

	/**
	 * @return the supervisions
	 */
	public List<Trainee> getSupervisions() {
		return this.supervisions;
	}
	
	/**
	 * @return the trainings
	 */
	public List<TrainingProgram> getTrainings() {
		return this.trainings;
	}
	
	@Override
	protected Person loadProfile() {
		return this.trainingUnitService.findOrCreatePerson(getUser());
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
	
	public Hashtable<User, Long> getOtherPeoplePending() {
		return otherPeoplePending;
	}
	
	public PagedResult<Application> getPagedAwaitingApproval() {
		return pagedAwaitingApproval;
	}
	
	@Override
	public String execute() {
		super.execute();
		this.trainees = this.trainingUnitService.listTrainees(this.profile);
		this.supervisions = this.trainingUnitService.listSupervisions(this.profile);
		this.trainings=this.trainingUnitService.listTrainingPrograms(this.profile);
		
		if(getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_CRM") || getUser().hasRole("ROLE_TRAININGUNITHEAD"))
			this.traineeYears = this.trainingUnitService.getTraineeYears(null);
		else
			this.traineeYears = this.trainingUnitService.getTraineeYears(getUser());
		
		if(getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_CRM") || getUser().hasRole("ROLE_TRAININGUNITHEAD"))
			this.trainingProgramYears = this.trainingUnitService.getTrainingProgramYears(null);
		else
			this.trainingProgramYears = this.trainingUnitService.getTrainingProgramYears(getUser());
		
		try {
			this.pagedAwaitingApproval = this.trainingUnitService.getAwaitingApproval(this.getUser(), 0, 50);
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
					long waitingTAs = this.trainingUnitService.getAwaitingApproval(incomingDelegation, 0, 1).getTotalHits();
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

}
