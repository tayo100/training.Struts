<%@ include file="/common/taglibs.jsp"%>
<s:if test="scope == null">
	<s:if test="activityYears.size > 0">
		<div class="yearselect">
		<h3>Activities by year:</h3> 
		<p><s:iterator value="activityYears">
			<s:if test="top==year">
				<a style="font-weight: bold;" class="active" href="yearlyactivities.jspx?year=<s:property />"><s:property /></a>
			</s:if>
			<s:else>
				<a href="yearlyactivities.jspx?year=<s:property />"><s:property /></a>
			</s:else>
		</s:iterator></p>
		</div>
	</s:if>
</s:if>