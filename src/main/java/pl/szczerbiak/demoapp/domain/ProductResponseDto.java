package pl.szczerbiak.demoapp.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class ProductResponseDto {
    private final String id;
    private final String name;
    private final PriceDto priceDto;

    @Override
    public String toString() {
        return "ProductResponseDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + priceDto + '\'' +
                '}';
    }

    public PriceDto getPriceDto() {
        return priceDto;
    }

    @JsonCreator
    public ProductResponseDto(@JsonProperty("id")String id,
                              @JsonProperty("name") String name,
                              @JsonProperty("price") PriceDto priceDto) {
        this.id = id;
        this.name = name;
        this.priceDto = priceDto;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
