<%@ include file="/common/taglibs.jsp"%>

<s:if test="ta.traveler.id==id">
<tr class="identifying">
	<td>Last name:</td>
	<td><s:property value="%{lastName}" /></td>
</tr>
<tr class="identifying">
	<td>First name:</td>
	<td><s:property  value="%{firstName}" /></td>
</tr>
<tr>
	<td>E-mail:</td>
	<td><s:property value="%{email}" /></td>
</tr>
<tr>
	<td>Staff ID:</td>
	<td><s:property value="%{staffId}" /></td>
</tr>
</s:if>
<s:else>
<tr>
	<td>Last name:</td>
	<td><s:hidden name="ta.travelers[%{travelerIndex}].version" value="%{version}" /><s:textfield name="ta.travelers[%{travelerIndex}].lastName"
		value="%{lastName}" /></td>
</tr>
<tr>
	<td>First name:</td>
	<td><s:textfield name="ta.travelers[%{travelerIndex}].firstName" value="%{firstName}" /></td>
</tr>
<tr>
	<td>E-mail:</td>
	<td><s:textfield name="ta.travelers[%{travelerIndex}].email" value="%{email}" /></td>
</tr>
</s:else>
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
		<s:iterator value="itinerary" status="status">
			<tr>
				<td><s:textfield name="ta.travelers[%{travelerIndex}].itinerary[%{#status.index}].origin" value="%{origin}" /></td>
				<td><s:textfield name="ta.travelers[%{travelerIndex}].itinerary[%{#status.index}].destination" value="%{destination}" /></td>
				<td><iita:datepicker name="ta.travelers[%{travelerIndex}].itinerary[%{#status.index}].departureDate" value="%{departureDate}" /></td>
				<td><iita:datepicker name="ta.travelers[%{travelerIndex}].itinerary[%{#status.index}].arrivalDate" value="%{arrivalDate}" /></td>
				<td><s:textfield name="ta.travelers[%{travelerIndex}].itinerary[%{#status.index}].carrier" value="%{carrier}" /></td>
				<td><s:textfield name="ta.travelers[%{travelerIndex}].itinerary[%{#status.index}].carrierNumber" value="%{carrierNumber}" /></td>
				<td><s:textfield name="ta.travelers[%{travelerIndex}].itinerary[%{#status.index}].accomodation" value="%{accomodation}" /></td>
			</tr>
		</s:iterator>
		<tr>
			<td><s:textfield name="ta.travelers[%{travelerIndex}].itinerary[%{itinerary==null?0:itinerary.size}].origin" value="" /></td>
			<td><s:textfield name="ta.travelers[%{travelerIndex}].itinerary[%{itinerary==null?0:itinerary.size}].destination" value="" /></td>
			<td><iita:datepicker name="ta.travelers[%{travelerIndex}].itinerary[%{itinerary==null?0:itinerary.size}].departureDate" value="" /></td>
			<td><iita:datepicker name="ta.travelers[%{travelerIndex}].itinerary[%{itinerary==null?0:itinerary.size}].arrivalDate" value="" /></td>
			<td><s:textfield name="ta.travelers[%{travelerIndex}].itinerary[%{itinerary==null?0:itinerary.size}].carrier" value="" /></td>
			<td><s:textfield name="ta.travelers[%{travelerIndex}].itinerary[%{itinerary==null?0:itinerary.size}].carrierNumber" value="" /></td>
			<td><s:textfield name="ta.travelers[%{travelerIndex}].itinerary[%{itinerary==null?0:itinerary.size}].accomodation" value="" /></td>
		</tr>
		<tr>
			<td><a onclick="copyBudget($($(this).parentNode.parentNode).previous(), 3, 1); return false;">More +</a></td>
			</tr>
		</table>
</td>
</tr>