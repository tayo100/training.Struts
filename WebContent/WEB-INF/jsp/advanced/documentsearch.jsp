<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Advanced Training Materials Search</title>

<script type="text/javascript">
	$(document).ready(function(){
		var bucks = {format: 'dd/mm/yyyy',
				autoclose: true,
				todayHighlight: true};
		$('input[name="startDate"]').datepicker(bucks);
		$('input[name="endDate"]').datepicker(bucks);
	});
</script>

</head>
<body>
<s:form method="post" action="advanced/search!query">
	<table class="inputform">
		<colgroup>
			<col width="100" />
			<col width="100" />
			<col />
		</colgroup>
		<tr>
			<td>Scope:</td>
			<td colspan="3"><s:select
				list="#{'Trainings':'Trainings','TrainingMaterials':'Training Materials','Topic':'Topic','Type':'Type','Category':'Category'}"
				name="table" value="%{table}" /></td>
		</tr>
		<tr>
			<td>Criteria:</td>
			<td colspan="3"><s:textfield name="text" value="%{text}" /><br /><s:checkbox name="fullText" id="fullText" fieldValue="true" /> Whole text search <i>(If checked, will search the whole clause at once, else it breaks the clause into individual words)</i></td>
		</tr>
		<tr>
			<td>Start date:</td>
			<td><input name="startDate" type="text"></td>
			<td colspan="2">End date:<input name="endDate" type="text"></td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3"><s:submit value="Search" /> <s:submit value="Download" action="advanced/search!export" /></td>
		</tr>
	</table>
	<br />
</s:form>
<s:include value="/WEB-INF/jsp/include/paged-listing-full.jsp" />
</body>
</html>