/**
 * 
 */
package org.iita.trainingunit.action.partner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.iita.crm.action.BaseAction;
import org.iita.crm.model.Partner;
import org.iita.struts.DownloadableStream;
import org.iita.trainingunit.service.PartnerPortService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

/**
 * @author koraegbunam
 *
 */
public class PartnerAction extends BaseAction implements Preparable, DownloadableStream {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7350759636698890958L;
	/**
	 * Partner service
	 */
	protected PartnerPortService partnerService;
	private int year;
	private InputStream downloadStream;
	private List<Partner> partners;
	private List<Object[]> allRowData;
	protected int startAt = 0, maxResults = 50;
	protected PagedResult<Partner> paged;
	private Long id;
	private String source = "unknown";
	private Long sourceId;
	
	/**
	 * @param alumniService
	 */
	public PartnerAction(PartnerPortService partnerService) {
		this.partnerService = partnerService;
	}
	
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return this.year;
	}
	
	/**
	 * @return the partners
	 */
	public List<Partner> getPartners() {
		return this.partners;
	}
	
	public PagedResult<Partner> getPaged() {
		return paged;
	}

	/**
	 * @return the allRowData
	 */
	public List<Object[]> getAllRowData() {
		return allRowData;
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
	 * @param sourceId the sourceId to set
	 */
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @return the sourceId
	 */
	public Long getSourceId() {
		return sourceId;
	}
	
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	
	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}
	
	/**
	 * @see org.iita.struts.BaseAction#prepare()
	 */
	@Override
	public void prepare() {
		super.prepare();
		this.year = Calendar.getInstance().get(Calendar.YEAR);
		this.paged = this.partnerService.list(startAt, maxResults);
	}

	/**
	 * Default action -- defaults to displaying who's appraising who
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() {
		LOG.info("TESING PARTNER LOADING");
		//this.alumnis = this.alumniService.list();
		return Action.SUCCESS;
	}

	/**
	 * Action to export alumni data in XLS
	 * 
	 * @return
	 */
	public String download() {
		// get data
		this.partners = this.partnerService.list();
		try {
			this.downloadStream = this.partnerService.exportPartnerData(this.partners);
		} catch (IOException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}

		return "download";
	}

	@Override
	public String getDownloadFileName() {
		return String.format("partner-list %2$d-%1$tY%1$tm%1$td.xls", new Date(), getYear());
	}

	@Override
	public InputStream getDownloadStream() {
		return this.downloadStream;
	}
	
	public String delete(){
		Partner p =this.partnerService.getPartnerInfo(this.id);
		if(p!=null){
			this.partnerService.deletePartner(p);
			addActionMessage("Partner record deleted!");
		}else{
			addActionError("No partner record found for deletion!");
		}
		
		return source;
	}
}
