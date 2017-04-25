<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Search results</title>
</head>
<body>
<s:if test="paged!=null && paged.pageSize>0">
	<s:push value="paged">
		<s:include value="/WEB-INF/jsp/paging.jsp">
			<s:param name="href" value="%{'tag=' + tag}" />
		</s:include>
	</s:push>


	<s:iterator value="paged.results">
		<div style="margin: 5px 0px; padding: 5px;">
			<s:if test="top instanceof org.iita.trainingunit.model.TraineeTag">
				<s:push value="entity">
					<s:include value="/WEB-INF/jsp/trainee/small.jsp" />
					<div style="font-size: 9px; margin: 3px 10px;">
					<s:iterator value="tags">
						<s:include value="/WEB-INF/jsp/tags/tag-readonly.jsp" />
					</s:iterator>
					</div>
				</s:push>
			</s:if>
			<s:elseif test="top instanceof org.iita.trainingunit.model.TrainingProgramTag">
			<s:push value="entity">
				<s:include value="/WEB-INF/jsp/program/short.jsp" />
				<div>
				<s:iterator value="tags">
					<s:include value="/WEB-INF/jsp/tags/tag-readonly.jsp" />
				</s:iterator>
				</div>
			</s:push>

		</s:elseif>		

		<s:elseif test="top instanceof org.iita.crm.model.OrganizationTag">
			<s:push value="entity">
				<s:include value="/WEB-INF/jsp/organization/small.jsp" />
			</s:push>
		</s:elseif>
		
		<s:elseif test="top instanceof org.iita.crm.model.PartnerTag">
			<s:push value="entity">
				<s:include value="/WEB-INF/jsp/partner/small.jsp" />
			</s:push>
		</s:elseif>
		
		<s:elseif test="top instanceof org.iita.crm.model.AnnouncementTag">
			<s:push value="entity">
				<s:include value="/WEB-INF/jsp/announcement/small.jsp" />
			</s:push>
		</s:elseif>
		
		<s:elseif test="top instanceof org.iita.crm.model.ApplicationTag">
			<s:push value="entity">
				<s:include value="/WEB-INF/jsp/application/small.jsp" />
			</s:push>
		</s:elseif>

		<s:else>
			<s:property value="top" /> <s:property value="top.class" />
		</s:else>
		</div>
	</s:iterator>

</s:if>



</body>
</html>