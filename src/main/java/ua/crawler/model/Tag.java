package ua.crawler.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @Getter
    private List<Link> links;

    public Tag() {
        this.links = new ArrayList<>();
    }

    public Tag(String name) {
        this.name = name;
        this.links = new ArrayList<>();
    }
}
