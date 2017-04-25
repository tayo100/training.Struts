<%@ include file="/common/taglibs.jsp"%>
<s:if test="paged.totalHits > 0">
	<table class="data-listing">
		<colgroup>
			<col width="2%" />
			<col />
			<col width="13%" />
			<col width="7%" />
		</colgroup>
		<thead>
			<tr>
				<td>#</td>
				<td>Title</td>
				<td>ShortName</td>
				<td>Last Updated</td>
			</tr>
		</thead>
		<s:iterator value="paged.results" status="status">
			<tr>
				<td><s:property value="#status.count + paged.startAt" /></td>
				<td><a href="<s:url action="partner/profile" />?id=<s:property value="id" />"><s:property value="title" /></a></td>
				<td><s:if test="shortName!=null"><s:property value="shortName" /></s:if></td>
				<td><s:date format="%{getText('date.format')}" name="lastUpdated" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
	<p>No records available for partner.</p>
</s:else>