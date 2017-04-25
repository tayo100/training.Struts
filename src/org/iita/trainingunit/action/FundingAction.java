package org.iita.trainingunit.action;

import org.iita.crm.model.Organization;
import org.iita.crm.service.CRMException;
import org.iita.struts.BaseAction;
import org.iita.trainingunit.model.Funding;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.model.Funding.SponsorType;
import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;

@SuppressWarnings("serial")
public class FundingAction extends BaseAction {
	private TrainingUnitService service;
	private Long organizationId;
	private String organizationName;
	private String costCenter;
	private Double estimatedCost;
	private Long traineeId;
	private Long fundingId;
	private Long programId;
	private SponsorType sponsorType;
	private Trainee trainee;
	private TrainingProgram trainingProgram;
	private Funding funding;

	public FundingAction(TrainingUnitService trainingUnitService) {
		this.service = trainingUnitService;
	}

	/**
	 * @param funding the funding to set
	 */
	public void setFunding(Funding funding) {
		this.funding = funding;
	}

	/**
	 * @param traineeId the traineeId to set
	 */
	public void setTraineeId(Long traineeId) {
		this.traineeId = traineeId;
	}
	
	/**
	 * @param fundingId the fundingId to set
	 */
	public void setFundingId(Long fundingId) {
		this.fundingId = fundingId;
	}
	
	/**
	 * @param programId the programId to set
	 */
	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	/**
	 * @return the trainee
	 */
	public Trainee getTrainee() {
		return this.trainee;
	}
	
	/**
	 * @return the trainingProgram
	 */
	public TrainingProgram getTrainingProgram() {
		return this.trainingProgram;
	}

	/**
	 * Used in {@link #addAffiliation()}
	 * 
	 * @param organizationId the organizationId to set
	 */
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * Used in {@link #addAffiliation()}
	 * 
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public void setSponsorType(SponsorType sponsorType) {
		this.sponsorType = sponsorType;
	}
	
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	
	public SponsorType getSponsorType() {
		return sponsorType;
	}

	public String execute() {
		String resultType = Action.SUCCESS;
		
		this.funding = new Funding();
		this.funding.setSponsorType(sponsorType);
		this.funding.setCostCenter(costCenter);
		this.funding.setEstimatedCost(estimatedCost);
		
		if (this.organizationId != null) {
			this.funding.setOrganization(this.service.loadOrganization(this.organizationId));
		} else {
			try {
				Organization organization= this.service.registerOrganization(this.organizationName);
				this.funding.setOrganization(organization);
			} catch (CRMException e) {
				addActionError(e.getMessage());
				return Action.ERROR;
			}
		}
		
		// attach funding to trainee
		if (this.traineeId != null) {
			this.trainee = this.service.loadTrainee(this.traineeId);
			if (trainee != null) {
				trainee.getFundings().add(this.funding);
			}
			resultType = "trainee";
		}
		
		// attach funding to training program
		if (this.programId!=null) {
			this.trainingProgram = this.service.loadTrainingProgram(this.programId);
			if (trainingProgram != null) {
				trainingProgram.getFundings().add(this.funding);
			}
			resultType="program";
		}
		
		this.service.registerFunding(this.funding);

		return resultType;
	}
	
	public String remove(){
		String resultType = "unknown";
		this.funding = new Funding();
		this.funding = (Funding) this.service.find(Funding.class, this.fundingId);
		
		LOG.debug(this.funding.getOrganization().getTitle());
		// attach funding to trainee
		if (this.traineeId != null && this.fundingId != null) {
			this.trainee = this.service.loadTrainee(this.traineeId);
			this.service.removeTraineeFunding(this.trainee, this.funding);
			
			resultType = "trainee";
		}
		
		// attach funding to training program
		if (this.programId!=null && this.fundingId != null) {
			this.trainingProgram = this.service.loadTrainingProgram(this.programId);
			this.service.removeProgramFunding(this.trainingProgram, this.funding);
			
			resultType="program";
		}
		
		return resultType;
	}

	public void setEstimatedCost(Double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public String update(){
		String resultType = "unknown";
		this.funding = new Funding();
		this.funding = (Funding) this.service.find(Funding.class, this.fundingId);
		
		// update funding on trainee
		if (this.traineeId != null && this.fundingId != null) {
			this.trainee = (Trainee) this.service.find(Trainee.class, this.traineeId);
			
			this.funding.setCostCenter(this.costCenter);
			this.funding.setEstimatedCost(this.estimatedCost);
			
			if (this.organizationId != null) {
				this.funding.setOrganization(this.service.loadOrganization(this.organizationId));
			}
			
			this.funding.setSponsorType(this.sponsorType);
			
			this.service.updateFunding(this.funding);

			resultType = "trainee";
		}

		// update funding on training program
		if (this.programId != null && this.fundingId != null) {
			this.trainingProgram = (TrainingProgram) this.service.find(TrainingProgram.class, this.programId);
			
			this.funding.setCostCenter(this.costCenter);
			this.funding.setEstimatedCost(this.estimatedCost);
			
			if (this.organizationId != null) {
				this.funding.setOrganization(this.service.loadOrganization(this.organizationId));
			}
			
			this.funding.setSponsorType(this.sponsorType);
			
			this.service.updateFunding(this.funding);

			resultType = "program";
		}
		
		return resultType;
	}
}
