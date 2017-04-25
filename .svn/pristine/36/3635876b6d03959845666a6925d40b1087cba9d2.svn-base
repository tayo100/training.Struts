/**
 * promisCRM.Struts Aug 6, 2010
 */
package org.iita.crm.model;

import javax.persistence.Entity;

import org.hibernate.search.annotations.Indexed;
import org.iita.security.UserAccess;
import org.iita.security.model.User;
import org.iita.trainingunit.announcements.model.TrainTheTrainer;

/**
 * @author KOraegbunam
 * 
 */
@Entity
@Indexed
public class TrainTheTrainerDocument extends EntityDocument<TrainTheTrainer> implements UserAccess {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Access to trainthetrainer documents is limited to people with general roles
	 * 
	 * @see org.iita.security.UserAccess#hasAccess(org.iita.security.model.User)
	 */
	@Override
	public boolean hasAccess(User user) {
		return false;
	}
}
