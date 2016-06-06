package ua.nure.nikolaienko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.nikolaienko.CodeAnalyzer;
import ua.nure.nikolaienko.GitCloneException;
import ua.nure.nikolaienko.GitLoader;
import ua.nure.nikolaienko.dto.ProjectCredentialDTO;
import ua.nure.nikolaienko.entity.Project;
import ua.nure.nikolaienko.entity.TODO;
import ua.nure.nikolaienko.repository.ProjectRepository;
import ua.nure.nikolaienko.repository.TODORepository;

import java.io.File;
import java.util.List;

/**
 * Created by vlad on 05.06.16.
 */
@RestController
@RequestMapping(path = "/analyze/project")
public class ProjectController {

    @Autowired
    private GitLoader gitLoader;
    @Autowired
    private CodeAnalyzer codeAnalyzer;
    @Autowired
    private TODORepository todoRepository;
    @Autowired
    private ProjectRepository projectRepository;


    public String analyze(@RequestBody ProjectCredentialDTO projectCredentialDTO) {
        try {
            gitLoader.clone(projectCredentialDTO.getName(), projectCredentialDTO.getUsername(), projectCredentialDTO.getPassword());
        } catch (GitCloneException e) {
            return "error";
        }
        List<TODO> todos = codeAnalyzer.analize(new File(projectCredentialDTO.getName()));
        Project project = new Project();
        project.setUri(projectCredentialDTO.getName());
        project.setDescription(projectCredentialDTO.getDescription());
        project.setTitle(projectCredentialDTO.getTitle());
        project.setTodoList(todos);
        projectRepository.save(project);
//        todoRepository.save(todos);
        return "OK";
    }

}
