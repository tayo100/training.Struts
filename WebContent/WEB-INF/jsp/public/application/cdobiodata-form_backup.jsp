<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html lang="en">
<head>
    <title>Training Application</title>
</head>
<body>
<div class="container">
<h3>Application for: <s:if test="announcement!=null"><s:property value="announcement.title" /></s:if><s:elseif test="trainingOption!=null"><s:property value="trainingOption" /> Training</s:elseif></h3>
				
	<div class="row-fluid">
		<div class="<s:if test="cdoBioData!=null">col-md-6</s:if><s:else>col-md-12</s:else> alert alert-danger classWithPad">
			<fieldset>
				<legend style="font-weight:bold;font-size:160%">For Non-IITA staff only</legend>
				<div class="alert alert-warning">
					Instructions: Completed application forms should be accompanied by an admission letter from the University, copies of degree and/or diploma certificates, transcripts and two letters of recommendation (one from either your supervisor or head of department)
				</div>		
				<s:form action="savedraft" method="POST" cssClass="form-horizontal">
				<s:hidden name="announcementId" value="%{announcement.id}" />
				<s:hidden name="trainingOption" value="%{trainingOption}" />
				<s:if test="appStarter!=null">
				<s:hidden name="appStarterId" value="%{appStarter.id}" />
				</s:if>
				<s:if test="user!=null">
					<s:hidden name="userPassord" value="%{userPassword}" />
				</s:if>
				<s:hidden name="id" value="%{cdoBioData.id}" />
				<s:hidden name="cdoBioData.version" value="%{cdoBioData.version}" />
				<div><em>* <font style="color:#ff0000">means mandatory fields</font></em></div>
				<div id="accordion">
				
				<s:include value="/WEB-INF/jsp/include/biodata-form.jsp" />
				
				<s:include value="/WEB-INF/jsp/include/nextofkin-form.jsp" />
				
				<s:if test="cdoBioData.id!=null && announcement=='Graduate'" >
					<s:include value="/WEB-INF/jsp/include/spokenlanguages-form.jsp" />
					<s:include value="/WEB-INF/jsp/include/children-form.jsp" />
					<s:include value="/WEB-INF/jsp/include/educationandtraining-form.jsp" />
					<s:include value="/WEB-INF/jsp/include/employmenthistory-form.jsp" />
				</s:if>
				</div> 
				
				<table class="inputform">
				    <colgroup>
							<col width="200px" />
							<col />
						</colgroup>
				        <tr>
				            <td></td>
				            <td>
				            <s:submit value="Save Draft & Continue" /> 
				            <s:if test="user!=null">
				            	<s:submit action="process-register" value="Proceed to registration" onclick="if(confirm('Submit your form and proceed anyway?')){return true;}else{return false;}" />
				            </s:if>
				            </td>
				        </tr>
				    </table>
				</s:form>
			</fieldset>
		</div>
		
		<s:if test="cdoBioData.id==null">
			<div class="col-md-4 alert alert-info classWithPad">
				<fieldset>
					<legend style="font-weight:bold;font-size:160%">For IITA staff only</legend>	
					
					<%-- STAFF IDENTIFIER NAVIGATOR  --%>
					<s:include value="/WEB-INF/jsp/public/application/staff-navigator.jsp" />
				</fieldset>
			</div>
		</s:if>
	</div>
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