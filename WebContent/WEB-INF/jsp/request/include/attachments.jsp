<%@ include file="/common/taglibs.jsp"%>
<s:if test="ta.attachments.size>0">
	<table class="inputform">
		<colgroup>
			<col width="25%" />
			<col />
		</colgroup>
		<tbody>
			<tr>
				<td>Attachments</td>
				<td>
				<ul class="file-list">
					<s:iterator value="ta.attachments" status="status">
						<li class="file"><a href="<c:url value="/download" />/<s:property value="ta.id" />:<s:property value="id" />/<s:property value="fileName" />"><s:property
							value="fileName" /></a></li>
					</s:iterator>
				</ul>
				</td>
			</tr>
		</tbody>
	</table>
</s:if>
<s:if test="ta.owner.id==user.id">
	<s:include value="attach.jsp" />
</s:if>