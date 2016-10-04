package persistence.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by abalaev on 28.09.2016.
 */
@Entity
@Table(name = "Timetable", schema = "mydb")
@NamedQuery(name = "Timetable.getStationTimetable",
                        query = "SELECT t FROM Timetable t WHERE t.stationDeparture = :station AND t.dateDeparture BETWEEN :datetime AND :datetime2")
public class Timetable {
    @Id
    @Column(name = "idLine")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idLine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_departure", nullable = false)
    private Station stationDeparture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_arrival", nullable = false)
    private Station stationArrival;

    @Column(name = "date_departure", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeparture;

    @Column(name = "date_arrival", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateArrival;

    @Column(name = "distance")
    private double distance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id", nullable = false)
    private int routeId;

    @Column(name = "number_in_route")
    private int numberInRoute;

   public Timetable(){}

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

    public Date getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(Date dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public Date getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(Date dateArrival) {
        this.dateArrival = dateArrival;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getNumberInRoute() {
        return numberInRoute;
    }

    public void setNumberInRoute(int numberInRoute) {
        this.numberInRoute = numberInRoute;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "idLine=" + idLine +
                ", stationDeparture=" + stationDeparture +
                ", stationArrival=" + stationArrival +
                ", dateDeparture=" + dateDeparture +
                ", dateArrival=" + dateArrival +
                ", distance=" + distance +
                '}';
    }
}
