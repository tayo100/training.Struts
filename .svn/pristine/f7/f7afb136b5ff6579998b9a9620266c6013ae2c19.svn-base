<%@ include file="/common/taglibs.jsp"%>


<tr>
	<td>Last name:</td>
	<td><s:hidden name="version" value="" /><s:textfield name="lastName"
		value="" /></td>
</tr>
<tr>
	<td>First name:</td>
	<td><s:textfield name="firstName" value="" /></td>
</tr>
<tr>
	<td>E-mail:</td>
	<td><s:textfield name="email" value="" /></td>
</tr>
<s:url namespace="/ajax" action="protected" id="autocompleteCity" />
<tr>
	<td />
	<td>
	<table class="data-listing">
		<thead>
			<tr>
				<td>Traveling From</td>
				<td>Traveling To</td>
				<td>Departure Date</td>
				<td>Arrival Date</td>
				<td>Carrier</td>
				<td>Carrier No.</td>
				<td>Accommodation</td>
			</tr>
		</thead>
		<tr>
			<td><s:textfield name="origin" value="" /></td>
			<td><s:textfield name="destination" value="" /></td>
			<td><iita:datepicker name="departureDate" value="" /></td>
			<td><iita:datepicker name="arrivalDate" value="" /></td>
			<td><s:textfield name="carrier" value="" /></td>
			<td><s:textfield name="carrierNumber" value="" /></td>
			<td><s:textfield name="accomodation" value="" /></td>
		</tr>
		<tr>
			<td><a onclick="copyBudget($($(this).parentNode.parentNode).previous(), 3, 1); return false;">More +</a></td>
			</tr>
		</table>
</td>
</tr>