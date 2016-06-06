package ua.nure.nikolaienko.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by vlad on 05.06.16.
 */
@Data
public class ProjectCredentialDTO {

    private String name;
    private String title;
    private String description;
    private String username;
    private String password;

}
