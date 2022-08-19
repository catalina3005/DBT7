package com.example.dbtema7.service;
import com.example.dbtema7.model.Product;
import com.example.dbtema7.model.Cart;
import com.example.dbtema7.repository.ProductRepository;
import com.example.dbtema7.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository CartRepository;
    private final ProductRepository productRepository;

    public List<Cart> getAllCarts(){
        return CartRepository.findAll();
    }

    public void addProduct(Integer CartId, Integer productId){
        Optional<Product> product = productRepository.findById(productId);
        Optional<Cart> Cart = CartRepository.findById(CartId);
        Cart.get().addProduct(product.get());
        CartRepository.save(Cart.get());
    }

    public void removeProduct(Integer CartId, Integer productId){
        Optional<Product> product = productRepository.findById(productId);
        Optional<Cart> Cart = CartRepository.findById(CartId);
        Cart.get().removeProduct(product.get());
        CartRepository.save(Cart.get());
    }

    public Integer totalPrice(Integer CartId){
        Optional<Cart> Cart = CartRepository.findById(CartId);
        return Cart.get().totalPrice();
    }

    public Cart createCart(){
        Cart Cart = new Cart();
        return CartRepository.save(Cart);
    }
}