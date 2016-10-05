package persistence.entities;

import javax.persistence.*;

/**
 * Created by abalaev on 28.09.2016.
 */
@Entity
@Table(name = "Train", schema = "mydb")
@NamedQuery(name = "Train.findTrainByTimetable",
//        query = "SELECT t FROM Train t " +
//                "INNER JOIN t.idTrain r ON t.idTrain = r.train" +
//                "INNER JOIN Timetable tm ON tm.route_Id = r.idRoute WHERE idLine =:idTmtbl")
        query = "select t from Train t, Route r, Timetable tm where t.idTrain = r.train and r.idRoute = tm.routeId and tm.idLine =:idTmtbl")
public class Train {
    @Id
    @Column(name = "idTrain")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrain;

    @Column(name = "seats")
    private int seats;

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
                '}';
    }
}
