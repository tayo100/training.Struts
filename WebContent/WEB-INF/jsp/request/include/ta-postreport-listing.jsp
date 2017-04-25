<%@ include file="/common/taglibs.jsp"%>

<table class="data-listing">
	<colgroup>
		<col width="25px" />
		<col />
	</colgroup>
	<thead>
		<tr>
			<td>#</td>
			<td>Travel plan title</td>
		</tr>
	</thead>
	<tbody>
	<s:iterator value="postReportAlert" status="status">
		<tr>
			<td><s:property value="#status.count" /></td>
			<td>
			<s:if test="ta.taReport!=null">
			[<a href="<s:url action="postreport/form" />?id=<s:property value="ta.taReport.id" />&taId=<s:property value="ta.id" />">Edit</a>] <a href="<s:url action="view" />?id=<s:property value="id" />"><s:if test="title==null || title==''">[Not titled]</s:if><s:else><s:property value="title" /></s:else></a>
			</s:if><s:else>
			<b><a href="<s:url action="view" />?id=<s:property value="id" />"><s:if test="title==null || title==''">[Not titled]</s:if><s:else><s:property value="title" /></s:else></a></b>
			</s:else>
			</td>
		</tr>
	</s:iterator>
	<s:if test="postReportAlert == null ">
	<tr>
			<td colspan="2">No pending Post-report found!</td></tr>
	</s:if>
	</tbody>
</table>