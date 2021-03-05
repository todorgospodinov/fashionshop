package softuni.fashionshop.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserEntity extends BaseEntity {
    private String username;
    private String password;
    private String email;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private List<Role> roles = new ArrayList<>();

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public UserEntity setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
        return this;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public UserEntity setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
        return this;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public UserEntity setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
        return this;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public UserEntity setEnabled(boolean enabled) {
        isEnabled = enabled;
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
}
