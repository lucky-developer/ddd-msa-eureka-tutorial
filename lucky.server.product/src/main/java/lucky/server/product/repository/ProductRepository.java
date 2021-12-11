package lucky.server.product.repository;

import lucky.server.common.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductRepository {

    private Map<Integer, Product> database = new HashMap<>();

    public Product getProductById(int id){
        return database.get(id);
    }

    public Product internProductById(int id){
        Product product = getProductById(id);
        if(product == null){
            product = new Product(id);
            database.put(id, product);
        }
        return product;
    }
}
