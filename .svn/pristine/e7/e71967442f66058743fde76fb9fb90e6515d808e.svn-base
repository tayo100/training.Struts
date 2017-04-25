<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Edit traveler</title>
</head>
<body>
<h2>Edit traveler information</h2>
<p>Please provide all the details of the person traveling. If there is cash advances included, IITA staff ID is required.</p>

<s:form method="post" action="guide!traveler">
	<s:hidden name="travelerType" value="%{travelerType}" />
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td><label>Last name:</label></td>
			<td><s:textfield name="traveler.lastName" value="%{traveler.lastName}" /></td>
		</tr>
		<tr>
			<td><label>First name:</label></td>
			<td><s:textfield name="traveler.firstName" value="%{traveler.firstName}" /></td>
		</tr>
		<tr class="help">
			<td />
			<td>
			<div class="note">Please use official IITA e-mail address.</div>
			</td>
		</tr>
		<tr>
			<td><label>E-mail address:</label></td>
			<td><s:textfield name="traveler.email" value="%{traveler.email}" /></td>
		</tr>
		<tr class="help">
			<td />
			<td>
			<div class="note">When requesting for <b>cash advance</b> the Staff ID is required. Please use the correct format (<b>E-zero-number</b>)!</div>
			</td>
		</tr>
		<tr>
			<td><label>Staff ID:</label></td>
			<td><s:textfield name="traveler.staffId" value="%{traveler.staffId=='' ? 'E0' : traveler.staffId}" /></td>
		</tr>
	</table>
	<s:submit value="Continue" />
</s:form>
</body>
</html>