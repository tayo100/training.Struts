package org.iita.trainingunit.action;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.iita.crm.model.Partner;
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
 * @author KOraegbunam
 * 
 */

@SuppressWarnings("serial")
public class PartnerListAction extends BaseAction implements Preparable, DownloadableStream {
	private TrainingUnitService partnerService;
	private UserService userService;
	private ExportService exportService;
	private Long id;
	private Long supervisorId;
	protected int startAt = 0, maxResults = 50;
	protected PagedResult<Partner> paged;
	protected List<Partner> partners;
	private InputStream inputStream;
	private SelectionService selectionService;

	/**
	 * @param traineeService
	 * @param exportService
	 */
	public PartnerListAction(TrainingUnitService partnerService, ExportService exportService) {
		this.partnerService = partnerService;
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

	public PagedResult<Partner> getPaged() {
		return paged;
	}

	public List<Partner> getPartners() {
		return partners;
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
		if(getUser().hasRole("ROLE_PARTNERREADALL") || getUser().hasRole("ROLE_PARTNERADMIN") || getUser().hasRole("ROLE_ADMIN"))
			this.paged = this.partnerService.getPartners(startAt, maxResults);
	}

	/**
	 * Action method to export all Trainee data in XLS file
	 * 
	 * @return
	 */
	public String export() {
		// Export data
		List<? extends Partner> partners = null;

		// list all
		if(getUser().hasRole("ROLE_PARTNERREADALL") || getUser().hasRole("ROLE_PARTNERADMIN") || getUser().hasRole("ROLE_ADMIN"))
			partners = this.partnerService.getPartnersExportList().getResults();

		try {
			this.inputStream = this.exportService.exportToStream(
					new String[] { "Full name", "Nationality", "Gender", "DoB", "Start Date", "End Date", "Extension Date", "Duration", "Degree", 
							"Research Location", "University Name", "Univ Supervisor", "Univ Supervisor Email", "Sponsor", 
							"Program", "Cost Center", "Keywords", "Research Topic", "IITA Supervisor" },
							 
					new String[] { "person.fullName", "person.country", "person.gender", "person.dob", "startDate", "EndDate", "extensionDate", "duration", 
							"degree", "location", "university.title", "univSupervisors", "univSupervisorsEmail", "sponsor", "program", "costCenters", "keywords", "researchTopic", "iitaSupervisors" }, 
					partners);
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
			return "Partners-" + df.format(new Date()) + ".xls";
		} else {
			User user = this.userService.find(this.supervisorId);
			return "Partners-" + (user == null ? "unknown" : user.getLastName() + "-" + user.getFirstName()) + "-" + df.format(new Date()) + ".xls";
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
