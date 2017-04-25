<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Training Unit Application</title>
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
	<colgroup><col width="<s:if test="applications!=null && applications.size>0">70%</s:if><s:else>100%</s:else>"/><s:if test="applications!=null && applications.size>0"><col width="30%" /></s:if></colgroup>
	<tr>
		<td style="vertical-align: top; padding-right: 30px">
			<div class="container-main">  
			  <div class="row">
			    <div class="col-sm-4">
			      	<p><a href="<s:url action="person-register"/>" class="image-border"><img src="/training/img/register_new_person.png" class="img-rounded"></a></p>
			    	<h4><a href="<s:url action="person-register"/>">Register new <br/>resource person</a></h4>
			    </div>
			    <div class="col-sm-4">
			      	<p><a href="<s:url action="trainee-register"/>" class="image-border"><img src="/training/img/register_trainee.png" class="img-rounded"></a></p>
			    	<h4><a href="<s:url action="trainee-register"/>">Register trainee</a></h4>
			    </div>
			    <div class="col-sm-4">
			      	<p><a href="<s:url action="trainingprogram-register"/>" class="image-border"><img src="/training/img/register_new_training.png" class="img-rounded"></a></p>
			    	<h4><a href="<s:url action="trainingprogram-register"/>">Register new <br/>group training</a></h4>
			    </div>
			  </div>
			  <div class="row">
			    <div class="col-sm-4">
			      	<p><a href="<s:url action="organization-register"/>" class="image-border"><img src="/training/img/register_new_organization.png" class="img-rounded"></a></p>
			      	<h4><a href="<s:url action="organization-register"/>">Register new <br/>service provider/organization</a></h4>
			    </div>
			    <div class="col-sm-4">
			      	<p><a href="<s:url action="partner-register"/>" class="image-border"><img src="/training/img/partnership.png" class="img-rounded"></a></p>
			    	<h4><a href="<s:url action="partner-register"/>">Register new partner</a></h4>
			    </div>
			    <div class="col-sm-4">
			      	<p><a href="<s:url action="alerts"/>" class="image-border"><img src="/training/img/alert_notifications.png" class="img-rounded"></a></p>
			    	<h4><a href="<s:url action="alerts"/>">Last pending alert notifications</a></h4>
			    </div>
			  </div>
			  <div class="row">
			    <div class="col-sm-4">
					<p><a href="<s:url action="trainingprogram-updated"/>" class="image-border"><img src="/training/img/last_updated_programs.png" class="img-rounded"></a></p>
			    	<h4><a href="<s:url action="trainingprogram-updated"/>">Last updated programs</a></h4>
			    </div>
			    <div class="col-sm-4">
			      	<p><a href="<s:url action="trainee-updated"/>" class="image-border"><img src="/training/img/last_updated_trainee.png" class="img-rounded"></a></p>
			    	<h4><a href="<s:url action="trainee-updated"/>">Last updated trainees</a></h4>
			    </div>
			    <div class="col-sm-4">
			      	<p><a href="<s:url action="person-updated"/>" class="image-border"><img src="/training/img/last_updated_persons.png" class="img-rounded"></a></p>
			    	<h4><a href="<s:url action="person-updated"/>">Last updated persons</a></h4>
			    </div>
			  </div>
			  <div class="row">
			    <div class="col-sm-4">
			     	<p><a href="<s:url action="organization-updated"/>" class="image-border"><img src="/training/img/last_updated_organizations.png" class="img-rounded"></a></p>
			    	<h4><a href="<s:url action="organization-updated"/>">Last updated organizations</a></h4>
			    </div>
			    <div class="col-sm-4">
			      	<p><a href="<s:url action="partner-updated"/>" class="image-border"><img src="/training/img/partnership-1.jpeg" class="img-rounded"></a></p>
			    	<h4><a href="<s:url action="partner-updated"/>">Last updated partners</a></h4>
			    </div>
			    <div class="col-sm-4">
			      	<p><a href="<s:url action="tagcloud"/>" class="image-border"><img src="/training/img/tag_cloud.png" class="img-rounded"></a></p>
			    	<h4><a href="<s:url action="tagcloud"/>">Tag cloud</a></h4>
			    </div>
			  </div>
			</div>
		</td>
		<s:if test="applications!=null && applications.size>0">
			<td valign="top">
				<h3>Latest applications</h3>
				<ul>
				<s:iterator value="applications">
					<li><s:include value="/WEB-INF/jsp/include/applications-short.jsp" /></li>
				</s:iterator>
				</ul>
			</td>
		</s:if>
	</tr>
</table> 
</body>
</html>