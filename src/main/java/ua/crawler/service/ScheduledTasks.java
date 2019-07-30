package ua.crawler.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ua.crawler.model.Link;
import ua.crawler.model.Tag;

import java.io.IOException;

@Service
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private LinkService linkService;

    @Autowired
    private TagService tagService;

    @Scheduled(fixedRate = 86400000)
    public void reportCurrentTime() {
        WebCrawlerWithDepth crawler = new WebCrawlerWithDepth();
        crawler.getPageLinks("https://habr.com/en/all/", 0);
        for (String url : crawler.getLinks()) {
            Link link1 = new Link(url);
            linkService.addLink(link1);
            try {
                Document document = Jsoup.connect(url).get();
                Elements tags = document.select("a.inline-list__item-link.hub-link");
                for (Element tagElement : tags) {
                    Tag tag = new Tag(tagElement.text());
                    tag.getLinks().add(link1);
                    tagService.addTag(tag);
                    linkService.addLink(link1);
                }
            } catch (IOException e) {
                logger.warn("For '" + url + "': " + e.getMessage());
            }
        }
        logger.info("success");
    }
}
