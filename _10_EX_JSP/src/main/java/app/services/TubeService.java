package app.services;

import app.models.service_models.TubeServiceModel;

import java.util.List;

public interface TubeService {
    void save(TubeServiceModel tubeServiceModel);

    TubeServiceModel findByName(String name);

    List<TubeServiceModel> findAll();
}
