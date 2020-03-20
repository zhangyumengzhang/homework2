package com.java.code.servlet;

import com.java.code.Model.Homework;
import com.java.code.jdbc.HomeworkJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allHomework")
public class allHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Homework> list = HomeworkJdbc.selectAllHomework();
        req.setAttribute("homeworklist", list);
        req.getRequestDispatcher("allHomework.jsp").forward(req, resp);
    }
}
