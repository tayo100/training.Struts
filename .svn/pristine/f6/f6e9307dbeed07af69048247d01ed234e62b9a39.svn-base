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

<div class="container-main">  
  <div class="row">
    <div class="col-sm-4">
      <h4><a href="<s:url action="person-register"/>">Register new person</a></h4>
      <p><a href="<s:url action="person-register"/>"><img src="/training/img/register_new_person.png" class="img-rounded"></a></p>
    </div>
    <div class="col-sm-4">
      <h4>Register trainee</h4>
      <p><img src="/training/img/register_trainee.png" class="img-rounded"></p>
    </div>
    <div class="col-sm-4">
      <h4>Register new training</h4>
      <p><img src="/training/img/register_new_training.png" class="img-rounded"></p>
    </div>
  </div>
  <div class="row">
    <div class="col-sm-4">
      <h4>Register new organization</h4>
      <p><img src="/training/img/register_new_organization.png" class="img-rounded"></p>
    </div>
    <div class="col-sm-4">
      <h4>Register new partner</h4>
      <p><a href="/training/partner/quickform.jsp"><img src="/training/img/register_new_partner.png" class="img-rounded"></a></p>
    </div>
    <div class="col-sm-4">
      <h4>Last pending alert notifications</h4>        
      <p><img src="/training/img/alert_notifications.png" class="img-rounded"></p>
    </div>
  </div>
  <div class="row">
    <div class="col-sm-4">
      <h4>Last updated programs</h4>
      <p><img src="/training/img/last_updated_programs.png" class="img-rounded"></p>
    </div>
    <div class="col-sm-4">
      <h4>Last updated trainees</h4>
      <p><img src="/training/img/last_updated_trainee.png" class="img-rounded"></p>
    </div>
    <div class="col-sm-4">
      <h4>Last updated persons</h4>        
      <p><img src="/training/img/last_updated_persons.png" class="img-rounded"></p>
    </div>
  </div>
  <div class="row">
    <div class="col-sm-4">
      <h4>Last updated organizations</h4>
      <p><img src="/training/img/last_updated_organizations.png" class="img-rounded"></p>
    </div>
    <div class="col-sm-4">
      <h4>Last updated partners</h4>
      <p><img src="/training/img/last_updated_partners.png" class="img-rounded"></p>
    </div>
    <div class="col-sm-4">
      <h4>Tag cloud</h4>        
      <p><img src="/training/img/tag_cloud.png" class="img-rounded"></p>
    </div>
  </div>
</div>

<table>
<colgroup><col width="50%" /><col width="50%" /></colgroup>
<tr>
<td style="vertical-align: top; padding-right: 30px">
<security:authorize ifAnyGranted="ROLE_HEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
	<div class="actionMessage">Before registering new persons, please check if the record about the person already exists.</div>
	
	<h2>Register new person</h2>
	<s:include value="/WEB-INF/jsp/person/person-quickform.jsp" />
	
	
	<h2>Register trainee</h2>
	<s:include value="/WEB-INF/jsp/trainee/quickform.jsp" />
	
	
	<h2>Register new training</h2>
	<s:include value="/WEB-INF/jsp/program/quickform.jsp" />
	
	
	<h2>Register new organization</h2>
	<s:include value="/WEB-INF/jsp/organization/quickform.jsp" />
</security:authorize>
<security:authorize ifAnyGranted="ROLE_PARTNERADMIN">
	<h2>Register new partner</h2>
	<s:include value="/WEB-INF/jsp/partner/quickform.jsp" />
</security:authorize>
<security:authorize ifAnyGranted="ROLE_HEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
	<s:if test="alerts!=null && alerts.size>0">
		<h2>Last pending alert notifications</h2>
		<ul>
			<s:iterator value="alerts">
				<li><s:include value="/WEB-INF/jsp/alert/quickinfo.jsp" /></li>
			</s:iterator>
		</ul>
	</s:if>
</security:authorize>
</td>
<td>
<s:if test="applications!=null && applications.size>0">
	<h3>Latest applications</h3>
	<ul>
	<s:iterator value="applications">
		<li><s:include value="/WEB-INF/jsp/include/applications-short.jsp" /></li>
	</s:iterator>
	</ul>
</s:if>
<s:if test="programs!=null && programs.size>0">
	<h3>Last updated programs</h3>
	<ul>
	<s:iterator value="programs">
		<li><s:include value="/WEB-INF/jsp/program/short.jsp" /></li>
	</s:iterator>
	</ul>
</s:if>
<s:if test="trainees!=null && trainees.size>0">
	<h3>Last updated trainees</h3>
	<ul>
	<s:iterator value="trainees">
		<li><s:include value="/WEB-INF/jsp/trainee/small.jsp" /></li>
	</s:iterator>
	</ul>
</s:if>
<s:if test="persons!=null && persons.size>0">
	<h3>Last updated persons</h3>
	<ul>
	<s:iterator value="persons">
		<li><s:include value="/WEB-INF/jsp/person/small.jsp" /></li>
	</s:iterator>
	</ul>
</s:if>
<s:if test="organizations!=null && organizations.size>0">
	<h3>Last updated organizations</h3>
	<ul>
	<s:iterator value="organizations">
		<li><s:include value="/WEB-INF/jsp/organization/small.jsp" /></li>
	</s:iterator>
	</ul>
</s:if>
<s:if test="partners!=null && partners.size>0">
	<h3>Last updated partners</h3>
	<ul>
	<s:iterator value="partners">
		<li><s:include value="/WEB-INF/jsp/partner/small.jsp" /></li>
	</s:iterator>
	</ul>
</s:if>
<h2>Tag cloud <small><a href="<s:url action="tag/cloud" />">Browse tag cloud</a></small></h2>
	<s:action name="tag/cloud!inline" executeResult="true" ignoreContextParams="true" />
</td>
</tr>
</table> 
</body>
</html>