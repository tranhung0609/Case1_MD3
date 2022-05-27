package controller;

import model.Account;
import service.impl.AccountServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AccountServlet", urlPatterns = "/accounts")
public class AccountServlet extends HttpServlet {
    AccountServiceImpl accountService = new AccountServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                showFormLogin(request, response);
                break;
            case "signup":
                showFormSignUp(request, response);
                break;
        }
    }

    private void showFormSignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login/register-form/colorlib-regform-33/colorlib-regform-33/register.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                login(request, response);
                break;
            case "signup":
                try {
                    signUp(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void signUp(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String comfirmPassword = request.getParameter("comfirmPassword");
        Account account = new Account(name, email, address, password);
        if (accountService.checkSignUp(account) && accountService.checkPass(password, comfirmPassword)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request,response);
        } else {
            response.sendRedirect("/accounts?action=signup");
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (accountService.checkLogin(email, password)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("homepage/minishop-master/minishop-master/homepage.jsp");
            requestDispatcher.forward(request,response);
        } else {
            response.sendRedirect("/account?action=login");
        }
    }
}
