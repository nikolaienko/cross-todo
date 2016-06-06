package ua.nure.nikolaienko.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ua.nure.nikolaienko.entity.Project;

/**
 * Created by vlad on 02.06.16.
 */
@EnableJpaRepositories
@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
public interface ProjectRepository extends CrudRepository<Project, Long>{
}
