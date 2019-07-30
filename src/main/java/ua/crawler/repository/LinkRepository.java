package ua.crawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.crawler.model.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {

}
