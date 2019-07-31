package ua.crawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.crawler.model.Link;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Long> {
    List<Link> findAll();

    Link findByUrl(String url);
}
