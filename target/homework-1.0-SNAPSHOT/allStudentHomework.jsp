<%@ page import="com.java.code.Model.StudentHomework" %>
<%@ page import="com.java.code.jdbc.StudentHomeworkJdbc" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zym
  Date: 2020/3/10
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homework System</title>
</head>
<body align="center">
<h1 >
    学生作业列表
</h1>
<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">
        <td>ID</td>
        <td>学生学号</td>
        <td>作业编号</td>
        <td>作业标题</td>
        <td>作业内容</td>
        <td>提交时间</td>
    </tr>
    <%
        List<StudentHomework> list = (List<StudentHomework>) request.getAttribute("studentHomeworklist");
        if (null == list || list.size() <= 0) {
            out.print("None data.");
        } else {
            for (StudentHomework sh : list) {
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=sh.getId()%></td>
        <td><%=sh.getStudentId()%></td>
        <td><%=sh.getHomeworkId()%></td>
        <td><%=sh.getHomeworkTitle()%></td>
        <td><%=sh.getHomeworkContent()%></td>
        <td><%=sh.getUpdateTime()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
