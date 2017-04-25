<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html lang="en">
<head>
    <title>Bio-Data Update Form</title>
</head>
<body>

<div class="container-fluid">
<div class="myapp-bar">
	<h3>Fill your bio-data information below before proceeding to submitting your pending application.</h3>
</div>
<div class=" col col-sm-8">
	<h2>Personal Information for: <s:property value="cdoBioData.fullName" /></h2>

	<s:form action="biodata-update!update" method="POST">
	<table class="inputform">
	    <colgroup>
				<col />
			</colgroup>
	        <tr>
	            <td>
	            <s:submit cssClass="btn btn-primary pull-right" value="Save Bio-Data" onclick="javascript: return confirm('Update bio-data anyway?');" /> 
	            </td>
	        </tr>
	    </table>
	<s:hidden name="id" value="%{cdoBioData.id}" />
	<s:hidden name="cdoBioData.version" value="%{cdoBioData.version}" />
	<div><em>* <font style="color:#ff0000">means mandatory fields</font></em></div>
	<div id="accordion">
	
	<s:if test="cdoBioData.id!=null" >
		<s:include value="/WEB-INF/jsp/include/biodata-form.jsp" />
	
		<s:include value="/WEB-INF/jsp/include/nextofkin-form.jsp" />
	
		<s:include value="/WEB-INF/jsp/include/educationandtraining-form.jsp" />
	
		<s:include value="/WEB-INF/jsp/include/previouseducationandtraining-form.jsp" />
		
		<s:include value="/WEB-INF/jsp/include/otherstudiesandtraining-form.jsp" />
		
		<s:include value="/WEB-INF/jsp/include/employmenthistory-form.jsp" />
		
		<s:include value="/WEB-INF/jsp/include/previousemploymenthistory-form.jsp" />
		
		<s:include value="/WEB-INF/jsp/include/spokenlanguage-form.jsp" />
	</s:if>
	</div> 
	
	<table class="inputform">
	    <colgroup>
				<col />
			</colgroup>
	        <tr>
	            <td>
	            <s:submit cssClass="btn btn-primary pull-right" value="Save Bio-Data" onclick="javascript: return confirm('Update bio-data anyway?');" /> 
	            </td>
	        </tr>
	    </table>
	</s:form>
</div>

<div class="col col-sm-3 pull-right">
	<s:include value="/WEB-INF/jsp/include/personal-data.jsp" />
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