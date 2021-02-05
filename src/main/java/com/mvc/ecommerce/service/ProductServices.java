package com.mvc.ecommerce.service;

import com.mvc.ecommerce.Repository.CategoryRepo;
import com.mvc.ecommerce.Repository.ProductRepo;
import com.mvc.ecommerce.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepo;

    public List<Products> getAllProducts() {
        return productRepo.findAll();
    }
}
