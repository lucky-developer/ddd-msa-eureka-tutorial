package lucky.server.product.service;

import lucky.server.common.entity.Product;
import lucky.server.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(int id){
        return productRepository.getProductById(id);
    }

    public Product internProductById(int id){
        return productRepository.internProductById(id);
    }
}
