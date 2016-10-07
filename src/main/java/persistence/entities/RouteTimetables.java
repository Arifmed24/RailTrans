package persistence.entities;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by abalaev on 05.10.2016.
 */
@Entity
@Table(name = "Route_Timetables", schema = "mydb")
@NamedQuery(name = "RouteTimetables.getAll",
                        query = "SELECT r FROM RouteTimetables r")
public class RouteTimetables {

    @Id
    @Column(name = "id_event", nullable = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idEvent;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "line", nullable = false)
    private Timetable line;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    private Route routeId;

    @Column(name = "number_in_route", nullable = false)
    private int numberInRoute;

    @Column(name = "date_departure", columnDefinition="DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeparture;

    @Column(name = "date_arrival", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateArrival;

    @Column(name = "free_seats", nullable = false)
    private int freeSeats;

    @Override
    public String toString() {
        return "RouteTimetables{" +
                "idEvent=" + idEvent +
                ", line=" + line +
                ", routeId=" + routeId +
                ", numberInRoute=" + numberInRoute +
                ", dateDeparture=" + dateDeparture +
                ", dateArrival=" + dateArrival +
                '}';
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public Timetable getLine() {
        return line;
    }

    public void setLine(Timetable line) {
        this.line = line;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public int getNumberInRoute() {
        return numberInRoute;
    }

    public void setNumberInRoute(int numberInRoute) {
        this.numberInRoute = numberInRoute;
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
}
