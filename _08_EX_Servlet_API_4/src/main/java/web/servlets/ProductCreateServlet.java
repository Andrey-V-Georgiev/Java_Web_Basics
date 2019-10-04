package web.servlets;

import domain.models.service.ProductServiceModel;
import repository.ProductRepository;
import service.ProductService;
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
    private final ProductService productService;

    @Inject
    public ProductCreateServlet(HtmlFileReader htmlFieReader, ProductRepository productRepository, ProductService productService) {
        this.htmlFieReader = htmlFieReader;
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String createProductView = this.htmlFieReader.readFile(CREATE_PRODUCT_VIEW_FILE_PATH);
        resp.getWriter().println(createProductView);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String type = req.getParameter("type");

        ProductServiceModel productServiceModel = new ProductServiceModel();
        productServiceModel.setName(name);
        productServiceModel.setDescription(description);
        productServiceModel.setType(type);

        this.productService.saveProduct(productServiceModel);

        resp.sendRedirect(String.format("/products/details?name=%s", req.getParameter("name")));
    }
}
