package servlets.train;

import persistence.entities.Train;
import services.api.TrainService;
import services.impl.FactoryService;
import servlets.ValidationUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by abalaev on 07.10.2016.
 */
@WebServlet(name = "TrainCreate",urlPatterns = "/newtrain")
public class TrainCreate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String seatsStr = request.getParameter("seats");
        if (ValidationUtils.checkNumber(seatsStr) && seatsStr.length()<10) {
            int seats = Integer.parseInt(seatsStr);
            TrainService trainService = FactoryService.getTrainService();
            if(ValidationUtils.checkNumberSeats(seats)) {
                Train train = new Train();
                train.setSeats(seats);
                trainService.createTrain(train);
                request.getRequestDispatcher("/trains").forward(request, response);
            }
            else {
                request.setAttribute("error", "Number is too big. From 1 to 15 seats");
                request.getRequestDispatcher("pages/admin/train/createTrain.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Incorrect text");
            request.getRequestDispatcher("pages/admin/train/createTrain.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title","Create train");
        request.getRequestDispatcher("pages/admin/train/createTrain.jsp").forward(request, response);
    }
}
