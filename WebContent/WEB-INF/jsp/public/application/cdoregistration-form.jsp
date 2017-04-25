<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html lang="en">
<head>
    <title>Training Registration</title>
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
		    	var i = i = j("#childrenTable input:last").find("input").length;
		        j("#childrenTable tr:last").clone().find("input").each(function() {
		        	i++;
		        	j(this).val('').attr('name', 'cdoApplication.biodata.applicantsChildren['+i+'].childName');
		            j(this).val('').attr('name', 'cdoApplication.biodata.applicantsChildren['+i+'].dateOfBirth');
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

</body>
</html>