package com.java.code.jdbc;

import com.java.code.Model.Student;
import com.java.code.Model.Teacher;
import main.java.com.java.code.util.jdbcutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginJdbc {
    public  static boolean slogin(Student s){
        Connection connection = jdbcutil.getConnection();
        String sqlString = "select * from student where student_id=?";
        //建立连接
        try  {
            PreparedStatement pst = connection.prepareStatement(sqlString);
            pst.setLong(1, s.getStudentId());
            ResultSet resultSet=pst.executeQuery();
            if (resultSet.next()){
                if(s.getPassword().equals(resultSet.getString("password"))){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean tlogin(Teacher t) {
        Connection connection = jdbcutil.getConnection();
        String sqlString = "select * from teacher where teacher_id=?";
        //建立连接
        try {
            PreparedStatement pst = connection.prepareStatement(sqlString);
            pst.setLong(1, t.getTeacherId());
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                if (t.getPassword().equals(resultSet.getString("password"))) {

                    return true;
                } else {

                    return false;
                }
            } else {

                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
    }
}
