package com.eshop.ThymeleafEshop.service;

import com.eshop.ThymeleafEshop.model.Product;
import com.eshop.ThymeleafEshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository proRepo;

    public ProductServiceImpl(ProductRepository proRepo) {
        this.proRepo = proRepo;
    }

    @Override
    public List<Product> getAllProduct() throws SQLException {
        return proRepo.getAll();
    }

    @Override
    public void save(Product product) throws SQLException {
        proRepo.save(product);
    }


    @Override
    public Product getById(int id) throws SQLException {
        Product product = proRepo.findById(id);

        if (product != null) {
            return product;
        } else {
            throw new RuntimeException("Product not found for id : " + id);
        }

    }

    @Override
    public void deleteViaId(int id) throws SQLException {
        Product product = proRepo.findById(id);
        if (product != null) {
            proRepo.deleteById(id);
           } else
           {
            throw new RuntimeException("Product not found for id : " + id);
        }
    }

    @Override
    public void deleteIsForSale(boolean isForSale) throws SQLException {
        proRepo.deleteIsForSale(isForSale);
    }


    @Override
    public void update(Product product) throws SQLException {
        proRepo.update(product);
    }

    @Override
    public Product updateProduct(int id, Model model) throws SQLException {
        Product product = proRepo.findById(id);
        if (product != null) {
            proRepo.update(product);
        }
         else {
            throw new RuntimeException("Product not found for id : " + id);
        }
        return product;
    }


    @Override
    public Product updatePriceById(int id, Model model) throws SQLException {
        Product product = proRepo.findById(id);
        if (product != null) {
            proRepo.update(product);
        }
        else {
            throw new RuntimeException("Product not found for id : " + id);
        }
        return product;
    }


}