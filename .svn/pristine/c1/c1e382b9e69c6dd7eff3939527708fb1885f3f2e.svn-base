package org.iita.trainingunit.announcements.action;

import org.iita.crm.action.BaseAction;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.service.IframeSearchService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;

public class IframeSearchAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	protected IframeSearchService iframeSearchService;
	private PagedResult<?> paged;
	protected int startAt = 0, maxResults = 50;
	private PagedResult<Announcement> pagedAnnouncement;
	private String ask;
	
	public IframeSearchAction(IframeSearchService iframeSearchService) {
		this.iframeSearchService = iframeSearchService;
	}
	
	public String execute(){
		return Action.SUCCESS;
	}
	
	public String details() {
		System.out.println("Result: " + this.ask);
		if(this.ask != null){
			this.pagedAnnouncement = this.iframeSearchService.searchAnnouncement(ask, startAt, maxResults);
		}
		return Action.SUCCESS;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public String getAsk() {
		return ask;
	}

	public void setPagedAnnouncement(PagedResult<Announcement> pagedAnnouncement) {
		this.pagedAnnouncement = pagedAnnouncement;
	}

	public PagedResult<Announcement> getPagedAnnouncement() {
		return pagedAnnouncement;
	}

	public void setPaged(PagedResult<?> paged) {
		this.paged = paged;
	}

	public PagedResult<?> getPaged() {
		return paged;
	}	
}