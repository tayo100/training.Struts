<h2>Supervisor</h2>
<ul class="merge-supervisor">
<s:iterator value="getSupervisors(top)">
<li><div class="merge-info">
	<s:iterator value="supervisors">
	<s:if test="person.id==[2].id">
	<s:hidden name="%{#entityPosition}.preserveClass" value="%{class.name}" />
	<s:hidden name="%{#entityPosition}.preserveId" value="%{id}" />
	</s:if>
	</s:iterator>
	<%@include file="/WEB-INF/jsp/trainee/quickinfo-other.jsp" %>
	<%@include file="merge-tools.jsp" %>
</div></li>
</s:iterator>
</ul>