<%@ include file="/common/taglibs.jsp"%>

<h3>OTHER APPLICATION INFORMATION</h3>
<div>
    <div>
        <table class="inputform">
        <colgroup>
			<col width="200px" />
			<col />
		</colgroup>
            
            <tr>
                <td>Estimated Start Date: </td>
                <td><iita:datepicker name="cdoApplication.otherAppDetails.startDate" value="%{cdoApplication.otherAppDetails.startDate}" cssClass="datepicker" /></td>
            </tr>
            
        </table>
    </div>
</div>