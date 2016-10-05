package persistence.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by abalaev on 28.09.2016.
 */
@Entity
@Table(name = "Train", schema = "mydb")
//@NamedQuery(name = "Train.findTrainByTimetable",
//  query = "select t from Train t, Route r, Timetable tm where t.idTrain = r.train and r.idRoute = tm.routeId and tm.idLine =:idTmtbl")
public class Train {
    @Id
    @Column(name = "idTrain", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrain;

    @Column(name = "seats",  nullable = false)
    private int seats;

    @OneToMany(mappedBy = "train",fetch = FetchType.LAZY)
    private List<Route> routes;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public int getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(int idTrain) {
        this.idTrain = idTrain;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Train{" +
                "idTrain=" + idTrain +
                ", seats=" + seats +
                ", routes=" + routes +
                '}';
    }
}

