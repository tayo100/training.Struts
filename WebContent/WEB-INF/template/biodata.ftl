<h3>PERSONAL INFORMATION</h3>
<table class="data" border="1" cellpadding="1">
	<thead>
		<tr>
			<td colspan="2"><h3><em>Personal information details</em></h3></td>
		</tr>
	</thead>
	<tbody>
<#if applicant.createdDate??>
       <tr><td>Date Created:</td><td>${applicant.createdDate?date}</td></tr>
		</#if>

<#if applicant.owner??>
		<tr><td colspan="2"><h3><em>USER LOGIN DETAILS:</em></h3></td></tr>
       <tr><td>Username:</td><td>${applicant.owner.username!''}</td></tr>
       <tr><td>Password:</td><td>${applicant.owner.description!''}</td></tr>
</#if>
<#if appStarter??>
<tr>
			<td colspan="2"><h3><em>BIO-DATA REGISTRATION KEY DETAILS</em></h3></td>
		</tr>
<tr>
                <td><label>TARGET TRAINING:</label></td>
                <td><strong>${announcement.title!''} in ${announcement.type!''}</strong></td>
            </tr>
<tr>
                <td><label>REFERENCE NUMBER:</label></td>
                <td><strong>${appStarter.appKey!''}</strong></td>
            </tr>
<tr>
                <td><label>STATUS:</label></td>
                <td><strong>${appStarter.status!''}</strong></td>
            </tr>
<tr>
			<td colspan="2"><h5><em>NB: You will redirected to complete this training application if the STATUS is INPROGRESS</em></h5></td>
		</tr>
</#if>
<tr>
                <td><label>Title: *</label></td>
                <td>${applicant.title!''}</td>
            </tr>
            <tr>
                <td>Given (First) Name: *</td>
                <td>${applicant.firstName!''}</td>
            </tr>
            <tr>
                <td>Middle Name: *</td>
                <td>${applicant.middleName!''}</td>
            </tr>
            <tr>
                <td>Last Name: *</td>
                <td>${applicant.lastName!''}</td>
            </tr>
            <#if applicant.maidenName??>
            	<tr>
	                <td>Maiden Name: *</td>
	                <td>${applicant.maidenName!''}</td>
	            </tr>
            </#if>
            <tr>
                <td><label>Gender: *</label></td>
                <td>
				${applicant.gender!''}
                </td>
            </tr>

            <#if applicant.spouseName??>
            	<tr>
	                <td>Spouse Name: *</td>
	                <td>${applicant.spouseName!''}</td>
	            </tr>
            </#if>
            <tr>
	            <td>Date of Birth: </td>
					<td><#if applicant.dateOfBirth??>${applicant.dateOfBirth?date}</#if>
				</td>
			</tr>
            <tr>
                <td>Place of Birth: </td>
                <td>${applicant.placeOfBirth!''}</td>
            </tr>
           	<tr>
                <td>Nationality: </td>
                <td>${applicant.nationality!''}</td>
            </tr>
</tbody>
</table>

<h3>CORRESPONDENCE ADDRESS</h3>
<div>
    <table class="data" border="1" cellpadding="1">
    <colgroup>
			<col width="200px" />
			<col />
		</colgroup>
        <tr>
                <td>Address: </td>
                <td>${applicant.correspondenceAddress!''}</td>
            </tr>
            
            <tr>
                <td>City: </td>
                <td>${applicant.correspondenceCity!''}</td>
            </tr>
         <tr>
                <td>State: </td>
                <td>${applicant.correspondenceState!''}</td>
            </tr>
            <tr>
                <td>Country: </td>
                <td>${applicant.correspondenceCountry!''}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${applicant.correspondenceEmailAddress!''}</td>
            </tr>
            <tr>
                <td>Cellular: </td>
                <td>${applicant.correspondenceCellular!''}</td>
            </tr>
            <tr>
                <td>Telephone: </td>
                <td>${applicant.correspondenceTelephone!''}</td>
            </tr>
            <tr>
                <td>Postal Code: </td>
                <td>${applicant.correspondencePostalCode!''}</td>
            </tr>
    </table>
</div>


<h3>PERMANENT ADDRESS</h3>
<div>
    <table class="data" border="1" cellpadding="1">
    <colgroup>
			<col width="200px" />
			<col />
		</colgroup>
        <tr>
                <td>Address: </td>
                <td>${applicant.permanentAddress!''}</td>
            </tr>
            
            <tr>
                <td>City: </td>
                <td>${applicant.permanentCity!''}</td>
            </tr>
         <tr>
                <td>State: </td>
                <td>${applicant.permanentState!''}</td>
            </tr>
            <tr>
                <td>Postal Code: </td>
                <td>${applicant.permanentPostalCode!''}</td>
            </tr>
            <tr>
                <td>Country: </td>
                <td>${applicant.permanentCountry!''}</td>
            </tr>
    </table>
</div>


<h3>NEXT OF KIN</h3>
<div>
    <table class="data" border="1" cellpadding="1">
    <colgroup>
			<col width="200px" />
			<col />
		</colgroup>
        <tr>
                <td>Name: </td>
                <td>${applicant.nextOfKinName!''}</td>
            </tr>
            
            <tr>
                <td>Address: </td>
                <td>${applicant.nextOfKinAddrs!''}</td>
            </tr>
         <tr>
                <td>Relationship: </td>
                <td>${applicant.nextOfKinRelationship!''}</td>
            </tr>
            <tr>
                <td>Telephone Number: </td>
                <td>${applicant.nextOfKinTelNo!''}</td>
            </tr>
    </table>
</div>