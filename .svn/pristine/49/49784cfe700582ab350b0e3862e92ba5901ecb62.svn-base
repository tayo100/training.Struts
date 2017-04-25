package org.iita.trainingunit.action;

import java.io.InputStream;
import java.util.Date;

import org.iita.crm.action.BaseAction;
import org.iita.crm.model.Organization;
import org.iita.struts.DownloadableStream;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.Trainer;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Preparable;

public class InternalUsersSearch extends BaseAction implements Preparable, DownloadableStream {
	private static final long serialVersionUID = 924636809483264410L;
	private String table;
	private String text;
	private Date startDate;
	private Date endDate;
	private boolean fullText;
	private PagedResult<Trainee> pagedTrainee;
	private PagedResult<TrainingProgram> pagedPrograms;
	private PagedResult<Organization> pagedOrg;
	private PagedResult<Trainer> pagedTrainer;
	protected int startAt = 0, maxResults = 50;
	private InputStream inputStream;

	@Override
	public String getDownloadFileName() {
		return null;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isFullText() {
		return fullText;
	}

	public void setFullText(boolean fullText) {
		this.fullText = fullText;
	}

	public PagedResult<Trainee> getPagedTrainee() {
		return pagedTrainee;
	}

	public void setPagedTrainee(PagedResult<Trainee> pagedTrainee) {
		this.pagedTrainee = pagedTrainee;
	}

	public PagedResult<TrainingProgram> getPagedPrograms() {
		return pagedPrograms;
	}

	public void setPagedPrograms(PagedResult<TrainingProgram> pagedPrograms) {
		this.pagedPrograms = pagedPrograms;
	}

	public PagedResult<Organization> getPagedOrg() {
		return pagedOrg;
	}

	public void setPagedOrg(PagedResult<Organization> pagedOrg) {
		this.pagedOrg = pagedOrg;
	}

	public PagedResult<Trainer> getPagedTrainer() {
		return pagedTrainer;
	}

	public void setPagedTrainer(PagedResult<Trainer> pagedTrainer) {
		this.pagedTrainer = pagedTrainer;
	}

	public int getStartAt() {
		return startAt;
	}

	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public InputStream getDownloadStream() {
		return null;
	}

}