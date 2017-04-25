/**
 * training.Struts Feb 5, 2010
 */
package org.iita.trainingunit.action;

import org.iita.struts.BaseAction;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.service.TrainingProgramService;

import com.opensymphony.xwork2.Action;

/**
 * @author mobreza
 * 
 */
@SuppressWarnings("serial")
public class AddTrainingProgramAction extends BaseAction {
	private String title;
	private TrainingProgramService service;
	private TrainingProgram program;

	/**
	 * 
	 */
	public AddTrainingProgramAction(TrainingProgramService organizationService) {
		this.service = organizationService;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the training
	 */
	public TrainingProgram getProgram() {
		return this.program;
	}

	/**
	 * @see org.iita.struts.BaseAction#execute()
	 */
	@Override
	public String execute() {
		if(this.title != null && this.title.length()>0){
			try {
				this.program = this.service.registerTrainingProgram(this.title);
			} catch (javax.persistence.PersistenceException e) {
				addActionError(e.getMessage());
				return Action.ERROR;
			}
		}else{
			addActionError("Provide group training title to proceed");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
}
