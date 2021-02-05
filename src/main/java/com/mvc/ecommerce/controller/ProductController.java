package com.mvc.ecommerce.controller;

import com.mvc.ecommerce.model.Products;
import com.mvc.ecommerce.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductServices productServices;
    @RequestMapping("getAll")
    public List<Products> getAllProducts() {
        return productServices.getAllProducts();
    }

}
