package org.iita.crm.model;

import javax.persistence.Entity;

import org.hibernate.search.annotations.Indexed;
import org.iita.security.UserAccess;
import org.iita.security.model.User;
import org.iita.trainingunit.announcements.model.TrainingProposal;

@Entity
@Indexed
public class TrainingProposalDocument extends EntityDocument<TrainingProposal> implements UserAccess  {
	private static final long serialVersionUID = 1L;

	/**
	 * Access to announcement documents is limited to people with general roles
	 * 
	 * @see org.iita.security.UserAccess#hasAccess(org.iita.security.model.User)
	 */
	@Override
	public boolean hasAccess(User user) {
		return false;
	}
}
