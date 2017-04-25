<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Training Unit Application: Welcome to IYA Portal</title>
<style type="text/css">
	.home-title {
		text-align: left;
  		font-size: 35px;
  		font-family: sans-serif;
  		color: olive;
  		padding-bottom: 20px;
	}
	.ticker-link {
		font-size: x-large;
  		color: #999999;
  		font-family: monospace;
  		text-decoration: underline;
  		font-weight: bold;
  		!important;
	}
	
	/* .col-sm-6 { float: left; text-align:left; padding-left:75px; !important;}
	
	.col-sm-6 img {padding-left: 10px;} */
	
	.search-box { margin-left:75px; !important;}
	
	.yearselect { text-align:left; !important;}
	
	.top-buffer { margin-top:20px; }
	
	.hideDiv {display: none;}
</style>
</head>
<body>
<div class="container">
<div class="col-sm-12">
	    	<div class="col-sm-9">    	
		        <div class="col-sm-12 alert alert-warning">
		            <strong>Notice: </strong>This system holds tracks of all training information in the institute. You are advised to go through the procedures for information on proper use of the system. Use the system accordingly and contact <a href="mailto:iita-trainingunit@cgiar.org">IITA-TrainingUnit@cgiar.org</a> on any ambiguities.
		        </div>
	       	</div>
	       	
	       	<div class="col-sm-3">
		        <div class="col-sm-12 alert alert-info">
		            <a class="btn btn-primary" href="<s:url namespace="/iya" action="announcement" />">Add Announcement</a> 
					<a class="btn btn-info" href="<s:url namespace="/iya" action="register" />">Training Registration</a>
		        </div>
	        </div>
</div>

	<div class="col-sm-6 container">
	  <h2>Announcements</h2>
	  <div class="panel panel-default">
	    <div class="panel-body">
	      <div class="row">
	        <div class="col-md-12">
	          <table class="table">
	            <thead>
	              <tr>
	                <th>#</th>
	                <th>Organizer</th>
	                <th>Sponsor</th>
	                <th>Training Course/module</th>
	              </tr>
	            </thead>
	            <tbody>
	            	<s:if test="iyaAnnouncements.size>0">
		            	<s:iterator value="iyaAnnouncements" status="status">
						<tr>
							<td><s:property value="#status.count" />.</td>
			                <td><s:property value="organizer" /></td>
			                <td><s:property value="sponsor" /></td>
			                <td><a href="<s:url namespace="/iya" action="announcement/view" />?id=<s:property value="id" />"><iita:text value="trainingCourse" maxLength="80" addDots="true" /></a></td>
			              </tr>
		              	</s:iterator>
	              	</s:if>
	              	<s:else>
	              		<tr>
							<td colspan="4">
								<em>No announcements found!</em>
							</td>
						</tr>
	              	</s:else>
	              	<s:if test="iyaAnnouncements.size>1">
	              		<tr>
	              			<td colspan="4">
	              				<div class="pull-right"><a href="<s:url namespace="/iya" action="announcements" />">View All &raquo;</a></div>
	              			</td>
	              		</tr>
	              	</s:if>
	            </tbody>
	          </table>
	        </div>
		   </div>
		   
		</div>
	  </div>
	</div>
	
	
	<div class="col-sm-6 container">
	  <h2>Registrations</h2>
	  <div class="panel panel-default">
	    <div class="panel-body">
	      <div class="row">
	        <div class="col-md-12">
	          <table class="table">
	            <thead>
	              <tr>
	                <th>#</th>
	                <th>FullName</th>
	                <th>Address</th>
	                <th>Qualification</th>
	              </tr>
	            </thead>
	            <tbody>
	              <s:if test="iyaRegistrations.size>0">
		            	<s:iterator value="iyaRegistrations" status="status">
						<tr>
							<td><s:property value="#status.count" />.</td>
			                <td><a href="<s:url namespace="/iya" action="registration/view" />?id=<s:property value="id" />"><s:property value="fullName" /></a></td>
			                <td><s:property value="fullAddress" /></td>
			                <td><s:property value="qualification" /></td>
			              </tr>
		              	</s:iterator>
	              	</s:if>
	              	<s:else>
	              		<tr>
							<td colspan="4">
								<em>No registrations found!</em>
							</td>
						</tr>
	              	</s:else>
	              	<s:if test="iyaRegistrations.size>1">
	              		<tr>
	              			<td colspan="4">
	              				<div class="pull-right"><a href="<s:url namespace="/iya" action="registrations" />">View All &raquo;</a></div>
	              			</td>
	              		</tr>
	              	</s:if>
	            </tbody>
	          </table>
	        </div>
		   </div>
		   
	    </div>
	  </div>
	</div>
</div>
</body>
</html>