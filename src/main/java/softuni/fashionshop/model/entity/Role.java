package softuni.fashionshop.model.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Role extends BaseEntity {
    private RoleEnum role;

    public Role() {
    }
    @Enumerated(EnumType.STRING)
    public RoleEnum getRole() {
        return role;
    }

    public Role setRole(RoleEnum role) {
        this.role = role;
        return this;
    }
}