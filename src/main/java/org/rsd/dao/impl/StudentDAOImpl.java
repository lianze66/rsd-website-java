package org.rsd.dao.impl;

import org.rsd.bean.Student;
import org.rsd.dao.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDAOImpl implements IStudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Student> mapper = new RowMapper<Student>() {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();

            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setCreateTime(rs.getTimestamp("create_time"));

            return student;
        }
    };

    @Override
    public List<Student> queryList() {
        String sql = "select * from bu_student order by id desc";
        List<Student> list = jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override
    public Student getById(Integer id) {
        String sql = "select * from bu_student where id=?";
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }

    @Override
    public void insert(Student student) {
        String sql = "insert into bu_student values(null, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getCreateTime());
    }
}
