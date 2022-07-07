package org.rsd.dao.impl;

import org.rsd.bean.NewsType;
import org.rsd.dao.INewsTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NewsTypeDAOImpl implements INewsTypeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<NewsType> mapper = new RowMapper<NewsType>() {
        @Override
        public NewsType mapRow(ResultSet rs, int rowNum) throws SQLException {
            NewsType newsType = new NewsType();

            newsType.setId(rs.getInt("id"));
            newsType.setName(rs.getString("name"));

            return newsType;
        }
    };

    @Override
    public List<NewsType> queryList() {
        String sql = "select * from bu_news_type";
        return jdbcTemplate.query(sql, mapper);
    }
}
