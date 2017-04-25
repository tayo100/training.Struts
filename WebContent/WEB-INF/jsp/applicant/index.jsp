<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Applicant Dashboard: <s:property value="user.fullName" /></title>
</head>
<body>
<table style="width: 100%">
	<colgroup>
		<col />
		<col /> <%--  width="550" --%>
		<col width="400" />
	</colgroup>
	<tbody>
		<tr>
			<td style="padding-right: 10px;">			
				<s:include value="/WEB-INF/jsp/include/public-announcementlisting.jsp" />
			</td>
			<td style="padding-left: 10px;">
				<s:include value="/WEB-INF/jsp/include/mytraining-list.jsp" />
			</td>
			<td style="padding-left: 10px;">
				<s:include value="/WEB-INF/jsp/include/personal-data.jsp" />
				<table class="table">
						<colgroup>
							<col />
						</colgroup>
						<tr>
							<td>
							<div class="col-xs-12 col-md-12 alert alert-info">
								<s:form cssClass="form-horizontal" method="post" namespace="/applicant" action="register">
									<fieldset>
									
									<!-- Form Name -->
									<legend>Kickstart New Application</legend>
									
									<!-- Select Basic -->
									<div class="form-group">
									  <div class="col-xs-12 col-md-12">
									    <select id="trainingOption" name="trainingOption" class="form-control">
									    	<option value="">--Training type--</option>
									      <option value="Graduate">Graduate Trainee</option>
									      <option value="Group">Group</option>
									      <option value="Internship">Internship</option>
									      <option value="Sabbatical">Sabbatical</option>
									    </select>
									  </div>
									</div>
									
									<!-- Button -->
									<div class="form-group">
									  <div class="col-xs-12">
									    <button type="submit" id="singlebutton" name="singlebutton" class="btn btn-info">Start Application</button>
									  </div>
									</div>
									
									</fieldset>
								</s:form>
							</div>
							</td>
						</tr>
					</table>
			</td>
		</tr>
	</tbody>
</table>

</body>
</html>