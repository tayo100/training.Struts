<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html lang="en">
<head>
    <title>Non Graduate Registration</title>
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
	<s:include value="/WEB-INF/jsp/include/nondegree/biodata-form.jsp" />
</s:if>
<s:else>
	<s:include value="/WEB-INF/jsp/include/nondegree/biodata-exist-form.jsp" />
</s:else>

<s:include value="/WEB-INF/jsp/include/nondegree/spokenlanguages-form.jsp" />

<s:include value="/WEB-INF/jsp/include/nondegree/children-form.jsp" />

<s:include value="/WEB-INF/jsp/include/nondegree/nextofkin-form.jsp" />

<s:include value="/WEB-INF/jsp/include/nondegree/educationandtraining-form.jsp" />

<s:include value="/WEB-INF/jsp/include/nondegree/employmenthistory-form.jsp" />

<s:include value="/WEB-INF/jsp/include/nondegree/research-form.jsp" />

<s:include value="/WEB-INF/jsp/include/nondegree/duties-form.jsp" />

<s:include value="/WEB-INF/jsp/include/nondegree/constraints-form.jsp" />

<s:include value="/WEB-INF/jsp/include/nondegree/previoustraining-form.jsp" />

<s:include value="/WEB-INF/jsp/include/nondegree/languagespoken.jsp" />

<s:include value="/WEB-INF/jsp/include/nondegree/goalsandobjectives.jsp" />

<s:include value="/WEB-INF/jsp/include/nondegree/institutionorsponsor.jsp" />

<s:include value="/WEB-INF/jsp/include/nondegree/trainingsupport.jsp" />

<s:include value="/WEB-INF/jsp/include/nondgree/cdoreg-related-form.jsp" />

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
</body>
</html>