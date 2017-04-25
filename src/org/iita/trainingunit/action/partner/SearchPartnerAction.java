/**
 * 
 */
package org.iita.trainingunit.action.partner;

import java.util.List;

import javax.persistence.NoResultException;

import org.iita.crm.action.BaseAction;
import org.iita.query.model.Query;
import org.iita.service.QueryService;
import org.iita.service.TemplatingService;
import org.iita.trainingunit.service.PartnerPortService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;

/**
 * @author KOraegbunam
 *
 */
public class SearchPartnerAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected PartnerPortService partnerService;
	private String name;
	private String tag;
	private String org;
	private String hub;
	private String contact;
	
	private String classification;
	private String category;
	private String mandateCrop;
	private String coreBusiness;
	
	private PagedResult<?> paged;
	protected int startAt = 0, maxResults = 50;
	protected QueryService queryService;
	private TemplatingService templatingService;
	private Query query;
	private Long id;
	private String report;
	/**
	 * @param partnerService
	 */
	public SearchPartnerAction(PartnerPortService partnerService, QueryService queryService) {
		this.partnerService = partnerService;
		this.queryService = queryService;
	}
	
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the report
	 */
	public String getReport() {
		return this.report;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the hub
	 */
	public String getHub() {
		return hub;
	}

	/**
	 * @param hub the hub to set
	 */
	public void setHub(String hub) {
		this.hub = hub;
	}
	
	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	/**
	 * @return the classification
	 */
	public String getClassification() {
		return classification;
	}

	/**
	 * @param classification the classification to set
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * @return the mandateCrop
	 */
	public String getMandateCrop() {
		return mandateCrop;
	}

	/**
	 * @param mandateCrop the mandateCrop to set
	 */
	public void setMandateCrop(String mandateCrop) {
		this.mandateCrop = mandateCrop;
	}
	
	/**
	 * @return the coreBusiness
	 */
	public String getCoreBusiness() {
		return coreBusiness;
	}

	/**
	 * @param coreBusiness the coreBusiness to set
	 */
	public void setCoreBusiness(String coreBusiness) {
		this.coreBusiness = coreBusiness;
	}
	
	/**
	 * @param templatingService the templatingService to set
	 */
	public void setTemplatingService(TemplatingService templatingService) {
		this.templatingService = templatingService;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @return the org
	 */
	public String getOrg() {
		return org;
	}

	/**
	 * @param org the org to set
	 */
	public void setOrg(String org) {
		this.org = org;
	}
	
	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}
	
	/**
	 * @return the query
	 */
	public Query getQuery() {
		return query;
	}
	
	/**
	 * @see org.iita.struts.BaseAction#prepare()
	 */
	@Override
	public void prepare() {
		if (this.id != null)
			this.query = this.queryService.loadQuery(this.id);

	}
	
	public String execute(){
		
		//if (this.query.getTemplateName() != null) {
		//	this.report = fillReport(this.query.getTemplateName(), this.query.getHeadings(), this.paged);
		//}
		return Action.SUCCESS;
	}
	
	public List<String> getListClassifications(){
		return this.partnerService.listPartnerClassifications();
	}	
	public List<String> getListCategories(){
		return this.partnerService.listPartnerCategories();
	}
	public List<String> getListCoreBusinesses(){
		return this.partnerService.listPartnerCoreBusinesses();
	}
	public List<String> getListMandateCrops(){
		return this.partnerService.listPartnerMandateCrops();
	}
	public List<String> getListHubs(){
		return this.partnerService.listHubs();
	}
	
	/**
	 * This method should be overriden in other implementations to give extra beans required to render report
	 * 
	 * @param pagedResult
	 * @param headings
	 * @param templateName
	 */
	protected String fillReport(String templateName, String[] headings, PagedResult<?> pagedResult) {
		return this.templatingService.fillReport(templateName, headings, pagedResult, null);
	}
	
	public String query(){
		//this.paged = this.partnerService.search(this.name, this.tag, this.org, this.startAt, this.maxResults);
		if(this.name==null && this.tag==null && this.org==null){
			addActionError("No query criteria supplied!");
			return Action.ERROR;
		}
		
		String queryString = queryString(this.name, this.tag, this.org, this.hub, this.contact);
		String buildQueryStr;
		
			if (this.query == null){
				if(queryString!=null){
					if(queryString.length()>0){
						
						if(this.name!=null && this.name.length()>0)
							buildQueryStr = "Select distinct pc from Contact c inner join c.partner pt left join pt.tags at left join pt.partnerContacts pc left join pc.person p left join pt.classifications cl left join pt.partnerCategories ct left join pt.coreBusinesses cb left join pt.mandateCrops mc left join pt.contacts addresses left join pt.iitaHubs h where "+queryString+" group by pt.title, p.lastName, p.firstName order by pt.title, p.firstName, p.lastName asc";
							//buildQueryStr = "Select distinct pt.title, pt.shortName, group_concat(c.address) as address, group_concat(c.city) as city, group_concat(c.state) as state, group_concat(c.country) as country, group_concat(c.email) as email, group_concat(c.phoneNumber) as phoneNumber, group_concat(pt.continent) as continent, group_concat(h.hub) as hub, CONCAT(p.lastName,', ',p.firstName) as fullName, p.gender from Contact c inner join c.partner pt left join pt.tags at left join pt.partnerContacts pc left join pc.person p where "+queryString+" group by pt.title, p.lastName, p.firstName order by pt.title, p.firstName, p.lastName asc";
						else
							buildQueryStr = "Select distinct pt from Partner pt left join pt.contacts c left join pt.tags at left join pt.iitaHubs h left join pt.classifications cl left join pt.partnerCategories ct left join pt.coreBusinesses cb left join pt.mandateCrops mc left join pt.contacts addresses left join pt.iitaHubs h where "+queryString+" group by pt.title order by pt.title asc";
							//buildQueryStr = "Select distinct pt.title, pt.shortName, group_concat(c.address) as address, group_concat(c.city) as city, group_concat(c.state) as state, group_concat(c.country) as country, group_concat(c.email) as email, group_concat(c.phoneNumber) as phoneNumber, group_concat(pt.continent) as continent, group_concat(h.hub) as hub from Partner pt left join pt.contacts c left join pt.tags at left join pt.iitaHubs h where "+queryString+" group by pt.title order by pt.title asc";
						
						Query q = new Query();
						
						q.setAllowedRoles("ROLE_QUERY,ROLE_PARTNERADMIN,ROLE_PARTNERREADALL");
						q.setQuery(buildQueryStr.toString());
						
						if(this.name!=null && this.name.length()>0){
							q.setTemplateName("partnership-report-person");
							q.setHeads("PartnerPersonContact");
							//q.setHeads("Organization, ShortName, Address, City, State, Country, Email, PhoneNo, Continent, IITAHub, Contact Person, Gender");
						}else{
							q.setTemplateName("partnership-report");
							q.setHeads("Partner");
							//q.setHeads("Organization, ShortName, Address, City, State, Country, Email, PhoneNo, Continent, IITAHub");
						}
						
						q.setTitle("Title:PartnerSearch");
						q.setShortName("ShortName:PartnerSearch");
						
						this.query = this.queryService.updateSearch(q);
					}
				}else{
					addActionError("No query criteria supplied!");
					return Action.ERROR;
				}
			}			
				
			if(this.query!=null){
				this.paged = this.queryService.executeQuery(this.query, this.startAt, this.maxResults);
				if (this.query.getTemplateName() != null) {
					this.report = fillReport(this.query.getTemplateName(), this.query.getHeadings(), this.paged);
				}
			}
		return Action.SUCCESS;
	}
	
	//Build Query String
	@SuppressWarnings("unused")
	private String queryString(String name, String tag, String org, String hub, String contact){
		try {
			StringBuilder queryStr = new StringBuilder();
			//query = null;
					
			if(queryStr!=null && queryStr.length()>0){
				if(name!=null && name.length()>0)
					queryStr.append(" and (").append("p.lastName like '%").append(name).append("%'").append(" or p.firstName like '%").append(name).append("%'").append(")");
			}else{
				if(name!=null && name.length()>0)
					queryStr.append("(").append("p.lastName like '%").append(name).append("%'").append(" or p.firstName like '%").append(name).append("%'").append(")");
			}
			
			if(queryStr!=null && queryStr.length()>0){
				if(tag!=null && tag.length()>0)
					queryStr.append(" and at.tag like '%").append(tag).append("%'");
			}else {
				if(tag!=null && tag.length()>0)
					queryStr.append("at.tag like '%").append(tag).append("%'");
			}
			
			if(queryStr!=null && queryStr.length()>0){
				if(classification!=null && classification.length()>0)
					queryStr.append(" and cl.type like '%").append(classification).append("%'");
			}else {
				if(classification!=null && classification.length()>0)
					queryStr.append("cl.type like '%").append(classification).append("%'");
			}
			
			if(queryStr!=null && queryStr.length()>0){
				if(category!=null && category.length()>0)
					queryStr.append(" and ct.type like '%").append(category).append("%'");
			}else {
				if(category!=null && category.length()>0)
					queryStr.append("ct.type like '%").append(category).append("%'");
			}
			
			if(queryStr!=null && queryStr.length()>0){
				if(coreBusiness!=null && coreBusiness.length()>0)
					queryStr.append(" and cb.type like '%").append(coreBusiness).append("%'");
			}else {
				if(coreBusiness!=null && coreBusiness.length()>0)
					queryStr.append("cb.type like '%").append(coreBusiness).append("%'");
			}
			
			if(queryStr!=null && queryStr.length()>0){
				if(mandateCrop!=null && mandateCrop.length()>0)
					queryStr.append(" and mc.type like '%").append(mandateCrop).append("%'");
			}else {
				if(mandateCrop!=null && mandateCrop.length()>0)
					queryStr.append("mc.type like '%").append(mandateCrop).append("%'");
			}
			
			if(queryStr!=null && queryStr.length()>0){
				if(org!=null && org.length()>0)
					queryStr.append(" and (pt.title like '%").append(org).append("%'").append(" or pt.shortName like '%").append(org).append("%')");
			}else{
				if(org!=null && org.length()>0)
					queryStr.append("(pt.title like '%").append(org).append("%'").append(" or pt.shortName like '%").append(org).append("%')");
			}
			
			if(queryStr!=null && queryStr.length()>0){
				if(hub!=null && hub.length()>0)
					queryStr.append(" and (h.hub like '%").append(hub).append("%')");
			}else{
				if(hub!=null && hub.length()>0)
					queryStr.append("(h.hub like '%").append(hub).append("%')");
			}
			
			if(queryStr!=null && queryStr.length()>0){
				if(contact!=null && contact.length()>0)
					queryStr.append(" and (addresses.city like '%").append(contact).append("%'").append(" or addresses.state like '%").append(contact).append("%'").append(" or addresses.country like '%").append(contact).append("%'").append(" or addresses.continent like '%").append(contact).append("%'").append(" or addresses.address like '%").append(contact).append("%')");
			}else{
				if(contact!=null && contact.length()>0)
					queryStr.append("(addresses.city like '%").append(contact).append("%'").append(" or addresses.state like '%").append(contact).append("%'").append(" or addresses.country like '%").append(contact).append("%'").append(" or addresses.continent like '%").append(contact).append("%'").append(" or addresses.address like '%").append(contact).append("%')");
			}
			
			if(queryStr!=null){
				if(queryStr.length()>0)
					return queryStr.toString();
				else
					return null;
			}else
				return null;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	/**
	 * @return the partner
	 */
	public PagedResult<?> getPaged() {
		return paged;
	}

}
