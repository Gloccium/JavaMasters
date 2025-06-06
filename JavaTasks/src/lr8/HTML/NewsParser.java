package lr8.HTML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NewsParser {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://fat.urfu.ru/index.html").get();
            Elements newsParent = doc.select(
                    "body > table > tbody > tr > td > div > table > *" +
                            "tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > *" +
                            "tr > td:nth-child(1)"
            );

            try (FileWriter writer = new FileWriter("news_output.txt")) {
                for (int i = 1; i < 20; i++) {
                    if ((i % 2 == 0)) {
                        List<Node> nodes = newsParent.get(i).childNodes();
                        String title = ((Element) nodes.get(1))
                                .getElementsByClass("blocktitle")
                                .get(0)
                                .childNodes()
                                .get(0)
                                .toString();

                        String date = ((Element) nodes.get(1))
                                .getElementsByClass("blockdate")
                                .get(0)
                                .childNodes()
                                .get(0)
                                .toString();

                        System.out.println("Заголовок: " + title);
                        System.out.println("Дата: " + date + "\n");

                        writer.write("Заголовок: " + title + "\n");
                        writer.write("Дата: " + date + "\n\n");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при подключении к сайту или записи в файл.");
            handleConnectionError();
        }
    }

    private static void handleConnectionError() {
        int attempts = 3;
        for (int i = 1; i <= attempts; i++) {
            try {
                System.out.println("Попытка переподключения (" + i + "/" + attempts + ")...");
                Thread.sleep(2000); // Задержка перед повторной попыткой
                Document doc = Jsoup.connect("http://fat.urfu.ru/index.html").get();
                System.out.println("Подключение успешно восстановлено.");
                break;
            } catch (Exception ex) {
                System.out.println("Ошибка при попытке переподключения.");
                if (i == attempts) {
                    System.out.println("Не удалось восстановить подключение.");
                }
            }
        }
    }
}