package ua.crawler.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Link> links;

    public Tag() {
        this.links = new ArrayList<>();
    }

    public Tag(String name) {
        this.name = name;
        this.links = new ArrayList<>();
    }
}
