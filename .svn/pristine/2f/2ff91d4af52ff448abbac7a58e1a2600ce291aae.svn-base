<%@ include file="/common/taglibs.jsp"%>
<div class="navigation-tabs clearfloat">
	<a href="<s:url action="program/profile" />?id=<s:property value="profile.id" />">Profile</a>
	<iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_CGO">
			<a href="<s:url action="program/tags" />?id=<s:property value="profile.id" />">Tags</a>
		</iita:authorize>
</div>
