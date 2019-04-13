package pl.szczerbiak.demoapp.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

public class ProductsListResponseDto {
    private final List<ProductResponseDto> products;

    @JsonCreator
    public ProductsListResponseDto(@JsonProperty("products") List<ProductResponseDto> products) {
        this.products = products;
    }

    public List<ProductResponseDto> getProducts() {
        return products;
    }
}