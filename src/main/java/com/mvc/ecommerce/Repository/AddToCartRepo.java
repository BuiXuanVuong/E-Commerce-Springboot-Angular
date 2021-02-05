package com.mvc.ecommerce.Repository;

import com.mvc.ecommerce.model.AddtoCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddToCartRepo extends JpaRepository<AddtoCart, Long> {
}
