/**
 * promisCRM.Struts Aug 6, 2010
 */
package org.iita.crm.model;

import javax.persistence.Entity;

import org.hibernate.search.annotations.Indexed;
import org.iita.security.UserAccess;
import org.iita.security.model.User;

/**
 * @author mobreza
 * 
 */
@Entity
@Indexed
public class OrganizationDocument extends EntityDocument<Organization> implements UserAccess {
	private static final long serialVersionUID = -5921787003660417000L;

	/**
	 * Access to organization documents is limited to people with general roles
	 * 
	 * @see org.iita.security.UserAccess#hasAccess(org.iita.security.model.User)
	 */
	@Override
	public boolean hasAccess(User user) {
		return false;
	}
}
