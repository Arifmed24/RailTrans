package persistence.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by abalaev onb 28.09.2016.
 */
@Entity
@Table(name = "Station", schema = "mydb")
@NamedQueries(
        {
                @NamedQuery(name = "Station.findStationByName", query = "SELECT s FROM Station s WHERE s.stationName = :stationName"),
                @NamedQuery(name = "Station.getAll", query = "SELECT s FROM Station s")
        }
)
public class Station {
    @Id
    @Column(name = "idStation", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStation;

    @Column(name = "stationName", nullable = false)
    private String stationName;

    @OneToMany(mappedBy = "stationDeparture",fetch = FetchType.LAZY)
    private List<Timetable> timetablesDep;

    @OneToMany(mappedBy = "stationArrival",fetch = FetchType.LAZY)
    private List<Timetable> timetablesArr;


    public List<Timetable> getTimetablesDep() {
        return timetablesDep;
    }

    public void setTimetablesDep(List<Timetable> timetablesDep) {
        this.timetablesDep = timetablesDep;
    }

    public List<Timetable> getTimetablesArr() {
        return timetablesArr;
    }

    public void setTimetablesArr(List<Timetable> timetablesArr) {
        this.timetablesArr = timetablesArr;
    }

    public int getIdStation() {
        return idStation;
    }

    public void setIdStation(int idStation) {
        this.idStation = idStation;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String toString() {
        return "Station{" +
                "idStation=" + idStation +
                ", stationName='" + stationName + '\'' +
                '}';
    }
}
