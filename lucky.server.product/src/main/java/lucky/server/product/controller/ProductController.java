package lucky.server.product.controller;

import lucky.server.common.entity.Product;
import lucky.server.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(path = "/v1/product/get/{id}")
    ResponseEntity<Product> getProductByIdInMemory(@PathVariable("id") int id){
        Product product = productService.getProductByIdInMemory(id);
        if(product == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping(path = "/v1/product/intern/{id}")
    ResponseEntity<Product> internProductByIdInMemory(@PathVariable("id") int id){
        Product product = productService.internProductByIdInMemory(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping(path = "/v2/product/get/{id}")
    ResponseEntity<Product> getProductById(@PathVariable("id") int id){
        Product product = productService.getProductById(id);
        if(product == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping(path = "/v2/product/intern/{id}")
    ResponseEntity<Product> internProduct(@PathVariable("id") int id){
        Product product = productService.internProductById(id);
        return ResponseEntity.ok(product);
    }
}
