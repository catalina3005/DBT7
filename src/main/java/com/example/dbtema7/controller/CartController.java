package com.example.dbtema7.controller;
import com.example.dbtema7.model.Cart;
import com.example.dbtema7.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Cart")
public class CartController {
    private final CartService CartService;

    @GetMapping("/getAll")
    public List<Cart> getAllCarts(){
        return CartService.getAllCarts();
    }

    @PostMapping("/createCart")
    public Cart createCart(){
        return CartService.createCart();
    }

    @PostMapping("/addProduct/{CartId}/{productId}")
    public void addProduct(@PathVariable Integer CartId, @PathVariable Integer productId){
        CartService.addProduct(CartId,productId);
    }

    @DeleteMapping("/removeProduct/{CartId}/{productId}")
    public void removeProduct(@PathVariable Integer CartId, @PathVariable Integer productId){
        CartService.removeProduct(CartId,productId);
    }

    @GetMapping("/totalPrice/{CartId}")
    public Integer getTotalPrice(@PathVariable Integer CartId){
        return CartService.totalPrice(CartId);
    }
}