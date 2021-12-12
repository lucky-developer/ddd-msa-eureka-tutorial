package lucky.server.product.service;

import lucky.server.common.entity.Product;
import lucky.server.common.repository.ProductMemoryRepository;
import lucky.server.common.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Deprecated
    @Autowired
    private ProductMemoryRepository productMemoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Deprecated
    public Product getProductByIdInMemory(int id){
        return productMemoryRepository.getProductById(id);
    }

    @Deprecated
    public Product internProductByIdInMemory(int id){
        return productMemoryRepository.internProductById(id);
    }

    public Product findProductById(int id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Deprecated
    public Product internProductById(int id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElseGet(() -> createProduct());
    }

    @Deprecated
    public Product createProduct(){
        return productRepository.saveAndFlush(new Product());
    }

    public Product createProduct(Product product){
        return productRepository.saveAndFlush(product);
    }

    public boolean updateProduct(Product product){
        Product old = findProductById(product.getId());
        if(old == null){
            return false;
        }
        old.setName(product.getName());
        old.setDescription(product.getDescription());
        productRepository.saveAndFlush(old);
        return true;
    }

    public boolean deleteProduct(int id){
        Product product = findProductById(id);
        if(product == null){
            return false;
        }
        productRepository.delete(product);
        return true;
    }
}
