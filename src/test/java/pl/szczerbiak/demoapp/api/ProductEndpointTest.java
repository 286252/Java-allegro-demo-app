package pl.szczerbiak.demoapp.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import pl.szczerbiak.demoapp.DemoappApplicationTests;
import pl.szczerbiak.demoapp.domain.ProductFacade;
import pl.szczerbiak.demoapp.domain.ProductRequestDto;
import pl.szczerbiak.demoapp.domain.ProductResponseDto;

import static org.assertj.core.api.Assertions.*;

public class ProductEndpointTest extends DemoappApplicationTests {

    @Autowired
    ProductFacade productFacade;
    @Test
    public void shouldGetExistingProducts(){
        //given
        ProductRequestDto requestdto = new ProductRequestDto("product");
        ProductResponseDto existingProduct = productFacade.create(requestdto);
        final String url = "http://localhost:" + port + "/products/" + existingProduct.getId();
        //when
        ResponseEntity<ProductResponseDto> result = httpClient.getForEntity(url, ProductResponseDto.class);
        //ten
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
        assertThat(result.getBody()).isEqualToComparingFieldByField(existingProduct);
    }

    @Test
    public void shouldCreateProduct(){
        //given
        final String url = "http://localhost:"+port+"/products";
        final ProductRequestDto product = new ProductRequestDto("iphone");
        String productJson = mapToJson(product);
        //when
        ResponseEntity<ProductResponseDto> result = httpClient.postForEntity(url,
                getHttpRequest(productJson), ProductResponseDto.class);


        //then
        assertThat(result.getStatusCodeValue()).isEqualTo(200); //kod html'a to 201
        assertThat(result.getBody().getName()).isEqualTo("iphone");
    }

    String mapToJson (ProductRequestDto productRequestDto) {
        try {
            return objectMapper.writeValueAsString(productRequestDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
            //e.printStackTrace();
        }
    }

    private HttpEntity<String> getHttpRequest(String json){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("content-type","application/json");
        return new HttpEntity<>(json,httpHeaders);
    }
}