package servlets.route;

import persistence.entities.Route;
import persistence.entities.Station;
import persistence.entities.Train;
import services.api.RouteService;
import services.api.StationService;
import services.api.TrainService;
import services.impl.FactoryService;
import servlets.ValidationUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewRoute", urlPatterns = "/newroute")
public class NewRoute extends HttpServlet {

    StationService stationService = FactoryService.getStationService();
    TrainService trainService = FactoryService.getTrainService();
    RouteService routeService = FactoryService.getRouteService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rounteName = request.getParameter("routeName");
        String idTrain = request.getParameter("train");
        String startStationId = request.getParameter("startStation");
        String finishStationId = request.getParameter("finishStation");

        if (startStationId.equals(finishStationId))
        {
            request.setAttribute("error", "Start station and finish station must be different");
            request.setAttribute("title", "New route");
            request.getRequestDispatcher("pages/admin/routes/newRoute.jsp").forward(request,response);
        } else {
            if (ValidationUtils.checkRouteName(rounteName)){

                Integer intTrainId = Integer.parseInt(idTrain);
                Integer intStartStationId = Integer.parseInt(startStationId);
                Integer intFinishStationId = Integer.parseInt(finishStationId);

                Train train = trainService.read(intTrainId);
                Station startStation = stationService.read(intStartStationId);
                Station finishStation = stationService.read(intFinishStationId);

                Route route = new Route();
                route.setRouteName(rounteName);
                route.setTrain(train);
                route.setStartStation(startStation);
                route.setFinishStation(finishStation);
                route = routeService.createRoute(route);

                request.getSession().setAttribute("route",route);

                request.getSession().removeAttribute("stations");
                request.getSession().removeAttribute("trains");

                response.sendRedirect("/numberOfElements");
            }
            else {
                request.setAttribute("error", "Incorrect route name");
                request.setAttribute("title", "New route");
                request.getRequestDispatcher("pages/admin/routes/newRoute.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Station> stations = stationService.getAllStations();
        List<Train> trains = trainService.getAllTrains();
        request.getSession().setAttribute("stations", stations);
        request.getSession().setAttribute("trains",trains);
        request.setAttribute("title", "New route");
        request.getRequestDispatcher("pages/admin/routes/newRoute.jsp").forward(request,response);
    }
}
