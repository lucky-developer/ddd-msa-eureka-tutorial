package lucky.server.product.controller;

import lucky.server.common.entity.Product;
import lucky.server.common.entity.ProductDto;
import lucky.server.common.util.RestResponse;
import lucky.server.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// TODO
// 1. @Valid
// 1. list API
// 1. 로깅
// 2. ResponseEntity util (responseDto)
// 3. restTemplate
// 4. eureka
// 1. swagger

@RestController
public class ProductControllerV3 {
    Logger logger = LoggerFactory.getLogger(ProductControllerV3.class);
    @Autowired
    private ProductService productService;

    @PostMapping(path = "/v3/product/create")
    RestResponse createUpdate(@RequestBody ProductDto dto){
        Product product = productService.createProduct(Product.fromDtoWithId(dto, false));
        return RestResponse.success(product);
    }

    @GetMapping(path = "/v3/product/get/{id}")
    RestResponse getProductById(@PathVariable("id") int id){
        Product product = productService.findProductById(id);
        if(product == null){
            logger.info("/v3/product/get/{id} product is null");
            return RestResponse.badRequest("product with id " + id + " does not exist");
        }
        return RestResponse.success(product);
    }

    @PutMapping(path = "/v3/product/update")
    RestResponse updateProduct(@RequestBody ProductDto dto){
        boolean ret = productService.updateProduct(Product.fromDtoWithId(dto, true));
        if(ret){
            return RestResponse.success(true);
        }else{
            return RestResponse.badRequest("product with id "+dto.getId()+" does not exist");
        }
    }

    @DeleteMapping(path = "/v3/product/delete/{id}")
    RestResponse deleteProductById(@PathVariable("id") int id){
        boolean ret = productService.deleteProduct(id);
        if(ret){
            return RestResponse.success();
        }else{
            return RestResponse.badRequest("product with id " + id + " does not exist");
        }
    }
}
