package app.servlets.filters;

import app.models.binding_models.TubeBindingModel;
import app.utils.ValidatorUtil;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/tubes/create")
public class TubeCreateFilter extends HttpFilter {

    private final ValidatorUtil validatorUtil;

    @Inject
    public TubeCreateFilter(ValidatorUtil validatorUtil) {
        this.validatorUtil = validatorUtil;
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        if ("post".equals(req.getMethod().toLowerCase())) {
            TubeBindingModel tubeBindingModel = new TubeBindingModel();

            tubeBindingModel.setName(req.getParameter("title"));
            tubeBindingModel.setDescription(req.getParameter("description"));
            tubeBindingModel.setYoutubeLink(req.getParameter("youtube_link"));
            tubeBindingModel.setUploader(req.getParameter("uploader"));

            if (this.validatorUtil.isValid(tubeBindingModel)) {
                req.setAttribute("tubeBindingModel", tubeBindingModel);
            }
        }
        chain.doFilter(req, res);
    }
}
