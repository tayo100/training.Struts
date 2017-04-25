<%@ include file="/common/taglibs.jsp"%>

<h3><s:property value="lastName" />, <s:property value="firstName" /> [<a href="mailto:<s:property value="email" />"><s:property value="email" /></a>]</h3>
<s:if test="ta.traveler.id==id">
<div class="actionMessage">This is the principal traveler.
<s:if test="ta.traveler.user!=null">This TA will be linked to <s:property value="user.fullName" /></s:if>
<s:else>The TA is not linked to IITA staff.</s:else></div>
</s:if>
<table class="data-listing">
	<colgroup>
		<col width="21%" />
		<col width="21%" />
		<col width="14%" />
		<col width="14%" />
		<col width="12%" />
		<col width="18%" />
	</colgroup>
	<thead>
		<tr>
			<td>From</td>
			<td>To</td>
			<td>Departure</td>
			<td>Arrival</td>
			<td>Carrier</td>
			<td>Accommodation</td>
		</tr>
	</thead>
	<s:iterator value="itinerary" status="status">
		<tr>
			<td><s:property value="origin" /></td>
			<td><s:property value="destination" /></td>
			<td><s:property value="departureDate" /></td>
			<td><s:property value="arrivalDate" /></td>
			<td><s:property value="carrier" /> <s:property value="carrierNumber" /></td>
			<td><s:property value="accomodation" /></td>
		</tr>
	</s:iterator>
</table>