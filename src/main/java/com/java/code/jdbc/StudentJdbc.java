package com.java.code.jdbc;

import com.java.code.Model.Student;
import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;
import main.java.com.java.code.util.jdbcutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbc {
    //获取所有学生信息
    public static List<Student> selectAllStudent() {

        Connection connection = jdbcutil.getConnection();
        String sqlString = "SELECT * FROM student";

        List<Student> list = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement(sqlString);
            ResultSet resultSet = pst.executeQuery();
            // 获取执行结果
            while (resultSet.next()) {
                Student s = new Student();
                s.setStudentId(resultSet.getInt("student_id"));
                s.setStudentName(resultSet.getString("student_name"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //增加新的学生
    public static boolean addStudent(Student s) throws ClassNotFoundException {
        Connection connection = jdbcutil.getConnection();
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

        //建立连接
        try  {
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
