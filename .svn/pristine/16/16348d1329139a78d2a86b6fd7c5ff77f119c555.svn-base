<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Merge data</title>
</head>
<body>
<h1>Merge data</h1>
<s:if test="left.id==null || right.id==null">
	<div class="actionMessage">Please select <b>left</b> and <b>right</b> entities.</div>
	<%@include file="select.jsp" %>
</s:if>
<s:else>
	<div class="actionMessage">Please merge entities by moving data <b>left</b> and <b>right</b>.</div>
	<s:form method="post" action="merge!merge">
		<s:hidden name="left.id" value="%{left.id}" />
		<s:hidden name="left.className" value="%{left.className}" />
		<s:hidden name="right.id" value="%{right.id}" />
		<s:hidden name="right.className" value="%{right.className}" />
		<table>
			<colgroup>
				<col width="50%" />
				<col width="50%" />
			</colgroup>
			<tr>
				<td id="left-entity" style="padding-right: 10px"><!-- LEFT ENTITY -->
				<s:set name="entityPosition" value="%{'left'}" />
				<s:push value="left.entity">
					<%@ include file="entity.jsp" %>
				</s:push>
				</td>
				<td id="right-entity" style="padding-left: 10px"><!-- RIGHT ENTITY -->
				<s:set name="entityPosition" value="%{'right'}" />
				<s:push value="right.entity">
					<%@ include file="entity.jsp" %>
				</s:push>
				</td>
			</tr>
		</table>
		<div class="button-bar"><s:submit value="Apply changes" /></div>
	</s:form>
	<script type="text/javascript">
	<%@ include file="merge.js" %>
	</script>
</s:else>
</body>
</html>