<%@ include file="/common/taglibs.jsp"%>

<s:form method="post" action="program/profile!update">
	<s:hidden name="id" value="%{profile.id}" />
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td><label>Title:</label></td>
			<td><s:textfield name="profile.title" value="%{profile.title}" /></td>
		</tr>
		<tr>
			<td><label>Type:</label></td>
			<td><s:select name="profile.status" emptyOption="true" list="@org.iita.trainingunit.model.TrainingProgram$ProgramType@values()" listValue="%{getText('trainingprogram.type.' + toString())}" /></td>
		</tr>
		<tr>
			<td><label>Description:</label></td>
			<td><s:textarea cssClass="sizable-textarea" name="profile.description" value="%{profile.description}" /></td>
		</tr>
		<!-- 
		<tr>
			<td>Program:</td>
			<td><s:select name="profile.program" list="#{'Agro-biodiversity':'Agro-biodiversity','Banana and Plantains Systems':'Banana and Plantains Systems'
			,'Cereals and Legumes Systems':'Cereals and Legumes Systems','Horticulture and Tree Crop Systems':'Horticulture and Tree Crop Systems'
			,'Opportunities and Threats':'Opportunities and Threats','Roots and Tubers Systems':'Roots and Tubers Systems'
			,'System-wide Propram on IPM':'System-wide Propram on IPM','Agriculture and Health':'Agriculture and Health'
			,'N/A':'N/A'}" value="%{profile.program}" emptyOption="true" />
			</td>
		</tr> -->
		<tr>
			<td><label>Female participants:</label></td>
			<td><s:textfield name="profile.femaleParticipants" cssClass="numeric-input" value="%{profile.femaleParticipants}" /></td>
		</tr>
		<tr>
			<td><label>Male participants:</label></td>
			<td><s:textfield name="profile.maleParticipants" cssClass="numeric-input" value="%{profile.maleParticipants}" /></td>
		</tr>
		<tr>
			<td><label>Start date:</label></td>
			<td><iita:datepicker name="profile.startDate" value="%{profile.startDate}" format="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<td><label>End date:</label></td>
			<td><iita:datepicker name="profile.endDate" value="%{profile.endDate}" format="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<td><label>Location:</label></td>
			<td><s:textfield name="profile.location" value="%{profile.location}" /></td>
		</tr>
		<tr>
			<td>Longitude:</td>
			<td><s:textfield name="profile.longitude" value="%{profile.longitude}" /></td>
		</tr>
		<tr>
			<td>Latitude:</td>
			<td><s:textfield name="profile.latitude" value="%{profile.latitude}" /></td>
		</tr>
		<tr>
			<td><label>Country:</label></td>
			<td><s:textfield name="profile.country" value="%{profile.country}" /></td>
		</tr>
		<tr>
			<td><label>Purpose:</label></td>
			<td><s:textarea cssClass="sizable-textarea" name="profile.purpose" value="%{profile.purpose}" /></td>
		</tr>
		<tr>
			<td><label>Outcomes:</label></td>
			<td><s:textarea cssClass="sizable-textarea" name="profile.outcomes" value="%{profile.outcomes}" /></td>
		</tr>
		<tr>
			<td><label>Crps:</label></td>
			<td><s:select name="crps" list="#{'CRP 1.2 Humid':'CRP 1.2 Humid'
			,'CRP 3.2 Maize':'CRP 3.2 Maize'
			,'CRP 3.4 RTB':'CRP 3.4 RTB'
			,'CRP 3.5 Cereal Legumes':'CRP 3.5 Cereal Legumes'
			,'CRP 4 A4NH':'CRP 4 A4NH'
			,'CRP 5 WLE':'CRP 5 WLE'
			,'CRP 7 CCAFS':'CRP 7 CCAFS'
			,'CRP Genebank':'CRP Genebank'
			,'IITA Strategic':'IITA Strategic'
			}" value="%{selectedCrps}" multiple="true" />
			</td>
		</tr>
		<tr>
			<td><label>Hubs:</label></td>
			<td><s:select name="hubs" list="#{'Western Africa':'Western Africa','Eastern Africa':'Eastern Africa',
			'Central Africa':'Central Africa','Southern Africa':'Southern Africa'}" value="%{selectedHubs}" multiple="true" />
			</td>
		</tr>
		<tr>
			<td><label>Core Competencies:</label></td>
			<td><s:select name="coreCompetencies" list="#{'Natural Resource Management':'Natural Resource Management'
			,'Biotech & Plant Breeding':'Biotech & Plant Breeding'
			,'Social Science & Agribusiness':'Social Science & Agribusiness'
			,'Plant Production & Health':'Plant Production & Health'}" value="%{selectedCoreCompetencies}" multiple="true" />
			</td>
		</tr>
		<tr>
			<td><label>Keywords:</label></td>
			<td><s:textfield name="profile.keywords" value="%{profile.keywords}" /></td>
		</tr>
		<tr>
			<td />
			<td><s:submit value="Update" /></td>
		</tr>
	</table>
</s:form>