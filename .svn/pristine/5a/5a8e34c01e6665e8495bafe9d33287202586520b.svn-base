<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Merge data</title>
</head>
<body>
<h1>Merge data</h1>
<s:if test="left.id==null || right.id==null">
	<div class="actionMessage">Please select <b>left</b> and <b>right</b> entities.</div>
	<%@include file="select.jsp"%>
</s:if>
<s:else>
	<div class="actionMessage">Merge all data from right entity to left entity.</div>
	<div class="button-bar">
	<s:form method="post" action="merge">
		<s:hidden name="left.id" value="%{right.id}" />
		<s:hidden name="left.className" value="%{right.className}" />
		<s:hidden name="right.id" value="%{left.id}" />
		<s:hidden name="right.className" value="%{left.className}" />
		<s:submit value="Swap left to right" />
	</s:form>
	</div>
	
	<table>
		<colgroup>
			<col width="50%" />
			<col width="50%" />
		</colgroup>
		<tr>
			<td><s:push value="left.entity">
				<%@include file="auto-entity.jsp" %>
			</s:push></td>
			<td><s:push value="right.entity">
				<%@include file="auto-entity.jsp" %>
			</s:push></td>
		</tr>
	</table>
	<s:form method="post" action="merge!merge">
		<s:hidden name="left.id" value="%{left.id}" />
		<s:hidden name="left.className" value="%{left.className}" />
		<s:hidden name="right.id" value="%{right.id}" />
		<s:hidden name="right.className" value="%{right.className}" />
		<div class="button-bar"><s:submit value="Merge to left" onclick="javascript: return confirm('Are you absolutely sure you want to merge these entities?\nThe process is irreversible.');" /> <b>The right entity will be removed!</b></div>
	</s:form>
</s:else>
</body>
</html>