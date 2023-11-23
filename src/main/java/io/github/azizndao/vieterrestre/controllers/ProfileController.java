package io.github.azizndao.vieterrestre.controllers;

import io.github.azizndao.vieterrestre.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/me", "/profile"})
public class ProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login");
        } else {
            req.getRequestDispatcher("profile.jsp").forward(req, resp);
        }
    }
}
