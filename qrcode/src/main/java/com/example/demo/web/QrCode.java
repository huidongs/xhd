package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description TODO
 * @Author: xhd
 * @Date: 2021-11-10 10:02
 **/
@RestController
public class QrCode {

    @RequestMapping(value = "/qrcode")
    public void test(HttpServletResponse response) throws IOException {
        System.out.println("========================");
        try{
            response.sendRedirect("http://www.baidu.com");
        }catch(Exception e){
            response.getWriter().print(e);
        }
    }
}
