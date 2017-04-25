<%@ include file="/common/taglibs.jsp"%>
<s:if test="email.length()>0">
<span class="contact email <s:if test="!active">inactive</s:if>"><a href="mailto:<s:property value="email" />"><s:property value="email" /></a></span>
</s:if>