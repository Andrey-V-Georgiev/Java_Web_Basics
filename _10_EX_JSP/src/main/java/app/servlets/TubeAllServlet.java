package app.servlets;

import app.models.view_models.TitleViewModel;
import app.services.TubeService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/tubes/all")
public class TubeAllServlet extends HttpServlet {

    private final ModelMapper modelMapper;
    private final TubeService tubeService;

    @Inject
    public TubeAllServlet(TubeService tubeService) {
        this.tubeService = tubeService;
        modelMapper = new ModelMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<TitleViewModel> allTitleViewModels = this.tubeService.findAll()
                .stream()
                .map(t -> this.modelMapper.map(t, TitleViewModel.class))
                .collect(Collectors.toList());
        req.setAttribute("allTitleViewModels", allTitleViewModels);
        req.getRequestDispatcher("/views/all-tubes.jsp").forward(req, resp);
    }
}
