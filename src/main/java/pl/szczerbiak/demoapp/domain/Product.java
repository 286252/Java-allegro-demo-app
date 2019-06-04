package pl.szczerbiak.demoapp.domain;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public final class Product {

    private final String id;
    private final String name;
    private final LocalDateTime createdAt;

    private final PriceDto priceDto;
    private final ImageDto imageDto;
    private final DescriptionDto descriptionDto;
    private final List<TagsDto> tags;

    public Product(String id, String name, LocalDateTime createdAt,
                   PriceDto priceDto, ImageDto imageDto, DescriptionDto descriptionDto, List<TagsDto> tags) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.priceDto = priceDto;
        this.imageDto = imageDto;
        this.descriptionDto = descriptionDto;
        this.tags = tags;
    }

    public PriceDto getPriceDto() {
        return priceDto;
    }

    public ImageDto getImageDto() {
        return imageDto;
    }

    public List<TagsDto> getTags() {
        return tags;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public DescriptionDto getDescriptionDto() {
        return descriptionDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(createdAt, product.createdAt) &&
                Objects.equals(priceDto, product.priceDto) &&
                Objects.equals(imageDto, product.imageDto) &&
                Objects.equals(descriptionDto, product.descriptionDto) &&
                Objects.equals(tags, product.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdAt, priceDto, imageDto, descriptionDto, tags);
    }

    @Override
    public String toString() {
        return "ProductJava{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
