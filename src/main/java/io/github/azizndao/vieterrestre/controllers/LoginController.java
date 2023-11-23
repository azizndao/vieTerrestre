package io.github.azizndao.vieterrestre.controllers;

import io.github.azizndao.vieterrestre.repository.AuthRepository;
import io.github.azizndao.vieterrestre.repository.AuthRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Login", value = "/login")
public class LoginController extends HttpServlet {
    private AuthRepository authRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        authRepository = new AuthRepositoryImpl();
    }

    @Override
    public void destroy() {
        authRepository = null;
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var user = authRepository.authenticate(req.getParameter("email"), req.getParameter("password"));
        if (user != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/");
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}