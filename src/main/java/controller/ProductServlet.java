package controller;

import model.Product;
import service.implement.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view":
                showProductForm(request, response);
                break;
            case "creat":
                showCreatForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            default:
                showListCustomer(request, response);
                break;
        }
    }

    private void showProductForm(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showCreatForm(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/homepage/minishop-master/minishop-master/shop.jsp");
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");


    }
}


