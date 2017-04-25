<%@ include file="/common/taglibs.jsp"%>

<s:if test="groups.size() > 0">
<div class="button-bar">
	Click links to view available advertised Training Announcements details
</div>

<s:if test="groups.size() > 0 || graduates.size() > 0">
<h2>Group Training</h2>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="groups">
						<li>
							<s:if test="user==null">
								<a href="<s:url action="fulldetail" />?id=<s:property value="id" />">
							</s:if>
							<s:else>
								<a href="<s:url action="announcementdetail" />?id=<s:property value="id" />">
							</s:else>
								<s:if test="type!=null"><s:property value="type" />: </s:if>
									<s:if test="title!=null">
										<s:property value="title" />
										<s:if test="deadline!=null">
											(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
										</s:if>
									</s:if>
								<s:else>
									Unspecified title
									<s:if test="deadline!=null">
										(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
									</s:if>
								</s:else>
							</a>
						</li>
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="graduates.size() > 0">
<h2>Graduate Training</h2>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="graduates">
						<li>
							<s:if test="user==null">
								<a href="<s:url action="fulldetail" />?id=<s:property value="id" />">
							</s:if>
							<s:else>
								<a href="<s:url action="announcementdetail" />?id=<s:property value="id" />">
							</s:else>
							<s:if test="type!=null"><s:property value="type" />: </s:if>
							<s:if test="title!=null">
								<s:property value="title" />
								<s:if test="deadline!=null">
									(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="deadline!=null">
									(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="duration!=null && duration.length()>0"> - <s:property value="duration" /></s:if>
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="nonDegrees.size() > 0">
<h2>Non Degree Training</h2>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="nonDegrees">
						<li>
							<s:if test="user==null">
								<a href="<s:url action="fulldetail" />?id=<s:property value="id" />">
							</s:if>
							<s:else>
								<a href="<s:url action="announcementdetail" />?id=<s:property value="id" />">
							</s:else>
							<s:if test="type!=null"><s:property value="type" />: </s:if>
							<s:if test="title!=null">
								<s:property value="title" />
								<s:if test="deadline!=null">
									(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="deadline!=null">
									(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="duration!=null && duration.length()>0"> - <s:property value="duration" /></s:if>
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>

<s:if test="user.authenticationType.toString()=='PASSWORD' || user.mail.indexOf('@cgiar.org')<=0">
	<s:if test="inhouseGroup.size() > 0">
		<h2>In-house Group</h2>
		<table class="data-listing">
			<tr>
				<td>
					<ul>
						<s:iterator value="inhouseGroup">
							<li>
								<s:if test="user==null">
									<a href="<s:url action="fulldetail" />?id=<s:property value="id" />">
								</s:if>
								<s:else>
									<a href="<s:url action="announcementdetail" />?id=<s:property value="id" />">
								</s:else>
								<s:if test="type!=null"><s:property value="type" />: </s:if>
								<s:if test="title!=null">
									<s:property value="title" />
									<s:if test="deadline!=null">
										(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
									</s:if>
								</s:if>
								<s:else>
									Unspecified title
									<s:if test="deadline!=null">
										(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
									</s:if>
								</s:else>
								</a><s:if test="duration!=null && duration.length()>0"> - <s:property value="duration" /></s:if>
							</li>	
						</s:iterator>
					</ul>
				</td>
			</tr>
		</table>
	</s:if>
	
	<s:if test="individual.size() > 0">
		<h2>Individual</h2>
		<table class="data-listing">
			<tr>
				<td>
					<ul>
						<s:iterator value="individual">
							<li>
								<s:if test="user==null">
									<a href="<s:url action="fulldetail" />?id=<s:property value="id" />">
								</s:if>
								<s:else>
									<a href="<s:url action="announcementdetail" />?id=<s:property value="id" />">
								</s:else>
								<s:if test="type!=null"><s:property value="type" />: </s:if>
								<s:if test="title!=null">
									<s:property value="title" />
									<s:if test="deadline!=null">
										(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
									</s:if>
								</s:if>
								<s:else>
									Unspecified title
									<s:if test="deadline!=null">
										(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
									</s:if>
								</s:else>
								</a><s:if test="duration!=null && duration.length()>0"> - <s:property value="duration" /></s:if>
							</li>	
						</s:iterator>
					</ul>
				</td>
			</tr>
		</table>
	</s:if>
	
	<s:if test="sabbatical.size() > 0">
		<h2>Sabbatical</h2>
		<table class="data-listing">
			<tr>
				<td>
					<ul>
						<s:iterator value="sabbatical">
							<li>
								<s:if test="user==null">
									<a href="<s:url action="fulldetail" />?id=<s:property value="id" />">
								</s:if>
								<s:else>
									<a href="<s:url action="announcementdetail" />?id=<s:property value="id" />">
								</s:else>
								<s:if test="type!=null"><s:property value="type" />: </s:if>
								<s:if test="title!=null">
									<s:property value="title" />
									<s:if test="deadline!=null">
										(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
									</s:if>
								</s:if>
								<s:else>
									Unspecified title
									<s:if test="deadline!=null">
										(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
									</s:if>
								</s:else>
								</a><s:if test="duration!=null && duration.length()>0"> - <s:property value="duration" /></s:if>
							</li>	
						</s:iterator>
					</ul>
				</td>
			</tr>
		</table>
	</s:if>
	
	<s:if test="staffDevelopment.size() > 0">
		<h2>Staff Development</h2>
		<table class="data-listing">
			<tr>
				<td>
					<ul>
						<s:iterator value="staffDevelopment">
							<li>
								<s:if test="user==null">
									<a href="<s:url action="fulldetail" />?id=<s:property value="id" />">
								</s:if>
								<s:else>
									<a href="<s:url action="announcementdetail" />?id=<s:property value="id" />">
								</s:else>
								<s:if test="type!=null"><s:property value="type" />: </s:if>
								<s:if test="title!=null">
									<s:property value="title" />
									<s:if test="deadline!=null">
										(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
									</s:if>
								</s:if>
								<s:else>
									Unspecified title
									<s:if test="deadline!=null">
										(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
									</s:if>
								</s:else>
								</a><s:if test="duration!=null && duration.length()>0"> - <s:property value="duration" /></s:if>
							</li>	
						</s:iterator>
					</ul>
				</td>
			</tr>
		</table>
	</s:if>
</s:if>

<s:if test="others.size() > 0">
<h2>Other Training</h2>
	<table class="data-listing">
		<tr>
			<td>
				<ul>
					<s:iterator value="others">
						<li>
							<s:if test="user==null">
								<a href="<s:url action="fulldetail" />?id=<s:property value="id" />">
							</s:if>
							<s:else>
								<a href="<s:url action="announcementdetail" />?id=<s:property value="id" />">
							</s:else>
							<s:if test="type!=null"><s:property value="type" />: </s:if>
							<s:if test="title!=null">
								<s:property value="title" />
								<s:if test="deadline!=null">
									(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
								</s:if>
							</s:if>
							<s:else>
								Unspecified title
								<s:if test="deadline!=null">
									(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
								</s:if>
							</s:else>
							</a><s:if test="duration!=null && duration.length()>0"> - <s:property value="duration" /></s:if>
						</li>	
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
</s:if>
</s:if>