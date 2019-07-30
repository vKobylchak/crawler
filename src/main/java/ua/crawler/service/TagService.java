package ua.crawler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.crawler.model.Tag;
import ua.crawler.repository.TagRepository;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Transactional
    public void addTag(Tag tag) {
        tagRepository.save(tag);
    }

    @Transactional
    public Tag findByName(String name) {
        return tagRepository.findByName(name);
    }


}
