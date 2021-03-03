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
 * A simple servlet to provide user search results.
 * @author Tosan Ogedengbe
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //UserData userData = new UserData();
        CompendiumDao userDaoOne = new CompendiumDao();
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("users", userDaoOne.getByPropertyEqual(req.getParameter("propertyName"), req.getParameter("searchTerm")));
        } else {
            req.setAttribute("users", userDaoOne.getAll());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/searchresults.jsp");
        dispatcher.forward(req, resp);
    }
}
