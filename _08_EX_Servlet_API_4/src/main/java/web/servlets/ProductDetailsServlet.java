package web.servlets;

import domain.models.service.ProductServiceModel;
import service.ProductService;
import util.HtmlFileReader;
import util.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static paths.Paths.DETAILS_PRODUCT_VIEW_FILE_PATH;

@WebServlet("/products/details")
public class ProductDetailsServlet extends HttpServlet {

    private final HtmlFileReader htmlFieReader;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @Inject
    public ProductDetailsServlet(HtmlFileReader htmlFieReader, ProductService productService, ModelMapper modelMapper) {
        this.htmlFieReader = htmlFieReader;
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        ProductServiceModel productServiceModel = this.productService.findByName(name);

        String detailsProductView = this.htmlFieReader.readFile(DETAILS_PRODUCT_VIEW_FILE_PATH)
                .replace("{{name}}", productServiceModel.getName())
                .replace("{{description}}", productServiceModel.getDescription())
                .replace("{{type}}", productServiceModel.getType());

        resp.getWriter().println(detailsProductView);
    }
}
