<%@ include file="/common/taglibs.jsp"%>
<span id="fundingEdit_${id}">
	<span class="trainer quick">
		<a href="<s:url action="organization/profile" />?id=<s:property value="organization.id" />"><s:if test="organization.shortName != null"><s:property value="organization.shortName" /></s:if><s:else><s:property value="organization.title" /></s:else></a>, <s:property value="sponsorType" /><s:if test="costCenter != null">, <s:property value="costCenter" /></s:if><s:if test="estimatedCost != null">, <s:text name="format.money">
					<s:param value="estimatedCost" />
				</s:text> USD</s:if>
		<security:authorize ifAnyGranted="ROLE_HEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
		<a href="<s:url action="funding/remove" />?fundingId=<s:property value="id" /><s:push value="profile"><s:if test="top instanceof org.iita.trainingunit.model.Trainee && id!=null">&amp;traineeId=<s:property value="id" /></s:if><s:elseif test="top instanceof org.iita.trainingunit.model.TrainingProgram && id!=null">&amp;programId=<s:property value="id" /></s:elseif></s:push>"
		onclick="javascript: return confirm('Are you sure you want to remove this funding?');">[ X ]</a>
		</security:authorize>
	</span>
</span>
<iita:inlineeditor id="fundingeditform" targetId="fundingEdit_${id}">
					<s:include value="/WEB-INF/jsp/funding/update-form.jsp" />
			</iita:inlineeditor>