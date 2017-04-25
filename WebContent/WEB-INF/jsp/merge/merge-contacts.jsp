<h2>Contacts</h2>
<ul class="merge-contacts">
<s:iterator value="contacts">
<li><div class="merge-info">
	<s:hidden name="%{#entityPosition}.preserveClass" value="%{class.name}" />
	<s:hidden name="%{#entityPosition}.preserveId" value="%{id}" />
	<%@include file="/WEB-INF/jsp/contact/contact.jsp" %>
	<%@include file="merge-tools.jsp" %>
</div></li>
</s:iterator>
</ul>