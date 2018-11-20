package com.fengying.servlet;

import com.fengying.domain.Student;
import com.fengying.service.StudentService;
import com.fengying.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditStudentServlet", value = "/EditStudentServlet")
/**
 * 处理学生的更新，查询一个学生的信息，然后跳转到更新页面
 */
public class EditStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收ID
        int sid = Integer.parseInt(request.getParameter("sid"));
        StudentService service = new StudentServiceImpl();
        Student student = null;
        // 2. 查询学生
        try {
            student = service.findStudentById(sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 3. 存数据
        request.setAttribute("stu", student);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
