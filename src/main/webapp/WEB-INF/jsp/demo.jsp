<%--
  Created by IntelliJ IDEA.
  User: 或
  Date: 2018/4/29
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/demo" method="post">
        id<input type="text" name="id">
        <input type="submit" value="提交">
    </form>
</body>
</html>
