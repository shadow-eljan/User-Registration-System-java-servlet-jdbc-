package com.servlet.app.web;


import com.servlet.app.dto.UserDTO;
import com.servlet.app.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/register")
public class UserRegisterServlet extends HttpServlet {
    private UserService service;
    @Override
    public void init() {
        service = new UserService();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("username");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");

            UserDTO dto = new UserDTO();
            dto.setFullName(name);
            dto.setEmail(email);
            dto.setPhone(phone);

            long id = service.register(dto);

            resp.sendRedirect(req.getContextPath() + "/users/success?id=" + id);

        }catch (Exception e){
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/users/error")
                    .forward(req, resp);

        }
    }
}
