<%--
  Created by IntelliJ IDEA.
  User: 或
  Date: 2019/3/18
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.println( "Your IP address is" + request.getRemoteAddr() );

    out.println( response.getWriter() );
%>
    aa

</body>
</html>
