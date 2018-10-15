package com.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {

    private static final long serialVerionUID = 1L;

    private static String lastLogin;
    private Map<String,String> db = new HashMap<>();

    public LoginServlet() {
        db.put("user1","1234");
        db.put("user2","5678");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String s = db.get(login);

        if (s!= null && s.equals(password)) {
            lastLogin =login;
            response.setStatus(200);
            response.sendRedirect("loginP.jsp");
        } else {
            response.sendRedirect("errorLogin.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public static String getLastLogin() {
        return lastLogin != null ? lastLogin : "";
    }
}
