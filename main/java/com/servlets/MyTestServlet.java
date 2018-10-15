package com.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class MyTestServlet extends HttpServlet {

    private static final String HTML = "<html>" +
        "<head><title>Test</title></head>" +
        "<body><h1>%s %s</h1>" +
            "<h2>%s</h2></body>" +
        "</html>";

    private static final String HTML_RES = "<html>" +
            "<head><title>Test</title></head>" +
            "<body><h1>%s</h1>" +
            "</body>" +
            "</html>";

    private static List<User> users = new ArrayList<>();

    private String name;
    private String surname;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> yesUs = new ArrayList<>();
        List<User> noUs = new ArrayList<>();
        String result = "";

        for (User us : users) {
            if (us.answer.equalsIgnoreCase("yes")) {
                yesUs.add(us);
            } else {
                noUs.add(us);
            }
        }

        result = "<h1>Users with trainings : " + yesUs.size() + "</h1>";

        for (User us : yesUs) {
            result += us.name + " " + us.surname + " answer : " + us.answer + "<br>";
        }

        result += "<h1>Users without trainings : " + noUs.size() + "</h1>";

        for (User us : noUs) {
            result += us.name + " " + us.surname + " answer : " + us.answer + "<br>";
        }

        resp.getWriter().println(String.format(HTML_RES,result));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String first = req.getParameter("firstname");
        String last = req.getParameter("lastname");
        String answer = req.getParameter("question");

        if ((first != null && first != "") && (last != null && last != "") && answer != "") {
            String r;
            if (answer.equalsIgnoreCase("yes")) {
                r = String.format(HTML, first, last, "Well done!");
            } else {
                r = String.format(HTML, first, last, "Try tomorrow!");
            }
            users.add(new User(first,last,answer));
            resp.getWriter().println(r);
        } else {
            resp.sendRedirect("errorpage.jsp");
        }

    }

    public static String getName() {
        if (users.size() > 0) {
            return users.get(users.size() - 1).name;
        }
        return "";
    }

    public static String getSurname() {
        if (users.size() > 0) {
            return users.get(users.size() - 1).surname;
        }
        return "";
    }

    public class User{
        public String name;
        public String surname;
        public String answer;

        public User(String name, String surname, String answer) {
            this.name = name;
            this.surname = surname;
            this.answer = answer;
        }
    }
}
