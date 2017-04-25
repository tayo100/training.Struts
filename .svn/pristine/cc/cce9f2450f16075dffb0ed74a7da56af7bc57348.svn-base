/**
 * training.Struts Feb 4, 2010
 */
package org.iita.trainingunit.action;

import java.util.List;

import org.iita.crm.model.Contact;
import org.iita.crm.model.Organization;
import org.iita.crm.model.Partner;
import org.iita.crm.model.Person;
import org.iita.service.SearchException;
import org.iita.service.SearchService;
import org.iita.struts.BaseAction;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.TrainingProgram;

import com.opensymphony.xwork2.Action;

/**
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public class SearchAction extends BaseAction {
	/**
	 * 
	 */
	private static final String[] FIELDS = new String[] { "" };
	private String queryString = null;
	private SearchService<?> searchService;
	private List<Person> persons;
	private List<Contact> contacts;
	private List<Organization> organizations;
	private List<TrainingProgram> programs;
	private List<Trainee> trainees;
	private List<Partner> partners;

	/**
	 * @param searchService
	 * 
	 */
	public SearchAction(SearchService<?> searchService) {
		this.searchService = searchService;
	}

	/**
	 * @param queryString the queryString to set
	 */
	public void setQ(String queryString) {
		this.queryString = queryString;
	}

	/**
	 * @return the persons
	 */
	public List<Person> getPersons() {
		return this.persons;
	}

	/**
	 * @return the contacts
	 */
	public List<Contact> getContacts() {
		return this.contacts;
	}

	/**
	 * @return the organizations
	 */
	public List<Organization> getOrganizations() {
		return this.organizations;
	}
	
	/**
	 * @return the partners
	 */
	public List<Partner> getPartners() {
		return this.partners;
	}

	/**
	 * @return the programs
	 */
	public List<TrainingProgram> getPrograms() {
		return this.programs;
	}
	
	/**
	 * @return the trainees
	 */
	public List<Trainee> getTrainees() {
		return this.trainees;
	}

	/**
	 * @see org.iita.struts.BaseAction#execute()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String execute() {
		try {
			int totalResults = 0;
			this.organizations = (List<Organization>) this.searchService.search(this.queryString, Organization.class, FIELDS, 0, 10).getResults();
			totalResults += this.organizations.size();

			this.persons = (List<Person>) this.searchService.search(this.queryString, Person.class, FIELDS, 0, 10).getResults();
			totalResults += this.persons.size();

			this.programs = (List<TrainingProgram>) this.searchService.search(this.queryString, TrainingProgram.class, FIELDS, 0, 10).getResults();
			totalResults += this.programs.size();

			this.trainees = (List<Trainee>) this.searchService.search(this.queryString, Trainee.class, FIELDS, 0, 10).getResults();
			totalResults += this.trainees.size();
			
			this.partners = (List<Partner>) this.searchService.search(this.queryString, Partner.class, FIELDS, 0, 10).getResults();
			totalResults += this.partners.size();

			if (totalResults == 1) {
				if (this.organizations.size() == 1)
					return "organization";
				if (this.persons.size() == 1)
					return "person";
				if (this.programs.size() == 1)
					return "program";
				if (this.trainees.size()==1)
					return "trainee";
				if (this.partners.size()==1)
					return "partner";
			}

		} catch (SearchException e) {
			addActionError(e.getMessage());
			return Action.ERROR;
		}
		LOG.info("Got search results");
		return Action.SUCCESS;
	}
}
