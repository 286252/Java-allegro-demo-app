package pl.szczerbiak.demoapp.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.szczerbiak.demoapp.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class InMemoryProductRepository implements ProductRepository{

    private final Map<String, Product> products = new HashMap<>();

    @Override
    public void save(Product product){
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(String id) {
        if(!products.containsKey(id)) throw new ProductNotFoundException("Product not found!");
        return products.get(id);
    }

    @Override
    public Product update(String name, Product product, PriceDto priceDto, ImageDto imageDto, DescriptionDto descriptionDto, List<TagsDto> tags) {
        if(!products.containsKey(product.getId())) throw new
                ProductNotFoundException("Aktualizacja danych się nie powiodła, nie znaleziono produktu!");
        products.put(product.getId(), new Product(product.getId(), name , product.getCreatedAt(),priceDto, imageDto, descriptionDto, tags));
        return products.get(product.getId());
    }

    @Override
    public void delete(String id) {
        if(!products.containsKey(id)) throw new ProductNotFoundException("Usunięcie produktu się nie powiodło, ponieważ, " +
                "nie znaleziono produktu!");
        products.remove(id);
    }

    @Override
    public List<Product> getAll() {
        return List.copyOf(products.values());
    }

    @Override
    public List<Product> getAllByTags(String tag){
        return products.values()
                .stream()
                .filter(p -> p.getTags() != null)
                .filter(p -> p.getTags().contains(new TagsDto(tag)))
                .collect(Collectors.toList());
    }
}
