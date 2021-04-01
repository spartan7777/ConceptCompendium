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
 * Servlet implementation class for SearchConcept
 */

@WebServlet(
        urlPatterns = {"/searchConcept"}
)

//This is a user interface where they can search for concepts.
//We need this cvontroller to search the database for concepts based on the search criteria entered here.
//This search needs to be all inclusive and search all columns in the concept table in the database.
//Need to make sure the quesry for this is up to date and asks the right things.
//Then, we will need to create a result object here and put the data from the search into that object using dao methods.
//After that, we submit it all to the proper page.
//So, there will be some code here for form validation, code to run the proper Dao method to submit the search and where to put the results.

public class SearchConcept extends HttpServlet {

    protected void doGet(HttpServletRequest requestOne, HttpServletResponse responseOne) throws ServletException, IOException {

        CompendiumDao daoOne = new CompendiumDao();
        //PrintWriter writerOne = new PrintWriter();

        if (requestOne.getParameter("searchTerm") == null || (requestOne.getParameter("searchTerm").trim().isEmpty())) {
            //writerOne.write("Data is required for a search.");

        } else {

            requestOne.getParameter("submit").equals("search");
            requestOne.setAttribute("concepts", daoOne.getAll());

        }

        RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/searchresults.jsp");
        dispatcherOne.forward(requestOne, responseOne);
    }

}

