<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Users</title>
</head>
<body>
<s:include value="include/search.jsp" />

<a href="<s:url action="user/user!input" namespace="/admin" />">Add New User</a>
<a href="<s:url action="users" namespace="/admin" />">List all users</a>
<a href="<s:url action="user/roles" namespace="/admin" />">Roles</a>

<s:include value="include/userlist.jsp" />
</body>
</html>