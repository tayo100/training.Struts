<%@ include file="/common/taglibs.jsp"%>
<span id="alertediting_${id}">
<span class="alert quick"> <s:date name="alertDate" format="dd/MM/yyyy HH:mm" />, <s:property value="subject" /> 
	<security:authorize ifAnyGranted="ROLE_HEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
		<a href="<s:url action="alert/remove" />?alertId=<s:property value="id" /><s:push value="profile"><s:if test="top instanceof org.iita.trainingunit.model.Trainee && id!=null">&amp;traineeId=<s:property value="id" /></s:if><s:elseif test="top instanceof org.iita.trainingunit.model.TrainingProgram && id!=null">&amp;programId=<s:property value="id" /></s:elseif></s:push>"
		onclick="javascript: return confirm('Are you sure you want to remove this alert?');" />[ X ]</a> 
	</security:authorize>
	</span>
</span>
<iita:inlineeditor id="alerteditform" targetId="alertediting_${id}">
			<s:include value="/WEB-INF/jsp/alert/alert-edit.jsp" />
		</iita:inlineeditor>