package com.example.dbtema7;
import com.example.dbtema7.controller.CartController;
import com.example.dbtema7.service.CartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CartController.class)
public class CartControllerTest {
    @MockBean
    CartService CartService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_create_shoppig_cart() throws Exception{
        String request = "{\"id\" : 1, \"productList\" : null }";
        mockMvc.perform(post("/Cart/createCart")
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void it_should_get_all_shopping_carts() throws Exception{
        mockMvc.perform(get("/Cart/getAll"))
                .andExpect(status().isOk());
    }
}