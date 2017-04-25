<%@ include file="/common/taglibs.jsp"%>

<%@ include file="/common/yearmodules.jsp"%>

<div class="container">
<!-- 
    <div class="page-header">
      <h1>Series of <s:property value="year" /> activities</h1>
    </div> -->
	<div class="row">
    	<!-- Trainees here -->
    		<div class="page-header">
				<h3>Top 10 Trainees</h3>
			</div>
			<s:if test="listTrainees.totalHits==0">
				<div style="width: 380px; float: left; margin: 5px 10px 5px 50px; padding: 5px; display:inline-block" class="alert alert-danger">
					<em>No trainee records found!</em>
				</div>
			</s:if>
			<s:iterator value="listTrainees.results" status="status">
				
				<div style="width: 380px; height:110px;overflow:hidden; text-overflow: ellipsis; float: left; margin: 5px 10px 5px 50px; padding: 5px; display:inline-block" class="alert alert-success">
					<div style="float:right;width:290px">
						<h4><a href="<s:url action="trainee/profile" />?id=<s:property value="id" />"><s:property value="person.fullName" /></a></h4>
						<div style="float: left; width: 100%;">
							<p>
								<s:property value="researchTopic" />
								<!--<br/> End date: <s:if test="extensionDate!=null"><s:property value="extensionDate" /></s:if><s:else><s:property value="endDate" /></s:else> -->
							</p> 
						</div>
					</div>
					<div class="greendate">
					    <div class="xdate-month"><s:date name="startDate" format="dd" /></div>
					    <div class="xdate-day"><s:date name="startDate" format="MMM" /></div>
					</div>
				</div>
			</s:iterator>
			<s:if test="listTrainees.totalHits>0">
				<div style="width: 380px; float: left; margin: 5px 10px 5px 50px; padding: 5px; display:inline-block" class="alert alert-success">
					<h4><a href="searchyear.jspx?scope=trainee&year=<s:property value='year' />">View All <s:property value='year' /> Trainees</a></h4>
				</div>
			</s:if>
    </div>
    <div class="row">
    	<!-- Training Programs here -->
    		<div class="page-header">
				<h3>Top 10 Training Programs</h3>
			</div>
			<s:if test="listPrograms.totalHits==0">
				<div style="width: 380px; float: left; margin: 5px 10px 5px 50px; padding: 5px; display:inline-block" class="alert alert-danger">
					<em>No training program records found!</em>
				</div>
			</s:if>
			<s:iterator value="listPrograms.results" status="status">
				<div style="width: 380px; height:120px; overflow:hidden; text-overflow: ellipsis; float: left; margin: 5px 10px 5px 50px; padding: 5px; display:inline-block"  class="alert alert-warning">
					<div style="float:right;width:290px">
						<div style="float: left; width: 100%;">
							<h4><a href="<s:url action="program/profile" />?id=<s:property value="id" />"><s:property value="title" /></a></h4>
							<s:property value="location" /> | <s:property value="country" />
							<!--<br/><s:property value="startDate" /> - <s:if test="extensionDate!=null"><s:property value="extensionDate" /></s:if><s:else><s:property value="endDate" /></s:else>-->
						</div>
					</div>
					<div class="browndate">
					    <div class="xdate-month"><s:date name="startDate" format="dd" /></div>
					    <div class="xdate-day"><s:date name="startDate" format="MMM" /></div>
					</div>
				</div>
			</s:iterator>
			<s:if test="listPrograms.totalHits>0">
				<div style="width: 380px; float: left; margin: 5px 10px 5px 50px; padding: 5px; display:inline-block" class="alert alert-warning">
					<h4><a href="searchyear.jspx?scope=trainingprogram&year=<s:property value='year' />">View All <s:property value='year' /> Training Programs</a></h4>
				</div>
			</s:if>
    </div>
    <div class="row">
    	<!-- Announcements here -->
    		<div class="page-header">
				<h3>Top 10 Announcements</h3>
			</div>
			<s:if test="listAnnouncements.totalHits==0">
				<div style="width: 380px; float: left; margin: 5px 10px 5px 50px; padding: 5px; display:inline-block" class="alert alert-danger">
					<em>No announcement records found!</em>
				</div>
			</s:if>
			<s:iterator value="listAnnouncements.results" status="status">
				<div style="width: 380px; height:160px; overflow:hidden; text-overflow: ellipsis; float: left; margin: 5px 10px 5px 50px; padding: 5px; display:inline-block" class="alert alert-danger">
					<div style="float:right;width:290px">
						<div style="float: left; width: 100%;">
							<h4><a href="<s:url action="announcement/profile" />?id=<s:property value="announcement.id" />"><s:if test="announcement.title!=null"><s:property value="announcement.title" /></s:if><s:else>Unspecified title</s:else></a></h4>
							<s:if test="requester!=null">Requester: <s:property value="requester.fullName" /><br/></s:if><!--  | Start: <s:property value="announcement.startDate" /> | End: <s:property value="announcement.endDate" />-->
							<s:if test="venue!=null || country!=null">
							Location: <s:property value="venue" /> | <s:property value="country" /></s:if>
						</div>
					</div>
					<div class="reddate">
					    <div class="xdate-month"><s:date name="startDate" format="dd" /></div>
					    <div class="xdate-day"><s:date name="startDate" format="MMM" /></div>
					</div>
				</div>
			</s:iterator>
			<s:if test="listAnnouncements.totalHits>0">
				<div style="width: 380px; float: left; margin: 5px 10px 5px 50px; padding: 5px; display:inline-block" class="alert alert-danger">
					<h4><a href="searchyear.jspx?scope=announcement&year=<s:property value='year' />">View All <s:property value='year' /> Announcements</a></h4>
				</div>
			</s:if>
	</div>
	<div class="row">
    	<!-- Proposals here -->
    		<div class="page-header">
				<h3>Top 10 Proposals</h3>
			</div>
			<s:if test="listProposals.totalHits==0">
				<div style="width: 380px; float: left; margin: 5px 10px 5px 50px; padding: 5px; display:inline-block" class="alert alert-danger">
					<em>No proposal records found!</em>
				</div>
			</s:if>
			<s:iterator value="listProposals.results" status="status">
				<div style="width: 380px; height:160px; overflow:hidden; text-overflow: ellipsis; float: left; margin: 5px 10px 5px 50px; padding: 5px; display:inline-block" class="alert alert-info">
					<div style="float:right;width:290px">
						<div style="float: left; width: 100%;">
							<h4><a href="<s:url action="proposal/profile" />?id=<s:property value="trainingProposal.id" />"><s:property value="trainingProposal.title" /></a></h4>
							<s:if test="requester!=null">Requester: <s:property value="requester.fullName" /><br/></s:if><!--  | Start: <s:property value="startDate" /> | End: <s:property value="endDate" />-->
							Location: <s:property value="venue" /> | <s:property value="country" />
						</div>
					</div>
					<div class="bluedate">
					    <div class="xdate-month"><s:date name="startDate" format="dd" /></div>
					    <div class="xdate-day"><s:date name="startDate" format="MMM" /></div>
					</div>
				</div>
			</s:iterator>
			<s:if test="listProposals.totalHits>0">
				<div style="width: 380px; float: left; margin: 5px 10px 5px 50px; padding: 5px; display:inline-block" class="alert alert-info">
					<h4><a href="searchyear.jspx?scope=announcement&year=<s:property value='year' />">View All <s:property value='year' /> Training Proposals</a></h4>
				</div>
			</s:if>
    </div>
    <div class="row">
    	<!-- Registered Organizations here for the year in review -->
    		<div class="page-header">
				<h3>Top 10 Organizations</h3>
			</div>
			<s:if test="listOrganizations.totalHits==0">
				<div style="width: 380px; float: left; margin: 5px 10px 5px 50px; padding: 5px; display:inline-block" class="alert alert-danger">
					<em>No organization records found!</em>
				</div>
			</s:if>
			<s:iterator value="listOrganizations.results" status="status">
				<div style="width: 380px; height:60px; overflow:hidden; float: left; margin: 5px 10px 5px 50px; padding: 5px; display:inline-block" class="alert alert-success">
					<div style="float: left; width: 100%;">
						<h4><a href="<s:url action="organization/profile" />?id=<s:property value="id" />"><s:if test="shortName!=null"><s:property value="shortName" />: </s:if><s:property value="title" /></a></h4>
						<s:if test="type!=null">
							Type: <s:property value="type" />
						</s:if>
					</div>
				</div>
			</s:iterator>
			<s:if test="listOrganizations.totalHits>0">
				<div style="width: 380px; float: left; margin: 5px 10px 5px 50px; padding: 5px; display:inline-block" class="alert alert-success">
					<h4><a href="searchyear.jspx?scope=organization&year=<s:property value='year' />">View All <s:property value='year' /> Organizations</a></h4>
				</div>
			</s:if>
  	</div>
</div>
