package io.github.azizndao.vieterrestre.controllers;

import io.github.azizndao.vieterrestre.models.Alert;
import io.github.azizndao.vieterrestre.models.User;
import io.github.azizndao.vieterrestre.repository.AlertRepository;
import io.github.azizndao.vieterrestre.repository.AlertRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/alert"}, name = "Alert")
public class AlertController extends HttpServlet {

    private AlertRepository alertRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        alertRepository = new AlertRepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            req.getRequestDispatcher("alert.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var user = (User) req.getSession().getAttribute("user");

        if (user != null) {
            resp.sendRedirect("/login");
            return;
        }

        var type = req.getParameter("type");
        var description = req.getParameter("description");
        var longitude = Float.parseFloat(req.getParameter("longitude"));
        var latitude = Float.parseFloat(req.getParameter("latitude"));

//        alertRepository.save(type, description, longitude, latitude, user);
    }
}
