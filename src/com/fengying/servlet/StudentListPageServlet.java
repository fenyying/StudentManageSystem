package com.fengying.servlet;

import com.fengying.domain.PageBean;
import com.fengying.service.StudentService;
import com.fengying.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "StudentListPageServlet", value = "/StudentListPageServlet")
public class StudentListPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取需要显示的页码数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        // 2. 根据指定的页数，获取该页的数据
        StudentService service = new StudentServiceImpl();
        PageBean pageBean = null;
        try {
            pageBean = service.findStudentByPage(currentPage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("pageBean", pageBean);
        // 3. 跳转界面
        request.getRequestDispatcher("list_page.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
