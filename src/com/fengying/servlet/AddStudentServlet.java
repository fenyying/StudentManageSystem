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

@WebServlet(name = "AddStudentServlet", value = "/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 1. 获取客户端提交的数据
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
        // 2. 添加数据到数据库
        StudentService service = new StudentServiceImpl();
        Student student = new Student(sname, gender, phone, hobby, info, date);
        try {
            service.insert(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 3. 跳转到列表界面
        // 这里直接跳转界面，那么这个页面会重新翻译一次，上面那个request的请求存储的数据也就没有了
        // request.getRequestDispatcher("list.jsp").forward(request, response);
        request.getRequestDispatcher("StudentListServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
