/**
 * 
 */
package org.iita.trainingunit.action.alumni;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.NoResultException;

import org.iita.crm.action.BaseAction;
import org.iita.query.model.Query;
import org.iita.service.QueryService;
import org.iita.trainingunit.service.AlumniService;
import org.iita.util.PagedResult;

import com.opensymphony.xwork2.Action;

/**
 * @author KOraegbunam
 *
 */
public class SearchAlumniAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected AlumniService alumniService;
	private String lastName;
	private String firstName;
	private String researchTopic;
	private String gender;
	private Date fromDate;
	private Date toDate;
	private String org;
	private PagedResult<?> paged;
	protected int startAt = 0, maxResults = 50;
	protected QueryService queryService;
	private Query query;
	private Long id;
	
	/**
	 * @param alumniService
	 */
	public SearchAlumniAction(AlumniService alumniService, QueryService queryService) {
		this.alumniService = alumniService;
		this.queryService = queryService;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the researchTopic
	 */
	public String getResearchTopic() {
		return researchTopic;
	}
	
	/**
	 * @return the query
	 */
	public Query getQuery() {
		return query;
	}
	

	/**
	 * @param researchTopic the researchTopic to set
	 */
	public void setResearchTopic(String researchTopic) {
		this.researchTopic = researchTopic;
	}

	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
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
	 * @return the startAt
	 */
	public int getStartAt() {
		return this.startAt;
	}
	
	/**
	 * @see org.iita.struts.BaseAction#prepare()
	 */
	@Override
	public void prepare() {
		if (this.id != null){
			this.query = this.queryService.loadQuery(this.id);
		}
	}

	public String execute(){
		return Action.SUCCESS;
	}
	
	//Search Query Parser
	public String query(){
		if(this.lastName==null && this.gender==null && this.firstName==null && this.researchTopic==null && this.org==null && this.fromDate==null && this.toDate==null){
			addActionError("No query criteria supplied!");
			return Action.ERROR;
		}
		
		String queryString = queryString(this.gender, this.lastName, this.firstName, this.researchTopic, this.org, this.fromDate, this.toDate);
		String buildQueryStr;
		if (this.query == null){
			if(queryString!=null){
				if(queryString.length()>0){ 
					buildQueryStr = "Select CONCAT(COALESCE(title, ''), CONCAT(COALESCE(lastName, ''), ', ', COALESCE(firstName, ''))) as fullName , p.gender, p.maritalStatus, p.dob, p.country, CONCAT(la.address,' ', la.city, ' ', la.state) as address, p.countryOfResidence, le.email, lp.phoneNumber, t.researchTopic from Trainee t inner join t.person p left join p.lastAddress la left join p.lastEmail le left join p.lastPhone lp where "+queryString+" order by p.firstName, p.lastName asc";
					Query q = new Query();
					q.setAllowedRoles("ROLE_QUERY,ROLE_CRM,ROLE_PARTNERADMIN,ROLE_PARTNERREADALL");
					q.setQuery(buildQueryStr.toString());
					q.setHeads("Name, Gender, MStatus, DoB, Nationality, Address, Country of Residence, Email, Phone, Research Topic");
					q.setTitle("Title:AlumniSearch");
					q.setShortName("ShortName:AlumniSearch");
					this.query = this.queryService.updateSearch(q);
				}
			}else{
				addActionError("No query criteria supplied!");
				return Action.ERROR;
			}
		}else{
			if(queryString!=null){
				if(!this.query.getQuery().equalsIgnoreCase(queryString) && queryString.length()>0){
					buildQueryStr = "Select CONCAT(COALESCE(title, ''), CONCAT(COALESCE(lastName, ''), ', ', COALESCE(firstName, ''))) as fullName, p.gender, p.maritalStatus, p.dob, p.country, CONCAT(la.address,' ', la.city, ' ', la.state) as address, p.countryOfResidence, le.email, lp.phoneNumber, t.researchTopic from Trainee t inner join t.person p left join p.lastAddress la left join p.lastEmail le left join p.lastPhone lp where "+queryString+" order by p.firstName, p.lastName asc";
					this.query.setQuery(buildQueryStr.toString());
					
					if(!this.query.getHeads().equalsIgnoreCase("Name, Gender, MStatus, DoB, Nationality, Address, Country of Residence, Email, Phone, Research Topic"))
						this.query.setHeads("Name, Gender, MStatus, DoB, Nationality, Address, Country of Residence, Email, Phone, Research Topic");
					
					this.query = this.queryService.updateSearch(this.query);
				}
			}
		}
			
		if(this.query!=null){
			this.paged = this.queryService.executeQuery(this.query, this.startAt, this.maxResults);
		}
		//this.paged = this.alumniService.search(this.lastName, this.firstName, this.researchTopic, this.org, this.fromDate, this.toDate, this.startAt, this.maxResults);
		return Action.SUCCESS;
	}
	
	//Build Query String
	private String queryString(String gender, String lastName, String firstName, String topic, String org, Date fromDate, Date toDate){
		try {
			StringBuilder queryStr = new StringBuilder();
			
			if(lastName!=null && lastName.length()>0)
				queryStr.append("p.lastName like '%").append(lastName).append("%'");
			
			if(queryStr!=null && queryStr.length()>0){
				if(firstName!=null && firstName.length()>0)
					queryStr.append("and p.firstName like '%").append(firstName).append("%'");
			}else{
				if(firstName!=null && firstName.length()>0)
					queryStr.append("p.firstName like '%").append(firstName).append("%'");
			}
			
			if(queryStr!=null && queryStr.length()>0){
				if(gender!=null && gender.length()>0)
					queryStr.append("and p.gender = '").append(gender).append("'");
			}else{
				if(gender!=null && gender.length()>0)
					queryStr.append("p.gender = '").append(gender).append("'");
			}
			
			if(queryStr!=null && queryStr.length()>0){
				if(topic!=null && topic.length()>0)
					queryStr.append(" and t.researchTopic like '%").append(topic).append("%'");
			}else {
				if(topic!=null && topic.length()>0)
					queryStr.append("t.researchTopic like '%").append(topic).append("%'");
			}
			
			if(queryStr!=null && queryStr.length()>0){
				if(org!=null && org.length()>0)
					queryStr.append(" and (t.university.title like '%").append(org).append("%'").append(" or t.university.shortName like '%").append(org).append("%')");
			}else{
				if(topic!=null && org.length()>0)
					queryStr.append("(t.university.title like '%").append(org).append("%'").append(" or t.university.shortName like '%").append(org).append("%')");
			}
			
			if(queryStr!=null && queryStr.length()>0){
				if(fromDate!=null && toDate!=null){
					String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					String toDate1 = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
					queryStr.append(" and ((t.startDate between '").append(fromDate1).append("' and '").append(toDate1).append("')");
					queryStr.append(" or (t.endDate between '").append(fromDate1).append("' and '").append(toDate1).append("')");
					queryStr.append(" or (t.extensionDate between '").append(fromDate1).append("' and '").append(toDate1).append("'))");
				}
				else if(fromDate!=null && toDate==null){
					String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					queryStr.append(" and ((t.startDate = '").append(fromDate1).append("')");
					queryStr.append(" or (t.endDate = '").append(fromDate1).append("')");
					queryStr.append(" or (t.extensionDate = '").append(fromDate1).append("'))");
				}
				else if(fromDate==null && toDate!=null){
					String toDate1 = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
					queryStr.append(" and ((t.startDate = '").append(toDate1).append("')");
					queryStr.append(" or (t.endDate = '").append(toDate1).append("')");
					queryStr.append(" or (t.extensionDate = '").append(toDate1).append("'))");
				}
			}else{
				if(fromDate!=null && toDate!=null){
					String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					String toDate1 = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
					queryStr.append("((t.startDate between '").append(fromDate1).append("' and '").append(toDate1).append("')");
					queryStr.append(" or (t.endDate between '").append(fromDate1).append("' and '").append(toDate1).append("')");
					queryStr.append(" or (t.extensionDate between '").append(fromDate1).append("' and '").append(toDate1).append("'))");
				}
				else if(fromDate!=null && toDate==null){
					String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					queryStr.append("((t.startDate = '").append(fromDate1).append("')");
					queryStr.append(" or (t.endDate = '").append(fromDate1).append("')");
					queryStr.append(" or (t.extensionDate = '").append(fromDate1).append("'))");
				}
				else if(fromDate==null && toDate!=null){
					String toDate1 = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
					queryStr.append("((t.startDate = '").append(toDate1).append("')");
					queryStr.append(" or (t.endDate = '").append(toDate1).append("')");
					queryStr.append(" or (t.extensionDate = '").append(toDate1).append("'))");
				}
			}
			if(queryStr!=null && queryStr.length()>0){
				if(queryStr.length()>0){
					queryStr.append(" and p.alumniStatus='Yes'");
					return queryStr.toString();
				}else
					return null;
			}else
				return null;
		} catch (NoResultException e) {
			return null;
		}
	}
	/**
	 * @return the alumni
	 */
	public PagedResult<?> getPaged() {
		return paged;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

}
