package org.iita.crm.service;

import java.util.List;

import org.iita.crm.model.Person;
import org.iita.security.model.User;
import org.iita.service.SearchException;
import org.iita.util.PagedResult;
import org.springframework.dao.DataIntegrityViolationException;

public interface PersonService {
	/**
	 * Load person by ID
	 * 
	 * @param id
	 * @return
	 */
	Person loadPerson(Long id);
	
	/**
	 * @param profile
	 */
	void delete(Person profile) throws DataIntegrityViolationException;


	void registerPerson(Person person);

	/**
	 * @param text
	 * @return
	 * @throws SearchException
	 */
	List<Person> autocompletePerson(String text, int maxResults) throws SearchException;

	/**
	 * @param personName
	 * @return
	 */
	Person createPerson(String personName);
	
	/**
	 * @param personName
	 * @return
	 */
	Person findPerson(String personName);

	/**
	 * @param profile
	 */
	void update(Person profile);


	/**
	 * Get a list of persons with similar names
	 * 
	 * @param person
	 * @return
	 */
	List<Person> getSimilarPersons(Person person, int maxResults);

	/**
	 * @param startAt
	 * @param maxResults
	 * @return
	 */
	PagedResult<Person> listPersons(int startAt, int maxResults);
	

	/**
	 * @param user
	 * @return
	 */
	Person findOrCreatePerson(User user);
}
