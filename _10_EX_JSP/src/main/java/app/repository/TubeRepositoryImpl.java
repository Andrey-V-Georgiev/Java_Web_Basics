package app.repository;

import app.models.entities.Tube;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class TubeRepositoryImpl implements TubeRepository {

    private final EntityManager entityManager;

    public TubeRepositoryImpl() {
        this.entityManager = Persistence
                .createEntityManagerFactory("tubes")
                .createEntityManager();
    }

    @Override
    public void save(Tube tube) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(tube);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Tube findByName(String name) {
        this.entityManager.getTransaction().begin();
        Tube tube = this.entityManager
                .createQuery("SELECT t FROM Tube t WHERE t.name=:name", Tube.class)
                .setParameter("name", name)
                .getResultList()
                .get(0);
        this.entityManager.getTransaction().commit();
        return tube;
    }

    @Override
    public List<Tube> findAll() {
        this.entityManager.getTransaction().begin();
        List<Tube> tubes = this.entityManager
                .createQuery("SELECT t FROM Tube t", Tube.class)
                .getResultList();
        this.entityManager.getTransaction().commit();
        return tubes;
    }
}
