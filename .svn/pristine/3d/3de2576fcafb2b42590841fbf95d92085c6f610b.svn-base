<%@ include file="/common/taglibs.jsp"%>

<s:property value="application.locations.size" />
KENNETH
<s:if test="application.locations.size()>0">
<table class="data-listing">
    <colgroup>
		<col width="200px" />
		<col />
	</colgroup>
   <tr>
        <td></td>
        <td>
			<h3>TRAINING LOCATIONS</h3>
			<div><em>Applicant's chosen training location(s)</em></div>
			<div>
				<div>
				    <table class="inputform" id="applicantLocTable">
				    <colgroup>
						<col width="20%" />
						<col width="30%" />
						<col />
					</colgroup>
					<tr>
						<td><strong>Country</strong></td>
						<td><strong>Venue</strong></td>
						<td><strong>Start - End Dates</strong></td>
					</tr>
					<s:iterator value="application.locations" status="status">
						<s:set name="locIndex" value="#status.index" />
						<s:set name="appLocId" value="id" />
						<tr>
							<td><s:property value="trainingLocation.country" /></td>
			                <td><s:property value="trainingLocation.venue" /></td>
			                <td><s:property value="trainingLocation.startDate" /> - <s:property value="trainingLocation.endDate" /> (<s:property value="trainingLocation.duration" />)</td>
			            </tr>
					</s:iterator>
				    </table>
				</div>
			</div>
		</td>
    </tr>
</table>
</s:if>
