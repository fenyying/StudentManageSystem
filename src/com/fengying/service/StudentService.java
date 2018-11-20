package com.fengying.service;

import com.fengying.domain.PageBean;
import com.fengying.domain.Student;
import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    /**
     * 查询当前页的数据
     * @param currentPage
     * @return
     * @throws SQLException
     */
    PageBean<Student> findStudentByPage(int currentPage) throws SQLException;
    /**
     * 根据姓名或者性别或者姓名和性别查找学生
     * @param sname 姓名
     * @param gender 性别
     * @return List<Student> 学生类集合
     * @throws SQLException SQL异常
     */
    List<Student> search(String sname, String gender) throws SQLException;
    /**
     * 更新学生数据
     * @param student，需要更新的学生数据
     * @throws SQLException SQL异常
     */
    void update(Student student) throws SQLException;
    /**
     * 根据ID查询单个学生对象
     * @return Student
     * @throws SQLException SQL异常
     */
    Student findStudentById(int sid) throws SQLException;
    /**
     * 根据sid删除学生
     * @param sid id号
     * @throws SQLException SQL异常
     */
    void delete(int sid) throws SQLException;

    /**
     * 查询所有的学生
     * @return 学生类集合
     * @throws SQLException SQL异常
     */
    List<Student> findAll() throws SQLException;

    /**
     * 添加学生
     * @param student 学生类
     * @throws SQLException SQL异常
     */
    void insert(Student student) throws SQLException;
}
