<%@ include file="/common/taglibs.jsp"%>

<h3>LANGUAGES SPOKEN</h3>
<div>
	<div>
	    <table class="inputform" id="languageTable">
	    <colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<s:iterator value="cdoBioData.languageSpoken" status="status">
			<s:set name="langIndex" value="#status.index" />
			<tr>
				<td>Language:</td>
				<td>
					<s:select name="cdoBioData.languageSpoken[%{langIndex}].language" 
					list="#{'English':'English','French':'French','Portuguese':'Portuguese','Others':'Others'}" 
					value="%{language}" headerKey="" headerValue="--Select language--" />
				</td>
			</tr>
		</s:iterator>
		<s:set name="langIndex" value="cdoBioData.languageSpoken.size" />
	       	<tr>
				<td>Language:</td>
				<td><s:hidden name="cdoBioData.languageSpoken[%{langIndex}].version" value="%{version}" />
					<s:select name="cdoBioData.languageSpoken[%{langIndex}].language" 
					list="#{'English':'English','French':'French','Portuguese':'Portuguese','Others':'Others'}" 
					headerKey="" headerValue="--Select language--" />
				</td>
			</tr>
			<tr>
				<td><a onclick="javascript: copyLanguage($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More languages +</a></td>
			</tr>
	    </table>
	</div>
</div>