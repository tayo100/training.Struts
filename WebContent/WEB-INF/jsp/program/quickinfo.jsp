<%@ include file="/common/taglibs.jsp"%>
<div class="program quick <s:if test="expired">expired</s:if>">
<h3><a href="<s:url action="program/profile"/>?id=<s:property value="id" />"><s:property value="title" /></a></h3>
<div><s:date name="startDate" format="dd/MM/yyyy" /> - <s:date name="endDate" format="dd/MM/yyyy" /></div>
<div><iita:text value="description" maxLength="100" /></div>
<s:if test="expired">
	<div><b>This training program finished <s:date name="endDate" nice="true" />.</b></div>
</s:if>
<div>
	<ul>
		<s:iterator value="trainers">
			<li><s:include value="/WEB-INF/jsp/trainer/program-quickinfo.jsp" /></li>
		</s:iterator>
	</ul>
</div>
</div>