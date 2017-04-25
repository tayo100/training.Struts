<h3>PERSONAL INFORMATION</h3>
<table class="data" border="1" cellpadding="1">
	<thead>
		<tr>
			<td colspan="2"><h3><em>Application details</em></h3></td>
		</tr>
	</thead>
	<tbody>
<#if applicant.createdDate??>
       <tr><td>Registration Date:</td><td>${applicant.createdDate?date}</td></tr>
</#if>
<tr>
                <td><label>Title: *</label></td>
                <td>${applicant.title!''}</td>
            </tr>
            <tr>
                <td>Given Name (First Name): *</td>
                <td>${applicant.firstName!''}</td>
            </tr>
            <tr>
                <td>Last Name: *</td>
                <td>${applicant.lastName!''}</td>
            </tr>

</tbody>
</table>

<h3>TRAINING APPLICATION INFORMATION</h3>
<table class="data" border="1" cellpadding="1">
	<tbody>
<#if application.createdDate??>
       <tr><td>Application Date:</td><td>${application.createdDate?date}</td></tr>
</#if>
<tr>
                <td><label>REFERENCE NUMBER:</label></td>
                <td><strong>${application.refNumber!''}</strong></td>
            </tr>
<tr>
                <td><label>Title: *</label></td>
                <td>${application.title!''}</td>
            </tr>
<#if application.otherAppDetails??>
       <tr>
       		<td>Name of Sponsor:</td>
       		<td>${application.otherAppDetails.nameOfSponsor!''}</td>
       </tr>
       <tr>
       		<td>Address of Sponsor:</td>
       		<td>${application.otherAppDetails.addressofSponsor!''}</td>
       </tr>
</#if>
</tbody>
</table>