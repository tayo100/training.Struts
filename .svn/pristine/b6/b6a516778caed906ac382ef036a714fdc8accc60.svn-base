package org.iita.trainingunit.action;

import java.util.List;

import org.iita.struts.BaseAction;
import org.iita.crm.model.Affiliation;
import org.iita.crm.model.Contact;
import org.iita.crm.model.Organization;
import org.iita.crm.model.Person;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.Trainer;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.service.TrainingUnitService;
import org.iita.trainingunit.service.TrainingUnitService.MergeEntity;

import com.opensymphony.xwork2.Action;

/**
 * <p>
 * Merge action allows users to visually merge {@link Person} and {@link Organization} data. Two records are loaded and displayed side-by-side, moving and
 * copying {@link Contact}, {@link Trainee}, {@link Trainer} and {@link Affiliation} data between the two. Changes are applied once the person confirms the
 * changes.
 * </p>
 * 
 * <p>
 * Administrators will use this action to clean up the database of duplicate person and organization entries. Once no more data is linked to {@link Person} or
 * {@link Organization}, that record can be purged from the sysetm.
 * </p>
 * 
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public class MergeAction extends BaseAction {
	private TrainingUnitService service;
	private MergeEntity left = new MergeEntity();
	private MergeEntity right = new MergeEntity();

	/**
	 * @param service
	 * 
	 */
	public MergeAction(TrainingUnitService service) {
		this.service = service;
	}

	/**
	 * @return the left
	 */
	public MergeEntity getLeft() {
		return this.left;
	}

	/**
	 * @return the right
	 */
	public MergeEntity getRight() {
		return this.right;
	}
	
	public List<Trainee> getTrainees(Person person) {
		return this.service.listTrainees(person);
	}
	
	public List<Trainee> getTrainees(Organization organization) {
		return this.service.listTrainees(organization);
	}
	
	public List<TrainingProgram> getPrograms(Person person) {
		return this.service.listTrainingPrograms(person);
	}
	
	public List<Trainee> getSupervisors(Person person) {
		return this.service.listSupervisions(person);
	}
	
	/**
	 * @see org.iita.struts.BaseAction#prepare()
	 */
	@Override
	public void prepare() {
		if (left.getId()!=null && left.getEntity()==null) {
			left.setEntity(this.service.find(left.getClazz(), left.getId()));
		}
		if (right.getId()!=null && right.getEntity()==null) {
			right.setEntity(this.service.find(right.getClazz(), right.getId()));
		}
	}
	
	public List<?> getSimilar(Object entity) {
		if (entity instanceof Person) {
			return this.service.getSimilarPersons((Person)entity, 10);
		}
		if (entity instanceof Organization) {
			return this.service.getSimilarOrganizations((Organization)entity, 10);
		}
		return null;
	}

	/**
	 * Default action
	 */
	@Override
	public String execute() {
		return Action.SUCCESS;
	}
	
	public String merge() {
		LOG.info("Applying merge changes");
		try {
			this.service.merge(this.left, this.right);
		} catch (Exception e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		if (this.left.getClazz() == Organization.class)
			return "merged-organization";
		else if (this.left.getClazz() == Person.class)
			return "merged-person";
		else
			return Action.SUCCESS;
	}
}
