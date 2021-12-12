package lucky.server.product.controller;

import lucky.server.common.entity.Product;
import lucky.server.common.entity.ProductDto;
import lucky.server.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// TODO
// 1. @Valid
// 1. list API
// 1. 로깅
// 2. ResponseEntity util (responseDto)
// 3. restTemplate
// 4. eureka

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(path = "/v1/product/create")
    ResponseEntity<Product> createUpdate(@RequestBody ProductDto dto){
        Product product = productService.createProduct(Product.fromDtoWithId(dto, false));
        return ResponseEntity.ok(product);
    }

    @Deprecated // 2021-12-12 휘발성 메모리 디비 사용하지 않는 정책 추가.
    @GetMapping(path = "/v1/product/get/{id}")
    ResponseEntity<Product> getProductByIdInMemory(@PathVariable("id") int id){
        return ResponseEntity.badRequest().body(null);
//        Product product = productService.getProductByIdInMemory(id);
//        if(product == null){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//        return ResponseEntity.ok(product);
    }

    @Deprecated // 2021-12-12 휘발성 메모리 디비 사용하지 않는 정책 추가.
    @GetMapping(path = "/v1/product/intern/{id}")
    ResponseEntity<Product> internProductByIdInMemory(@PathVariable("id") int id){
        return ResponseEntity.badRequest().body(null);
//        Product product = productService.internProductByIdInMemory(id);
//        return ResponseEntity.ok(product);
    }

    @PutMapping(path = "/v1/product/update")
    ResponseEntity<Boolean> updateProduct(@RequestBody ProductDto dto){
        boolean ret = productService.updateProduct(Product.fromDtoWithId(dto, true));
        if(ret){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.badRequest().body(false);
        }
    }

    @DeleteMapping(path = "/v1/product/delete/{id}")
    ResponseEntity<Boolean> deleteProductById(@PathVariable("id") int id){
        boolean ret = productService.deleteProduct(id);
        if(ret){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.badRequest().body(false);
        }
    }
}
