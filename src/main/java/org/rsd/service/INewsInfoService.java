package org.rsd.service;

import org.rsd.bean.NewsInfo;
import org.rsd.bean.NewsType;

import java.util.List;

public interface INewsInfoService {

    List<NewsInfo> queryList();

    NewsInfo getById(Integer id);

    void insert(NewsInfo newsInfo);

    void update(NewsInfo newsInfo);

    void delete(Integer id);

    List<NewsType> queryNewsTypeList();

}
