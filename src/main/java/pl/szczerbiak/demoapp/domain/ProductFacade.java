package pl.szczerbiak.demoapp.domain;

public interface ProductFacade {
    //get
    ProductResponseDto findById(String id);
    //ProductResponseDto getProduct(ProductRequestDto productRequest);

    //create
    ProductResponseDto create(ProductRequestDto productRequest);

    //void update

    //void delete(String dto)
}
