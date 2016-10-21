package persistence.entities;

import javax.persistence.*;
import java.util.*;

/**
 * Created by abalaev on 05.10.2016.
 */
@Entity
@Table(name = "Route_Timetables", schema = "mydb")
@NamedQueries(
        {
                @NamedQuery(name = "RouteTimetables.getAll",
                        query = "SELECT r FROM RouteTimetables r"),
                @NamedQuery(name = "RouteTimetables.getStationTimetableArr",
                        query = "SELECT rt FROM RouteTimetables rt INNER JOIN rt.line l " +
                                " WHERE l.stationArrival =:station " +
                                " AND rt.dateArrival between :date1 AND:date2"),
                @NamedQuery(name = "RouteTimetables.getStationTimetableDep",
                        query = "SELECT rt FROM RouteTimetables rt INNER JOIN rt.line l " +
                                " WHERE l.stationDeparture =:station " +
                                " AND rt.dateDeparture between :date1 AND:date2"),
                @NamedQuery(name = "RouteTimetables.getRoutes",
                        query = "SELECT r FROM RouteTimetables r order by numberInRoute"),
                @NamedQuery(name = "RouteTimetables.getRouteTimetableByRouteAndNumberInRoute",
                query = "SELECT r FROM RouteTimetables r WHERE routeId =:route AND numberInRoute = :number "
                      +  "AND dateDeparture > :dateBegin "
                     +   "AND dateArrival < :dateEnd AND freeSeats > 0 order by dateDeparture")
        }
)
public class RouteTimetables extends Throwable {

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

    @Column(name = "date_arrival", nullable = false, columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateArrival;

    @Column(name = "free_seats", nullable = false)
    private int freeSeats;

    @ManyToMany(mappedBy = "routeTimetables")
//    @ManyToMany
//    @JoinTable(name = "booked_timetables", joinColumns = {
//            @JoinColumn(name = "event_id", nullable = false) },
//            inverseJoinColumns = { @JoinColumn(name = "ticket_id",
//                    nullable = false) })
    private Set<Ticket> tickets = new HashSet<>();


    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "RouteTimetables{" +
                "idEvent=" + idEvent +
                ", line=" + line +
                ", routeId=" + routeId +
                ", numberInRoute=" + numberInRoute +
                ", dateDeparture=" + dateDeparture +
                ", dateArrival=" + dateArrival +
                ", freeSeats=" + freeSeats +
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
