<%@ include file="/common/taglibs.jsp"%>
<h2>Quick TA</h2>
<s:form id="quick-ta" method="POST" action="savedraft">
	<table class="" style="width: 100%;">
		<colgroup>
			<col width="65%" />
			<col width="35%" />
		</colgroup>
		<tbody>
			<tr>
				<td colspan="2">
				<div>One-line title:</div>
				<s:textfield name="ta.title" value="%{''}" /></td>
			</tr>
			<tr>
				<td colspan="2">
				<div>Purposes and justification of travel:</div>
				<s:textarea name="ta.description" cssStyle="height: 3em;" value="%{''}" /></td>
			</tr>
			<tr>
				<td>
				<div>Estimated total cost (in USD):</div>
				<s:textfield name="ta.totalCost" value="%{''}" cssStyle="width: 80px;" /></td>
				<td>
				<div>Funding source:</div>
				<s:select name="ta.funding" value="%{'INTERNAL'}" list="@org.iita.travelauth.model.Funding@values()" /></td>
			</tr>
			<tr>
				<td colspan="2">
				<div>Budget codes (one per box!):</div>
				<s:textfield name="ta.budgetCodes[0].code" cssStyle="width: 50px" /> <s:textfield name="ta.budgetCodes[1].code" cssStyle="width: 50px" /> <s:textfield name="ta.budgetCodes[2].code" cssStyle="width: 50px" /></td>
			</tr>
			<tr>
				<td colspan="2">
				<table class="data-listing">
					<colgroup>
						<col width="30%" />
						<col width="30%" />
						<col width="20%" />
						<col width="20%" />
					</colgroup>
					<thead>
						<tr>
							<td>From:</td>
							<td>To:</td>
							<td>Depart:</td>
							<td>Arrive:</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><s:textfield cssClass="autocompleted" name="ta.travelers[0].itinerary[0].origin" /></td>
							<td><s:textfield cssClass="autocompleted" name="ta.travelers[0].itinerary[0].destination" /></td>
							<td><s:textfield name="ta.travelers[0].itinerary[0].departureDate" /></td>
							<td><s:textfield name="ta.travelers[0].itinerary[0].arrivalDate" /></td>
						</tr>
						<tr>
							<td><s:textfield cssClass="autocompleted" name="ta.travelers[0].itinerary[1].origin" /></td>
							<td><s:textfield cssClass="autocompleted" name="ta.travelers[0].itinerary[1].destination" /></td>
							<td><s:textfield name="ta.travelers[0].itinerary[1].departureDate" /></td>
							<td><s:textfield name="ta.travelers[0].itinerary[1].arrivalDate" /></td>
						</tr>
						<tr>
							<td><s:textfield cssClass="autocompleted" name="ta.travelers[0].itinerary[2].origin" /></td>
							<td><s:textfield cssClass="autocompleted" name="ta.travelers[0].itinerary[2].destination" /></td>
							<td><s:textfield name="ta.travelers[0].itinerary[2].departureDate" /></td>
							<td><s:textfield name="ta.travelers[0].itinerary[2].arrivalDate" /></td>
						</tr>
						<tr>
							<td><s:textfield cssClass="autocompleted" name="ta.travelers[0].itinerary[3].origin" /></td>
							<td><s:textfield cssClass="autocompleted" name="ta.travelers[0].itinerary[3].destination" /></td>
							<td><s:textfield name="ta.travelers[0].itinerary[3].departureDate" /></td>
							<td><s:textfield name="ta.travelers[0].itinerary[3].arrivalDate" /></td>
						</tr>
					</tbody>
				</table>
				</td>
			</tr>
			<tr>
				<td><s:submit cssStyle="font-size:16;font-weight:Bold;" value="Preview TA" /></td>
			</tr>
		</tbody>
	</table>
</s:form>
<script type="text/javascript" language="javascript" charset="utf-8">
// find all origin and destination fields and make them auto-complete
Event.observe(window, 'load', function() { makeAutoComplete($('quick-ta'), '<s:url namespace="/ajax" action="city" />', 'lookup'); });
</script>