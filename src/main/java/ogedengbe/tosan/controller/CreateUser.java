package ogedengbe.tosan.controller;

import ogedengbe.tosan.communication.CompendiumDao;
import ogedengbe.tosan.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class for CreateUser
 */

@WebServlet(
        urlPatterns = {"/createAccount"}
)

public class CreateUser extends HttpServlet {

    //This is a user interface where they can create concepts, so we need to get all data in the form and check it to make sure that there is stuff in the form.
    //Then, we will need to create a concept object here and put the data from the form into that object using dao methods.
    //After that, we submit it all to the database.
    //So, there will be some code here for object creation, form validation as well as code to run the proper Dao method to submit to the database.

    protected void doPost(HttpServletRequest requestOne, HttpServletResponse responseOne) throws ServletException, IOException {

        int userId = Integer.parseInt(requestOne.getParameter("user_id"));
        String firstName = requestOne.getParameter("first_name");
        String lastName = requestOne.getParameter("last_name");
        String userName = requestOne.getParameter("user_name");
        String password = requestOne.getParameter("password");

        User userOne = new User(userId, firstName, lastName, userName, password);

        userOne.setId(userId);
        userOne.setFirstName(firstName);
        userOne.setLastName(lastName);
        userOne.setUserName(userName);
        userOne.setPassword(password);

        CompendiumDao daoOne = new CompendiumDao();
        //PrintWriter writerOne = new PrintWriter();

        if (requestOne.getParameter("firstName") == null || (requestOne.getParameter("first_name").trim().isEmpty())) {
            //writerOne.write("A first name is required for a user.");
            RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/signup.jsp");
            dispatcherOne.forward(requestOne, responseOne);

        } else if

            (requestOne.getParameter("lastName") == null || requestOne.getParameter("last_name").trim().isEmpty()) {
            //writerOne.write("A last name is required for a user.");
            RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/signup.jsp");
            dispatcherOne.forward(requestOne, responseOne);

        } else if

            (requestOne.getParameter("user_name") == null || requestOne.getParameter("user_name").trim().isEmpty()) {
            //writerOne.write("A username is required for a user.");
            RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/signup.jsp");
            dispatcherOne.forward(requestOne, responseOne);

        } else if

            (requestOne.getParameter("password") == null || requestOne.getParameter("password").trim().isEmpty()) {
            //writerOne.write("A password is required for a user.");
            RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/signup.jsp");
            dispatcherOne.forward(requestOne, responseOne);

        } else if

            (requestOne.getParameter("retype_password") == null || requestOne.getParameter("retype_password").trim().isEmpty()) {
            //writerOne.write("The password must be entered twice.");
            RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/signup.jsp");
            dispatcherOne.forward(requestOne, responseOne);

        } else if

            (!requestOne.getParameter("password").equals("retype_password")) {
            //writerOne.write("The passwords must match.");
            RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/signup.jsp");
            dispatcherOne.forward(requestOne, responseOne);

        } else {

            daoOne.insert(userOne);
            requestOne.setAttribute("user", userOne);

        }

            RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/account.jsp");
            dispatcherOne.forward(requestOne, responseOne);
    }

}


