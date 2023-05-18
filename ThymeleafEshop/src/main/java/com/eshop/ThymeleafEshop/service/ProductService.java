package com.eshop.ThymeleafEshop.service;

import com.eshop.ThymeleafEshop.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProduct() throws SQLException;

    void save(Product product) throws SQLException;

    Product getById(int id) throws SQLException;

    void deleteViaId(int id) throws SQLException;

    void update(Product product) throws SQLException;

    Product updateProduct(int id, Model model) throws SQLException;

    Product updatePriceById(int id, Model model) throws SQLException;

    void deleteIsForSale(boolean isForSale) throws SQLException;




}
