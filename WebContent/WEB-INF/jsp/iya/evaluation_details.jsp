<%@ include file="/common/taglibs.jsp"%>
<head>
<title>IYA Evaluation form</title>
</head>
<a class="btn btn-primary" href="<s:url namespace="/iya" action="evaluation/edit" />?id=<s:property value="id" />">Edit evaluation</a>
<a class="btn btn-primary" href="<s:url namespace="/iya" action="evaluations" />">All Evaluations</a>
<table class="table">
	<colgroup>
		<col width="200px" />
		<col />
	</colgroup>
	<tr>
		<td>Mastery of Subject:</td>
		<td><s:property value="evaluation.subjectMastery" /></td>
	</tr>
	<tr>
		<td>Course Delivered Timely?:</td>
		<td><s:property value="evaluation.courseDelivery" /></td>
	</tr>
	<tr>
		<td>Classroom Interaction:</td>
		<td>
			<s:property value="evaluation.classInteraction" />
		</td>
	<tr>
		<td>Objectives Met?:</td>
		<td><s:property value="evaluation.objectivesMet" /></td>
	</tr>
</table>