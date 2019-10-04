package repository;

import java.util.List;

public interface GenericRepository<E, K> {

    E save(E entity);

    E findByID(K id);

    E findByName(K name);

    List<E> findAll();
}
