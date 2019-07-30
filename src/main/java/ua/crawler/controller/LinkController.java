package ua.crawler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.crawler.model.Link;
import ua.crawler.service.LinkService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/link")
public class LinkController {
    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping(path = "/all")
    public Set<String> getAllURLs() {
        Iterable<Link> links = linkService.findAll();
        return linkService.getURLs(links);
    }

    @GetMapping()
    public Set<String> getLinksByTagId(@RequestParam Long id) {
        List<Link> links = linkService.getLinksByTagId(id);
        return linkService.getURLs(links);
    }
}
