package pl.szczerbiak.demoapp.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequestDto {
    private final String name;
    private final PriceDto priceDto;

    public PriceDto getPrice() {
        return priceDto;
    }

    @JsonCreator
    public ProductRequestDto(@JsonProperty("name") String name, @JsonProperty("price") PriceDto priceDto) {
        this.name = name;
        this.priceDto = priceDto;
    }

    public boolean isValid(){
        return name != null && !name.isBlank();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ProductRequestDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
