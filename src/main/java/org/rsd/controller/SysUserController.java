package org.rsd.controller;

import org.rsd.bean.SysUser;
import org.rsd.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysUser")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("/admin/jsp/sysUser/list.jsp");

        List<SysUser> list = sysUserService.queryList();

        mav.addObject("list", list);

        return mav;
    }
}
