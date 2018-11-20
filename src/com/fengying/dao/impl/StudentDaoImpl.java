package com.fengying.dao.impl;

import com.fengying.dao.StudentDao;
import com.fengying.domain.Student;
import com.fengying.util.JDBCUtil;
import com.fengying.util.TextUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public int findCount() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        Long result = (Long) runner.query("select count(*) from stu", new ScalarHandler());  //ScalarHandler用于处理平均值，总的数目等
        return result.intValue();
    }

    @Override
    public List<Student> findStudentByPage(int currentPage) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        int startCount = PAGE_SIZE * (currentPage - 1);
        // 第一个？代表一页返回多少条数据,第二个？代表跳过前面多少条数据,第一页:(5, 0),第二页:(5, 5),第三页:(5, 10)
        return runner.query("select * from stu limit ? offset ?", new BeanListHandler<Student>(Student.class), PAGE_SIZE, startCount);
    }

    /**
     * 根据姓名或者性别或者两者都有模糊查询
     * @param sname 姓名
     * @param gender 性别
     * @return List<Student>
     * @throws SQLException SQL异常
     */
    @Override
    public List<Student> search(String sname, String gender) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from stu where 1 = 1";
        List<String> list = new ArrayList<String>();
        if(!TextUtil.isEmpty(sname)){
            sql = sql + " and sname like ?";
            list.add("%" + sname + "%");
        }
        if(!TextUtil.isEmpty(gender)){
            sql = sql + " and gender = ?";
            list.add(gender);
        }
        return runner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());
    }

    /**
     * 更新学生信息
     * @param student，需要更新的学生数据
     * @throws SQLException SQL异常
     */
    @Override
    public void update(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.update("update stu set sname = ?, gender = ?, phone = ?, birthday = ?, hobby = ?, info = ? where sid = ?",
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo(),
                student.getSid()
                );
    }

    /**
     * 根据ID查询单个学生
     * @param sid id号
     * @return Student
     * @throws SQLException SQL异常
     */
    @Override
    public Student findStudentById(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        return runner.query("select * from stu where sid = ?", new BeanHandler<Student>(Student.class), sid);
    }

    /**
     * 添加学生
     * @param student 学生类
     * @throws SQLException SQL异常
     */
    @Override
    public void insert(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.update("insert into stu values(null, ?, ?, ?, ?, ?, ?)",
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo()
                );
    }

    /**
     * 根据ID删除学生
     * @param sid id号
     * @throws SQLException SQL异常
     */
    @Override
    public void delete(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.update("delete from stu where sid = ?", sid);
    }

    /**
     * 查询所有的学生
     * @return List<Student> 学生类集合
     * @throws java.sql.SQLException SQL异常
     */
    @Override
    public List<Student> findAll() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        return runner.query("select * from stu", new BeanListHandler<Student>(Student.class));
    }
}
