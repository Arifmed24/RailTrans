package persistence.entities;

import javax.persistence.*;

/**
 * Created by abalaev on 28.09.2016.
 */
@Entity
@Table(name = "train", schema = "mydb")
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
