package persistence.entities;

import javax.persistence.*;

/**
 * Created by abalaev onb 28.09.2016.
 */
@Entity
@Table(name = "Station", schema = "mydb")
//@NamedQueries({
//        @NamedQuery(name = "Station.findAll", query = "SELECT s FROM Station s" ),
//        @NamedQuery(name = "Station.deleteAll", query = "DELETE FROM Station")
//})
public class Station {
    @Id
    @Column(name = "idStation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStation;

    @Column(name = "stationName")
    private String stationName;

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
