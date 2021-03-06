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
 * A servlet to delete a user.
 * @author tosan ogedengbe
 */

@WebServlet(
        urlPatterns = {"/deleteUser"}
)

//Here we are deleting users.
//Much like the delete concept controller - this one will handle the users when deleted on the Admin page.
//Here, we need to use the delete button that will invoke this controller to select the proper user for deletion by the id.
//Once we have that, we will collect the rest of the data for deletion here and we submit it all to the database for removal.
//So, there will be some code here to call the proper Dao method to delete from the database.

public class DeleteUser extends HttpServlet {

    protected void doGet(HttpServletRequest requestOne, HttpServletResponse responseOne) throws ServletException, IOException {

        int userId = Integer.parseInt(requestOne.getParameter("user_id"));

        //String name = requestOne.getParameter("concept_name");
        //String keywordOne = requestOne.getParameter("keyword_one");
        //String keywordTwo = requestOne.getParameter("keyword_two");
        //String category = requestOne.getParameter("category");
        //String description = requestOne.getParameter("description");

        //User userOne = new User();

        //conceptOne.setId(id);
        //conceptOne.setName(name);
        //conceptOne.setKeywordOne(keywordOne);
        //conceptOne.setKeywordTwo(keywordTwo);
        //conceptOne.setCategory(category);
        //conceptOne.setDescription(description);

        CompendiumDao daoOne = new CompendiumDao();
        daoOne.delete(userId);

        RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/adminresults.jsp");
        dispatcherOne.forward(requestOne,responseOne);

    }
}