package org.iita.trainingunit.applications.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.applications.model.Application.TYPE;
import org.iita.trainingunit.applications.service.ApplicationSearchService;
import org.iita.trainingunit.model.Trainee;
import org.iita.util.PagedResult;
import org.springframework.transaction.annotation.Transactional;

public class ApplicationSearchServiceImpl implements ApplicationSearchService {
	private static final Log LOG = LogFactory.getLog(ApplicationSearchServiceImpl.class);
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	/**
	   Generated SQL: SELECT * FROM Application ap left join Announcement at on 
	   ap.announcement_id=at.id left join ApplicantsBioData ab on
	   ap.id = ab.id WHERE at.type = 'Group'
	   AND (at.createdDate between '2005-07-04' and '2014-07-01' or at.deadline between '2005-07-04' and '2014-07-01') 
	   */
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public PagedResult<Application> search(String details, Date fromDate, Date toDate, String majorFieldOfStudy, String trainingType, String nationality, String degree, Date dobFromDate, Date dobToDate, int startAt, int maxResults) {
		try{
			//if(details.isEmpty()){
			//	return null;
			//}else{
				StringBuilder query = new StringBuilder("");
				
				if(details!="" && details.trim().length()>0){
					if(query.length()>0){
						query.append(" and (a.announcement.title like '%" + details + "%')");
					}else{
						query.append(" where (a.announcement.title like '%" + details + "%')");
					}
				}
				
				if(majorFieldOfStudy!="" && majorFieldOfStudy.trim().length()>0){
					if(query.length()>0){
						query.append(" and ('" + majorFieldOfStudy + "' IN (ed.majorFieldOfStudy))");
					}else{
						query.append(" where ('" + majorFieldOfStudy + "' IN (ed.majorFieldOfStudy))");
					}
				}
				
				if(trainingType!="" && trainingType.trim().length()>0){
					if(query.length()>0){
						query.append(" and (a.class like '" + trainingType + "%')");
					}else{
						query.append(" where (a.class like '" + trainingType + "%')");
					}
				}
				
				if(nationality!="" && nationality.trim().length()>0){
					if(query.length()>0){
						query.append(" and (a.biodata.nationality='" + nationality + "')");
					}else{
						query.append(" where (a.biodata.nationality='" + nationality + "')");
					}
				}
				
				LOG.info("DEGREE LENGTH: " + degree.trim().length());
				LOG.info("DEGREE: " + degree);
				if(degree!="" && degree.trim().length()>0){
					if(query.length()>0){
						query.append(" and ('" + degree + "' IN (ed.certificateObtained))");
					}else{
						query.append(" where ('" + degree + "' IN (ed.certificateObtained))");
					}
				}
				
				String fromDateStr = "";
				String toDateStr = "";
				
				if(fromDate!=null && toDate!=null){
					fromDateStr = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					toDateStr = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
					if(query.length()>0){
						query.append(" and (DATE(a.createdDate) between '" + fromDateStr).append("' and '" + toDateStr + "')");
					}else{
						query.append(" where (DATE(a.createdDate) between '" + fromDateStr).append("' and '" + toDateStr + "')");
					}
				}else if(fromDate!=null){
					fromDateStr = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					if(query.length()>0){
						query.append(" and (DATE(a.createdDate)='" + fromDateStr + "')");
					}else{
						query.append(" where (DATE(a.createdDate)='" + fromDateStr + "')");
					}
				}
				
				String dobFromDateStr = "";
				String dobToDateStr = "";
				
				if(dobFromDate!=null && dobToDate!=null){
					dobFromDateStr = new SimpleDateFormat("yyyy-MM-dd").format(dobFromDate);
					dobToDateStr = new SimpleDateFormat("yyyy-MM-dd").format(dobToDate);
					if(query.length()>0){
						query.append(" and (a.biodata.dateOfBirth between '" + dobToDateStr).append("' and '" + dobToDateStr + "')");
					}else{
						query.append(" where (a.biodata.dateOfBirth between '" + dobFromDateStr).append("' and '" + dobToDateStr + "')");
					}
				}else if(dobFromDate!=null){
					dobFromDateStr = new SimpleDateFormat("yyyy-MM-dd").format(dobFromDate);
					if(query.length()>0){
						query.append(" and (a.biodata.dateOfBirth='" + dobFromDateStr + "')");
					}else{
						query.append(" where (a.biodata.dateOfBirth='" + dobFromDateStr + "')");
					}
				}
				
				
				if(query.length()<=0)
					query.append(" where a.submissionStatus='Submitted' ");
				else
					query.append(" and a.submissionStatus='Submitted' ");
				
				PagedResult<Application> paged = new PagedResult<Application>();
				paged.setStartAt(startAt);
				paged.setMaxResults(maxResults);
				paged.setResults(this.entityManager.createQuery("select distinct a from Application a left outer join a.biodata.educationAndTraining ed" + query + " order by a.biodata.lastName, a.createdDate desc")
						.setMaxResults(maxResults).getResultList());
				List<Application> apps = this.entityManager.createQuery("select distinct a from Application a left outer join a.biodata.educationAndTraining ed" + query + " order by a.biodata.lastName, a.createdDate desc")
				.getResultList();
				paged.setTotalHits(apps.size());
				return paged;
			//}
		}catch (NoResultException e) {
			LOG.warn("Application not found.");
			return null;
		}		
	}

	@Override
	public PagedResult<Application> search(String details, Date fromDate, Date toDate, String majorFieldOfStudy, String trainingType, String nationality, String degree, Date dobFromDate, Date dobToDate) {
		PagedResult<Application> paged = new PagedResult<Application>();
		try{
			StringBuilder query = new StringBuilder("");
			
			if(details!="" && details.trim().length()>0){
				if(query.length()>0){
					query.append(" and (a.announcement.title like '%" + details + "%')");
				}else{
					query.append(" where (a.announcement.title like '%" + details + "%')");
				}
			}
			
			if(majorFieldOfStudy!="" && majorFieldOfStudy.trim().length()>0){
				if(query.length()>0){
					query.append(" and ('" + majorFieldOfStudy + "' IN (ed.majorFieldOfStudy))");
				}else{
					query.append(" where ('" + majorFieldOfStudy + "' IN (ed.majorFieldOfStudy))");
				}
			}
			
			if(trainingType!="" && trainingType.trim().length()>0){
				if(query.length()>0){
					query.append(" and (a.class like '" + trainingType + "%')");
				}else{
					query.append(" where (a.class like '" + trainingType + "%')");
				}
			}
			
			if(nationality!="" && nationality.trim().length()>0){
				if(query.length()>0){
					query.append(" and (a.biodata.nationality='" + nationality + "')");
				}else{
					query.append(" where (a.biodata.nationality='" + nationality + "')");
				}
			}
			
			if(degree!="" && degree.trim().length()>0){
				if(query.length()>0){
					query.append(" and ('" + degree + "' IN (ed.certificateObtained))");
				}else{
					query.append(" where ('" + degree + "' IN (ed.certificateObtained))");
				}
			}
			
			String fromDateStr = "";
			String toDateStr = "";
			
			if(fromDate!=null && toDate!=null){
				fromDateStr = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
				toDateStr = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
				if(query.length()>0){
					query.append(" and (DATE(a.createdDate) between '" + fromDateStr).append("' and '" + toDateStr + "')");
				}else{
					query.append(" where (DATE(a.createdDate) between '" + fromDateStr).append("' and '" + toDateStr + "')");
				}
			}else if(fromDate!=null){
				fromDateStr = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
				if(query.length()>0){
					query.append(" and (DATE(a.createdDate)='" + fromDateStr + "')");
				}else{
					query.append(" where (DATE(a.createdDate)='" + fromDateStr + "')");
				}
			}
			
			String dobFromDateStr = "";
			String dobToDateStr = "";
			
			if(dobFromDate!=null && dobToDate!=null){
				dobFromDateStr = new SimpleDateFormat("yyyy-MM-dd").format(dobFromDate);
				dobToDateStr = new SimpleDateFormat("yyyy-MM-dd").format(dobToDate);
				if(query.length()>0){
					query.append(" and (a.biodata.dateOfBirth between '" + dobToDateStr).append("' and '" + dobToDateStr + "')");
				}else{
					query.append(" where (a.biodata.dateOfBirth between '" + dobFromDateStr).append("' and '" + dobToDateStr + "')");
				}
			}else if(dobFromDate!=null){
				dobFromDateStr = new SimpleDateFormat("yyyy-MM-dd").format(dobFromDate);
				if(query.length()>0){
					query.append(" and (a.biodata.dateOfBirth='" + dobFromDateStr + "')");
				}else{
					query.append(" where (a.biodata.dateOfBirth='" + dobFromDateStr + "')");
				}
			}
			
			if(query.length()<=0)
				query.append(" where a.submissionStatus='Submitted' ");
			else
				query.append(" and a.submissionStatus='Submitted' ");

			paged.setResults(this.entityManager.createQuery("select distinct a from Application a left outer join a.biodata.educationAndTraining ed" + query +"order by a.biodata.lastName, a.createdDate desc").getResultList());
			
			return paged;
		} catch (NoResultException e) {
			LOG.info("Application not found.");
			return null;
		} catch (Exception e) {
			LOG.info("Application not found. " + e.getMessage());
			return null;
		}
	}
	
}