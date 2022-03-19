package com.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/resp4")
public class responseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //读取文件
        FileInputStream file = new FileInputStream("C://Users/Admin/Pictures/Saved Pictures/luori.jpg");

        //获取response字节输出流
        ServletOutputStream os = response.getOutputStream();

        //完成流的·copy
//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while((len = file.read(bytes))!=-1){
//            os.write(bytes,0,len);
//        }
        IOUtils.copy(file,os);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
