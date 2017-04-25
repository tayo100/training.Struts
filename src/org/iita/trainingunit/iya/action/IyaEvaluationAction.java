/**
 * 
 */
package org.iita.trainingunit.iya.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.crm.action.BaseAction;
import org.iita.trainingunit.iya.model.IYAEvaluation;
import org.iita.trainingunit.iya.model.IYARegistration;
import org.iita.trainingunit.iya.model.IYATrainingAnnouncement;
import org.iita.trainingunit.iya.service.IyaService;
import org.iita.util.PagedResult;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;


public class IyaEvaluationAction extends BaseAction implements Preparable {
	
	private static final Log LOG = LogFactory.getLog(IyaEvaluationAction.class);
	private IyaService iyaService;
	private PagedResult<IYAEvaluation> paged;
	private IYAEvaluation evaluation;
	private IYARegistration registration;
	private IYATrainingAnnouncement IYAtrn;	
	protected int startAt = 0, maxResults = 50;
	private Long id;
	private Long regId;
	//private String objectivesMet, subjectMastery, courseDelivery, classInteraction ; 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IyaEvaluationAction(IyaService iyaService) {
		this.iyaService = iyaService;
	}
	
	@Override
	public void prepare() {
		super.prepare();
		this.paged = this.iyaService.iyaEvaluations(this.startAt, this.maxResults);	
		
		if(this.id != null){
			this.evaluation = this.iyaService.loadEvaluation(this.id);
		}
		if(this.regId != null)
			this.registration = this.iyaService.loadRegistration(this.regId);				
	}
	
	public String list(){
		
		return Action.SUCCESS;
		
	}
	
	public String input(){
		return "input";
	}
	/**
	 * @return the paged
	 */
	public PagedResult<IYAEvaluation> getPaged() {
		return paged;
	}
	
	public String saveEvaluation(){
		if(this.evaluation==null)
			this.evaluation = new IYAEvaluation();
		
		if(this.regId != null)
			this.registration = this.iyaService.loadRegistration(this.regId);
		
		this.evaluation.setIyaRegistration(this.registration);
		this.evaluation = this.iyaService.saveEvaluation(this.evaluation);

		return Action.SUCCESS;		
	}

	public String details(){		
		if(this.evaluation==null)
			return Action.ERROR;
		else
			return Action.SUCCESS;
	}
	
	public String removeEvaluation() throws Exception {
		this.evaluation = this.iyaService.loadEvaluation(id);

		try {
			this.iyaService.ensureRemoved(this.evaluation);
		}
		catch (javax.persistence.PersistenceException e) {
			addActionError("Evaluation could not be removed due to constraints violation.");
			return Action.ERROR;
		}
 		return Action.SUCCESS;
	}

	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	/**
	 * @param evaluation the evaluation to set
	 */
	public void setEvaluation(IYAEvaluation evaluation) {
		this.evaluation = evaluation;
	}

	/**
	 * @return the evaluation
	 */
	public IYAEvaluation getEvaluation() {
		return evaluation;
	}
	/**
	 * @param id the regId to set
	 */
	public void setRegId(Long regId) {
		this.regId = regId;
	}
	
	public Long getRegId() {
		return regId;
	}

	/**
	 * @return the log
	 */
	public static Log getLog() {
		return LOG;
	}
	
	/**
	 * @param registration the registration to set
	 */
	public void setRegistration(IYARegistration registration) {
		this.registration = registration;
	}

	/**
	 * @return the registration
	 */
	public IYARegistration getRegistration() {
		return registration;
	}

	/**
	 * @return the iYAtrn
	 */
	public IYATrainingAnnouncement getIYAtrn() {
		return IYAtrn;
	}

	/**
	 * @param iYAtrn the iYAtrn to set
	 */
	public void setIYAtrn(IYATrainingAnnouncement iYAtrn) {
		IYAtrn = iYAtrn;
	}
	
	
}
