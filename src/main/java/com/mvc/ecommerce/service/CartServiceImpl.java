package com.mvc.ecommerce.service;

import com.mvc.ecommerce.Repository.AddToCartRepo;
import com.mvc.ecommerce.Repository.CheckoutRepo;
import com.mvc.ecommerce.model.AddtoCart;
import com.mvc.ecommerce.model.CheckoutCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    AddToCartRepo addCartRepo;

    @Autowired
    CheckoutRepo checkoutRepo;

    @Override
    public List<AddtoCart> addCartbyUserIdAndProductId(long productId, long userId, int qty, double price) throws Exception {

        try {
            if (addCartRepo.getCartByProductIdAnduserId(userId, productId).isPresent()) {
                throw new Exception("Product is already exist.");
            }
            AddtoCart obj = new AddtoCart();
            obj.setQty(qty);
            obj.setUser_id(userId);
            obj.setProduct_id(productId);
            obj.setPrice(price);
            addCartRepo.save(obj);
            return this.getCartByUserId(userId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void updateQtyByCartId(long cartId, int qty, double price) throws Exception {
        addCartRepo.updateQtyByCartId(cartId, price, qty);
    }

    @Override
    public List<AddtoCart> getCartByUserId(long userId) {
       return addCartRepo.getCartByuserId(userId);
    }

    @Override
    public List<AddtoCart> removeCartByUserId(long cartId, long userId) {
        addCartRepo.deleteCartByIdAndUserId(userId, cartId);
        return this.getCartByUserId(userId);
    }

    @Override
    public List<AddtoCart> removeAllCartByUserId(long userId) {
        addCartRepo.deleteAllCartByUserId(userId);
        return null;
    }

    @Override
    public Boolean checkTotalAmountAgainstCart(double totalAmount, long userId) {
        double total_amount = addCartRepo.getTotalAmountByUserId(userId);
        if(total_amount == totalAmount) {
            return true;
        }
        System.out.println("Error from request " + total_amount + "--db--" + totalAmount);
        return false;
    }

    @Override
    public List<CheckoutCart> getAllCheckoutByUserId(long userId) {
       return checkoutRepo.getByuserId(userId);
    }

    @Override
    public List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp) throws Exception {
         try {
             long user_id = tmp.get(0).getUser_id();
             if(tmp.size() > 0) {
                 checkoutRepo.saveAll(tmp);
                 this.removeAllCartByUserId(user_id);
                 return this.getAllCheckoutByUserId(user_id);
             }
             else {
                 throw new Exception("should not be empty");
             }
         } catch (Exception e) {
             throw new Exception("Error while checkout "+ e.getMessage());
         }
    }
}
