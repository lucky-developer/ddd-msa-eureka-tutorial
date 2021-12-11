package lucky.server.product.service;

import lucky.server.product.entity.Product;
import lucky.server.product.repository.ProductMemoryRepository;
import lucky.server.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductMemoryRepository productMemoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public Product getProductByIdInMemory(int id){
        return productMemoryRepository.getProductById(id);
    }

    public Product internProductByIdInMemory(int id){
        return productMemoryRepository.internProductById(id);
    }

    public Product getProductById(int id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public Product internProductById(int id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElseGet(() -> createProduct(id));
    }

    private Product createProduct(int id){
        Product product = new Product(id);
        return productRepository.saveAndFlush(product);
    }
}
