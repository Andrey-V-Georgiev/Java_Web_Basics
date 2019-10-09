package app.repository;

import java.util.List;

public interface GenericRepository<Entity, Key> {

    void save(Entity entity);

    Entity findByName(Key name);

    List<Entity> findAll();
}
