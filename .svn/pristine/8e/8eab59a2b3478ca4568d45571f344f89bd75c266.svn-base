<%@ include file="/common/taglibs.jsp"%>

<h3>APPLICANT'S CHILDREN</h3>
<div>
	<div>
	    <table class="inputform" id="childrenTable">
	    <colgroup>
			<col width="200px" />
			<col width="300px" />
			<col />
		</colgroup>
		<tr>
			<td />
			<td>Child's Names:</td>
			<td>Date of Birth:</td>
		</tr>
		<s:iterator value="cdoApplication.biodata.applicantsChildren" status="status">
			<s:set name="childIndex" value="#status.index" />
			<tr>
				<td><s:textfield name="cdoApplication.biodata.applicantsChildren[%{childIndex}].childName" value="%{childName}" /></td>
                <td><iita:datepicker name="cdoApplication.biodata.applicantsChildren[%{childIndex}].dateOfBirth" value="%{dateOfBirth}" cssClass="datepicker" /></td>
            </tr>
		</s:iterator>
	       	<tr>
				<td />
				<td><s:textfield name="cdoApplication.biodata.applicantsChildren[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.applicantsChildren==null ? 0 : cdoApplication.biodata.applicantsChildren.size}].childName" value="%{childName}" /></td>
                <td><iita:datepicker name="cdoApplication.biodata.applicantsChildren[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.applicantsChildren==null ? 0 : cdoApplication.biodata.applicantsChildren.size}].dateOfBirth" value="%{dateOfBirth}" cssClass="datepicker" /></td>
			</tr>
			<tr>
				<td><a onclick="javascript: copyChildren($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More children +</a></td>
			</tr>
	    </table>
	</div>
</div>