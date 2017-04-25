<%@ include file="/common/taglibs.jsp"%>
<div class="alert alert-block alert-success" style="float:left;width:300px;margin:10px;height:100px;">
<span class="application small">
					<s:if test="%{top instanceof org.iita.trainingunit.applications.model.GroupTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />"><s:property value="announcement.title" /></a>,
					</s:if>
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.GraduateResearchTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />"><s:property value="announcement.title" /></a>,
					</s:elseif>
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.NonDegreeTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />"><s:property value="announcement.title" /></a>,
					</s:elseif>
					
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.OtherTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />"><s:property value="announcement.title" /></a>,
					</s:elseif>
					
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.IndividualTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />"><s:property value="announcement.title" /></a>,
					</s:elseif>
					
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.SabbaticalTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />"><s:property value="announcement.title" /></a>,
					</s:elseif>
					
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.InHouseTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />"><s:property value="announcement.title" /></a>,
					</s:elseif>
					
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.StaffDevTraining}">
						<a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />"><s:property value="announcement.title" /></a>,
					</s:elseif>
					

<s:if
	test="biodata!=null">(<s:property value="biodata.fullName" /> - <em>registered: <iita:date format="dd MMM yyyy" name="createdDate" /></em>)</s:if></span>
</div>