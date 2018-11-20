package com.fengying.servlet;

import com.fengying.dao.StudentDao;
import com.fengying.dao.impl.StudentDaoImpl;
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
import java.util.List;

/**
 * 将学生信息呈现到页面上
 */
@WebServlet(name = "StudentListServlet", value = "/StudentListServlet")
public class StudentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService service = new StudentServiceImpl();
        try {
            // 1. 查询所有的学生
            List<Student> list = service.findAll();
            // 2. 先把数据存储到作用域中
            request.setAttribute("list", list);
            // 3. 跳转页面
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
