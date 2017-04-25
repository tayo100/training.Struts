<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Selected records</title>
</head>
<body>

<s:if test="trainees.size > 0">
	<div style="margin: 5px 0px 20px 5px; background-color: rgb(239, 239, 239);">
		<s:form method="POST" namespace="/selection">
			<s:submit action="index!clearAllTrainees" value="Clear Trainees selection" theme="simple" />
		</s:form>
		<s:form method="get" namespace="/selection">
			<s:submit action="index!exportTrainee" value="Export to Excel" theme="simple" />
		</s:form>
		<span style="margin-left: 100px;">Trainees in selection: <b><s:property value="selectionService.selectedList.selectedTrainees.size" /></b></span>
	</div>
	<%@ include file="/WEB-INF/jsp/include/trainees-listing-full.jsp"%>
</s:if>

<s:if test="trainingPrograms.size > 0">
	<div style="margin: 5px 0px 20px 5px; background-color: rgb(239, 239, 239);">
		<s:form method="POST" namespace="/selection">
			<s:submit action="index!clearAllTrainingPrograms" value="Clear Group Training selection" theme="simple" />
		</s:form>
		<s:form method="get" namespace="/selection">
			<s:submit action="index!exportGroup" value="Export to Excel" theme="simple" />
		</s:form>
		<span style="margin-left: 100px;">Group Training in selection: <b><s:property value="selectionService.selectedList.selectedTrainingPrograms.size" /></b></span>
	</div>
	<%@ include file="/WEB-INF/jsp/include/trainingprogram-listing-full.jsp"%>
</s:if>

<s:if test="trainees==null && trainingPrograms==null">
	<p>There are no records in your selection list.</p>
</s:if>

</body>
</html>