package pl.szczerbiak.demoapp.domain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.szczerbiak.demoapp.infrastructure.ProductRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
public class ProductFacadeImpl implements ProductFacade {
    private final ProductRepository productRepository;

    public ProductFacadeImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductsListResponseDto getAll() {
        List<Product> products = productRepository.getAll();
        return new ProductsListResponseDto(products.stream().map(product ->
                new ProductResponseDto(product.getId(), product.getName(),product.getPriceDto(),
                        product.getImageDto(),product.getDescriptionDto(), product.getTags()))
                .sorted(Comparator.comparing(ProductResponseDto::getId)).collect(Collectors.toList()));
    }

    @Override
    public ProductsListResponseDto getAllByTag(String tag){
        List<Product> products = productRepository.getAllByTags(tag);
        return new ProductsListResponseDto(products.stream().map(product ->
                new ProductResponseDto(product.getId(), product.getName(), product.getPriceDto(), product.getImageDto(),
                        product.getDescriptionDto(), product.getTags()))
                .sorted(Comparator.comparing(ProductResponseDto::getId)).collect(Collectors.toList()));
    }

    @Override
    public ProductResponseDto findById(String id){
        Product product = productRepository.findById(id);
        if(product.equals(null)){
            throw new RuntimeException("Product not exist!");
        }
        return  new ProductResponseDto(product.getId(),product.getName(),product.getPriceDto(),
                product.getImageDto(),product.getDescriptionDto(), product.getTags());

    }

    @Override
    public ProductResponseDto create(ProductRequestDto productRequest){
        //walidacja
        if (!productRequest.isValid()){
            throw new RuntimeException("Product name cannot be empty!");
        }
        //Stworzyć produkt
        String id = UUID.randomUUID().toString();
        LocalDateTime createdAt = LocalDateTime.now();
        Product product = new Product(id, productRequest.getName(), createdAt,
                productRequest.getPrice(), productRequest.getImageDto(),productRequest.getDescriptionDto(), productRequest.getTags());
        // zapisać go
        productRepository.save(product);

        //ProductResponseDto responseDto = new ProductResponseDto(product.getId(),product.getName());

        //przemapować produkt na product response i zwrócić
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPriceDto(),
                product.getImageDto(),
                product.getDescriptionDto(),
                product.getTags()
        );
    }

    @Override
    public ProductResponseDto update(String id, ProductRequestDto productRequestDto) {
        if (!productRequestDto.isValid()){
            throw new RuntimeException("Product name cannot be empty!");
        }

        Product product = productRepository.findById(id);
        Product updatedProduct = productRepository.update(productRequestDto.getName(),product, productRequestDto.getPrice(),
                productRequestDto.getImageDto(), productRequestDto.getDescriptionDto(), productRequestDto.getTags());

        return new ProductResponseDto(updatedProduct.getId(), updatedProduct.getName(),
                updatedProduct.getPriceDto(),product.getImageDto(),product.getDescriptionDto(), productRequestDto.getTags());
    }

    @Override
    public ResponseEntity<Void> delete(String id){
        productRepository.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
