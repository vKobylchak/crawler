package ua.crawler.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ua.crawler.entityHelper.TagHelper;
import ua.crawler.model.Tag;
import ua.crawler.repository.TagRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TagServiceTest {
    @Autowired
    private TagService tagService;
    @MockBean
    private TagRepository tagRepository;

    @Test
    public void addTagTest() {
        Tag tag = TagHelper.generateTag();

        Mockito.when(tagRepository.save(tag)).thenReturn(tag);

        assertThat(tagService.addTag(tag)).isEqualTo(tag);
    }

    @Test
    public void findByNameTest() {
        Tag tag = TagHelper.generateTag();

        Mockito.when(tagRepository.findByName(tag.getName())).thenReturn(tag);

        assertThat(tagService.findByName(tag.getName())).isEqualTo(tag);
    }

    @Test
    public void findByIdTest() {
        Tag tag = TagHelper.generateTag();

        Mockito.when(tagRepository.findById(tag.getId())).thenReturn(Optional.of(tag));

        assertThat(tagService.findById(tag.getId())).isEqualTo(tag);
    }
}