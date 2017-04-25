/**
 * 
 */
package org.iita.trainingunit.iya.action;

import org.iita.crm.action.BaseAction;
import org.iita.crm.model.Person;
import org.iita.security.service.UserService;
import org.iita.trainingunit.iya.model.IYARegistration;
import org.iita.trainingunit.iya.model.IYATrainingAnnouncement;
import org.iita.trainingunit.iya.service.IyaService;
import org.iita.trainingunit.service.TrainingUnitService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

/**
 * @author ken
 *
 */
public class IyaRegistrationEditAction extends BaseAction implements Preparable {
	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	private IyaService iyaService;
	private IYARegistration registration;
	private Person person;
	private IYATrainingAnnouncement announcement;
	private Long id;
	private String fullname;
	public IyaRegistrationEditAction(IyaService iyaService, TrainingUnitService trainingUnitService, UserService userService) {
		this.iyaService = iyaService;
	}
	
	@Override
	public void prepare(){
		super.prepare();
/*		Person person = new Person();
		person = this.trainingUnitService.loadPerson(this.personId);
		this.registration.set
		this.registration.setPerson(person);
		//this.setFullname(person.getFullName());
		
		
		User user = null;
		user = this.userService.lookup(facilitator.getEmail(), true);
		
		if(user!=null)
			facilitator.setNames(user.getFullName());
		person.getFullName()
*/
		
		
		
		if (this.id != null)
			this.registration = this.iyaService.loadRegistration(id);
	}

	public String edit(){
/*		if(this.person!=null)
			this.person.setPerson(this);
		this.announcement.setOrganizer(this.organizer);
		
		if(this.sponsor!=null)
		this.announcement.setSponsor(this.sponsor);*/
		
		if (this.registration != null){
			if (this.registration.getId() != null)
				this.iyaService.updateRegistration(this.registration);
		}
		return Action.SUCCESS;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param iyaTrainingAnnouncement the iyaTrainingAnnouncement to set
	 */
	public void setIyaTrainingAnnouncement(IYATrainingAnnouncement iyaTrainingAnnouncement) {
		this.announcement = iyaTrainingAnnouncement;
	}

	/**
	 * @return the iyaTrainingAnnouncement
	 */
	public IYATrainingAnnouncement getIyaTrainingAnnouncement() {
		return announcement;
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
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}
	

}
