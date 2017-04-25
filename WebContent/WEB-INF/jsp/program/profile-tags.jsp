<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title><s:property value="profile.title" /> Tag builder</title>
</head>
<body>
<%@ include file="program-navigation.jsp" %>

<s:form method="post" action="program/tags!update">
<s:hidden name="id" value="%{profile.id}" />
<s:include value="/WEB-INF/jsp/tags/builder.jsp" />
<s:submit value="Save tags" />
</s:form>

<ul class="taglist">
	<iita:authorize ifAnyGranted="ROLE_CGO,ROLE_ADMIN">
		<li><span id="newGroupTrainingTag"><b>Add tag</b></span> <iita:authorize ifAnyGranted="ROLE_CGO, ROLE_ADMIN">
			<s:bean name="org.iita.trainingunit.model.TrainingProgramTag">
				<s:param name="entity" value="[1].profile" />
				<iita:inlineeditor id="" targetId="newGroupTrainingTag">
					<s:include value="/WEB-INF/jsp/tags/tag-form.jsp" />
				</iita:inlineeditor>
			</s:bean>
		</iita:authorize></li>
	</iita:authorize>
</ul>
</body>
</html>