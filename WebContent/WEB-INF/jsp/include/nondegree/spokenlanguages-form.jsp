<%@ include file="/common/taglibs.jsp"%>

<h3>LANGUAGES SPOKEN</h3>
<div>
	<div>
	    <table class="inputform" id="languageTable">
	    <colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<s:iterator value="cdoApplication.biodata.languageSpoken" status="status">
			<s:set name="langIndex" value="#status.index" />
			<tr>
				<td>Language:</td>
				<td>
					<s:select name="cdoApplication.biodata.languageSpoken[%{langIndex}].language" 
					list="#{'English':'English','French':'French','Portuguese':'Portuguese','Others':'Others'}" 
					value="%{language}" headerKey="" headerValue="--Select language--" />
				</td>
			</tr>
		</s:iterator>
	       	<tr>
				<td>Language:</td>
				<td>
					<s:select name="cdoApplication.biodata.languageSpoken[%{cdoApplication==null || cdoApplication.biodata==null || cdoApplication.biodata.languageSpoken==null ? 0 : cdoApplication.biodata.languageSpoken.size}].language" 
					list="#{'English':'English','French':'French','Portuguese':'Portuguese','Others':'Others'}" 
					value="" headerKey="" headerValue="--Select language--" />
				</td>
			</tr>
			<tr>
				<td><a onclick="javascript: copyLanguage($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More languages +</a></td>
			</tr>
	    </table>
	</div>
</div>