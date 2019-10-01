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

import static app.paths.paths.ALL_CATS_VIEW_FILE_PATH;

@WebServlet("/cats/all")
public class AllCatsServlet extends HttpServlet {

    private final HtmlFileReader htmlFileReader;

    @Inject
    public AllCatsServlet(HtmlFileReader htmlFileReader) {
        this.htmlFileReader = htmlFileReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String allCatsView = this.htmlFileReader.readHtmlFile(ALL_CATS_VIEW_FILE_PATH);
        Map allCats = (Map) req.getSession().getAttribute("Cats");
        String replacedAllCatsView = "";

        if(allCats == null) {
            String errorContent = String.format("<h2>Ther are no cats. <a href=\"%s\">Create some!</a></h2>", "/cats/create");
            replacedAllCatsView = allCatsView.replace("{{content}}", errorContent);
        } else {
            String content = "";
            for (Object value : allCats.values()) {
                Cat cat = (Cat) value;
                content += String.format("<strong><a href=\"/cats/profile?catName=%s\">%s</a></strong><br/>", cat.getName(), cat.getName());
            }
            replacedAllCatsView = allCatsView.replace("{{content}}", content);
        }

        resp.getWriter().println(replacedAllCatsView);
    }
}
