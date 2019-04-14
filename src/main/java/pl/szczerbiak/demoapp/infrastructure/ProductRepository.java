package pl.szczerbiak.demoapp.infrastructure;

import pl.szczerbiak.demoapp.domain.PriceDto;
import pl.szczerbiak.demoapp.domain.Product;

import java.util.List;

public interface ProductRepository {
    void save(Product product);
    Product findById(String id);
    Product update(String name, Product product, PriceDto priceDto);
    void delete(String id);
    List<Product> getAll();

}
