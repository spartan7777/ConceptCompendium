package ogedengbe.tosan.controller;

import ogedengbe.tosan.communication.CompendiumDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to provide concept search results.
 * @author Tosan Ogedengbe
 */

@WebServlet(
        urlPatterns = {"/searchConcept"}
)

public class LogOutUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //UserData userData = new UserData();
        CompendiumDao conceptDaoOne = new CompendiumDao();
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("users", conceptDaoOne.getByPropertyEqual(req.getParameter("propertyName"), req.getParameter("searchTerm")));
        } else {
            req.setAttribute("users", conceptDaoOne.getAll());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/create.jsp");
        dispatcher.forward(req, resp);
    }
}

