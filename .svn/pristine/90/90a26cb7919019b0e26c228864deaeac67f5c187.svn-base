<%@ include file="/common/taglibs.jsp"%>
<hr size="1" />
<div style="float:right;font-size:10px;">CDO-Training Unit Database - Ver. 3(3936:20150223)</div>
<s:action name="user/notification-quick" namespace="/" executeResult="true" ignoreContextParams="true" />

<%-- Render footer notificaiton messages, usually success messages --%>
<s:if test="notificationMessages!=null && notificationMessages.size>0">
	<div id="notificationMessages"><s:iterator value="notificationMessages">
		<div class="notificationMessage"><s:property escape="false" /></div>
	</s:iterator></div>
</s:if>

<div id="ajax-indicator" style="display: none;">
	<b>Please wait...</b> <img src="<c:url value="/img/ajax-ind-1.gif" />" />
</div>