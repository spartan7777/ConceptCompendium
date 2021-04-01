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

/**
 * A servlet to update a concept.
 * @author tosan ogedengbe
 */

@WebServlet(
        urlPatterns = {"/updateConcept"}
)

//Here we are updating concepts.
//This is considered the actual change of the data in the database after that concpet has been selected for editing.
//In this code, we need to collect all of the data for update here from the form in the editing page.
//We will place all of that new data into a concept object and we submit it all to the database for update.
//So, there will be some code here to call the proper Dao method to update concepts in the database.

public class UpdateConcept extends HttpServlet {

    protected void doGet(HttpServletRequest requestOne, HttpServletResponse responseOne) throws ServletException, IOException {

        int conceptId = Integer.parseInt(requestOne.getParameter("concept_id"));
        String conceptName = requestOne.getParameter("concept_name");
        String keywordOne = requestOne.getParameter("keyword_one");
        String keywordTwo = requestOne.getParameter("keyword_two");
        String category = requestOne.getParameter("category");
        String description = requestOne.getParameter("description");

        Concept conceptOne = new Concept(conceptId, conceptName, keywordOne, keywordTwo, category, description);

        conceptOne.setConceptId(conceptId);
        conceptOne.setConceptName(conceptName);
        conceptOne.setKeywordOne(keywordOne);
        conceptOne.setKeywordTwo(keywordTwo);
        conceptOne.setCategory(category);
        conceptOne.setDescription(description);

        CompendiumDao daoOne = new CompendiumDao();

        daoOne.saveOrUpdate(conceptOne);
        requestOne.setAttribute("concept", conceptOne);

        RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/records.jsp");
        dispatcherOne.forward(requestOne, responseOne);

    }
}
