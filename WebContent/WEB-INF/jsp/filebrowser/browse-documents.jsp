<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Browsing <s:property value="browserTitle" /> <s:property value="directory" /></title>
</head>
<body>
<table class="data-listing">
	<colgroup>
		<col />
		<col width="150px" />
		<col width="150px" />
	</colgroup>
	<thead>
		<tr>
			<td>Name</td>
			<td class="ar">Size</td>
			<td class="ar">Last modified</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><a href="?id=<s:property value="id" />&directory=<s:property value="directory" />"><i>Refresh</i></a> <s:if
				test="directory!=null && directory.length()>0">
				<a href="?id=<s:property value="id" />"><i>Go to root folder</i></a>
				<a href="?id=<s:property value="id" />&directory=<s:property value="parentDirectory" />"><i>Go to parent folder</i></a>
			</s:if></td>
			<td />
			<td />
		</tr>
		<s:if test="files.size>0">
			<s:set name="totalSize" value="0" />
			<s:iterator value="files">
				<tr class="${file.directory?'directory':'file'}">
					<td><s:if test="file.directory">
						<a href="<s:url action="%{action}" />?id=<s:property value="id" />&directory=<s:property value="directory" />/<s:property value="fileName" />"><s:property
							value="fileName" /></a>
					</s:if> <s:else>
						<a href="<s:url action="%{action}!download" />?id=<s:property value="id" />&directory=<s:property value="directory" />&file=<s:property value="fileName" />">
							<s:property value="fileName" /></a>
					</s:else></td>
					<td class="ar"><s:if test="file.file">
						<iita:disksize value="file.length()" />
						<s:set name="totalSize" value="#totalSize + file.length()" />
					</s:if></td>
					<td class="ar"><iita:date name="new java.util.Date(file.lastModified())" format="dd/MM/yyyy HH:mm" /></td>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="3">No files found.</td>
			</tr>
		</s:else>
	</tbody>
	<tfoot>
		<tr>
			<td>Files: <s:property value="files.size" /></td>
			<td class="ar"><iita:disksize value="#totalSize" /></td>
			<td />
		</tr>
	</tfoot>
</table>
<iita:filedropzone action="%{action}!upload" queryParams="id=${id}&directory=${directory}">
	<p>You can attach files by dragging-and-dropping them right HERE! The <b>copy</b> icon will appear.</p>
</iita:filedropzone>
</body>
</html>