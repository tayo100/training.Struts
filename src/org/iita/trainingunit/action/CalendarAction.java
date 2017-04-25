/**
 * training.Struts Feb 8, 2010
 */
package org.iita.trainingunit.action;

import java.util.Calendar;
import java.util.List;

import org.iita.struts.BaseAction;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;

/**
 * Action to show all {@link Trainee}s and {@link TrainingProgram}s in a specified time period (defaults to current month)
 * 
 * @author mobreza
 */
@SuppressWarnings("serial")
public class CalendarAction extends BaseAction {
	private TrainingUnitService service;
	private Calendar dateFrom = org.iita.util.Date.getMonthStart(0);
	private Calendar dateTo = org.iita.util.Date.getMonthEnd(0);
	private List<Trainee> trainees;
	private List<TrainingProgram> programs;

	/**
	 * @param trainingProgramService
	 * 
	 */
	public CalendarAction(TrainingUnitService trainingUnitService) {
		this.service = trainingUnitService;
	}

	/**
	 * @param dateFrom the dateFrom to set
	 */
	public void setDateFrom(Calendar dateFrom) {
		this.dateFrom = dateFrom;
		this.dateFrom.set(Calendar.DAY_OF_MONTH, 1);
		this.dateTo=(Calendar) this.dateFrom.clone();
		this.dateTo.add(Calendar.MONTH, 1);
		this.dateTo.add(Calendar.DAY_OF_MONTH, -1);		
	}

	/**
	 * @return the dateFrom
	 */
	public Calendar getDateFrom() {
		return this.dateFrom;
	}
	
	/**
	 * @return the dateTo
	 */
	public Calendar getDateTo() {
		return this.dateTo;
	}

	/**
	 * @return the trainees
	 */
	public List<Trainee> getTrainees() {
		return this.trainees;
	}
	
	/**
	 * @return the programs
	 */
	public List<TrainingProgram> getPrograms() {
		return this.programs;
	}
	
	public Calendar prevMonth(Calendar date) {
		Calendar date2=(Calendar) date.clone();
		date2.set(Calendar.DAY_OF_MONTH, 1);
		date2.add(Calendar.MONTH, -1);
		return date2;
	}

	public Calendar nextMonth(Calendar date) {
		Calendar date2=(Calendar) date.clone();
		date2.set(Calendar.DAY_OF_MONTH, 1);
		date2.add(Calendar.MONTH, 1);
		return date2;
	}

	/**
	 * @see org.iita.struts.BaseAction#execute()
	 */
	@Override
	public String execute() {
		Calendar x=(Calendar) dateTo.clone();
		x.add(Calendar.DAY_OF_MONTH, 1);
		x.add(Calendar.MILLISECOND, -1);
		LOG.debug("Calendar from: " + dateFrom);
		LOG.debug("Calendar to: " + dateTo);
		if(getUser().hasRole("ROLE_ADMIN") || getUser().hasRole("ROLE_HEAD") || getUser().hasRole("ROLE_QUERYMANAGER")){
			this.trainees=this.service.listTrainees(dateFrom, x);
			this.programs=this.service.listTrainingPrograms(dateFrom, x);
		}else{
			this.trainees=this.service.listTrainees(getUser(), dateFrom, x);
			this.programs=this.service.listTrainingPrograms(getUser(), dateFrom, x);
		}
		return Action.SUCCESS;
	}
}
