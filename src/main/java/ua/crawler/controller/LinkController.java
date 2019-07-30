package ua.crawler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.crawler.model.Link;
import ua.crawler.service.LinkService;

import java.util.List;

@RestController
@RequestMapping(path = "/link")
public class LinkController {
    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/all")
    public List<Link> getAllLinks() {
        return linkService.findAll();
    }

    @GetMapping()
    public List<Link> getLinksByTagId(@RequestParam Long id) {
        return linkService.getLinksByTagId(id);
    }
}
