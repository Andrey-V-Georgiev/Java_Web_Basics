package service;

import domain.entities.Product;
import domain.entities.Type;
import domain.models.service.ProductServiceModel;
import repository.ProductRepository;
import util.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Inject
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveProduct(ProductServiceModel productServiceModel) {
        Product product = this.modelMapper.map(productServiceModel, Product.class);
        product.setType(Type.valueOf(productServiceModel.getType()));

        this.productRepository.save(product);
    }

    @Override
    public ProductServiceModel findByName(String name) {
        Product product = this.productRepository.findByName(name);
        ProductServiceModel psm = this.modelMapper.map(product, ProductServiceModel.class);

        return psm;
    }

    @Override
    public List<ProductServiceModel> findAllProducts() {
        List<Product> products = this.productRepository.findAll();
        return products.stream()
                .map(product -> {
                    ProductServiceModel psModel = this.modelMapper.map(product, ProductServiceModel.class);
                    psModel.setType(product.getType().toString());
                    return psModel;
                })
                .collect(Collectors.toList());
    }
}
