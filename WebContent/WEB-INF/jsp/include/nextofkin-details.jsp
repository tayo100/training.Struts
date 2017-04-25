<%@ include file="/common/taglibs.jsp"%>

<h3>NEXT OF KIN</h3>
<div>
	<div>
	    <table class="table" id="nextofkinTable">
	    <colgroup>
			<col width="200px" />
			<col />
			<col />
			<col />
		</colgroup>
		<tr>
			<td />
			<td>Name:</td>
			<td>Address:</td>
			<td>Relationship:</td>
			<td>Telephone:</td>
		</tr>
		<tr>
			<td></td>
			<td><s:property value="biodata.nextOfKinName" /></td>
			<td><s:property value="biodata.nextOfKinAddrs" /></td>
			<td>
				<s:property value="biodata.nextOfKinRelationship" />
			</td>
			<td><s:property value="biodata.nextOfKinTelNo" /></td>
		</tr>
	    </table>
	</div>
</div>