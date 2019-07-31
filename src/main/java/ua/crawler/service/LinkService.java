package ua.crawler.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.crawler.model.Link;
import ua.crawler.repository.LinkRepository;
import ua.crawler.repository.TagRepository;

import java.util.List;

@Service
public class LinkService {
    private final LinkRepository linkRepository;
    private final TagRepository tagRepository;

    public LinkService(LinkRepository linkRepository, TagRepository tagRepository) {
        this.linkRepository = linkRepository;
        this.tagRepository = tagRepository;
    }

    @Transactional
    public void addLink(Link link) {
        linkRepository.save(link);
    }

    @Transactional
    public List<Link> findAll() {
        return linkRepository.findAll();
    }

    @Transactional
    public List<Link> getLinksByTagId(Long id) {
        return tagRepository.findById(id).get().getLinks();
    }

    @Transactional
    public Link findByURL(String url){
        return linkRepository.findByUrl(url);
    }
}
