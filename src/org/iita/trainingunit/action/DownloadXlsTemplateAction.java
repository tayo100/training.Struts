package org.iita.trainingunit.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.iita.service.impl.XLSImportException;
import org.iita.struts.BaseAction;
import org.iita.struts.DownloadableStream;
import org.iita.struts.FileUploadAction;
import org.iita.trainingunit.model.Attendance;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * Action use in downloading and uploading xls template file for group trainings
 * 
 * @author koraegbunam
 * */
@SuppressWarnings("serial")
public class DownloadXlsTemplateAction extends BaseAction implements DownloadableStream, FileUploadAction {
	private static final String XLSIMPORTDATA__1 = "OO_IMPORTDATA";
	private TrainingUnitService service;
	private List<File> uploads;

	private InputStream downloadStream;
	private List<Attendance> attendance;
	private Long id;
	private TrainingProgram group;
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(TrainingProgram group) {
		this.group = group;
	}
	
	/**
	 * @return the group
	 */
	public TrainingProgram getGroup() {
		return group;
	}
	
	/**
	 * @return the attendance
	 */
	public List<Attendance> getAttendance() {
		return this.attendance;
	}
	
	/**
	 * @param service
	 * 
	 */
	public DownloadXlsTemplateAction (TrainingUnitService service) {
		this.service = service;
	}
	
	/**
	 * @see org.iita.struts.BaseAction#prepare()
	 */
	@Override
	public void prepare() {
		this.group = (TrainingProgram) this.service.find(TrainingProgram.class, this.id);
	}

	/**
	 * Default action method will render the Download/Upload form
	 * 
	 * @see org.iita.struts.BaseAction#execute()
	 */
	@Override
	public String execute() {
		return Action.SUCCESS;
	}
	
	/**
	 * @see org.iita.struts.FileDownloadAction#download()
	 */
	public String download() {
		try {
			this.downloadStream = this.service.getXLSTemplateStream(this.group);
			return "download";
		} catch (IOException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
	}
	
	/**
	 * @see org.iita.struts.FileDownloadAction#downloadPdf()
	 */
	public String downloadPdf() {
		try {
			this.downloadStream = this.service.getPDFTemplateStream();
			return "download";
		} catch (IOException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
	}

	
	/**
	 * @see org.iita.struts.DownloadableStream#getDownloadFileName()
	 */
	@Override
	public String getDownloadFileName() {
		return "IITA-Timesheets-" + String.format("%1$tY-%1$tm-%1$td", new Date()) + ".xls";
	}
	
	/**
	 * Downloading PDF template for attendance
	 */
	public String getDownloadPdfFileName() {
		return "IITA-AttendantSheets-" + String.format("%1$tY-%1$tm-%1$td", new Date()) + ".pdf";
	}
	
	/**
	 * @see org.iita.struts.DownloadableStream#getDownloadStream()
	 */
	@Override
	public InputStream getDownloadStream() {
		return this.downloadStream;
	}
	
	/**
	 * Action executed on XLS file upload
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String upload() {
		if (this.uploads == null || this.uploads.size() == 0) {
			addActionError("No file uploaded");
			return Action.ERROR;
		}

		try {
			this.attendance = this.service.previewXLSAttendance(this.group, this.uploads.get(0));
			
			ActionContext.getContext().getSession().put(XLSIMPORTDATA__1, this.attendance);
		} catch (FileNotFoundException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		} catch (IOException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		} catch (XLSImportException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String save() {
		this.attendance = (List<Attendance>) ActionContext.getContext().getSession().get(XLSIMPORTDATA__1);
		if (this.attendance == null) {
			addActionError("No attendance to import or already imported.");
			return Action.ERROR;
		}
		this.service.importXLSAttendance(this.attendance);
		addActionMessage("Attendance have been imported");
		ActionContext.getContext().getSession().remove(XLSIMPORTDATA__1);
		return Action.SUCCESS;
	}
	
	/**
	 * @see org.iita.struts.FileUploadAction#setUploads(java.util.List)
	 */
	@Override
	public void setUploads(List<File> uploads) {
		this.uploads = uploads;
	}

	/**
	 * @see org.iita.struts.FileUploadAction#setUploadsContentType(java.util.List)
	 */
	@Override
	public void setUploadsContentType(List<String> uploadContentTypes) {
		
		
	}

	/**
	 * @see org.iita.struts.FileUploadAction#setUploadsFileName(java.util.List)
	 */
	@Override
	public void setUploadsFileName(List<String> uploadFileNames) {
		
		
	}
	
}
