<%@ include file="/common/taglibs.jsp"%>
<div class="navigation-tabs clearfloat">
	<a href="<s:url action="trainee/profile" />?id=<s:property value="profile.id" />">Profile</a>
	<iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_MERGE,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
			<a href="<s:url action="trainee/tags" />?id=<s:property value="profile.id" />">Tags</a>
		</iita:authorize>
</div>
