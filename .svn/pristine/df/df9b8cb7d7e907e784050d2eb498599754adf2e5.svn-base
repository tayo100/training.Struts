<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title><s:property value="profile.title" /> Tag builder</title>
</head>
<body>
<%@ include file="trainee-navigation.jsp" %>

<s:form method="post" action="trainee/tags!update">
<s:hidden name="id" value="%{profile.id}" />
<s:include value="/WEB-INF/jsp/tags/builder.jsp" />
<s:submit value="Save tags" />
</s:form>

<ul class="taglist">
	<iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_MERGE,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
		<li><span id="newTraineeTag"><b>Add tag</b></span> <iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_MERGE,ROLE_TRAININGUNITHEAD,ROLE_HEAD">
			<s:bean name="org.iita.trainingunit.model.TraineeTag">
				<s:param name="entity" value="[1].profile" />
				<iita:inlineeditor id="" targetId="newTraineeTag">
					<s:include value="/WEB-INF/jsp/tags/tag-form.jsp" />
				</iita:inlineeditor>
			</s:bean>
		</iita:authorize></li>
	</iita:authorize>
</ul>
</body>
</html>