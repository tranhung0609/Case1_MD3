
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
