<%@ page import="com.java.code.Model.StudentHomework" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.code.jdbc.StudentHomeworkJdbc" %><%--
  Created by IntelliJ IDEA.
  User: zym
  Date: 2020/3/10
  Time: 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Homework System</title>
    <style>
        .button {
            display: inline-block;
            padding: 15px 25px;
            font-size: 24px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            outline: none;
            color: #fff;
            background-color: #4CAF50;
            border: none;
            border-radius: 15px;
            box-shadow: 0 9px #999;
        }

        .button:hover {background-color: #3e8e41}

        .button:active {
            background-color: #3e8e41;
            box-shadow: 0 5px #666;
            transform: translateY(4px);
        }
    </style>
</head>

<body align="center">
<h1 >
    简易作业管理系统
</h1>
<a href="http://localhost:8080/homework_war_exploded/allStudentHomework" style='text-decoration:none;'>
    <button class="button">查询学生作业</button>
</a>
<br/><br/>
<a href="http://localhost:8080/homework_war_exploded/allStudent" style='text-decoration:none;'>
    <button class="button">查询学生信息</button>
</a>
<br/><br/>
<a href="http://localhost:8080/homework_war_exploded/addStudent" style='text-decoration:none;'>
    <button class="button">添加学生</button>
</a>
<br/><br/>
<a href="http://localhost:8080/homework_war_exploded/allHomework" style='text-decoration:none;'>
    <button class="button">查询作业</button>
</a>
<br/><br/>
<a href="http://localhost:8080/homework_war_exploded/publishHomework" style='text-decoration:none;'>
    <button class="button">发布作业</button>
</a>
<br/><br/>
<a href="http://localhost:8080/homework_war_exploded/submitHomework" style='text-decoration:none;'>
    <button class="button">提交作业</button>
</a>

</body>

</html>
