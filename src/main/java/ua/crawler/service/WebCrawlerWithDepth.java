package ua.crawler.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class WebCrawlerWithDepth {

    private static final int MAX_DEPTH = 2;
    private HashSet<String> links;

    public WebCrawlerWithDepth() {
        links = new HashSet<String>();
    }

    public HashSet<String> getLinks() {
        return links;
    }

    public void getPageLinks(String URL, int depth) {
        if ((!links.contains(URL) && (depth < MAX_DEPTH))) {
            try {
                if (URL != "https://habr.com/en/all/")
                    links.add(URL);

                Document document = Jsoup.connect(URL).get();
                Elements linksOnPage = document.select(".post__title a[href]");

                depth++;
                for (Element page : linksOnPage) {
                    getPageLinks(page.attr("abs:href"), depth);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
