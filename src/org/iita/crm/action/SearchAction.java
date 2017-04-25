/**
 * training.Struts Feb 4, 2010
 */
package org.iita.crm.action;

import org.iita.service.SearchException;
import org.iita.service.SearchService;
import org.iita.struts.BaseAction;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;

/**
 * @author mobreza
 * @author koraegbunam
 */
@SuppressWarnings("serial")
public class SearchAction extends BaseAction {
	/**
	 * 
	 */
	private static final String[] FIELDS = new String[] { "" };
	private String queryString = null;
	private String entityType = null;
	private SearchService<?> searchService;
	private int startAt = 0;
	private int maxResults = 20;
	private PagedResult<?> paged;

	/**
	 * @param searchService
	 * 
	 */
	public SearchAction(SearchService<?> searchService) {
		this.searchService = searchService;
	}


	/**
	 * @param entityType the entityType to set
	 */
	public void setEnt(String entityType) {
		this.entityType = entityType;
	}

	/**
	 * @return the entityType
	 */
	public String getEnt() {
		return this.entityType;
	}

	/**
	 * @param queryString the queryString to set
	 */
	public void setQ(String queryString) {
		this.queryString = queryString;
	}

	/**
	 * @return the queryString
	 */
	public String getQueryString() {
		return this.queryString;
	}

	/**
	 * @return the results
	 */
	public PagedResult<?> getPaged() {
		return this.paged;
	}
	
	/**
	 * @param startAt the startAt to set
	 */
	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}

	/**
	 * @see org.iita.struts.BaseAction#execute()
	 */
	@Override
	public String execute() {
		try {
			Class<?> clazz = null;
			if (this.entityType != null && this.entityType.trim().length() > 0) {
				try {
	                clazz = Class.forName(this.entityType);
                } catch (ClassNotFoundException e) {
                	LOG.warn("Invalid entity for search: " + this.entityType);
                }
			}
			if (clazz != null)
				this.paged = this.searchService.search(this.queryString, clazz, FIELDS, startAt, maxResults);
			else
				this.paged = this.searchService.search(this.queryString, FIELDS, startAt, maxResults);
		} catch (SearchException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		LOG.info("Got search results");
		return Action.SUCCESS;
	}
}
