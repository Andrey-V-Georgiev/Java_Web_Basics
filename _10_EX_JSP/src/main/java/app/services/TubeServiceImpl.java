package app.services;

import app.models.entities.Tube;
import app.models.service_models.TubeServiceModel;
import app.repository.TubeRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class TubeServiceImpl implements TubeService {

    private final ModelMapper modelMapper;
    private final TubeRepository tubeRepository;

    @Inject
    public TubeServiceImpl(TubeRepository tubeRepository) {
        this.modelMapper = new ModelMapper();
        this.tubeRepository = tubeRepository;
    }

    @Override
    public void save(TubeServiceModel tubeServiceModel) {
        this.tubeRepository.save(this.modelMapper.map(tubeServiceModel, Tube.class));
    }

    @Override
    public TubeServiceModel findByName(String name) {
        return this.modelMapper.map(this.tubeRepository.findByName(name), TubeServiceModel.class);
    }

    @Override
    public List<TubeServiceModel> findAll() {
        return this.tubeRepository.findAll().stream()
                .map(t-> this.modelMapper.map(t, TubeServiceModel.class))
                .collect(Collectors.toList());
    }
}
