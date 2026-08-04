package org.springBootWeb.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        System.out.println("in service");
        super.service(req,res);
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("in get method");
        PrintWriter printWriter=res.getWriter();
        printWriter.println("hello");
    }
}
