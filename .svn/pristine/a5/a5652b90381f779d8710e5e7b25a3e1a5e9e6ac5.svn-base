<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Traveler details</title>
</head>
<body>
<p>We will try matching the traveler information with our user database. When this is successful, the Travel Authorization record will be properly attached
to the person traveling.</p>
<s:form method="post" action="guide!confirm">
	<s:hidden name="travelerType" value="%{travelerType}" />
	<s:hidden name="traveler.lastName" value="%{traveler.lastName}" />
	<s:hidden name="traveler.firstName" value="%{traveler.firstName}" />
	<s:hidden name="traveler.email" value="%{traveler.email}" />
	<s:hidden name="traveler.staffId" value="%{traveler.staffId}" />

	<h2>Traveler details</h2>
	<p>Please check traveler information for any incorrect data.</p>
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td><label>Last name:</label></td>
			<td><s:property value="traveler.lastName" /></td>
		</tr>
		<tr>
			<td><label>First name:</label></td>
			<td><s:property value="traveler.firstName" /></td>
		</tr>
		<tr>
			<td><label>E-Mail:</label></td>
			<td><s:property value="traveler.email" /></td>
		</tr>
		<tr>
			<td><label>Staff ID:</label></td>
			<td><s:property value="traveler.staffId" /></td>
		</tr>
	</table>

	<s:if test="traveler.user!=null">
		<p>We have found a matching user in our database. Please cross check if the information is correct.</p>
		<table class="inputform">
			<colgroup>
				<col width="200px" />
				<col />
			</colgroup>
			<tr>
				<td><label>Last name:</label></td>
				<td><s:property value="traveler.user.lastName" /></td>
			</tr>
			<tr>
				<td><label>First name:</label></td>
				<td><s:property value="traveler.user.firstName" /></td>
			</tr>
			<tr>
				<td><label>E-Mail:</label></td>
				<td><s:property value="traveler.user.mail" /></td>
			</tr>
			<tr>
				<td><label>Staff ID:</label></td>
				<td><s:property value="traveler.user.staffId" /></td>
			</tr>
		</table>

		<s:if test="travelerType!=@org.iita.travelauth.action.NewTAAction$TravelerType@ORIGINATOR">
			<p>If traveler and user records match perfectly, press <s:submit value="Information is correct" /></p>
			<p>If you want to edit traveler information to try matching an existing user, press <s:submit value="Edit traveler details" action="guide!edittraveler" />
			</p>
			<p>User and traveler information do not match, and you are <b>sure</b> you entered traveler details correctly, press <s:submit
				value="User information is NOT matching" action="guide!nouser" />. There will be no link between this TA and the staff traveling.</p>
		</s:if>
		<s:else>
			<s:submit value="Continue" />
		</s:else>
	</s:if>
	<s:else>
		<p>If you want to edit traveler information to try matching an existing user, press <s:submit value="Edit traveler details" action="guide!edittraveler" />
		</p>
		<p>No matching user could be found in the system, and you are <b>sure</b> you entered traveler details correctly, press <s:submit
			value="Continue without user" action="guide!nouser" />. There will be no link between this TA and the staff traveling.</p>
	</s:else>
</s:form>
</body>
</html>