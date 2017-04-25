<%@ include file="/common/taglibs.jsp"%>
<div class="container">

	<div class="table-responsive">
	
	<s:if test="pagedTrainee.pageSize > 0">
		
		<s:include value="/WEB-INF/jsp/paging-advsearch.jsp">
			<s:param name="page" value="pagedTrainee.page" />
			<s:param name="pages" value="pagedTrainee.pages" />
			<s:param name="pageSize" value="pagedTrainee.pageSize" />
			<s:param name="href" value="%{''}" />
			<s:param name="selectedType" value="selectedType" />
			<s:param name="selTrainers" value="parse2Trainerslink" />
			<s:param name="crps" value="parse2Crpslink" />
			<s:param name="hubs" value="parse2Hubslink" />
			<s:param name="coreCompetencies" value="parse2Coreslink" />
			<s:param name="sponsors" value="parse2Sponsorslink" />
			<s:param name="fullText" value="fullText" />
			<s:param name="groupYearly" value="groupYearly" />
			<s:param name="cc" value="cc" />
		</s:include>
		<hgroup class="mb20">
			<h1>Search Results</h1>
			<h2 class="lead"><strong class="text-danger"><s:property value="pagedTrainee.totalHits" /></strong> results were found for the search criteria supplied</h2>								
		</hgroup>
		
			<s:iterator value="pagedTrainee.results" status="status">
				<article class="search-result">
					<div class="col-xs-12 col-sm-12 col-md-2">
						<s:property value="#status.count + pagedTrainee.startAt" />. <a href="<s:url action="person/profile" />?id=<s:property value="person.id" />"><s:property value="person.fullName" /></a>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-2">
						<ul class="meta-search">
							<li><i class="glyphicon glyphicon-calendar"></i> <span>Date: <s:date format="%{getText('date.format')}" name="startDate" /> - <s:date format="%{getText('date.format')}" name="endDate" /></span></li>
							<li><i class="glyphicon glyphicon-time"></i> <span>Nationality: <s:property value="person.country" /></span></li>
							<li><i class="glyphicon glyphicon-tags"></i> <span>Research Location: <s:if test="location!=null">
								<s:property value="location" />
								<s:if test="country!=null">
									, <s:property value="country" />
								</s:if>
							</s:if>
							<s:elseif test="country!=null">
								<s:property value="country" />
							</s:elseif></span></li>
						</ul>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-8 excerpet">
						<h3><a href="<s:url action="trainee/profile" />?id=<s:property value="id" />" title=""><s:property value="researchTopic" /></a></h3>
						<s:if test="sponsor!=null"><p>Sponsor: <s:property value="sponsor" /></p></s:if>
						<p>Supervisor(s): <s:iterator value="supervisors">
								<a href="<s:url action="person/profile" />?id=<s:property value="person.id" />"><s:property value="person.fullName" /></a>; 
							</s:iterator></p>					
		                <s:if test="university!=null"><p>University: <a href="<s:url action="organization/profile" />?id=<s:property value="university.id" />" title="<s:property value="university.title" />"><i class="glyphicon glyphicon-plus"><s:if test="university.title != null"><s:property value="university.title" /></s:if><s:else><s:property value="university.shortName" /></s:else></i></a></p></s:if>
					</div>
					<span class="clearfix borda"></span>
				</article>
			</s:iterator>
			<s:include value="/WEB-INF/jsp/paging-advsearch.jsp">
				<s:param name="page" value="pagedTrainee.page" />
				<s:param name="pages" value="pagedTrainee.pages" />
				<s:param name="pageSize" value="pagedTrainee.pageSize" />
				<s:param name="href" value="%{''}" />
				<s:param name="selectedType" value="selectedType" />
				<s:param name="selTrainers" value="parse2Trainerslink" />
				<s:param name="crps" value="parse2Crpslink" />
				<s:param name="hubs" value="parse2Hubslink" />
				<s:param name="coreCompetencies" value="parse2Coreslink" />
				<s:param name="sponsors" value="parse2Sponsorslink" />
				<s:param name="fullText" value="fullText" />
				<s:param name="groupYearly" value="groupYearly" />
				<s:param name="cc" value="cc" />
			</s:include>
	</s:if>
	<s:if test="pagedTrainee.totalHits==0 && table.equals('Trainee')">
		<article class="search-result">
			<em>No trainee records found!</em>
		</article>
	</s:if>
	
	
	<s:if test="pagedPrograms.pageSize > 0">
		<s:include value="/WEB-INF/jsp/paging-advsearch.jsp">
			<s:param name="page" value="pagedPrograms.page" />
			<s:param name="pages" value="pagedPrograms.pages" />
			<s:param name="pageSize" value="pagedPrograms.pageSize" />
			<s:param name="href" value="%{''}" />
			<s:param name="selectedType" value="selectedType" />
			<s:param name="selTrainers" value="parse2Trainerslink" />
			<s:param name="crps" value="parse2Crpslink" />
			<s:param name="hubs" value="parse2Hubslink" />
			<s:param name="coreCompetencies" value="parse2Coreslink" />
			<s:param name="sponsors" value="parse2Sponsorslink" />
			<s:param name="fullText" value="fullText" />
			<s:param name="groupYearly" value="groupYearly" />
			<s:param name="cc" value="cc" />
		</s:include>
		<hgroup class="mb20">
			<h1>Search Results</h1>
			<h2 class="lead"><strong class="text-danger"><s:property value="pagedPrograms.totalHits" /></strong> results were found for the search criteria supplied</h2>								
		</hgroup>
		
			<s:iterator value="pagedPrograms.results" status="status">
				<article class="search-result">
					<div class="col-xs-12 col-sm-12 col-md-12 excerpet">
						<h3><s:property value="#status.count + pagedPrograms.startAt" />. <a href="<s:url action="program/profile" />?id=<s:property value="id" />" title=""><s:if test="title!=null"><s:property value="title" /> </s:if><s:else>Unknown title</s:else></a></h3>
						<s:if test="trainers!=null">
						<p>Trainer(s): <s:iterator value="trainers">
								<a href="<s:url action="person/profile" />?id=<s:property value="person.id" />"><s:property value="person.fullName" /></a>; 
							</s:iterator></p>
						</s:if>
						<ul class="meta-search">
							<s:if test="startDate!=null"><li><i class="glyphicon glyphicon-calendar"></i> <span>Date: <s:date format="%{getText('date.format')}" name="startDate" /> - <s:date format="%{getText('date.format')}" name="endDate" /></span></li></s:if>
							<s:if test="extensionDate!=null"><li><i class="glyphicon glyphicon-calendar"></i> <span>Extension: <s:date format="%{getText('date.format')}" name="extensionDate" /></span></li></s:if>
							<s:if test="country!=null"><li><i class="glyphicon glyphicon-time"></i> <span>Location/Country: <s:property value="country" /></span></li></s:if>
						</ul>				
		            </div>
					<span class="clearfix borda"></span>
				</article>
			</s:iterator>
			<s:include value="/WEB-INF/jsp/paging-advsearch.jsp">
				<s:param name="page" value="pagedPrograms.page" />
				<s:param name="pages" value="pagedPrograms.pages" />
				<s:param name="pageSize" value="pagedPrograms.pageSize" />
				<s:param name="href" value="%{''}" />
				<s:param name="selectedType" value="selectedType" />
				<s:param name="selTrainers" value="parse2Trainerslink" />
				<s:param name="crps" value="parse2Crpslink" />
				<s:param name="hubs" value="parse2Hubslink" />
				<s:param name="coreCompetencies" value="parse2Coreslink" />
				<s:param name="sponsors" value="parse2Sponsorslink" />
				<s:param name="fullText" value="fullText" />
				<s:param name="groupYearly" value="groupYearly" />
				<s:param name="cc" value="cc" />
			</s:include>
	</s:if>
	
	<s:if test="pagedPrograms.totalHits==0 && table.equals('TrainingProgram')">
		<article class="search-result">
			<em>No training program records found!</em>
		</article>
	</s:if>
	
	<s:if test="pagedOrg.pageSize > 0">
	<s:include value="/WEB-INF/jsp/paging-advsearch.jsp">
		<s:param name="page" value="pagedOrg.page" />
		<s:param name="pages" value="pagedOrg.pages" />
		<s:param name="pageSize" value="pagedOrg.pageSize" />
		<s:param name="href" value="%{''}" />
		<s:param name="selectedType" value="selectedType" />
		<s:param name="selTrainers" value="parse2Trainerslink" />
		<s:param name="crps" value="parse2Crpslink" />
		<s:param name="hubs" value="parse2Hubslink" />
		<s:param name="coreCompetencies" value="parse2Coreslink" />
		<s:param name="sponsors" value="parse2Sponsorslink" />
		<s:param name="fullText" value="fullText" />
		<s:param name="groupYearly" value="groupYearly" />
		<s:param name="cc" value="cc" />
	</s:include>
	<hgroup class="mb20">
			<h1>Search Results</h1>
			<h2 class="lead"><strong class="text-danger"><s:property value="pagedOrg.totalHits" /></strong> results were found for the search criteria supplied</h2>								
		</hgroup>
		
			<s:iterator value="pagedOrg.results" status="status">
				<article class="search-result">
					<div class="col-xs-12 col-sm-12 col-md-3">
						<s:property value="#status.count + pagedOrg.startAt" />. <a href="<s:url action="organization/profile" />?id=<s:property value="id" />"><s:if test="shortName!=null"><s:property value="shortName" />: </s:if><s:property value="title" /></a>
						<s:if test="type!=null"><p><s:property value="type" /></p></s:if>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-2">
						<ul class="meta-search">
							<s:iterator value="contacts">
								<s:if test="top instanceof org.iita.crm.model.AddressContact">
									<li><i class="glyphicon glyphicon-calendar"></i> <span>Country: <s:property value="country" /></span></li>
								</s:if>
							</s:iterator>
							<s:iterator value="contacts">
								<s:if test="top instanceof org.iita.crm.model.EmailContact">
									<li><i class="glyphicon glyphicon-calendar"></i> <span><s:property value="email" /></span></li>
								</s:if>
							</s:iterator>
						</ul>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-7 excerpet">
						<ul class="meta-search">
							<s:iterator value="contacts">
								<s:if test="top instanceof org.iita.crm.model.AddressContact">
									<li><i class="glyphicon glyphicon-calendar"></i> <span><s:property value="address" />, <s:property value="contacts.city" />, <s:property value="contacts.state" /></span></li>
								</s:if>
							</s:iterator>
							<s:iterator value="contacts">
								<s:if test="top instanceof org.iita.crm.model.PhoneContact">
									<li><i class="glyphicon glyphicon-calendar"></i> <span><s:property value="phone" /></span></li>
								</s:if>
							</s:iterator>
						</ul>				
		            </div>
					<span class="clearfix borda"></span>
				</article>
			</s:iterator>
			<s:include value="/WEB-INF/jsp/paging-advsearch.jsp">
				<s:param name="page" value="pagedOrg.page" />
				<s:param name="pages" value="pagedOrg.pages" />
				<s:param name="pageSize" value="pagedOrg.pageSize" />
				<s:param name="href" value="%{''}" />
				<s:param name="selectedType" value="selectedType" />
				<s:param name="selTrainers" value="parse2Trainerslink" />
				<s:param name="crps" value="parse2Crpslink" />
				<s:param name="hubs" value="parse2Hubslink" />
				<s:param name="coreCompetencies" value="parse2Coreslink" />
				<s:param name="sponsors" value="parse2Sponsorslink" />
				<s:param name="fullText" value="fullText" />
				<s:param name="groupYearly" value="groupYearly" />
				<s:param name="cc" value="cc" />
			</s:include>
	</s:if>
	
	<s:if test="pagedOrg.totalHits==0 && table.equals('Organization')">
		<article class="search-result">
			<em>No organization records found!</em>
		</article>
	</s:if>
	
	<s:if test="pagedTrainer.pageSize > 0">
		<s:include value="/WEB-INF/jsp/paging-advsearch.jsp">
			<s:param name="page" value="pagedTrainer.page" />
			<s:param name="pages" value="pagedTrainer.pages" />
			<s:param name="pageSize" value="pagedTrainer.pageSize" />
			<s:param name="href" value="%{''}" />
			<s:param name="selectedType" value="selectedType" />
			<s:param name="selTrainers" value="parse2Trainerslink" />
			<s:param name="crps" value="parse2Crpslink" />
			<s:param name="hubs" value="parse2Hubslink" />
			<s:param name="coreCompetencies" value="parse2Coreslink" />
			<s:param name="sponsors" value="parse2Sponsorslink" />
			<s:param name="fullText" value="fullText" />
			<s:param name="groupYearly" value="groupYearly" />
			<s:param name="cc" value="cc" />
		</s:include>
		<hgroup class="mb20">
			<h1>Search Results</h1>
			<h2 class="lead"><strong class="text-danger"><s:property value="pagedTrainer.totalHits" /></strong> results were found for the search criteria supplied</h2>								
		</hgroup>
		
			<s:iterator value="pagedTrainer.results" status="status">
				<article class="search-result">
					<div class="col-xs-12 col-sm-12 col-md-2">
						<s:property value="#status.count + pagedTrainee.startAt" />. <a href="<s:url action="person/profile" />?id=<s:property value="person.id" />"><s:property value="person.fullName" /></a>
						<s:if test="type!=null"><p><s:property value="type" /></p></s:if>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-2">
						<ul class="meta-search">
							<li><i class="glyphicon glyphicon-calendar"></i> <span>Affiliation: <s:if test="lastAffiliation.organization.shortName!=null"><a href="<s:url action="organization/profile" />?id=<s:property value="lastAffiliation.organization.id" />"><s:property value="lastAffiliation.organization.shortName" /></a></s:if><s:elseif test="lastAffiliation.organization.title!=null"><a href="<s:url action="organization/profile" />?id=<s:property value="lastAffiliation.organization.id" />"><s:property value="lastAffiliation.organization.title" /></a></s:elseif><s:else>Unspecified</s:else></span></li>
							<li><i class="glyphicon glyphicon-time"></i> <span>Nationality: <s:if test="country!=null"><s:property value="country" /></s:if><s:else><s:property value="person.country" /></s:else></span></li>
							<s:if test="lastEmail.email!=null">
								<li><i class="glyphicon glyphicon-email"></i> <span>Email: <s:property value="lastEmail.email" /></span></li>
							</s:if>
							<s:if test="lastAddress.address!=null">
								<li><i class="glyphicon glyphicon-tags"></i> <span>Address: <s:property value="lastAddress.address" /></span></li>
							</s:if>
							<s:if test="lastPhone.phone!=null">
								<li><i class="glyphicon glyphicon-phone"></i> <span>Phone: <s:property value="lastPhone.phone" /></span></li>
							</s:if>
						</ul>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-8 excerpet">
						<h3><s:if test="trainee!=null"><a href="<s:url action="trainee/profile" />?id=<s:property value="trainee.id" />">Trainee: <s:property value="trainee.person.fullName" /> - <s:property value="trainee.researchTopic" /></a></s:if><s:elseif test="group!=null"><a href="<s:url action="program/profile" />?id=<s:property value="group.id" />">Group: <s:property value="group.title" /></a></s:elseif><s:else>Unspecified</s:else></h3>
						<s:if test="notes!=null"><p><em>Notes:</em> <s:property value="notes" /></p></s:if>
					</div>
					<span class="clearfix borda"></span>
				</article>
			</s:iterator>
			<s:include value="/WEB-INF/jsp/paging-advsearch.jsp">
				<s:param name="page" value="pagedTrainer.page" />
				<s:param name="pages" value="pagedTrainer.pages" />
				<s:param name="pageSize" value="pagedTrainer.pageSize" />
				<s:param name="href" value="%{''}" />
				<s:param name="selectedType" value="selectedType" />
				<s:param name="selTrainers" value="parse2Trainerslink" />
				<s:param name="crps" value="parse2Crpslink" />
				<s:param name="hubs" value="parse2Hubslink" />
				<s:param name="coreCompetencies" value="parse2Coreslink" />
				<s:param name="sponsors" value="parse2Sponsorslink" />
				<s:param name="fullText" value="fullText" />
				<s:param name="groupYearly" value="groupYearly" />
				<s:param name="cc" value="cc" />
			</s:include>
	</s:if>
	<s:if test="pagedTrainer.totalHits==0 && table.equals('Trainer')">
		<article class="search-result">
			<em>No trainer records found!</em>
		</article>
	</s:if>
	
	
	<s:if test="pagedProposals.totalHits > 0">
	
		<s:include value="/WEB-INF/jsp/paging-advsearch.jsp">
			<s:param name="page" value="pagedProposals.page" />
			<s:param name="pages" value="pagedProposals.pages" />
			<s:param name="pageSize" value="pagedProposals.pageSize" />
			<s:param name="href" value="%{''}" />
			<s:param name="selectedType" value="selectedType" />
			<s:param name="selTrainers" value="parse2Trainerslink" />
			<s:param name="crps" value="parse2Crpslink" />
			<s:param name="hubs" value="parse2Hubslink" />
			<s:param name="coreCompetencies" value="parse2Coreslink" />
			<s:param name="sponsors" value="parse2Sponsorslink" />
			<s:param name="fullText" value="fullText" />
			<s:param name="groupYearly" value="groupYearly" />
			<s:param name="cc" value="cc" />
		</s:include>
		<hgroup class="mb20">
			<h1>Search Results</h1>
			<h2 class="lead"><strong class="text-danger"><s:property value="pagedProposals.totalHits" /></strong> results were found for the search criteria supplied</h2>								
		</hgroup>
		
			<s:iterator value="pagedProposals.results" status="status">
				<article class="search-result">
					<div class="col-xs-12 col-sm-12 col-md-2">
						<s:property value="#status.count + pagedProposals.startAt" />. <s:property	value="requester.fullName" /> (Requester)
						<s:if test="type!=null"><p><s:property value="type" /></p></s:if>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-4">
						<p>Status: <strong><s:property	value="status" />:</strong> 
							<s:if test="title!=null">
								<a href="<s:url action="announcement/trainingproposal-details" />?id=<s:property value="id" />"><iita:text value="title" maxLength="500" /></a>
							</s:if>
						</p>
						<p>
							<s:if test="trainingLocations!=null">
								<strong>Training Location(s):</strong>
								<ul class="meta-search">
									<s:iterator value="trainingLocations">
										<li><i class="glyphicon glyphicon-tags"></i> <span><strong>-</strong><s:property value="venue" />, <s:property value="country" /> <s:date format="%{getText('date.format')}"
										name="startDate" />-<s:date format="%{getText('date.format')}" name="endDate" /> <strong>(<s:property value="duration" />)</strong></span></li>
									</s:iterator>
								</ul>
							</s:if>
						</p>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-6 excerpet">
						<s:if test="projectInformation!=null">
							<p><em><strong>Project information:</strong></em><br /><iita:text value="projectInformation" maxLength="150" removeHTML="true" addDots="true" />
						</s:if>
						<s:if test="activity!=null">
							<p><em><strong>Activity:</strong></em><br /><iita:text value="activity" maxLength="150" removeHTML="true" addDots="true" />
						</s:if>
						<s:if test="trainers!=null">
							<p>
								<s:iterator value="trainers">
									<strong>-</strong><s:include value="/WEB-INF/jsp/trainer/trainingproposalsmall.jsp" /><br />
								</s:iterator>
							</p>
						</s:if>
						<s:if test="documents!=null">
							<p>
								<s:iterator value="documents">
									<strong>-</strong><a href="<s:url action="announcement/document-download" />?id=<s:property value="top.id" />&file=<s:property value="document.filePath" />" target="_blank"><s:property value="document.filePath" /></a><br />
								</s:iterator>
							</p>
						</s:if>
					</div>
					<span class="clearfix borda"></span>
				</article>
			</s:iterator>
			<s:include value="/WEB-INF/jsp/paging-advsearch.jsp">
				<s:param name="page" value="pagedProposals.page" />
				<s:param name="pages" value="pagedProposals.pages" />
				<s:param name="pageSize" value="pagedProposals.pageSize" />
				<s:param name="href" value="%{''}" />
				<s:param name="selectedType" value="selectedType" />
				<s:param name="selTrainers" value="parse2Trainerslink" />
				<s:param name="crps" value="parse2Crpslink" />
				<s:param name="hubs" value="parse2Hubslink" />
				<s:param name="coreCompetencies" value="parse2Coreslink" />
				<s:param name="sponsors" value="parse2Sponsorslink" />
				<s:param name="fullText" value="fullText" />
				<s:param name="groupYearly" value="groupYearly" />
				<s:param name="cc" value="cc" />
			</s:include>
	</s:if>
	<s:if test="pagedProposals.totalHits==0 && table.equals('TrainingProposal')">
		<article class="search-result">
			<em>No records available from training proposals!</em>
		</article>
	</s:if>
</div>
</div>