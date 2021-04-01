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
import java.io.PrintWriter;


/**
 * A simple servlet to create a concept.
 * @author tosan ogedengbe
 */

@WebServlet(
        urlPatterns = {"/createConcept"}
)

//This is a user interface where they can create concepts, so we need to get all data in the form and check it to make sure that there is stuff in the form.
//Then, we will need to create a concept object here and put the data from the form into that object using dao methods.
//After that, we submit it all to the database.
//So, there will be some code here for object creation, form validation as well as code to run the proper Dao method to submit to the database.

public class CreateConcept extends HttpServlet {

    protected void doPost(HttpServletRequest requestOne, HttpServletResponse responseOne) throws ServletException, IOException {

        int conceptId = Integer.parseInt(requestOne.getParameter("conceptId"));
        String conceptName = requestOne.getParameter("conceptName");
        String keywordOne = requestOne.getParameter("keywordOne");
        String keywordTwo = requestOne.getParameter("keywordTwo");
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
        //PrintWriter writerOne = new PrintWriter;

        if (requestOne.getParameter("idea_name") == null || (requestOne.getParameter("idea_name").trim().isEmpty())) {
            //writerOne.write("A name is required for a concept.");
            RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/create.jsp");
            dispatcherOne.forward(requestOne, responseOne);

        } else if
                (requestOne.getParameter("idea_description") == null || requestOne.getParameter("idea_description").trim().isEmpty()) {
                //writerOne.write("A description is required for a concept.");
                RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/create.jsp");
                dispatcherOne.forward(requestOne, responseOne);

            } else {

                daoOne.create(conceptOne);

                requestOne.setAttribute("concept", conceptOne);

            }

            RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/records.jsp");
            dispatcherOne.forward(requestOne, responseOne);
        }

}