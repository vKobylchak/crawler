package ua.crawler.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ua.crawler.entityHelper.LinkHelper;
import ua.crawler.model.Link;
import ua.crawler.repository.LinkRepository;
import ua.crawler.repository.TagRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LinkServiceTest {

    @Autowired
    private LinkService linkService;

    @MockBean
    private LinkRepository linkRepository;

    @MockBean
    private TagRepository tagRepository;

    @Test
    public void addLinkTest(){
        Link link = LinkHelper.generateLink();

        Mockito.when(linkRepository.save(link)).thenReturn(link);

        assertThat(linkService.addLink(link)).isEqualTo(link);
    }

    @Test
    public void findAllTest(){
        List<Link> links = List.of(LinkHelper.generateLink());

        Mockito.when(linkRepository.findAll()).thenReturn(links);

        assertThat(linkService.findAll()).isEqualTo(links);
    }

    @Test
    public void findByUrlTest(){
        Link link = LinkHelper.generateLink();

        Mockito.when(linkRepository.findByUrl(link.getUrl())).thenReturn(link);

        assertThat(linkService.findByURL(link.getUrl())).isEqualTo(link);
    }

}