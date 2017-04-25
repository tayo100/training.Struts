<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html lang="en">
<head>
    <title>Individual Training Application</title>
</head>
<body>
<table style="width: 100%">
	<colgroup>
		<col />
		<col width="350" />
	</colgroup>
	<tbody>
	<tr>
	<td>
<h2>Application for: <s:property value="announcement.type" /> - <s:property value="announcement.title" /></h2>

<div><em>* <font style="color:#ff0000">means mandatory fields</font></em></div>
<div id="accordion">
<s:form id="processdata" action="draft-individual" method="post">
<s:hidden name="announcementId" value="%{announcement.id}" />
<s:if test="cdoIndividualApplication!=null">
	<s:hidden name="applicationId" value="%{cdoIndividualApplication.id}" />
</s:if>
<s:include value="/WEB-INF/jsp/include/cdoreg-related-form.jsp" />

<s:include value="/WEB-INF/jsp/include/cdoapp-location-form.jsp" />

<table class="inputform">
    <colgroup>
			<col width="200px" />
			<col />
		</colgroup>
        <tr>
            <td></td>
            <td>
            	<s:submit value="Continue Editing" /> 
            	<s:if test="cdoIndividualApplication!=null && cdoIndividualApplication.submissionStatus==@org.iita.trainingunit.applications.model.Application$SUBMISSIONSTATUS@Draft">
           			<s:submit action="process-individual" value="Submit Form" onclick="if(confirm('Submit your application form anyway?')){return true;}else{return false;}" />
            	</s:if>
            </td>
        </tr>
</table>
</s:form>
</div> 

<table class="inputform">
    <colgroup>
			<col width="200px" />
			<col />
		</colgroup>        
        <s:if test="cdoIndividualApplication!=null">
	        <tr>
	            <td></td>
	            <td>
	            	<h2>Application documents</h2>
					<s:if test="cdoIndividualApplication.documents!=null">
						<ul class="file-list">
							<s:iterator value="cdoIndividualApplication.documents">
								<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-applicant-quick.jsp" /></li>
							</s:iterator>
						</ul>
					</s:if>
					
					<s:if test="cdoIndividualApplication.id!=null">
						<p>Attach document to application:</p>
						<iita:fileupload action="application-document!upload" value="Upload files" queryParams="entityId=${cdoIndividualApplication.id}" />
	            	</s:if>
	            	<s:else>
	            		<font style="font-style: italic;"><strong>Hint:</strong> Click 'Continue application' button to be able to attach documents.</font>
	            	</s:else>			
				</td>
	        </tr>
        </s:if>
    </table>

</td>
<td style="padding-left: 10px;">
				<s:include value="/WEB-INF/jsp/include/personal-data.jsp" />
			</td>
				</tbody>
</table>
<script> 
$(function () {
	$(".datepicker").datepicker({ changeMonth: true,
        changeYear: true, dateFormat: 'dd/mm/yy'});
	
	$(".mthyrpicker").datepicker({ changeMonth: true,
        changeYear: true, dateFormat: 'mm/yy'});
	
    $(function () {
        $("#accordion").accordion({
            heightStyle: "content"
        });
    });
});</script>
</body>
</html>