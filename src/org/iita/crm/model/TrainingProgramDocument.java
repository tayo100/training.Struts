/**
 * 
 */
package org.iita.crm.model;

import javax.persistence.Entity;

import org.hibernate.search.annotations.Indexed;
import org.iita.security.UserAccess;
import org.iita.security.model.User;
import org.iita.trainingunit.model.TrainingProgram;

/**
 * @author ken
 *
 **/
@Entity
@Indexed
public class TrainingProgramDocument extends EntityDocument<TrainingProgram> implements UserAccess  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6806831711176481111L;

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
