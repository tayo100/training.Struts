/**
 * 
 */
package org.iita.trainingunit.service;

import java.util.Date;

import org.iita.trainingunit.model.Alert;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.model.Alert.AlertType;

/**
 * @author koraegbunam
 *
 */
public interface AlertService {
	/*
	 * creation of alert messages for trainee and group training use
	 * */
	void createAlert(Alert alert);

	void removeAlert(Alert alert);
	
	Alert createAlert(Date firstAlert, AlertType alertType, String subject, String body, Trainee trainee);

	Alert createAlert(Date firstAlert, AlertType alertType, String subject, String body, TrainingProgram trainingProgram);
	
	void updateAlert(Alert alert);
	void sendAlertNotification(Long id, String whichObject);
	//Trainee getAlertTraineeDate(Long traineeId);
	//TrainingProgram getAlertGroupDate(Long groupId);
	void requestForPendingAlerts(String whichObject);
}
