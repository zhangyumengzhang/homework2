package com.java.code.servlet;

import com.java.code.Model.Student;
import com.java.code.jdbc.StudentJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allStudent")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = StudentJdbc.selectAllStudent();

        req.setAttribute("studentlist", list);
        req.getRequestDispatcher("allStudent.jsp").forward(req, resp);
    }
}
