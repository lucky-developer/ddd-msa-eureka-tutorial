package lucky.server.common.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductFromCommon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    public ProductFromCommon(){}

    public ProductFromCommon(int id){
        this.id = id;
        this.name = "TestProduct";
        this.description = "TestDescription";
    }

    public ProductFromCommon(ProductDto dto){
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
