package com.java.code.servlet;

import com.java.code.Model.Student;
import com.java.code.Model.StudentHomework;
import com.java.code.Model.Teacher;
import com.java.code.jdbc.LoginJdbc;
import com.java.code.jdbc.StudentHomeworkJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String userType = req.getParameter("type");
            int id = Integer.parseInt(req.getParameter("id"));
            String password =req.getParameter("password");
            resp.setContentType("text/html;charset=UTF-8");
            if(userType.equals("teacher")){
                Teacher teach=new Teacher();
                teach.setTeacherId(id);
                teach.setPassword(password);
                if(LoginJdbc.tlogin(teach)){
                    resp.getWriter().write("<script>alert('登陆成功！'); window.location='teachermenu.jsp'; window.close();</script>");
                    resp.getWriter().flush();
                }else{
                    resp.getWriter().write("<script>alert('用户名或密码错误，请检查后再登录!网页将跳转到登录界面！'); window.location='index.jsp'; window.close();</script>");
                    resp.getWriter().flush();
                }
            }else if(userType.equals("student")){
               Student stud=new Student();
               stud.setStudentId(id);
               stud.setPassword(password);
                if(LoginJdbc.slogin(stud)){
                    resp.getWriter().write("<script>alert('登陆成功！'); window.location='studentmenu.jsp'; window.close();</script>");
                    resp.getWriter().flush();
                }else{
                    resp.getWriter().write("<script>alert('用户名或密码错误，请检查后再登录!网页将跳转到登录界面！'); window.location='index.jsp'; window.close();</script>");
                    resp.getWriter().flush();
                }
            }
        }
}
