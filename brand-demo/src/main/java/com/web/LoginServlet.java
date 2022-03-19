package com.web;

import com.pojo.User;
import com.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取复选框数据
        String remember = request.getParameter("remember");

        //调用service进行查询
        User user = service.login(username, password);

        //判断
        if(user != null){
            //登录成功
            //判断用户是否勾选记住我
            if("1".equals(remember)){
                //勾选了 ，发送cookie

                //1、创建cookie对象
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);

                //设置cookie的存活时间
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);
                //2、发送cookie
                response.addCookie(c_username);
                response.addCookie(c_password);

            }
            //将登录成功后的user对象存储到session中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            //跳转到selectAll页面
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");
        }else{
            //登录失败，跳转到login.jsp
            //存储错误信息到request
            request.setAttribute("login_msg","用户名或密码错误");

            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
