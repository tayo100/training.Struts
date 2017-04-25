<%@ include file="/common/taglibs.jsp"%>

<div class="row">
	<h3>PERSONAL INFORMATION</h3>
	<div class="form-group">
		<div class="col-md-4 col-xs-6">
			<label for="title"	class="col-md-4">Title:</label>
			<span  class="col-xs-12"><s:property value="biodata.title" /></span>
		</div>
		<div class="col-md-8 col-xs-12">
			<label for="lastName" class="col-md-8">Surname: *</label>
			<span  class="col-xs-12"><s:property value="%{biodata.lastName" /></span>
		</div>
	</div>
</div>

<div class="row">
	<div class="form-group">
		<div class="col-xs-6 col-md-4">
			<label for="firstName"	class="col-xs-12">Given (First) Name: *</label>
			<span  class="col-xs-12"><s:property value="biodata.firstName" /></span>
		</div>
		<div class="col-xs-6 col-md-4">
			<label for="middleName" class="col-xs-12">Middle Name:</label>
			<span  class="col-xs-12"><s:property value="biodata.middleName" /></span>
		</div>
		<div class="col-xs-6 col-md-4">
			<label for="gender" class="col-xs-12">Gender: *</label>
			<span  class="col-xs-12"><s:property value="biodata.gender" /></span>
		</div>
	</div>
</div>

<div class="row">
	<div class="form-group">
		<div class="col-xs-6 col-md-4">
			<label for="dateOfBirth" class="col-xs-12">Date of Birth: *</label>
        	<span  class="col-xs-12"><iita:date name="biodata.dateOfBirth" format="%{getText('date.format')}" /></span>
		</div>
	    <div class="col-xs-12 col-md-8">
			<label for="nationality" class="col-xs-12">Nationality:  *</label>
	        <span  class="col-xs-12"><s:property value="biodata.nationality" /></span>
		</div>
	</div>
</div>

<div class="row">
	<h3>Correspondence Address</h3>
	<div class="form-group">
		<div class="col-xs-12 col-md-12">
			<label for="correspondenceAddress" class="col-xs-12">Address: *</label>
		    <span  class="col-xs-12"><s:property value="biodata.correspondenceAddress" /></span>
		</div>
	

		<div class="col-xs-6 col-md-6">
			<label for="correspondenceCity" class="col-xs-12">City: *</label>
		    <span  class="col-xs-12"><s:property value="biodata.correspondenceCity" /></span>
		</div>
		<div class="col-xs-6 col-md-6">
			<label for="correspondenceState" class="col-xs-12">State: *</label>
			<span  class="col-xs-12"><s:property value="biodata.correspondenceState" /></span>
		</div>
	</div>
</div>

<div class="row">
	<div class="form-group">
		<div class="col-xs-6 col-md-4">
			<label for="correspondencePostalCode" class="col-xs-12">Postal Code:</label>
			<s:property value="biodata.correspondencePostalCode" /></span>
		</div>
		<div class="col-xs-12 col-md-8">
			<label for="correspondenceCountry" class="col-xs-12">Country: *</label>
			<s:property value="biodata.correspondenceCountry" /></span>
		</div>
	</div>
</div>

<div class="row">
	<div class="form-group">
		<div class="col-xs-6 col-md-4">
			<label for="correspondenceEmail" class="col-xs-12">Email: *</label>
		    <span  class="col-xs-12"><s:property value="biodata.correspondenceEmailAddress" /></span>
		</div>
		<div class="col-xs-6 col-md-4">
			<label for="correspondenceTelephone" class="col-xs-12">Telephone:</label>
		    <span  class="col-xs-12"><s:property value="biodata.correspondenceTelephone" /></span>
		</div>
		<div class="col-xs-6 col-md-4">
			<label for="correspondenceCellular" class="col-xs-12">Cellular: *</label>
			<span  class="col-xs-12"><s:property value="biodata.correspondenceCellular" /></span>
		</div>
	</div>
</div>


<div class="row">
	<h3>Permanent Address</h3>
	<div class="form-group">
		<div class="col-xs-6 col-md-4">
			<label for="permanentAddress" class="col-xs-12">Address: *</label>
       		<span  class="col-xs-12"><s:property value="biodata.permanentAddress" /></span>
		</div>

		<div class="col-xs-6 col-md-4">
			<label for="permanentCity" class="col-xs-12">City: *</label>
       		<span  class="col-xs-12"><s:property value="biodata.permanentCity" /></span>
		</div>

	    <div class="col-xs-6 col-md-4">
			<label for="permanentState" class="col-xs-12">State: *</label>
        	<span  class="col-xs-12"><s:property value="biodata.permanentState" /></span>
		</div>
	</div>
</div>

<div class="row">
	<div class="form-group">
		<div class="col-xs-6 col-md-4">
			<label for="permanentPostalCode" class="col-xs-12">Postal Code:</label>
	   		<span  class="col-xs-12"><s:property value="biodata.permanentPostalCode" /></span>
		</div>

		<div class="col-xs-12 col-md-8">
			<label for="permanentCountry" class="col-xs-12">Country: *</label>
       		<span  class="col-xs-12"><s:property value="biodata.permanentCountry" /></span>
		</div>
	</div>
</div>