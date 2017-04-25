<%@ include file="/common/taglibs.jsp"%>
<div class="navigation-tabs clearfloat">
	<a href="<s:url action="organization/profile" />?id=<s:property value="profile.id" />">Profile</a>
	<a href="<s:url action="organization/affiliations" />?id=<s:property value="profile.id" />">Affiliations</a>
	<iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_CGO">
		<a href="<s:url action="organization/tags" />?id=<s:property value="profile.id" />">Tags</a>
	</iita:authorize>
</div>
