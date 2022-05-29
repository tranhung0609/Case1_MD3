package controller;

import model.CartItem;
import model.Category;
import model.Product;
import service.impl.OrderDetailServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/orders")
public class OrderServlet extends HttpServlet {
    OrderServiceImpl orderService = new OrderServiceImpl();
    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        switch (action) {
            case "add-to-cart":
                addToCart(request, response, session);
                break;
            default:
                showListCart(request, response,session);
                break;
        }

    }

    private void showListCart(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart/list.jsp");
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            session.setAttribute("cartItems", cartItems);
        } else {
            double totalPrice = orderService.calTotalPrice(cartItems);
            session.setAttribute("cartItems", cartItems);
            session.setAttribute("totalPrice", totalPrice);
        }
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add-to-cart":
                addToCart(request, response, session);
                break;
            case "buy":
                break;
            default:
                showListCart(request, response,session);
                break;
        }
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = productService.findById(productId);
        CartItem cartItem = new CartItem(product, price, quantity);
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            session.setAttribute("cartItems", cartItems);
        }
        orderService.addToCart(cartItem, cartItems, quantity);
        response.sendRedirect("/orders");
    }
}
