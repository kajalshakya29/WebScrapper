package com.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class IdpWebSrapper {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.idp.com/india/blog/study-mca-abroad/")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                    .header("Accept-Language", "*")
                    .get();

            // Extract title
            String title = doc.title();
            System.out.println("Title: " + title);

            // Extract meta description
            Element metaDesc = doc.selectFirst("meta[name=description]");
            String metaDescription = metaDesc.attr("content");
            System.out.println("Meta Description: " + metaDescription);

            // Extract headings
            Elements headings = doc.select("h1, h2, h3, h4, h5, h6");
            System.out.println("Headings:");
            for (Element heading : headings) {
                System.out.println(heading.text());
            }

            // Extract paragraphs
            Elements paragraphs = doc.select("p");
            System.out.println("Paragraphs:");
            for (Element paragraph : paragraphs) {
                System.out.println(paragraph.text());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}