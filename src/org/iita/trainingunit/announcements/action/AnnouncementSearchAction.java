package org.iita.trainingunit.announcements.action;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.iita.crm.action.BaseAction;
import org.iita.service.ExportService;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.service.AnnouncementService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;

public class AnnouncementSearchAction extends BaseAction {
	private static final long serialVersionUID = 5385236433436328030L;
	private ExportService exportService;
	private String details;
	private Date fromDate;
	private Date toDate;
	private PagedResult<?> paged;
	protected AnnouncementService announcementService;
	private PagedResult<Announcement> pagedAnnouncement;
	protected int startAt = 0, maxResults = 50;
	private InputStream inputStream;
	
	//private EntityManager entityManager;
	/*
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}*/

	public AnnouncementSearchAction(AnnouncementService announcementService) {
		this.announcementService = announcementService;
		/**
		 * this.exportService = exportService;
		 */
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iita.par.action.training.DownloadableStream#getDownloadStream()
	 */
	public InputStream getDownloadStream() {
		return inputStream;
	}
	
	public String export() {
		List<Announcement> announcementList = this.announcementService.search(this.details, this.fromDate, this.toDate);;
		
		try{
			if(announcementList!=null){
				this.inputStream = this.exportService.exportToStream(
					new String[] { "Type", "Title" },
							 
					new String[] { "type", "title" }, 
					announcementList);
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
	
	public PagedResult<?> getPaged() {
		return paged;
	}
	
	public String query(){
		if(this.details.isEmpty() && this.fromDate==null && this.toDate==null){			
			addActionError("No query criteria supplied!");
			return Action.ERROR;
		}else{
			this.paged = this.announcementService.search(this.details, this.fromDate, this.toDate, this.startAt, this.maxResults);
			//addActionError("Cool!");
			return Action.SUCCESS;
		}
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setPagedAnnouncement(PagedResult<Announcement> pagedAnnouncement) {
		this.pagedAnnouncement = pagedAnnouncement;
	}

	public PagedResult<Announcement> getPagedAnnouncement() {
		return pagedAnnouncement;
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
}