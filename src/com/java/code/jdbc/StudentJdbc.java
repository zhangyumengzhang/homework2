package com.java.code.jdbc;

import com.java.code.Model.Student;
import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbc {
    //获取所有学生信息
    public static List<Student> selectAllStudent() {

        String url = "jdbc:mysql://localhost:3306/javaee?serverTimezone=UTC&useSSL=false";
        String username = "root";
        String password = "123456";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String sqlString = "SELECT * FROM student";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Student> list = new ArrayList<>();
        //建立连接
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    // 获取执行结果
                    while (resultSet.next()) {
                        Student s = new Student();
                        s.setStudentId(resultSet.getInt("student_id"));
                        s.setStudentName(resultSet.getString("student_name"));
                        list.add(s);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //增加新的学生
    public static boolean addStudent(Student s) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/javaee?serverTimezone=UTC&useSSL=false";
        String username = "root";
        String password = "123456";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String sqlString = "insert into student(student_id,student_name)values(?,?)";

        //判断该学生是否已经存在
        boolean isStudent = true;

        List<Student> slist = StudentJdbc.selectAllStudent();

        for (Student stud : slist) {
            if (stud.getStudentId() == s.getStudentId()) {
                isStudent = false;
                break;
            }
        }
        //如果存在返回FALSE
        if (isStudent == false) {
            return false;
        }
        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //建立连接
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement pst = connection.prepareStatement(sqlString);
            pst.setLong(1, s.getStudentId());
            pst.setString(2, s.getStudentName());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
