<%@ include file="/common/taglibs.jsp"%>

<s:include value="report.jsp" />

<s:include value="ta-head.jsp" />

<h2>Travelers</h2>
<s:iterator value="ta.travelers" status="status">
	<s:include value="/WEB-INF/jsp/request/include/ta-travelers.jsp" />
</s:iterator>

<s:include value="/WEB-INF/jsp/request/include/ta-actionlog.jsp" />