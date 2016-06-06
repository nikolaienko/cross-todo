package ua.nure.nikolaienko.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * Created by vlad on 5/12/16.
 */
@Entity
@Data
public class Team implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany
    private List<TeamMember> members;
    private String title;
    @OneToMany
    private List<Project> projects;


}
