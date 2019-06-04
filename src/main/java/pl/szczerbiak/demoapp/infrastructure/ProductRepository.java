package pl.szczerbiak.demoapp.infrastructure;

import pl.szczerbiak.demoapp.domain.*;

import java.util.List;

public interface ProductRepository {
    void save(Product product);
    Product findById(String id);
    Product update(String name, Product product, PriceDto priceDto, ImageDto imageDto, DescriptionDto descriptionDto, List<TagsDto> tags);
    void delete(String id);
    List<Product> getAll();
    List<Product> getAllByTags(String tag);
}
