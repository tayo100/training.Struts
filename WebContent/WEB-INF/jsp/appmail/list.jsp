<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Application emails</title>
</head>
<body>
<s:if test="paged!=null && paged.totalHits>0">
	<s:include value="/WEB-INF/jsp/paging.jsp">
		<s:param name="page" value="paged.page" />
		<s:param name="pages" value="paged.pages" />
		<s:param name="pageSize" value="paged.pageSize" />
		<s:param name="href" value="%{'unit='+unit.id}" />
	</s:include>

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
		<s:iterator value="paged.results">
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
		</s:iterator>
		</tbody>
		</table>		
		</s:if>
		<s:else>
			<p>No emails received in this application.</p>
		</s:else>
</body>
</html>