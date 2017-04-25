<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Announcement: <s:property value="announcement.title" /></title>

<script type="text/javascript">
	$(document).ready(function(){
	    $('input.bosdate').datepicker({format: 'dd/mm/yyyy', autoclose: true, todayHighlight: true});
	});
</script>

</head>
<body>
	<table class="data-listing">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tbody>
			<tr>
				<td>Type:</td>
				<td><s:property value="announcement.type" /></td>
			</tr>
			<tr>
				<td>Title:</td>
				<td><s:property value="announcement.title" /></td>
			</tr>
			<tr>
				<td>Introduction:</td>
				<td><iita:text value="announcement.introduction"
						maxLength="1500" /></td>
			</tr>
			<tr>
				<td>Target Group:</td>
				<td><iita:text value="announcement.targetGroup"
						maxLength="1500" /></td>
			</tr>
			<tr>
				<td>Objective:</td>
				<td><iita:text value="announcement.objective" maxLength="1500" />
				</td>
			</tr>
			<tr>
				<td>Learning Method:</td>
				<td><iita:text value="announcement.learningMethod"
						maxLength="1500" /></td>
			</tr>
			<tr>
				<td>Expected Outcome:</td>
				<td><iita:text value="announcement.expectedOutcome"
						maxLength="1500" /></td>
			</tr>
			<tr>
				<td>Course Contents:</td>
				<td><iita:text value="announcement.courseContents"
						maxLength="1500" /></td>
			</tr>
			<tr>
				<td>Training Fee:</td>
				<td>
					<s:if test="announcement.trainingFee!=null">
						<s:text name="format.money">
							<s:param value="announcement.trainingFee" />
						</s:text> USD
					</s:if>
				</td>
			</tr>
			<tr>
				<td>Accommodation:</td>
				<td><iita:text value="announcement.accommodation"
						maxLength="1500" /></td>
			</tr>
			<tr>
				<td>Payment:</td>
				<td><iita:text value="announcement.payment" maxLength="1500" />
				</td>
			</tr>
			<tr>
				<td>Deadline:</td>
				<td><s:property value="announcement.deadline" /></td>
			</tr>
		</tbody>
	</table>
	<h3>LOCATION/VENUE INFORMATION</h3>
	<div>
		<div>
		    <table class="inputform" id="educationTable">
		    <colgroup>
				<col width="200px" />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tr>
				<td />
				<td>Country</td>
				<td>Location/Venue</td>
				<td>Started</td>
				<td>Ended</td>
				<td>Duration</td>
			</tr>
			<s:iterator value="announcement.trainingLocations" status="status">
				<s:set name="locIndex" value="#status.index" />
				<tr>
					<td></td>
					<td><s:property value="country" /></td>
					<td><s:property value="venue" /></td>
	                <td><input class="bosdate" name="startDate" type="text"></td>
	                <td><input class="bosdate" name="endDate" type="text"></td>
	                <td><s:property value="duration" /></td>
	            </tr>
			</s:iterator>
		    </table>
		</div>
	</div>
</body>
</html>