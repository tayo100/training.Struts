/**
 * promisCRM.Struts Apr 8, 2010
 */
package org.iita.crm.service;

import java.util.List;

import org.iita.crm.model.Organization;
import org.iita.crm.model.PartnerClassification;
import org.iita.crm.model.Person;
import org.iita.crm.model.PersonMail;
import org.iita.security.model.User;
import org.iita.service.SearchException;
import org.iita.trainingunit.announcements.model.TrainingProposal;
import org.iita.util.PagedResult;

/**
 * @author mobreza
 * @author KOraegbunam
 * 
 */
public interface CoreCRMService extends ContactService, PersonService, OrganizationService, DocumentService, TagService, PartnerService {
	/**
	 * @param class1
	 * @param i
	 * @return
	 */
	<T> List<T> getLastUpdated(Class<T> clazz, int maxRecords);
	
	/**
	 * Find entities
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	<T> T find(Class<T> clazz, Long id);

	/**
	 * @param sample
	 * @param startAt
	 * @param maxResults
	 * @return
	 */
	<T> List<T> list(T sample, int startAt, int maxResults);

	/**
	 * @param sample
	 * @return
	 */
	<T> T findOne(T sample);

	/**
	 * @param person
	 * @param i
	 * @param j
	 * @return
	 */
	PagedResult<PersonMail> listPersonMail(Person person, int startAt, int maxRecords);

	/**
	 * @param text
	 * @param i
	 * @return
	 */
	List<User> autocompleteUser(String text, int maxRecords);

	/**
	 * @return
	 */
	Organization getThisOrganization();

	void updateClassification(PartnerClassification classification);

	List<TrainingProposal> lookupTrainingProposal(String lookup, int i) throws SearchException;
	
	
}
