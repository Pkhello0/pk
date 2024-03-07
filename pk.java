import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) {
        String url = "https://time.com/";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements books = doc.select(".latest-stories__item");

            for (Element book : books) {
                Element linkElement = book.select("a").first();
                String link = linkElement.attr("href");

                Element titleElement = book.select("a > h3").first();
                String title = titleElement.text();

                System.out.println("Title: " + title);
                System.out.println("Link: " + link);
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}