package servlets.train;

import persistence.dao.api.TrainDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.Train;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by abalaev on 07.10.2016.
 */
@WebServlet(name = "AllTrains",urlPatterns = "/trains")
public class AllTrains extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            TrainDao trainDao = FactoryDao.getTrainDao();
            List<Train> trains = trainDao.getAllTrains();
        if (trains.size() == 0) {
            request.setAttribute("infoMessage", "No trains");
        }
            request.setAttribute("trains", trains);
            request.setAttribute("title","Trains");
            request.getRequestDispatcher("pages/train/allTrains.jsp").forward(request, response);
    }
}
