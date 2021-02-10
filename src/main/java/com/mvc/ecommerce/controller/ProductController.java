package com.mvc.ecommerce.controller;

import com.mvc.ecommerce.model.Category;
import com.mvc.ecommerce.model.Products;
import com.mvc.ecommerce.service.ProductServices;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    ProductServices productServices;

    @RequestMapping("getAll")
    public List<Products> getAllProducts() {
        return productServices.getAllProducts();
    }

    @RequestMapping("getAllCategory")
    public List<Category> getAllCategory() {
        return productServices.getAllCategory();
    }

    @RequestMapping("getProductsByCategory")
    public List<Products> getProductsByCategory(@RequestBody HashMap<String, String> request) {
        String category_id = request.get("cat_id");
        return productServices.getProductsByCategory(category_id);
    }


    @GetMapping(value = "/getimage/{img_name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImageWithMediaType(@PathVariable("img_name")String img_name) throws Exception {
        InputStream in = getClass().getResourceAsStream("/images/" + img_name);
        return IOUtils.toByteArray(in);
    }

}
