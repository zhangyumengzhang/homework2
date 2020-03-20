package com.java.code.jdbc;

import com.java.code.Model.Student;
import com.java.code.Model.StudentHomework;
import com.java.code.Model.Homework;
import main.java.com.java.code.util.jdbcutil;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {
    //添加学生作业
    public static boolean addStudentHomework(StudentHomework sh) throws ClassNotFoundException {

        Connection connection = jdbcutil.getConnection();
        String sqlString = "insert into student_homework(id,student_id,homework_id,homework_title,homework_content,update_time)values(?,?,?,?,?,?)";

        //获取系统当前时间
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        //将新的学生作业信息补充完整
        sh.setHomeworkTitle(HomeworkJdbc.getTitlebyId(sh.getHomeworkId()));
        sh.setUpdateTime(currentTime);
        //判断该学生以及该作业是否存在
        boolean isstudent = false;
        boolean ishomework = false;

        List<Student> slist = StudentJdbc.selectAllStudent();
        List<Homework> hlist = HomeworkJdbc.selectAllHomework();

        for (Student s : slist) {
            if (s.getStudentId() == sh.getStudentId()) {
                isstudent = true;
                break;
            }
        }
        for (Homework h : hlist) {
            if (h.getHomeworkId() == sh.getHomeworkId()) {
                ishomework = true;
                break;
            }
        }
        //如果学生或者不存在或者作业不存在均返回FALSE
        if (isstudent == false || ishomework == false) {
            return false;
        }

        try {
            PreparedStatement pst = connection.prepareStatement(sqlString);
            pst.setInt(1, sh.getId());
            pst.setInt(2, sh.getStudentId());
            pst.setInt(3, sh.getHomeworkId());
            pst.setString(4, sh.getHomeworkTitle());
            pst.setString(5, sh.getHomeworkContent());
            pst.setString(6, sh.getUpdateTime());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    //获取所有学生提交作业
    public static List<StudentHomework> selectAll() {

        Connection connection = jdbcutil.getConnection();
        String sqlString = "SELECT * FROM student_homework";


        List<StudentHomework> list = new ArrayList<>();
        //建立连接

        try {
            PreparedStatement pst = connection.prepareStatement(sqlString);
            ResultSet resultSet = pst.executeQuery();
            // 获取执行结果
            while (resultSet.next()) {
                StudentHomework sh = new StudentHomework();
                sh.setId(resultSet.getInt("id"));
                sh.setStudentId(resultSet.getInt("student_id"));
                sh.setHomeworkId(resultSet.getInt("homework_id"));
                sh.setHomeworkTitle(resultSet.getString("homework_title"));
                sh.setHomeworkContent(resultSet.getString("homework_content"));
                sh.setUpdateTime(resultSet.getString("update_time"));
                list.add(sh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}