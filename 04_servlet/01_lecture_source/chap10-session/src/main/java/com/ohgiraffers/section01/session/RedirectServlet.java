package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        System.out.println("session id = " + session.getId());

        String firstName = (String) session.getAttribute("firstName");
        String lastName = (String) session.getAttribute("lastName");

        System.out.println("session firstName = " + firstName);
        System.out.println("session lastName = " + lastName);
    }
}
