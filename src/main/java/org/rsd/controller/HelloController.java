package org.rsd.controller;

import org.rsd.bean.SysUser;
import org.rsd.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("hi1")
    public ModelAndView hi1() {
        ModelAndView modelAndView = new ModelAndView("/jsp/test.jsp");
        modelAndView.addObject("name", "lianze - 廉泽");
        return modelAndView;
    }

    @RequestMapping("hi2")
    public ModelAndView hi2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "china - 中国");
        modelAndView.addObject("age", 11);
        modelAndView.setViewName("/jsp/test.jsp");
        return modelAndView;
    }

    @RequestMapping("hi3")
    public ModelAndView hi3() {
        ModelAndView modelAndView = new ModelAndView();

        List<SysUser> list = sysUserService.queryList();
        modelAndView.addObject("list",list);

        modelAndView.setViewName("/jsp/test.jsp");
        return modelAndView;
    }

    @RequestMapping("hi4")
    public ModelAndView hi4(Integer id) {
        ModelAndView modelAndView = new ModelAndView();

        SysUser sysUser = sysUserService.getById(id);

        modelAndView.addObject("sysUser", sysUser);
        modelAndView.setViewName("/jsp/test.jsp");

        return modelAndView;

    }
}
