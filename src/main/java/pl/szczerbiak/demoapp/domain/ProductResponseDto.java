package pl.szczerbiak.demoapp.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

public class ProductResponseDto {
    private final String id;
    private final String name;
    private final PriceDto priceDto;
    private final ImageDto imageDto;
    private final DescriptionDto descriptionDto;
    private final List<TagsDto> tags;

    @Override
    public String toString() {
        return "ProductResponseDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", priceDto=" + priceDto +
                ", imageDto=" + imageDto +
                ", descriptionDto=" + descriptionDto +
                ", tags=" + tags +
                '}';
    }

    public ImageDto getImageDto() {
        return imageDto;
    }

    public PriceDto getPriceDto() {
        return priceDto;
    }

    public DescriptionDto getDescriptionDto() {
        return descriptionDto;
    }

    public List<TagsDto> getTags() {
        return tags;
    }

    @JsonCreator
    public ProductResponseDto(@JsonProperty("id")String id,
                              @JsonProperty("name") String name,
                              @JsonProperty("price") PriceDto priceDto,
                              @JsonProperty("image") ImageDto imageDto,
                              @JsonProperty("description") DescriptionDto descriptionDto,
                              @JsonProperty("tags") List<TagsDto> tags) {
        this.id = id;
        this.name = name;
        this.priceDto = priceDto;
        this.imageDto = imageDto;
        this.descriptionDto = descriptionDto;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
