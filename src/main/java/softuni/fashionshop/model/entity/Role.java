package softuni.fashionshop.model.entity;

import softuni.fashionshop.model.entity.enums.RoleEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "roles")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleEnum == role.roleEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleEnum);
    }
}