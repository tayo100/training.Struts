<%@ include file="/common/taglibs.jsp"%>

<h3>OBJECTIVES/GOALS</h3>
<div>
	<div>
	    <table class="inputform" id="skillsTable">
	    <colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td />
			<td>Specific Skills (you wish to acquire):</td>
		</tr>
		<s:iterator value="cdoNonDegreeApplication.listSkills" status="status">
			<s:set name="sIndex" value="#status.index" />
			<tr>
				<td />
				<td><s:textfield name="cdoNonDegreeApplication.listSkills[%{sIndex}].acquireSkills" value="%{acquireSkills}" /></td>
            </tr>
		</s:iterator>
	       	<tr>
				<td />
				<td><s:textfield name="cdoNonDegreeApplication.listSkills[%{cdoNonDegreeApplication==null || cdoNonDegreeApplication.listSkills==null ? 0 : cdoNonDegreeApplication.listSkills.size}].acquireSkills" value="%{acquireSkills}" /></td>
			</tr>
			<tr>
				<td><a onclick="javascript: copyConstraint($($(this).parentNode.parentNode).previous(), 3, 0); return false;">Add more +</a></td>
			</tr>
	    </table>
	</div>
</div>