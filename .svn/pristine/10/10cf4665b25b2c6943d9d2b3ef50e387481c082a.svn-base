<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<style type="text/css">

.singleColumn{ padding-left: 5px; font-weight:normal;}
.lr{float:left; width:100%}
</style>
</head>
<body>

<div>
	<div>
	    <table id="locTable" class="table">
	    	<colgroup>
	    		<col />
	    		<col />
	    	</colgroup>
	    	<tr>
				<td>
					<label for="projectname" class="col-xs-12"><strong>Project/Unit Name</strong></label>
			    </td>
			    <td>
			        <s:property id="projectname" value="application.projectName" />     
		       </td>
		       <td>     
					<label for="topic" class="col-xs-6"><strong>Topic</strong></label>
				</td>
			    <td>
				    <s:property id="topic" value="application.trainingTopic" />
				</td>
			    <td>
				    <label for="group" class="col-xs-6"><strong>Target Group</strong></label>
				</td>
			    <td>            
				    <s:property id="address" value="application.trainingGroup" />
				</td>
			    <td>
		            <label for="objectives" class="col-xs-6"><strong>Objectives</strong></label>
				</td>
			    <td>           
					<s:property id="objectives" value="application.objectives" />
				</td>
			    <td>
			    	<label for="resources" class="col-xs-6"><strong>Curricular/Resources</strong></label>
				</td>
			    <td>
					<s:property id="resources" value="application.resources" />
				</td>
			    <td>
		            <label for="outputs" class="col-xs-12"><strong>Outputs/Results</strong></label>
			    </td>
			    <td>
			        <s:property id="outputs" value="application.outputs" />     
			    </td>
			</tr>
	    </table>
	</div>
</div>
<h3>Scheduled Training Dates and Locations</h3>
<div>
	<table id="dateScehdulerTable" class="table">
	    <tr>
	    	<td>
	    		<label class="col-xs-12">Country</label>
			</td>
			<td>
			    <label class="col-xs-12">Venue</label>
			</td>
			<td>            
			    <label class="col-xs-12">Start date</label>
			</td>
			<td>
			    <label class="col-xs-12">End date </label>
	    	</td>
	    </tr>
		<s:iterator value="application.locations" status="status">
			<s:set name="locIndex" value="#status.index" />
			<tr>
				<td>
					<s:property value="country" />
				</td>
			    <td>
			    	<s:property value="venue" />
				</td>
			    <td>
			    	<iita:date format="dd/MM/yyyy" name="startDate" />
			    </td>
			    <td>
			    	<iita:date format="dd/MM/yyyy" name="endDate" />
				</td>
			</tr>
		</s:iterator>
	</table>
</div>
</body>
</html>