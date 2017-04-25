<%@ include file="/common/taglibs.jsp"%>

<h3>LANGUAGES SKILLS</h3>
<div>
	<div>
	    <table class="table" id="languageTable">
	    <colgroup>
			<col />
			<col />
			<col />
			<col />
		</colgroup>
		<tr>
			<td>Mother Tongue:</td>
			<td colspan="3">
				<s:property value="biodata.motherTongue" />
			</td>
		</tr>
		<tr>
			<td>Language</td>
			<td>Read</td>
			<td>Speak</td>
			<td>Write</td>
		</tr>
		<s:iterator value="biodata.languageSpoken" status="status">
			<s:set name="langIndex" value="#status.index" />
			<tr>
				<td>
					<s:property value="language" />
				</td>
				<td>
					<s:property value="languageRead" />
				</td>
				<td>
					<s:property value="languageSpeak" />
				</td>
				<td>
					<s:property value="languageWrite" />
				</td>
			</tr>
		</s:iterator>
	    </table>
	</div>
</div>