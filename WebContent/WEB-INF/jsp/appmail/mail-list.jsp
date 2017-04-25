<%@ include file="/common/taglibs.jsp"%>
<%-- This to be included when you have a class that has .message as property --%>

<table class="data-listing">
	<colgroup>
		<col width="200" />
		<col />
		<col width="200" />
	</colgroup>
	<thead>
		<tr>
			<td>Sender</td>
			<td class="identifying">Subject</td>
			<td>Date</td>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="top">
			<s:push value="message">
				<tr>
					<td><s:iterator value="message.from">
						<span><s:if test="personal!=null">
							<s:property value="personal" />
						</s:if><s:else>
							<s:property value="address" />
						</s:else></span>
					</s:iterator></td>
					<td class="identifying"><a href="<s:url action="appmail/mail" />?id=<s:property value="id" />"><s:property value="message.subject" /></a></td>
					<td><iita:date name="createdDate" format="dd/MM/yyyy HH:mm" /></td>
				</tr>
			</s:push>
		</s:iterator>
	</tbody>
</table>
