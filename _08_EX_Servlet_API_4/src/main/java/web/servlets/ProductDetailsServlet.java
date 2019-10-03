package web.servlets;

import util.HtmlFileReader;

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

    @Inject
    public ProductDetailsServlet(HtmlFileReader htmlFieReader) {
        this.htmlFieReader = htmlFieReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String detailsProductView = this.htmlFieReader.readFile(DETAILS_PRODUCT_VIEW_FILE_PATH);
        resp.getWriter().println(detailsProductView);
    }
}
