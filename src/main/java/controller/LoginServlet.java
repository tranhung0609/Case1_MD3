//<<<<<<< HEAD
//<<<<<<< HEAD
package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/logins")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");


    }
}
//=======
//=======
//>>>>>>> 6937992147570808aaed3f70b50a15290f7706b0
//package controller;
//
//import model.Login;
//import service.impl.LoginDAO;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//
//@WebServlet(name = "LoginServlet", urlPatterns = "/logins ")
//public class LoginServlet extends HttpServlet {
//    private static final long serialVersionUID = 1;
//    private LoginDAO loginDAO;
//
//    public void init() {
//        loginDAO = new LoginDAO();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        Login login = new Login();
//        login.setUsername(username);
//        login.setPassword(password);
//
//        try {
//            if (loginDAO.validate(login)) {
////                HttpSession session = request.getSession();
////                session.setAttribute("username", username);
//                response.sendRedirect("/homepage/minishop-master/minishop-master/homepage.jsp");
//            } else {
////                HttpSession session = request.getSession();
////                session.setAttribute("user", username);
//                response.sendRedirect("login.jsp");
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}
//<<<<<<< HEAD
//>>>>>>> ecf40001fbd76130ad07bcaf183f9ed38e49ff0e
//=======
//=======
//package controller;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//
//@WebServlet(name = "LoginServlet", urlPatterns = "/logins")
//public class LoginServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("user");
//        String password = request.getParameter("pass");
//
//
//    }
//}
//>>>>>>> a7574b6365838c7573df263cb95b4a4cd414be2c
//>>>>>>> 6937992147570808aaed3f70b50a15290f7706b0
