<%@ include file="/common/taglibs.jsp"%>

<h3>PREVIOUS TRAININGS AT IITA</h3>
<div>
	<div>
	    <table class="inputform" id="prevTrainingTable">
	    <colgroup>
			<col width="200px" />
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td />
			<td>Training:</td>
			<td>If Yes (State it):</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<s:radio name="cdoNonDegreeApplication.previousTrainings" value="%{cdoNonDegreeApplication.previousTrainings}" 
			list="@org.iita.trainingunit.applications.model.NonDegreeTraining$PreviousIITATrainings@values()" 
			listValue="%{getText('previousTrainings.value.'+toString())}" />
			</td>
			<td><s:textarea name="cdoNonDegreeApplication.trainingReceived" value="%{cdoNonDegreeApplication.trainingReceived}" /></td>
		</tr>
	    </table>
	</div>
</div>