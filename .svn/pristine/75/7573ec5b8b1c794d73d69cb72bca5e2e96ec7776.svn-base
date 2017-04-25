<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html lang="en">
<head>
    <title>Graduate Training Application</title>
</head>
<body>
<div class="container-fluid">
<div class="col col-sm-8">

<h2>Application for: <s:property value="announcement.title" /></h2>


<div><em>* <font style="color:#ff0000">means mandatory fields</font></em></div>
<div id="accordion">
<s:form id="processdata" action="draft-graduate" method="post">
<s:hidden name="announcementId" value="%{announcement.id}" />
<table class="table-responsive">
    <colgroup>
			<col />
		</colgroup>
        <tr>
            <td>
            	<s:submit cssClass="btn btn-primary pull-right" value="Continue Editing" />
            	<s:if test="cdoGraduateApplication!=null && cdoGraduateApplication.submissionStatus==@org.iita.trainingunit.applications.model.Application$SUBMISSIONSTATUS@Draft">
           			 &nbsp;&nbsp; <s:submit cssClass="btn btn-primary pull-right col-md-offset-2" action="process-graduate" value="Submit Application" onclick="if(confirm('Submit your application form anyway?')){return true;}else{return false;}" />  &nbsp;&nbsp;
            	</s:if>
            	<div class="clearfix">&nbsp;</div>
            </td>
        </tr>
</table>


<s:if test="cdoGraduateApplication!=null">
	<s:hidden name="applicationId" value="%{cdoGraduateApplication.id}" />
	<s:hidden name="cdoGraduateApplication.version" value="%{cdoGraduateApplication.version}" />
</s:if>
<%--
<s:include value="/WEB-INF/jsp/include/educationandtraining-form.jsp" />

<s:include value="/WEB-INF/jsp/include/previouseducationandtraining-form.jsp" />

<s:include value="/WEB-INF/jsp/include/otherstudiesandtraining-form.jsp" />

<s:include value="/WEB-INF/jsp/include/employmenthistory-form.jsp" />

<s:include value="/WEB-INF/jsp/include/previousemploymenthistory-form.jsp" />

<s:include value="/WEB-INF/jsp/include/spokenlanguage-form.jsp" />--%>

<s:include value="/WEB-INF/jsp/include/projectsummary-form.jsp" />

<s:include value="/WEB-INF/jsp/include/timeschedule-form.jsp" />

<s:include value="/WEB-INF/jsp/include/milestone-form.jsp" />

<s:include value="/WEB-INF/jsp/include/supporttype-form.jsp" />

<%--
<s:include value="/WEB-INF/jsp/include/research-form.jsp" />

<s:include value="/WEB-INF/jsp/include/cdoreg-related-form.jsp" />

<s:include value="/WEB-INF/jsp/include/cdoapp-location-form.jsp" />	
 --%>
<table class="table-responsive">
    <colgroup>
			<col />
		</colgroup>
        <tr>
            <td>
            	<s:submit cssClass="btn btn-primary pull-right" value="Continue Editing" />
            	<s:if test="cdoGraduateApplication!=null && cdoGraduateApplication.submissionStatus==@org.iita.trainingunit.applications.model.Application$SUBMISSIONSTATUS@Draft">
           			<s:submit cssClass="btn btn-primary pull-right col-md-offset-2" action="process-graduate" value="Submit Application" onclick="if(confirm('Submit your application form anyway?')){return true;}else{return false;}" />
            	</s:if>
            	<div class="clearfix">&nbsp;</div>
            </td>
        </tr>
</table>
</s:form>
<div class="clearfix">&nbsp;</div>
</div> 


</div>

<div class="col col-sm-3 pull-right">
		<s:include value="/WEB-INF/jsp/include/personal-data.jsp" />
		<s:if test="cdoGraduateApplication.id!=null">
			<table class="table">
			    <colgroup>
						<col />
					</colgroup>
				        <tr>
				            <td>
				            	<h2>Application documents</h2>
								<s:if test="cdoGraduateApplication.documents!=null">
									<ul class="file-list">
										<s:iterator value="cdoGraduateApplication.documents">
											<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-applicant-quick.jsp" /></li>
										</s:iterator>
									</ul>
								</s:if>
								<p>Attach document to application:</p>
								<iita:fileupload action="application-document!upload" value="Upload files" queryParams="entityId=${cdoGraduateApplication.id}" />
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