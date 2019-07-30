package ua.crawler.repository;

import org.springframework.data.repository.CrudRepository;
import ua.crawler.model.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
     Tag findByName(String name);
}
