package org.iita.crm.model;

import javax.persistence.Entity;

import org.hibernate.search.annotations.Indexed;
import org.iita.security.UserAccess;
import org.iita.security.model.User;

/**
 * @author koraegbunam
 * 
 */
@Entity
@Indexed
public class PersonDocument extends EntityDocument<Person> implements UserAccess {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3305233628827899982L;

	/**
	 * Access to person's documents is limited to person itself (and other general roles)
	 * 
	 * @see org.iita.security.UserAccess#hasAccess(org.iita.security.model.User)
	 */
	@Override
	public boolean hasAccess(User user) {
		if (getEntity().getUser().getId().equals(user.getId()))
			return true;
		return false;
	}
}