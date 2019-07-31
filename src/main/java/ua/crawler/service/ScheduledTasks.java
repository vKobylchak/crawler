package ua.crawler.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ua.crawler.model.Link;
import ua.crawler.model.Tag;

import java.io.IOException;

@Service
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private final LinkService linkService;
    private final TagService tagService;
    private final WebCrawlerWithDepth crawler;

    public ScheduledTasks(LinkService linkService, TagService tagService, WebCrawlerWithDepth crawler) {
        this.linkService = linkService;
        this.tagService = tagService;
        this.crawler = crawler;
    }

    @Value("${crawler.URL}")
    private String URL;
    @Value("${crawler.depth}")
    private int depth;
    @Value("${crawler.cssQuery}")
    private String cssQuery;

    @Scheduled(fixedRate = 86400000)
    public void reportCurrentTime() {
        crawler.getPageLinks(URL, depth);
        for (String url : crawler.getLinks()) {
            Link link = new Link(url);
            linkService.addLink(link);
            try {
                Document document = Jsoup.connect(url).get();
                Elements tags = document.select(cssQuery);
                for (Element tagElement : tags) {
                    Tag tag = createTag(tagElement.text());
                    tag.getLinks().add(link);
                    tagService.addTag(tag);
                    linkService.addLink(link);
                }
            } catch (IOException e) {
                logger.warn("For '" + url + "': " + e.getMessage());
            }
        }
        logger.info("create database");
    }

    private Tag createTag(String tagName) {
        Tag tag = tagService.findByName(tagName);
        if (tag == null) return new Tag(tagName);
        else return tag;
    }
}
