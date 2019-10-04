package util;

import domain.models.view.AllProductsViewModel;
import service.ProductService;

import javax.inject.Inject;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ProductsHtml {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    @Inject
    public ProductsHtml(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    public String generate() {
        List<AllProductsViewModel> allProducts = this.productService
                .findAllProducts()
                .stream()
                .map(psm -> {
                    AllProductsViewModel allProductsViewModel = this.modelMapper.map(psm, AllProductsViewModel.class);
                    allProductsViewModel.setTitle(psm.getName());
                    return allProductsViewModel;
                })
                .collect(Collectors.toList());

        StringJoiner sj = new StringJoiner("");
        allProducts.forEach(p -> {
            sj.add(String.format("<li><a href=\"/products/details?name=%s\">%s</a></li>", p.getTitle(), p.getTitle()));
        });
        return sj.toString().trim();
    }
}
