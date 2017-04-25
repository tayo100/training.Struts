/**
 * 
 */
package org.iita.trainingunit.action;

//import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.iita.service.ExportService;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.service.TrainingUnitService;
import org.iita.trainingunit.service.SelectionService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * Bean managing selected lots.
 * 
 * @author koraegbunam
 * 
 */
public class SelectionAction extends ActionSupport implements Preparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SelectionService selectionService;
	private TrainingUnitService service;
	private ExportService exportService;
	
	private List<Trainee> trainees = null;
	private List<TrainingProgram> trainingPrograms = null;
	private String referer;
	private Long parsedId;
	private InputStream inputStream;
	private String targetExport;
	//private List<Integer> ids = new ArrayList<Integer>();

	/**
	 * @return the referer
	 */
	public String getReferer() {
		return this.referer;
	}

	/**
	 * @param referer the referer to set
	 */
	public void setReferer(String referer) {
		this.referer = referer;
	}
	
	public void setParsedId(Long parsedId) {
		this.parsedId = parsedId;
	}

	public Long getParsedId() {
		return parsedId;
	}

	///**
	// * @param ids the ids to set
	// */
	//public void setId(List<Integer> ids) {
	//	this.ids = ids;
	//}

	public SelectionAction(TrainingUnitService service, SelectionService selectionService, ExportService exportService) {
		this.service = service;
		this.selectionService = selectionService;
		this.exportService=exportService;
	}

	/**
	 * @param targetExport the targetExport to set
	 */
	public void setTargetExport(String targetExport) {
		this.targetExport = targetExport;
	}

	/**
	 * @return the targetExport
	 */
	public String getTargetExport() {
		return targetExport;
	}

	/**
	 * @return the selectionService
	 */
	public SelectionService getSelectionService() {
		return this.selectionService;
	}

	/**
	 * Get selected Trainees
	 * 
	 * @return
	 */
	public Collection<Trainee> getTrainees() {
		return this.trainees;
	}
	
	/**
	 * Get selected TrainingPrograms
	 * 
	 * @return
	 */
	public Collection<TrainingProgram> getTrainingPrograms() {
		return this.trainingPrograms;
	}

	/** Default action */
	public String execute() {
		try {
			//this.selectionService.traineeContains(id);
			this.trainees = this.service.getTrainees(this.selectionService.getSelectedList().getSelectedTrainees());
			this.trainingPrograms = this.service.getTrainingPrograms(this.selectionService.getSelectedList().getSelectedTrainingPrograms());
			return Action.SUCCESS;
		} 
		catch (Exception e){
			addActionError("Selection empty!.");
			return Action.INPUT;
		}
	}

	/** Clear Trainees selection */
	public String clearAllTrainees() {
		this.selectionService.getSelectedList().clearTraineeSelection();
		System.err.println("Trainee Selection contains: " + this.selectionService.getSelectedList().getTraineeSize());
		execute();
		return "refresh";
	}
	
	/** Clear TrainingPrograms selection */
	public String clearAllTrainingPrograms() {
		this.selectionService.getSelectedList().clearTrainingProgramSelection();
		System.err.println("Group Training Selection contains: " + this.selectionService.getSelectedList().getTrainingProgramSize());
		execute();
		return "refresh";
	}

	/** Remove item from selection */
	public String removeTrainee() {
		try {
			String[] ids = (String[]) ActionContext.getContext().getParameters().get("id");
			for (String id : ids) {
				Long traineeId = new Long(id);
				this.selectionService.getSelectedList().removeTraineeSelection(traineeId);
			}
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		return "goback";
	}

	/** Add item to Trainee selection */
	public String addTrainee() {
		try {
			String[] ids = (String[]) ActionContext.getContext().getParameters().get("id");
			//LOG.debug(ids.size() + " size for KENNETH");
			for (String id : ids) {
				Long traineeId = new Long(id);
				//LOG.debug(traineeId + " size for KENNETH");
				this.selectionService.getSelectedList().addTraineeSelection(traineeId);
			}
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		return "goback";
	}
	
	/** Remove item from TrainingProgram selection */
	public String removeTrainingProgram() {
		try {
			String[] ids = (String[]) ActionContext.getContext().getParameters().get("id");
			for (String id : ids) {
				Long groupId = new Long(id);
				this.selectionService.getSelectedList().removeTrainingProgramSelection(groupId);
			}
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		return "goback";
	}

	/** Add item to TrainingProgram selection */
	public String addTrainingProgram() {
		try {
			String[] ids = (String[]) ActionContext.getContext().getParameters().get("id");
			for (String id : ids) {
				Long groupId = new Long(id);
				this.selectionService.getSelectedList().addTrainingProgramSelection(groupId);
			}
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		return "goback";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	@Override
	public void prepare() throws Exception {
		String referer = ServletActionContext.getRequest().getHeader("Referer");
		if (referer != null) {
			this.referer = referer;
		}
	}
	
	/**
	 * Action method to export all Training programs data in XLS file
	 * 
	 * @return
	 */
	public String exportGroup() {
		this.targetExport = "group";
		// Export data
		List<? extends TrainingProgram> trainingPrograms = null;
	
		trainingPrograms = this.service.getTrainingPrograms(this.selectionService.getSelectedList().getSelectedTrainingPrograms());
		
		try {
			this.inputStream = this.exportService.exportToStream(
					new String[] { "ID", "Program", "Title", "Location", "Start date", "End date", 
							 "Training Description", "Outcome of Training", "No. of Male Participants", "No. of Female Participants", 
							 "Keywords", "Created Date", "Created by", "Last updated", "Updated by" },
					new String[] { "id", "program", "title", "location", "startDate", "endDate", 
							"description", "outcomes", "maleParticipants", "femaleParticipants",
							"keywords", "createdDate", "createdBy", "lastUpdated", "lastUpdatedBy" }, 
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
	public String exportTrainee() {
		this.targetExport = "trainee";
		// Export data
		List<? extends Trainee> trainees = null;

		// list all
		trainees = this.service.getTrainees(this.selectionService.getSelectedList().getSelectedTrainees());

		try {
			this.inputStream = this.exportService.exportToStream(
					new String[] { "ID", "Full name", "Research Topic", "Location", "Start Date", "End Date", "Gender", "Extension Date", 
							 "Program", "Discipline", "Country", "Keywords", "University Name", "Degree", "Deg. Award Date",
							 "Created Date", "Created by", "Last updated", "Updated by" },
							 
					new String[] { "id", "person.fullName", "researchTopic", "location", "startDate", "EndDate", "person.gender", "extensionDate", 
							"program", "discipline", "country", "keywords", "university.title", "degree", "degreeAwardDate", 
							"createdDate", "createdBy", "lastUpdated", "lastUpdatedBy" }, 
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
	 * @see org.iita.struts.DownloadableStream#getDownloadFilename()
	 */
	public String getDownloadFileName() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (this.targetExport == "group")
			return "GroupTraining-" + df.format(new Date()) + ".xls";
		else if(this.targetExport == "trainee") 
			return "Trainees-" + df.format(new Date()) + ".xls";
		else
			return null;
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
