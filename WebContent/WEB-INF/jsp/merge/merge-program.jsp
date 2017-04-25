<h2>Trainer</h2>
<ul class="merge-program">
<s:iterator value="getPrograms(top)">
<li><div class="merge-info">
	<s:iterator value="trainers">
	<s:if test="person.id==[2].id">
	<s:hidden name="%{#entityPosition}.preserveClass" value="%{class.name}" />
	<s:hidden name="%{#entityPosition}.preserveId" value="%{id}" />
	</s:if>
	</s:iterator>
	<%@include file="/WEB-INF/jsp/program/short.jsp" %>
	<%@include file="merge-tools.jsp" %>
</div></li>
</s:iterator>
</ul>