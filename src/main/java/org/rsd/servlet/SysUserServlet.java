package org.rsd.servlet;

import org.rsd.bean.SysUser;
import org.rsd.service.ISysUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/sysUser/list", "/sysUser/detail"})
public class SysUserServlet extends HttpServlet {

    private ISysUserService sysUserService;

    @Override
    public void init() throws ServletException {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");
        sysUserService = factory.getBean(ISysUserService.class);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/sysUser/list")) {
            list(request, response);
        } else if (uri.equals("/sysUser/detail")) {
            detail(request, response);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SysUser> list = sysUserService.queryList();

        request.setAttribute("list", list);
        request.getRequestDispatcher("/jsp/sysUser/list.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        SysUser sysUser = sysUserService.getById(Integer.valueOf(id));

        request.setAttribute("sysUser", sysUser);
        request.getRequestDispatcher("/jsp/sysUser/detail.jsp").forward(request, response);
    }
}
