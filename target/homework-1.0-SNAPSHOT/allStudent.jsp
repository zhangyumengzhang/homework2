<%@ page import="com.java.code.Model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zym
  Date: 2020/3/10
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homework System</title>
</head>
<body align="center">
<h1 >
    学生列表
</h1>
<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">
        <td>学生学号</td>
        <td>学生姓名</td>
    </tr>
    <%
        List<Student> list = (List<Student>) request.getAttribute("studentlist");
        if (null == list || list.size() <= 0) {
            out.print("None data.");
        } else {
            for (Student sh : list) {
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=sh.getStudentId()%>
        </td>
        <td><%=sh.getStudentName()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
