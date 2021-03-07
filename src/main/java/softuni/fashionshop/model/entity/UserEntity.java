package softuni.fashionshop.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class UserEntity extends BaseEntity {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private List<Role> roles = new ArrayList<>();

    public UserEntity() {
    }
    @Column(name="username")
    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }
    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }
@Column(name="full_name")
    public String getFullName() {
        return fullName;
    }

    public UserEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    @ManyToMany(fetch= FetchType.EAGER)
    public List<Role> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public UserEntity addRole(Role role) {
        this.roles.add(role);
        return this;
    }
}
