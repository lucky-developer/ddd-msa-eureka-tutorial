package lucky.server.common.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private long createdAtLong;
    @LastModifiedDate
    private long updatedAtLong;

    public Product(){}

    public Product(int id){
        this.id = id;
        this.name = "TestProduct";
        this.description = "TestDescription";
    }

    public static Product fromDtoWithId(ProductDto dto, boolean withId){
        Product product = new Product();
        if(withId){
            product.id = dto.getId();
        }
        product.name = dto.getName();
        product.description = dto.getDescription();
        return product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdAtLong=" + createdAtLong +
                ", updatedAtLong=" + updatedAtLong +
                '}';
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getCreatedAtLong() {
        return createdAtLong;
    }

    public void setCreatedAtLong(long createdAtLong) {
        this.createdAtLong = createdAtLong;
    }

    public long getUpdatedAtLong() {
        return updatedAtLong;
    }

    public void setUpdatedAtLong(long updatedAtLong) {
        this.updatedAtLong = updatedAtLong;
    }
}
