<%@ include file="/common/taglibs.jsp"%>
<span class="trainer quick"> 
	<span id="programTrainerEdit_${id}">
		<s:push value="person">
			<s:include value="/WEB-INF/jsp/person/small.jsp" />
		</s:push>, <s:text name="grouptrainer.type.%{type}" /> 
		<security:authorize ifAnyGranted="ROLE_HEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
		<a href="<s:url action="trainer/remove" />?trainerId=<s:property value="id" /><s:push value="profile"><s:if test="top instanceof org.iita.trainingunit.model.Trainee && id!=null">&amp;traineeId=<s:property value="id" /></s:if><s:elseif test="top instanceof org.iita.trainingunit.model.TrainingProgram && id!=null">&amp;programId=<s:property value="id" /></s:elseif></s:push>"
			onclick="javascript: return confirm('Are you sure you want to remove this trainer?');"
			title="Delete this trainer?" alt="Delete this trainer?" />[ X ]</a> 
		</security:authorize>
	</span>
	<iita:inlineeditor
			targetId="programTrainerEdit_${id}" id="trainerEditform">
			<s:include value="/WEB-INF/jsp/trainer/updateform.jsp" />
		</iita:inlineeditor>
</span>