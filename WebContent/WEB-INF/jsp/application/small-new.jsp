<%@ include file="/common/taglibs.jsp"%>

<article class="search-result row">
			<div class="col-xs-12 col-sm-12 col-md-3">
				<s:if test="biodata.fileName==null || biodata.fileName.length()==0">
							<s:if test="biodata.gender==@org.iita.trainingunit.applications.model.ApplicantsBioData$GENDER@Male">
								<a href="#" title="Pix" class="thumbnail">
									<img src="<c:url value="/passports/male.png" />" alt="Pix" />
								</a>
							</s:if>
							<s:elseif test="biodata.gender==@org.iita.trainingunit.applications.model.ApplicantsBioData$GENDER@Female">
								<a href="#" title="Pix" class="thumbnail">
									<img src="<c:url value="/passports/female.png" />" alt="Pix" />
								</a>
							</s:elseif>
							<s:else>
								<a href="#" title="Pix" class="thumbnail">
									<img src="<c:url value="/passports/male.png" />" alt="Pix" />
								</a>
							</s:else>
						</s:if>
						<s:else>
							<a href="#" title="Pix" class="thumbnail">
								<img src="<s:property value="biodata.fileName" />" width="60px" height="60px" />
							</a>
						</s:else>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-2">
				<ul class="meta-search">
					<li><i class="glyphicon glyphicon-book"></i> <span><s:property value="biodata.fullName" /></span></li>
					<li><i class="glyphicon glyphicon-calendar"></i> <span><iita:date format="dd MMM yyyy" name="createdDate" /></span></li>
					<li><i class="glyphicon glyphicon-time"></i> <span><iita:date format="hh:mm a" name="createdDate" /></span></li>
					<li><i class="glyphicon glyphicon-bookmark"></i> <span><s:property value="top.class.simpleName.substring(0, top.class.simpleName.indexOf('Training'))" /></span></li>
				</ul>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-7 excerpet">
				<s:if test="%{top instanceof org.iita.trainingunit.applications.model.GroupTraining}">
					<h3><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title=""><s:property value="status" />: <s:property value="trainingTopic" /></a></h3>
					<p><s:property value="objectives" /></p>						
	                <span class="plus"><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title="<s:property value="refNumber" />"><i class="glyphicon glyphicon-plus"></i></a></span>
				</s:if>
				<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.GraduateResearchTraining}">
					<h3><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title=""><s:property value="status" />: <s:property value="projectSummaries.title" /></a></h3>
					<p><s:property value="projectSummaries.summary" /></p>						
	                <span class="plus"><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title="<s:property value="refNumber" />"><i class="glyphicon glyphicon-plus"></i></a></span>
				</s:elseif>
				<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.InternshipTraining}">
					<h3><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title=""><s:property value="status" />: <s:property value="areaOfSpecialization" /></a></h3>
					<p><s:property value="whyInIITA" /></p>						
	                <span class="plus"><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title="<s:property value="refNumber" />"><i class="glyphicon glyphicon-plus"></i></a></span>
				</s:elseif>
				<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.NonDegreeTraining}">
					<h3><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title=""><s:property value="status" />: <s:property value="trainingReceived" /></a></h3>
					<p><s:property value="trainingLocation" /></p>						
	                <span class="plus"><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title="<s:property value="refNumber" />"><i class="glyphicon glyphicon-plus"></i></a></span>
				</s:elseif>					
				<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.OtherTraining}">
					<h3><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title=""><s:property value="refNumber" /></a></h3>					
	                <span class="plus"><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title="<s:property value="refNumber" />"><i class="glyphicon glyphicon-plus"></i></a></span>
				</s:elseif>
				<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.IndividualTraining}">
					<h3><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title=""><s:property value="status" />: <s:property value="refNumber" /></a></h3>					
	                <span class="plus"><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title="<s:property value="refNumber" />"><i class="glyphicon glyphicon-plus"></i></a></span>
				</s:elseif>					
				<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.SabbaticalTraining}">
					<h3><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title=""><s:property value="status" />: <s:property value="sabProjectSummaries.theme" /></a></h3>
					<p><s:property value="sabProjectSummaries.summary" /></p>						
	                <span class="plus"><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title="<s:property value="refNumber" />"><i class="glyphicon glyphicon-plus"></i></a></span>
				</s:elseif>				
				<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.InHouseTraining}">
					<h3><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title=""><s:property value="status" />: <s:property value="refNumber" /></a></h3>					
	                <span class="plus"><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title="<s:property value="refNumber" />"><i class="glyphicon glyphicon-plus"></i></a></span>
				</s:elseif>				
				<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.StaffDevTraining}">
					<h3><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title=""><s:property value="status" />: <s:property value="refNumber" /></a></h3>					
	                <span class="plus"><a href="<s:url namespace="/" action="appdetails" />?applicationId=<s:property value="id" />" title="<s:property value="refNumber" />"><i class="glyphicon glyphicon-plus"></i></a></span>
				</s:elseif>
			</div>
			<span class="clearfix border"></span>
		</article>