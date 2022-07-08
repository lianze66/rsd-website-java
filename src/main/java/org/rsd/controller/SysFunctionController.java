package org.rsd.controller;

import org.rsd.bean.SysFunction;
import org.rsd.service.ISysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("sysFunction")
@Controller
public class SysFunctionController {

    @Autowired
    private ISysFunctionService sysFunctionService;

    @ResponseBody
    @GetMapping("queryList")
    public List<SysFunction> queryList() {
        return sysFunctionService.queryList();
    }

}
