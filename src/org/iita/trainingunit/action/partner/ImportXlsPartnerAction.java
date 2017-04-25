/**
 * 
 */
package org.iita.trainingunit.action.partner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerPersonContact;
import org.iita.security.Authorize;
import org.iita.service.impl.XLSImportException;
import org.iita.struts.BaseAction;
import org.iita.struts.DownloadableStream;
import org.iita.struts.FileUploadAction;
import org.iita.trainingunit.service.PartnerPortService;
import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author koraegbunam
 *
 */
public class ImportXlsPartnerAction extends BaseAction implements DownloadableStream, FileUploadAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3139989522644797174L;
	private static final String XLSIMPORTDATA__1 = "OO_IMPORTDATA";
	private TrainingUnitService trainingUnitService;
	private PartnerPortService partnerService;
	private List<File> uploads;
	private String type;
	private List<Object[]> existingImports;
	private List<Object[]> allXlsRowData;

	//private int year;

	private List<? extends Partner> partners;
	
	private List<? extends PartnerPersonContact> partnerContacts;

	/**
	 * @param trainingUnitService
	 */
	public ImportXlsPartnerAction(TrainingUnitService trainingUnitService, PartnerPortService partnerService) {
		this.trainingUnitService = trainingUnitService;
		this.partnerService = partnerService;
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
	 * @return the partners
	 */
	public List<? extends Partner> getPartners() {
		return partners;
	}
	
	/**
	 * @return the partnerContacts
	 */
	public List<? extends PartnerPersonContact> getPartnerContacts() {
		return partnerContacts;
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
			
			if (Authorize.hasAny("ROLE_PARTNERADMIN, ROLE_ADMIN")) {
				this.partners = this.partnerService.previewXLSImports(this.uploads.get(0), Partner.class, this.allXlsRowData);
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String save() {
		this.partners = (List<Partner>) ActionContext.getContext().getSession().get(XLSIMPORTDATA__1);
		this.allXlsRowData = (List<Object[]>) ActionContext.getContext().getSession().get(XLSIMPORTDATA__1);
		if (this.allXlsRowData == null) {
			addActionError("No partner to import or already imported.");
			return Action.ERROR;
		}

		try {
			Class clazz = null;
			clazz = Partner.class;
			this.existingImports = new ArrayList<Object[]>();
			this.partnerService.importXLSData(this.allXlsRowData, clazz, this.existingImports);
			addActionMessage("Partner data have been imported");
			ActionContext.getContext().getSession().remove(XLSIMPORTDATA__1);
			return Action.SUCCESS;
		} catch (Exception e) {
			addActionError(e.getMessage());
			LOG.error(e, e);
			return Action.ERROR;
		}
	}
	
	/**
	 * Action executed on XLS file upload
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String uploadcontacts() {
		if (this.uploads == null || this.uploads.size() == 0) {
			addActionError("No file uploaded");
			return Action.ERROR;
		}

		try {
			System.out.println("UPLOAD TEST TYPE: " + this.type);
			this.allXlsRowData = new ArrayList<Object[]>();
			
			if (Authorize.hasAny("ROLE_PARTNERADMIN, ROLE_ADMIN")) {
				this.partnerContacts = this.partnerService.previewContactsXLSImports(this.uploads.get(0), PartnerPersonContact.class, this.allXlsRowData);
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String savecontacts() {
		this.partnerContacts = (List<PartnerPersonContact>) ActionContext.getContext().getSession().get(XLSIMPORTDATA__1);
		this.allXlsRowData = (List<Object[]>) ActionContext.getContext().getSession().get(XLSIMPORTDATA__1);
		if (this.allXlsRowData == null) {
			addActionError("No partner contacts to import or already imported.");
			return Action.ERROR;
		}

		try {
			Class clazz = null;
			clazz = PartnerPersonContact.class;
			this.existingImports = new ArrayList<Object[]>();
			this.partnerService.importContactsXLSData(this.allXlsRowData, clazz, this.existingImports);
			addActionMessage("Partner contacts data have been imported");
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
