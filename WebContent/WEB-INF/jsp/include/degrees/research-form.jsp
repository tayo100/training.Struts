<%@ include file="/common/taglibs.jsp"%>

<h3>PROPOSED ACADEMIC PROGRAM</h3>
<div>
	<div>
	    <table class="inputform" id="nextofkinTable">
	    <colgroup>
			<col width="200px" />
			<col />
			<col />
			<col />
		</colgroup>
		<tr>
			<td />
			<td>Present University:</td>
			<td>Degree Sought:</td>
			<td>Proposed Research Theme:</td>
		</tr>
		<tr>
			<td></td>
			<td><s:textfield name="cdoApplication.biodata.nextOfKinName" value="%{cdoApplication.biodata.nextOfKinName}" /></td>
			<td><s:textfield name="cdoApplication.biodata.nextOfKinAddrs" value="%{cdoApplication.biodata.nextOfKinAddrs}" /></td>
			<td><s:textfield name="cdoApplication.biodata.nextOfKinRelationship" value="%{cdoApplication.biodata.nextOfKinRelationship}" /></td>
		</tr>
		<tr>
			<td />
			<td>University Supervisor/Advisers:</td>
			<td>Email:</td>
			<td>Name of IITA Supervisors:</td>
		</tr>
		<tr>
			<td></td>
			<td><s:textfield name="cdoApplication.biodata.nextOfKinName" value="%{cdoApplication.biodata.nextOfKinName}" /></td>
			<td><s:textfield name="cdoApplication.biodata.nextOfKinAddrs" value="%{cdoApplication.biodata.nextOfKinAddrs}" /></td>
			<td><s:textfield name="cdoApplication.biodata.nextOfKinRelationship" value="%{cdoApplication.biodata.nextOfKinRelationship}" /></td>
		</tr>		
		
	    </table>
	    
	    <div>
		    <table class="inputform" id="nextofkinTable">
		    <colgroup>
				<col width="200px" />
				<col />
				<col />
			</colgroup>
			<tr>
				<td />
				<td>Research Locations:</td>
				<td>Expected Duration:</td>
			</tr>
			<tr>
				<td></td>
				<td><s:textfield name="cdoApplication.biodata.nextOfKinName" value="%{cdoApplication.biodata.nextOfKinName}" /></td>
				<td><s:textfield name="cdoApplication.biodata.nextOfKinAddrs" value="%{cdoApplication.biodata.nextOfKinAddrs}" /></td>
			</tr>
		    </table>
		</div>
		
		<div>
		    <table class="inputform" id="nextofkinTable">
		    <colgroup>
				<col width="200px" />
				<col width="100px" />
				<col width="100px" />
				<col />
			</colgroup>
			<tr>
				<td />
				<td>Start Date:</td>
				<td>End Date:</td>
				<td />
			</tr>
			<tr>
				<td></td>
				<td><iita:datepicker name="cdoApplication.biodata.applicantsChildren[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.applicantsChildren==null ? 0 : cdoApplication.biodata.applicantsChildren.size}].dateOfBirth" value="%{dateOfBirth}" cssClass="datepicker" /></td>
				<td><iita:datepicker name="cdoApplication.biodata.applicantsChildren[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.applicantsChildren==null ? 0 : cdoApplication.biodata.applicantsChildren.size}].dateOfBirth" value="%{dateOfBirth}" cssClass="datepicker" /></td>
				<td></td>
			</tr>
		    </table>
		</div>
		
		<div>
		    <table class="inputform" id="nextofkinTable">
		    <colgroup>
				<col width="200px" />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tr>
				<td>Spoken Languages</td>
				<td>English:</td>
				<td>French:</td>
				<td>Portuguese:</td>
				<td>Swahili:</td>
				<td>Local/Others (Indicate):</td>
			</tr>
			<tr>
				<td>...</td>
				<td><select><option>Nil</option><option>Average</option><option>Good</option><option>Excellent</option></select></td>
				<td><select><option>Nil</option><option>Average</option><option>Good</option><option>Excellent</option></select></td>
				<td><select><option>Nil</option><option>Average</option><option>Good</option><option>Excellent</option></select></td>
				<td><select><option>Nil</option><option>Average</option><option>Good</option><option>Excellent</option></select></td>
				<td><s:textfield name="cdoApplication.biodata.nextOfKinAddrs" value="%{cdoApplication.biodata.nextOfKinAddrs}" /></td>
			</tr>
		    </table>
		</div>
		
		<div>
		    <table class="inputform" id="nextofkinTable">
		    <colgroup>
				<col width="200px" />
				<col />
			</colgroup>
			<tr>
				<td>Support Required</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="checkbox" name="support" value="fullscholarship">Full scholarship<br>
					<input type="checkbox" name="support" value="researchandlivingcosts">Research and living costs<br>
					<input type="checkbox" name="support" value="researchcost">Research cost only<br>
					<input type="checkbox" name="support" value="none">None
				</td>
			</tr>
		    </table>
		</div>
		
		<div>
		    <table class="inputform" id="nextofkinTable">
		    <colgroup>
				<col width="200px" />
				<col />
			</colgroup>
			<tr>
				<td>Funding Source</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="checkbox" name="funding" value="employer" title="provide proof of support">Employer<br>
					<input type="checkbox" name="funding" value="donor" title="provide proof of support">Donor<br>
					<input type="checkbox" name="funding" value="self" title="provide proof of support">Self<br>
					<input type="checkbox" name="funding" value="joint" title="provide proof of support">Joint<br>
					<input type="checkbox" name="funding" value="iitacore">IITA Core<br>
					<input type="checkbox" name="funding" value="iitaproject">IITA Project<br>
				</td>
			</tr>
		    </table>
		</div>
		
		<div>
		    <table class="inputform" id="nextofkinTable">
		    <colgroup>
				<col width="200px" />
				<col width="100px" />
				<col />
				<col />
			</colgroup>
			<tr>
				<td />
				<td>Date:</td>
				<td>Name of sponsor:</td>
				<td>Address of sponsor:</td>
			</tr>
			<tr>
				<td></td>
				<td><iita:datepicker name="cdoApplication.biodata.applicantsChildren[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.applicantsChildren==null ? 0 : cdoApplication.biodata.applicantsChildren.size}].dateOfBirth" value="%{dateOfBirth}" cssClass="datepicker" /></td>
				<td><s:textfield name="cdoApplication.biodata.nextOfKinName" value="%{cdoApplication.biodata.nextOfKinName}" /></td>
				<td><s:textfield name="cdoApplication.biodata.nextOfKinAddrs" value="%{cdoApplication.biodata.nextOfKinAddrs}" /></td>
			</tr>
		    </table>
		</div>
	</div>
</div>