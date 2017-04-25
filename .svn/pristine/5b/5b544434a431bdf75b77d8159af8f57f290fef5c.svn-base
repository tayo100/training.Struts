<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html lang="en">
<head>
    <title>Training Registration</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/script/tabbedjs/lightness/jquery-ui-1.10.4.custom.min.css'/>" />
    <script type="text/javascript" src="<c:url value='/script/tabbedjs/js/jquery-ui-1.10.4.custom.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/script/tabbedjs/js/jquery-1.10.2.js'/>"></script>
    <script type="text/javascript">
    	var j = jQuery.noConflict();
    	
    	//<![CDATA[ 
	    j(window).load(function(){// onclick="javascript: copyLanguages($($(this).parentNode.parentNode).previous(), 3, 0); return false;
		    //var i = 1;
		    j("#copyLanguage").click(function() {
		    	var i = i = j("#languageTable > tr").find("select").index();
		        j("#languageTable tr:last").clone().find("input, select").each(function() {
		        	i++;
		            j(this).val('').attr('name', 'cdoApplication.biodata.languageSpoken['+i+'].language');
		        }).end().appendTo("#languageTable");
		        i++;
		    });
		    
		    j("#copyChildren").click(function() {
		    	var i = j("#childrenTable tr:last").find("tr").length;
		        j("#childrenTable tr:last").clone().find("input").each(function() {
		        	i++;
		        	alert("i: " + i);
		        	j(this).val('').attr('name', 'cdoApplication.biodata.applicantsChildren['+i+'].childName');
		        	j(this).val('').attr('id', 'cdoApplication.biodata.applicantsChildren['+i+'].childName');
		            j(this).val('').attr('name', 'cdoApplication.biodata.applicantsChildren['+i+'].dateOfBirth');
		            j(this).val('').attr('id', 'cdoApplication.biodata.applicantsChildren['+i+'].dateOfBirth');
		        }).end().appendTo("#childrenTable");
		        i++;
		    });
		    
		    j("#copyEducation").click(function() {
		    	var i = i = j("#educationTable input:last").find("input, select").length;
		        j("#educationTable tr:last").clone().find("input").each(function() {
		        	i++;
		        	j(this).val('').attr('name', 'cdoApplication.biodata.educationAndTraining['+i+'].nameOfInstitution');
		            j(this).val('').attr('name', 'cdoApplication.biodata.educationAndTraining['+i+'].majorFieldOfStudy');
		            j(this).val('').attr('name', 'cdoApplication.biodata.educationAndTraining['+i+'].certificateObtained');
		            j(this).val('').attr('name', 'cdoApplication.biodata.educationAndTraining['+i+'].startMonthOfCertification');
		            j(this).val('').attr('name', 'cdoApplication.biodata.educationAndTraining['+i+'].stopMonthOfCertification');
		        }).end().appendTo("#educationTable");
		        i++;
		    });
		    
		    j("#copyEmployment").click(function() {
		    	var i = i = j("#employmentTable input:last").find("input, select").length;
		        j("#employmentTable tr:last").clone().find("input").each(function() {
		        	i++;
		        	j(this).val('').attr('name', 'cdoApplication.biodata.employmentHistory['+i+'].nameOfEmployer');
		            j(this).val('').attr('name', 'cdoApplication.biodata.employmentHistory['+i+'].addressOfEmployer');
		            j(this).val('').attr('name', 'cdoApplication.biodata.employmentHistory['+i+'].jobTitle');
		            j(this).val('').attr('name', 'cdoApplication.biodata.employmentHistory['+i+'].appointedOn');
		            j(this).val('').attr('name', 'cdoApplication.biodata.employmentHistory['+i+'].exitedOn');
		        }).end().appendTo("#employmentTable");
		        i++;
		    });
	    });//]]>
    </script>
</head>
<body>
<h2>Registration for: <s:property value="announcement.title" /> in <s:property value="announcement.type" /></h2>

<s:form id="processdata" action="process-register" method="post">
<s:hidden name="announcementId" value="%{announcement.id}" />
<s:hidden name="regOption" value="%{regOption}" />
<s:hidden name="refNumber" value="%{refNumber}" />
<s:if test="cdoApplication!=null">
	<s:hidden name="applicationId" value="%{cdoApplication.id}" />
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
var jq = jQuery.noConflict();
jq(function () {
	jq(".datepicker").datepicker({ changeMonth: true,
        changeYear: true, dateFormat: 'dd/mm/yy'});
	
	jq(".mthyrpicker").datepicker({ changeMonth: true,
        changeYear: true, dateFormat: 'mm/yy'});
	
    jq(function () {
        jq("#accordion").accordion({
            heightStyle: "content"
        });
    });
});</script>
</body>
</html>