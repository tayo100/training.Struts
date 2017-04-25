<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>CDO Registration Continuation</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/script/tabbedjs/lightness/jquery-ui-1.10.4.custom.min.css'/>" />
<script type="text/javascript" src="<c:url value='/script/tabbedjs/js/jquery-1.10.2.js'/>"></script>
<script type="text/javascript" src="<c:url value='/script/tabbedjs/js/jquery-ui-1.10.4.custom.min.js'/>"></script>
</head>
<body>
<s:form id="proceedreg" action="resume" method="post">
<div><em>* <font style="color:#ff0000">means mandatory fields</font></em></div>
<div id="accordion">
<h3>BIODATA REGISTRATION NAVIGATOR</h3>
<div>
    <div>
    	<table class="inputform">
        <colgroup>
			<col width="200px" />
			<col />
		</colgroup>
            <tr>
                <td><label>Application Key: *</label></td>
                <td><s:textfield name="appKey" /></td>
            </tr>
            <tr>
                <td><label>Email: *</label></td>
                <td><s:textfield name="email" /></td>
            </tr>
            <tr>
	            <td></td>
	            <td><s:submit value="Continue editing" onclick="if(confirm('Proceed to registration anyway?')){return true;}else{return false;}" /></td>
	        </tr>
        </table>
    </div>
</div>
</div>
</s:form>
</body>
</html>