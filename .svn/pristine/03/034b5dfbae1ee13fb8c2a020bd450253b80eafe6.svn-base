/**
 * 
 */
package org.iita.trainingunit.announcements.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.iita.crm.model.ActionLog;
import org.iita.security.model.User;

/**
 * @author koraegbunam
 *
 */
public class ActionLogServiceImpl {
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	/**
	 * @see org.iita.trainingunit.announcements.service.ActionLogService#getRecentActionLogs(org.iita.security.model.User, int)
	 */
	@SuppressWarnings("unchecked")
	public List<ActionLog> getRecentActionLogs(User user, int howMany) {
		return this.entityManager.createQuery("from ActionLog al where al.trainingProposal.owner=:user order by id desc").setParameter("user", user)
				.setMaxResults(howMany).getResultList();
	}
}
