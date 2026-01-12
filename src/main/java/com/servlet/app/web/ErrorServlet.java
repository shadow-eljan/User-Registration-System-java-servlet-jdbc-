package com.servlet.app.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users/error")
public class ErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        showError(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        showError(req, resp);
    }

    private void showError(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String error = (String) req.getAttribute("errorMessage");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<h2>Registration Failed</h2>");
        out.println("<p style='color:red;'>" +
                (error != null ? error : "Unknown error occurred")
                + "</p>");
        out.println("<a href='javascript:history.back()'>Go Back</a>");
    }
}
