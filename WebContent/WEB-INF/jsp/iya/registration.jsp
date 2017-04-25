<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>IYA Registration form</title>
</head>
<s:form namespace="/iya" action="save-registration" method="post">
	<s:if test="id!=null">
		<s:hidden name="registration.id" value="%{id}" />
	</s:if>
	<table class="inputform">
		<colgroup>
			<col width="10%" />
			<col width="30%" />
			<col />
		</colgroup>
		<tr>
			<td>Trainee Name:</td>
			<!--<td><s:textfield name="firstName" value="%{firstName}" /></td>
			-->
			<td><s:url namespace="/ajax" action="public-ajax" id="xx" /> 
				<iita:autocompleter cssClass="person" name="personId" id="person.id" 
				listKey="id" listValue="fullName" url="%{xx}" method="autocompletePerson" 					
				value="%{registration.person.id}" displayValue="%{registration.person.fullname}" />
			</td>
		</tr>
		<tr>
			<td>Training Registering For:</td>
			<td><s:url namespace="/ajax" action="public-ajax" id="xxx" /> 
				<iita:autocompleter cssClass="" name="announcementId" id="announcement.id" listKey="id"
				listValue="trainingCourse" url="%{xxx}" method="autocompleteIyaAnnouncement" value="%{registration.iyaTrainingAnnouncement.id}"
				 displayValue="%{registration.iyaTrainingAnnouncement.trainingCourse}"/>
			</td>			
		</tr>		
		<tr>
			<td></td>
			<td><s:submit value="Submit" /></td>
		</tr>
	</table>	
</s:form>