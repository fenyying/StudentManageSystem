package com.fengying.service.impl;

import com.fengying.dao.StudentDao;
import com.fengying.dao.impl.StudentDaoImpl;
import com.fengying.domain.PageBean;
import com.fengying.domain.Student;
import com.fengying.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public PageBean<Student> findStudentByPage(int currentPage) throws SQLException {
        PageBean<Student> pageBean = new PageBean<Student>();
        pageBean.setCurrentPage(currentPage);   // 设置当前页
        pageBean.setPageSize(StudentDao.PAGE_SIZE);     // 设置每页显示的记录数目
        StudentDao dao = new StudentDaoImpl();
        List<Student> list = dao.findStudentByPage(currentPage);
        pageBean.setList(list);     // 设置这一页的学生数据
        pageBean.setTotalSize(dao.findCount());     // 设置总的记录数
        pageBean.setTotalPage(dao.findCount() % StudentDao.PAGE_SIZE == 0 ? dao.findCount() / StudentDao.PAGE_SIZE : dao.findCount() / StudentDao.PAGE_SIZE + 1);
        return pageBean;
    }

    /**
     * 根据学生姓名或者性别或者姓名和性别查找学生
     * @param sname 姓名
     * @param gender 性别
     * @return List<Student> 学生类集合
     * @throws SQLException SQL异常
     */
    @Override
    public List<Student> search(String sname, String gender) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.search(sname, gender);
    }

    /**
     * 更新学生数据
     * @param student，需要更新的学生数据
     * @throws SQLException SQL异常
     */
    @Override
    public void update(Student student) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.update(student);
    }

    /**
     * 根据Id删除学生
     * @param sid id号
     * @throws SQLException SQLException
     */
    @Override
    public void delete(int sid) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.delete(sid);
    }

    /**
     * 查找所有的学生
     * @return List<Student> 学生类集合
     * @throws SQLException SQL异常
     */
    @Override
    public List<Student> findAll() throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.findAll();
    }

    /**
     * 根据ID号查找学生
     * @param sid id号
     * @return Student 学生类
     * @throws SQLException SQL异常
     */
    @Override
    public Student findStudentById(int sid) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.findStudentById(sid);
    }

    /**
     * 插入一个学生类
     * @param student 学生类
     * @throws SQLException SQL异常
     */
    @Override
    public void insert(Student student) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.insert(student);
    }
}
