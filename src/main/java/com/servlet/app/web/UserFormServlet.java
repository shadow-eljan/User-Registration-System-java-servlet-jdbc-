package com.servlet.app.web;


import com.servlet.app.dao.UserDAO;
import com.servlet.app.dto.UserDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/new")
public class UserFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/user-form.html");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        req.setAttribute("username", name);
        req.setAttribute("email", email);
        req.setAttribute("phone", phone);


        UserDAO dao = new UserDAO();
        UserDTO user = new UserDTO();
        user.setFullName(name);
        user.setEmail(email);
        user.setPhone(phone);

        boolean inserted = dao.insert(user);


        req.setAttribute("user", user);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/user-form.html");
        rd.forward(req, resp);

    }
}
