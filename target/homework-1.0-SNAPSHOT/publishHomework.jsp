<%--
  Created by IntelliJ IDEA.
  User: zym
  Date: 2020/3/10
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homework System</title>
</head>
<body align="center">
<h1 >
    发布作业
</h1>
<form align="center" method="POST" action="/homework_war_exploded/publishHomework">
    <tr >
        <td >作业编号</td>
        <td ><input type="text" name="homework_id"  size="20" maxlength="20"/></td>
        <br/> <br/> <br/>
    </tr>
    <tr>
        <td >作业标题</td>
        <td ><input type="text" name="homework_title"  size="20" maxlength="20"/></td>
        <br/> <br/> <br/>
    </tr>

    <table align="center">
        <tr>
            <td><input type="submit" name="add" value="发布"/></td>
        </tr>
    </table>

</form>
</body>
</html>
