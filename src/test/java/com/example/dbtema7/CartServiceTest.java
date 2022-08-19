package com.example.dbtema7;
import com.example.dbtema7.model.Cart;
import com.example.dbtema7.repository.CartRepository;
import com.example.dbtema7.service.CartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {
    @Mock
    CartRepository CartRepository;

    @InjectMocks
    CartService CartService;

    @Test
    public void it_should_save_shopping_cart(){
        Cart cart = new Cart();
        when(CartRepository.save(any(Cart.class))).thenReturn(new Cart());
        Cart cartCreated = CartService.createCart();
        assertThat(cartCreated.getId()).isSameAs(cart.getId());
    }

    @Test
    public void getAllCartsTest(){
        Cart Cart = new Cart();
        List<Cart> carts = new ArrayList<>();
        carts.add(Cart);
        when(CartRepository.findAll()).thenReturn(carts);
        List<Cart> createdCarts = CartService.getAllCarts();
        assertThat(createdCarts.size()).isSameAs(carts.size()).isGreaterThan(0);
    }
}