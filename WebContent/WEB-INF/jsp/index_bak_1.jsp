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
</style>
</head>
<body>

<s:if test="pagedAwaitingApproval.totalHits>0">
	<div class="actionMessage">There are <b><s:property value="pagedAwaitingApproval.totalHits" /></b> application requests waiting for your
	approval. <s:if test="pagedAwaitingApproval.TotalHits > 0">
		<input type="button" onClick="javascript: window.location='<s:url action="review" />';" value="Review requests" />
	</s:if></div>
</s:if>
<s:if test="otherPeoplePending!=null && otherPeoplePending.size()>0">
	<div class="actionMessage">
	<b>DELEGATED APPROVAL: </b>
	<s:iterator value="otherPeoplePending.keys">
		<a href="<s:url action="user/delegate!switchuser"><s:param name="email" value="%{mail}"/></s:url>"><s:property value="fullName" /></a> has <b><s:property value="otherPeoplePending[top]" /></b> Travel Authorization awaiting their approval.
	</s:iterator>
	</div>
</s:if>

<table style="width:100%">
	<colgroup><col width="80%"/><col width="20%"/>
	</colgroup>
	<tr>
		<td style="vertical-align: top; padding-right: 30px">
			<div class="container-main"> 
				<div class="row">
					<div class="col-sm-4 home-title">
						Registration
					</div>
			    	<div class="col-sm-12">
			    		<div class="col-sm-6">
			    			<img src="/training/img/tick.png" class="img-rounded"> <a href="<s:url action="person-register"/>" class="ticker-link">Person/Biodata</a>
			    		</div>
			    	</div>
			    	<div class="col-sm-12">
			    		<div class="col-sm-6">
			    			<img src="/training/img/dash-trainee.png" class="img-rounded"> <a href="<s:url action="trainee-register"/>" class="ticker-link">Trainee</a>
			    		</div>
			    	</div>
			    	<div class="col-sm-12">
			    		<div class="col-sm-6">
			    			<img src="/training/img/dash-group.png" class="img-rounded"> <a href="<s:url action="trainingprogram-register"/>" class="ticker-link">Training Program</a>
			    		</div>
			    	</div>
			    	<div class="col-sm-12">
			    		<div class="col-sm-6">
			    			<img src="/training/img/dash-org.jpeg" class="img-rounded"> <a href="<s:url action="organization-register"/>" class="ticker-link">Service Provider/Organization</a>
			    		</div>
			    	</div>
			    	<div class="col-sm-12">
			    		<div class="col-sm-6">
			    			<img src="/training/img/dash-partner.png" class="img-rounded"> <a href="<s:url action="partner-register"/>" class="ticker-link">Partner</a>
			    		</div>
			    	</div>
			  	</div>
			  	
			  	<div class="row">
					<div class="col-sm-4 home-title">
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
			    
			    <div class="row">
					<div class="col-sm-4 home-title">
						Procedures ...
					</div>
				    <div class="col-lg-12">
				    	Procedure details go in here!
					</div><!-- /.col-lg-6 -->
				</div>
			</div>			
		</td>
		<td valign="top">
			<div class="row">
				<div class="col-sm-12">
					<%@ include file="/common/years.jsp"%>
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
			<div class="row">
				<div class="col-sm-12">
					<p><a href="<s:url action="alerts"/>" class="image-border"><img src="/training/img/alert_notifications.png" class="img-rounded"></a></p>
					<h4><a href="<s:url action="alerts"/>">Notification monitor</a></h4>
				</div>
			    <div class="col-sm-12">
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
