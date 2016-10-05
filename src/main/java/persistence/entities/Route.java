package persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by abalaev on 28.09.2016.
 */
@Entity
@Table(name = "Route", schema = "mydb")
public class Route {
    @Id
    @Column(name = "idRoute")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRoute;

    @Column(name = "route_name", nullable = false)
    private String routeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "start_station", nullable = false)
    private Station startStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "finish_station", nullable = false)
    private Station finishStation;

    @ManyToOne
    @JoinColumn(name = "train", nullable = false)
    private Train train;

    @Column(name = "start_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "free_seats",nullable = false)
    private int freeSeats;

    @OneToMany
    @JoinColumn(name = "route_id")
    private Set<Timetable> timetables = new HashSet<>(0);

    /*
    private Date finishDate;

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate()
    {
        int maxNumber = 0;
        Timetable lastTimetable = null;
        for (Timetable timetable: timetables){
            if (timetable.getNumberInRoute()>maxNumber) {
                maxNumber = timetable.getNumberInRoute();
                lastTimetable = timetable;
            }
        }
        Date date = lastTimetable.getDateArrival();
        this.finishDate = date;
    }
*/

    public Set<Timetable> getTimetables() {
        return this.timetables;
    }


    public void setTimetables(Set<Timetable> timetables) {
        this.timetables = timetables;
    }

    @Override
    public String toString() {
        return "Route{" +
                "idRoute=" + idRoute +
                ", routeName='" + routeName + '\'' +
                ", startStation=" + startStation +
//                ", finishStation=" + finishStation +
                ", train=" + train +
                ", startDate=" + startDate +
//                ", timetables=" + timetables +
                '}';
    }

    public int getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute = idRoute;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Station getStartStation() {
        return startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public Station getFinishStation() {
        return finishStation;
    }

    public void setFinishStation(Station finishStation) {
        this.finishStation = finishStation;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
