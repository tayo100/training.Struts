<%@ include file="/common/taglibs.jsp"%>

<h2>Tags</h2>
<ul class="taglist">
	<s:iterator value="announcement.tags">
		<li><s:include value="/WEB-INF/jsp/tags/tag-readonly.jsp" /></li>
	</s:iterator>
	<iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
		<li><span id="newProjectTag"><b>Add tag</b></span> 
		<iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_QUERYMANAGER,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
			<s:bean name="org.iita.crm.model.AnnouncementTag">
				<s:param name="entity" value="[1].announcement" />
				<iita:inlineeditor id="" targetId="newProjectTag">
					<s:include value="/WEB-INF/jsp/tags/tag-form.jsp" />
				</iita:inlineeditor>
			</s:bean>
		</iita:authorize></li>
	</iita:authorize>
</ul>