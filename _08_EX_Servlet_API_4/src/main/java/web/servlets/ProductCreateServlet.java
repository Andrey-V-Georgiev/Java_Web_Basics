package web.servlets;

import domain.entities.ProductEntity;
import domain.entities.Type;
import repository.ProductRepository;
import util.HtmlFileReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static paths.Paths.CREATE_PRODUCT_VIEW_FILE_PATH;

@WebServlet("/products/create")
public class ProductCreateServlet extends HttpServlet {

    private final HtmlFileReader htmlFieReader;
    private final ProductRepository productRepository;

    @Inject
    public ProductCreateServlet(HtmlFileReader htmlFieReader, ProductRepository productRepository) {
        this.htmlFieReader = htmlFieReader;
        this.productRepository = productRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String createProductView = this.htmlFieReader.readFile(CREATE_PRODUCT_VIEW_FILE_PATH);
        resp.getWriter().println(createProductView);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName("Pesho");
        productEntity.setDescription("Megazoba");
        productEntity.setType(Type.Cosmetic);
        this.productRepository.save(productEntity);
        resp.sendRedirect("/");
    }
}
