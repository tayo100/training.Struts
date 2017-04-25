/**
 * 
 */
package org.iita.trainingunit.applications.service;

import org.iita.security.model.User;
import org.iita.trainingunit.applications.model.ApplicantsBioData;
import org.iita.trainingunit.applications.model.ApplicationStarter;

/**
 * @author ken
 *
 */
public interface ApplicantBioDataService {
	void save(ApplicantsBioData cdoBioData, ApplicationStarter appStarter);
	void save(ApplicantsBioData cdoBioData);
	ApplicantsBioData findByUser(User user);
	User findUserByEmail(String emailAddress);
	User save(User user);
	ApplicationStarter findByAppKeyAndEmail(String appKey, String email);
	
	boolean confirmExistingPassword(User user, String newPassword);
	void updatePassword(User user, String newPassword);
}
