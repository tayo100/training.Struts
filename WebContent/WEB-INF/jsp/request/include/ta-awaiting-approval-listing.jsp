<%@ include file="/common/taglibs.jsp"%>

<tr>
	<td><s:property value="#status.count" /></td>
	<td><s:property value="status" /></td>
	<td><s:property value="traveler.fullName" /></td>
	<td class="ar"><s:property value="duration" /></td>
	<td><a href="<s:url action="edit" />?id=<s:property value="id" />"><s:property value="title" /> [<s:property value="funding" />]</a></td>
	<td class="ar"><s:property value="startDate" /></td>
	<td><s:property value="endDate" /></td>
	<td class="ar"><s:property value="totalCost" /></td>
	<td><a href="<s:url action="review/show" />?id=<s:property value="id" />">REVIEW</a></td>
</tr>