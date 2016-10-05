package persistence.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by abalaev on 28.09.2016.
 */
@Entity
@Table(name = "Timetable", schema = "mydb")
//@NamedQueries(
//        {
//                @NamedQuery(name = "Timetable.getStationTimetableDep",
//                        query = "SELECT t FROM Timetable t WHERE t.stationDeparture = :station AND t.dateDeparture BETWEEN :datetime AND :datetime2"),
//                @NamedQuery(name = "Timetable.getStationTimetableArr",
//                        query = "SELECT t FROM Timetable t WHERE t.stationArrival = :station AND t.dateArrival BETWEEN :datetime AND :datetime2")
//        }
//)
public class Timetable {
    @Id
    @Column(name = "idLine", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idLine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_departure", nullable = false)
    private Station stationDeparture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_arrival", nullable = false)
    private Station stationArrival;

    @Column(name = "distance", nullable = false)
    private double distance;

    @OneToMany(mappedBy = "line",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RouteTimetables> routeTimetables;

    public List<RouteTimetables> getRouteTimetables() {
        return routeTimetables;
    }

    public void setRouteTimetables(List<RouteTimetables> routeTimetables) {
        this.routeTimetables = routeTimetables;
    }

    public int getIdLine() {
        return idLine;
    }

    public void setIdLine(int idLine) {
        this.idLine = idLine;
    }

    public Station getStationDeparture() {
        return stationDeparture;
    }

    public void setStationDeparture(Station stationDeparture) {
        this.stationDeparture = stationDeparture;
    }

    public Station getStationArrival() {
        return stationArrival;
    }

    public void setStationArrival(Station stationArrival) {
        this.stationArrival = stationArrival;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "idLine=" + idLine +
                ", stationDeparture=" + stationDeparture +
                ", stationArrival=" + stationArrival +
                ", distance=" + distance +
                '}';
    }
}
