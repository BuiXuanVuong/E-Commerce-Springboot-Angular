package com.mvc.ecommerce.Repository;

import com.mvc.ecommerce.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Products, Long> {

}
