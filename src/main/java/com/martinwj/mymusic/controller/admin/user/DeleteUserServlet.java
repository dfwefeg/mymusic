package com.martinwj.mymusic.controller.admin.user;

import com.martinwj.mymusic.entity.Song;
import com.martinwj.mymusic.service.UserService;
import com.martinwj.mymusic.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Martin（靖王）
 * @description: TODO
 * @date: 2020/11/18 16:04
 * @version: 1.0
 */
@WebServlet("/admin/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

    private UserService userService = null;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取所有id
        String[] ids = request.getParameterValues("userId");
        System.out.println(Arrays.toString(ids));

        // 2.调用service删除
        List<Integer> list = userService.delUserByUserIds(ids);

        //3.跳转查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/admin/showUsersByPageServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
