<%@ include file="/common/taglibs.jsp"%>

<h3>LANGUAGE(S) PROFICIENCY</h3>
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
				<td><em>Spoken Languages</em></td>
				<td><em>English:</em></td>
				<td><em>French:</em></td>
				<td><em>Portuguese:</em></td>
				<td><em>Swahili:</em></td>
				<td><em>Local/Others (Indicate):</em></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<s:property value="cdoGraduateApplication.englishLanguage" />
				</td>
				<td>
					<s:property value="cdoGraduateApplication.frenchLanguage" />
				</td>
				<td>
					<s:property value="cdoGraduateApplication.portugueseLanguage" />
				</td>
				<td>
					<s:property value="cdoGraduateApplication.swahiliLanguage" />
				</td>
				<td><s:property value="cdoGraduateApplication.otherLanguage" /></td>
			</tr>
		    </table>
		</div>