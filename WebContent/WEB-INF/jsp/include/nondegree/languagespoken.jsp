<%@ include file="/common/taglibs.jsp"%>

<h3>LANGUAGE(S) PROFICIENCY</h3>
<div>
		    <table class="inputform" id="langProficiencyTable">
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
					<s:select name="cdoNonDegreeApplication.englishLanguage" 
					list="#{'Nil':'Nil','Average':'Average','Good':'Good','Excellent':'Excellent'}" 
					value="%{cdoNonDegreeApplication.englishLanguage}" headerKey="" headerValue="--Select--" />
				</td>
				<td>
					<s:select name="cdoNonDegreeApplication.frenchLanguage" 
					list="#{'Nil':'Nil','Average':'Average','Good':'Good','Excellent':'Excellent'}" 
					value="%{cdoNonDegreeApplication.frenchLanguage}" headerKey="" headerValue="--Select--" />
				</td>
				<td>
					<s:select name="cdoNonDegreeApplication.portugueseLanguage" 
					list="#{'Nil':'Nil','Average':'Average','Good':'Good','Excellent':'Excellent'}" 
					value="%{cdoNonDegreeApplication.portugueseLanguage}" headerKey="" headerValue="--Select--" />
				</td>
				<td>
					<s:select name="cdoNonDegreeApplication.swahiliLanguage" 
					list="#{'Nil':'Nil','Average':'Average','Good':'Good','Excellent':'Excellent'}" 
					value="%{cdoNonDegreeApplication.swahiliLanguage}" headerKey="" headerValue="--Select--" />
				</td>
				<td><s:textfield name="cdoNonDegreeApplication.otherLanguage" value="%{cdoNonDegreeApplication.otherLanguage}" /></td>
			</tr>
		    </table>
		</div>