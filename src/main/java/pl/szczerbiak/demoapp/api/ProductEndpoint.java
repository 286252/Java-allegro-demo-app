package pl.szczerbiak.demoapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    ProductEndpoint(ProductFacade productFacade){
        this.productFacade = productFacade;
    }

    @PostMapping
    ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto){
        return productFacade.create(productRequestDto);
    }

    @CrossOrigin
    @GetMapping("/product-id-{id}")
    ProductResponseDto getProduct(@PathVariable("id") String id){
        return productFacade.findById(id);
    }

    @CrossOrigin
    @GetMapping
    ResponseEntity<ProductsListResponseDto> getAllProducts(@RequestParam(value="tag", required=false) String tag){
        if(tag != null && !tag.isBlank()){
            return ResponseEntity.status(HttpStatus.OK).body(productFacade.getAllByTag(tag));
        }
        return ResponseEntity.status(HttpStatus.OK).body(productFacade.getAll());
    }

    @PutMapping("/{id}")
    ProductResponseDto updateProduct(@PathVariable("id") String id, @RequestBody ProductRequestDto productRequestDto){
        return productFacade.update(id, productRequestDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable("id") String id){
        return productFacade.delete(id);
    }
}
//@JSONCreator