<%@ include file="/common/taglibs.jsp"%>

<h3>MAJOR CONSTRAINTS FACED IN WORK OR STUDY THAT PROPOSED TRAINING MIGHT ADDRESS</h3>
<div>
	<div>
	    <table class="inputform" id="childrenTable">
	    <colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td />
			<td>Indicate:</td>
		</tr>
		<s:iterator value="cdoNonDegreeApplication.constraints" status="status">
			<s:set name="cIndex" value="#status.index" />
			<tr>
				<td />
				<td><s:textfield name="cdoNonDegreeApplication.constraints[%{cIndex}].faced" value="%{faced}" /></td>
            </tr>
		</s:iterator>
	       	<tr>
				<td />
				<td><s:textfield name="cdoNonDegreeApplication.constraints[%{cdoNonDegreeApplication==null || cdoNonDegreeApplication.constraints==null ? 0 : cdoNonDegreeApplication.constraints.size}].faced" value="%{faced}" /></td>
			</tr>
			<tr>
				<td><a onclick="javascript: copyConstraint($($(this).parentNode.parentNode).previous(), 3, 0); return false;">Add more +</a></td>
			</tr>
	    </table>
	</div>
</div>