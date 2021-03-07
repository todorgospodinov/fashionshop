package softuni.fashionshop.model.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role extends BaseEntity {
    private RoleEnum roleEnum;

    public Role() {
    }
    @Enumerated(EnumType.STRING)
    public RoleEnum getRole() {
        return roleEnum;
    }

    public Role setRole(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
        return this;
    }
}