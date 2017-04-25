<%@ include file="/common/taglibs.jsp"%>
<head>
<title>IYA - Update Registration</title>
</head>
<s:form namespace="/iya" action="save-registration" method="post">
	<s:hidden name="registration.version" value="%{registration.version}" />
	<s:if test="id!=null">
		<s:hidden name="id" value="%{id}" />
	</s:if>
	<s:hidden name="type" value="org.iita.trainingunit.model.IYARegistration" />
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
			<col />
		</colgroup>
		<tr>
			<td>Trainee Name:</td>
			<td><s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter
				cssClass="person" name="personId" id="person.id" listKey="id"
				listValue="fullName" url="%{xx}" method="autocompletePerson"	
				value="%{registration.person.id}"			
				displayValue="%{registration.person.fullName}" /></td>
		</tr>		

		<tr>
			<td>Training Registering For:</td>
			<td><s:url namespace="/ajax" action="public-ajax" id="xxx" /> <iita:autocompleter
				cssClass="" name="announcementId" id="iyaannouncement.id"
				listKey="id" listValue="trainingCourse" url="%{xxx}"
				method="autocompleteIyaAnnouncement"
				value="%{registration.iyaTrainingAnnouncement.id}"
				displayValue="%{registration.iyaTrainingAnnouncement.trainingCourse}" />
			</td>
		</tr>

		<tr>
			<td></td>
			<td><s:submit value="Update" cssClass="btn btn-warning"
				onclick="javascript: return confirm('Are you sure you want to update this record?');" /></td>
		</tr>
	</table>
</s:form>