<%@ include file="/common/taglibs.jsp"%>

<security:authorize ifNotGranted="ROLE_APPLICANT,ROLE_USER">
	<a style="margin-right: 10px;" href="<s:url namespace="/" action="application/index" />">Public domain</a>
	<a style="margin-right: 10px;" href="<s:url namespace="/" action="application/incomplete" />">Continue Registration?</a>
</security:authorize>

<security:authorize ifAllGranted="ROLE_APPLICANT">
	<a style="margin-right: 10px;" href="<s:url namespace="/applicant" action="index" />">Applicant dashboard</a>
</security:authorize>

<security:authorize ifAnyGranted="ROLE_STAFF">
	<security:authorize ifAnyGranted="ROLE_USER">
		<a style="margin-right: 10px;" href="<s:url namespace="/" action="index" />">System dashboard</a>
		<!-- Other menus -->
		<a style="margin-right: 10px;" href="<s:url namespace="/" action="calendar" />">Calendar</a>
		<a style="margin-right: 10px;" href="<s:url namespace='/' action='user/notification' />">Notifications</a>
		<a style="margin-right: 10px;" href="<s:url namespace='/' action='user/delegate' />">Delegate</a>
	 	<a style="margin-right: 10px;" href="<s:url namespace='/selection' action='index' includeParams="none" />">Selection</a>
		<a style="margin-right: 10px;" href="<s:url namespace="/" action='trainees/list' />">Trainees</a>
		<a style="margin-right: 10px;" href="<s:url namespace="/" action='programs/list' />">Training Programs</a>
		<a style="margin-right: 10px;" href="<s:url namespace='/' action='announcement/trainingproposal' />">Training Proposal</a>
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_HEAD,ROLE_QUERYMANAGER">
		<!-- <a style="margin-right: 10px;" href="<s:url namespace="/" action="merge" />" title="Information merge tool">Merge</a> -->
	</security:authorize>
	<!-- End -->
	<a style="margin-right: 10px;" href="<s:url namespace='/' action='advanced/search' />">Advanced Search</a>
	<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERY,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_CRM">
		<!-- <a style="margin-right: 10px;" href="<s:url namespace='/' action='advanced/search' />">Advanced Search</a> -->
		<a style="margin-right: 10px;" href="<s:url namespace='/' action='query/index' />">Query</a>		
	</security:authorize>
	<security:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_ADMIN,ROLE_QUERY,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_CRM,ROLE_PARTNERREADALL">
		<a style="margin-right: 10px;" href="<s:url namespace='/' action='alumni/index' />">Alumni</a>
	</security:authorize>
	<security:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_PARTNERREADALL">
		<a style="margin-right: 10px;" href="<s:url namespace='/' action='partner/list' />">Partners</a>
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_CRM">
		<a style="margin-right: 10px;" href="<s:url namespace='/announcement' action='search-applications' />">Search Applications</a>
		<a style="margin-right: 10px;" href="<s:url namespace='/announcement' action='cdoindex' />">Announcements</a>
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_ADMIN">
		<a style="margin-right: 10px;" href="<c:url value="/admin/" />">Administration</a>
	</security:authorize>
</security:authorize>

<security:authorize ifNotGranted="ROLE_STAFF,ROLE_APPLICANT">
	<security:authorize ifAnyGranted="ROLE_USER">
		<a style="margin-right: 10px;" href="<s:url namespace="/" action="index" />">Dashboard</a>
		<!-- Other menus -->
		<a style="margin-right: 10px;" href="<s:url namespace="/" action="calendar" />">Calendar</a>
	</security:authorize>
	<security:authorize ifAnyGranted="ROLE_APPLICANT">
		<a style="margin-right: 10px;" href="<s:url namespace="/applicant" action="index" />">Applicant Switch</a>
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_USER">
		<a style="margin-right: 10px;" href="<s:url namespace='/' action='user/notification' />">Notifications</a>
		<a style="margin-right: 10px;" href="<s:url namespace='/' action='user/delegate' />">Delegate</a>
	 	<a style="margin-right: 10px;" href="<s:url namespace='/selection' action='index' includeParams="none" />">Selection</a>
		<a style="margin-right: 10px;" href="<s:url namespace="/" action='trainees/list' />">Trainees</a>
		<a style="margin-right: 10px;" href="<s:url namespace="/" action='programs/list' />">Training Programs</a>
		<a style="margin-right: 10px;" href="<s:url namespace='/' action='announcement/trainingproposal' />">Training Proposal</a>
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_ITAICT,ROLE_IYAMANAGER,ROLE_IYAUSER">
		<a style="margin-right: 10px;" href="<s:url namespace='/iya' action='/index' />">IYA Agripreneurs</a>
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_HEAD,ROLE_QUERYMANAGER">
		<!-- <a style="margin-right: 10px;" href="<s:url namespace="/" action="merge" />" title="Information merge tool">Merge</a> -->
	</security:authorize>
	<!-- End -->
	<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERY,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_CRM">
		<a style="margin-right: 10px;" href="<s:url namespace='/' action='advanced/search' />">Advanced Search</a>
		<a style="margin-right: 10px;" href="<s:url namespace='/' action='query/index' />">Query</a>
	</security:authorize>
	<security:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_ADMIN,ROLE_QUERY,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_CRM,ROLE_PARTNERREADALL">
		<a style="margin-right: 10px;" href="<s:url namespace='/' action='alumni/index' />">Alumni</a>
	</security:authorize>
	<security:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_PARTNERREADALL">
		<a style="margin-right: 10px;" href="<s:url namespace='/' action='partner/list' />">Partners</a>
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_CRM">		
		<a style="margin-right: 10px;" href="<s:url namespace='/announcement' action='search-applications' />">Search Applications</a>
		<a style="margin-right: 10px;" href="<s:url namespace='/announcement' action='cdoindex' />">Announcements</a>
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_ADMIN">
		<a style="margin-right: 10px;" href="<c:url value="/admin/" />">Administration</a>
	</security:authorize>
</security:authorize>
<security:authorize ifAnyGranted="ROLE_USER">
	<!--  <a style="margin-right: 10px; background-image: url('<c:url value="/img/help.png" />'); background-repeat: no-repeat; background-position: 0px 0px; padding-left: 20px;" onclick="javascript: return IITAHELP.helpFrame();" title="Help!">Help</a> -->
	<a style="margin-right: 10px; background-image: url('<c:url value="/img/help.png" />'); background-repeat: no-repeat; background-position: 0px 0px; padding-left: 20px;" href="mailto:software@iita.org?subject=Training Database Application bug report" title="Send a bug report">Bug</a>
	<!--  <a style="margin-right: 10px;" href="http://pubx.iita.cgiarad.org:8880" title="Report a bug">Bug</a> -->
	
	<a style="margin-right: 10px;" href="<c:url value='/j_spring_security_logout' />" title="Log out">Log out</a>
</security:authorize>