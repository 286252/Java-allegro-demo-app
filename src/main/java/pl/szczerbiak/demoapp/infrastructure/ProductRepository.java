package pl.szczerbiak.demoapp.infrastructure;

import pl.szczerbiak.demoapp.domain.Product;

public interface ProductRepository {
    void save(Product product);
    Product findById(String id);
    Product update(String name, Product product);
    void delete(String id);

}
