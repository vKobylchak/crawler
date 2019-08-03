package ua.crawler.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.crawler.entityHelper.LinkHelper;
import ua.crawler.model.Link;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LinkRepositoryTest {

    @Autowired
    private  LinkRepository linkRepository;

    @Test
    public void findAll() {
        List<Link> expectedLinks = List.of(LinkHelper.generateLink());
        linkRepository.saveAll(expectedLinks);

        List<Link> actualLinks = linkRepository.findAll();

        assertEquals(expectedLinks.size(), actualLinks.size());
    }

    @Test
    public void findByUrl() {
        Link expectedLink =  LinkHelper.generateLink();
        linkRepository.save(expectedLink);

        Link actualLink = linkRepository.findByUrl(expectedLink.getUrl());

        assertNotNull(actualLink);
        assertEquals(expectedLink, actualLink);
    }
}