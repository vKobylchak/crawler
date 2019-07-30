package ua.crawler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.crawler.model.Link;
import ua.crawler.repository.LinkRepository;
import ua.crawler.repository.TagRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LinkService {
    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private TagRepository tagRepository;

    @Transactional
    public void addLink(Link link) {
        linkRepository.save(link);
    }

    @Transactional
    public Iterable<Link> findAll() {
        return linkRepository.findAll();
    }

    @Transactional
    public List<Link> getLinksByTagId(Long id) {
        return tagRepository.findById(id).get().getLinks();
    }

    @Transactional
    public Set<String> getURLs(Iterable<Link> links) {
        Set<String> urls = new HashSet<>();
        for (Link link : links) {
            urls.add(link.getURL());
        }
        return urls;
    }
}
