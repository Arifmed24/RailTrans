package servlets.timetable;

import services.api.TimetableService;
import services.impl.FactoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by abalaev on 24.10.2016.
 */
@WebServlet(name = "TimetableCreate" , urlPatterns = "/timetableCreate")
public class TimetableCreate extends HttpServlet {

    TimetableService timetableService = FactoryService.getTimetableService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: 24.10.2016 create timetable

    }
}
