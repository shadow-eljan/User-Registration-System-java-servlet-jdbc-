package com.servlet.app.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/users/success")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Registration Success</title></head>");
        out.println("<body>");
        out.println("<h2>Registration Successful</h2>");
        if (id != null) {
            out.println("<p>Your User ID is: <strong>" + id + "</strong></p>");
        } else {
            out.println("<p>User ID not found.</p>");
        }
        out.println("<a href='javascript:history.back()'>Go Back</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
