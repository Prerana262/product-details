package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public class ProductDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/store";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "@Uvzain262000";

    public List<Product> retrieveProductDetails() {
        List<Product> products = new ArrayList<>();

        try {
            // Load the MySQL JDBC driver
           // Class.forName("com.mysql.jdbc.Driver");
        	Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM product");

            // Iterate over the result set and create Product objects
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getFloat("price");

                // Create a Product object and add it to the list
                Product product = new Product(id, name, price);
                products.add(product);
            }

            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle any exceptions
        }

        return products;
    }
}
