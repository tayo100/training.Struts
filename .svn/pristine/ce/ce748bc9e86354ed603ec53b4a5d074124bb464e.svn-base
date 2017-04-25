<%@ include file="/common/taglibs.jsp"%>

<style type="text/css">

.singleColumn{ padding-left: 5px; font-weight:normal;}
.lr{float:left; width:100%}
</style>


<h3>Type Of Support Required</h3>
<div>
	<div>
	    <table class="table" id="supporttypeTable">
	    <colgroup>
			<col />
			<col />
		</colgroup>
		
	       	<tr>
				<td colspan="2">
					<s:checkboxlist cssClass="form-control" name="cdoSabbaticalApplication.supportTypes.typeOfSupport" 
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
					<s:checkboxlist cssClass="form-control" name="cdoSabbaticalApplication.supportTypes.fundingSource" 
					list="#{'Employer':'Employer', 'Donor':'Donor', 'Self':'Self', 'Joint':'Joint', 'IITA Core':'IITA Core', 'IITA Project':'IITA Project' }" 
					value="%{selectedFundingSource}" />
				</td>
			</tr>
			<tr>
				<td>
					Name of Sponsor
				</td>
				<td>
					<s:textfield cssClass="form-control" name="cdoSabbaticalApplication.supportTypes.sponsorName" value="%{cdoSabbaticalApplication.supportTypes.sponsorName}" />
				</td>
			</tr>
			<tr>
				<td>
					Address of Sponsor
				</td>
				<td>
					<s:textfield cssClass="form-control" name="cdoSabbaticalApplication.supportTypes.sponsorAddress" value="%{cdoSabbaticalApplication.supportTypes.sponsorAddress}" />
				</td>
			</tr>
			<tr>
				<td>
					Signature of applicant (Agreed?)
				</td>
				<td>
					<s:checkbox cssClass="form-control" name="cdoSabbaticalApplication.supportTypes.signed" value="%{cdoSabbaticalApplication.supportTypes.signed}" />
				</td>
			</tr>
	    </table>
	</div>
</div>