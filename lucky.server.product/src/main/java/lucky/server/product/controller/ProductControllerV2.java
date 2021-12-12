package lucky.server.product.controller;

import lucky.server.common.entity.Product;
import lucky.server.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControllerV2 {
    @Autowired
    private ProductService productService;

    @GetMapping(path = "/v2/product/get/{id}")
    ResponseEntity<Product> getProductById(@PathVariable("id") int id){
        Product product = productService.findProductById(id);
        if(product == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(product);
    }

    @Deprecated // 2021-12-12 임의로 product를 생성하지 않는 정책 추가. 조회한 product가 없는 경우 400에러 리턴
    @GetMapping(path = "/v2/product/intern/{id}")
    ResponseEntity<Product> internProduct(@PathVariable("id") int id){
        return ResponseEntity.badRequest().body(null);
    }
}
