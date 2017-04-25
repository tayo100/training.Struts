/**
 * training.Struts Feb 5, 2010
 */
package org.iita.crm.service;

import java.util.List;

import org.iita.crm.model.Affiliation;
import org.iita.crm.model.Organization;
import org.iita.service.SearchException;
import org.iita.util.PagedResult;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * @author mobreza
 * 
 */
public interface OrganizationService {
	Organization loadOrganization(Long id);

	void update(Organization organization);

	void update(Affiliation affiliation);

	/**
	 * @param affiliation
	 */
	void remove(Affiliation affiliation);
	
	/**
	 * @param id
	 * @return
	 */
	Affiliation loadAffiliation(Long id);
	
	/**
	 * @param profile
	 * @throws DataIntegrityViolationException 
	 */
	void delete(Organization organization) throws org.springframework.dao.DataIntegrityViolationException;
	
	/**
	 * @param title
	 * @return
	 * @throws TrainingUnitDataException 
	 */
	Organization registerOrganization(String title) throws CRMException;
	

	/**
	 * @param text
	 * @param i
	 * @return
	 * @throws SearchException 
	 */
	List<Organization> autocompleteOrganization(String text, int maxRecords) throws SearchException;


	/**
	 * Gets the similar organizations.
	 * 
	 * @param entity the entity
	 * @param i the i
	 * 
	 * @return the similar organizations
	 */
	List<Organization> getSimilarOrganizations(Organization entity, int i);
	

	/**
	 * @param organization
	 * @param startAt
	 * @param maxResults
	 * @return
	 */
	PagedResult<Affiliation> listAffiliations(Organization organization, int startAt, int maxResults);

}
