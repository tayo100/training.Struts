<%@ include file="/common/taglibs.jsp"%>
<div class="bs-example">
    <nav id="myNavbar" class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <security:authorize ifNotGranted="ROLE_APPLICANT,ROLE_USER">
						<li><a style="margin-right: 10px;" href="<s:url namespace="/" action="application/index" />">Public domain</a></li>
						<li><a style="margin-right: 10px;" href="<s:url namespace="/" action="application/incomplete" />">Continue Registration?</a></li>
					</security:authorize>
					
					<security:authorize ifAllGranted="ROLE_APPLICANT">
						<li><a style="margin-right: 10px;" href="<s:url namespace="/applicant" action="index" />">Applicant dashboard</a></li>
					</security:authorize>
					
					<security:authorize ifAnyGranted="ROLE_STAFF">
						<security:authorize ifAnyGranted="ROLE_USER">
							<li><a style="margin-right: 10px;" href="<s:url namespace="/" action="index" />">System dashboard</a></li>
						</security:authorize>
					</security:authorize>
					
					
                    <security:authorize ifNotGranted="ROLE_STAFF,ROLE_APPLICANT">
	                    <security:authorize ifAnyGranted="ROLE_USER">
							<li><a style="margin-right: 10px;" href="<s:url namespace="/" action="index" />">Dashboard</a></li>
						</security:authorize>
	                    <security:authorize ifAnyGranted="ROLE_APPLICANT">
							<li><a style="margin-right: 10px;" href="<s:url namespace="/applicant" action="index" />">Applicant Switch</a></li>
						</security:authorize>
					</security:authorize>
					
					<security:authorize ifAnyGranted="ROLE_USER">
	                    <li class="dropdown">
	                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Manage <b class="caret"></b></a>
	                        <ul class="dropdown-menu">
	                            <security:authorize ifAnyGranted="ROLE_STAFF">
									<security:authorize ifAnyGranted="ROLE_USER">
									 	<li><a style="margin-right: 10px;" href="<s:url namespace='/selection' action='index' includeParams="none" />">Selection</a></li>
										<li class="divider"></li>
										<li><a style="margin-right: 10px;" href="<s:url namespace="/" action='trainees/list' />">Trainees</a></li>
										<li class="divider"></li>
										<li><a style="margin-right: 10px;" href="<s:url namespace="/" action='programs/list' />">Training Programs</a></li>
										<li class="divider"></li>
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='announcement/trainingproposal' />">Training Proposal</a></li>
										<li class="divider"></li>
									</security:authorize>
									<security:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_ADMIN,ROLE_QUERY,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_CRM,ROLE_PARTNERREADALL">
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='alumni/index' />">Alumni</a></li>
										<li class="divider"></li>
									</security:authorize>
									<security:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_PARTNERREADALL">
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='partner/list' />">Partners</a>
										<li class="divider"></li>
									</security:authorize>
									
									<security:authorize ifAnyGranted="ROLE_CRM">		
										<li><a style="margin-right: 10px;" href="<s:url namespace='/announcement' action='cdoindex' />">Announcements</a></li>
										<li class="divider"></li>
									</security:authorize>
								</security:authorize>
								
								<security:authorize ifNotGranted="ROLE_STAFF,ROLE_APPLICANT">
									<security:authorize ifAnyGranted="ROLE_USER">
									 	<li><a style="margin-right: 10px;" href="<s:url namespace='/selection' action='index' includeParams="none" />">Selection</a></li>
										<li class="divider"></li>
										<li><a style="margin-right: 10px;" href="<s:url namespace="/" action='trainees/list' />">Trainees</a></li>
										<li class="divider"></li>
										<li><a style="margin-right: 10px;" href="<s:url namespace="/" action='programs/list' />">Training Programs</a></li>
										<li class="divider"></li>
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='announcement/trainingproposal' />">Training Proposal</a></li>
										<li class="divider"></li>
									</security:authorize>
									<security:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_ADMIN,ROLE_QUERY,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_CRM,ROLE_PARTNERREADALL">
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='alumni/index' />">Alumni</a></li>
										<li class="divider"></li>
									</security:authorize>
									<security:authorize ifAnyGranted="ROLE_PARTNERADMIN,ROLE_PARTNERREADALL">
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='partner/list' />">Partners</a>
										<li class="divider"></li>									
									</security:authorize>
									
									<security:authorize ifAnyGranted="ROLE_CRM">
										<li><a style="margin-right: 10px;" href="<s:url namespace='/announcement' action='cdoindex' />">Announcements</a></li>
										<li class="divider"></li>
									</security:authorize>
								</security:authorize>
	                        </ul>
	                    </li>
	                    
	                    <li class="dropdown">
	                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Search <b class="caret"></b></a>
	                        <ul class="dropdown-menu">
	                            <security:authorize ifAnyGranted="ROLE_USER">
									<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERY,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_CRM">
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='query/index' />">Query</a></li>
										<li class="divider"></li>
									</security:authorize>
									
									<security:authorize ifNotGranted="ROLE_STAFF,ROLE_APPLICANT">
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='advanced/search' />">Advanced Search</a></li>
										<li class="divider"></li>
										<li><a style="margin-right: 10px;" href="<s:url namespace='/announcement' action='search-applications' />">Search Applications</a></li>
										<li class="divider"></li>
									</security:authorize>
								</security:authorize>
	                            
	                            <security:authorize ifNotGranted="ROLE_STAFF,ROLE_APPLICANT">
									<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERY,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_CRM">
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='query/index' />">Query</a>
										<li class="divider"></li>
										<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='advanced/search' />">Advanced Search</a></li>
										<li class="divider"></li>
									</security:authorize>
									<security:authorize ifAnyGranted="ROLE_CRM">		
										<li><a style="margin-right: 10px;" href="<s:url namespace='/announcement' action='search-applications' />">Search Applications</a></li>
										<li class="divider"></li>
									</security:authorize>
								</security:authorize>
	                        </ul>
	                    </li>
                    </security:authorize>
                </ul>
                
                <security:authorize ifAnyGranted="ROLE_USER">
	                <ul class="nav navbar-nav navbar-right">
	                    <li class="dropdown">
	                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Settings <b class="caret"></b></a>
	                        <ul class="dropdown-menu">
								<security:authorize ifAnyGranted="ROLE_ADMIN">
									<li><a style="margin-right: 10px;" href="<c:url value="/admin/" />">Administration</a></li>
									<li class="divider"></li>
								</security:authorize>
	                        	<security:authorize ifAnyGranted="ROLE_USER">
									<li><a style="margin-right: 10px;" href="<s:url namespace="/" action="calendar" />">Calendar</a>
									<li class="divider"></li>
									<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='user/notification' />">Notifications</a>
									<li class="divider"></li>
									<li><a style="margin-right: 10px;" href="<s:url namespace='/' action='user/delegate' />">Delegate</a></li>
									<li class="divider"></li>
									<li><a style="margin-right: 10px; background-image: url('<c:url value="/img/help.png" />'); background-repeat: no-repeat; background-position: 0px 0px; padding-left: 20px;" href="mailto:software@iita.org?subject=Training Database Application bug report" title="Send a bug report">Report Bug</a></li>
									<li class="divider"></li>
									<li><a style="margin-right: 10px;" href="<c:url value='/j_spring_security_logout' />" title="Log out">Log out</a></li>
								</security:authorize>
	                        </ul>
	                    </li>
	                </ul>
                </security:authorize>
            </div>
        </div>
    </nav>
</div>