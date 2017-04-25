/**
 * training.Struts Oct 13, 2010
 */
package org.iita.trainingunit.action;

import org.iita.crm.action.TagAction;
import org.iita.crm.model.AnnouncementTag;
import org.iita.crm.model.ApplicationTag;
import org.iita.crm.model.Organization;
import org.iita.crm.model.OrganizationTag;
import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerTag;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.applications.model.Application;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.TraineeTag;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.model.TrainingProgramTag;
import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

/**
 * @author koraegbunam
 * 
 */
@SuppressWarnings("serial")
public class TrainingUnitTagAction extends TagAction {
	private TrainingUnitService trainingUnitService;
	private Organization organization;
	private Partner partner;
	private String tagValue;
	private TrainingProgram trainingProgram;
	private Trainee trainee;
	private Announcement announcement;
	private Application application;

	/**
	 * @param crmService
	 */
	public TrainingUnitTagAction(TrainingUnitService trainingUnitService) {
		super(trainingUnitService);
		this.trainingUnitService = trainingUnitService;
		this.tag = new TrainingProgramTag();
	}

	@TypeConversion(converter = "genericConverter")
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	@TypeConversion(converter = "genericConverter")
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	
	@TypeConversion(converter = "genericConverter")
	public void setTrainingProgram(TrainingProgram trainingProgram) {
		this.trainingProgram = trainingProgram;
	}
	
	@TypeConversion(converter = "genericConverter")
	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}
	
	@TypeConversion(converter = "genericConverter")
	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}
	
	@TypeConversion(converter = "genericConverter")
	public void setApplication(Application application) {
		this.application = application;
	}

	/**
	 * @param tagValue the tagValue to set
	 */
	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
		if (this.tag != null) {
			this.tag.setTag(this.tagValue);
		}
	}

	/**
	 * @see org.iita.crm.action.TagAction#prepare()
	 */
	@Override
	public void prepare() {
		if (this.id != null) {
			if (this.organization != null)
				this.tag = this.trainingUnitService.loadTag(OrganizationTag.class, this.id);
			else if (this.trainingProgram != null)
				this.tag = this.trainingUnitService.loadTag(TrainingProgramTag.class, this.id);
			else if (this.trainee != null)
				this.tag = this.trainingUnitService.loadTag(TraineeTag.class, this.id);
			else if (this.partner != null)
				this.tag = this.trainingUnitService.loadTag(PartnerTag.class, this.id);
			else if (this.announcement != null)
				this.tag = this.trainingUnitService.loadTag(AnnouncementTag.class, this.id);
			else if (this.application != null)
				this.tag = this.trainingUnitService.loadTag(ApplicationTag.class, this.id);
			LOG.info("Loaded tag: " + this.tag);
		} else {
			LOG.info("Creating new TrainingUnit tag");

			if (this.organization != null) {
				OrganizationTag mytag = new OrganizationTag();
				mytag.setEntity(this.organization);
				this.tag = mytag;
			} else if (this.trainingProgram != null) {
				TrainingProgramTag mytag = new TrainingProgramTag();
				mytag.setEntity(this.trainingProgram);
				this.tag = mytag;
			} else if (this.trainee != null) {
				TraineeTag mytag = new TraineeTag();
				mytag.setEntity(this.trainee);
				this.tag = mytag;
			} else if (this.partner != null) {
				PartnerTag mytag = new PartnerTag();
				mytag.setEntity(this.partner);
				this.tag = mytag;
			} else if (this.announcement != null) {
				AnnouncementTag mytag = new AnnouncementTag();
				mytag.setEntity(this.announcement);
				this.tag = mytag;
			} else if (this.application != null) {
				ApplicationTag mytag = new ApplicationTag();
				mytag.setEntity(this.application);
				this.tag = mytag;
			}
			
		}
	}
	
	@Override
	public String update() {
		this.crmService.update(this.tag);
		if(this.tag instanceof TrainingProgramTag)
			return "program";
		else if(this.tag instanceof OrganizationTag)
			return "organization";
		else if(this.tag instanceof TraineeTag)
			return "trainee";
		else if(this.tag instanceof PartnerTag)
			return "partner";
		else if(this.tag instanceof AnnouncementTag)
			return "announcement";
		else if(this.tag instanceof ApplicationTag)
			return "application";
		else
			return Action.SUCCESS;
	}
	
	@Override
	public String remove() {
		this.crmService.remove(this.tag);
		if(this.tag instanceof TrainingProgramTag)
			return "program";
		else if(this.tag instanceof OrganizationTag)
			return "organization";
		else if(this.tag instanceof TraineeTag)
			return "trainee";
		else if(this.tag instanceof PartnerTag)
			return "partner";
		else if(this.tag instanceof AnnouncementTag)
			return "announcement";
		else if(this.tag instanceof ApplicationTag)
			return "application";
		else
			return Action.SUCCESS;
	}
}
