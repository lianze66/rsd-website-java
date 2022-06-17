package org.rsd.controller;

import org.rsd.bean.SysUser;
import org.rsd.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysUser")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("/admin/jsp/sysUser/list.jsp");

        List<SysUser> list = sysUserService.queryList();

        mav.addObject("list", list);

        return mav;
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("/admin/jsp/sysUser/detail.jsp");

        mav.addObject("sysUser", sysUserService.getById(id));

        return mav;
    }

    @RequestMapping(value = "toUpdatePage/{id}", method = RequestMethod.GET)
    public ModelAndView toUpdatePage(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("/admin/jsp/sysUser/update.jsp");

        mav.addObject("sysUser", sysUserService.getById(id));

        return mav;
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(SysUser sysUser) {
        sysUserService.insert(sysUser);
        return "redirect:/sysUser/list";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(SysUser sysUser) {
        sysUserService.update(sysUser);
        return "redirect:/sysUser/list";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id) {
        sysUserService.delete(id);
        return "redirect:/sysUser/list";
    }
}
