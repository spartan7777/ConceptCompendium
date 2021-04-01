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
 * Servlet implementation class for SearchUser
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

//This is a user interface where admin role users can search for other users.
//We need this cvontroller to search the database for users based on the search criteria entered here.
//Then, we will need to create a result object here and put the data from the search into that object using dao methods.
//After that, we submit it all to the proper page.
//So, there will be some code here for form validation, code to run the proper Dao method to submit the search and where to put the results.

public class SearchUser extends HttpServlet {

    protected void doGet(HttpServletRequest requestOne, HttpServletResponse responseOne) throws ServletException, IOException {

        CompendiumDao daoOne = new CompendiumDao();
        //PrintWriter writerOne = new PrintWriter();

        if (requestOne.getParameter("searchTerm").equals(null) || (requestOne.getParameter("searchTerm").trim().isEmpty())) {
            //writerOne.write("Data is required for a search.");

        } else {

            requestOne.getParameter("submit").equals("search");
            requestOne.setAttribute("users", daoOne.getAll());

        }

        RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/adminresults.jsp");
        dispatcherOne.forward(requestOne, responseOne);
    }

}
