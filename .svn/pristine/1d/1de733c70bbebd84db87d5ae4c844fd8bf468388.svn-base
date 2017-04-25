<%@ include file="/common/taglibs.jsp"%>

<table class="table">
	<tr>
		<td colspan="2"><h3>PERSONAL INFORMATION</h3></td>
	</tr>
	<tr>
		<td>
			<div class="col-xs-12">
				<label for="title"	class="col-xs-12">Title:</label>
				<span  class="col-xs-12"><s:property value="biodata.title" /></span>
			</div>
		</td>
		<td>
			<div class="col-xs-12">
				<label for="lastName" class="col-xs-12">Surname: *</label>
				<span  class="col-xs-12"><s:property value="biodata.lastName" /></span>
			</div>
		</td>
	</tr>
	
	<tr>
		<td>
			<div class="col-xs-12">
				<label for="firstName"	class="col-xs-12">Given (First) Names: *</label>
				<span  class="col-xs-12"><s:property value="biodata.firstName" /> <s:property value="biodata.middleName" /></span>
			</div>
		</td>
		<td>
			<div class="col-xs-12">
				<label for="gender" class="col-xs-12">Gender: *</label>
				<span  class="col-xs-12"><s:property value="biodata.gender" /></span>
			</div>
		</td>
	</tr>
	
	<tr>
		<td>
			<div class="col-xs-12">
				<label for="dateOfBirth" class="col-xs-12">Date of Birth: *</label>
	        	<span  class="col-xs-12"><iita:date name="biodata.dateOfBirth" format="%{getText('date.format')}" /></span>
			</div>
		</td>
		<td>
		    <div class="col-xs-12">
				<label for="nationality" class="col-xs-12">Nationality:  *</label>
		        <span  class="col-xs-12"><s:property value="biodata.nationality" /></span>
			</div>
		</td>
	</tr>
	
	<tr>
		<td colspan="2"><h3>Correspondence Address</h3></td>
	</tr>
	<tr>	
		<td>
			<div class="col-xs-12 col-md-12">
				<label for="correspondenceAddress" class="col-xs-12">Address: *</label>
			    <span  class="col-xs-12"><s:property value="biodata.correspondenceAddress" /></span>
			</div>
		</td>
		<td>
			<div class="col-xs-6 col-md-6">
				<label for="correspondenceCity" class="col-xs-12">City: *</label>
			    <span  class="col-xs-12"><s:property value="biodata.correspondenceCity" /></span>
			</div>
			<div class="col-xs-6 col-md-6">
				<label for="correspondenceState" class="col-xs-12">State: *</label>
				<span  class="col-xs-12"><s:property value="biodata.correspondenceState" /></span>
			</div>
		</td>
	</tr>
	
	<tr>
		<td>
			<div class="col-xs-12">
				<label for="correspondencePostalCode" class="col-xs-12">Postal Code:</label>
				<span  class="col-xs-12"><s:property value="biodata.correspondencePostalCode" /></span>
			</div>
		</td>
		<td>
			<div class="col-xs-12">
				<label for="correspondenceCountry" class="col-xs-12">Country: *</label>
				<span  class="col-xs-12"><s:property value="biodata.correspondenceCountry" /></span>
			</div>
		</td>
	</tr>
	
	<tr>
		<td>
			<div class="col-xs-12 col-md-12">
				<label for="correspondenceEmail" class="col-xs-12">Email: *</label>
			    <span  class="col-xs-12"><s:property value="biodata.correspondenceEmailAddress" /></span>
			</div>
		</td>
		<td>
			<div class="col-xs-6 col-md-6">
				<label for="correspondenceTelephone" class="col-xs-12">Telephone:</label>
			    <span  class="col-xs-12"><s:property value="biodata.correspondenceTelephone" /></span>
			</div>
			<div class="col-xs-6 col-md-6">
				<label for="correspondenceCellular" class="col-xs-12">Cellular: *</label>
				<span  class="col-xs-12"><s:property value="biodata.correspondenceCellular" /></span>
			</div>
		</td>
	</tr>
	
	
	<tr>
		<td colspan="2"><h3>Permanent Address</h3></td>
	</tr>
	<tr>
		<td>
			<div class="col-xs-6 col-md-4">
				<label for="permanentAddress" class="col-xs-12">Address: *</label>
	       		<span  class="col-xs-12"><s:property value="biodata.permanentAddress" /></span>
			</div>
		</td>
		<td>
			<div class="col-xs-6 col-md-4">
				<label for="permanentCity" class="col-xs-12">City: *</label>
	       		<span  class="col-xs-12"><s:property value="biodata.permanentCity" /></span>
			</div>
	
		    <div class="col-xs-6 col-md-4">
				<label for="permanentState" class="col-xs-12">State: *</label>
	        	<span  class="col-xs-12"><s:property value="biodata.permanentState" /></span>
			</div>
		</td>
	</tr>
	
	<tr>
		<td>
			<div class="col-xs-6 col-md-4">
				<label for="permanentPostalCode" class="col-xs-12">Postal Code:</label>
		   		<span  class="col-xs-12"><s:property value="biodata.permanentPostalCode" /></span>
			</div>
		</td>
		<td>
			<div class="col-xs-12 col-md-8">
				<label for="permanentCountry" class="col-xs-12">Country: *</label>
	       		<span  class="col-xs-12"><s:property value="biodata.permanentCountry" /></span>
			</div>
		</td>
	</tr>
	
	<s:include value="/WEB-INF/jsp/include/educationandtraining-details.jsp" />
	
	<s:include value="/WEB-INF/jsp/include/previouseducationandtraining-details.jsp" />
	
	<s:include value="/WEB-INF/jsp/include/otherstudiesandtraining-details.jsp" />
	
	<s:include value="/WEB-INF/jsp/include/employmenthistory-details.jsp" />
	
	<s:include value="/WEB-INF/jsp/include/previousemploymenthistory-details.jsp" />
	
	<s:include value="/WEB-INF/jsp/include/spokenlanguages-details.jsp" />
</table>