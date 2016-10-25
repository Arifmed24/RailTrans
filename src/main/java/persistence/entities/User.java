package persistence.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User", schema = "mydb")
@NamedQueries(
        {
                @NamedQuery(name = "User.findByLogin",
                        query = "FROM User u WHERE login = :login"),
                @NamedQuery(name = "User.findAll",
                        query = "SELECT u FROM User u"),
                @NamedQuery(name = "User.login",
                        query = "SELECT u FROM User u WHERE u.login = :login AND u.password = :password")
        }
)
 public class User {
    @Id
    @Column(name = "idUser")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;


    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @Column(name = "fio")
    private String fio;


    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        ticket.setUser(this);
        tickets.add(ticket);
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    Set<Ticket> tickets = new HashSet<>();

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public User(String login, String password, String fio) {
        this.login = login;
        this.password = password;
        this.role = RoleEnum.USER;
        this.fio = fio;
    }

    public User() {    }

}
