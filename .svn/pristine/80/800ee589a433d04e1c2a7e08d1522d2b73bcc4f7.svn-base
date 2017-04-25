package org.iita.trainingunit.applications.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.search.annotations.ClassBridge;
import org.hibernate.search.annotations.Indexed;
import org.iita.crm.lucene.IndividualBridge;
import org.iita.crm.model.ApplicationTag;
import org.iita.crm.model.EntityTag;
import org.iita.security.model.User;

@Entity
@Indexed
@ClassBridge(impl = IndividualBridge.class)
public class IndividualTraining extends Application {
	private static final long serialVersionUID = 290487080048218035L;	
	private List<ApplicationTag> tags;	
	/**
	 * @see org.iita.cdo.model.UserAccess#hasAccess(org.iita.security.model.User)
	 */
	@Override
	public boolean hasAccess(User user) {		
		if(super.getStatus()==APPLICATIONSTATUS.APPROVED)
			return true;
		
		if (super.getBiodata().getId().equals(user.getId())) {
			return true;
		}
		return false;
	}

	/**
	 * @return the tags
	 */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "entity")
	public List<ApplicationTag> getTags() {
		return this.tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<ApplicationTag> tags) {
		this.tags = tags;
	}

	@Override
	@Transient
	public Class<? extends EntityTag<Application>> getTagClass() {
		return ApplicationTag.class;
	}

	@Override
	public EntityTag<Application> createTag() {
		return new ApplicationTag();
	}
}