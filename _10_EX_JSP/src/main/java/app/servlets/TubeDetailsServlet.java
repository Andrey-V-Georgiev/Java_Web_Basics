package app.servlets;

import app.models.view_models.TubeViewModel;
import app.services.TubeService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/tubes/details")
public class TubeDetailsServlet extends HttpServlet {

    private final ModelMapper modelMapper;
    private final TubeService tubeService;

    @Inject
    public TubeDetailsServlet(TubeService tubeService) {
        this.tubeService = tubeService;
        modelMapper = new ModelMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = URLDecoder.decode(req.getQueryString().split("=")[1], StandardCharsets.UTF_8);
        TubeViewModel tubeViewModel = this.modelMapper.map(tubeService.findByName(name), TubeViewModel.class);
        req.setAttribute("tubeViewModel", tubeViewModel);

        req.getRequestDispatcher("/views/details-tube.jsp").forward(req, resp);
    }
}
