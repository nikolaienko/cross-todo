package ua.nure.nikolaienko.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.nure.nikolaienko.entity.Project;
import ua.nure.nikolaienko.entity.TODO;
import ua.nure.nikolaienko.entity.Team;
import ua.nure.nikolaienko.repository.ProjectRepository;
import ua.nure.nikolaienko.repository.TODORepository;
import ua.nure.nikolaienko.repository.TeamRepository;

/**
 * Created by vlad on 02.06.16.
 */
//@Component
public class ConverterBeans {

    @Autowired
    private TODORepository todoRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Bean
    public Converter<String, TODO> todoConverter() {
        return id -> todoRepository.findOne(Long.valueOf(id));
    }

    @Bean
    public Converter<String, Project> projectConverter() {
        return id -> projectRepository.findOne(Long.valueOf(id));
    }

    @Bean
    public Converter<String, Team> teamConverter() {
        return id -> teamRepository.findOne(Long.valueOf(id));
    }

}
