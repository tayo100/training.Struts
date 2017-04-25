<%@ include file="/common/taglibs.jsp"%>
<span class="trainer quick"> 
	<span id="supervisorEdit_${id}">
		<s:push value="person">
			<s:include value="/WEB-INF/jsp/person/small.jsp" />
		</s:push>, <s:text name="trainer.type.%{type}" />
		<security:authorize ifAnyGranted="ROLE_USER, ROLE_HEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
			<a href="<s:url action="trainer/remove" />?trainerId=<s:property value="id" /><s:push value="profile"><s:if test="top instanceof org.iita.trainingunit.model.Trainee && id!=null">&amp;traineeId=<s:property value="id" /></s:if><s:elseif test="top instanceof org.iita.trainingunit.model.TrainingProgram && id!=null">&amp;programId=<s:property value="id" /></s:elseif><s:elseif test="top instanceof org.iita.trainingunit.announcements.model.TrainingProposal && id!=null">&amp;trainingProposalId=<s:property value="id" /></s:elseif><s:elseif test="top instanceof org.iita.trainingunit.announcements.model.Announcement && id!=null">&amp;announcementId=<s:property value="id" /></s:elseif></s:push>"
			onclick="javascript: return confirm('Are you sure you want to remove this supervisor?');"
			title="Delete this supervisor?" alt="Delete this supervisor?" />[ X ]</a>
		</security:authorize>
		
	</span>
</span>
<iita:inlineeditor id="superVisorEditForm" targetId="supervisorEdit_${id}">
	<s:include value="/WEB-INF/jsp/trainer/updateform.jsp" />
</iita:inlineeditor> 