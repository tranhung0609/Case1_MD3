package controller;

import service.impl.OrderDetailServiceImpl;
import service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "OrderServlet", urlPatterns = "/orders")
public class OrderServlet extends HttpServlet {
    OrderDetailServiceImpl orderDetailService = new OrderDetailServiceImpl();
    OrderServiceImpl orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        switch (action) {
            case "add-cart":
                addCart(request, response);
                break;
            case "buy":
                addCart(request, response);
                break;
        }

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
            case "add-cart":
                addCart(request, response);
                break;
            case "buy":
                addCart(request, response);
                break;
        }
    }

    private void addCart(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        orderService.add();

    }
}
