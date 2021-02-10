package com.mvc.ecommerce.service;

import com.mvc.ecommerce.Repository.CategoryRepo;
import com.mvc.ecommerce.Repository.ProductRepo;
import com.mvc.ecommerce.model.Category;
import com.mvc.ecommerce.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryRepo cateRepo;

    public List<Products> getAllProducts() {
        return productRepo.findAll();
    }

    public List<Products> getProductsByCategory(String product_id) {
        return productRepo.getByCategoryId(product_id);
    }

    public List<Category> getAllCategory() {
        return cateRepo.findAll();
    }

    public Products getProductsById(long productId) throws Exception {
        return productRepo.findById(productId).orElseThrow(() ->new Exception("Product is not found"));
    }
}
