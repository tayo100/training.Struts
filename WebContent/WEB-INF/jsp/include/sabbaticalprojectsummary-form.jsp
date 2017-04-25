<%@ include file="/common/taglibs.jsp"%>

<h3>PART II - AREAS OF INTEREST</h3>

<h3>Summary of Project</h3>
<div class="row">
	<div class="col-xs-12 col-md-12">
		<div class="form-group">
			<label for="title" class="col-md-12 control-label">Proposed research theme/work</label>
			<div class="col-md-12">
				<s:textarea id="title" cssClass="form-control" name="cdoSabbaticalApplication.sabsabProjectSummaries.theme" value="%{cdoSabbaticalApplication.sabProjectSummaries.theme}" />
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-xs-12 col-md-12">
		<div class="form-group">
			<label for="summary" class="col-md-12 control-label">Short summary of research objective</label>
			<div class="col-md-12">
				<s:textarea id="summary" cssClass="form-control" name="cdoSabbaticalApplication.sabProjectSummaries.summary" value="%{cdoSabbaticalApplication.sabProjectSummaries.summary}" />
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="form-group">
		<div class="col-xs-6 col-md-6">
			<label for="howLong" class="col-md-12 control-label">How long will your project last? (in months)</label>
			<div class="col-md-12">
				<s:textfield id="howLong" cssClass="form-control" name="cdoSabbaticalApplication.sabProjectSummaries.howLong" value="%{cdoSabbaticalApplication.sabProjectSummaries.howLong}" />
			</div>
		</div>
		<div class="col-xs-6 col-md-6">
			<label for="startProject" class="col-md-12 control-label">When do you wish to start your project? (MM/YYYY)</label>
			<div class="col-md-12">
				<s:textfield id="startProject" cssClass="form-control" name="cdoSabbaticalApplication.sabProjectSummaries.startProject" value="%{cdoSabbaticalApplication.sabProjectSummaries.startProject}" />
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="form-group">
		<div class="col-xs-8 col-md-8">
			<label for="previousCollaboration" class="col-md-12 control-label">Previous Collaboration with IITA</label>
			<div class="col-md-12">
				<s:textfield id="previousCollaboration" cssClass="form-control" name="cdoSabbaticalApplication.sabProjectSummaries.previousCollaboration" value="%{cdoSabbaticalApplication.sabProjectSummaries.previousCollaboration}" />
			</div>
		</div>
		<div class="col-xs-4 col-md-4">
			<label for="location" class="col-md-12 control-label">Location</label>
			<div class="col-md-12">
				<s:textfield id="location" cssClass="form-control" name="cdoSabbaticalApplication.sabProjectSummaries.location" value="%{cdoSabbaticalApplication.sabProjectSummaries.location}" />
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="form-group">
		<div class="col-xs-6 col-md-6">
			<label for="iitaContacts" class="col-md-12 control-label">IITA Contacts</label>
			<div class="col-md-12">
				<s:textfield id="iitaContacts" cssClass="form-control" name="cdoSabbaticalApplication.sabProjectSummaries.iitaContacts" value="%{cdoSabbaticalApplication.sabProjectSummaries.iitaContacts}" />
			</div>
		</div>
		<div class="col-xs-6 col-md-6">
			<label for="iitaContactEmail" class="col-md-12 control-label">IITA Contact Emails</label>
			<div class="col-md-12">
				<s:textfield id="iitaContactEmail" cssClass="form-control" name="cdoSabbaticalApplication.sabProjectSummaries.iitaContactEmail" value="%{cdoSabbaticalApplication.sabProjectSummaries.iitaContactEmail}" />
			</div>
		</div>
	</div>
</div>