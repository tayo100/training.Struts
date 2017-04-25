<%@ include file="/common/taglibs.jsp"%>

<h3>TYPE OF SUPPORT REQUIRED TEST</h3>
<div>
	<div>
	    <table class="table" id="supporttypeTable">
	    <colgroup>
			<col />
			<col />
		</colgroup>
		
	       	<tr>
				<td colspan="2">
					<s:property value="cdoInternshipApplication.supportTypes.selectedTypeOfSupport" />
					<s:checkboxlist cssClass="form-control" name="cdoInternshipApplication.supportTypes.typeOfSupport" 
					list="#{'Full Scholarship':'Full Scholarship','Research and Living Cost':'Research and Living Cost',
					'Research Cost Only':'Research Cost Only','None':'None'}"
					value="%{selectedTypeOfSupport}" />
				</td>
			</tr>
			<tr>
				<td>
					Source of funding: (Please provide proof of support)
				</td>
				<td>
					<s:property value="cdoInternshipApplication.supportTypes.selectedFundingSource" />
					<s:checkboxlist cssClass="form-control" name="cdoInternshipApplication.supportTypes.fundingSource" 
					list="#{'Employer':'Employer', 'Donor':'Donor', 'Self':'Self', 'Joint':'Joint', 'IITA Core':'IITA Core', 'IITA Project':'IITA Project' }" 
					value="%{selectedFundingSource}" />
				</td>
			</tr>
			<tr>
				<td>
					Name of Sponsor
				</td>
				<td>
					<s:textfield cssClass="form-control" name="cdoInternshipApplication.supportTypes.sponsorName" value="%{cdoInternshipApplication.supportTypes.sponsorName}" />
				</td>
			</tr>
			<tr>
				<td>
					Address of Sponsor
				</td>
				<td>
					<s:textfield cssClass="form-control" name="cdoInternshipApplication.supportTypes.sponsorAddress" value="%{cdoInternshipApplication.supportTypes.sponsorAddress}" />
				</td>
			</tr>
			<tr>
				<td>
					Signature of applicant (Agreed?)
				</td>
				<td>
					<s:checkbox cssClass="form-control" name="cdoInternshipApplication.supportTypes.signed" value="%{cdoInternshipApplication.supportTypes.signed}" />
				</td>
			</tr>
	    </table>
	</div>
</div>
<style type="text/css">

.singleColumn{ padding-left: 5px; font-weight:normal;}
.lr{float:left; width:100%}
</style>
