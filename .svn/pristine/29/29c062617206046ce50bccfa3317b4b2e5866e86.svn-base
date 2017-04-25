<%@ include file="/common/taglibs.jsp"%>

<table class="data-listing">
	<colgroup>
		<col width="50%" />
		<col />
	</colgroup>
	<thead>
		<tr>
			<td>Who</td>
			<td>When</td>
		</tr>
	</thead>
	<tbody>
	<s:iterator value="taAway" status="status">
		<tr class="ht">
			<td><a href="<s:url action="view-travel" />?user=<s:property value="owner.id" />"><s:property value="traveler.fullName" /></a></td>
			<td><a href="<s:url action="view" />?id=<s:property value="id" />"><s:date format="dd/MM/yyyy" name="startDate" /> - <s:date format="dd/MM/yyyy" name="endDate" /></a></td>
		</tr>
	</s:iterator>
	<s:if test="taAway.size <= 0 ">
	<tr>
			<td colspan="2">No traveler on any approved trips found!</td></tr>
	</s:if>
	</tbody>
</table>