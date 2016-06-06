package ua.nure.nikolaienko.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ua.nure.nikolaienko.entity.TODO;

/**
 * Created by vlad on 02.06.16.
 */
@EnableJpaRepositories
@RepositoryRestResource(collectionResourceRel = "todos", path = "todos")
public interface TODORepository extends PagingAndSortingRepository<TODO, Long> {

}
