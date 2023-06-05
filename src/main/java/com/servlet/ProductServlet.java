package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/store";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "@Uvzain262000";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Float price = Float.parseFloat(request.getParameter("price"));

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            // Create a connection to the database
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Prepare the SQL statement to insert the product details
            String query = "INSERT INTO product (id, name, price) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setDouble(3, price);

            // Execute the SQL statement
            int rowsInserted = statement.executeUpdate();

            // Close the statement and connection
            statement.close();
            connection.close();

            if (rowsInserted > 0) {
                response.sendRedirect("success.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
