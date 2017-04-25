package org.iita.trainingunit.cron;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.trainingunit.service.TrainingUnitService;

@SuppressWarnings("serial")
public class AutoAlertNotificationAction implements QuartzJob {
	private static Log LOG = LogFactory.getLog(AutoAlertNotificationAction.class);
	private TrainingUnitService service;
	
	public AutoAlertNotificationAction(TrainingUnitService service){
		this.service = service;
	}
	
	@Override
	public void executeQuartz() {
		LOG.info("Requesting for pending Trainee alert records");
		this.service.requestForPendingAlerts("trainee");
		LOG.info("Requesting for pending Group Training alert records");
		this.service.requestForPendingAlerts("group");
	}

}
