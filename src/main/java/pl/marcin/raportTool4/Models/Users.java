package pl.marcin.raportTool4.Models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {

    @Id
    private String username;

    private String password;

    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name ="userRoles_userRoleId",referencedColumnName = "user_role_id")
    private UserRoles userRoles;


    public Users() {
    }

    public Users(String username, String password, boolean enabled, UserRoles userRoles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", userRoles=" + userRoles.getRole() +
                '}';
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserRoles getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
    }


}
