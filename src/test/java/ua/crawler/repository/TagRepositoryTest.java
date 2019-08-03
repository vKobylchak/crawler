package ua.crawler.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.crawler.entityHelper.TagHelper;
import ua.crawler.model.Tag;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TagRepositoryTest {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private LinkRepository linkRepository;

    @Test
    public void findByName(){
        Tag expectedTag = TagHelper.generateTag();

        linkRepository.saveAll(expectedTag.getLinks());
        tagRepository.save(expectedTag);

        Tag actualTag = tagRepository.findById(expectedTag.getId()).get();

        assertNotNull(actualTag);
        assertEquals(expectedTag, actualTag);
    }
}
