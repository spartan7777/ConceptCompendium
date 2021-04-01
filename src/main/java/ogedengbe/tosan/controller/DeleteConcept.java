package ogedengbe.tosan.controller;

import ogedengbe.tosan.communication.CompendiumDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet to delete a concept.
 * @author tosan ogedengbe
 */

@WebServlet(
        urlPatterns = {"/deleteConcept"}
)

//Here we are deleting concepts.
//Here, we need to use the delete button that will invoke this controller to select the proper concept for deletion by the id.
//Once we have that, we will collect the rest of the data for deletion here and we submit it all to the database for removal.
//So, there will be some code here to call the proper Dao method to delete from the database.

public class DeleteConcept extends HttpServlet {

    protected void doGet(HttpServletRequest requestOne, HttpServletResponse responseOne) throws ServletException, IOException {

        int conceptId = Integer.parseInt(requestOne.getParameter("concept_id"));

        //String name = requestOne.getParameter("concept_name");
        //String keywordOne = requestOne.getParameter("keyword_one");
        //String keywordTwo = requestOne.getParameter("keyword_two");
        //String category = requestOne.getParameter("category");
        //String description = requestOne.getParameter("description");

        //Concept conceptOne = new Concept();

        //conceptOne.setId(id);
        //conceptOne.setName(name);
        //conceptOne.setKeywordOne(keywordOne);
        //conceptOne.setKeywordTwo(keywordTwo);
        //conceptOne.setCategory(category);
        //conceptOne.setDescription(description);

        CompendiumDao daoOne = new CompendiumDao();
        daoOne.delete(conceptId);


        RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/records.jsp");
        dispatcherOne.forward(requestOne, responseOne);

    }
}
