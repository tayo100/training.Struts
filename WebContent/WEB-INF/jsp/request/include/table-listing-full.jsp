<%@ include file="/common/taglibs.jsp"%>

<table class="data-listing">
	<colgroup>
		<col width="50" />
		<col width="170px" />
		<col width="170px" />
		<col width="250px" />		
		<col />
	</colgroup>
	<thead>
		<tr>
			<td>#</td>
			<td>Owner</td>
			<td>Type</td>
			<td>Waiting For</td>
			<td>Request Title</td>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="paged.results" status="status">
			<tr class="tastatus-<s:property value="status" /> ht">
				<td><s:property value="#status.count + paged.startAt" /></td>
				<td><s:property value="biodata.owner.fullName" /><br /><small><s:property value="status" /></small></td>
				
				<td class="identifying"><s:property value="top.class.simpleName.substring(0, top.class.simpleName.indexOf('Training'))" /></td>
				
				<td>
					<s:iterator value="[1].waitingFor(top)" status="status">
						<s:property value="fullName" /><br/>
					</s:iterator>
				</td>
				
				<td>
					<s:if test="%{top instanceof org.iita.trainingunit.applications.model.GroupTraining}">
						<div>
							<a href="<s:url action="view" />?id=<s:property value="id" />">
								<s:if test="trainingTopic==null || trainingTopic==''">
									[Not titled]
								</s:if>
								<s:else>
									<s:property value="trainingTopic" />
								</s:else>
							</a>
						</div>
					</s:if>
					
					<s:if test="%{top instanceof org.iita.trainingunit.applications.model.InternshipTraining}">
						<div>
							<a href="<s:url action="view" />?id=<s:property value="id" />">
								<s:if test="areaOfSpecialization==null || areaOfSpecialization==''">
									[Not titled]
								</s:if>
								<s:else>
									<s:property value="areaOfSpecialization" />
								</s:else>
							</a>
						</div>
					</s:if>
					
					<s:if test="%{top instanceof org.iita.trainingunit.applications.model.GraduateResearchTraining}">
						<div>
							<a href="<s:url action="view" />?id=<s:property value="id" />">
								<s:if test="projectSummaries.title==null || projectSummaries.title==''">
									[Not titled]
								</s:if>
								<s:else>
									<s:property value="projectSummaries.title" />
								</s:else>
							</a>
						</div>
					</s:if>
					
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.NonDegreeTraining}">
						<div>
							<a href="<s:url action="view" />?id=<s:property value="id" />">
								<s:if test="trainingReceived==null || trainingReceived==''">
									[Not titled]
								</s:if>
								<s:else>
									<s:property value="trainingReceived" />
								</s:else>
							</a>
						</div>
					</s:elseif>
										
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.OtherTraining}">
						<div>
							<a href="<s:url action="view" />?id=<s:property value="id" />">
								<s:if test="refNumber==null || refNumber==''">
									[Not titled]
								</s:if>
								<s:else>
									<s:property value="refNumber" />
								</s:else>
							</a>
						</div>
					</s:elseif>
										
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.IndividualTraining}">
						<div>
							<a href="<s:url action="view" />?id=<s:property value="id" />">
								<s:if test="refNumber==null || refNumber==''">
									[Not titled]
								</s:if>
								<s:else>
									<s:property value="refNumber" />
								</s:else>
							</a>
						</div>
					</s:elseif>
										
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.SabbaticalTraining}">
						<div>
							<a href="<s:url action="view" />?id=<s:property value="id" />">
								<s:if test="sabProjectSummaries.theme==null || sabProjectSummaries.theme==''">
									[Not titled]
								</s:if>
								<s:else>
									<s:property value="sabProjectSummaries.theme" />
								</s:else>
							</a>
						</div>
					</s:elseif>
										
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.InHouseTraining}">
						<div>
							<a href="<s:url action="view" />?id=<s:property value="id" />">
								<s:if test="refNumber==null || refNumber==''">
									[Not titled]
								</s:if>
								<s:else>
									<s:property value="refNumber" />
								</s:else>
							</a>
						</div>
					</s:elseif>
										
					<s:elseif test="%{top instanceof org.iita.trainingunit.applications.model.StaffDevTraining}">
						<div>
							<a href="<s:url action="view" />?id=<s:property value="id" />">
								<s:if test="refNumber==null || refNumber==''">
									[Not titled]
								</s:if>
								<s:else>
									<s:property value="refNumber" />
								</s:else>
							</a>
						</div>
					</s:elseif>
				</td>
				
			</tr>
		</s:iterator>
	</tbody>
</table>