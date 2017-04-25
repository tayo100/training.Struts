package org.iita.trainingunit.action;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.service.SelectionService;
import org.iita.trainingunit.service.TrainingUnitService;
import org.iita.security.model.User;
import org.iita.security.service.UserService;
import org.iita.service.ExportService;
import org.iita.struts.BaseAction;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

/**
 * @author koraegbunam
 * 
 */

@SuppressWarnings("serial")
public class ProgramListAction extends BaseAction implements Preparable {
	private TrainingUnitService trainingProgramService;
	private UserService userService;
	private ExportService exportService;
	private Long id;
	private Long ownerId;
	protected int startAt = 0, maxResults = 50;
	protected PagedResult<TrainingProgram> paged;
	protected List<TrainingProgram> trainingPrograms;
	private InputStream inputStream;
	private SelectionService selectionService;
	private int exportyear = 0;
	
	/**
	 * @param exportService 
	 * @param traineeService
	 */
	public ProgramListAction(TrainingUnitService trainingProgramService, ExportService exportService) {
		this.trainingProgramService = trainingProgramService;
		this.exportService=exportService;
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
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	
	/**
	 * @return the ownerId
	 */
	public Long getOwnerId() {
		return ownerId;
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
	
	public PagedResult<TrainingProgram> getPaged() {
		return paged;
	}
	
	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}
	
	public List<TrainingProgram> getTrainingPrograms(){
		return trainingPrograms;
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
			this.paged = this.trainingProgramService.getTrainingPrograms(startAt, maxResults);
		else
			this.paged = this.trainingProgramService.getUserTrainingPrograms(getUser(), startAt, maxResults);
	}
	
	/**
	 * Action method to export all Training programs data in XLS file
	 * 
	 * @return
	 */
	public String export() {
		// Export data
		List<? extends TrainingProgram> trainingPrograms = null;
		
		if(getUser().hasRole("ROLE_READALL") || getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_HEAD") || getUser().hasRole("ROLE_QUERYMANAGER"))
			trainingPrograms = this.trainingProgramService.getTrainingProgramsExportList(0).getResults();
		else
			trainingPrograms = this.trainingProgramService.getUserTrainingProgramsExportList(getUser(),0).getResults();

		try {
			this.inputStream = this.exportService.exportToStream(
					new String[] { "ID", "Title", "Program", "Purpose", "Research Location", "Research Country", "Start date", "End date", "Duration", 
							 "Training Description", "Outcome of Training", "No. of Male Participants", "No. of Female Participants", 
							 "Keywords", "Iita Trainer", "External Trainer", "Cost Center" },
					new String[] { "id", "title", "program", "purpose", "location", "country", "startDate", "endDate", "duration", 
							"description", "outcomes", "maleParticipants", "femaleParticipants",
							"keywords", "iitaTrainers", "externalTrainers", "costCenters" }, 
							trainingPrograms);
		} catch (IOException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		return "download";
	}
	
	/**
	 * Action method to export all Training programs data in XLS file
	 * 
	 * @return
	 */
	public String yearlyexport() {
		// Export data
		List<? extends TrainingProgram> trainingPrograms = null;
		
		if(getUser().hasRole("ROLE_READALL") || getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_HEAD") || getUser().hasRole("ROLE_QUERYMANAGER"))
			trainingPrograms = this.trainingProgramService.getTrainingProgramsExportList(this.exportyear).getResults();
		else
			trainingPrograms = this.trainingProgramService.getUserTrainingProgramsExportList(getUser(), this.exportyear).getResults();

		try {
			this.inputStream = this.exportService.exportToStream(
					new String[] { "ID", "Title", "Program", "Purpose", "Research Location", "Research Country", "Start date", "End date", "Duration", 
							 "Training Description", "Outcome of Training", "No. of Male Participants", "No. of Female Participants", 
							 "Keywords", "Iita Trainer", "External Trainer", "Cost Center" },
					new String[] { "id", "title", "program", "purpose", "location", "country", "startDate", "endDate", "duration", 
							"description", "outcomes", "maleParticipants", "femaleParticipants",
							"keywords", "iitaTrainers", "externalTrainers", "costCenters" }, 
							trainingPrograms);
		} catch (IOException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		return "download";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.struts.DownloadableStream#getDownloadFilename()
	 */
	public String getDownloadFileName() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (this.ownerId == null) {
			return "GroupTraining-" + df.format(new Date()) + ".xls";
		} else {
			User user = this.userService.find(this.ownerId);
			return "Training Programs-" + (user == null ? "unknown" : user.getLastName() + "-" + user.getFirstName()) + "-" + df.format(new Date()) + ".xls";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.struts.DownloadableStream#getDownloadStream()
	 */
	public InputStream getDownloadStream() {
		return inputStream;
	}
}	
