package ogedengbe.tosan.controller;

import ogedengbe.tosan.communication.CompendiumDao;
import ogedengbe.tosan.model.Concept;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * A servlet to list the concepts.
 * @author tosan ogedengbe
 */

@WebServlet(
        urlPatterns = {"/listConcept"}
)

//Here we are creating a list based on a selected category on this page.
//A user will select a category from the dropdown menu and the query will run to select all the concepts with that category.
//Here will be code to call the proper Dao method to select all concepts that match the given search parameter from the database.

public class ListConcept extends HttpServlet {

    protected void doGet(HttpServletRequest requestOne, HttpServletResponse responseOne) throws ServletException, IOException {

        CompendiumDao daoOne = new CompendiumDao();

        String listTerm = requestOne.getParameter("category");
        String listValue = requestOne.getParameter("value");

        List<Concept> conceptList = daoOne.getByPropertyLike(listTerm, listValue);

        RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/list.jsp");
        dispatcherOne.forward(requestOne, responseOne);

    }
}


