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
		<s:iterator value="cdoBioData.applicantsChildren" status="status">
			<s:set name="childIndex" value="#status.index" />
			<tr>
				<td />
				<td><s:textfield name="cdoBioData.applicantsChildren[%{childIndex}].childName" value="%{childName}" /></td>
                <td><iita:datepicker name="cdoBioData.applicantsChildren[%{childIndex}].dateOfBirth" value="%{dateOfBirth}" cssClass="datepicker" /></td>
            </tr>
		</s:iterator>
	       	<tr>
				<td />
				<td><s:textfield name="cdoBioData.applicantsChildren[%{cdoBioData.applicantsChildren.size}].childName" value="%{childName}" /></td>
                <td><iita:datepicker name="cdoBioData.applicantsChildren[%{cdoBioData.applicantsChildren.size}].dateOfBirth" value="%{dateOfBirth}" cssClass="datepicker" /></td>
			</tr>
			<tr>
				<td><a onclick="javascript: copyChildren($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More children +</a></td>
			</tr>
	    </table>
	</div>
</div>