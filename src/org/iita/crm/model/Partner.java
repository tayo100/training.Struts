/**
 * training.Struts Feb 5, 2010
 */
package org.iita.crm.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.search.annotations.ClassBridge;
import org.hibernate.search.annotations.Indexed;
import org.iita.crm.model.PartnerIITAHub.IITAHub;
import org.iita.entity.VersionedEntity;

import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

/**
 * @author KOraegbunam
 * 
 */
@Entity
@Indexed
@ClassBridge(impl = org.iita.crm.lucene.PartnerBridge.class)
public class Partner extends VersionedEntity implements Taggable<Partner> {
	private static final long serialVersionUID = 4946010927958229857L;
	private String title;
	private String shortName;
	private String department;
	private String partnershipType;
	private String partnershipAgreement;
	private String sourceFile;
	private String sourcePerson;
	private Date dateSubmitted;
	private String notes;
	
	private List<PartnerClassification> classifications;
	private List<PartnerCategory> partnerCategories;
	private List<PartnerCoreBusiness> coreBusinesses;
	
	private List<PartnerCoreBusinessCategory> coreBusinessCategories;
	private List<PartnerScale> scales;
	private List<PartnerSector> sectors;
	private List<PartnerSubsector> subsectors;
	
	private List<PartnerMandateCrop> mandateCrops;
	private List<PartnerPersonContact> partnerContacts;
	private List<PartnerIITAHub> iitaHubs;
	
	private Partner parent;
	private List<Partner> subPartners;
	private List<PartnerTag> tags;
	private List<PartnerDocument> documents;


	
	/** The contacts. */
	private List<Contact> contacts = new ArrayList<Contact>();
	
	
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
	 * @return the classifications
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "partner")
	public List<PartnerClassification> getClassifications() {
		return this.classifications;
	}

	/**
	 * @param classifications the classifications to set
	 */
	public void setClassifications(List<PartnerClassification> classifications) {
		this.classifications = classifications;
	}
	
	/**
	 * @return the partnerCategories
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "partner")
	public List<PartnerCategory> getPartnerCategories() {
		return this.partnerCategories;
	}

	/**
	 * @param partnerCategories the partnerCategories to set
	 */
	public void setPartnerCategories(List<PartnerCategory> partnerCategories) {
		this.partnerCategories = partnerCategories;
	}
	
	/**
	 * @return the coreBusinesses
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "partner")
	public List<PartnerCoreBusiness> getCoreBusinesses() {
		return this.coreBusinesses;
	}

	/**
	 * @param coreBusinesses the coreBusinesses to set
	 */
	public void setCoreBusinesses(List<PartnerCoreBusiness> coreBusinesses) {
		this.coreBusinesses = coreBusinesses;
	}
	
	/**
	 * @return the iitaHubs
	 */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "partner")
	public List<PartnerIITAHub> getIitaHubs() {
		return this.iitaHubs;
	}

	/**
	 * @param iitaHubs the iitaHubs to set
	 */
	public void setIitaHubs(List<PartnerIITAHub> iitaHubs) {
		this.iitaHubs = iitaHubs;
	}
	
	/**
	 * @return the mandateCrops
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "partner")
	public List<PartnerMandateCrop> getMandateCrops() {
		return this.mandateCrops;
	}

	/**
	 * @param mandateCrops the mandateCrops to set
	 */
	public void setMandateCrops(List<PartnerMandateCrop> mandateCrops) {
		this.mandateCrops = mandateCrops;
	}
	
	/**
	 * @return the partnerContacts
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "partner")
	public List<PartnerPersonContact> getPartnerContacts() {
		return this.partnerContacts;
	}

	/**
	 * @param partnerContacts the partnerContacts to set
	 */
	public void setPartnerContacts(List<PartnerPersonContact> partnerContacts) {
		this.partnerContacts = partnerContacts;
	}

	/**
	 * @return the contacts
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "partner")
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
	 * Parent partner
	 * 
	 * @return the parent
	 */
	@ManyToOne(cascade = {}, optional = true)
	public Partner getParent() {
		return this.parent;
	}

	/**
	 * @param parent the parent to set
	 */
	@TypeConversion(converter = "genericConverter")
	public void setParent(Partner parent) {
		this.parent = parent;
	}

	/**
	 * @return the subPartners
	 */
	@OneToMany(cascade = {}, mappedBy = "parent")
	public List<Partner> getSubPartners() {
		return this.subPartners;
	}

	/**
	 * @param subPartners the subPartners to set
	 */
	public void setSubPartners(List<Partner> subPartners) {
		this.subPartners = subPartners;
	}

	/**
	 * @return the tags
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "entity")
	public List<PartnerTag> getTags() {
		return this.tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<PartnerTag> tags) {
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
	public List<PartnerDocument> getDocuments() {
		return this.documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<PartnerDocument> documents) {
		this.documents = documents;
	}
	
	/**
	 * @see org.iita.crm.model.Taggable#createTag()
	 */
	@Override
	public EntityTag<Partner> createTag() {
		return new PartnerTag();
	}
	
	/**
	 * @see org.iita.crm.model.Taggable#getTagClass()
	 */
	@Override
	@Transient
	public Class<? extends EntityTag<Partner>> getTagClass() {
		return PartnerTag.class;
	}
	
	@Transient
	public String getReportClassifications(){
		StringBuffer sb = new StringBuffer();
		
		for (PartnerClassification classy : this.classifications) {
			if(classy != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(classy.getType());
				else
					sb.append(classy.getType());
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportTags(){
		StringBuffer sb = new StringBuffer();
		
		for (PartnerTag tag : this.tags) {
			if(tag != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(tag.getTag());
				else
					sb.append(tag.getTag());
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportAddressContacts(){
		StringBuffer sb = new StringBuffer();
		
		for (Contact ct : this.contacts) {
			if(ct != null){
				if (ct instanceof AddressContact){
					AddressContact ac = (AddressContact) ct;
					if(!sb.toString().isEmpty())
						sb.append(", ").append(ac.getAddress());
					else
						sb.append(ac.getAddress());
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportCityContacts(){
		StringBuffer sb = new StringBuffer();
		
		for (Contact ct : this.contacts) {
			if(ct != null){
				if (ct instanceof AddressContact){
					AddressContact ac = (AddressContact) ct;
					if(!sb.toString().isEmpty())
						sb.append(", ").append(ac.getCity());
					else
						sb.append(ac.getCity());
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportStateContacts(){
		StringBuffer sb = new StringBuffer();
		
		for (Contact ct : this.contacts) {
			if(ct != null){
				if (ct instanceof AddressContact){
					AddressContact ac = (AddressContact) ct;
					if(!sb.toString().isEmpty())
						sb.append(", ").append(ac.getState());
					else
						sb.append(ac.getState());
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportCountryContacts(){
		StringBuffer sb = new StringBuffer();
		
		for (Contact ct : this.contacts) {
			if(ct != null){
				if (ct instanceof AddressContact){
					AddressContact ac = (AddressContact) ct;
					if(!sb.toString().isEmpty())
						sb.append(", ").append(ac.getCountry());
					else
						sb.append(ac.getCountry());
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportContinentContacts(){
		StringBuffer sb = new StringBuffer();
		
		for (Contact ct : this.contacts) {
			if(ct != null){
				if (ct instanceof AddressContact){
					AddressContact ac = (AddressContact) ct;
					if(!sb.toString().isEmpty())
						sb.append(", ").append(ac.getContinent());
					else
						sb.append(ac.getContinent());
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportEmailContacts(){
		StringBuffer sb = new StringBuffer();
		
		for (Contact ct : this.contacts) {
			if(ct != null){
				if (ct instanceof EmailContact){
					EmailContact em = (EmailContact) ct;
					if(!sb.toString().isEmpty())
						sb.append(", ").append(em.getEmail());
					else
						sb.append(em.getEmail());
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportPhoneContacts(){
		StringBuffer sb = new StringBuffer();
		
		for (Contact ct : this.contacts) {
			if(ct != null){
				if (ct instanceof PhoneContact){
					PhoneContact pc = (PhoneContact) ct;
					if(!sb.toString().isEmpty())
						sb.append(", ").append(pc.getPhoneNumber());
					else
						sb.append(pc.getPhoneNumber());
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportMobileContacts(){
		StringBuffer sb = new StringBuffer();
		
		for (Contact ct : this.contacts) {
			if(ct != null){
				if (ct instanceof MobileContact){
					MobileContact pc = (MobileContact) ct;
					if(!sb.toString().isEmpty())
						sb.append(", ").append(pc.getMobileNumber());
					else
						sb.append(pc.getMobileNumber());
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportFaxContacts(){
		StringBuffer sb = new StringBuffer();
		
		for (Contact ct : this.contacts) {
			if(ct != null){
				if (ct instanceof FaxContact){
					FaxContact pc = (FaxContact) ct;
					if(!sb.toString().isEmpty())
						sb.append(", ").append(pc.getFaxNumber());
					else
						sb.append(pc.getFaxNumber());
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportWebContacts(){
		StringBuffer sb = new StringBuffer();
		
		for (Contact ct : this.contacts) {
			if(ct != null){
				if (ct instanceof WebsiteContact){
					WebsiteContact wc = (WebsiteContact) ct;
					if(!sb.toString().isEmpty())
						sb.append(", ").append(wc.getUrl());
					else
						sb.append(wc.getUrl());
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportIitaHubs(){
		StringBuffer sb = new StringBuffer();
		
		for (PartnerIITAHub hub : this.iitaHubs) {
			if(hub != null){
				if(!sb.toString().isEmpty()){
					if(hub.gethub().equals(IITAHub.CENTRALAFRICA))
						sb.append(", ").append("Central Africa");
					if(hub.gethub().equals(IITAHub.WESTERNAFRICA))
						sb.append(", ").append("Western Africa");
					if(hub.gethub().equals(IITAHub.SOUTHERNAFRICA))
						sb.append(", ").append("Southern Africa");
					if(hub.gethub().equals(IITAHub.EASTERNAFRICA))
						sb.append(", ").append("Eastern Africa");
				}else{
					if(hub.gethub().equals(IITAHub.CENTRALAFRICA))
						sb.append("Central Africa");
					if(hub.gethub().equals(IITAHub.WESTERNAFRICA))
						sb.append("Western Africa");
					if(hub.gethub().equals(IITAHub.SOUTHERNAFRICA))
						sb.append("Southern Africa");
					if(hub.gethub().equals(IITAHub.EASTERNAFRICA))
						sb.append("Eastern Africa");
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportPersonContacts(){
		StringBuffer sb = new StringBuffer();
		
		for (PartnerPersonContact pcontact : this.partnerContacts) {
			if(pcontact != null){
				if(!sb.toString().isEmpty()){
					sb.append("; ").append(pcontact.getPerson().getFirstName()).append(" ").append(pcontact.getPerson().getLastName());
					if(pcontact.getPerson().getLastEmail()!=null)
						sb.append(", ").append(pcontact.getPerson().getLastEmail().getEmail());
					if(pcontact.getPerson().getLastPhone()!=null)
						sb.append(", ").append(pcontact.getPerson().getLastPhone().getPhoneNumber());
					
					if(pcontact.getType()!=null)
						sb.append(" (").append(pcontact.getType()).append(")");
				}else{
					sb.append(pcontact.getPerson().getFirstName()).append(" ").append(pcontact.getPerson().getLastName());
					if(pcontact.getPerson().getLastEmail()!=null)
						sb.append(", ").append(pcontact.getPerson().getLastEmail().getEmail());
					if(pcontact.getPerson().getLastPhone()!=null)
						sb.append(", ").append(pcontact.getPerson().getLastPhone().getPhoneNumber());
					
					if(pcontact.getType()!=null)
						sb.append(" (").append(pcontact.getType()).append(")");
				}
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportMandateCrops(){
		StringBuffer sb = new StringBuffer();
		
		for (PartnerMandateCrop mandate : this.mandateCrops) {
			if(mandate != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(mandate.getType());
				else
					sb.append(mandate.getType());
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportCoreBusinesses(){
		StringBuffer sb = new StringBuffer();
		
		for (PartnerCoreBusiness core : this.coreBusinesses) {
			if(core != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(core.getType());
				else
					sb.append(core.getType());
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportCategories(){
		StringBuffer sb = new StringBuffer();
		
		for (PartnerCategory caty : this.partnerCategories) {
			if(caty != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(caty.getType());
				else
					sb.append(caty.getType());
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportSectors(){
		StringBuffer sb = new StringBuffer();
		
		for (PartnerSector sect : this.sectors) {
			if(sect != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(sect.getType());
				else
					sb.append(sect.getType());
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportSubsectors(){
		StringBuffer sb = new StringBuffer();
		
		for (PartnerSubsector sect : this.subsectors) {
			if(sect != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(sect.getType());
				else
					sb.append(sect.getType());
			}
		}
		return sb.toString();
	}
		
	
	@Transient
	public String getReportScales(){
		StringBuffer sb = new StringBuffer();
		
		for (PartnerScale sc : this.scales) {
			if(sc != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(sc.getType());
				else
					sb.append(sc.getType());
			}
		}
		return sb.toString();
	}
	
	@Transient
	public String getReportCoreBusinessCategories(){
		StringBuffer sb = new StringBuffer();
		
		for (PartnerCoreBusinessCategory cbC : this.coreBusinessCategories) {
			if(cbC != null){
				if(!sb.toString().isEmpty())
					sb.append(", ").append(cbC.getType());
				else
					sb.append(cbC.getType());
			}
		}
		return sb.toString();
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setPartnershipType(String partnershipType) {
		this.partnershipType = partnershipType;
	}

	@Column(length = 255)
	public String getPartnershipType() {
		return partnershipType;
	}

	public void setPartnershipAgreement(String partnershipAgreement) {
		this.partnershipAgreement = partnershipAgreement;
	}

	@Lob
	public String getPartnershipAgreement() {
		return partnershipAgreement;
	}

	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}

	@Column(length = 255)
	public String getSourceFile() {
		return sourceFile;
	}

	public void setSourcePerson(String sourcePerson) {
		this.sourcePerson = sourcePerson;
	}

	@Column(length = 255)
	public String getSourcePerson() {
		return sourcePerson;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Lob
	public String getNotes() {
		return notes;
	}

	public void setCoreBusinessCategories(List<PartnerCoreBusinessCategory> coreBusinessCategories) {
		this.coreBusinessCategories = coreBusinessCategories;
	}

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "partner")
	public List<PartnerCoreBusinessCategory> getCoreBusinessCategories() {
		return coreBusinessCategories;
	}

	public void setScales(List<PartnerScale> scales) {
		this.scales = scales;
	}

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "partner")
	public List<PartnerScale> getScales() {
		return scales;
	}

	public void setSectors(List<PartnerSector> sectors) {
		this.sectors = sectors;
	}

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "partner")
	public List<PartnerSector> getSectors() {
		return sectors;
	}
	
	public void setSubsectors(List<PartnerSubsector> subsectors) {
		this.subsectors = subsectors;
	}

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "partner")
	public List<PartnerSubsector> getSubsectors() {
		return subsectors;
	}
}
