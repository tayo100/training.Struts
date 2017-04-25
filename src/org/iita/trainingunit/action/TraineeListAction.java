package org.iita.trainingunit.action;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.iita.trainingunit.model.Trainee;
import org.iita.security.model.User;
import org.iita.security.service.UserService;
import org.iita.service.ExportService;
import org.iita.struts.BaseAction;
import org.iita.struts.DownloadableStream;
import org.iita.trainingunit.service.SelectionService;
import org.iita.trainingunit.service.TrainingUnitService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

/**
 * @author koraegbunam
 * 
 */

@SuppressWarnings("serial")
public class TraineeListAction extends BaseAction implements Preparable, DownloadableStream {
	private TrainingUnitService traineeService;
	private UserService userService;
	private ExportService exportService;
	private Long id;
	private Long supervisorId;
	protected int startAt = 0, maxResults = 50;
	protected PagedResult<Trainee> paged;
	protected List<Trainee> trainees;
	private InputStream inputStream;
	private SelectionService selectionService;
	private int exportyear = 0;

	/**
	 * @param traineeService
	 * @param exportService
	 */
	public TraineeListAction(TrainingUnitService traineeService, ExportService exportService) {
		this.traineeService = traineeService;
		this.exportService = exportService;
	}
	
	public void setSelectionService(SelectionService selectionService) {
		this.selectionService = selectionService;
	}
	
	/**
	 * @return the selectionService
	 */
	public SelectionService getSelectionService() {
		return this.selectionService;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param exportyear the exportyear to set
	 */
	public void setExportyear(int exportyear) {
		this.exportyear = exportyear;
	}

	/**
	 * @return the exportyear
	 */
	public int getExportyear() {
		return exportyear;
	}

	/**
	 * @param ownerId the ownerId to set
	 */
	public void setSupervisorId(Long supervisorId) {
		this.supervisorId = supervisorId;
	}

	/**
	 * @return the supervisorId
	 */
	public Long getSupervisorId() {
		return supervisorId;
	}

	public PagedResult<Trainee> getPaged() {
		return paged;
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	@Override
	public void prepare() {
		super.prepare();
		if(getUser().hasRole("ROLE_READALL") || getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_HEAD") || getUser().hasRole("ROLE_QUERYMANAGER"))
			this.paged = this.traineeService.getTrainees(startAt, maxResults);
		else
			this.paged = this.traineeService.getUserTrainees(getUser(), startAt, maxResults);
	}

	/**
	 * Action method to export all Trainee data in XLS file
	 * 
	 * @return
	 */
	public String export() {
		// Export data
		List<? extends Trainee> trainees = null;

		// list all
		if(getUser().hasRole("ROLE_READALL") || getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_HEAD") || getUser().hasRole("ROLE_QUERYMANAGER"))
			trainees = this.traineeService.getTraineesExportList(0).getResults();
		else
			trainees = this.traineeService.getUserTraineesExportList(getUser(), 0).getResults();

		try {
			this.inputStream = this.exportService.exportToStream(
					new String[] { "Full name", "Nationality", "Gender", "DoB", "Start Date", "End Date", "Extension Date", "Duration", "Degree", 
							"Research Location", "Research Country", "University Name", "Univ Supervisor", "Univ Supervisor Email", "Sponsor", 
							"Program", "Cost Center", "Keywords", "Research Topic", "IITA Supervisor" },
							 
					new String[] { "person.fullName", "person.country", "person.gender", "person.dob", "startDate", "EndDate", "extensionDate", "duration", 
							"degree", "location", "country", "university.title", "univSupervisors", "univSupervisorsEmail", "sponsor", "program", "costCenters", "keywords", "researchTopic", "iitaSupervisors" }, 
					trainees);
		} catch (IOException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		return "download";
	}
	
	/**
	 * Action method to export all Trainee data in XLS file
	 * 
	 * @return
	 */
	public String yearlyexport() {
		// Export data
		List<? extends Trainee> trainees = null;

		// list all
		if(getUser().hasRole("ROLE_READALL") || getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_HEAD") || getUser().hasRole("ROLE_QUERYMANAGER"))
			trainees = this.traineeService.getTraineesExportList(this.exportyear).getResults();
		else
			trainees = this.traineeService.getUserTraineesExportList(getUser(),this.exportyear).getResults();

		try {
			this.inputStream = this.exportService.exportToStream(
					new String[] { "Full name", "Nationality", "Gender", "DoB", "Start Date", "End Date", "Extension Date", "Duration", "Degree", 
							"Research Location", "Research Country", "University Name", "Univ Supervisor", "Univ Supervisor Email", "Sponsor", 
							"CRP", "Cost Center", "Keywords", "Research Topic", "IITA Supervisor" },
							 
					new String[] { "person.fullName", "person.country", "person.gender", "person.dob", "startDate", "EndDate", "extensionDate", "duration", 
							"degree", "location", "country", "university.title", "univSupervisors", "univSupervisorsEmail", "sponsor", "ExportCrps", "costCenters", "keywords", "researchTopic", "iitaSupervisors" }, 
					trainees);
		} catch (IOException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		return "download";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.par.action.training.DownloadableStream#getDownloadFilename()
	 */
	public String getDownloadFileName() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (this.supervisorId == null) {
			return "Trainees-" + df.format(new Date()) + ".xls";
		} else {
			User user = this.userService.find(this.supervisorId);
			return "Trainees-" + (user == null ? "unknown" : user.getLastName() + "-" + user.getFirstName()) + "-" + df.format(new Date()) + ".xls";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.par.action.training.DownloadableStream#getDownloadStream()
	 */
	public InputStream getDownloadStream() {
		return inputStream;
	}
}
