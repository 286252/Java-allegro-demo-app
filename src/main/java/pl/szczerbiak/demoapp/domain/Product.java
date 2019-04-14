package pl.szczerbiak.demoapp.domain;


import java.time.LocalDateTime;
import java.util.Objects;

public final class Product {

    private final String id;
    private final String name;
    private final LocalDateTime createdAt;

    private final PriceDto priceDto;
    private final ImageDto imageDto;
    private final DescriptionDto descriptionDto;

    public PriceDto getPriceDto() {
        return priceDto;
    }

    public ImageDto getImageDto() {
        return imageDto;
    }

    public Product(String id, String name, LocalDateTime createdAt,
                   PriceDto priceDto, ImageDto imageDto, DescriptionDto descriptionDto) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.priceDto = priceDto;
        this.imageDto = imageDto;
        this.descriptionDto = descriptionDto;
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
        Product that = (Product) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdAt);
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
