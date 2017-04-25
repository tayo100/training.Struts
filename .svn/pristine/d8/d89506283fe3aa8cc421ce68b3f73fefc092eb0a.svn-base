<%@ include file="/common/taglibs.jsp"%>
<div id="cssmenu">
	<ul>
                    <security:authorize ifNotGranted="ROLE_APPLICANT,ROLE_USER">
						<li><a href="<s:url namespace="/" action="application/index" />"><span>Public domain</span></a></li>
						<li class='last'><a href="<s:url namespace="/" action="application/incomplete" />"><span>Continue Registration?</span></a></li>
					</security:authorize>
					
					<security:authorize ifAllGranted="ROLE_APPLICANT">
						<li><a href="<s:url namespace="/applicant" action="index" />"><span>Applicant dashboard</span></a></li>
					</security:authorize>
					
					<security:authorize ifAnyGranted="ROLE_STAFF">
						<security:authorize ifAnyGranted="ROLE_USER">
							<li><a href="<s:url namespace="/" action="index" />"><span>System dashboard</span></a></li>
						</security:authorize>
					</security:authorize>
					
					
                    <security:authorize ifNotGranted="ROLE_STAFF,ROLE_APPLICANT">
	                    <security:authorize ifAnyGranted="ROLE_USER">
							<li><a href="<s:url namespace="/" action="index" />"><span>Dashboard</span></a></li>
						</security:authorize>
	                    <security:authorize ifAnyGranted="ROLE_APPLICANT">
							<li><a href="<s:url namespace="/applicant" action="index" />"><span>Applicant Switch</span></a></li>
						</security:authorize>
					</security:authorize>
					
					<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_TRAININGUNITHEAD,ROLE_ITAICT,ROLE_IYAMANAGER,ROLE_IYAUSER">
						<li><a style="margin-right: 10px;" href="<s:url namespace='/iya' action='index' />"><span>IYA Agripreneurs</span></a></li>
					</security:authorize>
					
					<security:authorize ifAnyGranted="ROLE_USER">
	                    <li class="has-sub">
	                        <a href="#"><span>Manage</span></a>
	                        <ul>
	                            <security:authorize ifAnyGranted="ROLE_STAFF">
									<security:authorize ifAnyGranted="ROLE_USER">
									 	<li><a style="margin-right: 10px;" href="<s:url namespace='/selection' action='index' includeParams="none" />"><span>Selection</span></a></li>
										<li><a style="margin-right: 10px;" href="<s:url namespace="/" action='trainees/list' />"><span>Trainees</span></a></li>
										<li><a style="margin-right: 10px;" href="<s:url namespace="/" action='programs/list' />"><span>Training Programs</span></a></li>
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='announcement/trainingproposal' />"><span>Training Proposal</span></a></li>
									</security:authorize>
									<security:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_ADMIN,ROLE_QUERY,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_CRM,ROLE_PARTNERREADALL">
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='alumni/index' />"><span>Alumni</span></a></li>
									</security:authorize>
									<security:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_PARTNERREADALL">
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='partner/list' />"><span>Partners</span></a>
									</security:authorize>
									
									<security:authorize ifAnyGranted="ROLE_CRM">		
										<li><a style="margin-right: 10px;" href="<s:url namespace='/announcement' action='cdoindex' />"><span>Announcements</span></a></li>
										<li class="divider"></li>
									</security:authorize>
								</security:authorize>
								
								<security:authorize ifNotGranted="ROLE_STAFF,ROLE_APPLICANT">
									<security:authorize ifAnyGranted="ROLE_USER">
									 	<li><a style="margin-right: 10px;" href="<s:url namespace='/selection' action='index' includeParams="none" />"><span>Selection</span></a></li>
										<li><a style="margin-right: 10px;" href="<s:url namespace="/" action='trainees/list' />"><span>Trainees</span></a></li>
										<li><a style="margin-right: 10px;" href="<s:url namespace="/" action='programs/list' />"><span>Training Programs</span></a></li>
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='announcement/trainingproposal' />"><span>Training Proposal</span></a></li>
									</security:authorize>
									<security:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_ADMIN,ROLE_QUERY,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_CRM,ROLE_PARTNERREADALL">
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='alumni/index' />"><span>Alumni</span></a></li>
									</security:authorize>
									<security:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_PARTNERREADALL">
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='partner/list' />"><span>Partners</span></a>							
									</security:authorize>
									
									<security:authorize ifAnyGranted="ROLE_CRM">
										<li><a style="margin-right: 10px;" href="<s:url namespace='/announcement' action='cdoindex' />"><span>Announcements</span></a></li>
									</security:authorize>
								</security:authorize>
	                        </ul>
	                    </li>
	                    					
	                    <li class="has-sub">
	                        <a href="#"><span>Search</span></a>
	                        <ul>
	                            <security:authorize ifAnyGranted="ROLE_STAFF">
									<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERY,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_CRM">
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='query/index' />"><span>Query</span></a></li>
									</security:authorize>
									<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='advanced/search' />"><span>Advanced Search</span></a></li>
									<security:authorize ifAnyGranted="ROLE_CRM">		
										<li><a style="margin-right: 10px;" href="<s:url namespace='/announcement' action='search-applications' />"><span>Search Applications</span></a></li>
									</security:authorize>
								</security:authorize>
	                            
	                            <security:authorize ifNotGranted="ROLE_STAFF,ROLE_APPLICANT">
									<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERY,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_CRM">
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='query/index' />"><span>Query</span></a>
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='advanced/search' />"><span>Advanced Search</span></a></li>
									</security:authorize>
									<security:authorize ifAnyGranted="ROLE_CRM">		
										<li><a style="margin-right: 10px;" href="<s:url namespace='/announcement' action='search-applications' />"><span>Search Applications</span></a></li>
									</security:authorize>
								</security:authorize>
	                        </ul>
	                    </li>
                    </security:authorize>
                
                
                <security:authorize ifAnyGranted="ROLE_USER">
	                <li class="has-sub">
	                        <a href="#">Settings</a>
	                        <ul>
								<security:authorize ifAnyGranted="ROLE_ADMIN">
									<li><a style="margin-right: 10px;" href="<c:url value="/admin/" />"><span>Administration</span></a></li>
								</security:authorize>
	                        	<security:authorize ifAnyGranted="ROLE_USER">
									<li><a style="margin-right: 10px;" href="<s:url namespace="/" action="calendar" />"><span>Calendar</span></a></li>
									<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='user/notification' />"><span>Notifications</span></a></li>
									<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='user/delegate' />"><span>Delegate</span></a></li>
									<li><a style="margin-right: 10px;" href="mailto:software@iita.org?subject=Training Database Application bug report" title="Send a bug report"><span>Report Bug</span></a></li>
								</security:authorize>
	                        </ul>
	                    </li>
                </security:authorize>
                
                <security:authorize ifAnyGranted="ROLE_CFO">
					<li><a style="margin-right: 10px;" href="<c:url value="/cfo/" />"><span>CFO</span></a></li>
				</security:authorize>
						
				<security:authorize ifAnyGranted="ROLE_TRAININGUNITHEAD">
					<li><a style="margin-right: 10px;" href="<c:url value="/cdo/" />"><span>CDO Head</span></a></li>
				</security:authorize>
						
		         <security:authorize ifAnyGranted="ROLE_USER">
		         	<li class='last'><a style="margin-right: 10px;" href="<c:url value='/j_spring_security_logout' />" title="Log out"><span>Log out</span></a></li>
		         </security:authorize>
	</ul>
</div>