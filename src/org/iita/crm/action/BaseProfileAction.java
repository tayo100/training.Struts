/*
 * 
 */
package org.iita.crm.action;

import com.opensymphony.xwork2.Action;

/**
 * The Class BaseProfileAction.
 */
@SuppressWarnings("serial")
public abstract class BaseProfileAction<T> extends BaseAction {

	/** The id. */
	protected Long id = null;

	/** The profile. */
	protected T profile;

	/**
	 * Instantiates a new base profile action.
	 */
	public BaseProfileAction() {

	}

	/**
	 * Sets the id.
	 * 
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Gets the profile.
	 * 
	 * @return the profile
	 */
	public T getProfile() {
		return profile;
	}
	
	/**
	 * @see org.iita.struts.BaseAction#prepare()
	 */
	@Override
	public void prepare() {
		this.profile = loadProfile();
	}

	/**
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() {
		if (this.profile == null) {
			addActionError("No such profile " + this.id);
			return Action.ERROR;
		} else
			return Action.SUCCESS;
		
	}

	/**
	 * Load profile.
	 * 
	 * @return the t
	 */
	protected abstract T loadProfile();
}
