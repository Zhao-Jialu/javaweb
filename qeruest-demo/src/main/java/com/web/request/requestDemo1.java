package com.web.request;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/requestDemo1")
public class requestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码
        //request.setCharacterEncoding("UTF-8");//设置字符输入流的编码

        //获取username
        String username = request.getParameter("username");
        System.out.println(username);

        //先对乱码数据进行编码：转为字节数组
        //byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        //字节数组解码
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        System.out.println(username);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
