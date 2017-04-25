package org.iita.trainingunit.action;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.iita.crm.model.Partner;
import org.iita.service.ExportService;
import org.iita.trainingunit.service.PartnerPortService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * Action use in downloading and uploading xls template file for group trainings
 * 
 * @author koraegbunam
 * */
@SuppressWarnings("serial")
public class DownloadPartnerXlsTemplateAction extends ActionSupport implements Preparable {
	private PartnerPortService service;
	private ExportService exportService;
	
	private InputStream inputStream;

	private List<Partner> partner;
	private String lastName;
	private String firstName;
	private String researchTopic;
	private Date fromDate;
	private Date toDate;
	private String org;
	

	/**
	 * @param partner the partner to set
	 */
	public void setPartner(List<Partner> partner) {
		this.partner = partner;
	}

	/**
	 * @return the partner
	 */
	public List<Partner> getPartner() {
		return partner;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the researchTopic
	 */
	public String getResearchTopic() {
		return researchTopic;
	}

	/**
	 * @param researchTopic the researchTopic to set
	 */
	public void setResearchTopic(String researchTopic) {
		this.researchTopic = researchTopic;
	}

	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the org
	 */
	public String getOrg() {
		return org;
	}

	/**
	 * @param org the org to set
	 */
	public void setOrg(String org) {
		this.org = org;
	}
	
	
	/**
	 * @param service
	 * 
	 */
	public DownloadPartnerXlsTemplateAction (PartnerPortService service, ExportService exportService) {
		this.service = service;
		this.exportService=exportService;
	}
	
	/**
	 * @see org.iita.struts.BaseAction#prepare()
	 */
	@Override
	public void prepare() {
		this.partner = this.service.search(this.org);
	
		//for(Partner a : this.partner){
		//	System.out.println("LINE 154 - PHONE: " + a.getPerson().getPhoneContacts());
		//}
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
		if(this.partner!=null){			
			try {
				this.inputStream = this.exportService.exportToStream(
						new String[] { "Title", "ShortName" },
						new String[] { "title", "shortName" }, 
								this.partner);
			} catch (IOException e) {
				addActionError(e.getMessage());
				return Action.ERROR;
			}
			
			return "download";
		}else{
			addActionMessage("Not record match found!");
			return Action.ERROR;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.struts.DownloadableStream#getDownloadFilename()
	 */
	public String getDownloadFileName() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return "IITA-Partner-" + df.format(new Date()) + ".xls";
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
