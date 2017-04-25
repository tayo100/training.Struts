/**
 * promisCRM.Struts Aug 18, 2010
 */
package org.iita.crm.aspect;

import org.iita.annotation.Notification;
import org.iita.crm.model.Affiliation;
import org.iita.crm.model.Person;
import org.iita.security.Authorize;
import org.iita.service.NotificationSubscriptionService;
import org.iita.service.UserNotificationSender;
import org.iita.struts.ApplicationNotificationsImpl;

/**
 * @author mobreza
 * 
 */
public class CRMNotificationsImpl extends ApplicationNotificationsImpl implements CRMNotifications {

	private static final String AFFILIATION_UPDATED = "Affiliation of type %3$s between %1$s and %2$s updated.";
	private static final String AFFILIATION_REMOVED = "Affiliation of type %3$s between %1$s and %2$s was removed.";
	private static final String PERSON_REGISTERED = "Person %1$s registered.";
	private static final String ORGANIZATION_REGISTERED = "Organization %1$s registered.";

	/**
	 * @param notificationSender
	 * @param subscriptionService
	 */
	public CRMNotificationsImpl(UserNotificationSender notificationSender, NotificationSubscriptionService subscriptionService) {
		super(notificationSender, subscriptionService);
	}
	
	/**
	 * @see org.iita.crm.aspect.CRMNotifications#personRegistered(org.iita.crm.model.Person)
	 */
	@Override
	@Notification(defaultFormat=PERSON_REGISTERED, requiredRoles={"ROLE_CRM"})
	public void personRegistered(Person person) {
		sendNotification(Authorize.getPrincipal(), "personRegistered", null, PERSON_REGISTERED, person.getFullName());
	}
	
	/**
	 * @see org.iita.crm.aspect.CRMNotifications#organizationRegistered(java.lang.String)
	 */
	@Override
	@Notification(defaultFormat=ORGANIZATION_REGISTERED, requiredRoles={"ROLE_CRM"})
	public void organizationRegistered(String organizationTitle) {
		sendNotification(Authorize.getPrincipal(), "organizationRegistered", null, ORGANIZATION_REGISTERED, organizationTitle);
	}

	/**
	 * @see org.iita.crm.aspect.CRMNotifications#affiliationUpdated(org.iita.crm.model.Affiliation)
	 */
	@Override
	@Notification(defaultFormat = AFFILIATION_UPDATED, requiredRoles = {"ROLE_CRM"})
	public void affiliationUpdated(Affiliation affiliation) {
		sendNotification(Authorize.getPrincipal(), "affiliationUpdated", null, AFFILIATION_UPDATED, affiliation.getPerson().getFullName(), affiliation
				.getOrganization().getTitle(), affiliation.getType().name());
	}

	/**
	 * @see org.iita.crm.aspect.CRMNotifications#affiliationRemoved(org.iita.crm.model.Affiliation)
	 */
	@Override
	@Notification(defaultFormat = AFFILIATION_REMOVED, requiredRoles = {"ROLE_CRM"})
	public void affiliationRemoved(Affiliation affiliation) {
		sendNotification(Authorize.getPrincipal(), "affiliationRemoved", null, AFFILIATION_REMOVED, affiliation.getPerson().getFullName(), affiliation
				.getOrganization().getTitle(), affiliation.getType().name());
	}
}
