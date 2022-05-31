package controller;

import model.Category;
import model.Product;
import model.Promotion;
import service.impl.AccountServiceImpl;
import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;
import service.impl.PromotionServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    CategoryServiceImpl categoryService = new CategoryServiceImpl();
    PromotionServiceImpl promotionService = new PromotionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "details":
                showProductDetails(request, response);
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
            case "search":
                showSearchForm(request, response);
                break;
            case "sort":
                sortProductByQuantitySold(request, response);
                break;
              default:
                homePage(request, response);
                break;
        }
    }

    private void sortProductByQuantitySold(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/coloshop-master/sort.jsp");
        List<Product> products = productService.sortByQuantitySold();
        request.setAttribute("products", products);
        requestDispatcher.forward(request, response);
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/search.jsp");
        requestDispatcher.forward(request, response);
    }

    private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("coloshop-master/homepage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showProductDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/details.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        List<Category> categories = categoryService.findAll();
        List<Promotion> promotions = promotionService.findAll();
        request.setAttribute("categories", categories);
        request.setAttribute("promotions", promotions);
        requestDispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        List<Category> categories = categoryService.findAll();
        List<Promotion> promotions = promotionService.findAll();
        request.setAttribute("categories", categories);
        request.setAttribute("promotions", promotions);
        requestDispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            productService.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/products?action=sell-list");
    }

    private void showListProductAtSell(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list-sell.jsp");
        List<Product> products = productService.findAllAtSell();
        request.setAttribute("products", products);
        requestDispatcher.forward(request, response);
    }

    private void showListProductAtBuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/coloshop-master/categories.jsp");
        List<Product> products = productService.findAllAtBuy();
        request.setAttribute("products", products);
        requestDispatcher.forward(request, response);
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
                try {
                    createProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                searchProduct(request, response);
                break;
            case "edit":
                try {
                    editProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String image = request.getParameter("image");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int categoryId = Integer.parseInt(request.getParameter("category"));
        int promotionId = Integer.parseInt(request.getParameter("promotion"));
        Product product = new Product(id, name, price, image, quantity, categoryService.findById(categoryId), promotionService.findById(promotionId), AccountServiceImpl.currentAccount);
        productService.update(product);
        response.sendRedirect("/products?action=sell-list");
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        List<Product> products = productService.findByName(name);
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/search.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String image = request.getParameter("image");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int categoryId = Integer.parseInt(request.getParameter("category"));
        int promotionId = Integer.parseInt(request.getParameter("promotion"));
        Product product = new Product(name, price, image, quantity, categoryService.findById(categoryId), promotionService.findById(promotionId), AccountServiceImpl.currentAccount);
        productService.add(product);
        response.sendRedirect("/products?action=sell-list");
    }
}




