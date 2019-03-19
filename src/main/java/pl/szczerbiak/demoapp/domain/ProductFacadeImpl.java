package pl.szczerbiak.demoapp.domain;

import org.springframework.stereotype.Component;
import pl.szczerbiak.demoapp.infrastructure.ProductRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class ProductFacadeImpl implements ProductFacade {


    public final ProductRepository productRepository;

    ProductFacadeImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto create(ProductRequestDto productRequest){

        if (!productRequest.isValid()){
            throw new RuntimeException("Product name cannot be empty!");
        }
        String id = UUID.randomUUID().toString();
        LocalDateTime createdAt = LocalDateTime.now();
        Product product = new Product(id, productRequest.getName(), createdAt);

        productRepository.save(product);

        ProductResponseDto responseDto = new ProductResponseDto(product.getId(),product.getName());

        return null;
        //Stworzyć produkt
        // zapisać go
        //przemapować produkt na product response i zwrócić
    }
}
