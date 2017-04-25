<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html lang="en">
<head>
    <title>Group Training Registration</title>
</head>
<body>
<div class="container-fluid">

<div class=" col col-sm-8">
	<h2>Application for: <s:property value="announcement.title" /></h2>

	<s:form id="processdata" action="draft-register" method="post">
	<s:hidden name="announcementId" value="%{announcement.id}" />
	<s:if test="cdoApplication!=null">
		<s:hidden name="applicationId" value="%{cdoApplication.id}" />
	</s:if>
	<div><em>* <font style="color:#ff0000">means mandatory fields</font></em></div>
	<table class="inputform">
	    <colgroup>
				<col width="200px" />
				<col />
			</colgroup>
	        <tr>
	            <td></td>
	            <td>
	            	<s:submit cssClass="btn btn-primary pull-right" value="Continue Editing" />
	            	<s:if test="cdoApplication!=null && cdoApplication.submissionStatus==@org.iita.trainingunit.applications.model.Application$SUBMISSIONSTATUS@Draft">
	           			<s:submit cssClass="btn btn-primary pull-right col-md-offset-2" action="process-register" value="Submit Form" onclick="if(confirm('Submit your application form anyway?')){return true;}else{return false;}" />
	           		</s:if>
	            </td>
	        </tr>
	</table>
	
	<s:include value="/WEB-INF/jsp/include/grouptraining-form.jsp" />
	
	<table class="inputform">
	    <colgroup>
				<col width="200px" />
				<col />
			</colgroup>
	        <tr>
	            <td></td>
	            <td>
	            	<s:submit cssClass="btn btn-primary pull-right" value="Continue Editing" />
	            	<s:if test="cdoApplication!=null && cdoApplication.submissionStatus==@org.iita.trainingunit.applications.model.Application$SUBMISSIONSTATUS@Draft">
	           			<s:submit cssClass="btn btn-primary pull-right col-md-offset-2" action="process-register" value="Submit Form" onclick="if(confirm('Submit your application form anyway?')){return true;}else{return false;}" />
	           		</s:if>
	            </td>
	        </tr>
	</table>
	</s:form>
	<div class="clearfix">&nbsp;</div>
</div>


<div class="col col-sm-3 pull-right">
				<s:include value="/WEB-INF/jsp/include/personal-data.jsp" />
				<s:if test="cdoApplication!=null">
					<table class="inputform">
					    <colgroup>
							<col />
						</colgroup>        
						<tr>
							<td>
								<s:if test="cdoApplication.documents!=null">
						    		<h2>Application documents</h2>
									<ul class="file-list">
										<s:iterator value="cdoApplication.documents">
											<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-applicant-quick.jsp" /></li>
										</s:iterator>
									</ul>
								</s:if>
										
								<s:if test="cdoApplication.id!=null">
									<p>Attach document to application:</p>
									<iita:fileupload action="application-document!upload" cssClass="btn btn-primary" value="Upload files" queryParams="entityId=${cdoApplication.id}" />
						        </s:if>
						    </td>
						</tr>
					</table>
				</s:if>
</div>
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
</div>
</body>
</html>