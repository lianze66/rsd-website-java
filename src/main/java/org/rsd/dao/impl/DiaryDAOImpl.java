package org.rsd.dao.impl;

import org.rsd.bean.Diary;
import org.rsd.dao.IDiaryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DiaryDAOImpl implements IDiaryDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper<Diary> mapper = new RowMapper<Diary>() {
        @Override
        public Diary mapRow(ResultSet rs, int rowNum) throws SQLException {
            Diary diary = new Diary();

            diary.setId(rs.getInt("id"));
            diary.setTitle(rs.getString("title"));
            diary.setCreateTime(rs.getTimestamp("create_time"));
            return diary;
        }
    };

    @Override
    public List<Diary> queryList() {
        String sql = "select * from bu_diary";
        List<Diary> list = jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override
    public Diary getById(Integer id) {
        String sql = "select * from bu_diary where id="+id;
        Diary diary = jdbcTemplate.queryForObject(sql, mapper);
        return diary;
    }

    @Override
    public void insert(Diary diary) {
        String sql = "insert into bu_diary(title,content) values(?,?)";
        jdbcTemplate.update(sql, diary.getTitle(), diary.getContent());
    }
}
