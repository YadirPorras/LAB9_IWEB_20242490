package org.example.servlets;

import jakarta.servlet.Servlet;
import jakarta.servlet.annotation.WebServlet;
import org.example.beans.Usuario;
import org.example.daos.UsuarioDao;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String action = request.getParameter("action") == null ?
                "loginform" : request.getParameter("action");

        RequestDispatcher view;

        switch (action){
            case "loginform":
                view = request.getRequestDispatcher("login/loginform.jsp");
                view.forward(request,response);
                break;

            case "logout":
                HttpSession sesion = request.getSession();
                sesion.invalidate();
                response.sendRedirect(request.getContextPath() + "/LoginServlet");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        UsuarioDao usuarioDao = new UsuarioDao();
        String email = request.getParameter("email");
        String password = request.getParameter("password");


    }
}
