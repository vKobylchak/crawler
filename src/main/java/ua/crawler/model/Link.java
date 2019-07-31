package ua.crawler.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    private String url;

    @ManyToMany(mappedBy = "links", fetch = FetchType.EAGER)
    private List<Tag> tags;

    public Link() {
        this.tags = new ArrayList<>();
    }

    public Link(String url) {
        this.url = url;
        this.tags = new ArrayList<>();
    }
}
