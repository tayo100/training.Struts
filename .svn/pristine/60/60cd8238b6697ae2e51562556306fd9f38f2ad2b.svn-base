<%@ include file="/common/taglibs.jsp"%>

<s:form action="tag/update" method="post">
<h2>Update Tag</h2>
	<s:push value="profile">
	<s:if test="top instanceof org.iita.trainingunit.model.Trainee && id!=null">
		<s:hidden name="traineeId" value="%{id}" />
	</s:if>
	<s:elseif test="top instanceof org.iita.trainingunit.model.TrainingProgram && id!=null">
		<s:hidden name="programId" value="%{id}" />
	</s:elseif>
	</s:push>
	<s:hidden name="tagId" value="%{id}" />
	<table class="inputform">
		<colgroup>
			<col width="15%" />
			<col />
		</colgroup>
		<tr>
			<td>Description:</td><td><s:textfield name="tag" value="%{tag}" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Update Tag" /></td>
		</tr>
	</table>
</s:form>