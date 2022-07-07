package org.rsd.service.impl;

import org.rsd.bean.NewsInfo;
import org.rsd.bean.NewsType;
import org.rsd.dao.INewsInfoDAO;
import org.rsd.dao.INewsTypeDAO;
import org.rsd.service.INewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsInfoServiceImpl implements INewsInfoService {

    @Autowired
    private INewsInfoDAO newsInfoDAO;

    @Autowired
    private INewsTypeDAO newsTypeDAO;

    @Override
    public List<NewsInfo> queryList() {
        return newsInfoDAO.queryList();
    }

    @Override
    public NewsInfo getById(Integer id) {
        return newsInfoDAO.getById(id);
    }

    @Override
    public void insert(NewsInfo newsInfo) {
        newsInfoDAO.insert(newsInfo);
    }

    @Override
    public void update(NewsInfo newsInfo) {
        newsInfoDAO.update(newsInfo);
    }

    @Override
    public void delete(Integer id) {
        newsInfoDAO.delete(id);
    }

    @Override
    public List<NewsType> queryNewsTypeList() {
        return newsTypeDAO.queryList();
    }
}
