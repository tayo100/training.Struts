<%@ include file="/common/taglibs.jsp"%>
<html lang="en">
<head>
    <title>Training Registration</title>
</head>
<body>
<p>Choose new password to use a custom password to login to this application.</p>
	<s:form action="password-update!updatePassword" method="post">
		<table class="inputform">
			<colgroup>
				<col width="200" />
				<col />
			</colgroup>
			<tr>
				<td>Current Password:</td>
				<td><s:password name="oldPassword" value="%{oldPassword}" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><s:password name="newPassword" value="%{newPassword}" /></td>
			</tr>
			<tr>
				<td>Retype Password:</td>
				<td><s:password name="confirmPassword" value="%{confirmPassword}" /></td>
			</tr>
			<tr>
				<td></td>
				<td><s:submit value="Update Password" onclick="javascript: return confirm('Update password anyway?');" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>