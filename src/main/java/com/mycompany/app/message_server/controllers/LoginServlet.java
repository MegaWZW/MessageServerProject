package com.mycompany.app.message_server.controllers;

import com.mycompany.app.message_server.core.dto.UserDTO;
import com.mycompany.app.message_server.service.CookieService;
import com.mycompany.app.message_server.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;

@WebServlet(name="LoginServlet", urlPatterns = "/api/user")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");



        String login = CookieService.getValueFromAnywhere(req,"login");
        CookieService.saveCookies(resp,"login",login);

        //String password = req.getParameter("password");
        String password = CookieService.getValueFromAnywhere(req,"password");
        CookieService.saveCookies(resp,"password",password);

        String fio = CookieService.getValueFromAnywhere(req,"fio");
        CookieService.saveCookies(resp,"fio",fio);
        String dayBirth = CookieService.getValueFromAnywhere(req,"dayBirth");
        CookieService.saveCookies(resp,"dayBirth",dayBirth);
        String monthBirth = CookieService.getValueFromAnywhere(req,"monthBirth");
        CookieService.saveCookies(resp,"monthBirth",monthBirth);
        String yearBirth = CookieService.getValueFromAnywhere(req,"yearBirth");
        CookieService.saveCookies(resp,"yearBirth",yearBirth);

        UserDTO user= new UserDTO(login,password,fio, new GregorianCalendar(Integer.parseInt(yearBirth) ,Integer.parseInt(monthBirth),Integer.parseInt(dayBirth));
        UserService.save


//
//        String name = req.getParameter("name");
//        String surname = req.getParameter("surname");
//        String thirdName = req.getParameter("thirdName");
//        String dayBirth = req.getParameter("dayBirth");
//        String monthBirth = req.getParameter("dayBirth");
//        String yearBirth = req.getParameter("dayBirth");

    }
}
