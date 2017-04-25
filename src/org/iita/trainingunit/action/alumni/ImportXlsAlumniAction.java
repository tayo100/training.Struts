/**
 * 
 */
package org.iita.trainingunit.action.alumni;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.List;

import org.iita.crm.model.Person;
import org.iita.security.Authorize;
import org.iita.service.impl.XLSImportException;
import org.iita.struts.BaseAction;
import org.iita.struts.DownloadableStream;
import org.iita.struts.FileUploadAction;
import org.iita.trainingunit.model.Alumni;
import org.iita.trainingunit.service.AlumniService;
import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author koraegbunam
 *
 */
public class ImportXlsAlumniAction extends BaseAction implements DownloadableStream, FileUploadAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3139989522644797174L;
	private static final String XLSIMPORTDATA__1 = "OO_IMPORTDATA";
	//private static final String XLSIMPORTDATA__1 = "OO_IMPORTDATA";
	private TrainingUnitService trainingUnitService;
	private AlumniService alumniService;
	private List<File> uploads;
	private String type;
	private List<Object[]> existingImports;
	private List<Object[]> allXlsRowData;

	//private int year;

	private List<? extends Alumni> alumnis;

	/**
	 * @param trainingUnitService
	 */
	public ImportXlsAlumniAction(TrainingUnitService trainingUnitService, AlumniService alumniService) {
		this.trainingUnitService = trainingUnitService;
		this.alumniService = alumniService;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param year the year to set
	 */
	//public void setYear(int year) {
	//	this.year = year;
	//}

	/**
	 * @return the year
	 */
	//public int getYear() {
	//	return this.year;
	//}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return the existingImports
	 */
	public List<Object[]> getExistingImports() {
		return existingImports;
	}

	/**
	 * @param existingImports the existingImports to set
	 */
	public void setExistingImports(List<Object[]> existingImports) {
		this.existingImports = existingImports;
	}

	/**
	 * @return the persons
	 */
	public List<? extends Alumni> getAlumnis() {
		return alumnis;
	}
	
	/**
	 * @param allXlsRowData the allXlsRowData to set
	 */
	public void setAllXlsRowData(List<Object[]> allXlsRowData) {
		this.allXlsRowData = allXlsRowData;
	}

	/**
	 * @return the allXlsRowData
	 */
	public List<Object[]> getAllXlsRowData() {
		return allXlsRowData;
	}
	
	/**
	 * @see org.iita.struts.BaseAction#prepare()
	 */
	@Override
	public void prepare() {
		//this.year = Calendar.getInstance().get(Calendar.YEAR);
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
			System.out.println("UPLOAD TEST TYPE: " + this.type);
			this.allXlsRowData = new ArrayList<Object[]>();
			
			if (Authorize.hasAny("ROLE_ADMIN, ROLE_CDO, ROLE_CDOMANAGER")) {
				this.alumnis = this.alumniService.previewXLSImports(this.uploads.get(0), Alumni.class, this.allXlsRowData);
			}

			ActionContext.getContext().getSession().put(XLSIMPORTDATA__1, this.allXlsRowData);
			//ActionContext.getContext().getSession().put(XLSIMPORTDATA__1, this.allXlsRowData);
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
		this.alumnis = (List<Alumni>) ActionContext.getContext().getSession().get(XLSIMPORTDATA__1);
		this.allXlsRowData = (List<Object[]>) ActionContext.getContext().getSession().get(XLSIMPORTDATA__1);
		if (this.allXlsRowData == null) {
			addActionError("No alumni to import or already imported.");
			return Action.ERROR;
		}

		try {
			Class clazz = null;
			clazz = Alumni.class;
			this.existingImports = new ArrayList<Object[]>();
			this.alumniService.importXLSData(this.allXlsRowData, clazz, this.existingImports);
			addActionMessage("Alumni data have been imported");
			ActionContext.getContext().getSession().remove(XLSIMPORTDATA__1);
			return Action.SUCCESS;
		} catch (Exception e) {
			addActionError(e.getMessage());
			LOG.error(e, e);
			return Action.ERROR;
		}
	}

	@Override
	public String getDownloadFileName() {
		return null;
	}

	@Override
	public InputStream getDownloadStream() {
		return null;
	}

	@Override
	public void setUploads(List<File> uploads) {
		this.uploads = uploads;
	}

	@Override
	public void setUploadsContentType(List<String> uploadContentTypes) {

	}

	@Override
	public void setUploadsFileName(List<String> uploadFileNames) {

	}
}
