/**
 * 
 */
package org.iita.trainingunit.action;

/**
 * @author ken
 *
 */

import java.util.List;


import org.iita.crm.action.BaseAction;
import org.iita.security.model.User;
import org.iita.security.service.UserService;

import com.opensymphony.xwork2.Action;

public class UserAjaxAutocomplete extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lookup;
	private UserService userService;
	private List<User> users;

	/**
	 * @param userService
	 * 
	 */
	public UserAjaxAutocomplete(UserService userService) {
		this.userService=userService;
	}
	
	/**
	 * @param lookup the lookup to set
	 */
	public void setLookup(String lookup) {
		this.lookup = lookup;
	}

	public List<User> getValues() {
		return this.users;
	}

	/**
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() {
		this.users = this.userService.findByName(lookup, 10);
		System.out.println("USERS: " + users.size());
		return Action.SUCCESS;
	}
}