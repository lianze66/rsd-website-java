package org.rsd.dao.impl;

import org.rsd.bean.NewsInfo;
import org.rsd.dao.INewsInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NewsInfoDAOImpl implements INewsInfoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<NewsInfo> mapper = new RowMapper<NewsInfo>() {
        @Override
        public NewsInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            NewsInfo newsInfo = new NewsInfo();

            newsInfo.setId(rs.getInt("id"));
            newsInfo.setName(rs.getString("name"));
            newsInfo.setTypeId(rs.getInt("type_id"));
            newsInfo.setNewsPicUrl(rs.getString("news_pic_url"));
            newsInfo.setAuthor(rs.getString("author"));
            newsInfo.setArticleSource(rs.getString("article_source"));
            newsInfo.setContent(rs.getString("content"));
            newsInfo.setReleaseTime(rs.getString("release_time"));
            newsInfo.setViewsNumber(rs.getInt("views_number"));
            newsInfo.setCreateTime(rs.getTimestamp("create_time"));
            newsInfo.setUpdateTime(rs.getTimestamp("update_time"));

            newsInfo.setTypeName(rs.getString("type_name"));

            return newsInfo;
        }
    };

    @Override
    public List<NewsInfo> queryList() {
        String sql = "select t1.*,t2.name type_name from bu_news_info t1 left join bu_news_type t2 on t1.type_id = t2.id order by t1.id desc";
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public NewsInfo getById(Integer id) {
        String sql = "select t1.*,t2.name type_name from bu_news_info t1 left join bu_news_type t2 on t1.type_id = t2.id where t1.id=?";
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }

    @Override
    public void insert(NewsInfo newsInfo) {
        String sql = "insert into bu_news_info values(null,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                newsInfo.getName(),
                newsInfo.getTypeId(),
                newsInfo.getNewsPicUrl(),
                newsInfo.getAuthor(),
                newsInfo.getArticleSource(),
                newsInfo.getContent(),
                newsInfo.getReleaseTime(),
                newsInfo.getViewsNumber(),
                newsInfo.getCreateTime(),
                newsInfo.getUpdateTime());
    }

    @Override
    public void update(NewsInfo newsInfo) {
        String sql = "update bu_news_info set name=?,type_id=?,news_pic_url=?,author=?,article_source=?,content=?,release_time=?,views_number=?,update_time=? where id=?";
        jdbcTemplate.update(sql,
                newsInfo.getName(),
                newsInfo.getTypeId(),
                newsInfo.getNewsPicUrl(),
                newsInfo.getAuthor(),
                newsInfo.getArticleSource(),
                newsInfo.getContent(),
                newsInfo.getReleaseTime(),
                newsInfo.getViewsNumber(),
                newsInfo.getUpdateTime(),
                newsInfo.getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from bu_news_info where id=?";
        jdbcTemplate.update(sql, id);
    }
}
