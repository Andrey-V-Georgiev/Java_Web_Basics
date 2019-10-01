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
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import static app.paths.paths.CAT_CREATE_FORM_FILE_PATH;

@WebServlet("/cats/create")
public class CatCreateServlet extends HttpServlet {

    private final HtmlFileReader htmlFileReader;

    @Inject
    public CatCreateServlet(HtmlFileReader htmlFileReader) {
        this.htmlFileReader = htmlFileReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String catCreateFormView = this.htmlFileReader.readHtmlFile(CAT_CREATE_FORM_FILE_PATH);
        resp.getWriter().println(catCreateFormView);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        String color = req.getParameter("color");
        Integer age= Integer.parseInt(req.getParameter("age"));
        String path = req.getRequestURL().toString();

        Cat newCat = new Cat(name, breed, color, age);

        if(req.getSession().getAttribute("Cats") == null) {
            req.getSession().setAttribute("Cats", new LinkedHashMap<>());
            ((Map)req.getSession().getAttribute("Cats")).put(newCat.getName(), newCat);
        } else {
            ((Map)req.getSession().getAttribute("Cats")).put(newCat.getName(), newCat);
        }

        resp.sendRedirect( "/cats/profile?catName=" + name);
    }
}
