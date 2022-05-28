package controller;

import model.Product;
import service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    private ProductServiceImpl getProductService;

    public void init(){
        getProductService = new ProductServiceImpl();
    }

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
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "sell-list":
                showListProductAtSell(request, response);
                break;
            case "buy-list":
                showListProductAtBuy(request, response);
                break;
            default:
                showListProduct(request,response);
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("coloshop-master/homepage.jsp");
        List<Product> productList = productService.findAll();
        request.setAttribute("products",productList);
        requestDispatcher.forward(request,response);
    }

    private void showProductForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/createproduct/create-product.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showListProductAtSell(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/coloshop-master/categories.jsp");
        List<Product> products = productService.findAllAtSell();
        request.setAttribute("products", products);
        requestDispatcher.forward(request, response);
    }

    private void showListProductAtBuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/coloshop-master/categories.jsp");
//        List<Product> products = productService.findAllAtBuy();
//        request.setAttribute("products", products);
//        requestDispatcher.forward(request, response);
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
            case "create":
//                createProduct(request, response);
                break;


    }
}

//    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
//        String name = request.getParameter("name");
//        double price = Double.parseDouble(request.getParameter("price"));
//        String image = request.getParameter("image");
//        String image = request.getParameter("image");
//        String image = request.getParameter("image");
//        String image = request.getParameter("image");
//        Product newProduct = new Product(name,price);
//        try {
//            getProductService.add(newProduct);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
//        dispatcher.forward(request, response);
//    }
//    }
    }




