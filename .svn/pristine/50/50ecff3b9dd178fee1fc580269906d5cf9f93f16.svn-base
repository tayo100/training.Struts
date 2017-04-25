/**
 * 
 */
package org.iita.trainingunit.applications.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.search.annotations.ClassBridge;
import org.hibernate.search.annotations.Indexed;
import org.iita.crm.model.ActionLog;
import org.iita.crm.model.ActionLog.ActionType;
import org.iita.crm.model.ApplicationDocument;
import org.iita.crm.model.ApplicationReportDocument;
import org.iita.crm.model.Taggable;
import org.iita.entity.VersionedEntity;
import org.iita.security.UserAccess;
import org.iita.security.model.User;
import org.iita.trainingunit.announcements.model.Announcement;
import org.iita.trainingunit.lucene.ApplicationBridge;

/**
 * @author ken
 *
 */
@Entity
@Table(name = "Application")
@Indexed
@ClassBridge(impl = ApplicationBridge.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "`type`")
public abstract class Application extends VersionedEntity implements UserAccess, Taggable<Application> {
	private static final Log LOG = LogFactory.getLog(Application.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -6522615201912569765L;
	private Announcement announcement;
	private ApplicantsBioData biodata;
	private InternalApprovals internalApprovals;
	
	private String refNumber;
	private Date signedOn;	
	
	private SUBMISSIONSTATUS submissionStatus = SUBMISSIONSTATUS.Draft;
	private APPLICATIONSTATUS status = APPLICATIONSTATUS.PENDING;
	//private List<Approval> approvals = new ArrayList<Approval>();
	private List<PdfApplication> pdfApplications = new ArrayList<PdfApplication>();

	private String channelOfAwareness;

	private List<ApplicationDocument> documents;
	private List<ApplicationReportDocument> reportdocuments;
	private List<ActionLog> actionLog = new ArrayList<ActionLog>();
	
	public enum Type {
		GROUP, GRADUATE, NONDEGREE, INDIVIDUAL, STAFFDEVELOPMENT, SABBATICAL, INHOUSEGROUP, OTHERS
	}
	
	public enum TYPE {
		GROUP, GRADUATE, NONDEGREE, SELFDEVELOPMENT, INDIVIDUAL, INHOUSEGROUP, SABBATICAL, OTHERS
	}
	
	/** The parent application. */
	private Application parentApplication;
	
	public Application(){}
	
	public enum TRAININGTYPE {
		Solicited, Unsolicited
	}	
	
	
	
	/**
	 * SUBMITSTATUS.
	 */
	public enum SUBMISSIONSTATUS {
		/** Pending. */
		Draft,
		/** Approved. */
		Submitted
	}
	
	/**
	 * STATUS.
	 */
	public enum APPLICATIONSTATUS {
		PENDING, WAITING, WAITINGFORDIRECTOR, WAITINGFORCDO, WAITINGFORCFO, APPROVED, REJECTED, DEFERRED;
	}
	
	/**
	 * Copy constructor
	 * 
	 * @param application
	 */
	public Application(Application application) {
		this.refNumber = application.refNumber;
	}
	
	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	public Announcement getAnnouncement() {
		return announcement;
	}
	
	public void setStatus(APPLICATIONSTATUS status) {
		this.status = status;
	}
	
	@Enumerated(EnumType.STRING)
	public APPLICATIONSTATUS getStatus() {
		return status;
	}

	public void setBiodata(ApplicantsBioData biodata) {
		this.biodata = biodata;
	}
	
	@ManyToOne(cascade = {}, optional = false)
	public ApplicantsBioData getBiodata() {
		return biodata;
	}
	
	/**
	 * @return the refNumber
	 */
	@Column(length = 100)
	public String getRefNumber() {
		return refNumber;
	}
	
	/**
	 * @param refNumber the refNumber to set
	 */
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}
	
	public void setSignedOn(Date signedOn) {
		this.signedOn = signedOn;
	}

	public Date getSignedOn() {
		return signedOn;
	}
	
	public void setSubmissionStatus(SUBMISSIONSTATUS submissionStatus) {
		this.submissionStatus = submissionStatus;
	}

	/**
	 * @return the submitStatus
	 */
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	public SUBMISSIONSTATUS getSubmissionStatus() {
		return submissionStatus;
	}
	
	/**
	 * Get budget codes for this TA
	 * 
	 * @return
	 */
	/*
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
	public List<Approval> getApprovals() {
		return approvals;
	}

	public void setApprovals(List<Approval> approvals) {
		this.approvals = approvals;
	}
	*/
	/**
	 * Get generated pdfs for this Application
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
	public List<PdfApplication> getPdfApplications() {
		return pdfApplications;
	}

	public void setPdfApplications(List<PdfApplication> pdfApplications) {
		this.pdfApplications = pdfApplications;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	public InternalApprovals getInternalApprovals() {
		return internalApprovals;
	}

	public void setInternalApprovals(InternalApprovals internalApprovals) {
		this.internalApprovals = internalApprovals;
	}

	@Transient
	public boolean isRejected() {
		if (this.status != null && this.status==APPLICATIONSTATUS.REJECTED)
			return true;
		return false;
	}
	
	@Transient
	public boolean isApproveded() {
		if (this.status != null && this.status==APPLICATIONSTATUS.APPROVED)
			return true;
		return false;
	}

	@Transient
	public boolean isPending() {
		LOG.trace("Got pending status on application.");
		if (this.status != null && this.status==APPLICATIONSTATUS.PENDING)
			return true;
		return false;
	}
	
	@Transient
	public boolean isDeferred() {
		if (this.status != null && this.status==APPLICATIONSTATUS.DEFERRED)
			return true;
		return false;
	}
	
	public void setParentApplication(Application parentApplication) {
		this.parentApplication = parentApplication;
	}

	@ManyToOne(cascade = {}, optional = true)
	public Application getParentApplication() {
		return parentApplication;
	}

	public void setChannelOfAwareness(String channelOfAwareness) {
		this.channelOfAwareness = channelOfAwareness;
	}

	@Column(length = 500)
	public String getChannelOfAwareness() {
		return channelOfAwareness;
	}
	
	/**
	 * @return the documents
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "entity")
	@OrderBy("id desc")
	public List<ApplicationDocument> getDocuments() {
		return this.documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<ApplicationDocument> documents) {
		this.documents = documents;
	}
	
	/**
	 * @return the reportdocuments
	 */
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "entity")
	@OrderBy("id desc")
	public List<ApplicationReportDocument> getreportdocuments() {
		return this.reportdocuments;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setReportdocuments(List<ApplicationReportDocument> reportdocuments) {
		this.reportdocuments = reportdocuments;
	}
	
	/**
	 * Checks if all budget codes have been approved
	 * 
	 * @param ta
	 * @return <code>true</code> if all have been approved
	 */
	@Transient
	public boolean isAllBudgetCodesApproved() {
		for (int i = getInternalApprovals().getBudgetCodes().size() - 1; i >= 0; i--) {
			if (getInternalApprovals().getBudgetCodes().get(i).getStatus() != BCodeStatus.APPROVED)
				return false;
		}
		return true;
	}
	
	/**
	 * Get users who have approved the TA already
	 * 
	 * @param actionLog
	 * @return
	 */
	@Transient
	public List<User> getApprovers() {
		List<User> approvers = new ArrayList<User>();
		// sort action log by date descending
		List<ActionLog> actionLogs = new ArrayList<ActionLog>(getActionLog());
		Collections.sort(actionLogs, new Comparator<ActionLog>() {
			@Override
			public int compare(ActionLog arg0, ActionLog arg1) {
				return -arg0.getSysDate().compareTo(arg1.getSysDate());
			}
		});

		for (ActionLog actionLog : actionLogs) {
			if (actionLog.getAction() == ActionType.APPROVED || actionLog.getAction() == ActionType.SUBMITTED) {
				if (actionLog.getUser() == null)
					continue;
				if (!approvers.contains(actionLog.getUser())) {
					LOG.trace("Adding " + actionLog.getAction() + " of user " + actionLog.getUsername());
					approvers.add(actionLog.getUser());
				} else {
					LOG.trace("Already have user " + actionLog.getUsername() + " in approved path.");
				}
			} else {
				LOG.trace("Stopping list at " + actionLog.getAction() + " of user " + actionLog.getUsername());
				break;
			}
		}
		LOG.trace("Got " + approvers.size() + " existing approvers.");
		return approvers;
	}
	
	/**
	 * @return the actionLog
	 */
	@OneToMany(cascade = {}, mappedBy = "application")
	public List<ActionLog> getActionLog() {
		return this.actionLog;
	}
	
	/**
	 * @param actionLog the actionLog to set
	 */
	public void setActionLog(List<ActionLog> actionLog) {
		this.actionLog = actionLog;
	}

	/**
	 * @param user
	 * @return
	 */
	@Transient
	public boolean isWaitingForUser(User user) {
		if (user == null)
			return false;
		for (BudgetCode bc : getInternalApprovals().getBudgetCodes()) {
			if (bc.getNextApprover() == null)
				continue;
			if (bc.getNextApprover().getId().equals(user.getId()))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean hasAccess(User user) {		
		if(this.status==APPLICATIONSTATUS.APPROVED)
			return true;
		
		if (this.biodata.getOwner().getId().equals(user.getId())) {
			return true;
		}

		for (BudgetCode bc : this.internalApprovals.getBudgetCodes()) {
			//System.out.println("BCODE: "+bc.getCode());
			if (bc.getBudgetHolder().getId().equals(user.getId())) 
				return true;
			if(bc.getNextApprover()!=null && bc.getNextApprover().getId().equals(user.getId()))	
				return true;
		}

		for (ActionLog actionLog : this.actionLog) {
			if(actionLog.getUser()!=null) {
				if (actionLog.getUser().getId().equals(user.getId())) {
					return true;
				}
			}
		}
		return false;
	}
}
