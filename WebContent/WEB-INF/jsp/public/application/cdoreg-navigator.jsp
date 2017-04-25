<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>CDO Registration navigator</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/script/tabbedjs/lightness/jquery-ui-1.10.4.custom.min.css'/>" />
<script type="text/javascript" src="<c:url value='/script/tabbedjs/js/jquery-1.10.2.js'/>"></script>
<script type="text/javascript" src="<c:url value='/script/tabbedjs/js/jquery-ui-1.10.4.custom.min.js'/>"></script>
</head>
<body>
<h2>Registration for: <s:property value="announcement.title" /> in <s:property value="announcement.type" /></h2>
<s:form id="proceedreg" action="proceed-register" method="post">
<input type="hidden" name="announcementId" value="<s:property value="announcement.id" />" />
<div><em>* <font style="color:#ff0000">means mandatory fields</font></em></div>
<div id="accordion">
<h3>REGISTRATION NAVIGATOR</h3>
<div>
    <div>
    	<table class="inputform">
        <colgroup>
			<col width="200px" />
			<col />
		</colgroup>
            <tr>
                <td></td>
                <td><s:radio name="regOption" value="%{regOption}" 
                list="#{'New':'Fresh Registration','Exist':'New Registration with my Existing Bio-data'
                ,'Edit':'Continue with Existing Registration'}" />
                </td>
            </tr>
            <tr>
                <td><label>Enter your existing Reference Number:</label></td>
                <td><s:textfield name="refNumber" value="%{refNumber}" />
                </td>
            </tr>
            <tr>
                <td><label>Email:</label></td>
                <td><s:textfield name="email" value="%{email}" /><br/>
                <div><em><font style="color:#ff0000">NB: Your bio-data is valid for only 2 years in our system.</font></em></div>
                </td>
            </tr>
            <tr>
	            <td></td>
	            <td><s:submit value="Proceed Form" onclick="if(confirm('Proceed to registration anyway?')){return true;}else{return false;}" /></td>
	        </tr>
        </table>
    </div>
</div>
</div>
</s:form>
</body>
</html>