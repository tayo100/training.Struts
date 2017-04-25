package org.iita.trainingunit.action;

import org.iita.crm.action.TagBuilderAction;
import org.iita.crm.service.CoreCRMService;
import org.iita.trainingunit.model.TrainingProgram;

/**
 * @author koraegbunam
 *
 */

@SuppressWarnings("serial")
public class TrainingProgramTagBuilderAction extends TagBuilderAction<TrainingProgram> {
	/**
	 * @param coreCRMService 
	 * 
	 */
	public TrainingProgramTagBuilderAction(CoreCRMService coreCRMService) {
		super(coreCRMService);
	}
	
	/**
	 * @see org.iita.training.action.TagBuilderAction#loadProfile(java.lang.Long)
	 */
	@Override
	protected TrainingProgram loadProfile(Long id) {
		return this.coreCRMService.find(TrainingProgram.class, id);
	}
}
