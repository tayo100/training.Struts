package org.iita.trainingunit.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.crm.model.Organization;
import org.iita.security.model.User;
import org.iita.trainingunit.announcements.model.TrainingProposal;
import org.iita.trainingunit.announcements.model.TrainingProposal.STATUS;
import org.iita.trainingunit.model.Trainee;
import org.iita.trainingunit.model.Trainer;
import org.iita.trainingunit.model.TrainingProgram;
import org.iita.trainingunit.service.AdvancedTrainingSearchException;
import org.iita.trainingunit.service.AdvancedTrainingSearchService;
import org.iita.util.PagedResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ken
 * 
 * @author Chuks
 */
public class AdvancedTrainingSearchServiceImpl implements AdvancedTrainingSearchService {
	private static final Log LOG = LogFactory.getLog(AdvancedTrainingSearchServiceImpl.class);
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	private StringBuilder trainerQueryBuilder(String text, boolean fullText, String origin, String loc){
		String[] arrayText = text.split("\\s+");
		StringBuilder query = new StringBuilder("");
		StringBuilder where = new StringBuilder("");
		//query = null;
		if(fullText!=true){
			for (String txt : arrayText) {
				if (txt != null && txt.length() > 0) {
					if (query.length() == 0) {
						query.append("(");
						query.append("t.notes like '%").append(txt).append("%'");
						query.append(" or t.type like '%").append(txt).append("%'");
						query.append(" or t.person.lastName like '%").append(txt).append("%'");
						query.append(" or t.person.firstName like '%").append(txt).append("%'");
						query.append(" or t.person.otherNames like '%").append(txt).append("%'");
						query.append(" or t.person.gender like '%").append(txt).append("%'");
						query.append(" or t.person.country like '%").append(txt).append("%'");
						query.append(" or t.person.maritalStatus like '%").append(txt).append("%'");
						query.append(" or t.person.countryOfResidence like '%").append(txt).append("%'");
						query.append(")");
					} else {
						query.append(" or (");
						query.append("t.person.lastName like '%").append(txt).append("%'");
						query.append(" or t.person.firstName like '%").append(txt).append("%'");
						query.append(" or t.person.otherNames like '%").append(txt).append("%'");
						query.append(" or t.person.gender like '%").append(txt).append("%'");
						query.append(" or t.person.country like '%").append(txt).append("%'");
						query.append(" or t.person.maritalStatus like '%").append(txt).append("%'");
						query.append(" or t.person.countryOfResidence like '%").append(txt).append("%'");
						query.append(")");
					}
				}
			}
		}else{
			if (text != null && text.length() > 0) {
				if (query.length() == 0) {
					query.append("(");
					query.append("t.notes like '%").append(text).append("%'");						
					query.append(" or t.type like '%").append(text).append("%'");					
					query.append(" or t.person.lastName like '%").append(text).append("%'");						
					query.append(" or t.person.firstName like '%").append(text).append("%'");
					query.append(" or t.person.otherNames like '%").append(text).append("%'");
					query.append(" or t.person.gender like '%").append(text).append("%'");
					query.append(" or t.person.country like '%").append(text).append("%'");						
					query.append(" or t.person.maritalStatus like '%").append(text).append("%'");						
					query.append(" or t.person.countryOfResidence like '%").append(text).append("%'");
					query.append(")");
				} else {
					query.append(" or (");
					query.append("t.person.lastName like '%").append(text).append("%'");						
					query.append(" or t.person.firstName like '%").append(text).append("%'");
					query.append(" or t.person.otherNames like '%").append(text).append("%'");
					query.append(" or t.person.gender like '%").append(text).append("%'");
					query.append(" or t.person.country like '%").append(text).append("%'");						
					query.append(" or t.person.maritalStatus like '%").append(text).append("%'");						
					query.append(" or t.person.countryOfResidence like '%").append(text).append("%'");
					query.append(")");
				}
			}
		}
		
		if (origin!=null) {
			if (origin.length() > 0) {
				if(query != null && !query.toString().equals(""))
					query.append(" and (t.person.country = '").append(origin).append("')");
				else
					query.append("(t.person.country = '").append(origin).append("')");
			}
		}
		
		if (loc!=null) {
			if (loc.length() > 0) {
				if(query != null && !query.toString().equals(""))
					query.append(" and ((t.trainee.country = '").append(loc).append("') or (t.group.country = '").append(loc).append("'))");
				else
					query.append("((t.trainee.country = '").append(loc).append("') or (t.group.country = '").append(loc).append("'))");
			}
		}
		
		if(query != null && !query.toString().equals(""))
			where.append("where ").append(query);
		
		return where;
	}
	
	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public PagedResult<Trainer> searchTrainer(String sDate, String eDate, String operands, String origin, String text, Date fromDate, Date endDate, int startAt, int maxResults, boolean fullText, String loc) throws AdvancedTrainingSearchException {
		try {
			StringBuilder query = new StringBuilder("");			
			query = trainerQueryBuilder(text, fullText, origin, loc);
			
			PagedResult<Trainer> paged = new PagedResult<Trainer>();
			paged.setStartAt(startAt);
			paged.setMaxResults(maxResults);
			paged.setResults(this.entityManager.createQuery("select distinct t from Trainer t inner join t.person " + query + " group by t.person.lastName, t.person.firstName, t.type order by t.person.lastName, t.person.firstName asc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
					
			List<TrainingProgram> tp = this.entityManager.createQuery("select distinct t from Trainer t inner join t.person " + query + " group by t.person.lastName, t.person.firstName, t.type order by t.person.lastName, t.person.firstName asc")
				.getResultList();		
			paged.setTotalHits(tp.size());
			return paged;
		} catch (NoResultException e) {
			LOG.warn("Trainer not found.");
			return null;
		} catch (Exception e){
			throw new AdvancedTrainingSearchException("Trainer records not found! Check your criteria combinations.");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Trainer> searchTrainer(String sDate, String eDate, String operands, String origin, String text, Date fromDate, Date endDate, boolean fullText, String loc) throws AdvancedTrainingSearchException {
		try {
			StringBuilder query = new StringBuilder("");
			query = trainerQueryBuilder(text, fullText, origin, loc);
			
			return (List<Trainer>) this.entityManager.createQuery("select distinct t from Trainer t inner join t.person " + query + " group by t.person.lastName, t.person.firstName, t.type order by t.person.lastName, t.person.firstName asc").getResultList();
		} catch (NoResultException e) {
			throw new AdvancedTrainingSearchException("Trainer not found.");
		}
	}
	
	private StringBuilder orgQueryBuilder(String sDate, String eDate, String operands, String loc, String text, Date fromDate, Date endDate,
			boolean fullText) throws AdvancedTrainingSearchException {
		String[] arrayText = text.split("\\s+");
		StringBuilder query = new StringBuilder("");
		StringBuilder where = new StringBuilder("");
		
		if(fullText!=true){
			for (String txt : arrayText) {
				if (txt != null && txt.length() > 0) {
					if (query.length() == 0) {
						query.append("(");
						query.append("o.shortName like '%").append(txt).append("%'");
						query.append(" or o.title like '%").append(txt).append("%'");
						query.append(" or o.type like '%").append(txt).append("%'");
						query.append(" or emails.email like '%").append(txt).append("%'");
						query.append(" or addresses.address like '%").append(txt).append("%'");
						query.append(" or ts.tag like '%").append(txt).append("%'");
						query.append(")");
					} else {
						query.append(" or (");
						query.append("o.shortName like '%").append(txt).append("%'");
						query.append(" or o.title like '%").append(txt).append("%'");
						query.append(" or o.type like '%").append(txt).append("%'");
						query.append(" or emails.email like '%").append(txt).append("%'");
						query.append(" or addresses.address like '%").append(txt).append("%'");
						query.append(" or ts.tag like '%").append(txt).append("%'");
						query.append(")");
					}
				}
			}
		}else{
			if (text != null && text.length() > 0) {
				if (query.length() == 0) {
					query.append("(");
					query.append("o.shortName like '%").append(text).append("%'");
					query.append(" or o.title like '%").append(text).append("%'");
					query.append(" or o.type like '%").append(text).append("%'");
					query.append(" or emails.email like '%").append(text).append("%'");
					query.append(" or addresses.address like '%").append(text).append("%'");
					query.append(" or ts.tag like '%").append(text).append("%'");
					query.append(")");
				} else {
					query.append(" or (");
					query.append("o.shortName like '%").append(text).append("%'");
					query.append(" or o.title like '%").append(text).append("%'");
					query.append(" or o.type like '%").append(text).append("%'");
					query.append(" or emails.email like '%").append(text).append("%'");
					query.append(" or addresses.address like '%").append(text).append("%'");
					query.append(" or ts.tag like '%").append(text).append("%'");
					query.append(")");
				}
			}
		}
		
		if (loc!=null) {
			if (loc.length() > 0) {
				if(query != null && !query.toString().equals(""))
					query.append(" and (addresses.country = '").append(loc).append("')");
				else
					query.append("(addresses.country = '").append(loc).append("')");
			}
		}
		
		if(query != null && !query.toString().equals(""))
			where.append("where ").append(query);
		
		return where;
	}// orgQueryBuilder

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public PagedResult<Organization> searchOrg(String sDate, String eDate, String operands, String loc, String text, Date fromDate, Date endDate, int startAt, int maxResults, boolean fullText) throws AdvancedTrainingSearchException {
		try {
			StringBuilder query = new StringBuilder("");

			query = orgQueryBuilder(sDate, eDate, operands, loc, text, fromDate, endDate, fullText);
			
			PagedResult<Organization> paged = new PagedResult<Organization>();
			paged.setStartAt(startAt);
			paged.setMaxResults(maxResults);
	
			paged.setResults(this.entityManager.createQuery("select distinct o from Organization o inner join o.contacts emails inner join o.contacts phones inner join o.contacts addresses inner join o.tags ts " + 
				query + " group by o.shortName, o.title, o.type order by o.shortName, o.type asc").setFirstResult(startAt)
				.setMaxResults(maxResults).getResultList());
			List<Organization> org = this.entityManager.createQuery("select distinct o from Organization o inner join o.contacts emails inner join o.contacts phones inner join o.contacts addresses inner join o.tags ts " + 
				query + " group by o.shortName, o.title, o.type order by o.shortName, o.type asc").getResultList();
			paged.setTotalHits(org.size());
			return paged;
		} catch (NoResultException e) {
			LOG.warn("Organization not found.");
			return null;
		} catch (Exception e){
			throw new AdvancedTrainingSearchException("Organization records not found! Check your criteria combinations.");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Organization> searchOrg(String sDate, String eDate, String operands, String loc, String text, Date fromDate, Date endDate, boolean fullText) throws AdvancedTrainingSearchException {
		try {
			StringBuilder query = new StringBuilder("");
			query = orgQueryBuilder(sDate, eDate, operands, loc, text, fromDate, endDate, fullText);
			
			return (List<Organization>) this.entityManager.createQuery("select distinct o from Organization o inner join o.contacts emails inner join o.contacts phones inner join o.contacts addresses inner join o.tags ts " + 
				query + " group by o.shortName, o.title, o.type order by o.shortName, o.type asc").getResultList();
		} catch (NoResultException e) {
			LOG.warn("Organization not found.");
			throw new AdvancedTrainingSearchException("Organization not found.");
		} catch (AdvancedTrainingSearchException e) {
			throw new AdvancedTrainingSearchException("Illegal operand supplied.");
		} catch (Exception e){
			throw new AdvancedTrainingSearchException("Organization records not found! Check your criteria combinations.");
		}
	}

	private StringBuilder groupQueryBuilder(String sDate, String eDate, String operands, String loc, String text, Date fromDate, Date endDate, boolean fullText, String[] selectedCrps, String[] selectedHubs, String[] selectedCoreCompetencies, String[] selectedTrainers, String[] selectedSponsors, boolean groupYearly, String cc) throws AdvancedTrainingSearchException{
		String[] arrayText = text.split("\\s+");
		StringBuilder query = new StringBuilder("");
		StringBuilder where = new StringBuilder("");
		
		if(fullText!=true){
			for (String txt : arrayText) {
				if (txt != null && txt.length() > 0) {
					if (query.length() == 0) {
						query.append("(");
						query.append("t.title like '%").append(txt).append("%'");						
						query.append(" or t.description like '%").append(txt).append("%'");
						query.append(" or t.status like '%").append(txt).append("%'");
						query.append(" or t.purpose like '%").append(txt).append("%'");
						query.append(" or t.location like '%").append(txt).append("%'");
						
						//if (origin.length() > 0) {
						//	query.append(" or t.country like '%").append(txt).append("%'");
						//}
						
						query.append(" or t.keywords like '%").append(txt).append("%'");						
						query.append(" or t.program like '%").append(txt).append("%'");
						query.append(" or t.outcomes like '%").append(txt).append("%'");
						query.append(" or at.lastName like '%").append(txt).append("%'");
						query.append(" or at.firstName like '%").append(txt).append("%'");
						query.append(")");
					} else {
						query.append(" or (");
						query.append("t.title like '%").append(txt).append("%'");						
						query.append(" or t.description like '%").append(txt).append("%'");
						query.append(" or t.status like '%").append(txt).append("%'");
						query.append(" or t.purpose like '%").append(txt).append("%'");
						query.append(" or t.location like '%").append(txt).append("%'");
						
						//if (origin.length() > 0){
						//	query.append(" or t.country like '%").append(txt).append("%'");
						//}
										
						query.append(" or t.keywords like '%").append(txt).append("%'");						
						query.append(" or t.program like '%").append(txt).append("%'");
						query.append(" or t.outcomes like '%").append(txt).append("%'");
						query.append(" or at.lastName like '%").append(txt).append("%'");
						query.append(" or at.firstName like '%").append(txt).append("%'");
						query.append(")");
					}
				}
			}
		}
			
			if (query.length() > 0) {
				String fromDate1 = "";
				String endDate1 = "";
				if (fromDate != null && endDate != null) {
					if(groupYearly){
						fromDate1 = new SimpleDateFormat("yyyy").format(fromDate);
						endDate1 = new SimpleDateFormat("yyyy").format(endDate);
					}else{
						fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
						endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
					}
				}else if (fromDate != null && endDate == null) {
					if(groupYearly){
						fromDate1 = new SimpleDateFormat("yyyy").format(fromDate);
					}else{
						fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					}
				}else  if (fromDate == null && endDate != null) {
					if(groupYearly){
						endDate1 = new SimpleDateFormat("yyyy").format(endDate);
					}else{
						endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
					}
				}
				
				if (fromDate != null && endDate != null) {
					if (sDate.equals("BETWEEN") && operands.equals("AND")) {
						//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
						//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
						if(!groupYearly)
							query.append(" and ((t.startDate ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" '")
								.append(endDate1).append("'))");
						else
							query.append(" and ((YEAR(t.startDate) ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" '")
							.append(endDate1).append("'))");
						//return query;
					} else {
						if (sDate.equals("BETWEEN") && operands.equals("OR")) {
							throw new AdvancedTrainingSearchException("Illegal operand supplied");
						}

						if (sDate.equals("<") || sDate.equals("<=") || sDate.equals("=") || sDate.equals(">") || sDate.equals(">=")) {
							if (operands.equals("AND") || operands.equals("OR")) {
								if (eDate.equals("<") || eDate.equals("<=") || eDate.equals("=") || eDate.equals(">") || eDate.equals(">=")) {
									//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
									//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
									if(!groupYearly)
										query.append(" and ((t.startDate ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands)
											.append(" t.endDate").append(" ").append(eDate).append(" '").append(endDate1).append("'))");
									else
										query.append(" and ((YEAR(t.startDate) ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands)
										.append(" YEAR(t.endDate)").append(" ").append(eDate).append(" '").append(endDate1).append("'))");
									//return query;
								}
							} else {
								throw new AdvancedTrainingSearchException("Illegal operand supplied");
							}
						}
					}
				}else if (fromDate != null && (sDate.equals("<") || sDate.equals("<=") || sDate.equals("=") || sDate.equals(">") || sDate.equals(">="))) {
					//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);

					if(sDate.isEmpty())
						sDate = "=";
					
					if(!groupYearly)
						query.append(" and ((t.startDate ").append(sDate).append(" '").append(fromDate1).append("'").append("))");
					else
						query.append(" and ((YEAR(t.startDate) ").append(sDate).append(" '").append(fromDate1).append("'").append("))");
					//return query;
				} else if (endDate != null && (eDate.equals("<") || eDate.equals("<=") || eDate.equals("=") || eDate.equals(">") || eDate.equals(">="))) {
					//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
					
					if(eDate.isEmpty())
						eDate = "=";
					
					if(!groupYearly)
						query.append(" and (t.endDate ").append(eDate).append(" '").append(endDate1).append("'").append(")");//.append(" or ")
							//.append("(t.extensionDate ").append(eDate).append("'").append(endDate1).append("'").append("))");
					else
						query.append(" and (YEAR(t.endDate) ").append(eDate).append(" '").append(endDate1).append("'").append(")");
					//return query;
				} //else {
				//	throw new AdvancedTrainingSearchException("Illegal operand supplied");
				//}

			} else {
				String fromDate1 = "";
				String endDate1 = "";
				if (fromDate != null && endDate != null) {
					if(groupYearly){
						fromDate1 = new SimpleDateFormat("yyyy").format(fromDate);
						endDate1 = new SimpleDateFormat("yyyy").format(endDate);
					}else{
						fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
						endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
					}
				}else if (fromDate != null && endDate == null) {
					if(groupYearly){
						fromDate1 = new SimpleDateFormat("yyyy").format(fromDate);
					}else{
						fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					}
				}else  if (fromDate == null && endDate != null) {
					if(groupYearly){
						endDate1 = new SimpleDateFormat("yyyy").format(endDate);
					}else{
						endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
					}
				}
				
				//add the newer condition here
				if (fromDate != null && endDate != null) {
					if (sDate.equals("BETWEEN") && operands.equals("AND")) {
						//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
						//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
						if(!groupYearly)
							query.append(" t.startDate ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" '").append(endDate1)
								.append("'");
						else
							query.append(" YEAR(t.startDate) ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" '").append(endDate1)
							.append("'");
						//return query;
					} else {
						if (sDate.equals("BETWEEN") && operands.equals("OR")) {
							throw new AdvancedTrainingSearchException("Illegal operand supplied");
						}

						if (sDate.equals("<") || sDate.equals("<=") || sDate.equals("=") || sDate.equals(">") || sDate.equals(">=")) {
							if (operands.equals("AND") || operands.equals("OR")) {
								if (eDate.equals("<") || eDate.equals("<=") || eDate.equals("=") || eDate.equals(">") || eDate.equals(">=")) {
									//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
									//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
									if(!groupYearly)
										query.append(" ((t.startDate ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands)
											.append(" t.endDate").append(" ").append(eDate).append(" '").append(endDate1).append("'))");
									else
										query.append(" ((YEAR(t.startDate) ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands)
										.append(" YEAR(t.endDate)").append(" ").append(eDate).append(" '").append(endDate1).append("'))");
									//return query;
								}
							} else {
								//if (sDate.length() == 0 && eDate.length() == 0)
								throw new AdvancedTrainingSearchException("Illegal operand supplied");
							}
						}
					}
				} else if (fromDate != null) {
					//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					
					if(sDate.isEmpty())
						sDate = "=";
					if(!groupYearly)
						query.append("(t.startDate ").append(sDate).append(" '").append(fromDate1).append("'").append(")");
					else
						query.append("(YEAR(t.startDate) ").append(sDate).append(" '").append(fromDate1).append("'").append(")");
				} else if (endDate != null) {
					//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);

					if(eDate.isEmpty())
						eDate = "=";
					if(!groupYearly)
						query.append("(t.endDate ").append(eDate).append(" '").append(endDate1).append("'").append(")").append(" or ").append("(t.extensionDate ")
							.append(eDate).append("'").append(endDate1).append("'").append(")");
					else
						query.append("(YEAR(t.endDate) ").append(eDate).append(" '").append(endDate1).append("'").append(")").append(" or ").append("(t.extensionDate ")
						.append(eDate).append("'").append(endDate1).append("'").append(")");
				}
			}
		
		if (loc!=null) {
			if (loc.length() > 0) {
				if(query != null && !query.toString().equals(""))
					query.append(" and (t.location = '").append(loc).append("')");
				else
					query.append("(t.location = '").append(loc).append("')");
			}
		}
		
		if(selectedCrps!=null){
			if(selectedCrps.length>0){
				StringBuilder crps = new StringBuilder("");
				for(String crp : selectedCrps){
					if(!"".equals(crp)){
						if(crps.length()==0)
							crps.append("'").append(crp).append("'");
						else
							crps.append(", '").append(crp).append("'");
					}
				}
				
				if(crps.length()>0){
					if(query != null && !query.toString().equals(""))
						query.append(" and (cr.name IN (").append(crps).append("))");
					else
						query.append("(cr.name IN (").append(crps).append("))");
				}
			}
		}
		
		if(selectedHubs!=null){
			if(selectedHubs.length>0){
				StringBuilder hubs = new StringBuilder("");
				for(String hub : selectedHubs){
					if(!"".equals(hub)){
						if(hubs.length()==0)
							hubs.append("'").append(hub).append("'");
						else
							hubs.append(", '").append(hub).append("'");
					}
				}
				if(hubs.length()>0){
					if(query != null && !query.toString().equals(""))
						query.append(" and (h.name IN (").append(hubs).append("))");
					else
						query.append("(h.name IN (").append(hubs).append("))");
				}
			}
		}
		
		if(selectedCoreCompetencies!=null){
			if(selectedCoreCompetencies.length>0){
				StringBuilder comps = new StringBuilder("");
				for(String comp : selectedCoreCompetencies){
					if(!"".equals(comp)){
						if(comps.length()==0)
							comps.append("'").append(comp).append("'");
						else
							comps.append(", '").append(comp).append("'");
					}
				}
				
				if(comps.length()>0){
					if(query != null && !query.toString().equals(""))
						query.append(" and (cc.name IN (").append(comps).append("))");
					else
						query.append("(cc.name IN (").append(comps).append("))");
				}
			}
		}
		
		if(selectedTrainers!=null){
			if(selectedTrainers.length>0){
				StringBuilder trainers = new StringBuilder("");
				for(String trainer : selectedTrainers){
					if(!"".equals(trainer)){
						if(trainers.length()==0)
							trainers.append("").append(trainer).append("");
						else
							trainers.append(",").append(trainer).append("");
					}
				}
				
				if(trainers.length()>0){
					if(query != null && !query.toString().equals(""))
						query.append(" and (tr.person.id IN (").append(trainers).append("))");
					else
						query.append("(tr.person.id IN (").append(trainers).append("))");
				}
			}
		}
		
		String[] arrayCc = cc.split("\\s+");
		if(query != null && !query.toString().equals("") && arrayCc.length>0){
			query.append(" and ");
			int counter = 0;
			for (String txtCc : arrayCc) {
				if (txtCc != null && txtCc.length() > 0) {
					txtCc = txtCc.replace(",", "");
					if(counter==0)
						query.append("(f.costCenter = ").append(txtCc);//.append(")");
					else
						query.append(" or f.costCenter = ").append(txtCc);//.append(")");
				}
				counter++;
			}
			if(arrayCc.length == counter)
				query.append(")");
		}else{
			int counter = 0;
			for (String txtCc : arrayCc) {
				if (txtCc != null && txtCc.length() > 0) {
					txtCc = txtCc.replace(",", "");
					if(counter==0)
						query.append("(f.costCenter = ").append(txtCc);//.append(")");
					else
						query.append(" or f.costCenter = ").append(txtCc);//.append(")");
				}
				counter++;
			}
			if(arrayCc.length == counter)
				query.append(")");
		}
		
		if(selectedSponsors!=null){
			if(selectedSponsors.length>0){
				StringBuilder sponsors = new StringBuilder("");
				for(String sponsor : selectedSponsors){
					if(!"".equals(sponsor)){
						if(sponsors.length()==0)
							sponsors.append("").append(sponsor).append("");
						else
							sponsors.append(",").append(sponsor).append("");
					}
				}
				
				if(sponsors.length()>0){
					if(query != null && !query.toString().equals(""))
						query.append(" and (f.organization.id IN (").append(sponsors).append("))");
					else
						query.append("(f.organization.id IN (").append(sponsors).append("))");
				}
			}
		}
		
		if(query != null && !query.toString().equals(""))
			where.append("where ").append(query);
		
		return where;
	} //groupQueryBuilder
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public PagedResult<TrainingProgram> searchPrograms(String sDate, String eDate, String operands, String loc, String text, 
			Date fromDate, Date endDate, int startAt, int maxResults, boolean fullText, String[] selectedCrps, 
			String[] selectedHubs, String[] selectedCoreCompetencies, String[] selectedTrainers, String[] selectedSponsors, boolean groupYearly, String cc) throws AdvancedTrainingSearchException {
		try {
			StringBuilder query = new StringBuilder("");
			query = groupQueryBuilder(sDate, eDate, operands, loc, text, fromDate, endDate, fullText, selectedCrps, selectedHubs, selectedCoreCompetencies, selectedTrainers, selectedSponsors, groupYearly, cc);
			
			PagedResult<TrainingProgram> paged = new PagedResult<TrainingProgram>();
			paged.setStartAt(startAt);
			
			//System.out.println("select distinct t from TrainingProgram t left outer join t.attendance at left outer join t.crps cr left outer t.hubs h left outer join t.coreCompetencies cc left outer join t.trainers tr " + query 
			//	+ " group by t.title, t.description, t.status, t.startDate, t.endDate order by t.startDate, t.endDate desc");
			paged.setMaxResults(maxResults);
			paged.setResults(this.entityManager.createQuery("select distinct t from TrainingProgram t left outer join t.attendance at left outer join t.crps cr left outer join t.hubs h left outer join t.coreCompetencies cc left outer join t.trainers tr left outer join fundings f " + query 
				+ " group by t.title, t.description, t.status, t.startDate, t.endDate order by t.startDate, t.endDate desc")
				.setFirstResult(startAt).setMaxResults(maxResults).getResultList());
	
			List<TrainingProgram> tp = this.entityManager.createQuery("select distinct t from TrainingProgram t left outer join t.attendance at left outer join t.crps cr left outer join t.hubs h left outer join t.coreCompetencies cc left outer join t.trainers tr left outer join t.fundings f " + query + " group by t.title, t.description, t.status, t.startDate, t.endDate")
				.getResultList();
			paged.setTotalHits(tp.size());
					
			return paged;
		} catch (NoResultException e) {
			throw new AdvancedTrainingSearchException("Training Program not found.");
		} catch (AdvancedTrainingSearchException e) {
			throw new AdvancedTrainingSearchException("Illegal operand supplied.");
		} catch (Exception e){
			throw new AdvancedTrainingSearchException("Training Program records not found! Check your criteria combinations.");
		}
	}// PagedResult<TrainingProgram> searchPrograms
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<TrainingProgram> searchPrograms(String sDate, String eDate, String operands, String loc, String text, Date fromDate, 
			Date endDate, boolean fullText, String[] selectedCrps, String[] selectedHubs, String[] selectedCoreCompetencies,
			String[] selectedTrainers, String[] selectedSponsors, boolean groupYearly, String cc) throws AdvancedTrainingSearchException {
		try {
			
			StringBuilder query = new StringBuilder("");

			query = groupQueryBuilder(sDate, eDate, operands, loc, text, fromDate, endDate, fullText, selectedCrps, selectedHubs, selectedCoreCompetencies, selectedTrainers, selectedSponsors, groupYearly, cc);
			
			return (List<TrainingProgram>) this.entityManager.createQuery("select distinct t from TrainingProgram t left outer join t.attendance at left outer join t.crps cr left outer join t.hubs h left outer join t.coreCompetencies cc left outer join t.trainers tr left outer join t.fundings f " + query + " group by t.title, t.description, t.status, t.startDate, t.endDate order by t.startDate, t.endDate desc")
				.getResultList();
		} catch (NoResultException e) {
			LOG.warn("Training Program not found.");
			throw new AdvancedTrainingSearchException("Training Program not found.");
		} catch (AdvancedTrainingSearchException e) {
			throw new AdvancedTrainingSearchException("Illegal operand supplied.");
		} catch (Exception e){
			throw new AdvancedTrainingSearchException("Training Program records not found! Check your criteria combinations.");
		}
	}// List<TrainingProgram> searchPrograms

	private StringBuilder traineeQueryBuilder(String sDate, String eDate, String operands, String origin, String text, Date fromDate, Date endDate,
			boolean fullText, String type, String[] selectedCrps, String[] selectedHubs, String[] selectedCoreCompetencies, String[] selectedTrainers, String[] selectedSponsors, String loc, boolean groupYearly, String cc) throws AdvancedTrainingSearchException {
		
		String[] arrayText = text.split("\\s+");
		StringBuilder query = new StringBuilder("");
		StringBuilder where = new StringBuilder("");

		for (String txt : arrayText) {
			if (txt != null && txt.length() > 0) {
				if (query.length() == 0) {
					query.append("(");
					query.append("t.person.lastName like '%").append(txt).append("%'");
					query.append(" or t.person.firstName like '%").append(txt).append("%'");
					query.append(" or t.program like '%").append(txt).append("%'");
					query.append(" or t.location like '%").append(txt).append("%'");
					query.append(" or t.country like '%").append(txt).append("%'");
					query.append(" or t.keywords like '%").append(txt).append("%'");
					query.append(" or t.discipline like '%").append(txt).append("%'");
					query.append(" or t.sponsor like '%").append(txt).append("%'");
					query.append(" or t.degree like '%").append(txt).append("%'");
					query.append(")");
				} else {
					query.append(" or (");
					query.append("t.person.lastName like '%").append(txt).append("%'");
					query.append(" or t.person.firstName like '%").append(txt).append("%'");
					query.append(" or t.program like '%").append(txt).append("%'");
					query.append(" or t.location like '%").append(txt).append("%'");
					query.append(" or t.country like '%").append(txt).append("%'");
					query.append(" or t.keywords like '%").append(txt).append("%'");
					query.append(" or t.discipline like '%").append(txt).append("%'");
					query.append(" or t.sponsor like '%").append(txt).append("%'");
					query.append(" or t.degree like '%").append(txt).append("%'");
					query.append(")");
				}
			}
		}

		if (query.length() > 0) {
			String fromDate1 = "";
			String endDate1 = "";
			if (fromDate != null && endDate != null) {
				if(groupYearly){
					fromDate1 = new SimpleDateFormat("yyyy").format(fromDate);
					endDate1 = new SimpleDateFormat("yyyy").format(endDate);
				}else{
					fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
				}
			}else if (fromDate != null && endDate == null) {
				if(groupYearly){
					fromDate1 = new SimpleDateFormat("yyyy").format(fromDate);
				}else{
					fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
				}
			}else  if (fromDate == null && endDate != null) {
				if(groupYearly){
					endDate1 = new SimpleDateFormat("yyyy").format(endDate);
				}else{
					endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
				}
			}
			
			if (fromDate != null && endDate != null) {
				if (sDate.equals("BETWEEN") && operands.equals("AND")) {
					//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
					if(!groupYearly)
						query.append(" and ((t.startDate ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" '")
							.append(endDate1).append("'))");
					else
						query.append(" and ((YEAR(t.startDate) ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" '")
						.append(endDate1).append("'))");
					//return query;
				} else {
					if (sDate.equals("BETWEEN") && operands.equals("OR")) {
						throw new AdvancedTrainingSearchException("Illegal operand supplied");
					}

					if (sDate.equals("<") || sDate.equals("<=") || sDate.equals("=") || sDate.equals(">") || sDate.equals(">=")) {
						if (operands.equals("AND") || operands.equals("OR")) {
							if (eDate.equals("<") || eDate.equals("<=") || eDate.equals("=") || eDate.equals(">") || eDate.equals(">=")) {
								//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
								//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
								if(!groupYearly)
									query.append(" and ((t.startDate ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands)
										.append(" t.endDate").append(" ").append(eDate).append(" '").append(endDate1).append("'))");
								else
									query.append(" and ((YEAR(t.startDate) ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands)
									.append(" YEAR(t.endDate)").append(" ").append(eDate).append(" '").append(endDate1).append("'))");
								//return query;
							}
						} else {
							throw new AdvancedTrainingSearchException("Illegal operand supplied");
						}
					}
				}
			}else if (fromDate != null && (sDate.equals("<") || sDate.equals("<=") || sDate.equals("=") || sDate.equals(">") || sDate.equals(">="))) {
				//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
				if(sDate.isEmpty())
					sDate = "=";
				
				if(!groupYearly)
					query.append(" and ((t.startDate ").append(sDate).append(" '").append(fromDate1).append("'").append("))");
				else
					query.append(" and ((YEAR(t.startDate) ").append(sDate).append(" '").append(fromDate1).append("'").append("))");
				//return query;
			}else if (endDate != null && (eDate.equals("<") || eDate.equals("<=") || eDate.equals("=") || eDate.equals(">") || eDate.equals(">="))) {
				//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
				
				if(eDate.isEmpty())
					eDate = "=";
				
				if(!groupYearly)
					query.append(" and ((t.endDate ").append(eDate).append(" '").append(endDate1).append("'").append(")").append(" or ")
						.append("(t.extensionDate ").append(eDate).append("'").append(endDate1).append("'").append("))");
				else
					query.append(" and ((YEAR(t.endDate) ").append(eDate).append(" '").append(endDate1).append("'").append(")").append(" or ")
					.append("(t.extensionDate ").append(eDate).append("'").append(endDate1).append("'").append("))");
				//return query;
			} //else {
			//	throw new AdvancedTrainingSearchException("Illegal operand supplied");
			//}

		} else {
			String fromDate1 = "";
			String endDate1 = "";
			if (fromDate != null && endDate != null) {
				if(groupYearly){
					fromDate1 = new SimpleDateFormat("yyyy").format(fromDate);
					endDate1 = new SimpleDateFormat("yyyy").format(endDate);
				}else{
					fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
				}
			}else if (fromDate != null && endDate == null) {
				if(groupYearly){
					fromDate1 = new SimpleDateFormat("yyyy").format(fromDate);
				}else{
					fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
				}
			}else  if (fromDate == null && endDate != null) {
				if(groupYearly){
					endDate1 = new SimpleDateFormat("yyyy").format(endDate);
				}else{
					endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
				}
			}
			
			//add the newer condition here
			if (fromDate != null && endDate != null) {
				if (sDate.equals("BETWEEN") && operands.equals("AND")) {
					//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
					
					if(!groupYearly)
						query.append(" t.startDate ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" '").append(endDate1)
							.append("'");
					else
						query.append(" YEAR(t.startDate) ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" '").append(endDate1)
						.append("'");
					//return query;
				} else {
					if (sDate.equals("BETWEEN") && operands.equals("OR")) {
						throw new AdvancedTrainingSearchException("Illegal operand supplied");
					}

					if (sDate.equals("<") || sDate.equals("<=") || sDate.equals("=") || sDate.equals(">") || sDate.equals(">=")) {
						if (operands.equals("AND") || operands.equals("OR")) {
							if (eDate.equals("<") || eDate.equals("<=") || eDate.equals("=") || eDate.equals(">") || eDate.equals(">=")) {
								//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
								//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
								
								if(!groupYearly)
									query.append(" ((t.startDate ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" t.endDate")
										.append(" ").append(eDate).append(" '").append(endDate1).append("'))");
								else
									query.append(" ((YEAR(t.startDate) ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" t.endDate")
									.append(" ").append(eDate).append(" '").append(endDate1).append("'))");
								//return query;
							}
						} else {
							//if (sDate.length() == 0 && eDate.length() == 0)
							throw new AdvancedTrainingSearchException("Illegal operand supplied");
						}
					}
				}
			} else if (fromDate != null) {
				//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
				if(sDate.isEmpty())
					sDate = "=";
				
				if(!groupYearly)
					query.append("(t.startDate ").append(sDate).append(" '").append(fromDate1).append("'").append(")");
				else
					query.append("(YEAR(t.startDate) ").append(sDate).append(" '").append(fromDate1).append("'").append(")");
			} else if (endDate != null) {
				//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
				if(eDate.isEmpty())
					eDate = "=";
				
				if(!groupYearly)
					query.append("(t.endDate ").append(eDate).append(" '").append(endDate1).append("'").append(")").append(" or ").append("(t.extensionDate ")
						.append(eDate).append("'").append(endDate1).append("'").append(")");
				else
					query.append("(YEAR(t.endDate) ").append(eDate).append(" '").append(endDate1).append("'").append(")").append(" or ").append("(t.extensionDate ")
					.append(eDate).append("'").append(endDate1).append("'").append(")");
			}
		}
		
		if (origin!=null) {
			if (origin.length() > 0) {
				if(query != null && !query.toString().equals(""))
					query.append(" and (t.person.country = '").append(origin).append("')");
				else
					query.append("(t.person.country = '").append(origin).append("')");
			}
		}
		
		if (loc!=null) {
			if (loc.length() > 0) {
				if(query != null && !query.toString().equals(""))
					query.append(" and (t.country = '").append(loc).append("')");
				else
					query.append("(t.country = '").append(loc).append("')");
			}
		}
		
		if (type!=null) {
			if (type.length() > 0) {
				if(query != null && !query.toString().equals(""))
					query.append(" and (t.degree = '").append(type).append("')");
				else
					query.append("(t.degree = '").append(type).append("')");
			}
		}
		
		String[] arrayCc = cc.split("\\s+");
		if(query != null && !query.toString().equals("") && arrayCc.length>0){
			query.append(" and ");
			int counter = 0;
			for (String txtCc : arrayCc) {
				if (txtCc != null && txtCc.length() > 0) {
					txtCc = txtCc.replace(",", "");
					if(counter==0)
						query.append("(f.costCenter = ").append(txtCc);//.append(")");
					else
						query.append(" or f.costCenter = ").append(txtCc);//.append(")");
				}
				counter++;
			}
			if(arrayCc.length == counter)
				query.append(")");
		}else{
			int counter = 0;
			for (String txtCc : arrayCc) {
				if (txtCc != null && txtCc.length() > 0) {
					txtCc = txtCc.replace(",", "");
					if(counter==0)
						query.append("(f.costCenter = ").append(txtCc);//.append(")");
					else
						query.append(" or f.costCenter = ").append(txtCc);//.append(")");
				}
				counter++;
			}
			if(arrayCc.length == counter)
				query.append(")");
		}
		
		//System.out.println("LENGTH OF CRPs SELECTED: " + selectedCrps.length);
		
		if(selectedCrps!=null){
			if(selectedCrps.length>0){
				StringBuilder crps = new StringBuilder("");
				for(String crp : selectedCrps){
					if(!"".equals(crp)){
						if(crps.length()==0)
							crps.append("'").append(crp).append("'");
						else
							crps.append(", '").append(crp).append("'");
					}
				}
				
				if(crps.length()>0){
					if(query != null && !query.toString().equals(""))
						query.append(" and (cr.name IN (").append(crps).append("))");
					else
						query.append("(cr.name IN (").append(crps).append("))");
				}
			}
		}
		
		if(selectedHubs!=null){
			if(selectedHubs.length>0){
				StringBuilder hubs = new StringBuilder("");
				for(String hub : selectedHubs){
					if(!"".equals(hub)){
						if(hubs.length()==0)
							hubs.append("'").append(hub).append("'");
						else
							hubs.append(", '").append(hub).append("'");
					}
				}
				if(hubs.length()>0){
					if(query != null && !query.toString().equals(""))
						query.append(" and (h.name IN (").append(hubs).append("))");
					else
						query.append("(h.name IN (").append(hubs).append("))");
				}
			}
		}
		
		if(selectedCoreCompetencies!=null){
			if(selectedCoreCompetencies.length>0){
				StringBuilder comps = new StringBuilder("");
				for(String comp : selectedCoreCompetencies){
					if(!"".equals(comp)){
						if(comps.length()==0)
							comps.append("'").append(comp).append("'");
						else
							comps.append(", '").append(comp).append("'");
					}
				}
				
				if(comps.length()>0){
					if(query != null && !query.toString().equals(""))
						query.append(" and (cc.name IN (").append(comps).append("))");
					else
						query.append("(cc.name IN (").append(comps).append("))");
				}
			}
		}
		
		if(selectedTrainers!=null){
			if(selectedTrainers.length>0){
				StringBuilder trainers = new StringBuilder("");
				for(String trainer : selectedTrainers){
					if(!"".equals(trainer)){
						if(trainers.length()==0)
							trainers.append("").append(trainer).append("");
						else
							trainers.append(",").append(trainer).append("");
					}
				}
				
				if(trainers.length()>0){
					if(query != null && !query.toString().equals(""))
						query.append(" and (sup.person.id IN (").append(trainers).append("))");
					else
						query.append("(sup.person.id IN (").append(trainers).append("))");
				}
			}
		}

		if(selectedSponsors!=null){
			if(selectedSponsors.length>0){
				StringBuilder sponsors = new StringBuilder("");
				for(String sponsor : selectedSponsors){
					if(!"".equals(sponsor)){
						if(sponsors.length()==0)
							sponsors.append("").append(sponsor).append("");
						else
							sponsors.append(",").append(sponsor).append("");
					}
				}
				
				if(sponsors.length()>0){
					if(query != null && !query.toString().equals(""))
						query.append(" and (f.organization.id IN (").append(sponsors).append("))");
					else
						query.append("(f.organization.id IN (").append(sponsors).append("))");
				}
			}
		}
		
		if(query != null && !query.toString().equals(""))
			where.append("where ").append(query);
		
		return where;
	} //traineeQueryBuilder
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public PagedResult<Trainee> searchTrainee(String sDate, String eDate, String operands, String origin, String text, Date fromDate, 
			Date endDate, int startAt, int maxResults, boolean fullText, String type, String[] selectedCrps, String[] selectedHubs, 
			String[] selectedCoreCompetencies, String[] selectedTrainers, String[] selectedSponsors, String loc, boolean groupYearly, String cc) throws AdvancedTrainingSearchException  {
		String feds = null;
		try {
			StringBuilder query = new StringBuilder("");
			query = traineeQueryBuilder(sDate, eDate, operands, origin, text, fromDate, endDate, fullText, type, selectedCrps, selectedHubs, selectedCoreCompetencies, selectedTrainers, selectedSponsors, loc, groupYearly, cc);
			
			PagedResult<Trainee> paged = new PagedResult<Trainee>();
			paged.setStartAt(startAt);
			paged.setMaxResults(maxResults);
			feds = "select distinct t from Trainee t left outer join t.person left outer join t.crps cr left outer join t.hubs h left outer join t.coreCompetencies cc left outer join t.supervisors sup left outer join t.fundings f " + query + " group by t.researchTopic, t.person.lastName, t.person.firstName, t.person.country, t.startDate, t.endDate";
			
			//System.out.println(feds);
			paged.setResults(this.entityManager.createQuery(feds + " order by t.person.firstName, t.person.lastName asc")
				.setFirstResult(startAt).setMaxResults(maxResults).getResultList());
					
			List<Trainee> tr = this.entityManager.createQuery(feds).getResultList();
			paged.setTotalHits(tr.size());
			return paged;
		} catch (NoResultException e) {
			throw new AdvancedTrainingSearchException("Trainee not found.");
		} catch (AdvancedTrainingSearchException e) {
			throw new AdvancedTrainingSearchException("Illegal operand supplied.");
		} catch (Exception e){
			throw new AdvancedTrainingSearchException("Trainee records not found! Check your criteria combinations. " + feds);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Trainee> searchTrainee(String sDate, String eDate, String operands, String origin, String text, Date fromDate, 
			Date endDate, boolean fullText, String type, String[] selectedCrps, String[] selectedHubs, 
			String[] selectedCoreCompetencies, String[] selectedTrainers, String[] selectedSponsors, String loc, boolean groupYearly, String cc) throws AdvancedTrainingSearchException {
		try {
			StringBuilder query = traineeQueryBuilder(sDate, eDate, operands, origin, text, fromDate, endDate, fullText, type, selectedCrps, selectedHubs, selectedCoreCompetencies, selectedTrainers, selectedSponsors, loc, groupYearly, cc);

			return (List<Trainee>) this.entityManager.createQuery("select distinct t from Trainee t left outer join t.person left outer join t.crps cr left outer join t.hubs h left outer join t.coreCompetencies cc left outer join t.supervisors sup left outer join t.fundings f " + query + " group by t.researchTopic, t.person.lastName, t.person.firstName, t.person.country, t.startDate, t.endDate order by t.person.firstName, t.person.lastName asc")
				.getResultList();
		} catch (NoResultException e) {
			LOG.warn("Trainee not found.");
			throw new AdvancedTrainingSearchException("Trainee not found.");
		} catch (AdvancedTrainingSearchException e) {
			throw new AdvancedTrainingSearchException("Illegal operand supplied.");
		} catch (Exception e){
			throw new AdvancedTrainingSearchException("Trainee records not found! Check your criteria combinations.");
		}
	}
	

	/*
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public String[] getTraineeTypes() {
		return (String[]) this.entityManager.createQuery("select distinct tr.degree from Trainee tr order by tr.degree asc").getResultList().toArray(
				new String[] {});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public String[] getGroupTypes() {
		return (String[]) this.entityManager.createQuery("select distinct tr.status from TrainingProgram tr order by tr.status asc").getResultList().toArray(
				new String[] {});
	}*/
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<String> getTraineeTypes() {
		return this.entityManager.createQuery("from Trainee tr where tr.degree is not null and tr.degree<>'' group by tr.degree order by tr.degree asc").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<String> getGroupTypes() {
		return this.entityManager.createQuery("from TrainingProgram tr where tr.status is not null and tr.status<>'' group by tr.status order by tr.status asc").getResultList();
	}
	
	private StringBuilder proposalQueryBuilder(String sDate, String eDate, String operands, String loc, String text, Date fromDate, Date endDate, boolean fullText, String type, boolean groupYearly, String cc) throws AdvancedTrainingSearchException{
		String[] arrayText = text.split("\\s+");
		StringBuilder query = new StringBuilder("");
		StringBuilder where = new StringBuilder("");
		
		if(fullText!=true){
			for (String txt : arrayText) {
				if (txt != null && txt.length() > 0) {
					if (query.length() == 0) {
						query.append("(");
						query.append("t.requester.displayName like '").append(txt).append("%'");
						query.append(" or t.programDirector.displayName like '").append(txt).append("%'");
						query.append(" or t.title like '%").append(txt).append("%'");
						//query.append(" or t.type like '%").append(txt).append("%'");
						
						query.append(" or t.projectInformation like '%").append(txt).append("%'");
						query.append(" or t.crp like '%").append(txt).append("%'");
						query.append(" or t.activity like '%").append(txt).append("%'");
						query.append(" or t.costCenter like '%").append(txt).append("%'");

						query.append(" or t.introduction like '%").append(txt).append("%'");						
						query.append(" or t.targetGroup like '%").append(txt).append("%'");
						query.append(" or t.objective like '%").append(txt).append("%'");
						query.append(" or t.learningMethod like '%").append(txt).append("%'");
						query.append(" or t.expectedOutcome like '%").append(txt).append("%'");
						query.append(" or t.courseContents like '%").append(txt).append("%'");
						query.append(" or t.keywords like '%").append(txt).append("%'");
						query.append(" or ('").append(txt).append("' in t.trainingLocations.country").append("')");
						query.append(" or ('").append(txt).append("' in t.trainingLocations.venue").append("')");
						query.append(")");
					} else {
						query.append(" or (");
						query.append("t.requester.displayName like '").append(txt).append("%'");
						query.append(" or t.programDirector.displayName like '").append(txt).append("%'");
						query.append(" or t.title like '%").append(txt).append("%'");
						//query.append(" or t.type like '%").append(txt).append("%'");
						
						query.append(" or t.projectInformation like '%").append(txt).append("%'");
						query.append(" or t.crp like '%").append(txt).append("%'");
						query.append(" or t.activity like '%").append(txt).append("%'");
						query.append(" or t.costCenter like '%").append(txt).append("%'");

						query.append(" or t.introduction like '%").append(txt).append("%'");						
						query.append(" or t.targetGroup like '%").append(txt).append("%'");
						query.append(" or t.objective like '%").append(txt).append("%'");
						query.append(" or t.learningMethod like '%").append(txt).append("%'");
						query.append(" or t.expectedOutcome like '%").append(txt).append("%'");
						query.append(" or t.courseContents like '%").append(txt).append("%'");
						query.append(" or t.keywords like '%").append(txt).append("%'");
						query.append(" or ('").append(txt).append("' in t.trainingLocations.country").append("')");
						query.append(" or ('").append(txt).append("' in t.trainingLocations.venue").append("')");
					}
				}
			}
		}
			
		if (query.length() > 0) {
			String fromDate1 = "";
			String endDate1 = "";
			if (fromDate != null && endDate != null) {
				if(groupYearly){
					fromDate1 = new SimpleDateFormat("yyyy").format(fromDate);
					endDate1 = new SimpleDateFormat("yyyy").format(endDate);
				}else{
					fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
				}
			}else if (fromDate != null && endDate == null) {
				if(groupYearly){
					fromDate1 = new SimpleDateFormat("yyyy").format(fromDate);
				}else{
					fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
				}
			}else  if (fromDate == null && endDate != null) {
				if(groupYearly){
					endDate1 = new SimpleDateFormat("yyyy").format(endDate);
				}else{
					endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
				}
			}
			
			if (fromDate != null && endDate != null) {
				if (sDate.equals("BETWEEN") && operands.equals("AND")) {
					//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
					if(!groupYearly)
						query.append(" and ((tl.startDate ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" '")
							.append(endDate1).append("'))");
					else
						query.append(" and ((YEAR(tl.startDate) ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" '")
						.append(endDate1).append("'))");
					//return query;
				} else {
					if (sDate.equals("BETWEEN") && operands.equals("OR")) {
						throw new AdvancedTrainingSearchException("Illegal operand supplied");
					}

					if (sDate.equals("<") || sDate.equals("<=") || sDate.equals("=") || sDate.equals(">") || sDate.equals(">=")) {
						if (operands.equals("AND") || operands.equals("OR")) {
							if (eDate.equals("<") || eDate.equals("<=") || eDate.equals("=") || eDate.equals(">") || eDate.equals(">=")) {
								//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
								//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
								if(!groupYearly)
									query.append(" and ((tl.startDate ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands)
										.append(" tl.endDate").append(" ").append(eDate).append(" '").append(endDate1).append("'))");
								else
									query.append(" and ((YEAR(tl.startDate) ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands)
									.append(" YEAR(tl.endDate)").append(" ").append(eDate).append(" '").append(endDate1).append("'))");
								//return query;
							}
						} else {
							throw new AdvancedTrainingSearchException("Illegal operand supplied");
						}
					}
				}
			}else if (fromDate != null && (sDate.equals("<") || sDate.equals("<=") || sDate.equals("=") || sDate.equals(">") || sDate.equals(">="))) {
				//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
				
				if(sDate.isEmpty())
					sDate = "=";
				
				if(!groupYearly)
					query.append(" and ((tl.startDate ").append(sDate).append(" '").append(fromDate1).append("'").append("))");
				else
					query.append(" and ((YEAR(tl.startDate) ").append(sDate).append(" '").append(fromDate1).append("'").append("))");
				//return query;
			}else if (endDate != null && (eDate.equals("<") || eDate.equals("<=") || eDate.equals("=") || eDate.equals(">") || eDate.equals(">="))) {
				//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
				
				if(eDate.isEmpty())
					eDate = "=";
				
				if(!groupYearly)
					query.append(" and (tl.endDate ").append(eDate).append(" '").append(endDate1).append("'").append(")");
				else
					query.append(" and (YEAR(tl.endDate) ").append(eDate).append(" '").append(endDate1).append("'").append(")");
				//return query;
			} //else {
			//	throw new AdvancedTrainingSearchException("Illegal operand supplied");
			//}

		} else {
			String fromDate1 = "";
			String endDate1 = "";
			if (fromDate != null && endDate != null) {
				if(groupYearly){
					fromDate1 = new SimpleDateFormat("yyyy").format(fromDate);
					endDate1 = new SimpleDateFormat("yyyy").format(endDate);
				}else{
					fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
				}
			}else if (fromDate != null && endDate == null) {
				if(groupYearly){
					fromDate1 = new SimpleDateFormat("yyyy").format(fromDate);
				}else{
					fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
				}
			}else  if (fromDate == null && endDate != null) {
				if(groupYearly){
					endDate1 = new SimpleDateFormat("yyyy").format(endDate);
				}else{
					endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
				}
			}
			
			//add the newer condition here
			if (fromDate != null && endDate != null) {
				if (sDate.equals("BETWEEN") && operands.equals("AND")) {
					//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
					
					if(!groupYearly)
						query.append(" tl.startDate ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" '").append(endDate1)
							.append("'");
					else
						query.append(" YEAR(tl.startDate) ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" '").append(endDate1)
						.append("'");
					//return query;
				} else {
					if (sDate.equals("BETWEEN") && operands.equals("OR")) {
						throw new AdvancedTrainingSearchException("Illegal operand supplied");
					}

					if (sDate.equals("<") || sDate.equals("<=") || sDate.equals("=") || sDate.equals(">") || sDate.equals(">=")) {
						if (operands.equals("AND") || operands.equals("OR")) {
							if (eDate.equals("<") || eDate.equals("<=") || eDate.equals("=") || eDate.equals(">") || eDate.equals(">=")) {
								//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
								//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
								
								if(!groupYearly)
									query.append(" ((tl.startDate ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" t.endDate")
										.append(" ").append(eDate).append(" '").append(endDate1).append("'))");
								else
									query.append(" ((YEAR(tl.startDate) ").append(sDate).append(" '").append(fromDate1).append("' ").append(operands).append(" t.endDate")
									.append(" ").append(eDate).append(" '").append(endDate1).append("'))");
								//return query;
							}
						} else {
							//if (sDate.length() == 0 && eDate.length() == 0)
							throw new AdvancedTrainingSearchException("Illegal operand supplied");
						}
					}
				}
			} else if (fromDate != null) {
				//String fromDate1 = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
				if(sDate.isEmpty())
					sDate = "=";
				
				if(!groupYearly)
					query.append("(tl.startDate ").append(sDate).append(" '").append(fromDate1).append("'").append(")");
				else
					query.append("(YEAR(tl.startDate) ").append(sDate).append(" '").append(fromDate1).append("'").append(")");
			} else if (endDate != null) {
				//String endDate1 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);

				if(eDate.isEmpty())
					eDate = "=";
				
				if(!groupYearly)
					query.append("(tl.endDate ").append(eDate).append(" '").append(endDate1).append("'").append(")");
				else
					query.append("(YEAR(tl.endDate) ").append(eDate).append(" '").append(endDate1).append("'").append(")");
			}
		}
		
		if (loc!=null) {
			if (loc.length() > 0) {
				if(query != null && !query.toString().equals(""))
					query.append(" and (").append(loc).append(" in tl.country").append("')");
				else
					query.append("(").append(loc).append(" in tl.country").append("')");
			}
		}
		
		if (type!=null) {
			if (type.length() > 0) {
				if(query != null && !query.toString().equals(""))
					query.append(" and (t.type = '").append(type).append("')");
				else
					query.append("(t.type = '").append(type).append("')");
			}
		}
		
		String[] arrayCc = cc.split("\\s+");
		if(query != null && !query.toString().equals("") && arrayCc.length>0){
			query.append(" and ");
			int counter = 0;
			for (String txtCc : arrayCc) {
				if (txtCc != null && txtCc.length() > 0) {
					txtCc = txtCc.replace(",", "");
					if(counter==0)
						query.append("(f.costCenter = ").append(txtCc);//.append(")");
					else
						query.append(" or f.costCenter = ").append(txtCc);//.append(")");
				}
				counter++;
			}
			if(arrayCc.length == counter)
				query.append(")");
		}else{
			int counter = 0;
			for (String txtCc : arrayCc) {
				if (txtCc != null && txtCc.length() > 0) {
					txtCc = txtCc.replace(",", "");
					if(counter==0)
						query.append("(f.costCenter = ").append(txtCc);//.append(")");
					else
						query.append(" or f.costCenter = ").append(txtCc);//.append(")");
				}
				counter++;
			}
			if(arrayCc.length == counter)
				query.append(")");
		}
		
		if(query != null && !query.toString().equals(""))
			where.append("where ").append(query).append(" and t.status='").append(STATUS.SUBMITTED).append("'");
		else
			where.append("where ").append("t.status='").append(STATUS.SUBMITTED).append("'");
		
		return where;
	} //proposalQueryBuilder
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public PagedResult<TrainingProposal> searchTrainingProposal(String sDate, String eDate, String operands, String loc, String text, Date fromDate, Date endDate, int startAt, int maxResults, boolean fullText, String type, boolean groupYearly, String cc) throws AdvancedTrainingSearchException {
		try {
			StringBuilder query = new StringBuilder("");
			query = proposalQueryBuilder(sDate, eDate, operands, loc, text, fromDate, endDate, fullText, type, groupYearly, cc);
			
			PagedResult<TrainingProposal> paged = new PagedResult<TrainingProposal>();
			paged.setStartAt(startAt);
					
			paged.setMaxResults(maxResults);
			paged.setResults(this.entityManager.createQuery("select distinct t from TrainingProposal t left outer join t.trainingLocations tl left outer join t.fundings f " + query 
				+ " group by t.title, t.requester, tl.startDate, tl.endDate order by tl.startDate, tl.endDate desc")
				.setFirstResult(startAt).setMaxResults(maxResults).getResultList());
	
			List<TrainingProposal> tp = this.entityManager.createQuery("select distinct t from TrainingProposal t left outer join t.trainingLocations tl left outer join t.fundings f " + query + " group by t.title, t.requester, tl.startDate, tl.endDate")
				.getResultList();
			paged.setTotalHits(tp.size());
					
			return paged;
		} catch (NoResultException e) {
			throw new AdvancedTrainingSearchException("Training Proposal not found.");
		} catch (AdvancedTrainingSearchException e) {
			throw new AdvancedTrainingSearchException("Illegal operand supplied.");
		} catch (Exception e){
			throw new AdvancedTrainingSearchException("Training Proposal records not found! Check your criteria combinations.");
		}
	}// PagedResult<TrainingProgram> searchPrograms
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<TrainingProposal> searchTrainingProposal(String sDate, String eDate, String operands, String loc, String text, Date fromDate, Date endDate, boolean fullText, String type, boolean groupYearly, String cc) throws AdvancedTrainingSearchException {
		try {
			
			StringBuilder query = new StringBuilder("");

			query = proposalQueryBuilder(sDate, eDate, operands, loc, text, fromDate, endDate, fullText, type, groupYearly, cc);
			
			return (List<TrainingProposal>) this.entityManager.createQuery("select distinct t from TrainingProposal t left outer join t.trainingLocations tl left outer join t.fundings f " + query + " group by t.title, t.status, tl.startDate, tl.endDate order by tl.startDate, tl.endDate desc")
				.getResultList();
		} catch (NoResultException e) {
			LOG.warn("Training Proposal not found.");
			throw new AdvancedTrainingSearchException("Training Proposal not found.");
		} catch (AdvancedTrainingSearchException e) {
			throw new AdvancedTrainingSearchException("Illegal operand supplied.");
		} catch (Exception e){
			throw new AdvancedTrainingSearchException("Training proposal records not found! Check your criteria combinations.");
		}
	}
	
	public PagedResult<Trainee> searchTrainee(User user, int year, int startAt, int maxResults){
		PagedResult<Trainee> paged = new PagedResult<Trainee>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		
		if(user != null){
			paged.setResults(entityManager.createQuery("select distinct t from Trainee t left outer join t.supervisors tr left outer join t.fundings f where tr.person.user=:user and year(t.startDate)=:year order by t.startDate Desc").setParameter(
				"user", user).setParameter("year", year).setFirstResult(startAt).setMaxResults(maxResults).getResultList());
			paged.setTotalHits((Long) entityManager.createQuery("select count(*) from Trainee t left outer join t.supervisors tr left outer join t.fundings f where tr.person.user=:user and year(t.startDate)=:year").setParameter(
					"user", user).setParameter("year", year).getSingleResult());
		}else{
			paged.setResults(entityManager.createQuery("select distinct t from Trainee t left outer join t.fundings f where year(t.startDate)=:year order by t.startDate Desc").setParameter("year", year)
					.setFirstResult(startAt).setMaxResults(maxResults).getResultList());
			paged.setTotalHits((Long) entityManager.createQuery("select count(*) from Trainee t left outer join t.fundings f where year(t.startDate)=:year").setParameter("year", year).getSingleResult());
		}
		
		return paged;
	}

	public PagedResult<TrainingProgram> searchPrograms(User user, int year, int startAt, int maxResults){
		PagedResult<TrainingProgram> paged = new PagedResult<TrainingProgram>();
		paged.setStartAt(startAt);
		paged.setMaxResults(maxResults);
		
		if(user != null){
			paged.setResults(entityManager.createQuery("select distinct t from TrainingProgram t left outer join t.supervisors tr left outer join t.fundings f where tr.person.user=:user and year(t.startDate)=:year order by t.startDate Desc").setParameter(
				"user", user).setParameter("year", year).setFirstResult(startAt).setMaxResults(maxResults).getResultList());
			paged.setTotalHits((Long) entityManager.createQuery("select count(*) from TrainingProgram t left outer join t.trainers tr left outer join t.fundings f where tr.person.user=:user and year(t.startDate)=:year").setParameter(
					"user", user).setParameter("year", year).getSingleResult());
		}else{
			paged.setResults(entityManager.createQuery("select distinct t  from TrainingProgram t left outer join t.fundings f where year(t.startDate)=:year order by t.startDate Desc")
					.setParameter("year", year).setFirstResult(startAt).setMaxResults(maxResults).getResultList());
			paged.setTotalHits((Long) entityManager.createQuery("select count(*) from TrainingProgram t left outer join t.fundings f where year(t.startDate)=:year").setParameter("year", year).getSingleResult());
		}
		
		return paged;
	}
}