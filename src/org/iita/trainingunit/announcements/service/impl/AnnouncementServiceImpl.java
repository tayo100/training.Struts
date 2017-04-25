package org.iita.trainingunit.announcements.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.security.model.User;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.announcements.model.Announcement.STATUS;
import org.iita.trainingunit.announcements.service.AnnouncementException;
import org.iita.trainingunit.announcements.service.AnnouncementService;
import org.iita.trainingunit.applications.model.Application;
import org.iita.util.PagedResult;
import org.springframework.transaction.annotation.Transactional;

public class AnnouncementServiceImpl implements AnnouncementService {
	private static final Log LOG = LogFactory.getLog(AnnouncementServiceImpl.class);
	static final String[] FIELDS = new String[] { "" };
	private EntityManager entityManager;
	
	/**
	 * @see org.iita.service.impl.SimpleDaoServiceImpl#setEntityManager(javax.persistence.EntityManager)
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Announcement announcement) {
		if (announcement.getId() == null) {
			this.entityManager.persist(announcement);
		} else {
			this.entityManager.merge(announcement);
		}
	}

	@Override
	@Transactional
	public void delete(Announcement announcement) {
		this.entityManager.remove(announcement);
	}

	@Override
	@Transactional(readOnly=true)
	public PagedResult<Announcement> list(int startAt, int maxResults) {
		PagedResult<Announcement> paged = new PagedResult<Announcement>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		paged.setResults(this.entityManager.createQuery("from Announcement a " +
				"order by a.createdDate, a.deadline, a.title desc").setFirstResult(startAt).setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(a) from Announcement a").getSingleResult());
		return paged;
	}

	@Override
	@Transactional(readOnly=true)
	public Announcement find(Long id) {
		Announcement announcement = this.entityManager.find(Announcement.class, id);
		return announcement;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Announcement> list(String type) {
		//return this.entityManager.createQuery("from Announcement a where ((a.deadline>=now() or a.deadline is null) and a.type=:type) order by a.deadline, a.title desc").setParameter("type", type).getResultList();
		return this.entityManager.createQuery("from Announcement a " +
		"where (a.status='Published' and (a.deadline>=now() or a.deadline is null) and a.type=:type) order by a.deadline, a.title desc").setParameter("type", type).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Announcement> listAll() {
		return this.entityManager.createQuery("from Announcement a " +
		"where a.status='Published' and (a.deadline>=now() or a.deadline is null) order by a.deadline, a.title desc").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int totalApplicants(Announcement announcement) {
		LOG.info("Announcement: " + announcement);
		List<Application> list = this.entityManager.createQuery("from Application a inner join a.annoucement an" +
		"where a.announcement=:announcement order by a.createdDate, a.lastName, a.firstName desc").setParameter("announcement", announcement).getResultList();		
		return list.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public PagedResult<Announcement> search(String details, Date fromDate, Date toDate, int startAt, int maxResults) {
		try{
			if(details.isEmpty()){
				return null;
			}else{
				PagedResult<Announcement> paged = new PagedResult<Announcement>();
				paged.setStartAt(startAt);
				paged.setMaxResults(maxResults);
				paged.setResults(this.entityManager.createQuery("select distinct a from Announcement a where (a.class like :details) or (a.title like :details and a.createdDate between :fromDate and :toDate) or (a.title like :details) or (a.title like :details or a.createdDate between :fromDate and :toDate) or (a.title like :details or a.createdDate =:fromDate)").setParameter("details", "%" + details + "%").setParameter("fromDate", fromDate).setParameter("toDate", toDate).setFirstResult(startAt).setMaxResults(maxResults).getResultList());
				List<Announcement> announces = this.entityManager.createQuery("select distinct a from Announcement a where (a.class like :details) or  (a.title like :details and a.createdDate between :fromDate and :toDate) or (a.title like :details) or (a.title like :details or a.createdDate between :fromDate and :toDate) or (a.title like :details or a.createdDate =:fromDate)").setParameter("details", "%" + details + "%").setParameter("fromDate", fromDate).setParameter("toDate", toDate).getResultList();
				paged.setTotalHits(announces.size());
				return paged;
			}
		}catch (NoResultException e) {
			LOG.warn("Announcement not found.");
			return null;
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Announcement> search(String details, Date fromDate, Date toDate) {
		try{
			//StringBuilder query = new StringBuilder();
			return (List<Announcement>) this.entityManager.createQuery("select distinct a from Announcement a where (a.class like :details) or  (a.title like :details and a.createdDate between :fromDate and :toDate) or (a.title like :details) or (a.title like :details or a.createdDate between :fromDate and :toDate) or (a.title like :details or a.createdDate =:fromDate)").setParameter("details", "%" + details + "%").setParameter("fromDate", fromDate).setParameter("toDate", toDate).getResultList();
		} catch (NoResultException e) {
			LOG.warn("Announcement not found.");
			return null;
		}
	}
	
	@Override
	@Transactional(readOnly = false)
	public Announcement createNew(User owner) throws AnnouncementException {
		LOG.info("Creating new Announcement for " + owner);
		Announcement an = new Announcement();
		an.setStatus(STATUS.Draft);
		an.setTitle("Yet to be specified");
		an.setOwner(owner);
		an.setTrainingFee(0.0d);
		this.entityManager.persist(an);
		return an;
	}

	@Override
	@Transactional
	public Announcement lookUp(String title, STATUS status) {
		Announcement app = new Announcement();
		
		try{
			String annTitle = title + " Training Application";
			app = (Announcement) this.entityManager.createQuery("select a from Announcement a where title=:title and status=:status").setParameter("title", annTitle).setParameter("status", status).getSingleResult();
			
			if(app==null || app.getId()==null){
				app = new Announcement();
				app.setStatus(STATUS.Application);
				app.setTitle(annTitle);
				app.setType(title);
				app.setOwner(null);
				app.setTrainingFee(0.0d);
				this.entityManager.persist(app);
				return app;
			}
		}catch(Exception ex){
			if(app==null || app.getId()==null){
				app = new Announcement();
				app.setStatus(STATUS.Application);
				String annTitle = title + " Training Application";
				app.setTitle(annTitle);
				app.setType(title);
				app.setOwner(null);
				app.setTrainingFee(0.0d);
				this.entityManager.persist(app);
				return app;
			}
		}
		
		return app;
	}
}
