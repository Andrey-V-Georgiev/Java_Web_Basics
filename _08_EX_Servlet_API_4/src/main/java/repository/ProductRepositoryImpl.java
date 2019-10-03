package repository;

import domain.entities.ProductEntity;
import domain.entities.Type;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private final EntityManager em;

    public ProductRepositoryImpl() {
        this.em = Persistence
                .createEntityManagerFactory("chushka_db")
                .createEntityManager();
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        this.em.getTransaction().begin();
        this.em.persist(productEntity);
        this.em.getTransaction().commit();
        return productEntity;
    }

    @Override
    public ProductEntity findByID(String id) {
        return null;
    }

    @Override
    public List<ProductEntity> findAll() {
        return null;
    }
}
