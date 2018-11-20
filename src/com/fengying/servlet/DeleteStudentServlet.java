package com.fengying.servlet;

import com.fengying.service.StudentService;
import com.fengying.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 用于处理删除学生
 */
@WebServlet(name = "DeleteStudentServlet", value = "/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收ID
        int sid = Integer.parseInt(request.getParameter("sid"));
        // 2. 执行删除
        StudentService service = new StudentServiceImpl();
        try {
            service.delete(sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 3. 跳转到列表页
        System.out.println("删除成功");
        request.getRequestDispatcher("StudentListServlet").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
