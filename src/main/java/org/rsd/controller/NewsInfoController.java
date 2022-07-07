package org.rsd.controller;

import org.rsd.bean.NewsInfo;
import org.rsd.bean.NewsType;
import org.rsd.service.INewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("newsInfo")
@RestController
public class NewsInfoController {

    @Autowired
    private INewsInfoService newsInfoService;

    @GetMapping("list")
    public List<NewsInfo> queryList() {
        return newsInfoService.queryList();
    }

    @GetMapping("detail/{id}")
    public NewsInfo detail(@PathVariable Integer id) {
        return newsInfoService.getById(id);
    }

    @GetMapping("newsTypeList")
    public List<NewsType> queryNewsTypeList() {
        return newsInfoService.queryNewsTypeList();
    }

    @PostMapping("insert")
    public void insert(NewsInfo newsInfo) {
        newsInfoService.insert(newsInfo);
    }
}
