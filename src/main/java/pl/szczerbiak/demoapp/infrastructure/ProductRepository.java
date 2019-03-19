package pl.szczerbiak.demoapp.infrastructure;

import pl.szczerbiak.demoapp.domain.Product;

public interface ProductRepository {
    void save(Product product);
}
