package com.hangman;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int letterIndex = Integer.parseInt(req.getParameter("letterIndex"));
        boolean hit = Handler.checkTheLetter(letterIndex);
        if (hit) {
            Handler.handleHitOption(letterIndex);
        } else {
            Handler.handleNoHitOption(letterIndex);
        }
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
