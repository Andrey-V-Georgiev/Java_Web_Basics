package domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class ProductEntity extends BaseEntity {

    private String name;
    private String description;
    private Type type;

    public ProductEntity() {
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="type")
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}