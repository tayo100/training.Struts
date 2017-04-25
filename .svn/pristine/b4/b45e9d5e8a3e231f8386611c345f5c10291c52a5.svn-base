<%@ include file="/common/taglibs.jsp"%>
<s:if test="isMimeType('text/plain')">
	<s:push value="content">
		<s:include value="text-plain.jsp" />
	</s:push>
</s:if>
<s:elseif test="isMimeType('text/html')">
	<s:push value="content">
		<s:include value="text-html.jsp" />
	</s:push>
</s:elseif>
<s:elseif test="disposition=='attachment'">
	<s:push value="content">
		<s:include value="attachment.jsp" />
	</s:push>
</s:elseif>
<s:elseif test="isMimeType('multipart/mixed')">
<div style="margin: 20px 0;">
	<s:push value="content">
		<s:iterator value="new int[count]" status="status">
			<s:push value="getBodyPart(#status.index)">
				<s:if test="#status.index==0">
					<%-- First one is body --%>
					<s:include value="mime-part.jsp" />
				</s:if>
				<s:else>
					<s:include value="attachment.jsp" />
				</s:else>
			</s:push>
		</s:iterator>
	</s:push>
</div>
</s:elseif>
<s:elseif test="isMimeType('multipart/alternative')">
<div style="margin: 20px 0;">
	<s:push value="content">
		<s:iterator value="new int[count]" status="status">
			<s:if test="getBodyPart(#status.index).isMimeType('text/plain')">
				<s:push value="getBodyPart(#status.index)">
					<s:include value="mime-part.jsp" />
				</s:push>
			</s:if>
			<s:else>
				<%--<p><s:property value="getBodyPart(#status.index).contentType" /></p>--%>
			</s:else>
		</s:iterator>
	</s:push>
</div>
</s:elseif>

<s:elseif test="isMimeType('multipart/related')">
<div style="margin: 20px 0;">
	<s:push value="content">
		<s:iterator value="new int[count]" status="status">
			<s:push value="getBodyPart(#status.index)">
				<s:include value="mime-part.jsp" />
			</s:push>
		</s:iterator>
	</s:push>
</div>
</s:elseif>
<s:else>
<div style="margin: 20px 0;">
CONTENT TYPE: <s:property value="contentType" /><br />
DISP: <s:property value="disposition" /><br />
Content: <s:property value="content" /><br />
</div>
</s:else>