package org.iita.trainingunit.announcements.service.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.service.IframeSearchService;
import org.iita.util.PagedResult;

public class IframeSearchServiceImpl implements IframeSearchService {
	private static final Log LOG = LogFactory.getLog(IframeSearchServiceImpl.class);
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	private String theQuery(String text){
		try{
			StringBuilder data = new StringBuilder();
			data.append("FROM Announcement a WHERE a.status = 'Published' AND a.deadline >= NOW() AND (a.accommodation like '%");
			data.append(text).append("%' OR a.courseContents like '%").append(text).append("%' OR a.expectedOutcome like '%");
			data.append(text).append("%' OR a.introduction like '%").append(text).append("%' OR a.keywords like '%");
			data.append(text).append("%' OR a.learningMethod like '%").append(text);
			data.append(text).append("%' OR a.numberOfParticipants like '%").append(text).append("%' OR a.objective like '%");
			data.append(text).append("%' OR a.payment like '%").append(text).append("%' OR a.targetGroup like '%");
			data.append(text).append("%' OR a.title like '%").append(text).append("%' OR a.trainingFee like '%");
			data.append(text).append("%' OR a.type like '%").append(text);
			return data.append("%')").toString();
		} catch (NoResultException e) {
			return null;
		}		
	}
	
	@Override
	public PagedResult<Announcement> searchAnnouncement(String ask, int startAt, int maxResults) {
		try {
			PagedResult<Announcement> paged = new PagedResult<Announcement>();
			paged.setStartAt(startAt);
			paged.setMaxResults(maxResults);
			paged.setResults(this.entityManager.createQuery(theQuery(ask)).setFirstResult(startAt).setMaxResults(maxResults).getResultList());
			return paged;
		} catch (NoResultException e) {
			LOG.warn("No Announcement with '" + ask + "' criteria found.");
			return null;
		}
	}

	@Override
	public List<Announcement> searchAnnouncement(String ask) {
		return null;
	}
}

/**
objective like '%%' OR payment like '%%' OR targetGroup like '%%' OR title like '%%' OR
trainingFee like '%%' OR type like '%%';
*/