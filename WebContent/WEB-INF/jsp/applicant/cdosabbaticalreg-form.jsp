<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html lang="en">
<head>
    <title>Sabbatical Training Application</title>
</head>
<body>
<div class="container-fluid">

<div class=" col col-sm-8">
	<h2>Application for: <s:property value="announcement.title" /></h2>
	
	
	<div><em>* <font style="color:#ff0000">means mandatory fields</font></em></div>
	<div id="accordion">
	<s:form id="processdata" action="draft-sabbatical" method="post">
	<s:hidden name="announcementId" value="%{announcement.id}" />
	<s:if test="cdoSabbaticalApplication!=null">
		<s:hidden name="applicationId" value="%{cdoSabbaticalApplication.id}" />
	</s:if>
	<div class="row">
		<div class="col-xs-6 col-md-6">
		   	<label for="activityType" class="col-xs-12">Type of Activity</label>
		   	<s:radio id="activityType" value="%{cdoSabbaticalApplication.activityType}" name="cdoSabbaticalApplication.activityType" 
		   	list="#{'Sabbatical':'Sabbatical','Visiting Position':'Visiting Position', 'Other':'Other'}" />
		</div>
		<div class="col-xs-6 col-md-6">
	       	<label for="specifyOther" class="col-xs-12">If Other, Please Specify</label>
	       	<s:textfield cssClass="form-control" id="specifyOther" value="%{cdoSabbaticalApplication.specifyOther}" name="cdoSabbaticalApplication.specifyOther" />
		</div>
	</div>
	
	<h2>PART I - ADMINISTRATIVE INFORMATION</h2>
	
	<s:include value="/WEB-INF/jsp/include/sabbatical-administrativeexperience-form.jsp" />
	
	<s:include value="/WEB-INF/jsp/include/sabbaticalprojectsummary-form.jsp" />
	
	<s:include value="/WEB-INF/jsp/include/sabbatical-supporttype-form.jsp" />
	
	<table class="inputform">
	    <colgroup>
				<col width="200px" />
				<col />
			</colgroup>
	        <tr>
	            <td></td>
	            <td>
	            	<s:submit cssClass="btn btn-primary pull-right" value="Continue Editing" /> 
	            	<s:if test="cdoSabbaticalApplication!=null && cdoSabbaticalApplication.submissionStatus==@org.iita.trainingunit.applications.model.Application$SUBMISSIONSTATUS@Draft">
	           			<s:submit cssClass="btn btn-primary pull-right" action="process-sabbatical" value="Submit Form" onclick="if(confirm('Submit your application form anyway?')){return true;}else{return false;}" />
	            	</s:if>
	            </td>
	        </tr>
	</table>
	</s:form>
	<div class="clearfix">&nbsp;</div>
	</div> 
</div>

<div class="col col-sm-3 pull-right">
				<s:include value="/WEB-INF/jsp/include/personal-data.jsp" />
				
				<s:if test="cdoSabbaticalApplication!=null">
					<table class="inputform">
					    <colgroup>
							<col />
						</colgroup>        
						<tr>
							<td>
								<s:if test="cdoSabbaticalApplication.documents!=null">
						    		<h2>Application documents</h2>
									<ul class="file-list">
										<s:iterator value="cdoSabbaticalApplication.documents">
											<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-applicant-quick.jsp" /></li>
										</s:iterator>
									</ul>
								</s:if>
										
								<s:if test="cdoSabbaticalApplication.id!=null">
									<p>Attach document to application:</p>
									<iita:fileupload action="application-document!upload" cssClass="btn btn-primary" value="Upload files" queryParams="entityId=${cdoSabbaticalApplication.id}" />
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