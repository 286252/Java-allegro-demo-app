package pl.szczerbiak.demoapp.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import pl.szczerbiak.demoapp.DemoappApplicationTests;
import pl.szczerbiak.demoapp.domain.*;

import java.awt.*;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class ProductEndpointTest extends DemoappApplicationTests {

    @Autowired
    ProductFacade productFacade;

    @Test
    public void shouldGetNotExistingProducts(){
        final String url = "http://localhost:" + port + "/products/" + "product-id-123";
        ResponseEntity<ProductResponseDto> result = httpClient.getForEntity(url,ProductResponseDto.class);
        assertThat(result.getStatusCodeValue()).isEqualTo(404);
    }

    /*@Test
    public void shouldGetExistingProducts(){
        //given
        PriceDto priceDto = new PriceDto(10.00,"PLN");
        ImageDto imageDto = new ImageDto("https://via.placeholder.com/150");
        DescriptionDto descriptionDto = new DescriptionDto("product long description here");
        ProductRequestDto requestdto = new ProductRequestDto("product",priceDto,imageDto, descriptionDto);
        ProductResponseDto existingProduct = productFacade.create(requestdto);
        final String url = "http://localhost:" + port + "/products/" + existingProduct.getId();
        //when
        ResponseEntity<ProductResponseDto> result = httpClient.getForEntity(url, ProductResponseDto.class);
        //then
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
        assertThat(result.getBody()).isEqualToComparingFieldByField(existingProduct);
    }

    @Test
    public void shouldCreateProduct(){
        //given
        final String url = "http://localhost:"+port+"/products";
        PriceDto priceDto = new PriceDto(10.00,"PLN");
        ImageDto imageDto = new ImageDto("https://via.placeholder.com/150");
        DescriptionDto descriptionDto = new DescriptionDto("product long description here");
        final ProductRequestDto product = new ProductRequestDto("iphone",priceDto,imageDto,descriptionDto);
        String productJson = mapToJson(product);
        //when
        ResponseEntity<ProductResponseDto> result = httpClient.postForEntity(url,
                getHttpRequest(productJson), ProductResponseDto.class);


        //then
        assertThat(result.getStatusCodeValue()).isEqualTo(200); //kod html'a to 201
        assertThat(result.getBody().getName()).isEqualTo("iphone");
    }

    @Test
    public void shouldUpdateProduct(){
        //given
        PriceDto priceDto = new PriceDto(10.00,"PLN");
        ImageDto imageDto = new ImageDto("https://via.placeholder.com/150");
        DescriptionDto descriptionDto = new DescriptionDto("product long description here");
        ProductRequestDto product = new ProductRequestDto("produkt",priceDto,imageDto,descriptionDto);
        ProductResponseDto existingProduct = productFacade.create(product);
        final String url = "http://localhost:" + port + "/products/" + existingProduct.getId();

        ProductRequestDto updateProduct = new ProductRequestDto("produkt2",priceDto,imageDto,descriptionDto);
        String productJson = mapToJson(updateProduct);
        //when
        ResponseEntity<ProductResponseDto> result = httpClient.exchange(url,
                HttpMethod.PUT, getHttpRequest(productJson), ProductResponseDto.class);
        //then
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
        assertThat(result.getBody().getId()).isEqualTo(existingProduct.getId());
        assertThat(result.getBody().getName()).isEqualTo(updateProduct.getName());
    }

    @Test
    public void shouldDeleteProduct(){
        //given
        PriceDto priceDto = new PriceDto(10.00,"PLN");
        ImageDto imageDto = new ImageDto("https://via.placeholder.com/150");
        DescriptionDto descriptionDto = new DescriptionDto("product long description here");
        ProductRequestDto product = new ProductRequestDto("produkt",priceDto,imageDto,descriptionDto);
        ProductResponseDto existingProduct = productFacade.create(product);
        final String url = "http://localhost:" + port + "/products/" + existingProduct.getId();
        //when
        ResponseEntity<ProductResponseDto> result = httpClient.exchange(url, HttpMethod.DELETE,null, ProductResponseDto.class);
        //then
        assertThat(result.getStatusCodeValue()).isEqualTo(204);
    }*/
/*
    @Test
    public void shouldReturnThatTheProductDoesNotExist(){
        //given
        final String url = "http://localhost:" + port + "/products/" + UUID.randomUUID().toString();
        //when
        ResponseEntity<ProductResponseDto> result = httpClient.getForEntity(url, ProductResponseDto.class);
        //then
        assertThat(result.getStatusCodeValue()).isEqualTo(404);
    }
*/
    /*@Test
    public void ShouldGetAll(){
        PriceDto priceDto = new PriceDto(10.00,"PLN");
        ImageDto imageDto = new ImageDto("https://via.placeholder.com/150");
        DescriptionDto descriptionDto = new DescriptionDto("product long description here");
        ProductRequestDto req1 = new ProductRequestDto("product1",priceDto,imageDto,descriptionDto);
        productFacade.create(req1);
        ProductRequestDto req2 = new ProductRequestDto("product2",priceDto,imageDto,descriptionDto);
        productFacade.create(req2);

    }

    @Test
    public void ShouldGetALLExistProduct() {
        //given
        ImageDto imageDto = new ImageDto("https://via.placeholder.com/150");
        DescriptionDto descriptionDto = new DescriptionDto("product long description here");
        ProductRequestDto request1 = new ProductRequestDto("product1",new PriceDto(10.00,"PLN"),imageDto,descriptionDto);
        productFacade.create(request1);
        ProductRequestDto request2 = new ProductRequestDto("product2",new PriceDto(10.00,"PLN"),imageDto,descriptionDto);
        productFacade.create(request2);

        final String url = "http://localhost:" + port + "/products";

        //when
        ResponseEntity<ProductsListResponseDto> result = httpClient.getForEntity(url, ProductsListResponseDto.class);
        ProductsListResponseDto products = result.getBody();
        //then
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
        assertThat(products.getProducts().get(0).getName()).isEqualTo(productFacade.getAll().getProducts().get(0).getName());
        assertThat(products.getProducts().get(1).getName()).isEqualTo(productFacade.getAll().getProducts().get(1).getName());
    }*/

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
