package com.ohgiraffers.section01.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/show500error")
public class Show500errorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                "500번 에러는 누구 잘못?? 개발자! 개발자는 누구??");
    }
}
