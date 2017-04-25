<%@ include file="/common/taglibs.jsp"%>

<s:if test="announcement.trainingLocations.size()>0">
<table class="inputform">
    <colgroup>
		<col width="200px" />
		<col />
	</colgroup>
   <tr>
        <td></td>
        <td>
			<h3>TRAINING LOCATIONS</h3>
			<div><em>Check your preferred location for this training application</em></div>
			<div>
				<div>
				    <table class="inputform" id="childrenTable">
				    <colgroup>
						<col width="3%" />
						<col width="20%" />
						<col width="30%" />
						<col />
					</colgroup>
					<tr>
						<td />
						<td><strong>Country</strong></td>
						<td><strong>Venue</strong></td>
						<td><strong>Start - End Dates</strong></td>
					</tr>
					<s:iterator value="announcement.trainingLocations" status="status">
						<s:set name="locIndex" value="#status.index" />
						<s:set name="announceLocId" value="id" />
						<tr>
							<td align="right">
								<s:checkbox name="selectedLocations" fieldValue="%{id}" value="%{id in selectedLocations}"></s:checkbox>
							</td>
							<td><s:property value="country" /></td>
			                <td><s:property value="venue" /></td>
			                <td><s:property value="startDate" /> - <s:property value="endDate" /> (<s:property value="duration" />)</td>
			            </tr>
					</s:iterator>
				    </table>
				</div>
			</div>
		</td>
    </tr>
</table>
</s:if>
