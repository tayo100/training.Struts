package org.iita.crm.action;

import java.util.Date;
import java.util.List;

import org.iita.crm.model.Affiliation;
import org.iita.crm.model.Contact;
import org.iita.crm.model.Organization;
import org.iita.crm.model.Person;
import org.iita.crm.model.PersonMail;
import org.iita.crm.model.Affiliation.AffiliationType;
import org.iita.crm.service.CRMException;
import org.iita.crm.service.CoreCRMService;
import org.iita.security.service.UserService;
import org.iita.trainingunit.model.Alumni;
import org.iita.trainingunit.service.AlumniService;
import org.springframework.dao.DataIntegrityViolationException;

import com.opensymphony.xwork2.Action;

@SuppressWarnings("serial")
public class PersonProfileAction extends BaseProfileAction<Person> {
	private CoreCRMService service;
	private AlumniService alumniService;
	private List<Contact> contacts;
	protected Person person;
	private AffiliationType affiliationType;
	private Long organizationId;
	private String organizationName;
	private List<Person> similarPersons;
	private List<PersonMail> mail;
	private Long userId;
	private UserService userService;
	private Alumni alumni;
	
	private String staffId;
	private String channel;
	private String text;
	private String subject;
	private String jobTitle;
	private String department;
	private String contactedby;
	private Date startDate;
	private Date endDate;

	public PersonProfileAction(CoreCRMService service, AlumniService alumniService) {
		this.service = service;
		this.alumniService = alumniService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getContactedby() {
		return contactedby;
	}

	public void setContactedby(String contactedby) {
		this.contactedby = contactedby;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * @param alumniService the alumniService to set
	 */
	//public void setAlumniService(AlumniService alumniService) {
	//	this.alumniService = alumniService;
	//}

	public List<Contact> getContacts() {
		return contacts;
	}
	
	/**
	 * @return the alumni
	 */
	public Alumni getAlumni() {
		return alumni;
	}

	@Override
	protected Person loadProfile() {
		this.person = this.service.loadPerson(this.id);
		return person;
	}

	/**
	 * Used in {@link #addAffiliation()}
	 * 
	 * @param affiliationType the affiliationType to set
	 */
	public void setAffiliationType(AffiliationType affiliationType) {
		this.affiliationType = affiliationType;
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
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Used in {@link #addAffiliation()}
	 * 
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @return the similarPersons
	 */
	public List<Person> getSimilarPersons() {
		return this.similarPersons;
	}

	/**
	 * @return the mail
	 */
	public List<PersonMail> getMail() {
		return this.mail;
	}

	@Override
	public String execute() {
		this.contacts = this.service.loadContacts(this.person);
		this.similarPersons = this.service.getSimilarPersons(this.person, 5);
		this.mail = this.service.listPersonMail(this.person, 0, 10).getResults();
		this.alumni = this.alumniService.getAlumniInfo(this.person);
		return Action.SUCCESS;
	}

	public String addAffiliation() {
		Affiliation affiliation = new Affiliation();
		affiliation.setType(this.affiliationType);
		affiliation.setPerson(this.profile);
		
		affiliation.setJobTitle(this.jobTitle);
		affiliation.setDepartment(this.department);
		affiliation.setChannel(this.channel);
		affiliation.setEndDate(this.endDate);
		affiliation.setStaffId(this.staffId);
		affiliation.setStartDate(this.startDate);
		affiliation.setSubject(this.subject);
		affiliation.setText(this.text);
		affiliation.setContactedby(this.contactedby);
		
		if (this.organizationId != null) {
			affiliation.setOrganization(this.service.loadOrganization(this.organizationId));
		} else {
			try {
				Organization organization = this.service.registerOrganization(this.organizationName);
				affiliation.setOrganization(organization);
			} catch (CRMException e) {
				addActionError(e.getMessage());
				return Action.ERROR;
			}
		}
		this.service.update(affiliation);
		return "reload";
	}

	public String update() {
		if (this.userId != null && this.userService != null) {
			this.profile.setUser(this.userService.find(this.userId));
		} else if (this.profile.getUser()!=null) {
			this.profile.setUser(null);
		}
		
		if(this.profile.getAlumniStatus()!=null){
			if(this.profile.getAlumniStatus().equals(Person.AlumniStatus.YES)){
				Alumni alumnus = new Alumni();
				alumnus.setPerson(this.profile);
				this.alumniService.addAlumnus(alumnus);
			}
		}
		this.service.update(this.profile);
		return "reload";
	}

	public String delete() {
		try {
			this.service.delete(this.profile);
		} catch (DataIntegrityViolationException e) {
			addActionError("Could not delete Person. Other data relies on it.");
			return Action.ERROR;
		}
		return "tolist";
	}
}
