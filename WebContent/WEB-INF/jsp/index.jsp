<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Training Unit Application</title>
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
	
	.col-sm-6 { float: left; text-align:left; padding-left:75px; !important;}
	
	.col-sm-6 img {padding-left: 10px;}
	
	.search-box { margin-left:75px; !important;}
	
	.yearselect { text-align:left; !important;}
	
	.top-buffer { margin-top:20px; }
	
	.hideDiv {display: none;}
</style>
</head>
<body>
<div class="notice">
	<p>
		<strong>Notice: </strong>This system holds tracks of all training information in the institute. You are advised to go through the procedures for information on proper use of the system. Use the system accordingly and contact <a href="mailto:iita-trainingunit@cgiar.org">IITA-TrainingUnit@cgiar.org</a> on any ambiguities.
	</p>
</div>
<s:if test="pagedAwaitingApproval.totalHits>0">
	<div class="actionMessage">There are <b><s:property value="pagedAwaitingApproval.totalHits" /></b> application request(s) waiting for your
	approval. <s:if test="pagedAwaitingApproval.TotalHits > 0">
		<input type="button" onClick="javascript: window.location='<s:url action="review" />';" value="Review requests" />
	</s:if></div>
</s:if>
<s:if test="otherPeoplePending!=null && otherPeoplePending.size()>0">
	<div class="actionMessage">
	<b>DELEGATED APPROVAL: </b>
	<s:iterator value="otherPeoplePending.keys">
		<a href="<s:url action="user/delegate!switchuser"><s:param name="email" value="%{mail}"/></s:url>"><s:property value="fullName" /></a> has <b><s:property value="otherPeoplePending[top]" /></b> request(s) awaiting their approval.
	</s:iterator>
	</div>
</s:if>

<table style="width:100%">
	<colgroup><col width="80%"/><col width="20%"/>
	</colgroup>
	<tr>
		<td style="vertical-align: top; padding-right: 30px">
			<div class="container-main"> 
				<div class="row alert alert-info">
					<div class="col-sm-4 home-title top-buffer">
						Procedures ...
					</div>
				    <div class="col-lg-12">
				    	<div class="text-left">
					    	<p>
							The Training database aims to manage all training initiatives centrally, organize all information in a central repository. It will ensure that everyone can access and share information from one place. The database provides information on:
							</p>
							
							<ol>
							<li>Trainees (graduate and short-term term)</li> 
							<li>Training programs, including degree programs, short courses and funding opportunities such as scholarships and fellowships;</li>
							<li>Training materials which include manuals, trainers' guides, textbooks, curricula and other pedagogical tools, and reports. The materials are directly linked to IITA institutional repository where they can be searched.</li>
							</ol>
							
							<p>
							The database is constantly updated and we welcome your contributions on relevant items for inclusion. 
							</p>
							
							<ul>
							<li>To Submit a New Program to the Database, click on New Training Program link and submit your program and materials!</li> 
							<li>To Register a trainee, click on New Trainee link herein!</li> 
							<li>To Submit Training Proposal, click on Request Training Proposal link below!</li> 
							<li>To Produce a Report, click on Advanced Search link and follow the instructions.</li> 
							</ul>
							
							<p>
							For any issues or questions about submitting a program, trainees and printing reports, please contact ...
							</p>
							<p>
							<strong>Note:</strong> Information contained in this database is self-reported by representatives from each unit, project or program.  It may not represent an exhaustive list of training programs.
							</p>
						</div>
					</div><!-- /.col-lg-6 -->
				</div>
				
				<div class="clearfix" style="height:10px; clear: both;"></div>
			    
				 
				<div class="row alert alert-info hideDiv">
					<div class="col-lg-12">
					<div class="text-left">
						<br>
						<img src="displayBarChart"/> 
						<img src="displayTraineeChart"/> 
					</div>
					</div>
				</div>
				<div class="clearfix" style="height:10px; clear: both;"></div>
			  
				<div class="row alert alert-danger">
					<div class="col-sm-4 home-title top-buffer">
						Registration
					</div>
			    	<div class="col-sm-12">
			    		<div class="col-sm-6">
			    			<img src="/training/img/dash-trainee.png" class="img-rounded"> <a href="<s:url action="trainee-register"/>" class="ticker-link">New Trainee</a>
			    		</div>
			    	</div>
			    	<div class="col-sm-12">
			    		<div class="col-sm-6">
			    			<img src="/training/img/dash-group.png" class="img-rounded"> <a href="<s:url action="trainingprogram-register"/>" class="ticker-link">New Training Program</a>
			    		</div>
			    	</div>
			    	<div class="col-sm-12">
			    		<div class="col-sm-6">
			    			<img src="/training/img/dash-org.jpeg" class="img-rounded"> <a href="<s:url action="announcement/new-training"/>" class="ticker-link">Training Proposal Request</a>
			    		</div>
			    	</div>
			    	
			    	<div class="col-sm-12">
			    		<div class="col-sm-6">
			    			<img src="/training/img/dash-partner.png" class="img-rounded"> <a href="<s:url action="advanced/search"/>" class="ticker-link">Report Generation</a>
			    		</div>
			    	</div>
			  	</div>
			  	
			  	<div class="clearfix" style="height:10px; clear: both;"></div>
			  	
			  	<div class="row alert alert-warning">
					<div class="col-sm-4 home-title top-buffer">
						Search database
					</div>
			    	<div class="col-lg-12">
			    		<form method="get" action="<s:url action='search' />" id="frmSearch" name="frmSearch">
						    <div class="input-group">
						      <input name="q" type="text" style="width:90%;" class="form-control search-box" placeholder="Search for...">
						      <span class="input-group-btn">
						        <input class="btn btn-default" type="submit" value="Search!" id="btnSearch">
						      </span>
						    </div><!-- /input-group -->
					    </form>
					</div><!-- /.col-lg-6 -->
			    </div>
			</div>			
		</td>
		<td valign="top">
			<div class="row alert alert-info">
				<div class="col-sm-12">
			    	<img src="<c:url value="traineechart.png" />" />
			    </div>
			    <div class="clearfix" style="height:10px; clear: both;"></div>
			    <div class="col-sm-12">
			    	<img src="<c:url value="groupchart.png" />" />
			    </div>
			</div>
			<div class="row alert alert-warning">
				<div class="col-sm-12">
					<%@ include file="/common/yearmodules.jsp"%>
				</div>
			</div>
			<s:if test="applications!=null && applications.size>0">
				<div class="row">
					<div class="col-sm-12">
						<h3>Latest applications</h3>
						<ul>
						<s:iterator value="applications">
							<li><s:include value="/WEB-INF/jsp/include/applications-short.jsp" /></li>
						</s:iterator>
						</ul>
					</div>
				</div>
			</s:if>
			<div class="row alert alert-danger">
				<div class="col-sm-12" style="text-align: center">
					<p><a href="<s:url action="alerts"/>" class="image-border"><img src="/training/img/alert_notifications.png" class="img-rounded"></a></p>
					<h4><a href="<s:url action="alerts"/>">Notification monitor</a></h4>
				</div>
			</div>
			<div class="row alert alert-warning">
			    <div class="col-sm-12" style="text-align: center">
			      	<p><a href="<s:url action="tagcloud"/>" class="image-border"><img src="/training/img/tag_cloud.png" class="img-rounded"></a></p>
			    	<h4><a href="<s:url action="tagcloud"/>">Tag cloud</a></h4>
			    </div>
			</div>
		</td>
	</tr>
</table> 
<script>
$(document).ready(function(){
	$("#btnSearch").click(function() {
		$("#frmSearch").submit();
	});
});
</script>
</body>
</html>
