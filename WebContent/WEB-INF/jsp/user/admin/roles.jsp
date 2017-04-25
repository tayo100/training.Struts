<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>User roles</title>
</head>
<body>
<s:include value="include/search.jsp" />

<a href="<s:url action="user/user!input" namespace="/admin" />">Add New User</a>
<a href="<s:url action="users" namespace="/admin" />">List all users</a>
<a href="<s:url action="user/roles" namespace="/admin" />">Roles</a>

<div style="margin: 5px 0px;">
<b>All available roles: </b>
<s:iterator value="allRoles">
<a style="margin-left: 10px;" href="?role=<s:property />"><s:property value="top.substring(5)" /></a>
</s:iterator>
</div>

<s:include value="include/userlist.jsp" />
</body>
</html>