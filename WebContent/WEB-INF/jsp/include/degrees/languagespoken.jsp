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
					<s:select name="cdoGraduateApplication.englishLanguage" 
					list="#{'Nil':'Nil','Average':'Average','Good':'Good','Excellent':'Excellent'}" 
					value="%{cdoGraduateApplication.englishLanguage}" headerKey="" headerValue="--Select--" />
				</td>
				<td>
					<s:select name="cdoGraduateApplication.frenchLanguage" 
					list="#{'Nil':'Nil','Average':'Average','Good':'Good','Excellent':'Excellent'}" 
					value="%{cdoGraduateApplication.frenchLanguage}" headerKey="" headerValue="--Select--" />
				</td>
				<td>
					<s:select name="cdoGraduateApplication.portugueseLanguage" 
					list="#{'Nil':'Nil','Average':'Average','Good':'Good','Excellent':'Excellent'}" 
					value="%{cdoGraduateApplication.portugueseLanguage}" headerKey="" headerValue="--Select--" />
				</td>
				<td>
					<s:select name="cdoGraduateApplication.swahiliLanguage" 
					list="#{'Nil':'Nil','Average':'Average','Good':'Good','Excellent':'Excellent'}" 
					value="%{cdoGraduateApplication.swahiliLanguage}" headerKey="" headerValue="--Select--" />
				</td>
				<td><s:textfield name="cdoGraduateApplication.otherLanguage" value="%{cdoGraduateApplication.otherLanguage}" /></td>
			</tr>
		    </table>
		</div>