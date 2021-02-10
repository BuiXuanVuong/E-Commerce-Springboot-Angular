package com.mvc.ecommerce.Repository;

import com.mvc.ecommerce.model.AddtoCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AddToCartRepo extends JpaRepository<AddtoCart, Long> {

    @Query("Select sum(addCart.price)  FROM add_to_cart addCart WHERE addCart.user_id=:user_id")
    double getTotalAmountByUserId(@Param("user_id")Long user_id);

    @Query("Select addCart  FROM add_to_cart addCart WHERE addCart.user_id=:user_id")
    List<AddtoCart> getCartByuserId(@Param("user_id")Long user_id);


    @Query("SELECT addCart FROM add_to_cart addCart WHERE addCart.product_id=:product_id AND addCart.user_id=:user_id")
    Optional<AddtoCart> getCartByProductIdAnduserId(@Param("user_id")Long user_id, @Param("product_id")Long product_id);

    @Modifying
    @Transactional
    @Query("DELETE  FROM add_to_cart addCart WHERE addCart.id =:cart_id   and addCart.user_id=:user_id")
    void deleteCartByIdAndUserId(@Param("user_id")Long user_id,@Param("cart_id")Long cart_id);

    @Modifying
    @Transactional
    @Query("DELETE  FROM add_to_cart addCart WHERE   addCart.user_id=:user_id")
    void deleteAllCartByUserId(@Param("user_id")Long user_id);


    @Modifying
    @Transactional
    @Query("UPDATE add_to_cart addCart set addCart.qty=:qty, addCart.price=:price  WHERE addCart.id=:cart_id")
    void updateQtyByCartId(@Param("cart_id")Long cart_id, @Param("price")double price, @Param("qty")Integer qty);


}
