package com.fengying.dao;
import com.fengying.domain.Student;
import java.sql.SQLException;
import java.util.List;

/**
 * 这是针对学生表的数据访问
 * @author fengying
 */
public interface StudentDao {
    int PAGE_SIZE = 5;

    /**
     * 查询学生记录数目
     * @return 学生记录的数目
     * @throws SQLException SQL异常
     */
    int findCount() throws SQLException;
    /**
     * 查询当页的学生数据
     * @param currentPage 当前的页数
     * @return List<Student> 学生类集合
     * @throws SQLException SQL异常
     */
    List<Student> findStudentByPage(int currentPage) throws SQLException;
    /**
     * 根据学生的姓名和性别查询
     * @param sname 姓名
     * @param gender 性别
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
     * @param sid id
     * @return Student 学生类
     * @throws SQLException SQL异常
     */
    Student findStudentById(int sid) throws SQLException;
    /**
     * 根据ID号删除学生
     * @param sid id
     * @throws SQLException SQL异常
     */
    void delete(int sid) throws SQLException;

    /**
     * 查询所有的学生
     * @return list<Student> 学生类集合
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
