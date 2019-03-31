package pl.szczerbiak.demoapp.api;

import org.springframework.web.bind.annotation.*;
import pl.szczerbiak.demoapp.domain.ProductFacade;
import pl.szczerbiak.demoapp.domain.ProductRequestDto;
import pl.szczerbiak.demoapp.domain.ProductResponseDto;

@RestController
@RequestMapping("/products")
class ProductEndpoint {

    private final ProductFacade productFacade;

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

}
//@JSONCreator