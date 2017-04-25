/**
 * promisCRM.Struts Apr 27, 2010
 */
package org.iita.crm.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.iita.entity.VersionedEntity;
import org.iita.security.UserAccess;
import org.iita.security.model.User;

/**
 * @author mobreza
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Note extends VersionedEntity implements UserAccess {
	private static final long serialVersionUID = -7126096069286583603L;
	private String text;
	private User owner;

	/**
	 * @return the text
	 */
	@Lob
	public String getText() {
		return this.text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the owner
	 */
	@ManyToOne(cascade = {}, optional = false)
	public User getOwner() {
		return this.owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	/**
	 * Note owners have access to own notes.
	 * @see org.iita.security.UserAccess#hasAccess(org.iita.security.model.User)
	 */
	@Override
	public boolean hasAccess(User user) {
		return getOwner()==null || getOwner().getId().equals(user.getId());
	}

}
