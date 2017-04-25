/**
 * promisCRM.Struts Aug 18, 2010
 */
package org.iita.crm.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;
import org.iita.crm.model.Affiliation;
import org.iita.crm.model.Person;
import org.iita.struts.WebArchitecture;

/**
 * @author mobreza
 *
 */
public class CRMSystemArchitecture extends WebArchitecture {
	private static final Log LOG = LogFactory.getLog(CRMSystemArchitecture.class);
	private CRMNotifications crmNotifications;
	
	/**
	 * @param applicationNotifications
	 */
	public CRMSystemArchitecture(CRMNotifications crmNotifications) {
		super(crmNotifications);
		this.crmNotifications=crmNotifications;
	}
	
	@Override
	@Pointcut("within(org.iita.crm.service..*)")
	public void withinApplicationService() {
	}

	@AfterThrowing(pointcut = "withinApplicationService()", throwing = "ex")
	public void applicationExceptionThrown(Throwable ex) {
		LOG.error("Application exception thrown: " + ex.getMessage());
		this.crmNotifications.applicationExceptionThrown(ex);
	}

	@AfterReturning(pointcut="execution(* org.iita.crm.service.PersonService.registerPerson(org.iita.crm.model.Person))")
	public void personRegistered(final JoinPoint jp) {
		final Person person= (Person) jp.getArgs()[0];
		this.crmNotifications.personRegistered(person);
	}
	

	@AfterReturning(pointcut="execution(* org.iita.crm.service.OrganizationService.registerOrganization(java.lang.String))")
	public void organizationRegistered(final JoinPoint jp) {
		final String organizationTitle = (String) jp.getArgs()[0];
		this.crmNotifications.organizationRegistered(organizationTitle);
	}
	
	
	
	@AfterReturning(pointcut="execution(* org.iita.crm.service.OrganizationService.update(org.iita.crm.model.Affiliation))")
	public void affiliationUpdated(JoinPoint jp) {
		LOG.warn("affiliationUpated!!!!");
		Affiliation affiliation= (Affiliation) jp.getArgs()[0];
		this.crmNotifications.affiliationUpdated(affiliation);
	}

	@AfterReturning(pointcut="execution(* org.iita.crm.service.OrganizationService.remove(org.iita.crm.model.Affiliation))")
	public void affiliationRemoved(JoinPoint jp) {
		LOG.warn("affiliationRemoved!!!");
		Affiliation affiliation= (Affiliation) jp.getArgs()[0];
		this.crmNotifications.affiliationRemoved(affiliation);
	}
	
	
}
