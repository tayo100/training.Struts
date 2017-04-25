<%@ include file="/common/taglibs.jsp"%>

<s:form action="add-trainee-eduinfo" method="post">
	<s:if test="top instanceof org.iita.crm.model.Person && id!=null">
		<s:hidden name="personId" value="%{id}" />
	</s:if>
	<table class="inputform">
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<s:if test="!(top instanceof org.iita.crm.model.Person && id!=null)">
			<tr>
				<td>Person:</td>
				<td><s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter cssClass="person" name="personId" id="trainee.personId" listKey="id"
					listValue="fullName" url="%{xx}" method="autocompletePerson" /></td>
			</tr>
		</s:if>
		<tr>
			<td>Degree:</td>
			<td><s:textfield name="degree" /></td>
		</tr>
		<!-- 
		<tr>
			<td>Degree Award Date:</td>
			<td><iita:datepicker name="degreeAwardDate" format="dd/MM/yyyy" /></td>
		</tr>
		 -->
		<tr>
			<td>University:</td>
			<td><s:textfield name="university" /></td>
		</tr>
		<tr>
			<td>University Address:</td>
			<td><s:textfield name="universityAddress" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Register trainee educational info" /></td>
		</tr>
	</table>
</s:form>