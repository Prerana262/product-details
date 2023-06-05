package com.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ProductDAO;
import com.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Assuming you have a method to retrieve the product details from a data source
    	ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.retrieveProductDetails();

        // Set the product list as a request attribute
        request.setAttribute("productsList", products);

        // Forward the request to the JSP for rendering
        request.getRequestDispatcher("productDetails.jsp").forward(request, response);
    }

    private List<Product> retrieveProductDetails() {
        // Your implementation to retrieve the product details from a data source
        // For demonstration purposes, let's assume we are creating sample data here
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Product 1", 10.0));
        products.add(new Product(2, "Product 2", 20.0));
        products.add(new Product(3, "Product 3", 30.0));
        return products;
    }
}
