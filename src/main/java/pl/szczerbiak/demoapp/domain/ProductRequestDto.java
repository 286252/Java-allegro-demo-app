package pl.szczerbiak.demoapp.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequestDto {
    private final String name;
    private final PriceDto priceDto;
    private final ImageDto imageDto;
    private final DescriptionDto descriptionDto;
    private final List<TagsDto> tags;

    public PriceDto getPriceDto() {
        return priceDto;
    }

    public DescriptionDto getDescriptionDto() {
        return descriptionDto;
    }

    public ImageDto getImageDto() {
        return imageDto;
    }

    public PriceDto getPrice() {
        return priceDto;
    }

    public List<TagsDto> getTags() {
        return tags;
    }

    @JsonCreator
    public ProductRequestDto(@JsonProperty("name") String name,
                             @JsonProperty("price") PriceDto priceDto,
                             @JsonProperty("image") ImageDto imageDto,
                             @JsonProperty("description") DescriptionDto descriptionDto,
                             @JsonProperty("tags") List<TagsDto> tags) {
        this.name = name;
        this.priceDto = priceDto;
        this.imageDto = imageDto;
        this.descriptionDto = descriptionDto;
        this.tags = tags;
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
                ", priceDto=" + priceDto +
                ", imageDto=" + imageDto +
                ", descriptionDto=" + descriptionDto +
                ", tags=" + tags +
                '}';
    }
}
