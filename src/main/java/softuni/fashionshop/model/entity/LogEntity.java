package softuni.fashionshop.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
public class LogEntity extends BaseEntity{


    private UserEntity userEntity;

    private Item item;

    private String action;

    private LocalDateTime dateTime;

    public LogEntity() {
    }
    @ManyToOne
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public LogEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    public Item getItem() {
        return item;
    }

    public LogEntity setItem(Item item) {
        this.item = item;
        return this;
    }

    @Column(name = "action", nullable = false)
    public String getAction() {
        return action;
    }

    public LogEntity setAction(String action) {
        this.action = action;
        return this;
    }
    @Column(name = "date_time", nullable = false)
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public LogEntity setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}
