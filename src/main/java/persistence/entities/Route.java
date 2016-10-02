package persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * Created by abalaev on 28.09.2016.
 */
@Entity
@Table(name = "Route", schema = "mydb")
//@NamedQueries({
//        @NamedQuery(name = "Route.getAll",
//                   query = "SELECT route from Route"),
//        @NamedQuery(name = "Route.deleteAll",
//                    query = "DELETE FROM Route")
//})
public class Route {
    @Id
    @Column(name = "idRoute")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRoute;

    @Column(name = "route_name")
    @NotNull
    private String routeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "start_station", nullable = false)
    private Station startStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "finish_station", nullable = false)
    private Station finishStation;

    @OneToOne
    @JoinColumn(name = "train")
    private Train train;

    @Column(name = "start_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @ManyToMany(targetEntity = Timetable.class , cascade = { CascadeType.ALL })
    @JoinTable(name = "Route_Timetables",
            joinColumns = { @JoinColumn(name = "route_id") },
            inverseJoinColumns = { @JoinColumn(name = "timetable_id") })
    private Set<Timetable> timetables;


    @Override
    public String toString() {
        return "Route{" +
                "idRoute=" + idRoute +
                ", routeName='" + routeName + '\'' +
                ", startStation=" + startStation +
//                ", finishStation=" + finishStation +
                ", train=" + train +
                ", startDate=" + startDate +
                ", timetables=" + timetables +
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

//    public Station getFinishStation() {
//        return finishStation;
//    }

//    public void setFinishStation(Station finishStation) {
//        this.finishStation = finishStation;
//    }

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
