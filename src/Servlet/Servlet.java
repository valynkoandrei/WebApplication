package Servlet;

import DataBase.JDBC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


/**
 * Created by Андрей on 17.10.2016.
 */

@WebServlet("/servlet")
public class Servlet extends HttpServlet {
    public Servlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
            processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page = request.getParameter("page");
        String userName = request.getParameter("inputName");
        try {
            JDBC jdbc = new JDBC(userName);
            int id=jdbc.findValue();

            if (id<0) request.getSession().setAttribute("userName", "Такого ключа не существует");
                else request.getSession().setAttribute("userName", id);
        }
        catch (SQLException e)
        {
            System.err.println("Can'n to load driver");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }


}
