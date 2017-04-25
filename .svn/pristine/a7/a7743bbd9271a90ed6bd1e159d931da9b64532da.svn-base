<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>CDO/Projects Training Announcements</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<s:form method="post" namespace="/application" action="register">
			<!-- Form Name -->
			<div class="panel panel-blue margin-bottom-40">
				<div class="panel-heading">
					<h3 class="panel-title"><i class="fa fa-tasks">Training Application</i></h3>
				</div>	
			</div>
			<div class="panel-body">
				<!-- Select Basic -->
				<div class="row">
					<div class="col-xs-6 col-md-6">
					  	<label class="col-xs-12" for="trainingOption">Select Type:</label>
					    <s:select name="trainingOption" emptyOption="true" cssClass="form-control" 
						list="#{ 'Graduate' : 'Graduate Trainee', 'Group':'Group', 'Internship':'Internship', 'Sabbatical':'Sabbatical' }" />
					</div>
				</div>
				<!-- Button -->
				<div class="row">
					<div class="col-xs-6 col-md-6">
						<label class="col-xs-3">&nbsp;</label>
						<div class="col-xs-9 col-md-12">
							<button type="submit" id="singlebutton" name="singlebutton" class="btn btn-info">Start Application</button>
						</div>
					</div>
				</div>
			</div>	
		</s:form>
	
	<s:if test="nonGraduates.size()>0 || graduates.size()>0 || groups.size()>0 || others.size()>0">
		<div class="col-xs-8 col-md-8 alert alert-danger classWithPad">
			<s:include value="/WEB-INF/jsp/include/public-announcementlisting.jsp" />
		</div>
	</s:if>
	<s:elseif test="nonGraduates.size()==0 && graduates.size()==0 && groups.size()==0 && others.size()==0">
		<p>No solicited announcements found. Please check later.</p>
	</s:elseif>
	</div>
</div>
</body>
</html>