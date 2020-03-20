package com.java.code.servlet;

import com.java.code.Model.StudentHomework;
import com.java.code.jdbc.StudentHomeworkJdbc;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/submitHomework")
public class submitHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //跳转到该界面
        req.getRequestDispatcher("submitHomework.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //将新的学生作业信息实体化
        StudentHomework newsHomework = new StudentHomework();
        //获取表单信息
        newsHomework.setStudentId(Integer.parseInt(req.getParameter("student_id")));
        newsHomework.setHomeworkId(Integer.parseInt(req.getParameter("homework_id")));
        //编码问题需要转换
        String str = new String(req.getParameter("homework_content").getBytes("iso-8859-1"), "UTF-8");
        newsHomework.setHomeworkContent(str);

        resp.setContentType("text/html;charset=UTF-8");
        try {
            if (StudentHomeworkJdbc.addStudentHomework(newsHomework)) {
                //显示弹窗并且当关闭弹窗后跳到指定页面
                resp.getWriter().write("<script>alert('提交成功！网页将跳转到首页！'); window.location='index.jsp'; window.close();</script>");
                resp.getWriter().flush();
            } else {
                //显示弹窗并且当关闭弹窗后跳到指定页面
                resp.getWriter().write("<script>alert('提交失败，请仔细检查后再提交！网页将跳转到提交界面！'); window.location='submitHomework.jsp'; window.close();</script>");
                resp.getWriter().flush();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
