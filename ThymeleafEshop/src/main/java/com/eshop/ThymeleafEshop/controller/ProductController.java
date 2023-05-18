package com.eshop.ThymeleafEshop.controller;

import com.eshop.ThymeleafEshop.model.Product;
import com.eshop.ThymeleafEshop.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
// @RestController

public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productServiceImpl) {
        this.productService = productServiceImpl;
        }

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/")
    public String viewHomePage(Model model) throws SQLException {
        model.addAttribute("allprolist", productService.getAllProduct());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewProduct(Model model)  {
        Product product = new Product();
        model.addAttribute("product", product);
        return "newproduct";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) throws SQLException {
        try {
            productService.save(product);
            logger.info("The product has been saved");
            return "redirect:/";
        } catch (Exception e) {
            logger.error("I can't save the product - incorrectly filled attributes!", e);
        }
        return "redirect:/";
    }


    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product) throws SQLException {
        try {
        productService.update(product);
        } catch (Exception e) {
            logger.error("I can't save the product - incorrectly filled attributes!", e);
        }
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updatePriceById(@ModelAttribute("product") Product product) throws SQLException {
       productService.update(product);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) throws SQLException {
        Product updated = productService.updateProduct(id, model);
        model.addAttribute("product", updated);
        return "update";
    }


    // delete from product where id = 1;
    @GetMapping("/deleteProduct/{id}")
    public String deleteThroughId(@PathVariable(value = "id") int id) throws SQLException {
        productService.deleteViaId(id);
       return "redirect:/";
    }


    //  delete from product where isForSale = false;
    @GetMapping("/deleteProduct/false")
    public String deleteIsForSaleFalse(@PathVariable(value = "isForSale") boolean isForSale) throws SQLException {
        productService.deleteIsForSale(isForSale);
        return "redirect:/";
    }

}
