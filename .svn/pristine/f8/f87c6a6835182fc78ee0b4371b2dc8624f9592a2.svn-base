<%@ include file="/common/taglibs.jsp"%>

<div class="myapp-bar">
	My uncompleted training applications
</div>

<s:if test="groupUncompleted.size() > 0">
<h3>Group Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="groupUncompleted">
						<li>
							<a href="<s:url action="draft" />?applicationId=<s:property value="id" />&announcementId=<s:property value="announcement.id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Estimated Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- Submission Status: <s:property value="submissionStatus" />
						</li>
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="graduateUncompleted.size() > 0">
<h3>Graduate Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="graduateUncompleted">
						<li>
							<a href="<s:url action="draft" />?applicationId=<s:property value="id" />&announcementId=<s:property value="announcement.id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Estimated Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- Submission Status: <s:property value="submissionStatus" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="internshipUncompleted.size() > 0">
<h3>Internship Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="internshipUncompleted">
						<li>
							<a href="<s:url action="draft" />?applicationId=<s:property value="id" />&announcementId=<s:property value="announcement.id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Estimated Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- Submission Status: <s:property value="submissionStatus" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="nondegreeUncompleted.size() > 0">
<h3>Non Degree Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="nondegreeUncompleted">
						<li>
							<a href="<s:url action="draft" />?applicationId=<s:property value="id" />&announcementId=<s:property value="announcement.id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Estimated Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- Submission Status: <s:property value="submissionStatus" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="otherUncompleted.size() > 0">
<h3>Other Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="otherUncompleted">
						<li>
							<a href="<s:url action="draft" />?applicationId=<s:property value="id" />&announcementId=<s:property value="announcement.id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Estimated Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- Submission Status: <s:property value="submissionStatus" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="individualUncompleted.size() > 0">
<h3>Individual Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="individualUncompleted">
						<li>
							<a href="<s:url action="draft" />?applicationId=<s:property value="id" />&announcementId=<s:property value="announcement.id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Estimated Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- Submission Status: <s:property value="submissionStatus" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="sabbaticalUncompleted.size() > 0">
<h3>Sabbatical Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="sabbaticalUncompleted">
						<li>
							<a href="<s:url action="draft" />?applicationId=<s:property value="id" />&announcementId=<s:property value="announcement.id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Estimated Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- Submission Status: <s:property value="submissionStatus" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="staffDevUncompleted.size() > 0">
<h3>Staff Development Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="staffDevUncompleted">
						<li>
							<a href="<s:url action="draft" />?applicationId=<s:property value="id" />&announcementId=<s:property value="announcement.id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Estimated Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- Submission Status: <s:property value="submissionStatus" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="inHouseUncompleted.size() > 0">
<h3>In-house Group Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="inHouseUncompleted">
						<li>
							<a href="<s:url action="draft" />?applicationId=<s:property value="id" />&announcementId=<s:property value="announcement.id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Estimated Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- Submission Status: <s:property value="submissionStatus" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="nondegreeUncompleted.size()==0 && graduateUncompleted.size()==0 && groupUncompleted.size()==0 && otherUncompleted.size()==0 && individualUncompleted.size()==0 && staffDevUncompleted.size()==0 && sabbaticalUncompleted.size()==0 && inHouseUncompleted.size()==0 && internshipUncompleted.size()==0">
	<p>No uncompleted training application found.</p>
</s:if>

<div class="myapp-bar">
	My submitted training applications
</div>

<s:if test="groupApplication.size() > 0">
<h3>Group Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="groupApplication">
						<li>
							<a href="<s:url action="appdetails" />?applicationId=<s:property value="id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Tentative Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- Status: <s:property value="status" />
						</li>
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="graduateApplication.size() > 0">
<h3>Graduate Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="graduateApplication">
						<li>
							<a href="<s:url action="appdetails" />?applicationId=<s:property value="id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Tentative Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- <s:text name="application.status.%{status}" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="internshipApplication.size() > 0">
<h3>Internship Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="internshipApplication">
						<li>
							<a href="<s:url action="appdetails" />?applicationId=<s:property value="id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Tentative Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- <s:text name="application.status.%{status}" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="nondegreeApplication.size() > 0">
<h3>Non Degree Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="nondegreeApplication">
						<li>
							<a href="<s:url action="appdetails" />?applicationId=<s:property value="id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Tentative Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- <s:text name="application.status.%{status}" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="otherApplication.size() > 0">
<h3>Other Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="otherApplication">
						<li>
							<a href="<s:url action="appdetails" />?applicationId=<s:property value="id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Tentative Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- <s:text name="application.status.%{status}" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="individualApplication.size() > 0">
<h3>Individual Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="individualApplication">
						<li>
							<a href="<s:url action="appdetails" />?applicationId=<s:property value="id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Tentative Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- <s:text name="application.status.%{status}" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="sabbaticalApplication.size() > 0">
<h3>Sabbatical Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="sabbaticalApplication">
						<li>
							<a href="<s:url action="appdetails" />?applicationId=<s:property value="id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Tentative Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- <s:text name="application.status.%{status}" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="inHouseApplication.size() > 0">
<h3>In-house Group Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="inHouseApplication">
						<li>
							<a href="<s:url action="appdetails" />?applicationId=<s:property value="id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Tentative Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- <s:text name="application.status.%{status}" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="staffDevApplication.size() > 0">
<h3>Staff Development Training</h3>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="staffDevApplication">
						<li>
							<a href="<s:url action="appdetails" />?applicationId=<s:property value="id" />">
							<s:if test="announcement.type!=null"><s:property value="announcement.type" />: </s:if>
							<s:if test="announcement.title!=null">
								<s:property value="announcement.title" />
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="announcement.deadline!=null">
									(Deadline - <s:date format="%{getText('date.format')}" name="announcement.deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="announcement.duration!=null && announcement.duration.length()>0"> - <s:property value="announcement.duration" /></s:if>
							<s:if test="otherAppDetails.startDate!=null">
							- Tentative Start date: <s:date format="%{getText('date.format')}" name="otherAppDetails.startDate" /></s:if>
							- <s:text name="application.status.%{status}" />
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="nongraduateApplication.size()==0 && graduateApplication.size()==0 && groupApplication.size()==0 && otherApplication.size()==0 && individualApplication.size()==0 && staffDevApplication.size()==0 && inHouseApplication.size()==0 && sabbaticalApplication.size()==0">
	<p>No submitted training applications found.</p>
</s:if>