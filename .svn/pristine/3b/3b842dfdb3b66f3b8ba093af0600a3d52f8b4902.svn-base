<%@ include file="/common/taglibs.jsp"%>

<s:hidden name="id" value="%{ta.id}" />
<s:hidden name="ta.version" value="%{ta.version}" />
<table class="inputform">
	<colgroup>
		<col width="240px" />
		<col />
	</colgroup>
	<tbody>
		<tr>
			<td>Status:</td>
			<td><b><s:text name="ta.status.%{ta.status}" /></b></td>
		</tr>
		<tr>
			<td>Originator:</td>
			<td><s:property value="ta.owner.fullName" /> <s:property value="ta.owner.mail" /></td>
		</tr>
		<tr class="help">
			<td />
			<td>
			<div class="note">Principal traveler is the person actually traveling and is responsible for cash advance collection, expense claims and post-trip reporting.</div>
			</td>
		</tr>
		<tr>
			<td>Principal traveler:</td>
			<td><b><s:property value="ta.traveler.lastName" />, <s:property value="ta.traveler.firstName" /></b> <s:property value="ta.traveler.staffId" /></td>
		</tr>
		<tr>
			<td>Link to staff:</td>
			<td><s:if test="ta.traveler.user==null">
				<p style="color: Red;">This TA does not link to an IITA staff!</p>
			</s:if> <s:else>
				<b><s:property value="ta.traveler.user.lastName" />, <s:property value="ta.traveler.user.firstName" /></b>
				<s:property value="ta.traveler.user.staffId" />
				<p>Make sure this is the right person!</p>
			</s:else></td>
		</tr>
		<tr>
			<td>Trip title:*</td>
			<td><s:textfield name="ta.title" value="%{ta.title}" /></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><s:textarea name="ta.description" value="%{ta.description}" /></td>
		</tr>
		<!-- Need to get rid of this! -->
		<tr>
			<td>Trip start date:*</td>
			<td><iita:datepicker name="ta.startDate" value="%{getText('format.date',{ta.startDate})}" /></td>
		</tr>
		<tr>
			<td>Trip end date:*</td>
			<td><iita:datepicker name="ta.endDate" value="%{getText('format.date',{ta.endDate})}" /></td>
		</tr>
		<!-- // Cause it does not make sense! -->
		<tr class="help">
			<td />
			<td>
			<div class="note">Select your <b>director</b> or <b>line manager</b> if applicable.</div>
			</td>
		</tr>
		<tr>
			<td>First approver:*</td>
			<td><s:select name="lineManager" value="%{ta.lineManager.id}" emptyOption="true" list="lineManagers" listKey="id" listValue="%{lastName + ', ' + firstName}" /></td>
		</tr>
		<tr>
			<td>Hub Director/Head approver:*</td>
			<td><s:select name="director" value="%{ta.director.id}" emptyOption="true" list="directors" listKey="id" listValue="%{lastName + ', ' + firstName}" /></td>
		</tr>
	</tbody>
</table>

<table class="inputform">
	<colgroup>
		<col width="240px" />
		<col />
	</colgroup>
	<tr class="help">
		<td />
		<td>
		<div class="note">Specify <b>estimated</b> total cost of the travel itinerary including shuttle, taxi, IGH charges, etc.</div>
		</td>
	</tr>
	<tr>
		<td>Estimated total cost: $</td>
		<td><s:textfield name="ta.totalCost" value="%{ta.totalCost==null? '' : getText('format.money',{ta.totalCost})}" /></td>
	</tr>
	<tr class="help">
		<td />
		<td>
		<div class="note">Select <b>INTERNAL</b> for IITA sponsored travel, <b>EXTERNAL</b> for travel paid for by other institutions. Specify details in the
		Cost sharing text box below.</div>
		</td>
	</tr>
	<tr>
		<td>Source of funding:*</td>
		<td><s:radio onclick="javascript: personalTravel();" name="ta.funding" value="%{ta.funding}" list="@org.iita.travelauth.model.Funding@values()" listValue="%{getText('ta.funding.'+toString())}" /></td>
	</tr>
	<tr>
		<td>Type of Travel:</td>
		<td><s:radio name="ta.tripType" value="%{ta.tripType}" list="@org.iita.travelauth.model.TravelTypes@values()"
			listValue="%{getText('ta.type.'+toString())}" /></td>
	</tr>
</table>

<h2>Financial information</h2>
<div id="msgPersonal" style="display:none;">Hint: On personal travel, you do not need to supply Financial information for your trip.</div>
<table class="inputform" id="bCodeDetails">
	<colgroup>
		<col width="240px" />
		<col />
	</colgroup>
	<tr class="help">
		<td />
		<td><div class="note">When traveling on several cost centers, please describe how the costs should be shared among the listed cost centers. Leave this blank if there's no
		special sharing of costs.</div></td>
	</tr>
	<tr>
		<td>Cost sharing:</td>
		<td><s:textarea name="ta.costSharing" value="%{ta.costSharing}" /></td>
	</tr>
	<tr class="help">
		<td />
		<td>
		<div class="note">List <b>all involved</b> budget codes. Click <b>More +</b> below to add more records. In case of externally funded travel, specify the
		budget code that will be used to cover the purchase of ticket.<br /> To <b>DELETE</b> a cost center, just empty the cost center field and save your TA.</div>
		</td>
	</tr>
	<s:iterator value="ta.budgetCodes" status="status">
		<s:set name="budgetIndex" value="#status.index" />
		<s:include value="ta-budget-form.jsp" />
	</s:iterator>
	<s:set name="budgetIndex" value="ta.budgetCodes.size" />
	<s:include value="ta-budget-form.jsp" id="newbudgetform" />
	<tr>
		<td><a onclick="javascript: copyBudget($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More +</a></td>
		<td />
	</tr>
</table>

<table class="inputform" id="cashierDetails">
	<colgroup>
		<col width="240px" />
		<col />
	</colgroup>
	<tbody>
		<tr class="help">
			<td />
			<td>
			<div class="note">Please select the Cashier's office where you want to collect the advance.</div>
			</td>
		</tr>
		<tr>
			<td>Cashier's office:</td>
			<td><s:select name="cashier" list="%{cashiers}" value="%{ta.cashier.id}" emptyOption="true" listKey="id" listValue="location" /></td>
		</tr>
		<s:iterator value="ta.advances" status="status">
			<s:set name="advanceIndex" value="#status.index" />
			<tr>
				<td>Cash advance:</td>
				<td><s:select name="ta.advances[%{advanceIndex}].type" list="#{'CASH':'CASH','CHEQUE':'CHEQUE'}" value="%{type}" /> <s:textfield
					cssStyle="width: 200px;" name="ta.advances[%{#advanceIndex}].amount" value="%{amount}" /> <s:select name="ta.advances[%{advanceIndex}].currency"
					value="%{currency}" list="#{'USD':'USD','NGN':'NGN','CFA':'CFA','EURO':'EUR','GBP':'GBP'}" /></td>
			</tr>
		</s:iterator>
		<tr>
			<td>Cash advance:</td>
			<td><s:select name="ta.advances[%{ta==null || ta.advances==null ? 0 : ta.advances.size}].type" list="#{'CASH':'CASH','CHEQUE':'CHEQUE'}" value="" /> <s:textfield
				cssStyle="width: 200px;" name="ta.advances[%{ta==null || ta.advances==null ? 0 : ta.advances.size}].amount" value="" /> <s:select
				name="ta.advances[%{ta==null || ta.advances==null ? 0 : ta.advances.size}].currency" list="#{'USD':'USD','NGN':'NGN','CFA':'CFA','EURO':'EUR','GBP':'GBP'}"
				value="" /></td>
		</tr>
		<tr>
			<td><a onclick="javascript: copyBudget($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More records +</a></td>
			<td />
		</tr>
		<tr class="help">
			<td />
			<td><div class="note">Only one person per TA can collect cash. If cash advances go to individual travelers, separate authorizations need to be filled!</div></td>
		</tr>
		<tr>
			<td>Cash advance for:</td>
			<td><b><s:property value="ta.traveler.lastName" />, <s:property value="ta.traveler.firstName" /></b> <s:property value="ta.traveler.staffId" /></td>
		</tr>
		<tr>
			<td>Staff ID for cash advance:</td>
			<td><s:textfield name="ta.traveler.staffId" value="%{ta.traveler.staffId}" /></td>
		</tr>
	</tbody>
</table>

<h2>Travel itinerary</h2>

<table class="inputform">
	<colgroup>
		<col width="240px" />
		<col />
	</colgroup>
	<tbody>
		<tr class="help">
			<td />
			<td>
			<div class="note">Select the travel agency that will manage the travel on this TA. If there is <b>absolutely no involvement</b> required for Travel
			Services, you can select the blank option.</div>
			</td>
		</tr>
		<tr>
			<td>Travel agency</td>
			<td><s:select name="travelAgency" list="%{travelAgencies}" value="%{ta.travelAgency.id}" emptyOption="true" listKey="id" listValue="location" /></td>
		</tr>
		<tr class="help">
			<td />
			<td>
			<div class="note">List all travelers. Use <b>More travelers +</b> link below to add travelers to this TA. To <b>remove</b> a traveler, empty the last name field! You cannot remove principal traveler.</div>
			</td>
		</tr>
		<s:iterator value="ta.travelers" status="status">
			<s:set name="travelerIndex" value="#status.index" />
			<s:include value="ta-traveler-form.jsp" />
		</s:iterator>
	</tbody>
	<s:set name="travelerIndex" value="ta.travelers.size" />
	<tbody style="display: none;">
		<s:include value="ta-traveler-form.jsp" />
	</tbody>
	<tr>
		<td><a onclick="javascript: copyBudget($($(this).parentNode.parentNode.parentNode).previous(), 3, 0); return false;">More travelers +</a></td>
		<td />
	</tr>
</table>
<script type="text/javascript">
function personalTravel() {
	var isPersonal=document.getElementsByName('ta.funding')[0].checked;

	if (isPersonal) {
			document.getElementById('bCodeDetails').hide('slow');
			document.getElementById('cashierDetails').hide('slow');
			document.getElementById('msgPersonal').show('slow');
		} else {
			document.getElementById('bCodeDetails').show('slow');
			document.getElementById('cashierDetails').show('slow');
			document.getElementById('msgPersonal').hide('slow');
		}
}
personalTravel();
</script>