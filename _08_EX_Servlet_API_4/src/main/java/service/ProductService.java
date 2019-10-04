package service;

import domain.models.service.ProductServiceModel;

import java.util.List;

public interface ProductService {

    void saveProduct(ProductServiceModel productServiceModel);

    ProductServiceModel findByName(String name);

    List<ProductServiceModel> findAllProducts();
}
