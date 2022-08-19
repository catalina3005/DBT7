package com.example.dbtema7;
import com.example.dbtema7.controller.ProductController;
import com.example.dbtema7.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @MockBean
    ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createProductTest() throws Exception{
        String request = "{ \"name\" : \"Produs1\", \"code\" : \"56786\", \"productType\" : \"ELB\", \"stock\" : \"3\",\"price\" : \"4\"}";

        mockMvc.perform(post("/product/addProduct")
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllProductsTest() throws Exception{
        mockMvc.perform(get("/product/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void updateStockTest() throws Exception{
        mockMvc.perform(put("/product/updateStock/id/{id}/stock" + "?stock=3",1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}