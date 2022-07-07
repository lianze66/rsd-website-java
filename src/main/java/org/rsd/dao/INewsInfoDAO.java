package org.rsd.dao;

import org.rsd.bean.NewsInfo;

import java.util.List;

public interface INewsInfoDAO {

    List<NewsInfo> queryList();

    NewsInfo getById(Integer id);

    void insert(NewsInfo newsInfo);

    void update(NewsInfo newsInfo);

    void delete(Integer id);
}
