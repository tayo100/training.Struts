<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html lang="en">
<head>
    <title>Internship Application</title>
</head>
<body>

<div class="col col-sm-8">

<h2>Application for: <s:property value="announcement.title" /></h2>


<div><em>* <font style="color:#ff0000">means mandatory fields</font></em></div>
<div id="accordion">
<s:form id="processdata" action="draft-internship" method="post">
<s:hidden name="announcementId" value="%{announcement.id}" />
<table class="table-responsive">
    <colgroup>
			<col />
		</colgroup>
        <tr>
            <td>
            	<s:submit cssClass="btn btn-primary pull-right" value="Continue Editing" />
            	<s:if test="cdoInternshipApplication!=null && cdoInternshipApplication.submissionStatus==@org.iita.trainingunit.applications.model.Application$SUBMISSIONSTATUS@Draft">
           			 <s:submit cssClass="btn btn-primary pull-right col-md-offset-2" action="process-graduate" value="Submit Application" onclick="if(confirm('Submit your application form anyway?')){return true;}else{return false;}" />
            	</s:if>
            	<div class="clearfix">&nbsp;</div>
            </td>
        </tr>
</table>


<s:if test="cdoInternshipApplication!=null">
	<s:hidden name="applicationId" value="%{cdoInternshipApplication.id}" />
	<s:hidden name="cdoInternshipApplication.id" value="%{cdoInternshipApplication.id}" />
</s:if>

<s:include value="/WEB-INF/jsp/include/internshipeducationandexperience-form.jsp" />

<s:include value="/WEB-INF/jsp/include/internshipworkexperience-form.jsp" />

<s:include value="/WEB-INF/jsp/include/spokenlanguage-form.jsp" />

<s:include value="/WEB-INF/jsp/include/internship-supporttype-form.jsp" />

<table class="table-responsive">
    <colgroup>
			<col />
		</colgroup>
        <tr>
            <td>
            	<s:submit cssClass="btn btn-primary pull-right" value="Continue Editing" />
            	<s:if test="cdoInternshipApplication!=null && cdoInternshipApplication.submissionStatus==@org.iita.trainingunit.applications.model.Application$SUBMISSIONSTATUS@Draft">
           			 &nbsp;&nbsp; <s:submit cssClass="btn btn-primary pull-right col-md-offset-2" action="process-graduate" value="Submit Application" onclick="if(confirm('Submit your application form anyway?')){return true;}else{return false;}" />  &nbsp;&nbsp;
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
		<s:if test="cdoInternshipApplication.id!=null">
			<table class="table">
			    <colgroup>
						<col />
					</colgroup>
				        <tr>
				            <td>
				            	<h2>Application documents</h2>
								<s:if test="cdoInternshipApplication.documents!=null">
									<ul class="file-list">
										<s:iterator value="cdoInternshipApplication.documents">
											<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-applicant-quick.jsp" /></li>
										</s:iterator>
									</ul>
								</s:if>
								<p>Attach document to application:</p>
								<iita:fileupload action="application-document!upload" value="Upload files" queryParams="entityId=${cdoInternshipApplication.id}" />
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

</body>
</html>