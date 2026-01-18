package com.servlet.app.web;

import com.servlet.app.dao.UserDAO;
import com.servlet.app.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users/result")
public class UserSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDAO dao = new UserDAO();

        String email = req.getParameter("email");
        UserDTO user = dao.findByEmail(email);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");

        if (user != null) {
            out.println("<h2>User Found</h2>");
            out.println("<p>ID: " + user.getId() + "</p>");
            out.println("<p>Name: " + user.getFullName() + "</p>");
            out.println("<p>Email: " + user.getEmail() + "</p>");
        } else {
            out.println("<h2>No user found</h2>");
            out.println("<h2>Please Try Again.</h2>");
        }

        out.println("<a href='search'>Go Back</a>");
        out.println("</body></html>");

    }
}
