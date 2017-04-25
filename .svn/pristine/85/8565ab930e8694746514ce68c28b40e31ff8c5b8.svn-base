<%@ include file="/common/taglibs.jsp"%>
<span class="alert quick">
	<h4><s:if test="trainee.person.fullName!=null"><s:property value="trainee.person.fullName" />: </s:if><s:elseif test="group.title!=null"><s:property value="group.title" />: </s:elseif><s:property value="subject" /></h4>
		<s:if test="alertDate != null">
			Alert Date: <s:property value="alertDate" />
		</s:if>
		<s:if test="type != null">
			, Type: <s:property value="type" />
		</s:if>
		<s:if test="status != null">
			, Status: <s:property value="status" />
		</s:if>
	<s:if test="body != null">
		<div><s:property value="body" /></div><br/>
	</s:if>
</span>