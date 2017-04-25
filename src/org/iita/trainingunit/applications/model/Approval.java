/**
 * 
 */
package org.iita.trainingunit.applications.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.iita.entity.VersionedEntity;
import org.iita.security.model.User;

/**
 * @author ken
 *
 */
@Entity
public class Approval extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3414610299690589137L;
	private Application application;
	private User requester;
	private User nextApprover;
	private STATUS status = STATUS.NEW;

	public enum STATUS {NEW, WAITING, APPROVED, REJECTED, PENDING}
	
	@OneToOne(cascade = {}, optional = false)
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	@ManyToOne(cascade = {}, optional = true)
	public User getRequester() {
		return requester;
	}

	public void setRequester(User requester) {
		this.requester = requester;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public void setNextApprover(User nextApprover) {
		this.nextApprover = nextApprover;
	}
	
	@ManyToOne(cascade = {}, optional = true)
	public User getNextApprover() {
		return nextApprover;
	}

}
