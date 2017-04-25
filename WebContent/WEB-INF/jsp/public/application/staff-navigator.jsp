<%@ include file="/common/taglibs.jsp" %>

<s:form id="staffproceedreg" action="staffreg" method="post">
<s:hidden name="announcementId" value="%{announcement.id}" />
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
<h3>Staff Application</h3>
<i>If you a staff of IITA, enter your Staff ID and Email for swift registration.</i>
<div>
    <div>
    	<table class="inputform">
        <colgroup>
			<col width="200px" />
			<col />
		</colgroup>
            <tr>
                <td>Staff ID: *</td>
                <td><s:textfield name="staffId" /></td>
            </tr>
            <tr>
                <td>Email: *</td>
                <td><s:textfield name="email" /></td>
            </tr>
            <tr>
	            <td></td>
	            <td><s:submit value="Continue registration" onclick="if(confirm('Proceed to registration anyway?')){return true;}else{return false;}" /></td>
	        </tr>
        </table>
    </div>
</div>
</div>
</s:form>