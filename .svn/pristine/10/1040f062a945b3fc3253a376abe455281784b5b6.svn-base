/**
 * training.Struts July 01, 2011
 */
package org.iita.trainingunit.cron;


import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iita.trainingunit.service.TrainingUnitService;
import org.iita.query.model.Query;
import org.iita.security.model.User;
import org.iita.security.service.UserService;
import org.iita.service.EmailException;
import org.iita.service.EmailService;
import org.iita.service.QueryService;
import org.iita.service.TemplatingException;
import org.iita.service.TemplatingService;
import org.iita.util.PagedResult;
import org.iita.util.StringUtil;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;

/**
 * @author KOraegbunam
 *
 */
public class EmailReports implements QuartzJob {
	private static final Log LOG = LogFactory.getLog(EmailReports.class);
	private UserService userService;
	private QueryService queryService;
	private TemplatingService templatingService;
	private EmailService emailService;
	/** List of roles that should receive emails */
	private String roles = "";
	private TrainingUnitService trainingUnitService;
	private int maxEmailRecords = 200;

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @param queryService the queryService to set
	 */
	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	/**
	 * @param emailService the emailService to set
	 */
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	/**
	 * @param templatingService the templatingService to set
	 */
	public void setTemplatingService(TemplatingService templatingService) {
		this.templatingService = templatingService;
	}

	/**
	 * @param trainingUnitService the trainingUnitService to set
	 */
	public void setTrainingUnitService(TrainingUnitService trainingUnitService) {
		this.trainingUnitService = trainingUnitService;
	}

	/**
	 * Set the list of roles. All users having those roles will receive all reports that those roles can access.
	 * 
	 * @param roles the roles to set
	 */
	public void setRoles(String roles) {
		this.roles = roles;
	}

	/**
	 * Maximum number of records matching the query that are included in the email
	 * 
	 * @param maxEmailRecords the maxEmailRecords to set
	 */
	public void setMaxEmailRecords(int maxEmailRecords) {
		this.maxEmailRecords = maxEmailRecords;
	}

	/**
	 * This action is invoked by Quartz
	 */
	@Override
	public void executeQuartz() {
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken("Quartz", "",
				new GrantedAuthority[] { new GrantedAuthorityImpl("ROLE_QUERY") });
		SecurityContextHolder.getContext().setAuthentication(authRequest);

		LOG.info("Email reports executing for roles " + roles);

		// split given roles
		String[] rolesArray = StringUtil.splitString(roles, "\\s*,\\s*");

		Hashtable<Query, Set<String>> queryRecipients = new Hashtable<Query, Set<String>>();

		for (String role : rolesArray) {
			LOG.info("Loading query setup for role: " + role);
			// 1-find all reports having any of the roles
			List<Query> queries = this.queryService.listForRole(role);

			// 2-find all users having any of the roles
			List<User> users = this.userService.findByRole(role);

			// 3-generate unique list of reports + recipients
			for (Query query : queries) {
				Set<String> recipients = queryRecipients.get(query);
				if (recipients == null)
					queryRecipients.put(query, recipients = new TreeSet<String>());
				for (User user : users)
					try {
						recipients.add(user.getSMTPAddress());
					} catch (Exception e) {
						LOG.warn("Could not add " + user + " to recipient list: " + e.getMessage());
					}
			}
		}

		// 4-execute report and send to recipients
		for (Query query : queryRecipients.keySet()) {
			LOG.info("Doing query: " + query.getTitle());
			String[] recipients = queryRecipients.get(query).toArray(new String[] {});
			LOG.info("Query recipients: " + StringUtil.arrayToString(recipients));

			if (recipients.length == 0) {
				LOG.warn("Query has no recipients. Skipping.");
				continue;
			}

			// no more than 200 rows!
			LOG.debug("Getting data");
			PagedResult<?> paged = this.queryService.executeQuery(query, 0, this.maxEmailRecords);

			LOG.debug("Got data, filling template");
			String htmlBody = null;

			try {
				if (query.getTemplateName() != null) {
					// try filling the template
					Map<String, Object> extraBeans = new Hashtable<String, Object>();
					extraBeans.put("trainingUnitService", this.trainingUnitService);
					htmlBody = this.templatingService.fillReport(query.getTemplateName(), query.getHeadings(), paged, extraBeans);
					if (paged.getPages() > 1) {
						htmlBody = "<p>There are <b>" + paged.getTotalHits() + "</b> records that match the query. Only first " + this.maxEmailRecords
								+ " records are included in this email. Use ProMIS CRM to see all " + "records.</p>" + htmlBody;
					}
				}

				if (htmlBody == null) {
					Map<String, Object> data = new Hashtable<String, Object>();
					data.put("query", query);
					data.put("paged", paged);
					data.put("results", paged.getResults());
					try {
						htmlBody = this.templatingService.fillTemplate("query-data-html", data);
					} catch (TemplatingException e) {
						LOG.error("Could not fill template: " + e.getMessage(), e);
					}
				}
			} catch (Exception e) {
				LOG.error("Error filling report template. " + e.getMessage(), e);
			}

			if (htmlBody != null) {
				LOG.debug("Sending HTML email");
				try {
					this.emailService.sendEmail(null, recipients, null, query.getTitle(), null, htmlBody);
				} catch (EmailException e) {
					LOG.error("Could not send email: " + e.getMessage(), e);
				}
			} else
				LOG.warn("Did not send report email, no email body constructed.");
		}

		LOG.info("Done executing scheduled queries.");
		SecurityContextHolder.getContext().setAuthentication(null);
	}
}
