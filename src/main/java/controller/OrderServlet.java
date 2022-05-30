package controller;

import model.CartItem;
import model.Category;
import model.Product;
import service.impl.*;

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
    ManageCartItem manageCartItem = new ManageCartItem();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add-to-cart":
                addToCart(request, response, session);
                break;
            case "show":
                showListCart(request, response, session);
                break;
            case "delete":
                deleteFromCart(request, response, session);
                break;
            case "buy":
                buyFromCart(request, response, session);
                break;
        }

    }

    private void buyFromCart(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");

    }

    private void deleteFromCart(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        int cartItemId = Integer.parseInt(request.getParameter("cartItemId"));
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        manageCartItem.deleteProduct(cartItemId, cartItems);
        response.sendRedirect("/orders?action=show");
    }

    private void showListCart(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/check-out.jsp");
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            session.setAttribute("cartItems", cartItems);
        } else {
            List<CartItem> myCartItems = manageCartItem.findByAccount(AccountServiceImpl.currentAccount.getId(), cartItems);
            if (myCartItems == null) {
                myCartItems = new ArrayList<>();
                session.setAttribute("myCartItems", myCartItems);
            } else {
                double totalPrice = orderService.calTotalPrice(myCartItems);
                session.setAttribute("myCartItems", myCartItems);
                session.setAttribute("totalPrice", totalPrice);
            }
        }
        requestDispatcher.forward(request, response);
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        List<CartItem> myCartItems;
        int quantity = 1;
//                Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = productService.findById(productId);
        CartItem cartItem = new CartItem(product, AccountServiceImpl.currentAccount, price, quantity);
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            myCartItems = new ArrayList<>();
            session.setAttribute("cartItems", cartItems);
            session.setAttribute("myCartItems", myCartItems);
        } else {
            myCartItems = manageCartItem.findByAccount(AccountServiceImpl.currentAccount.getId(), cartItems);
            if (myCartItems.size() == 0) {
                myCartItems = new ArrayList<>();
                session.setAttribute("myCartItems", myCartItems);
            }
        }
        manageCartItem.addToCart(cartItem, cartItems, quantity);
        response.sendRedirect("/orders?action=show");
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
//        switch (action) {
//            case "add-to-cart":
//                addToCart(request, response, session);
//                break;
//            case "buy":
//                break;
//            default:
//                showListCart(request, response, session);
//                break;
//        }
    }


}
