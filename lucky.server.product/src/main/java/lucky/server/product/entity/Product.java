package lucky.server.product.entity;

import lucky.server.common.entity.ProductDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    public Product(){}

    public Product(int id){
        this.id = id;
        this.name = "TestProduct";
        this.description = "TestDescription";
    }

    public Product(ProductDto dto){
        this.id = dto.getId();
        this.name = dto.getName();
        this.description = dto.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
