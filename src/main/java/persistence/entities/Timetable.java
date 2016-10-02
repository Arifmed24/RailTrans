package persistence.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by abalaev on 28.09.2016.
 */
@Entity
@Table(name = "timetable")
//@NamedQueries({
//        @NamedQuery(name = "Timetable.findAll", query = "SELECT t FROM Timetable t`" ),
//        @NamedQuery(name = "Timetable.deleteAll", query = "DELETE FROM Timetable")
//})
public class Timetable {
    @Id
    @Column(name = "idLine")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idLine;

    @Column(name = "station_departure")
    private int stationDeparture;

    @Column(name = "station_arrival")
    private int stationArrival;

    @Column(name = "travelTime")
    @Temporal(TemporalType.TIME)
    private Date travelTime;

    @Column(name = "distance")
    private double distance;

    @Override
    public String toString() {
        return "Timetable{" +
                "idLine=" + idLine +
                ", stationDeparture=" + stationDeparture +
                ", stationArrival=" + stationArrival +
                ", travelTime=" + travelTime +
                ", distance=" + distance +
                '}';
    }

    public int getIdLine() {
        return idLine;
    }

    public void setIdLine(int idLine) {
        this.idLine = idLine;
    }

    public int getStationDeparture() {
        return stationDeparture;
    }

    public void setStationDeparture(int stationDeparture) {
        this.stationDeparture = stationDeparture;
    }

    public int getStationArrival() {
        return stationArrival;
    }

    public void setStationArrival(int stationArrival) {
        this.stationArrival = stationArrival;
    }

    public Date getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Date travelTime) {
        this.travelTime = travelTime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
