<%@ include file="/common/taglibs.jsp"%>
<ul>
<s:iterator value="values">
	<li ajaxvalue="<s:property value="id" />"><s:property value="lastName" />, <s:property value="firstName" /></li>
</s:iterator>
</ul>