package app.web.servlets;

import app.util.HtmlFileReader;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static app.paths.paths.HOME_VIEW_FILE_PATH;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    private final HtmlFileReader htmlFileReader;

    @Inject
    public HomeServlet(HtmlFileReader htmlFileReader) {
        this.htmlFileReader = htmlFileReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String homeView = htmlFileReader.readHtmlFile(HOME_VIEW_FILE_PATH);
        printWriter.println(homeView);
    }
}
