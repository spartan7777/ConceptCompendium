package ogedengbe.tosan.controller;

import ogedengbe.tosan.communication.CompendiumDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to start the application.
 * @author Tosan Ogedengbe
 */

@WebServlet(
        urlPatterns = {"/startConcept"}
)

public class StartConcept extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CompendiumDao daoOne = new CompendiumDao();

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}

