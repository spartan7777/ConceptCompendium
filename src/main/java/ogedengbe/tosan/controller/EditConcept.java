package ogedengbe.tosan.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet to edit a concept.
 * @author tosan ogedengbe
 */

@WebServlet(
        urlPatterns = {"/editConcept"}
)

//Here we are getting the user to the edit page where they can enter new details for editing.
//There will be some code here to get the user to the proper page when the edit button is used to invoke this controller.

public class EditConcept extends HttpServlet {

    protected void doGet(HttpServletRequest requestOne, HttpServletResponse responseOne) throws ServletException, IOException {

        RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/edit.jsp");
        dispatcherOne.forward(requestOne, responseOne);
    }
}