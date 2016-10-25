package persistence.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "passenger", schema = "mydb")
                @NamedQuery(name = "Passenger.getPassengers",
                        query = "SELECT p FROM Passenger p WHERE p.firstName =:first and p.lastName =:last and p.birth =:b")
public class Passenger extends Throwable {
    @Id
    @Column(name = "idPassenger", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPassenger;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    private Date birth;

    public int getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(int idPassenger) {
        this.idPassenger = idPassenger;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean equals(Object other){
        if (!(other instanceof Passenger)) {
            return false;
        }
        Passenger that = (Passenger) other;
        if (this.getFirstName().equals(that.getFirstName())&&this.getLastName().equals(that.getLastName())&&that.getBirth().equals(this.getBirth()))
            return true;
        else
            return false;
    }

    public String toString() {
        return "Passenger{" +
                "idPassenger=" + idPassenger +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birth=" + birth +
                '}';
    }
}
