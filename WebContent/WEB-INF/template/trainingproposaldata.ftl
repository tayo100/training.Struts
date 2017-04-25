<h3>TRAINING PROPOSAL INFORMATION</h3>
<table class="data" border="1" cellpadding="1">
	<tbody>
<#if trainingproposal.createdDate??>
       <tr><td>Created Date:</td><td>${trainingproposal.createdDate?date}</td></tr>
</#if>
<tr>
                <td><label>Title: </label></td>
                <td>${trainingproposal.title!''}</td>
            </tr>
            <tr>
                <td>Requester: </td>
                <td>${trainingproposal.requester.fullName!''}</td>
            </tr>
            <tr>
                <td>Program Director: </td>
                <td>${trainingproposal.programDirector.fullName!''}</td>
            </tr>
            <tr>
                <td><label>Venue: </label></td>
                <td>${trainingproposal.venue!''}</td>
            </tr>
            <#if trainingproposal.startTrainingDate??>
				<tr><td>Start Date:</td><td>${trainingproposal.startTrainingDate?date}</td></tr>
			</#if>
			<#if trainingproposal.endTrainingDate??>
			    <tr><td>End Date:</td><td>${trainingproposal.endTrainingDate?date}</td></tr>
			</#if>
</tbody>
</table>

<#if trainingproposal.trainingLocations??>
	<table class="data" border="1" cellpadding="1">
		<tbody>
			<tr>
				<td>Venue</td>
				<td>Start date</td>
				<td>End date</td>
			</tr>
			<#list trainingproposal.trainingLocations as tl>
				<tr>
					<td>${tl.venue} <#if tl.country??>(${tl.country})</#if></td>
					<td>${tl.startDate?date}</td>
					<td>${tl.endDate?date}</td>
				</tr>
			</#list>
		</tbody>
	</table>
</#if>

<#if trainingproposal.trainers??>
	<table class="data" border="1" cellpadding="1">
		<tbody>
			<tr>
				<td>Names</td>
				<td>Email</td>
				<td>Type</td>
			</tr>
			<#list trainingproposal.trainers as tr>
				<tr>
					<td>${tr.names}</td>
					<td>${tr.email}</td>
					<td>${tr.type}</td>
				</tr>
			</#list>
		</tbody>
	</table>
</#if>

<h3>MORE INFORMATION</h3>
<table class="data" border="1" cellpadding="1">
	<tbody>
<tr>
                <td><label>Project Information:</label></td>
                <td><strong>${trainingproposal.projectInformation!''}</strong></td>
            </tr>
<tr>
                <td colspan="2"><strong>For more information, go online and view training proposal details.</strong></td>
            </tr>
</tbody>
</table>