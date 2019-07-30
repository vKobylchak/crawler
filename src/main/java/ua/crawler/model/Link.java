package ua.crawler.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String URL;

    @ManyToMany
    private List<Tag> tags;

    public Link() {
        this.tags = new ArrayList<>();
    }

    public Link(String URL) {
        this.URL = URL;
        this.tags = new ArrayList<>();
    }
}
