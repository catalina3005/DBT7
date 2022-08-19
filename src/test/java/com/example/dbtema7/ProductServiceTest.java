package com.example.dbtema7;
import com.example.dbtema7.model.ProductType;
import com.example.dbtema7.model.Product;
import com.example.dbtema7.repository.ProductRepository;
import com.example.dbtema7.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void createProductTest(){
        Product product = new Product(null,"Produs1","56786", ProductType.ELB,3,false,4);
        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product productCreated = productService.createProduct(product);
        assertThat(productCreated.getName()).isSameAs(product.getName());
    }

    @Test
    public void getAllProductsTest(){
        Product product = new Product(null,"Produs1","56786", ProductType.ELB,3,false,4);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> createdProductList = productService.getAllProducts();
        assertThat(createdProductList.size()).isSameAs(productList.size()).isGreaterThan(0);
    }

    @Test
    public void updateStockTest() {
        Product product = new Product(null,"Produs1","56786", ProductType.ELB,3,false,4);
        given(productRepository.findById(product.getId())).willReturn(Optional.of(product));
        productService.updateStock(product.getId(),68);
        Product updatedProduct = productRepository.findById(product.getId()).get();
        assertThat(updatedProduct.getStock()).isSameAs(68);
    }
}