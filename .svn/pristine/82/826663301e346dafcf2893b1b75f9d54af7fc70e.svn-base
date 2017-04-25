<%@ include file="/common/taglibs.jsp"%>

<s:form action="documentupload" method="POST"
	enctype="multipart/form-data">
	<s:hidden name="id" value="%{cdoBioData.id}" />
	<table class="inputform" align="right">
		<colgroup>
			<col width="100" />
			<col />
		</colgroup>
		<iita:authorize ifAnyGranted="ROLE_CRM">
			<p>Attach document/material to announcement:</p>
			<iita:fileupload action="announcement-document!upload"
				value="Upload files" queryParams="entityId=${announcement.id}" />
		</iita:authorize>
	</table>
</s:form>