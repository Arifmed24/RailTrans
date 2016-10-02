package persistence.entities;

import javax.persistence.*;

/**
 * Created by abalaev on 30.09.2016.
 */
@Entity
@Table(name = "Role")
//@NamedQueries({
//        @NamedQuery(name = "Role.getAll",
//                    query = "SELECT role from Role"),
//        @NamedQuery(name = "Role.deleteAll",
//                  query = "DELETE FROM Role")
//})
public class Role {
    @Id
    @Column(name = "idRole")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "abilities")
    private String abilities;

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", roleName='" + roleName + '\'' +
                ", abilities='" + abilities + '\'' +
                '}';
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }
}
