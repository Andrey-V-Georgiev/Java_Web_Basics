package app.models.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {

    private UUID id;

    protected BaseEntity() {
    }

    @Id
    @GeneratedValue(generator ="uuid-string")
    @GenericGenerator(name="uuid-string", strategy="org.hibernate.id.UUIDGenerator")
    @Column(name="id", nullable = false, updatable = false)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
