<%@ page import="com.java.code.Model.Homework" %>
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
    作业列表
</h1>
<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">
        <td>作业编号</td>
        <td>作业标题</td>
    </tr>
    <%
        List<Homework> list = (List<Homework>) request.getAttribute("homeworklist");
        if (null == list || list.size() <= 0) {
            out.print("None data.");
        } else {
            for (Homework sh : list) {
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=sh.getHomeworkId()%>
        </td>
        <td><%=sh.getHomeworkTitle()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
