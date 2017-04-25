
<table>
	<colgroup>
		<col width="50%" />
		<col width="50%" />
	</colgroup>
	<tr>
		<td><!-- LEFT ENTITY --> <s:if test="left.entity==null">
		<p>Person:
			<s:form method="post" action="merge">
				<s:hidden name="left.className" value="org.iita.crm.model.Person" />
				<s:hidden name="right.className" value="%{right.className}" />
				<s:hidden name="right.id" value="%{right.id}" />
				<s:url namespace="/ajax" action="public-ajax" id="xx" />
				<iita:autocompleter cssClass="person" name="left.id" id="left.person" listKey="id" listValue="fullName" url="%{xx}" method="autocompletePerson" />
				<s:submit value="Select" />
			</s:form></p>
		<p>Organization:
			<s:form method="post" action="merge">
				<s:hidden name="left.className" value="org.iita.crm.model.Organization" />
				<s:hidden name="right.className" value="%{right.className}" />
				<s:hidden name="right.id" value="%{right.id}" />
				<s:url namespace="/ajax" action="public-ajax" id="xx" />
				<iita:autocompleter cssClass="person" name="left.id" id="left.organization" listKey="id" listValue="fullTitle" url="%{xx}" method="autocompleteOrganization" />
				<s:submit value="Select" />
			</s:form></p>
			
			<!-- Show available options -->
			<s:if test="right.entity!=null">
				<h2>Existing similar values</h2>
				<ul>
				<s:iterator value="getSimilar(right.entity)">
					<li><s:form method="post" action="merge">
					<s:hidden name="left.className" value="%{class.name}" />
					<s:hidden name="right.className" value="%{right.className}" />
					<s:hidden name="right.id" value="%{right.id}" />
					<s:hidden name="left.id" value="%{id}" />
					<s:submit value="Select" />
					<%@include file="quickinfo.jsp" %>
					</s:form></li>
				</s:iterator>
				</ul>
			</s:if>
			
		</s:if> <s:else>
			<s:push value="left.entity">
				<%@include file="quickinfo.jsp" %>
			</s:push>
		</s:else></td>
		<td><!-- RIGHT ENTITY --> <s:if test="right.entity==null">
			<s:form method="post" action="merge">
				<s:hidden name="right.className" value="org.iita.crm.model.Person" />
				<s:hidden name="left.className" value="%{left.className}" />
				<s:hidden name="left.id" value="%{left.id}" />
				<s:url namespace="/ajax" action="public-ajax" id="xx" />
				<iita:autocompleter cssClass="person" name="right.id" id="right.id" listKey="id" listValue="fullName" url="%{xx}" method="autocompletePerson" />
				<s:submit value="Select" />
			</s:form>
			
			<!-- Show available options -->
			<s:if test="left.entity!=null">
				<h2>Existing similar values</h2>
				<ul>
				<s:iterator value="getSimilar(left.entity)">
				<li>				
					<s:form method="post" action="merge">
					<s:hidden name="right.className" value="%{class.name}" />
					<s:hidden name="left.className" value="%{left.className}" />
					<s:hidden name="left.id" value="%{left.id}" />
					<s:hidden name="right.id" value="%{id}" />
					<s:submit value="Select" />
					<%@include file="quickinfo.jsp" %>
					</s:form>
					</li>
				</s:iterator>
				</ul>
			</s:if>
			
		</s:if> <s:else>
			<s:push value="right.entity">
				<%@include file="quickinfo.jsp" %>
			</s:push>
		</s:else></td>
	</tr>
</table>