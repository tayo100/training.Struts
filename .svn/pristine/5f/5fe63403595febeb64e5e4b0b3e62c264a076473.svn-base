/**
 * training.Struts Feb 5, 2010
 */
package org.iita.crm.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import org.hibernate.search.annotations.ClassBridge;
import org.hibernate.search.annotations.Indexed;
import org.iita.entity.VersionedEntity;

import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

/**
 * @author mobreza
 * 
 */
@Entity
@Indexed
@ClassBridge(impl = org.iita.crm.lucene.OrganizationBridge.class)
public class Organization extends VersionedEntity implements Taggable<Organization> {
	private static final long serialVersionUID = 4946010927958223657L;
	private String title;
	private String shortName;
	private OrganizationType type;
	private List<Affiliation> affiliations;
	private Organization parent;
	private List<Organization> subOrganizations;
	private List<OrganizationTag> tags;
	private List<OrganizationDocument> documents;

	/** The contacts. */
	private List<Contact> contacts = new ArrayList<Contact>();

	public enum OrganizationType {
		UNIVERSITY, PRIVATE, CGIAR, NGO, GOVERNMENT
	}

	/**
	 * @return the title
	 */
	@Column(length = 200, nullable = false, unique = false)
	public String getTitle() {
		return this.title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the type
	 */
	@Enumerated(EnumType.STRING)
	public OrganizationType getType() {
		return this.type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(OrganizationType type) {
		this.type = type;
	}

	/**
	 * @return the affiliations
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "organization")
	public List<Affiliation> getAffiliations() {
		return this.affiliations;
	}

	/**
	 * @param affiliations the affiliations to set
	 */
	public void setAffiliations(List<Affiliation> affiliations) {
		this.affiliations = affiliations;
	}

	/**
	 * @return the shortName
	 */
	@Column(length = 100)
	public String getShortName() {
		return this.shortName;
	}

	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		if (shortName != null && shortName.trim().length() == 0)
			shortName = null;
		this.shortName = shortName;
	}

	/**
	 * @return the contacts
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "organization")
	public List<Contact> getContacts() {
		return this.contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	/**
	 * Parent organization
	 * 
	 * @return the parent
	 */
	@ManyToOne(cascade = {}, optional = true)
	public Organization getParent() {
		return this.parent;
	}

	/**
	 * @param parent the parent to set
	 */
	@TypeConversion(converter = "genericConverter")
	public void setParent(Organization parent) {
		this.parent = parent;
	}

	/**
	 * @return the subOrganizations
	 */
	@OneToMany(cascade = {}, mappedBy = "parent")
	public List<Organization> getSubOrganizations() {
		return this.subOrganizations;
	}

	/**
	 * @param subOrganizations the subOrganizations to set
	 */
	public void setSubOrganizations(List<Organization> subOrganizations) {
		this.subOrganizations = subOrganizations;
	}

	/**
	 * @return the tags
	 */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "entity")
	public List<OrganizationTag> getTags() {
		return this.tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<OrganizationTag> tags) {
		this.tags = tags;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%1$s (%2$s)", this.title, this.shortName);
	}

	@Transient
	public String getFullTitle() {
		if (this.shortName != null)
			return String.format("%1$s (%2$s)", this.title, this.shortName);
		else
			return this.title;
	}

	/**
	 * @return the documents
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "entity")
	@OrderBy("id desc")
	public List<OrganizationDocument> getDocuments() {
		return this.documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<OrganizationDocument> documents) {
		this.documents = documents;
	}
	
	/**
	 * @see org.iita.crm.model.Taggable#createTag()
	 */
	@Override
	public EntityTag<Organization> createTag() {
		return new OrganizationTag();
	}
	
	/**
	 * @see org.iita.crm.model.Taggable#getTagClass()
	 */
	@Override
	@Transient
	public Class<? extends EntityTag<Organization>> getTagClass() {
		return OrganizationTag.class;
	}
	
	@Transient
	public String getLegalName(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this organization
		if(this.title!=null){
			if(this.shortName!=null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(this.shortName).append(": ").append(this.title);
				else
					sb.append(this.shortName).append(": ").append(this.title);
			}else{
				if(!sb.toString().isEmpty())
					sb.append(", ").append(this.title);
				else
					sb.append(this.title);
			}
		}else if(this.shortName!=null){
			if(!sb.toString().isEmpty())
				sb.append(", ").append(this.shortName);
			else
				sb.append(this.shortName);
		}
		return sb.toString().trim().replaceAll(",$", "");
	}
	
	@Transient
	public String getAddress(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this organization
		for(Contact c : contacts){
			if(c instanceof AddressContact){
				AddressContact ac = (AddressContact) c;
				if(ac!=null)
					if(ac.getAddress()!=null)
						if(!sb.toString().isEmpty())
							sb.append(", ").append(ac.getAddress());
						else
							sb.append(ac.getAddress());
			}
		}
		return sb.toString().trim().replaceAll(",$", "");
	}
	
	@Transient
	public String getAddressCity(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this organization
		for(Contact c : contacts){
			if(c instanceof AddressContact){
				AddressContact ac = (AddressContact) c;
				if(ac!=null)
					if(ac.getCity()!=null)
						if(!sb.toString().isEmpty())
							sb.append(", ").append(ac.getCity());
						else
							sb.append(ac.getCity());
			}
		}
		return sb.toString().trim().replaceAll(",$", "");
	}
	
	@Transient
	public String getAddressState(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this organization
		for(Contact c : contacts){
			if(c instanceof AddressContact){
				AddressContact ac = (AddressContact) c;
					if(ac!=null)
						if(ac.getState()!=null)
							if(!sb.toString().isEmpty())
								sb.append(", ").append(ac.getState());
							else
								sb.append(ac.getState());
			}
		}
		return sb.toString().trim().replaceAll(",$", "");
	}
	
	@Transient
	public String getAddressCountry(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this organization
		for(Contact c : contacts){
			if(c instanceof AddressContact){
				AddressContact ac = (AddressContact) c;
					if(ac!=null)
						if(ac.getCountry()!=null)
							if(!sb.toString().isEmpty())
								sb.append(", ").append(ac.getCountry());
							else
								sb.append(ac.getCountry());
			}
		}
		return sb.toString().trim().replaceAll(",$", "");
	}
	
	@Transient
	public String getEmailContacts(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this organization
		for(Contact c : contacts){
			if(c instanceof EmailContact){
				EmailContact ac = (EmailContact) c;
					if(ac!=null)
						if(ac.getEmail()!=null)
							if(!sb.toString().isEmpty())
								sb.append(", ").append(ac.getEmail());
							else
								sb.append(ac.getEmail());
			}
		}
		return sb.toString().trim().replaceAll(",$", "");
	}
	
	@Transient
	public String getPhoneContacts(){
		StringBuffer sb = new StringBuffer();
		
		//Address of this organization
		for(Contact c : contacts){
			if(c instanceof PhoneContact){
				PhoneContact ac = (PhoneContact) c;
					if(ac!=null)
						if(ac.getPhoneNumber()!=null)
							if(!sb.toString().isEmpty())
								sb.append(", ").append(ac.getPhoneNumber());
							else
								sb.append(ac.getPhoneNumber());
			}
		}
		return sb.toString().trim().replaceAll(",$", "");
	}
}
