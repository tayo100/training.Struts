<%@ include file="/common/taglibs.jsp"%>
<tr>
	<td>Core Competencies</td>
	<td><s:select name="internalApprovals.coreCompetencies[%{compIndex}].name" list="#{'Natural Resource Management':'Natural Resource Management'
			,'Biotech & Plant Breeding':'Biotech & Plant Breeding'
			,'Social Science & Agribusiness':'Social Science & Agribusiness'
			,'Plant Production & Health':'Plant Production & Health'}" emptyOption="true" value="%{name}" />
	</td>
</tr>	