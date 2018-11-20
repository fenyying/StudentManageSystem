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
import java.util.List;

@WebServlet(name = "SearchStudentServlet", value = "/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 1. 获取需要查询的关键数据，名字和性别
        String sname = request.getParameter("sname");
        String gender = request.getParameter("gender");
        // 2. 使用service查询
        StudentService service = new StudentServiceImpl();
        List<Student> list = null;
        try {
            list = service.search(sname, gender);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 3. 将查询的结果存入list
        request.setAttribute("list", list);
        // 4. 跳转页面
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
