package org.rsd.controller;

import org.rsd.bean.SysRole;
import org.rsd.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("sysRole")
@Controller
public class SysRoleController {

    @Autowired
    private ISysRoleService sysRoleService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView toListPage() {
        List<SysRole> list = sysRoleService.querList();

        ModelAndView mav = new ModelAndView();
        mav.addObject("list", list);
        mav.setViewName("/admin/jsp/sysRole/list.jsp");

        return mav;
    }

    @RequestMapping(value = "toUpdatePage/{id}", method = RequestMethod.GET)
    public ModelAndView toUpdatePage(@PathVariable Integer id) {
        SysRole sysRole = sysRoleService.getById(id);

        ModelAndView mav = new ModelAndView();
        mav.addObject("sysRole", sysRole);
        mav.setViewName("/admin/jsp/sysRole/form.jsp");

        return mav;
    }

    @PostMapping("insert")
    public String insert(SysRole sysRole) {
        sysRoleService.insert(sysRole);
        return "redirect:/sysRole/list";
    }

    @PostMapping("update")
    public String update(SysRole sysRole) {
        sysRoleService.update(sysRole);
        return "redirect:/sysRole/list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        sysRoleService.delete(id);
        return "redirect:/sysRole/list";
    }
}
