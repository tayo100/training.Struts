package org.iita.trainingunit.iya.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.security.model.User;
import org.iita.security.service.UserService;
import org.iita.trainingunit.announcements.model.TrainingLocation;
import org.iita.trainingunit.iya.model.ClassInteraction;
import org.iita.trainingunit.iya.model.ClassInteraction.InteractionType;
import org.iita.trainingunit.iya.model.IYAAnnouncementObjective;
import org.iita.trainingunit.iya.model.IYAEvaluation;
import org.iita.trainingunit.iya.model.IYAEvaluationObjective;
import org.iita.trainingunit.iya.model.IYARegistration;
import org.iita.trainingunit.iya.model.IYATrainingAnnouncement;
import org.iita.trainingunit.model.Trainer;
import org.iita.util.PagedResult;
import org.springframework.transaction.annotation.Transactional;

public class IyaServiceImpl implements IyaService {
	private static final Log LOG = LogFactory.getLog(IyaServiceImpl.class);
	private EntityManager entityManager;
	private UserService userService;

	/**
	 * @see org.iita.service.impl.SimpleDaoServiceImpl#setEntityManager(javax.persistence.EntityManager)
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Transactional
	public IYATrainingAnnouncement saveAnnouncement(IYATrainingAnnouncement announcement) {
		LOG.info("Announcement: " + announcement);
		cleanupAnnouncement(announcement);
		if (announcement.getId() == null)
			this.entityManager.persist(announcement);
		else
			this.entityManager.merge(announcement);

		return announcement;
	}
	
	

	@Transactional
	public IYATrainingAnnouncement updateAnnouncement(IYATrainingAnnouncement announcement) {
		LOG.info("Announcement: " + announcement);
		LOG.info("Announcement ID: " + announcement.getId());
		//Cleaning up the data arrays
		for (int i = announcement.getTrainingObjectives().size() - 1; i >= 0; i--) {
			System.out.println("OBJ " + i + " : " + announcement.getTrainingObjectives().get(i).getObjective());
		}

		cleanupAnnouncement(announcement);

		for (int i = announcement.getTrainingObjectives().size() - 1; i >= 0; i--) {
			System.out.println("OBJ " + i + " : " + announcement.getTrainingObjectives().get(i).getObjective());
		}

		if (announcement.getId() != null)
			this.entityManager.merge(announcement);

		return announcement;
	}

	
	@Override
	@Transactional
	public void removeAnnouncementItems(IYATrainingAnnouncement announcement){
		
		if (announcement.getTrainingLocations() != null) 
			for (int i = announcement.getTrainingLocations().size() - 1; i >= 0; i--) {
				TrainingLocation loc = announcement.getTrainingLocations().get(i);
				LOG.info("Removing locations " + loc);
				ensureRemoved(announcement.getTrainingLocations().remove(i));
			}		
		
		if (announcement.getTrainingObjectives() != null) 
			for (int i = announcement.getTrainingObjectives().size() - 1; i >= 0; i--) {
				IYAAnnouncementObjective obj = announcement.getTrainingObjectives().get(i);
				LOG.info("Removing objectives: " + obj);
				ensureRemoved(announcement.getTrainingObjectives().remove(i));
			}
		
/*		if (announcement.getFacilitators() != null) 
			for (int i = announcement.getFacilitators().size() - 1; i >= 0; i--) {
				Trainer facilitator = announcement.getFacilitators().get(i);
				LOG.info("Removing Facilitator: " + facilitator);
				ensureRemoved(announcement.getFacilitators().remove(i));
			}*/
	}
	
	
/*	
	*//**
	 * 
	 *//*
	@Transactional
	public void cleanup(IYAEvaluation ant) {

		if (announcement.getTrainingLocations() != null) {
			for (int i = announcement.getTrainingLocations().size() - 1; i >= 0; i--) {
				TrainingLocation loc = announcement.getTrainingLocations().get(i);

				LOG.info("loc: " + loc);
				LOG.info("loc size: " + announcement.getTrainingLocations().size());

				if (loc.getVenue() == null || loc.getVenue().length() == 0) {
					LOG.info("Removing locations " + loc);
					ensureRemoved(announcement.getTrainingLocations().remove(i));
				} else {
					LOG.info("Adding locations " + loc);
					loc.setIyaTrainingAnnouncement(announcement);
					this.entityManager.persist(loc);
				}
			}
		}
		*/
	
	
	/**
	 * 
	 */
	@Transactional
	public void cleanupAnnouncement(IYATrainingAnnouncement announcement) {

		if (announcement.getTrainingLocations() != null) {
			for (int i = announcement.getTrainingLocations().size() - 1; i >= 0; i--) {
				TrainingLocation loc = announcement.getTrainingLocations().get(i);

				LOG.info("loc: " + loc);
				LOG.info("loc size: " + announcement.getTrainingLocations().size());

				if (loc.getVenue() == null || loc.getVenue().length() == 0) {
					LOG.info("Removing locations " + loc);
					ensureRemoved(announcement.getTrainingLocations().remove(i));
				} else {
					LOG.info("Adding locations " + loc);
					loc.setIyaTrainingAnnouncement(announcement);
					this.entityManager.persist(loc);
				}
			}
		}
		
		IYAAnnouncementObjective obj;
		if (announcement.getTrainingObjectives() != null) {
			for (int i = announcement.getTrainingObjectives().size() - 1; i >= 0; i--) {
				obj = announcement.getTrainingObjectives().get(i);
				LOG.info("objective: " + obj);
				if (obj != null) {
					if (obj.getObjective() == null || obj.getObjective().length() == 0) {
						LOG.info("Removing objectives: " + obj);
						ensureRemoved(announcement.getTrainingObjectives().remove(i));
					} else {
						LOG.info("Adding objectives: " + obj);
						obj.setIyaTrainingAnnouncement(announcement);
						this.entityManager.persist(obj);
					}
				}
			}
		}
		
		if (announcement.getFacilitators() != null) {
			for (int i = announcement.getFacilitators().size() - 1; i >= 0; i--) {

				Trainer facilitator = announcement.getFacilitators().get(i);
			//	User user = new User();
				LOG.info("facilitator: " + facilitator.getEmail());
				LOG.info("facilitator size: " + announcement.getFacilitators().size());

				if (facilitator != null) {
					LOG.info("facilitator not null: " + facilitator);
					if (facilitator.getNames() == null || facilitator.getNames().length() == 0) {
						LOG.info("Removing Facilitator: " + facilitator);
						ensureRemoved(announcement.getFacilitators().remove(i));
					} else {/*
						LOG.info("Adding Facilitator: " + facilitator);
						if (facilitator.getEmail() != null) {							
							user = this.userService.lookup(facilitator.getEmail(), true);							
							facilitator.setNames(user.getFullName());							
							LOG.info("facilitator: " + facilitator.getEmail());
						}*/
						facilitator.setIyaTrainingAnnouncement(announcement);//.getFacilitators().get(i).getIyaTrainingAnnouncement()); //facilitator.set
						LOG.info("facilitator AGAIN: " + facilitator.getEmail());
						this.entityManager.persist(facilitator);
					}
				}
			}
		}
	}

	/**
	 * Utility method checks if object is in session and deletes from persistent storage
	 * 
	 * @param objectToRemove
	 */
	@Override
	@Transactional
	public void ensureRemoved(Object objectToRemove) {
		// if (this.entityManager.contains(objectToRemove))
		if (objectToRemove != null) {
			LOG.info("EM removing " + objectToRemove);
			this.entityManager.remove(objectToRemove);
		}
	}
	


	@Override
	@Transactional(readOnly = true)
	public IYATrainingAnnouncement loadAnnouncement(long id) {
		return this.entityManager.find(IYATrainingAnnouncement.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public IYARegistration loadRegistration(long id) {
		return this.entityManager.find(IYARegistration.class, id);
	}

	/**
	 * @see org.iita.crm.service.CoreCRMService#autocompleteUser(java.lang.String, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<IYATrainingAnnouncement> autocompleteIyaAnnouncement(String text, int maxRecords) {
		return this.entityManager.createQuery("select tr from IYATrainingAnnouncement tr where tr.trainingCourse like :text").setParameter("text", text + "%")
				.setMaxResults(maxRecords).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public PagedResult<IYARegistration> iyaRegistrations(int startAt, int maxResults) {
		PagedResult<IYARegistration> paged = new PagedResult<IYARegistration>(startAt, maxResults);
		paged.setResults(this.entityManager.createQuery("from IYARegistration a " + "order by a.createdDate desc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());

		if (paged.getResults().size() > 0)
			paged.setTotalHits(((Long) this.entityManager.createQuery("select count (a) from IYARegistration a").getSingleResult()).longValue());

		return paged;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<IYARegistration> iyaRegistrations() {
		return this.entityManager.createQuery("from IYARegistration a order by a.createdDate desc limit 10").getResultList();
	}

	/**
	 * 
	 */
	@Override
	@Transactional(readOnly = false)
	public IYARegistration updateRegistration(IYARegistration iyaRegistration) {
		LOG.info("Registration: " + iyaRegistration);
		LOG.info("Registration ID: " + iyaRegistration.getId());

		if (iyaRegistration.getId() != null)
			this.entityManager.merge(iyaRegistration);
		return iyaRegistration;
	}

	@Override
	@Transactional(readOnly = false)
	public IYARegistration saveRegistration(IYARegistration registration) {
		LOG.info("Registration ID: " + registration.getId());

		if (registration.getId() == null) {
			this.entityManager.persist(registration);
		} else
			this.entityManager.merge(registration);
		return registration;
	}

	@Override
	@Transactional(readOnly = true)
	public PagedResult<IYATrainingAnnouncement> iyaTrainingAnnoucements(int startAt, int maxResults) {
		PagedResult<IYATrainingAnnouncement> paged = new PagedResult<IYATrainingAnnouncement>(startAt, maxResults);
		paged.setResults(this.entityManager.createQuery("from IYATrainingAnnouncement a " + "order by a.createdDate desc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());

		if (paged.getResults().size() > 0)
			paged.setTotalHits(((Long) this.entityManager.createQuery("select count (a) from IYATrainingAnnouncement a").getSingleResult()).longValue());

		return paged;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<IYATrainingAnnouncement> iyaAnnoucements() {
		return this.entityManager.createQuery("from IYATrainingAnnouncement a order by a.createdDate desc limit 10").getResultList();
	}

	@Override
	public IYAEvaluation loadEvaluation(Long id) {
		return this.entityManager.find(IYAEvaluation.class, id);
	}

	@Override
	@Transactional
	public IYAEvaluation saveEvaluation(IYAEvaluation evaluation){
		LOG.info("Evaluation: " + evaluation);
		if (evaluation.getId() == null)
			this.entityManager.persist(evaluation);
		else
			this.entityManager.merge(evaluation);
		
		return evaluation;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public String[] getSelectedObjectives(IYAEvaluation iyaEvaluation) {
		return (String[]) this.entityManager
				.createQuery("select distinct c.objective from IYAEvaluationObjective c " + "where c.iyaEvaluation=:iyaEvaluation order by c.objective asc")
				.setParameter("iyaEvaluation", iyaEvaluation).getResultList().toArray(new String[] {});
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<IYAEvaluation> iyaEvaluations() {
		return this.entityManager.createQuery("from IYAEvaluation a order by a.createdDate desc limit 10").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<IYAAnnouncementObjective> iyaAnnouncementObjectives() {
		return this.entityManager.createQuery("from IYAAnnouncementObjective a order by a.createdDate desc limit 10").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<IYAAnnouncementObjective> getObjectives(IYATrainingAnnouncement iyaAnnouncement) {
		return this.entityManager.createQuery("from IYAAnnouncementObjective a where a.iyaAnnouncement=:iyaAnnouncement order by a.createdDate ")
				.setParameter("iyaAnnouncement", iyaAnnouncement).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public PagedResult<IYAEvaluation> iyaEvaluations(int startAt, int maxResults) {
		PagedResult<IYAEvaluation> paged = new PagedResult<IYAEvaluation>(startAt, maxResults);
		paged.setResults(this.entityManager.createQuery("from IYAEvaluation a " + "order by a.createdDate desc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());

		if (paged.getResults().size() > 0)
			paged.setTotalHits(((Long) this.entityManager.createQuery("select count (a) from IYAEvaluation a").getSingleResult()).longValue());

		return paged;
	}

}
