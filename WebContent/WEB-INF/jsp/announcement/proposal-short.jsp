<%@ include file="/common/taglibs.jsp"%>
<span class="proposal small"><a href="<s:url namespace="/announcement" action="trainingproposal-details"/>?id=<s:property value="id" />"><s:property value="title" /></a> <s:if
	test="type!=null">(<s:property value="type" />)</s:if></span>