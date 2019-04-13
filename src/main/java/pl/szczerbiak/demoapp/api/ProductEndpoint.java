package pl.szczerbiak.demoapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.szczerbiak.demoapp.domain.ProductFacade;
import pl.szczerbiak.demoapp.domain.ProductRequestDto;
import pl.szczerbiak.demoapp.domain.ProductResponseDto;
import pl.szczerbiak.demoapp.domain.ProductsListResponseDto;

@RestController
@RequestMapping("/products")
class ProductEndpoint {

    private final ProductFacade productFacade;

    @Autowired
    ProductEndpoint(ProductFacade productFacade){
        this.productFacade = productFacade;
    }

    @PostMapping
    ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto){
        return productFacade.create(productRequestDto);
    }

    @GetMapping("/{id}")
    ProductResponseDto getProduct(@PathVariable("id") String id){
        return productFacade.findById(id);
    }

    @PutMapping("/{id}")
    ProductResponseDto updateProduct(@PathVariable("id") String id, @RequestBody ProductRequestDto productRequestDto){
        return productFacade.update(id, productRequestDto);
    }

    @GetMapping
    ProductsListResponseDto getAllProducts(){
        return productFacade.getAll();
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteProduct(@PathVariable String id){
        return productFacade.delete(id);
    }
}
//@JSONCreator