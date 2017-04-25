<%@ include file="/common/taglibs.jsp"%>

<h3>APPLICANT'S INSTITUTION/SPONSOR</h3>
<div>
	<div>
		    <table class="inputform" id="nextofkinTable">
		    <colgroup>
				<col width="200px" />
				<col />
				<col />
				<col width="100px" />
			</colgroup>
			<tr>
				<td />
				<td>Name of institution:</td>
				<td>Director's signatures:</td>
				<td>Date:</td>
			</tr>
			<tr>
				<td></td>
				<td><s:textfield name="cdoApplication.biodata.nextOfKinName" value="%{cdoApplication.biodata.nextOfKinName}" /></td>
				<td><s:textfield name="cdoApplication.biodata.nextOfKinAddrs" value="%{cdoApplication.biodata.nextOfKinAddrs}" /></td>
				<td><iita:datepicker name="cdoApplication.biodata.applicantsChildren[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.applicantsChildren==null ? 0 : cdoApplication.biodata.applicantsChildren.size}].dateOfBirth" value="%{dateOfBirth}" cssClass="datepicker" /></td>
			</tr>
		    </table>
	</div>
</div>