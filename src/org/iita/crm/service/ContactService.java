package org.iita.crm.service;


import java.util.List;

import org.iita.crm.model.Contact;
import org.iita.crm.model.Person;

public interface ContactService {
	/**
	 * Load.
	 * 
	 * @param id the id
	 * @param person the person
	 * 
	 * @return the Contact
	 */
	List<Contact> loadContacts(Person person);
	
	Contact loadContact(Long id);
	
	void updateContact(Contact contact);

	void removeContact(Contact address);
}