<%@ include file="/common/taglibs.jsp"%>

<table class="inputform">
	<colgroup>
		<col width="25%" />
		<col />
	</colgroup>
	<tbody>
		<tr class="help">
			<td />
			<td>
			<div class="note">Please attach files relevant to this TA request.</div>
			</td>
		</tr>
		<tr>
			<td>Attachments</td>
			<td><ul>
			<s:iterator value="ta.attachments" status="status">
				<li><a href="<c:url value="/download" />/<s:property value="ta.id" />:<s:property value="id" />/<s:property value="fileName" />"><s:property value="fileName" /></a></li>
			</s:iterator>
			</ul></td>
		</tr>
	</tbody>
</table>
