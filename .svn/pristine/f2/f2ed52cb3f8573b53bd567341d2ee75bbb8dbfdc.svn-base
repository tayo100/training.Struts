package org.iita.trainingunit.applications.action;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.iita.crm.action.BaseAction;
import org.iita.security.model.User;
import org.iita.service.ExportService;
import org.iita.struts.DownloadableStream;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.service.ApplicationSearchService;
import org.iita.trainingunit.model.Trainee;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class ApplicationSearchAction extends BaseAction implements Preparable, DownloadableStream{
	private static final long serialVersionUID = -6289537593678842845L;
	private String details;
	private Date fromDate;
	private Date toDate;
	private String majorFieldOfStudy;
	private String trainingType;
	private String nationality;
	private String degree;
	private Date dobFromDate;
	private Date dobToDate;	
	
	private PagedResult<?> paged;
	protected ApplicationSearchService applicationSearchService;
	private ExportService exportService;
	protected int startAt = 0, maxResults = 50;
	private InputStream inputStream;
	
	public ApplicationSearchAction(ApplicationSearchService applicationSearchService, ExportService xlsExportService) {
		this.applicationSearchService = applicationSearchService;
		this.exportService = xlsExportService;
	}
	
	public String export() {
		List<? extends Application> applicationList = null;
		
		applicationList = this.applicationSearchService.search(this.details, this.fromDate, this.toDate, this.majorFieldOfStudy, this.trainingType, this.nationality, this.degree, this.dobFromDate, this.dobToDate).getResults();
		
		for(Application app : applicationList)
			System.out.println("TYPE: " + app.getAnnouncement().getType());
		
		try{
			if(applicationList!=null){
				this.inputStream = this.exportService.exportToStream(
					new String[] { "Type", "ReferenceNo", "Title", "Name", "Approval Status", "Submission Status", "Nationality", "DoB", "RegDate",
							"Correspondence EmailAddress", "Correspondence Cellular", "Correspondence Address",
							"Correspondence City", "Correspondence State", "Correspondence PostalCode",
							"Correspondence Country", "Correspondence Telephone", "Permanent Address",
							"Permanent City", "Permanent State", "Permanent PostalCode", "Permanent Country",
							"Next of Kin Name", "Next of Kin Address", "Next of Kin Relationship", "Next of Kin TelNo"},
							 
					new String[] { "announcement.type", "refNumber", "biodata.title", "biodata.fullName", "status", "submissionStatus", "biodata.nationality", 
							"biodata.dateOfBirth", "biodata.signedOn",
							"biodata.correspondenceEmailAddress", "biodata.correspondenceCellular", "biodata.correspondenceAddress",
							"biodata.correspondenceCity", "biodata.correspondenceState", "biodata.correspondencePostalCode",
							"biodata.correspondenceCountry", "biodata.correspondenceTelephone", "biodata.permanentAddress",
							"biodata.permanentCity", "biodata.permanentState", "biodata.permanentPostalCode", "biodata.permanentCountry",
							"biodata.nextOfKinName", "biodata.nextOfKinAddrs", "biodata.nextOfKinRelationship", "biodata.nextOfKinTelNo"}, 
					applicationList);
			}
		}catch(Exception e){
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		
		return "download";
	}
	
	public String execute() {
		return Action.SUCCESS;
	}
	
	public String query(){
		if(this.details==null && this.fromDate==null && this.toDate==null){			
			addActionError("No query criteria supplied!");
			return Action.ERROR;
		}else{
			//System.out.println(this.details);
			//System.out.println(this.fromDate);
			//System.out.println("DEGREE ACTION VALUE: " + this.degree);
			this.paged = this.applicationSearchService.search(this.details, this.fromDate, this.toDate, this.majorFieldOfStudy, this.trainingType, this.nationality, this.degree, this.dobFromDate, this.dobToDate, this.startAt, this.maxResults);
			return Action.SUCCESS;
		}
	}
	
	public PagedResult<?> getPaged() {
		return paged;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDetails() {
		return details;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Date getToDate() {
		return toDate;
	}

	/**
	 * @return the majorFieldOfStudy
	 */
	public String getMajorFieldOfStudy() {
		return majorFieldOfStudy;
	}

	/**
	 * @param majorFieldOfStudy the majorFieldOfStudy to set
	 */
	public void setMajorFieldOfStudy(String majorFieldOfStudy) {
		this.majorFieldOfStudy = majorFieldOfStudy;
	}

	/**
	 * @return the trainingType
	 */
	public String getTrainingType() {
		return trainingType;
	}

	/**
	 * @param trainingType the trainingType to set
	 */
	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * @return the dobFromDate
	 */
	public Date getDobFromDate() {
		return dobFromDate;
	}

	/**
	 * @param dobFromDate the dobFromDate to set
	 */
	public void setDobFromDate(Date dobFromDate) {
		this.dobFromDate = dobFromDate;
	}

	/**
	 * @return the dobToDate
	 */
	public Date getDobToDate() {
		return dobToDate;
	}

	/**
	 * @param dobToDate the dobToDate to set
	 */
	public void setDobToDate(Date dobToDate) {
		this.dobToDate = dobToDate;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.par.action.training.DownloadableStream#getDownloadFilename()
	 */
	public String getDownloadFileName() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return "Applications-" + "-" + df.format(new Date()) + ".xls";
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