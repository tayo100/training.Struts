<%@ include file="/common/taglibs.jsp"%>

<h3>LANGUAGES SKILLS</h3>
<div>
		<table class="table" id="motherTongueTable">
		    <colgroup>
				<col />
			</colgroup>
			<tr>
				<td>
					<div class="row">
						<div class="col-xs-12 col-md-12">
							<label class="col-xs-12">Mother Tongue</label>
							<s:textfield cssClass="form-control" name="cdoBioData.motherTongue" value="%{cdoBioData.motherTongue}" />
						</div>
					</div>
				</td>
			</tr>
		</table>
	    <table class="table" id="languageTable">
	    <colgroup>
			<col />
			<col />
			<col />
			<col />
		</colgroup>
		<tr>
				<td>Language</td>
				<td>Read</td>
				<td>Speak</td>
				<td>Write</td>
		</tr>
		<s:iterator value="cdoBioData.languageSpoken" status="status">
			<s:set name="langIndex" value="#status.index" />
			<tr>
				<td>
					<s:select cssClass="form-control" name="cdoBioData.languageSpoken[%{langIndex}].language" 
					list="#{'English':'English','French':'French','Portuguese':'Portuguese','Others':'Others'}" 
					value="%{language}" headerKey="" headerValue="--Select language--" />
				</td>
				<td>
					<s:select cssClass="form-control" name="cdoBioData.languageSpoken[%{langIndex}].languageRead" 
					list="#{'Easily':'Easily','Not Easily':'Not Easily'}" 
					value="%{languageRead}" headerKey="" headerValue="--Select read skill--" />
				</td>
				<td>
					<s:select cssClass="form-control" name="cdoBioData.languageSpoken[%{langIndex}].languageSpeak" 
					list="#{'Easily':'Easily','Not Easily':'Not Easily'}" 
					value="%{languageSpeak}" headerKey="" headerValue="--Select speak skill--" />
				</td>
				<td>
					<s:select cssClass="form-control" name="cdoBioData.languageSpoken[%{langIndex}].languageWrite" 
					list="#{'Easily':'Easily','Not Easily':'Not Easily'}" 
					value="%{languageWrite}" headerKey="" headerValue="--Select write skill--" />
				</td>
			</tr>
		</s:iterator>
	       	<tr>
				<td>
					<s:select cssClass="form-control" name="cdoBioData.languageSpoken[%{cdoBioData.languageSpoken.size}].language" 
					list="#{'English':'English','French':'French','Portuguese':'Portuguese','Others':'Others'}" 
					value="" headerKey="" headerValue="--Select language--" />
				</td>
				<td>
					<s:select cssClass="form-control" name="cdoBioData.languageSpoken[%{cdoBioData.languageSpoken.size}].languageRead" 
					list="#{'Easily':'Easily','Not Easily':'Not Easily'}" 
					value="" headerKey="" headerValue="--Select read skill--" />
				</td>
				<td>
					<s:select cssClass="form-control" name="cdoBioData.languageSpoken[%{cdoBioData.languageSpoken.size}].languageSpeak" 
					list="#{'Easily':'Easily','Not Easily':'Not Easily'}" 
					value="" headerKey="" headerValue="--Select speak skill--" />
				</td>
				<td>
					<s:select cssClass="form-control" name="cdoBioData.languageSpoken[%{cdoBioData.languageSpoken.size}].languageWrite" 
					list="#{'Easily':'Easily','Not Easily':'Not Easily'}" 
					value="" headerKey="" headerValue="--Select write skill--" />
				</td>
			</tr>
			
			<tr>
				<td colspan="4"><a onclick="javascript: copyLanguage($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More languages +</a></td>
			</tr>
	    </table>
</div>