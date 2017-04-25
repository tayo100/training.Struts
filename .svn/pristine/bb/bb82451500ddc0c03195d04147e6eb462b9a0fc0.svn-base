<%@ include file="/common/taglibs.jsp"%>
<span class="trainer quick"> 
	<span id="supervisorEdit_${id}">
		<s:push value="person">
			<s:include value="/WEB-INF/jsp/person/trainingproposal-small.jsp" />
		</s:push>, <s:text name="trainer.trainingproposal.type.%{type}" />
		<s:if test="trainingProposal.status==@org.iita.trainingunit.announcements.model.TrainingProposal$STATUS@DRAFT">
			<security:authorize ifAnyGranted="ROLE_USER, ROLE_HEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
				<a href="<s:url action="trainer/remove" />?trainerId=<s:property value="id" />&amp;trainingProposalId=<s:property value="trainingProposal.id" />"
				onclick="javascript: return confirm('Are you sure you want to remove this trainer?');"
				title="Delete this trainer?" alt="Delete this trainer">[X]</a>
			</security:authorize>
		</s:if>
	</span>
</span>
<%--<s:if test="trainingProposal.status==@org.iita.trainingunit.announcements.model.TrainingProposal$STATUS@DRAFT">
	<iita:inlineeditor id="superVisorEditForm" targetId="supervisorEdit_${id}">
		<s:include value="/WEB-INF/jsp/trainer/updateform.jsp" />
	</iita:inlineeditor>
</s:if>--%>