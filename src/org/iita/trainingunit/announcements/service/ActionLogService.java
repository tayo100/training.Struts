/**
 * 
 */
package org.iita.trainingunit.announcements.service;

import java.util.List;

import org.iita.crm.model.ActionLog;
import org.iita.security.model.User;

/**
 * @author koraegbunam
 *
 */
public interface ActionLogService {
	/**
	 * @param user
	 * @param howMany
	 * @return
	 */
	List<ActionLog> getRecentActionLogs(User user, int howMany);
}
