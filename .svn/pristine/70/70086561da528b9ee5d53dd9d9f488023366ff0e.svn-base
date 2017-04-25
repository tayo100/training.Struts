package org.iita.trainingunit.applications.action;

import org.iita.crm.action.BaseAction;
import org.iita.trainingunit.applications.model.Unsolicited;
import org.iita.trainingunit.applications.service.UnsolicitedService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class UnsolicitedAction extends BaseAction implements Preparable  {
	private static final long serialVersionUID = 1776860632792242064L;
	UnsolicitedService unsolicitedService;
	private PagedResult<? extends Unsolicited> paged;
	protected int startAt = 0, maxResults = 50;
	private Long id;	
	
	public UnsolicitedAction(UnsolicitedService unsolicitedService) {
		this.unsolicitedService = unsolicitedService;
	}
	
	public String execute() {
		return Action.SUCCESS;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PagedResult<? extends Unsolicited> getPaged() {
		return paged;
	}
}