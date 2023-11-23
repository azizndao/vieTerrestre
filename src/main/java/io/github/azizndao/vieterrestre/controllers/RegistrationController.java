package io.github.azizndao.vieterrestre.controllers;

import io.github.azizndao.vieterrestre.repository.AuthRepository;
import io.github.azizndao.vieterrestre.repository.AuthRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(value = "/register", name = "Registration")
public class RegistrationController extends HttpServlet {
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
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var password = req.getParameter("password");
        var passwordConfirmation = req.getParameter("password-confirmation");

        if (!password.equals(passwordConfirmation)) {
            req.setAttribute("error", "Passwords do not match");
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
            return;
        }

        var user = authRepository.register(
                req.getParameter("email"),
                password,
                req.getParameter("first-name"),
                req.getParameter("last-name"),
                LocalDate.parse(req.getParameter("birthday"))
        );

        if (user != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("error", "User already exists");
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
        }
    }
}
