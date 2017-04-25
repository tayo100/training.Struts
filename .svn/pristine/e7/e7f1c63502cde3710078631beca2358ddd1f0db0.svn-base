package org.iita.trainingunit.announcements.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.trainingunit.announcements.model.TrainTheTrainer;
import org.iita.trainingunit.announcements.service.TrainTheTrainerService;
import org.iita.util.PagedResult;
import org.springframework.transaction.annotation.Transactional;

public class TrainTheTrainerServiceImpl implements TrainTheTrainerService {
	private static final Log LOG = LogFactory.getLog(TrainTheTrainerServiceImpl.class);
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
	public void save(TrainTheTrainer trainTheTrainer) {
		if (trainTheTrainer.getId() == null) {
			this.entityManager.persist(trainTheTrainer);
		} else {
			this.entityManager.merge(trainTheTrainer);
		}
	}

	@Override
	@Transactional
	public void delete(TrainTheTrainer trainTheTrainer) {
		this.entityManager.remove(trainTheTrainer);
	}

	@Override
	public PagedResult<TrainTheTrainer> list(int startAt, int maxResults) {
		LOG.debug("Got here: ");
		LOG.debug(new TrainTheTrainer());
		PagedResult<TrainTheTrainer> paged = new PagedResult<TrainTheTrainer>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);

		paged.setResults(this.entityManager.createQuery("from TrainTheTrainer t " + "order by t.stopTrainingDate, t.unit desc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
		paged.setTotalHits((Long) this.entityManager.createQuery("select count(t) from TrainTheTrainer t").getSingleResult());

		return paged;
	}

	@Override
	@Transactional(readOnly = true)
	public TrainTheTrainer find(Long id) {
		TrainTheTrainer trainTheTrainer = this.entityManager.find(TrainTheTrainer.class, id);
		return trainTheTrainer;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<TrainTheTrainer> list() {
		return this.entityManager.createQuery("from TrainTheTrainer a " +
		"where (a.deadline>=now() or a.deadline is null) order by a.duration, a.trainingTitle desc").getResultList();
	}
}