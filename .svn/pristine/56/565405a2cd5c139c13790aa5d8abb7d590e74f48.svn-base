package org.iita.trainingunit.action;

import java.util.Date;

import org.iita.struts.BaseAction;
import org.iita.trainingunit.model.Alert;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.model.Alert.AlertType;
import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;

@SuppressWarnings("serial")
public class AlertAction extends BaseAction {
	private TrainingUnitService service;
	private Long traineeId;
	private Long alertId;
	private Long programId;
	private AlertType alertType;
	private Trainee trainee;
	private TrainingProgram trainingProgram;
	private String subject;
	private String body;
	private Date firstAlert;
	private Date lastAlert;
	private Alert alert;

	
	public AlertAction(TrainingUnitService trainingUnitService) {
		this.service = trainingUnitService;
	}


	/**
	 * @param traineeId the traineeId to set
	 */
	public void setTraineeId(Long traineeId) {
		this.traineeId = traineeId;
	}

	/**
	 * @param alertId the alertId to set
	 */
	public void setAlertId(Long alertId) {
		this.alertId = alertId;
	}

	/**
	 * @param programId the programId to set
	 */
	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	/**
	 * @param alertType the alertType to set
	 */
	public void setAlertType(AlertType alertType) {
		this.alertType = alertType;
	}

	/**
	 * @return the trainee
	 */
	public Trainee getTrainee() {
		return trainee;
	}

	/**
	 * @param trainee the trainee to set
	 */
	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}
	
	///**
	// * @return the alert
	// */
	//public Alert getAlert() {
	//	return alert;
	//}

	/**
	 * @return the trainingProgram
	 */
	public TrainingProgram getTrainingProgram() {
		return trainingProgram;
	}

	/**
	 * @param trainingProgram the trainingProgram to set
	 */
	public void setTrainingProgram(TrainingProgram trainingProgram) {
		this.trainingProgram = trainingProgram;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @param firstAlert the firstAlert to set
	 */
	public void setFirstAlert(Date firstAlert) {
		this.firstAlert = firstAlert;
	}

	/**
	 * @param lastAlert the lastAlert to set
	 */
	public void setLastAlert(Date lastAlert) {
		this.lastAlert = lastAlert;
	}
	
	@Override
	public void prepare() {
		if(this.alertId!=null){
			this.alert = new Alert();
			alert = (Alert) this.service.find(Alert.class, this.alertId);
			execute();
		}
	}

	public String execute() {
		String resultType = Action.SUCCESS;
		if (this.traineeId != null)
			this.trainee = this.service.loadTrainee(this.traineeId);
		if (this.programId != null)
			this.trainingProgram = this.service.loadTrainingProgram(this.programId);

		if (this.firstAlert != null) {
			if (this.trainee != null) {
				this.service.createAlert(this.firstAlert, this.alertType, this.subject, this.body, this.trainee);
				resultType = "trainee";
			} else if (this.trainingProgram != null) {
				this.service.createAlert(this.firstAlert, this.alertType, this.subject, this.body, this.trainingProgram);
				resultType = "program";
			}
		}

		if (this.lastAlert != null) {
			if (this.trainee != null) {
				this.service.createAlert(this.lastAlert, this.alertType, this.subject, this.body, this.trainee);
				resultType = "trainee";
			} else if (this.trainingProgram != null) {
				this.service.createAlert(this.lastAlert, this.alertType, this.subject, this.body, this.trainingProgram);
				resultType = "program";
			}
		}

		return resultType;
	}

	public String remove() {
		String resultType = "unknown";
		this.alert = new Alert();
		alert = (Alert) this.service.find(Alert.class, this.alertId);

		LOG.debug(alert.getSubject());
		// remove alert from trainee
		if (this.traineeId != null && this.alertId != null) {
			this.trainee = (Trainee) this.service.find(Trainee.class, this.traineeId);
			this.service.removeAlert(alert);

			resultType = "trainee";
		}

		// remove alert from training program
		if (this.programId != null && this.alertId != null) {
			this.trainingProgram = (TrainingProgram) this.service.find(TrainingProgram.class, this.programId);
			this.service.removeAlert(alert);

			resultType = "program";
		}

		return resultType;
	}
	
	public String update(){
		String resultType = "unknown";
		this.alert = new Alert();
		this.alert = (Alert) this.service.find(Alert.class, this.alertId);

		// update alert on trainee
		if (this.traineeId != null && this.alertId != null) {
			this.trainee = (Trainee) this.service.find(Trainee.class, this.traineeId);
			alert.setBody(this.body);
			alert.setSubject(this.subject);
			//alert.setGroup(this.trainingProgram);
			alert.setType(this.alertType);
			if(this.firstAlert!=null)
				alert.setAlertDate(this.firstAlert);
			else if(this.lastAlert!=null)
				alert.setAlertDate(this.lastAlert);
			
			this.service.updateAlert(alert);

			resultType = "trainee";
		}

		// update alert on training program
		if (this.programId != null && this.alertId != null) {
			this.trainingProgram = (TrainingProgram) this.service.find(TrainingProgram.class, this.programId);
			
			alert.setBody(this.body);
			alert.setSubject(this.subject);
			//alert.setGroup(this.trainingProgram);
			alert.setType(this.alertType);
			if(this.firstAlert!=null)
				alert.setAlertDate(this.firstAlert);
			else if(this.lastAlert!=null)
				alert.setAlertDate(this.lastAlert);
			
			this.service.updateAlert(alert);

			resultType = "program";
		}
		return resultType;
	}
	
	public String sendAlert() {
		//TODO send alert to trainees and trainers/supervisors
		return Action.SUCCESS;
	}
}