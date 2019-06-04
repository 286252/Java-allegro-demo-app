package pl.szczerbiak.demoapp.domain;

import org.springframework.http.ResponseEntity;

public interface ProductFacade {
    //get
    ProductResponseDto findById(String id);

    //create
    ProductResponseDto create(ProductRequestDto productRequest);

    //void update
    ProductResponseDto update(String id, ProductRequestDto productRequestDto);

    //void delete(String dto)
    ResponseEntity<Void> delete(String id);
    //getAll
    ProductsListResponseDto getAll();
    ProductsListResponseDto getAllByTag(String tag);
}
