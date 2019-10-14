package app.bean_config;

import org.modelmapper.ModelMapper;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.Serializable;

@RequestScoped
public class AppBeanConfig  implements Serializable {

    @Produces
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Produces
    public EntityManager entityManager() {
        return Persistence
                .createEntityManagerFactory("employees")
                .createEntityManager();
    }
}
