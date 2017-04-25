<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html>
<head>
<title>CDO New Announcement</title>
</head>
<body>
<div class="button-bar">
<a href="<s:url action="cdoindex" />">CDO Announcements</a>
</div>

<s:form action="save" method="post">
<div style="font-style: italic;"><strong>*</strong> means mandatory fields</div>
	<s:hidden name="id" value="%{announcement.id}" />
	<table class="chooseit">
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<td>Type:*</td>
			<td><s:select name="announcement.type" list="#{'Group':'Group'
			,'Graduate':'Graduate'
			,'In-house Group':'In-house Group'
			,'Individual':'Individual'
			,'Staff Development':'Staff Development'
			,'Other':'Other'
			}" value="%{announcement.type}" emptyOption="true" /></td>
		</tr>
	</table>
	<table id="table1" class="hidden">
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<td>Title:*</td>
			<td><s:textfield name="announcement.title" value="%{announcement.title}" /></td>
		</tr>
		<tr>
			<td>Introduction/Background:*</td>
			<td>
			<FCK:editor instanceName="announcement.introduction" height="100">
				<jsp:attribute name="value">${announcement.introduction}</jsp:attribute>
			</FCK:editor>
			</td>
		</tr>
		<tr>
			<td>Target group/participants:</td>
			<td>
			<FCK:editor instanceName="announcement.targetGroup" height="100">
				<jsp:attribute name="value">${announcement.targetGroup}</jsp:attribute>
			</FCK:editor>
			</td>
		</tr>
		<tr>
			<td>Expected No. of participants:</td>
			<td><s:textfield name="announcement.numberOfParticipants" value="%{announcement.numberOfParticipants}" /></td>
		</tr>
		<tr>
			<td>Expected No. of female(s):</td>
			<td><s:textfield name="announcement.numberOfFemale" value="%{announcement.numberOfFemale}" /></td>
		</tr>
		<tr>
			<td>Expected No. of male(s):</td>
			<td><s:textfield name="announcement.numberOfMale" value="%{announcement.numberOfMale}" /></td>
		</tr> 
		<tr>
			<td>Objective:</td>
			<td>
			<FCK:editor instanceName="announcement.objective" height="100">
				<jsp:attribute name="value">${announcement.objective}</jsp:attribute>
			</FCK:editor>
			</td>
		</tr>
		<tr>
			<td>Learning method:</td>
			<td>
			<FCK:editor instanceName="announcement.learningMethod" height="100">
				<jsp:attribute name="value">${announcement.learningMethod}</jsp:attribute>
			</FCK:editor>
			</td>
		</tr>
		<tr>
			<td>Expected outcome:</td>
			<td><FCK:editor instanceName="announcement.expectedOutcome" height="100">
				<jsp:attribute name="value">${announcement.expectedOutcome}</jsp:attribute>
			</FCK:editor>
				</td>
		</tr>
		<tr>
			<td>Course contents:</td>
			<td><FCK:editor instanceName="announcement.courseContents" height="100">
				<jsp:attribute name="value">${announcement.courseContents}</jsp:attribute>
				</FCK:editor>
				</td>
		</tr>
		<tr>
			<td>Duration:</td>
			<td><s:textfield name="announcement.duration" value="%{announcement.duration}" /></td>
		</tr>
		
		<tr>
			<td>Location/Venue:</td>
			<td><s:textfield name="announcement.location" value="%{announcement.location}" /></td>
		</tr>

		<tr>
			<td>Training fee:</td>
			<td><FCK:editor instanceName="announcement.trainingFee" height="100">
				<jsp:attribute name="value">${announcement.trainingFee}</jsp:attribute>
				</FCK:editor>
				</td>
		</tr>
		<tr>
			<td>Accommodation:</td>
			<td><FCK:editor instanceName="announcement.accommodation" height="100">
					<jsp:attribute name="value">${announcement.accommodation}</jsp:attribute>
				</FCK:editor>
					</td>
		</tr>
		<tr>
			<td>Payment:</td>
			<td><FCK:editor instanceName="announcement.payment" height="100">
				<jsp:attribute name="value">${announcement.payment}</jsp:attribute>
				</FCK:editor>
				</td>
		</tr>
		<tr>
			<td>Application deadline:</td>
			<td><iita:datepicker name="announcement.deadline" value="%{announcement.deadline}" format="dd/MM/yyyy" /><s:submit value="Save announcement" /></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
	</table>
</s:form>

<script>
    $('#save_announcement_type').on('change', function () {
        var val = $(this).val();
        console.log(val);
        $('#table1').hide();
        //$('#table2').hide();
        $('#' + val).show();
    });
</script>

</body>
</html>