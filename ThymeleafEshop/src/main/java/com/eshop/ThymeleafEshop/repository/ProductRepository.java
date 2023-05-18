package com.eshop.ThymeleafEshop.repository;

import com.eshop.ThymeleafEshop.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository {

    Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/eshop",
            "Engeto",
            "JavaEngeto123");

    Statement statement = connection.createStatement();

    public ProductRepository() throws SQLException {
    }

    public List<Product> getAll() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM product");

        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            Product product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setPartNumber(resultSet.getInt("partNumber"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setForSale(resultSet.getBoolean("isforSale"));
            product.setPrice(resultSet.getDouble("price"));
            products.add(product);
        }
        return products;
    }


    public void save(Product product) throws SQLException {
        try {
            String query = "INSERT INTO product (partNumber, name, description, isForSale, price) VALUES ('"
                    + product.getPartNumber() + "', '"
                    + product.getName() + "', '"
                    + product.getDescription() + "', '"
                    + product.booleanToInt(product.isForSale()) + "', '"
                    + product.getPrice() + "')";
            statement.executeUpdate(query);
        } catch (NumberFormatException e) {
            throw new SQLException("Špatně zadané číslo partNumber", e);
          }

    }

    public void deleteById(int id) throws SQLException {
        String query = "DELETE FROM product WHERE id = " + id;
        statement.executeUpdate(query);
    }

    public void deleteIsForSale(boolean isForSale) throws SQLException {
        String query = "DELETE FROM product WHERE isForSale = false";
        statement.executeUpdate(query);
    }


    public Product findById(int id) throws SQLException {
        String query = "SELECT * FROM product WHERE id = " + id;
        ResultSet resultSet = statement.executeQuery(query);
        Product product = new Product();
        if (resultSet.next()) {
            product.setId(resultSet.getInt("id"));
            product.setPartNumber(resultSet.getInt("partNumber"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setForSale(resultSet.getBoolean("isForSale"));
            product.setPrice(resultSet.getDouble("price"));
        }
        return product;
    }

    public void update(Product product) throws SQLException {
       String query = "UPDATE product SET "
                + "partNumber = '" + product.getPartNumber() + "', "
                + "name = '" + product.getName() + "', "
                + "description = '" + product.getDescription() + "', "
                + "isForSale = '" + product.booleanToInt(product.isForSale()) + "', "
                + "price = '" + product.getPrice() + "' WHERE id = " + product.getId();
        statement.executeUpdate(query);
      }

    public void updatePriceById(Product product) throws SQLException {
        String query = "UPDATE product SET "
                + "price = '" + product.getPrice() + "' WHERE id = " + product.getId();
        statement.executeUpdate(query);
    }

}
