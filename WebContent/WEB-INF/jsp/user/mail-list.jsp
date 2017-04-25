<%@ include file="/common/taglibs.jsp"%>

<s:if test="top!=null && top.totalHits>0">
	<table class="data-listing">
		<colgroup>
			<col width="350" />
			<col />
			<col width="200" />
		</colgroup>
		<thead>
			<tr>
				<td>Recipient</td>
				<td class="identifying">Subject</td>
				<td>Date</td>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="results">
				<tr>
					<td><s:iterator value="mail.message.allRecipients">
						<span><s:if test="personal!=null">
							<s:property value="personal" />
						</s:if><s:else>
							<s:property value="address" />
						</s:else></span>
					</s:iterator></td>
					<td class="identifying"><a href="<s:url action="appmail/mail" />?id=<s:property value="mail.id" />"><s:property value="mail.message.subject" /></a></td>
					<td><iita:date name="createdDate" format="dd/MM/yyyy HH:mm" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</s:if>
<s:else>
	<p>No emails received in this application.</p>
</s:else>
