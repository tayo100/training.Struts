<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html lang="en">
<head>
    <title>Training Registration</title>
</head>
<body>
<h2>Registration for: <s:property value="project.trainingTitle" /></h2>

<s:form id="processdata" action="process-register" method="post">
<s:hidden name="projectId" value="%{project.id}" />
<s:hidden name="regOption" value="%{regOption}" />
<s:hidden name="refNumber" value="%{refNumber}" />
<s:if test="projectApplication!=null">
	<s:hidden name="applicationId" value="%{projectApplication.id}" />
</s:if>
<div><em>* <font style="color:#ff0000">means mandatory fields</font></em></div>
<div id="accordion">

<s:if test="cdoBioData==null && (regOption=='New' || regOption=='Edit')">
	<s:include value="/WEB-INF/jsp/include/biodata-form.jsp" />
</s:if>
<s:else>
	<s:include value="/WEB-INF/jsp/include/biodata-exist-form.jsp" />
</s:else>

<s:include value="/WEB-INF/jsp/include/spokenlanguages-form.jsp" />

<s:include value="/WEB-INF/jsp/include/children-form.jsp" />

<s:include value="/WEB-INF/jsp/include/nextofkin-form.jsp" />

<s:include value="/WEB-INF/jsp/include/educationandtraining-form.jsp" />

<s:include value="/WEB-INF/jsp/include/employmenthistory-form.jsp" />

<s:include value="/WEB-INF/jsp/include/cdoreg-related-form.jsp" />

</div> 

<table class="inputform">
    <colgroup>
			<col width="200px" />
			<col />
		</colgroup>
        <tr>
            <td></td>
            <td><s:submit action="process-draft" value="Save Draft & Continue" /> <s:submit value="Submit Form" onclick="if(confirm('Submit your form anyway?')){return true;}else{return false;}" /></td>
        </tr>
    </table>
</s:form>

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