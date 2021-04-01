package ogedengbe.tosan.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class for LogOutUser
 */

@WebServlet(
        urlPatterns = {"/logOutUser"}
)

//The log out page.
//Here, code will close the session, and sing the user out of the applciation.
//Will add in code for closing the database.

public class LogOutUser extends HttpServlet {

    protected void doGet(HttpServletRequest requestOne, HttpServletResponse responseOne) throws ServletException, IOException {
        HttpSession session = requestOne.getSession(false);
        if (session != null) {
            session.removeAttribute("user");

            RequestDispatcher dispatcherOne = requestOne.getRequestDispatcher("/index.jsp");
            dispatcherOne.forward(requestOne, responseOne);
        }
    }
}

