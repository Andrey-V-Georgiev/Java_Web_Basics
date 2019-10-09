package app.servlets.filters;

import app.models.binding_models.TubeBindingModel;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/tubes/create")
public class TubeCreateFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if("post".equals(req.getMethod().toLowerCase())){
            try {
                TubeBindingModel tubeBindingModel = new TubeBindingModel();
                tubeBindingModel.setName(req.getParameter("title"));
                tubeBindingModel.setDescription(req.getParameter("description"));
                tubeBindingModel.setYoutubeLink(req.getParameter("youtube_link"));
                tubeBindingModel.setUploader(req.getParameter("uploader"));
                req.setAttribute("tubeBindingModel", tubeBindingModel);

            } catch (Error e) {
                res.sendRedirect("/tubes/create");
            }
        }
        chain.doFilter(req, res);
    }
}
