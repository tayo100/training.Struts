package org.iita.crm.action;

import org.iita.crm.model.Person;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

import com.opensymphony.xwork2.Action;

@SuppressWarnings("serial")
public class AddPersonAction extends BaseAction {
	private CoreCRMService service;
	private String lastName;
	private String firstName;
	private Person person;
	
	public AddPersonAction(CoreCRMService service) {
		this.service = service;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public Person getPerson() {
		return person;
	}
	
	
	@Override
	public String execute() {
		this.person=new Person();
		person.setLastName(this.lastName);
		person.setFirstName(this.firstName);
		this.service.registerPerson(person);
		
		return Action.SUCCESS;
	}
}
