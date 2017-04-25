<%@ include file="/common/taglibs.jsp"%>

<s:if test="ta.status==@org.iita.travelauth.model.TaStatus@NEW">
	<div class="actionMessage">This Travel Authorization form has not been submitted for approval yet. In order to submit this request, click the <b>Preview</b>
	button below and then <b>File TA</b> on the next screen.</div>
</s:if>
<s:if test="ta.status==@org.iita.travelauth.model.TaStatus@REJECTED">
	<div class="actionMessage">This Travel Authorization request has been rejected. See the <b><a href="#action-log">Action log</a></b> below for details. You need to review the TA
	and re-submit or cancel the request.</div>
</s:if>
