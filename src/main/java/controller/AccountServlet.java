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
//    static Account currentAccount;
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
            case "update":
                showFormUpdate(request, response);
                break;
        }
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showFormSignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login/login-form-14/login-form-14/register.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login/login-form-14/login-form-14/login.jsp");
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
            case "update":
                try {
                    updateAccount(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void updateAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        Account account = new Account(name, email, address, password);
        if (accountService.checkSignUp(account) & accountService.update(account)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("homepage/minishop-master/minishop-master/homepage.jsp");
            requestDispatcher.forward(request,response);
        } else {
            response.sendRedirect("/accounts?action=update");
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
            accountService.add(account);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login/login-form-14/login-form-14/login.jsp");
            requestDispatcher.forward(request,response);
        } else {
            response.sendRedirect("/accounts?action=signup");
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (accountService.checkLogin(email, password)) {
            request.setAttribute("currentAccount",AccountServiceImpl.currentAccount);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("homepage/minishop-master/minishop-master/homepage.jsp");
            requestDispatcher.forward(request,response);
        } else {
            response.sendRedirect("/accounts?action=login");
        }
    }
}
