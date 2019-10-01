package app.web.servlets;

import app.domain.entities.Cat;
import app.util.HtmlFileReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static app.paths.paths.CAT_PROFILE_VIEW_FILE_PATH;
import static app.paths.paths.ERROR_VIEW;

@WebServlet("/cats/profile")
public class CatsProfileServlet extends HttpServlet {

    private final HtmlFileReader htmlFileReader;

    @Inject
    public CatsProfileServlet(HtmlFileReader htmlFileReader) {
        this.htmlFileReader = htmlFileReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String catProfileView = this.htmlFileReader.readHtmlFile(CAT_PROFILE_VIEW_FILE_PATH);
        String ErrorView = this.htmlFileReader.readHtmlFile(ERROR_VIEW);

        Cat theCat = null;
        String queryName = req.getQueryString().split("=")[1];
        try{
            Map cats = (Map) req.getSession().getAttribute("Cats");
            theCat = (Cat)cats.get(queryName);
            boolean catExists = cats.get(queryName) != null;

            resp.getWriter().println(catProfileView
                    .replace("{{name}}", theCat.getName())
                    .replace("{{breed}}", theCat.getBreed())
                    .replace("{{color}}", theCat.getColor())
                    .replace("{{age}}", theCat.getAge().toString()));
        } catch (Exception e) {
            String replacedErrorView = ErrorView .replace("{{name}}", queryName);
            resp.getWriter().println(replacedErrorView);
        }
    }
}
