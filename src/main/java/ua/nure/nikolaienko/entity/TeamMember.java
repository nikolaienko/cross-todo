package ua.nure.nikolaienko.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vlad on 02.06.16.
 */
@Entity
@Data
public class TeamMember implements Serializable {

    @OneToOne
    @Id
    private User user;
    @Enumerated(EnumType.STRING)
    private TeamRole teamRole;


}
