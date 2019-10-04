package repository;

import domain.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private final EntityManager entityManager;

    public ProductRepositoryImpl() {
        this.entityManager = Persistence
                .createEntityManagerFactory("chushka_db")
                .createEntityManager();
    }

    @Override
    public Product save(Product product) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(product);
        this.entityManager.getTransaction().commit();
        return product;
    }

    @Override
    public Product findByID(String id) {
        this.entityManager.getTransaction().begin();
        Product product = this.entityManager
                .createQuery("SELECT p FROM Product p WHERE p.id=:id",
                        Product.class)
                .setParameter("id", id)
                .getSingleResult();

        this.entityManager.getTransaction().commit();
        return product;
    }

    @Override
    public Product findByName(String name) {
        this.entityManager.getTransaction().begin();
        Product product = this.entityManager
                .createQuery("SELECT p FROM Product p WHERE p.name=:name",
                        Product.class)
                .setParameter("name", name)
                .getSingleResult();

        this.entityManager.getTransaction().commit();
        return product;
    }


    @Override
    public List<Product> findAll() {
        this.entityManager.getTransaction().begin();
        List<Product> allProducts = this.entityManager
                .createQuery("SELECT p FROM Product p",
                        Product.class)
                .getResultList();
        this.entityManager.getTransaction().commit();
        return allProducts;
    }
}
