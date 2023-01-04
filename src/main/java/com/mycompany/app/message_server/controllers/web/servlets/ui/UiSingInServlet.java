package com.mycompany.app.message_server.controllers.web.servlets.ui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UiSingInServlet", urlPatterns = "/ui/singIn")
public class UiSingInServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/jsp/register/singIn.jsp").forward(request, response);
    }
}
