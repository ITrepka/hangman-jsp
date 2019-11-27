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
            boolean win = Handler.checkWin();
            if (win) {
                req.getSession().setAttribute("win", "true");
                Handler.numberOfImg = 10;
            } else {
                req.getSession().setAttribute("win", "false");
            }
        } else {
            Handler.numberOfImg++;
            Handler.handleNoHitOption(letterIndex);
            boolean lose = Handler.checkLose();
            if (lose) {
                req.getSession().setAttribute("lose", "true");
                Handler.numberOfImg = 11;
            } else {
                req.getSession().setAttribute("lose", "false");
            }
        }
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
