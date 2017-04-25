<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Partners data</title>
</head>
<body>
<s:form method="post" action="partner/search!query">
<table class="inputform">
						<colgroup>
							<col width="200px" />
							<col />
							<col />
							<col />
						</colgroup>
						<tr>
							<td><label>Organization:</label></td>
							<td colspan="3"><s:textfield name="org" value="%{org}" /></td>
						</tr>
						<tr>
							<td><label>First/Last name:</label></td>
							<td><s:textfield name="name" value="%{name}" /></td>
							<td align="right"><label>Contact <br /><span style="font-size:10px;">(city, state, country or continent):</span></label></td>
							<td><s:textfield name="contact" value="%{contact}" /></td>
						</tr>
						<tr>
							<td><label>Tag:</label></td>
							<td><s:textfield name="tag" value="%{tag}" /></td>
							<td align="right"><label>Hub:</label></td>
							<td>
								<s:select name="hub" value="%{hub}" list="listHubs" listValue="hub"
								 emptyOption="true" listKey="hub" />
							</td>
						</tr>
						<tr>
							<td><label>Classification:</label></td>
							<td>
							<s:select name="classification" value="%{classification}" list="listClassifications" listValue="type" emptyOption="true" listKey="type" />
							</td>
							<td align="right"><label>Category:</label></td>
							<td>
							<s:select name="category" value="%{category}" list="listCategories" listValue="type" emptyOption="true" listKey="type" />
							</td>
						</tr>
						<tr>
							<td><label>Core Business:</label></td>
							<td>
							<s:select name="coreBusiness" value="%{coreBusiness}" list="listCoreBusinesses" listValue="type" emptyOption="true" listKey="type" />
							</td>
							<td align="right"><label>Mandate Crop:</label></td>
							<td>
							<s:select name="mandateCrop" value="%{mandateCrop}" list="listMandateCrops" listValue="type" emptyOption="true" listKey="type" />
							</td>
						</tr>						
						<tr>
							<td></td>
							<td><s:submit value="Search" /></td>
						</tr>
					</table>
				</s:form>

<s:if test="paged!=null">	
	<s:push value="paged">
		<s:include value="/WEB-INF/jsp/paging.jsp">
			<s:param name="href" value="%{'id=' + [1].query.id}" />
		</s:include>
		<s:if test="report!=null">
			<s:property value="report" escape="false" />
		</s:if>
		<s:else>
			<s:include value="query-results.jsp" />
		</s:else>
	</s:push>
	<s:if test="paged.totalHits > 0">
		<div class="button-bar"><iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER">
			<b><a href="<s:url action="query/edit" />?id=<s:property value="query.id" />">Edit query</a></b>
		</iita:authorize> <a href="<s:url action="query/run!download" />?id=<s:property value="query.id" />">Export to Excel</a></div>
	</s:if>
</s:if>

</body>
</html>