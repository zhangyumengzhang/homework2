<%--
  Created by IntelliJ IDEA.
  User: zym
  Date: 2020/3/10
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homework System</title>
</head>
<body align="center">
<h1 >
    添加学生
</h1>
<form align="center" method="POST" action="/homework_war_exploded/addStudent">
    <tr>
        <td>学生学号</td>
        <td><input type="text" name="student_id" size="50"/></td>
        <br/> <br/> <br/>
    </tr>
    <tr>
        <td>学生姓名</td>
        <td><input type="text" name="student_name" size="50"/></td>
        <br/> <br/> <br/>
    </tr>

    <table align="center">
        <tr>
            <td><input type="submit" name="add" value="添加"/></td>
        </tr>
    </table>

</form>

</body>
</html>
