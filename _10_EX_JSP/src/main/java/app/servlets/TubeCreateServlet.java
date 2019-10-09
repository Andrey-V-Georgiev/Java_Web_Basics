package app.servlets;


import app.models.binding_models.TubeBindingModel;
import app.models.service_models.TubeServiceModel;
import app.services.TubeService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tubes/create")
public class TubeCreateServlet extends HttpServlet {

    private final ModelMapper modelMapper;
    private final TubeService tubeService;

    @Inject
    public TubeCreateServlet(TubeService tubeService) {
        this.modelMapper = new ModelMapper();
        this.tubeService = tubeService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager entityManager = Persistence.createEntityManagerFactory("tubes").createEntityManager();
        req.getRequestDispatcher("/views/create-tube.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TubeServiceModel tubeServiceModel = this.modelMapper.map(req.getAttribute("tubeBindingModel"), TubeServiceModel.class);
        this.tubeService.save(tubeServiceModel);
        resp.sendRedirect(String.format("/tubes/details?name=%s", tubeServiceModel.getName()));
    }
}
