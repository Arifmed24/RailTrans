package persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by abalaev on 28.09.2016.
 */
@Entity
@Table(name = "passenger", schema = "mydb")
//@NamedQueries({
//        @NamedQuery(name = "Passenger.getAll",
//                    query = "SELECT passenger from Passenger"),
//        @NamedQuery(name = "Passenger.deleteAll",
//                    query = "DELETE FROM Passenger")
//})
public class Passenger {
    @Id
    @Column(name = "idPassenger")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPassenger;

    @Column(name = "firstName")
    @NotNull
    private String firstName;

    @Column(name = "lastName")
    @NotNull
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


    public String toString() {
        return "Passenger{" +
                "idPassenger=" + idPassenger +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birth=" + birth +
                '}';
    }
}
