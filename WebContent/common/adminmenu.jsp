<%@ include file="/common/taglibs.jsp"%>

<div id="cssmenu">
	<ul>
		<li><a style="margin-right: 10px;" href="<c:url value="/" />"><span>Public site</span></a></li>
		
		<!-- Standard -->
		<li class="has-sub"><a href="#">Manage</a>
			<ul>
				<li><a style="margin-right: 10px;" href="<s:url namespace="/admin" action="users" />"><span>Users</span></a></li>
				<li><a style="margin-right: 10px;" href="<s:url namespace="/admin" action="browse" />"><span>Browse</span></a></li>
				<li><a style="margin-right: 10px;" href="<s:url namespace="/admin" action="log" />"><span>Log</span></a></li>
				<li><a style="margin-right: 10px;" href="<s:url namespace="/admin" action="schema" />"><span>Schema</span></a></li>
				<li><a style="margin-right: 10px;" href="<s:url namespace="/admin" action="template/index" />"><span>Templates</span></a></li>
				<li><a style="margin-right: 10px;" href="<s:url namespace="/admin" action="undelete" />"><span>Undelete</span></a></li>
			</ul>
		</li>
		<li class="has-sub"><a href="#">Tools</a>
			<ul>
				<li><a href="<s:url action="schedule/index" />"><span>Scheduled jobs</span></a></li>
				<li><a href="<s:url action="lucene/reindex" />"><span>Lucene reindex</span></a></li>
				<li><a href="<s:url action="applock" />"><span>Block access to application</span></a></li>
				<li><a href="<s:url action="java-status" />"><span>JRE status</span></a></li>
			</ul>
		</li>
		<!-- Uncomment when help is ready -->
		<li><a style="margin-right: 10px;" onclick="javascript: return IITAHELP.helpFrame();" title="Help!"><span>Help</span></a></li>
		<security:authorize ifAnyGranted="ROLE_USER">
			<li><a style="margin-right: 10px;" href="<c:url value='/j_spring_security_logout' />" title="Log out"><span>Log out</span></a></li>
		</security:authorize>
	</ul>
</div>
