package ua.nure.nikolaienko.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vlad on 5/12/16.
 */
@Entity
@Data
public class TODO implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String fileName;
    private String methodName;
    private String title;
    private int lineNumber;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private boolean isArchive;
    @ManyToOne
    private Project project;
    @OneToOne
    private User assigned;
}
