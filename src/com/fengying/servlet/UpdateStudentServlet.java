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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@WebServlet(name = "UpdateStudentServlet", value = "/UpdateStudentServlet")
/**
 * 处理学生的更新，查询一个学生的信息，然后跳转到更新页面
 */
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 1. 获取客户端提交的数据
        int sid = Integer.parseInt(request.getParameter("sid"));
        String sname = request.getParameter("sname");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String[] hobbys = request.getParameterValues("hobby");
        String hobby = Arrays.toString(hobbys);
        hobby = hobby.substring(1, hobby.length()-1);
        String info = request.getParameter("info");
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 2. 更新数据库
        StudentService service = new StudentServiceImpl();
        Student student = new Student(sname, gender, phone, hobby, info, date);
        student.setSid(sid);
        try {
            service.update(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("StudentListServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
