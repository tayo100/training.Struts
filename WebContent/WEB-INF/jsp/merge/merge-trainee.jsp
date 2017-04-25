<h2>Trainee</h2>
<ul class="merge-trainee">
<s:iterator value="getTrainees(top)">
<li><div class="merge-info">
	<s:hidden name="%{#entityPosition}.preserveClass" value="%{class.name}" />
	<s:hidden name="%{#entityPosition}.preserveId" value="%{id}" />
	<%@include file="/WEB-INF/jsp/trainee/quickinfo.jsp" %>
	<%@include file="merge-tools.jsp" %>
</div>
</li>
</s:iterator>
</ul>