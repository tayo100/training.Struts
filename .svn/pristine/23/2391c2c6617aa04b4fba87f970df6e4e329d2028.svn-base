<%@ include file="/common/taglibs.jsp"%>

<s:form action="" method="post">
	<s:hidden name="type" value="org.iita.trainingunit.model.IYARegistration" />
	<table class="inputform">
		<colgroup>
			<col width="20%" />
			<col width="30%" />
			<col />
		</colgroup>
		<tr>
			<td>Mastery of Subject:</td>
			<td><s:radio name="iyaevaluation.subjectmastery" list="#{'1':'Very Well','2':'Average', '3':'Not Really'}" value="1" /></td>
		</tr>
		<tr>
			<td>Objectives Met:</td>			
			<td><s:checkboxlist list="objectivesMet" name="iyaevaluation.objectivesMet" value="" /></td>
		</tr>
		<tr>
			<td>Was Course Delivered Within Alloted Time?:</td>
			<td><s:radio name="iyaevaluation.courseDelivery" list="#{'1':'Yes','2':'No'}" value="1" /></td>
		</tr>
		<tr>
			<td>Classroom Interaction:</td>
			<td>
			<s:checkboxlist name="iyaevaluation.classInteraction" list="@org.iita.trainingunit.model$InteractionType@values()" value="%{selectedClassInteractions}" listValue="%{getText('iya.classinteraction.'+toString())}" />			
		</td>
		</tr>
		<tr>
			<td>Program Duration:</td>
			<td><<s:radio name="iyaevaluation.programDuration" list="#{'1':'Yes','2':'No'}" value="1" /></td>
		</tr>
			
		<tr>
			<td></td>
			<td><s:submit value="Submit" /></td>
		</tr>
	</table>
</s:form>