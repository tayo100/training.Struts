<%@ include file="/common/taglibs.jsp"%>
<span class="partner small"><a href="<s:url action="partner/profile"/>?id=<s:property value="id" />"><s:property value="title" /></a> <s:if
	test="shortName!=null">(<s:property value="shortName" />)</s:if></span>