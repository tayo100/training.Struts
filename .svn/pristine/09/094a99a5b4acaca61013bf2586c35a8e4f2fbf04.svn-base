package org.iita.trainingunit.applications.service;

import java.util.Date;

import org.iita.trainingunit.applications.model.Application;
import org.iita.util.PagedResult;

public interface ApplicationSearchService {
	
	PagedResult<Application> search(String details, Date fromDate, Date toDate, String majorFieldOfStudy, String trainingType, String nationality, String degree, Date dobFromDate, Date dobToDate, int startAt, int maxResults);
	
	PagedResult<Application> search(String details, Date fromDate, Date toDate, String majorFieldOfStudy, String trainingType, String nationality, String degree, Date dobFromDate, Date dobToDate);
}