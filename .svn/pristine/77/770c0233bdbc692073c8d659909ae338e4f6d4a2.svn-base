<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Search results</title>
</head>
<body>
<div id="foobar">
	Searching for <b><s:property value="queryString" /></b><s:if test="ent!=null && ent!=''"> in <b><s:property value="getText('entity.' + ent)" />s</b></s:if>. Double click here for advanced search.
</div>
<iita:inlineeditor targetId="foobar" id="foobar2">
	<s:form method="post" action="search">
		Search for <s:textfield name="q" value="%{queryString}" /> in 
		<s:select name="ent" list="#{'':'Everything','org.iita.promis.model.Project':'Projects','org.iita.promis.model.Proposal':'Proposal','org.iita.promis.model.ConceptNote':'Concept note', 'org.iita.promis.model.Agreement':'Agreements', 'org.iita.crm.model.Organization':'Organizations', 'org.iita.crm.model.Person':'People', 'org.iita.crm.model.Contact':'Contact', 'org.iita.crm.model.Partner':'Partner'}" value="%{ent}" />
		<s:submit value="Search" />
	</s:form>
</iita:inlineeditor>

<s:if test="paged!=null && paged.pageSize>0">
	<s:push value="paged">
		<s:include value="/WEB-INF/jsp/paging.jsp">
			<s:param name="href" value="%{'q=' + queryString + '&ent=' + ent}" />
		</s:include>
	</s:push>

	<s:iterator value="paged.results">
		<div style="margin: 5px 0px; padding: 5px;">
		<s:if test="top instanceof org.iita.crm.model.Organization">
			<s:include value="/WEB-INF/jsp/organization/quickinfo.jsp" />
		</s:if>
		<s:elseif test="top instanceof org.iita.crm.model.Partner">
			<s:include value="/WEB-INF/jsp/partner/quickinfo.jsp" />
		</s:elseif>
		<s:elseif test="top instanceof org.iita.crm.model.Person">
			<s:include value="/WEB-INF/jsp/person/small.jsp" />
		</s:elseif>
		<s:elseif test="top instanceof org.iita.crm.model.Document">
			<s:include value="/WEB-INF/jsp/document/short.jsp" />
		</s:elseif>
		<s:elseif test="top instanceof org.iita.crm.model.OrganizationDocument">
			<s:include value="/WEB-INF/jsp/organization/document-short.jsp" />
		</s:elseif>
		<s:elseif test="top instanceof org.iita.trainingunit.model.Trainee">
			<s:include value="/WEB-INF/jsp/trainee/small.jsp" />
		</s:elseif>
		<s:elseif test="top instanceof org.iita.trainingunit.model.TrainingProgram">
			<s:include value="/WEB-INF/jsp/program/short.jsp" />
		</s:elseif>
		<s:elseif test="top instanceof org.iita.trainingunit.model.TrainingProposal">
			<s:include value="/WEB-INF/jsp/announcement/proposal-short.jsp" />
		</s:elseif>
		<s:elseif test="top instanceof org.iita.trainingunit.model.Announcement">
			<s:include value="/WEB-INF/jsp/announcement/small.jsp" />
		</s:elseif>
		<s:elseif test="top instanceof org.iita.crm.model.Contact">
			<s:if test="person!=null"><s:push value="person"><s:include value="/WEB-INF/jsp/person/small.jsp" /></s:push></s:if>
			<s:if test="organization!=null"><s:push value="organization"><s:include value="/WEB-INF/jsp/organization/small.jsp" /></s:push></s:if>
			<s:property value="top" />
		</s:elseif>
		<s:else>
			<s:property value="top" /> <s:property value="top.class" />
		</s:else>
		</div>
	</s:iterator>

</s:if>



</body>
</html>