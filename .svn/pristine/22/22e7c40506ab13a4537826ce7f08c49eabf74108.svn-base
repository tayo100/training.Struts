package org.iita.crm.action;

import org.iita.crm.model.Contact;
import org.iita.crm.model.Organization;
import org.iita.crm.model.Partner;
import org.iita.crm.model.Person;
import org.iita.crm.service.CoreCRMService;
import org.iita.struts.BaseAction;

import com.opensymphony.xwork2.Action;

@SuppressWarnings("serial")
public class UpdateContactAction extends BaseAction {
	private CoreCRMService service;
	private Person person = null;
	private Organization organization = null;
	private Partner partner = null;
	private Contact contact = null;
	private String type; // this contains class name of {@link Contact}
	private Long id = null;
	private Long personId = null;
	private Long organizationId = null;
	private Long partnerId = null;

	public UpdateContactAction(CoreCRMService service) {
		this.service = service;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPersonId(Long id) {
		this.personId = id;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganizationId(Long id) {
		this.organizationId = id;
	}
	
	/**
	 * @param partner the partner to set
	 */
	public void setPartnerId(Long id) {
		this.partnerId = id;
	}

	public Contact getContact() {
		return contact;
	}

	@Override
	public void prepare() {
		if (this.id == null && this.type != null) {
			// create instance of appropriate type
			try {
				this.contact = (Contact) Class.forName(this.type).newInstance();
				if (this.personId != null) {
					this.person = this.service.loadPerson(this.personId);
					this.contact.setPerson(this.person);
				} else if (this.organizationId != null) {
					this.organization = this.service.loadOrganization(this.organizationId);
					this.contact.setOrganization(this.organization);
				} else if (this.partnerId != null) {
					this.partner = this.service.loadPartner(this.partnerId);
					this.contact.setPartner(this.partner);
				}
			} catch (Exception e) {
				addActionError("Could not instantiate contact of type " + this.type);
			}
		} else if (this.id != null) {
			// load contact to edit
			this.contact = this.service.loadContact(this.id);
			this.person = this.contact.getPerson();
			this.organization = this.contact.getOrganization();
			this.partner = this.contact.getPartner();
		}
	}

	@Override
	public String execute() {
		return Action.SUCCESS;
	}

	public String updateContact() {
		this.service.updateContact(this.contact);
		if (this.contact.getPerson() != null)
			return "reload";
		else if (this.contact.getOrganization() != null)
			return "reload-organization";
		else if (this.contact.getPartner() != null)
			return "reload-partner";
	
		return Action.SUCCESS;
	}

	// Remove address from Person's profile
	public String remove() {
		if (this.contact != null) {
			if (this.contact.getPerson() != null) {
				this.service.removeContact(this.contact);
				return "reload";
			} else if (this.contact.getOrganization() != null) {
				this.service.removeContact(this.contact);
				return "reload-organization";
			} else if (this.contact.getPartner() != null) {
				this.service.removeContact(this.contact);
				return "reload-partner";
			}
		}
		addActionError("Could not remove contact");
		return Action.ERROR;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return this.person;
	}
	
	/**
	 * @return the partner
	 */
	public Partner getPartner() {
		return this.partner;
	}

	/**
	 * @return the organization
	 */
	public Organization getOrganization() {
		return this.organization;
	}
}
