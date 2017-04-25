<%@ include file="/common/taglibs.jsp"%>
<s:if test="scope == null">
	<s:if test="traineeYears.size > 0">
		<div class="yearselect">
		<h3>Trainees by year:</h3> 
		<p><s:iterator value="traineeYears">
			<s:if test="top==year">
				<a style="font-weight: bold;" class="active" href="searchyear.jspx?scope=trainee&year=<s:property />"><s:property /></a>
			</s:if>
			<s:else>
				<a href="searchyear.jspx?scope=trainee&year=<s:property />"><s:property /></a>
			</s:else>
		</s:iterator></p>
		</div>
	</s:if>
	
	<s:if test="trainingProgramYears.size > 0">
		<div class="yearselect">
		<h3>Training Programs by year:</h3> 
		<p><s:iterator value="trainingProgramYears">
			<s:if test="top==year">
				<a style="font-weight: bold;" class="active" href="searchyear.jspx?scope=trainingprogram&year=<s:property />"><s:property /></a>
			</s:if>
			<s:else>
				<a href="searchyear.jspx?scope=trainingprogram&year=<s:property />"><s:property /></a>
			</s:else>
		</s:iterator></p>
		</div>
	</s:if>
</s:if>
<s:elseif test="scope == 'trainee'">
	<div class="yearselect">
		<p><strong>Trainees by year:</strong> 
		<s:iterator value="traineeYears">
			<s:if test="top==year">
				<a style="font-weight: bold;" class="active" href="searchyear.jspx?scope=trainee&year=<s:property />"><s:property /></a>
			</s:if>
			<s:else>
				<a href="searchyear.jspx?scope=trainee&year=<s:property />"><s:property /></a>
			</s:else>
		</s:iterator></p>
	</div>
</s:elseif>
<s:elseif test="scope == 'trainingprogram'">
	<div class="yearselect">
		<p><strong>Training Programs by year:</strong> 
		<s:iterator value="trainingProgramYears">
			<s:if test="top==year">
				<a style="font-weight: bold;" class="active" href="searchyear.jspx?scope=trainingprogram&year=<s:property />"><s:property /></a>
			</s:if>
			<s:else>
				<a href="searchyear.jspx?scope=trainingprogram&year=<s:property />"><s:property /></a>
			</s:else>
		</s:iterator></p>
	</div>
</s:elseif>